package com.liuy.service.http;


import com.liuy.consist.HttpType;
import com.liuy.dao.entry.IpProxy;
import com.liuy.service.proxy.ExtraProxyService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
@Component
public class ProxyFetchHttp implements MyHttpService{
    @Autowired
    ExtraProxyService proxyService;

    @Override
    public HttpType UUID() {
        return HttpType.PROXY_FETCH;
    }

    @Override
    public ResponseBody MulHttpService(OkHttpClient.Builder clientBuilder, String... input) {
        IpProxy ipProxy=proxyService.getMyProxy();
        Proxy proxy=new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipProxy.getIp(), ipProxy.getPort()));
        clientBuilder.proxy(proxy);
        clientBuilder.connectTimeout(500, TimeUnit.MILLISECONDS);
        clientBuilder.readTimeout(1000,TimeUnit.MILLISECONDS);
        OkHttpClient client=clientBuilder.build();
        Request request = new Request.Builder()
                .url("http://api.bilibili.com/x/web-interface/card?mid="+input+"&photo=true")
                .method("GET", null)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36")
                .addHeader("Cookie", "mid=xxx; bfe_id=1bad38f44e358ca77469025e0405c4a6")
                .build();
        try {
//            System.out.println(ipProxy);
            proxyService.deleteProxy(ipProxy.getIp());
            Response response = client.newCall(request).execute();
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
