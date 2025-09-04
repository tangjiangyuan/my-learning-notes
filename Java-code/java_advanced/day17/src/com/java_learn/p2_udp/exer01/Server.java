package com.java_learn.p2_udp.exer01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 15:07
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 1. 创建 DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(9999);
        System.out.println("--------聊天室开启--------");
        // 2. 死循环接收数据
        while (true) { // 有多个客户端，不需要关闭循环。
            // 3. 创建 DatagramPacket，准备包裹，用来接收
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            // 4. 接收数据
            socket.receive(packet);
            // 5. 拆包
            byte[] data = packet.getData();
            String msg = new String(data, 0, packet.getLength());
            String ip = packet.getAddress().getHostAddress();
            System.out.println("接收到" + ip + "发送来的数据:" + msg);
        }
    }
}
