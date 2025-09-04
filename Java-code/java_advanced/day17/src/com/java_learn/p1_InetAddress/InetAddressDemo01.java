package com.java_learn.p1_InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 11:32
 */
public class InetAddressDemo01 {
    /*
        InetAddress : 此类表示 Internet协议（IP）地址

        static InetAddress getByName(String host) :     确定主机名称的IP地址（主机名称可以是机器名称，也可以是IP地址）
        String getHostName() :                          获取此IP地址的主机名
        String getHostAddress() :                       返回文本显示中的IP地址字符串
     */
    public static void main(String[] args) throws UnknownHostException {
        // 确定主机名称的IP地址
        InetAddress inetAddress = InetAddress.getByName("DESKTOP-RHBP3BP"); // DESKTOP-RHBP3BP
        System.out.println(inetAddress);
        // 获取此IP地址的[主机名]
        String hostName = inetAddress.getHostName();
        System.out.println(hostName); // 192.168.186.1
        // 返回文本显示中的[IP地址字符串]
        String ip = inetAddress.getHostAddress();
        System.out.println(ip); // 192.168.186.1
    }
}
