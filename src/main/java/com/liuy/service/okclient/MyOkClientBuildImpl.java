package com.liuy.service.okclient;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;

@Service
public class MyOkClientBuildImpl implements MyOkClinet{
    @Override
    public OkHttpClient.Builder getbuider() {
        return new OkHttpClient.Builder();
    }
}
