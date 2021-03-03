package com.liuy.componet.tools;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Auther: jlyin
 * @Date: 2018/11/14 10:25
 * @Description:
 */
public class IpUtil {

    private static final Pattern IPV4_PATTERN = Pattern.compile("^(([1-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){1}(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){2}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

    private static final String DATX_URL = "resources/17monipdb.datx";

    private static byte[] data;

    private static long indexSize;

    private static void getData() throws IOException {
        if (data != null){
            return;
        }
        Path path = Paths.get(DATX_URL);
        data = Files.readAllBytes(path);

        indexSize = bytesToLong(data[0], data[1], data[2], data[3]);
    }

    public static String[] find(String ips) throws IOException {


       getData();

        if (!isIPv4Address(ips)) {
            throw new RuntimeException("ip is error");
        }

        long val = ip2long(ips);
        int start = 262148;
        int low = 0;
        int mid = 0;
        int high = new Long((indexSize - 262144 - 262148) / 9).intValue() - 1;
        int pos = 0;
        while (low <= high) {
            mid = new Double((low + high) / 2).intValue();
            pos = mid * 9;

            long s = 0;
            if (mid > 0) {
                int pos1 = (mid - 1) * 9;
                s = bytesToLong(data[start + pos1], data[start + pos1 + 1], data[start + pos1 + 2], data[start + pos1 + 3]);
            }

            long end = bytesToLong(data[start + pos], data[start + pos + 1], data[start + pos + 2], data[start + pos + 3]);
            if (val > end) {
                low = mid + 1;
            } else if (val < s) {
                high = mid - 1;
            } else {

                byte b = 0;
                long off = bytesToLong(b, data[start + pos + 6], data[start + pos + 5], data[start + pos + 4]);
                long len = bytesToLong(b, b, data[start + pos + 7], data[start + pos + 8]);

                int offset = new Long(off - 262144 + indexSize).intValue();

                byte[] loc = Arrays.copyOfRange(data, offset, offset + new Long(len).intValue());

                return new String(loc, Charset.forName("UTF-8")).split("\t", -1);
            }
        }

        return null;
    }


    private static boolean isIPv4Address(String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    private static long bytesToLong(byte a, byte b, byte c, byte d) {
        return int2long((((a & 0xff) << 24) | ((b & 0xff) << 16) | ((c & 0xff) << 8) | (d & 0xff)));
    }

    private static int str2Ip(String ip) {
        String[] ss = ip.split("\\.");
        int a, b, c, d;
        a = Integer.parseInt(ss[0]);
        b = Integer.parseInt(ss[1]);
        c = Integer.parseInt(ss[2]);
        d = Integer.parseInt(ss[3]);
        return (a << 24) | (b << 16) | (c << 8) | d;
    }

    private static long ip2long(String ip) {
        return int2long(str2Ip(ip));
    }

    private static long int2long(int i) {
        long l = i & 0x7fffffffL;
        if (i < 0) {
            l |= 0x080000000L;
        }
        return l;
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress="";
        }
        // ipAddress = this.getRequest().getRemoteAddr();

        return ipAddress;
    }


    public static boolean ipExistsInRange(String ip,String beginIP,String endIP ) {

        ip = ip.trim();
        endIP=endIP.trim();
        beginIP=beginIP.trim();

        return getIp2long(beginIP)<=getIp2long(ip) &&getIp2long(ip)<=getIp2long(endIP);

    }

    public static long getIp2long(String ip) {

        ip = ip.trim();

        String[] ips = ip.split("\\.");

        long ip2long = 0L;

        for (int i = 0; i < 4; ++i) {

            ip2long = ip2long << 8 | Integer.parseInt(ips[i]);

        }

        return ip2long;

    }

    public static long getIp2long2(String ip) {

        ip = ip.trim();

        String[] ips = ip.split("\\.");

        long ip1 = Integer.parseInt(ips[0]);

        long ip2 = Integer.parseInt(ips[1]);

        long ip3 = Integer.parseInt(ips[2]);

        long ip4 = Integer.parseInt(ips[3]);



        long ip2long =1L* ip1 * 256 * 256 * 256 + ip2 * 256 * 256 + ip3 * 256 + ip4;

        return ip2long;

    }

    public static void main(String[] args) {
        try {
            long t1 = System.currentTimeMillis();
            System.out.println(Arrays.toString(find("195.75.193.255")));
            String[] locaton = find("202.96.209.6");
            long t2 = System.currentTimeMillis();
            System.out.println(t2 - t1);
            System.out.println(Arrays.toString(find("202.96.209.6")));
            long t3 = System.currentTimeMillis();
            System.out.println(t3 - t2);
            System.out.println(Arrays.toString(find("58.49.115.114")));
            long t4 = System.currentTimeMillis();
            System.out.println(t4 - t3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
