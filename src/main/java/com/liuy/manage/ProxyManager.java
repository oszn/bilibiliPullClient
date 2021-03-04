package com.liuy.manage;

import com.liuy.dao.entry.Goodproxy;
import com.liuy.dao.mapper.GoodproxyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProxyManager {
    @Autowired
    GoodproxyMapper proxyMapper;

    public int insertGoodProxy(Goodproxy goodproxy){
        return proxyMapper.insertSelective(goodproxy);
    };

    public int getProxyCount(){
//        return proxyMapper.selectCount();
    return 0;
    }
    public int deleteIp(String ip){
        return proxyMapper.deleteByPrimaryKey(ip);
    }
    public List<Goodproxy> getGoodProxyList(){
        return proxyMapper.selectAll();
//        return new ArrayList<Goodproxy>() ;
    }

}
