package com.myLogger.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myLogger.MyLoggerApplication;
import com.myLogger.dao.entry.Bilibili;
import com.myLogger.dao.mapper.BilibiliMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class walkMilk {
    @Autowired
    BilibiliMapper bilibiliMapper;
    private static  int a=0;
    public ResponseBody doFetch(String uid){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://api.bilibili.com/x/web-interface/card?mid="+uid+"&photo=true")
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
//    public ResponseBody doFetch2(String uid){
//        Ipproxy myProxyIp=new Ipproxy();
//        myProxyIp.setAddress("165.22.108.115");
//        myProxyIp.setPort("8080");
//        System.setProperty("http.maxRedirects", "50");
//        System.getProperties().setProperty("proxySet", "true");
//
//        // 设置代理服务器IP地址
//        System.getProperties().setProperty("http.proxyHost",
//                myProxyIp.getAddress());
//
//        // 设置代理服务器IP端口
//        System.getProperties().setProperty("http.proxyPort",
//                myProxyIp.getPort());
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url("http://api.bilibili.com/x/web-interface/card?mid="+uid+"&photo=true")
//                .method("GET", null)
//                .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                .addHeader("Cookie", "mid=xxx; bfe_id=1bad38f44e358ca77469025e0405c4a6")
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            return response.body();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public JSONObject get(JSONObject x, String ...key){
        JSONObject j=x;
        for(int i=0;i<key.length;i++){
            j=j.getJSONObject(key[i]);
        }
        return j;
    }
    public void insert(String uid){
        String ans=new String();
        try {
            ans=doFetch(uid).string();
        } catch (IOException e) {
            a++;
//            if(a>=100)
//            {
//                try {
//                    Thread.sleep (60*60*1000);
//                    a=0;
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace ();
//                }
//            }
            e.printStackTrace();
        }
        JSONObject j=JSONObject.parseObject(ans);
        Bilibili bilibili = new Bilibili();
        JSONObject data=get(j,"data");
        JSONObject card=get(j,"data","card");

        bilibili.setArticle(card.getString("article"));
        bilibili.setSex(card.getString("sex"));
        bilibili.setAttention(card.getString("attention"));
        bilibili.setMid(card.getLong("mid"));
        bilibili.setDescription(card.getString("description"));
        bilibili.setFans(card.getLong("fans"));
        bilibili.setName(card.getString("name"));
        bilibili.setFace(card.getString("face"));
        bilibili.setFriend(card.getString("friend"));
        bilibili.setRank(card.getString("rank"));
        bilibili.setSign(card.getString("sign"));
        bilibili.setBirthday(card.getString("birthday"));
        JSONObject VIP=get(card,"vip");
        bilibili.setViptype(VIP.getInteger("vipType"));
        bilibili.setVipstatus(VIP.getInteger("vipStatus"));

        bilibili.setFollower((long)data.getInteger("follower"));
        bilibili.setArticleCount((long)data.getInteger("article_count"));
        bilibili.setArchiveCount((long)data.getInteger("archive_count"));
        System.out.println(j);

        bilibiliMapper.insert(bilibili);

    }
    public static void main(String[] args) {

    }
}
