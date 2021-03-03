package com.liuy.service.http;


import com.liuy.consist.HttpType;
import com.liuy.service.proxy.ExtraProxyService;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;


public class ProxyIndexHttp implements MyHttpService{
    @Value("${table.number}")
    String n;
    @Value("${liuyi.remoteip}")
    String remoteip;
    @Value("${liuyi.localip}")
    String localip;
    @Autowired
    ExtraProxyService proxyService;

    @Override
    public Integer UUID() {
        return HttpType.PROXY_INDEX.value();
    }

    /*
        input 1:limit
        input 2:uri
         */
    @Override
    public Object MulHttpService(OkHttpClient.Builder clientBuilder, String... input) {

        OkHttpClient client = clientBuilder
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("limit", String.valueOf(input[0]))
                .build();
        Request request = new Request.Builder()
                .url("http://"+localip+":61010/"+input[1])
                .method("POST", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return Integer.parseInt(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
