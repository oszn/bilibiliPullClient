package com.liuy.service;


import com.liuy.service.http.MyHttpService;
import com.liuy.service.okclient.MyOkClientBuildImpl;
import com.liuy.service.okclient.MyOkClinet;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class MyRequestFactory {
    MyOkClinet client;
    public MyRequestFactory(){
        client=new MyOkClientBuildImpl();
    }
    private Map<Integer, MyHttpService> cmap;
    public ResponseBody getNorMalFetch(String uid,String){

    }
}
