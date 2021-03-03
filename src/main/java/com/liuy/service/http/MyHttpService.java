package com.liuy.service.http;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;

public interface MyHttpService {
    public Integer UUID();
    public Object MulHttpService(OkHttpClient.Builder clientBuilder, String ...input);
}
