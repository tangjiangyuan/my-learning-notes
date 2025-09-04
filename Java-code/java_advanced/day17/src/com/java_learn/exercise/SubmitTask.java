package com.java_learn.exercise;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 22:33
 */
public class SubmitTask implements Runnable {
    private Socket socket;
    public SubmitTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 3. 获取网络数据流
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            // 4. 将网络流交给转换流，再将转换流交给缓冲字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            // 5. 使用缓冲流读取上传的文件名字
            String fileName = br.readLine();
            // 6. 回写确认消息
            bw.write("ok");
            bw.newLine();
            bw.flush();
            // 7. 创建服务器端的存储位置
            File file = new File("D:\\update", UUID.randomUUID().toString() + fileName);
            // 8. 使用网络字节流读取上传的文件的字节，通过本地字节流写出到服务器端的存储位置
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bys = new byte[1024];
            int len;
            while ((len = is.read(bys)) != -1) {
                fos.write(bys, 0, len);
            }
            fos.close();
            // 9. 回写确认信息
            bw.write("上传成功!");
            bw.newLine();
            bw.flush();
            // 10. 释放资源
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
