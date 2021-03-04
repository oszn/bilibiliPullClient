package com.liuy.service.http;

import com.liuy.consist.HttpType;
import com.liuy.dao.entry.Bili;
import com.liuy.dao.entry.Goodproxy;
import com.liuy.dao.entry.IpProxy;
import com.liuy.dao.mapper.GoodproxyMapper;
import com.liuy.service.proxy.ExtraProxyService;
import com.liuy.tools.json2map;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Date;
import java.util.concurrent.TimeUnit;
@Service
public class TorchFetchHttp implements MyHttpService{
    public final Logger log= LoggerFactory.getLogger(this.getClass());

    @Override
    public HttpType UUID() {
        return HttpType.TORCH_FETCH;
    }
    @Value("${table.number}")
    String n;
    @Value("${liuyi.remoteip}")
    String remoteip;
    @Value("${liuyi.localip}")
    String localip;
    @Autowired
    ExtraProxyService proxyService;
    @Autowired
    GoodproxyMapper proxyMapper;
    @Autowired
    json2map j2m;
    /*
        input 1:limit
        input 2:uri
         */
    @Override
    public Object MulHttpService(OkHttpClient.Builder clientBuilder, String... input) {
        Goodproxy ipProxy=new Goodproxy();
        ipProxy.setIp(input[0]);
        ipProxy.setPort(Integer.parseInt(input[1]));
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipProxy.getIp(), ipProxy.getPort()));
        if(proxyMapper.selectByPrimaryKey(ipProxy.getIp())!=null){
            log.info("e!!!!!!!!!!!!!!!");
            return null;
        }
        clientBuilder.proxy(proxy);
        clientBuilder.connectTimeout(500, TimeUnit.MILLISECONDS);
        clientBuilder.readTimeout(1000, TimeUnit.MILLISECONDS);
        OkHttpClient client = clientBuilder.build();
        Request request = new Request.Builder()
                .url("http://api.bilibili.com/x/web-interface/card?mid=" + 1 + "&photo=true")
                .method("GET", null)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36")
                .addHeader("Cookie", "mid=xxx; bfe_id=1bad38f44e358ca77469025e0405c4a6")
                .build();
        try {
            Response response = client.newCall(request).execute();
            Bili bilibili = new Bili();
            bilibili.setMac(n);
            bilibili.setInsertDate(new Date(System.currentTimeMillis()));
            String ans=response.body().string();
            j2m.init(ans,bilibili);
            if(bilibili.getCode()!=0){
                return false;
            }
            if(proxyMapper.selectByPrimaryKey(ipProxy.getIp())==null){
                proxyMapper.insertSelective(ipProxy);
            }else {
                log.info("exist!");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

}
