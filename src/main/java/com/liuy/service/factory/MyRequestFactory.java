package com.liuy.service.factory;


import com.liuy.consist.HttpType;
import com.liuy.service.http.MyHttpService;
import com.liuy.service.okclient.MyOkClientBuildImpl;
import com.liuy.service.okclient.MyOkClinet;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
@Component
public class MyRequestFactory {
    MyOkClinet client;
    public MyRequestFactory(){
        client=new MyOkClientBuildImpl();
    }
    private  EnumMap<HttpType,MyHttpService> httpMap=new EnumMap<HttpType, MyHttpService>(HttpType.class);
    @Autowired
    public void init(List<MyHttpService> httpServiceList){
        httpServiceList.forEach(service->httpMap.put(service.UUID(),service));
    }
    public MyHttpService getHttpService(HttpType EnumType){
        return httpMap.get(EnumType);
    }
    public MyOkClinet getClient(){
        return client;
    }
}
