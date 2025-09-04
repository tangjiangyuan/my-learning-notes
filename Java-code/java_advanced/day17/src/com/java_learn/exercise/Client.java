package com.java_learn.exercise;

import java.io.*;
import java.net.Socket;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 20:03
 */
public class Client {
    /*
        练习 --- 上传文件
     */
    public static void main(String[] args) throws Exception {
        // 1. 创建 Socket对象
        Socket socket = new Socket("127.0.0.1", 9999);
        // 2. 获取网络数据流
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        // 3. 将网络流交给转换流，再将转换流交给缓冲字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        // 4. 创建File对象，关联到要上传的文件
        File file = new File("D:\\A.txt");
        // 5. 通过缓冲流写出文件的名字
        bw.write(file.getName());
        bw.newLine();
        bw.flush();
        // 6. 收到服务器端的回写，表示可以上传文件的字节
        String flag = br.readLine();
        if ("ok".equals(flag)) {
            // 7. 创建本地字节流读取文件，使用网络字节流写出
            FileInputStream fis = new FileInputStream(file);
            byte[] bys = new byte[1024];
            int len;
            while ((len = fis.read(bys)) != -1) {
                os.write(bys, 0, len);
            }
            fis.close();
            // 8. 上传完文件，需要给一个结束标记
            socket.shutdownOutput();
        }
        // 9. 接收回写消息
        String msg = br.readLine();
        System.out.println(msg);
        // 10. 释放资源
        socket.close();
    }
}
