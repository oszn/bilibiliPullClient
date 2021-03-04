package com.liuy.service.http;

import com.alibaba.fastjson.JSONObject;
import com.liuy.consist.HttpType;
import com.liuy.dao.entry.Goodproxy;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class UriFetchHttp implements MyHttpService{
    @Override
    public HttpType UUID() {
        return HttpType.URI_FETCH;
    }

    @Override
    public Goodproxy MulHttpService(OkHttpClient.Builder clientBuilder, String... input) {
        OkHttpClient client=clientBuilder.build();
        Goodproxy ipProxy=new Goodproxy();
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
        return ipProxy;
    }
}
