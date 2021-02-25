package com.myLogger.tools;

import okhttp3.*;

import java.io.IOException;

public class test implements Runnable{
    public int mul(){
//        System.out.println("?");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("limit","100")
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/getjob")
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
    public static void main(String[] args) {
//        Thread x=new Thread();
//        for(int i=0;i<100;i++){
//            test tmp=new test();
//            System.out.println(i);
//            tmp.run();
//        }
        test tmp=new test();
        tmp.mul();

    }

    @Override
    public void run() {
        mul();
    }
}
