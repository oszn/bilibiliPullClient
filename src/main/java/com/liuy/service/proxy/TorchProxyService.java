package com.liuy.service.proxy;


import com.liuy.dao.entry.IpProxy;
import org.springframework.stereotype.Service;

import java.lang.reflect.Proxy;

@Service
public class TorchProxyService implements ProxyService{

    @Override
    public Proxy getProxy() {
        return null;
    }

    @Override
    public IpProxy getMyProxy() {
        return null;
    }
}
