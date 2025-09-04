package com.java_learn.p2_udp.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 14:59
 */
public class Receive {
    public static void main(String[] args) throws Exception {
        // 1. 创建 DatagramSocket 对象
        DatagramSocket socket = new DatagramSocket(9999);
        // 2. 创建 DatagramPacket 对象
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        // 3. 接收数据
        socket.receive(packet);
        // 4. 拆包裹
        byte[] data = packet.getData();
        String msg = new String(data, 0, packet.getLength());
        String ip = packet.getAddress().getHostAddress();
        System.out.println("接收到" + ip + "发送来的数据:" + msg);
        // 5. 释放资源
        socket.close();
    }
}
