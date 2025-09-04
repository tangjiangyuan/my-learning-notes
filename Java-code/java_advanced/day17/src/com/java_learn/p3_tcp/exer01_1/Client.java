package com.java_learn.p3_tcp.exer01_1;

import java.io.*;
import java.net.Socket;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 18:34
 */
public class Client {
    /*
        上传文件
     */
    public static void main(String[] args) throws Exception {
        // 1. 创建 Socket对象
        Socket socket = new Socket("127.0.0.1", 9090);
        // 2. 获取网络流对象
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        // 3. 将网络流交给转换流，这样可以操作字符，但是转换流又是字符流的抽象子类，又可以交给字符缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

        // 4. 上传文件的名字，用字符流bw
        File file = new File("D:\\A.txt");
        bw.write(file.getName());
        bw.newLine();
        bw.flush();
        // 5. 读取服务器端的回写信息
        String flag = br.readLine();
        // 6. 确定回写信息，上传字节，使用字节流os
        if ("ok".equals(flag)) {
            // 7. 创建本地字节流，关联要上传的文件读取，网络字节流写出
            FileInputStream fis = new FileInputStream(file);
            // 8. 上传文件的字节
            byte[] bys = new byte[1024];
            int len;
            while ((len = fis.read(bys)) != -1) {
                os.write(bys, 0, len);
            }
            fis.close();
            // 重点 : 给服务器一个结束的标记
            socket.shutdownOutput(); // 相当与-1
        }
        // 9. 读取服务器端的返回消息
        String result = br.readLine();
        System.out.println(result);
        // 10. 释放资源
        socket.close();
    }
}
