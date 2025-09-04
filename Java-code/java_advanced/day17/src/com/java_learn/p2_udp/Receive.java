package com.java_learn.p2_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 14:22
 */
public class Receive {
    /*
        接收端
     */
    public static void main(String[] args) throws Exception {
        // 1. 创建 DatagramSocket 对象
        DatagramSocket socket = new DatagramSocket(9999);
        // 2. 创建 DatagramPacket 对象
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        // 3. 接收数据 --- 此处会有阻塞现象：因为会等待接收端发送的数据
        System.out.println(1);
        socket.receive(packet);
        System.out.println(2);
        // 4. 拆包裹
        byte[] data = packet.getData();
        // String msg = new String(data); packet准备的字节数组长度太大，多余数据会出现乱码，进行改进
        String msg = new String(data, 0, packet.getLength());
        String ip = packet.getAddress().getHostAddress();
        System.out.println("接收到" + ip + "发送过来的消息为:" + msg);
        // 5. 释放资源
        socket.close();
    }
}
