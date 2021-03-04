package com.liuy.service.proxy;


import com.liuy.dao.entry.IpProxy;

import java.lang.reflect.Proxy;

public interface ProxyService {
    Proxy getProxy();
    IpProxy getMyProxy();
    void deleteProxy(String ip);
}
