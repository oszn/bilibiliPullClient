package com.liuy.service;

import com.liuy.consist.ErrorEnum;
import com.liuy.consist.HttpType;
import com.liuy.consist.UriConst;
import com.liuy.dao.entry.Bili;
import com.liuy.dao.entry.Bilibilistep;
import com.liuy.dao.entry.Goodproxy;
import com.liuy.dao.entry.IpProxy;
import com.liuy.dao.mapper.BiliMapper;
import com.liuy.dao.mapper.BilibilistepMapper;
import com.liuy.dao.mapper.ErrorlogMapper;
import com.liuy.dao.mapper.GoodproxyMapper;
import com.liuy.service.factory.MyRequestFactory;
import com.liuy.tools.json2map;
import okhttp3.ResponseBody;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class PullBuilder {
    public final Logger log= LoggerFactory.getLogger(this.getClass());
    @Autowired
    MyRequestFactory requestFactory;
    @Autowired
    BiliMapper bilibiliMapper;
    @Autowired
    BilibilistepMapper bilibilistepMapper;
    @Autowired
    GoodproxyMapper proxyMapper;
    @Autowired
    json2map j2m;

    @Value("${table.number}")
    String n;
    @Value("${liuyi.remoteip}")
    String remoteip;
    @Value("${liuyi.localip}")
    String localip;


    public String NormalFetch(String uid, String epoch){
        Bilibilistep c=bilibilistepMapper.selectByPrimaryKey(epoch);
        uid=selectUid(uid,epoch,c);
        String ans=new String();
        try {
            ResponseBody responseBody= (ResponseBody) doHttp(HttpType.NORMAL_FETCH,uid);
            ans=responseBody.string();
            log.info(ans);
        } catch (IOException e) {

            e.printStackTrace();

        }

        after(ans,c);
        return uid;
    }


    public Boolean ProxyFetch(String uid,String epoch){
        Bilibilistep c=bilibilistepMapper.selectByPrimaryKey(epoch);
        uid=selectUid(uid,epoch,c);
        String ans=new String();

        try {
            ResponseBody responseBody= (ResponseBody) doHttp(HttpType.PROXY_FETCH,uid);
            ans=responseBody.string();
            log.info(ans);
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return after(ans,c);
    }
    public void torchFetch(){
        Goodproxy goodproxy= (Goodproxy) doHttp(HttpType.URI_FETCH,"");
        doHttp(HttpType.TORCH_FETCH,goodproxy.getIp(), String.valueOf(goodproxy.getPort()));
    }
    public int NormalIndex(int limit){
        return (int) doHttp(HttpType.NORMAL_INDEX, String.valueOf(limit), UriConst.normal_uri);
    }
    public int ProxyIndex(int limit){
        return (int) doHttp(HttpType.PROXY_INDEX, String.valueOf(limit), UriConst.proxy_uri);
    }


    public Boolean after(String ans,Bilibilistep c){
        Bili bilibili = new Bili();
        bilibili.setMac(n);
        bilibili.setInsertDate(new Date(System.currentTimeMillis()));

        j2m.init(ans,bilibili);
        if(bilibili.getCode()!=0){
            return false;
        }
        bilibiliMapper.insertSelective(bilibili);
        c.setValue(c.getValue()+1);
        bilibilistepMapper.updateByPrimaryKey(c);
        return true;
    }


    public String selectUid(String uid,String epoch,Bilibilistep c)
    {

        if(uid=="null"){
            uid= String.valueOf(c.getValue());
        }
        return uid;
    }
    public Object doHttp(HttpType type,String ...input){
        return requestFactory.getHttpService(type).MulHttpService(requestFactory.getClient().getbuider(),input);
    }

}
