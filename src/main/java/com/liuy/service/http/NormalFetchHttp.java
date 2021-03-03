package com.liuy.service.http;

import com.liuy.consist.HttpType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

public class NormalFetchHttp implements MyHttpService{
    @Override
    public Integer UUID() {
        return HttpType.NORMAL_FETCH.value();
    }

    /*
        input 1:uid
         */

    @Override
    public ResponseBody MulHttpService(OkHttpClient.Builder clientBuilder, String... input) {
        OkHttpClient client=clientBuilder.build();
        Request request = new Request.Builder()
                .url("http://api.bilibili.com/x/web-interface/card?mid="+input[0]+"&photo=true")
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
}
