package com.liuy.service.proxy;


import com.liuy.dao.entry.Goodproxy;
import com.liuy.dao.entry.IpProxy;
import com.liuy.manage.ProxyManager;
import com.liuy.service.PullBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
    @PostConstruct
    public void init(){
        index=0;
        count=index;
        goodProxyList=proxyManager.getGoodProxyList();
        count=goodProxyList.size();
    }
    public ExtraProxyService(){

    }
    @Override
    public IpProxy getMyProxy() {
        index=++index%count;
        Goodproxy proxy= goodProxyList.get(index);
        IpProxy ipProxy=new IpProxy();
        BeanUtils.copyProperties(proxy,ipProxy);

        return ipProxy;
    }

    @Override
    public void deleteProxy(String ip) {
        proxyManager.deleteIp(ip);
        goodProxyList.remove(index);
        count--;
        index--;

    }
}
