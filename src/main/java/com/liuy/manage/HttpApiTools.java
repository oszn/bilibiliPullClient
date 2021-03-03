package com.liuy.manage;

import com.alibaba.fastjson.JSONObject;

import com.liuy.dao.entry.IpProxy;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
public class HttpApiTools {

    @Value("${table.number}")
    String n;
    @Value("${liuyi.remoteip}")
    String remoteip;
    @Value("${liuyi.localip}")
    String localip;


    public IpProxy getIpProxy(IpProxy ipProxy){
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
//           =new IpProxy();
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



    public int mul(int limit,String uri){
//        System.out.println("?");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("limit", String.valueOf(limit))
                .build();
        Request request = new Request.Builder()
                .url("http://"+localip+":61010/"+uri)
                .method("POST", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return Integer.parseInt(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
            //eLog("unknown", ErrorEnum.MUL_ERR.type(),e);
        }
        return -1;
    }
}
