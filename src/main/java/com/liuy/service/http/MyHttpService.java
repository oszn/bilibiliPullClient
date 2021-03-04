package com.liuy.service.http;

import com.liuy.consist.HttpType;
import okhttp3.OkHttpClient;

public interface MyHttpService {
    public HttpType UUID();
    public Object MulHttpService(OkHttpClient.Builder clientBuilder, String ...input);
}
