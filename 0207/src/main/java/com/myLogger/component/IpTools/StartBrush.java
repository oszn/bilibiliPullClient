package com.myLogger.component.IpTools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StartBrush {
    public static void main(String[] args) {
        // 1.向http代理地址API发起请求，获取想要的代理IP地址
        // API链接中的IP地址每15分钟更新一次，因此不建议频繁读取API，15分钟来读取一次即可
        String IP_URL = "https://www.aitemi6.com/ProxyIp20180227.txt";

        List<Ipproxy> myProxyIpList = GetIpUtil.getIp(IP_URL);

        String BLOG_URL = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入Blog文章地址：");
        BLOG_URL = scanner.nextLine();

        System.out.println("请输入轮番刷新的倍数(x100)：");
        int time = scanner.nextInt();

        int count = 0;

        for (int i = 0; i < time; i++) {
            // 2.设置IP代理
            for (final Ipproxy myProxyIp : myProxyIpList) {
                // API调用的时候，使用的GET请求
                // 假设已经获取到了API的100个代理IP，则需要开始设置代理
                System.setProperty("http.maxRedirects", "50");
                System.getProperties().setProperty("proxySet", "true");

                // 设置代理服务器IP地址
                System.getProperties().setProperty("http.proxyHost",
                        myProxyIp.getAddress());

                // 设置代理服务器IP端口
                System.getProperties().setProperty("http.proxyPort",
                        myProxyIp.getPort());

                try {

                    Document document = Jsoup.connect(BLOG_URL)
                            .userAgent("Mozilla").cookie("auth", "token")
                            .timeout(3000).get();

                    if (document != null) {
                        count++;
                        System.out.println("=========成功刷新次数：" + count
                                + "========");
                    }
                } catch (IOException e) {
                    System.out.println(myProxyIp.getAddress() + ":"
                            + myProxyIp.getPort() + "，出现错误  ----->>>>   " + e);
                }
            }
        }
    }
    }
