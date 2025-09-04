package com.tjy.service.impl.client;

import com.tjy.pojo.Environment;
import com.tjy.service.inter.client.Client;
import com.tjy.util.WoosModuleInit;

import java.io.*;
import java.net.Socket;
import java.util.Collection;
import java.util.Properties;

/**
 * @version 1.0
 * @date 2025/8/27 18:54
 */
public class ClientImpl implements Client, WoosModuleInit {

    private static String ip;
    private static int port;

    @Override
    public void init(Properties prop) throws Exception {
        ip = prop.getProperty("ip");
        port = Integer.parseInt(prop.getProperty("port"));
    }

    @Override
    public void send(Collection<Environment> coll) throws IOException {

        System.out.println("采集模块: 采集数据完成,本次共采集:" + coll.size());
        System.out.println("元素数量:" + coll.size());

        Socket socket = new Socket(ip, port);
        System.out.println("客户端网络模块: 连接成功");

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        System.out.println("客户端网络模块: 准备发送数据");

        oos.writeObject(coll);
        oos.flush();

        System.out.println("客户端网络模块: 数据发送成功,共" + coll.size() + "条");

        // 释放资源
        oos.close();
        socket.close();
        System.out.println("客户端成功关闭!");
    }
}
