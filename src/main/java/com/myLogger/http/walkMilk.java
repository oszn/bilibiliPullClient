package com.myLogger.http;

import com.alibaba.fastjson.JSONObject;
import com.myLogger.component.tools.json2map;
import com.myLogger.consist.ErrorEnum;
import com.myLogger.dao.entry.*;
import com.myLogger.dao.mapper.BiliMapper;
import com.myLogger.dao.mapper.BilibiliMapper;
import com.myLogger.dao.mapper.BilibilistepMapper;
import com.myLogger.dao.mapper.ErrorlogMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
//import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.PublicKey;
import java.util.Date;

@Service
public class walkMilk {
    @Autowired
    BiliMapper bilibiliMapper;
    @Autowired
    BilibilistepMapper bilibilistepMapper;
    @Autowired
    ErrorlogMapper errorlogMapper;
    @Autowired
    json2map j2m;
    @Value("${table.number}")
    String n;
    @Value("${liuyi.remoteip}")
    String remoteip;
    @Value("${liuyi.localip}")
    String localip;

    public final Logger logger= LoggerFactory.getLogger(this.getClass());
    public ResponseBody doFetch(String uid){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://api.bilibili.com/x/web-interface/card?mid="+uid+"&photo=true")
                .method("GET", null)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", "mid=xxx; bfe_id=1bad38f44e358ca77469025e0405c4a6")
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResponseBody doFetchVersion2(String uid){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        IpProxy ipProxy=getIpProxy();
        Proxy proxy=new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipProxy.getIp(), ipProxy.getPort()));
        builder.proxy(proxy);
        OkHttpClient client=builder.build();
        Request request = new Request.Builder()
                .url("http://api.bilibili.com/x/web-interface/card?mid="+uid+"&photo=true")
                .method("GET", null)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36")
                .addHeader("Cookie", "mid=xxx; bfe_id=1bad38f44e358ca77469025e0405c4a6")
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    public void logfile(String key,String log){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("key",key)
                .addFormDataPart("log",log)
                .build();
        Request request = new Request.Builder()
                .url("http://"+remoteip+":13672/insertLog")
                .method("POST", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public IpProxy getIpProxy(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://42.193.170.22:4003/get/")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String body=response.body().string();
            JSONObject jsonObject=JSONObject.parseObject(body);
            IpProxy ipProxy=new IpProxy();
//            ipProxy.setIp(jsonObject.getString());
            String []ipandPort=jsonObject.getString("proxy").split(":");
            ipProxy.setIp(ipandPort[0]);
            ipProxy.setPort(Integer.parseInt(ipandPort[1]));
            return ipProxy;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public int mul(int limit){
//        System.out.println("?");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("limit", String.valueOf(limit))
                .build();
        Request request = new Request.Builder()
                .url("http://"+remoteip+":61010/getjob")
                .method("POST", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return Integer.parseInt(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
            eLog("unknown",ErrorEnum.MUL_ERR.type(),e);
        }
        return -1;
    }
    public JSONObject get(JSONObject x, String ...key){
        JSONObject j=x;
        for(int i=0;i<key.length;i++){
            j=j.getJSONObject(key[i]);
        }
        return j;
    }


    public void eLog(String uid,int type,Exception e){
        Errorlog errorlog=new Errorlog();
        errorlog.setMid(Long.parseLong(uid));
        errorlog.setErrorinfo(e.getMessage());
        errorlog.setType(type);
        errorlogMapper.insert(errorlog);
    }
    public String selectUid(String uid,String epoch,Bilibilistep c){

        if(uid=="null"){

            uid= String.valueOf(c.getValue());
        }
        return uid;
    }

    public String pushServer(String ans,String uid,Bilibilistep c){

        Bili bilibili = new Bili();
        bilibili.setMac(n);
        bilibili.setInsertDate(new Date(System.currentTimeMillis()));

        j2m.init(ans,bilibili);

        bilibiliMapper.insertSelective(bilibili);
        c.setValue(c.getValue()+1);
        bilibilistepMapper.updateByPrimaryKey(c);
        return uid;
    }
    public String pushVersion2(String uid,String epoch){
        Bilibilistep c=bilibilistepMapper.selectByPrimaryKey(epoch);
        uid=selectUid(uid,epoch,c);
        String ans=new String();
        try {
            ans=doFetchVersion2(uid).string();

        } catch (IOException e) {
            eLog(uid,ErrorEnum.FETCH_ERR.type(),e);
            e.printStackTrace();
        }
        Bili bilibili = new Bili();
        bilibili.setMac(n);
        bilibili.setInsertDate(new Date(System.currentTimeMillis()));

        j2m.init(ans,bilibili);

        bilibiliMapper.insertSelective(bilibili);
        c.setValue(c.getValue()+1);
        bilibilistepMapper.updateByPrimaryKey(c);

        return uid;
    }
    public String insert(String uid,String epoch){
        Bilibilistep c=bilibilistepMapper.selectByPrimaryKey(epoch);
        if(uid=="null"){

            uid= String.valueOf(c.getValue());
        }

        String ans=new String();
        try {
            ans=doFetch(uid).string();

        } catch (IOException e) {
            eLog(uid,ErrorEnum.FETCH_ERR.type(),e);
            e.printStackTrace();
        }

        Bili bilibili = new Bili();
        bilibili.setMac(n);
        bilibili.setInsertDate(new Date(System.currentTimeMillis()));

        j2m.init(ans,bilibili);

        bilibiliMapper.insertSelective(bilibili);
        c.setValue(c.getValue()+1);
        bilibilistepMapper.updateByPrimaryKey(c);

        return uid;
    }
    public void tf2(){
        walkMilk w=new walkMilk();
        int k=1;
        while (true){
            try {
                String ans=w.doFetchVersion2(String.valueOf(k)).string();
                System.out.println(ans);
                Thread.sleep(100);
            } catch (Exception e ) {
                e.printStackTrace();
            }
            k+=1;

        }
    }
    public static void main(String[] args) {
        walkMilk w=new walkMilk();
        w.tf2();
    }
}
