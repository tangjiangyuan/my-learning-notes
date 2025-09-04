package com.java_learn.p2_udp.exer01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 15:07
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 1. 创建 DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();// 随机值，可以开启多个客户端
        // 2. 键盘录入
        Scanner sc = new Scanner(System.in);
        // 死循环，不结束聊天
        while (true) {
            System.out.println("请输入:");
            String msg = sc.nextLine();
            // 3. 创建 DatagramPacket对象，对信息进行打包
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
                    InetAddress.getByName("127.0.0.1"), 9999);
            // 4. 发送信息
            socket.send(packet);
            // 5. 如果输入信息为指定值，结束循环
            if (msg.equals("886")) {
                break;
            }
        }
        // 6. 释放资源
        socket.close();
    }
}
