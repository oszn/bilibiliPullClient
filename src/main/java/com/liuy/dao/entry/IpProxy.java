package com.liuy.dao.entry;

public class IpProxy {
    @Override
    public String toString() {
        return "IpProxy{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private String ip;
    private int port;
}
