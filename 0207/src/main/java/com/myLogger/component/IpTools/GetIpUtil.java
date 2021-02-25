package com.myLogger.component.IpTools;

import com.myLogger.component.generateId;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetIpUtil {
    public static List<Ipproxy> getIp(String url){
        List<Ipproxy> myProxyIpList = null;

        try {

            // 1.向IP代理地址发起get请求，获取代理的IP
            Document document = Jsoup.connect(url).userAgent("Mozilla")
                    .cookie("auth", "token").timeout(3000).get();

            // 2.将得到的IP地址解析成字符串
            String ipStr = document.body().text().trim().toString();

            // 3.用正则表达式去切割所有的IP
            String[] ips = ipStr.split("\\s+");

            // 4.循环遍历得到的IPS，封装成MyProxyIp的bean
            myProxyIpList = new ArrayList<Ipproxy>();

            for (final String ip : ips) {
                Ipproxy myProxyIp = new Ipproxy();
                String[] temp = ip.split(":");
                myProxyIp.setAddress(temp[0].trim());
                myProxyIp.setPort(temp[1].trim());
                myProxyIp.setUid((int) generateId.fromtime(1));
                myProxyIpList.add(myProxyIp);
            }

        } catch (IOException e) {
            System.out.println("加载文件出错----->>>>  " + e);
        }

        return myProxyIpList;
    }
}
