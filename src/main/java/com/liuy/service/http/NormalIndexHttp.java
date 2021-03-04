package com.liuy.service.http;


import com.liuy.consist.HttpType;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class NormalIndexHttp implements MyHttpService{
    @Value("${table.number}")
    String n;
    @Value("${liuyi.remoteip}")
    String remoteip;
    @Value("${liuyi.localip}")
    String localip;

    @Override
    public HttpType UUID() {
        return HttpType.NORMAL_INDEX;
    }

    /*

        input 1:limit
        input 2:uri

         */
    @Override
    public Integer MulHttpService(OkHttpClient.Builder clientBuilder, String... input) {
        OkHttpClient client = clientBuilder
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("limit", String.valueOf(input[0]))
                .build();
        Request request = new Request.Builder()
                .url("http://"+remoteip+":61010/"+input[1])
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
