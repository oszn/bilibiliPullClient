package com.myLogger.http;

import com.alibaba.fastjson.JSONObject;
import com.myLogger.consist.ErrorEnum;
import com.myLogger.dao.entry.Bilibili;
import com.myLogger.dao.entry.Bilibilistep;
import com.myLogger.dao.entry.Errorlog;
import com.myLogger.dao.mapper.BilibiliMapper;
import com.myLogger.dao.mapper.BilibilistepMapper;
import com.myLogger.dao.mapper.ErrorlogMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class walkMilk {
    @Autowired
    BilibiliMapper bilibiliMapper;
    @Autowired
    BilibilistepMapper bilibilistepMapper;
    @Autowired
    ErrorlogMapper errorlogMapper;
    @Value("${table.number}")
    String n;
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
    public void logfile(String key,String log){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("key",key)
                .addFormDataPart("log",log)
                .build();
        Request request = new Request.Builder()
                .url("http://42.193.170.22:13672/insertLog")
                .method("POST", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public int mul(){
//        System.out.println("?");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("limit","100")
                .build();
        Request request = new Request.Builder()
                .url("http://42.193.170.22:61010/getjob")
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
        JSONObject j=JSONObject.parseObject(ans);
        Bilibili bilibili = new Bilibili();
        JSONObject data=get(j,"data");
        JSONObject card=get(j,"data","card");

        bilibili.setArticle(card.getString("article"));
        bilibili.setSex(card.getString("sex"));
        bilibili.setAttention(card.getString("attention"));
        bilibili.setMid(card.getLong("mid"));
        bilibili.setDescription(card.getString("description"));
        bilibili.setFans(card.getLong("fans"));
        bilibili.setName(card.getString("name"));
        bilibili.setFace(card.getString("face"));
        bilibili.setFriend(card.getString("friend"));
        bilibili.setRank(card.getString("rank"));
        bilibili.setSign(card.getString("sign"));
        bilibili.setBirthday(card.getString("birthday"));
        JSONObject VIP=get(card,"vip");
        bilibili.setViptype(VIP.getInteger("vipType"));
        bilibili.setVipstatus(VIP.getInteger("vipStatus"));

        bilibili.setFollower((long)data.getInteger("follower"));
        bilibili.setArticleCount((long)data.getInteger("article_count"));
        bilibili.setArchiveCount((long)data.getInteger("archive_count"));
        System.out.println(j);

        bilibili.setMac(n);

        bilibiliMapper.insert(bilibili);
        c.setValue(c.getValue()+1);
        bilibilistepMapper.updateByPrimaryKey(c);


        String keym= String.valueOf(bilibili.getMid())+"_"+n;
        try {
            logfile(keym,ans);
        }catch (Exception  e){
            e.printStackTrace();
        }

        return uid;
    }
    public static void main(String[] args) {

    }
}
