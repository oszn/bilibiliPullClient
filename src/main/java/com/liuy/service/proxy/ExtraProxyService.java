package com.liuy.service.proxy;


import com.liuy.dao.entry.Goodproxy;
import com.liuy.dao.entry.IpProxy;
import com.liuy.manage.ProxyManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Proxy;
import java.util.List;

@Service
public class ExtraProxyService implements ProxyService{
    @Autowired
    ProxyManager proxyManager;
    @Override
    public Proxy getProxy() {
        return null;
    }
    private List<Goodproxy> goodProxyList;
    private int index;
    private int count;

    public ExtraProxyService(){
        index=0;
        count=index;
//        goodProxyList=proxyManager.getGoodProxyList();
//        count=goodProxyList.size();
    }
    @Override
    public IpProxy getMyProxy() {
        Goodproxy proxy= goodProxyList.get(index);
        IpProxy ipProxy=new IpProxy();
        BeanUtils.copyProperties(proxy,ipProxy);
        index=++index%count;
        return ipProxy;
    }
}
