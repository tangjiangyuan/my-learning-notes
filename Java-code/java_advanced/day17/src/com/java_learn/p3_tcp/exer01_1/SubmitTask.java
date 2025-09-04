package com.java_learn.p3_tcp.exer01_1;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 22:12
 */
public class SubmitTask implements Runnable {
    private Socket socket;

    public SubmitTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 3. 获取流对象
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            // 4. 将网络流交给转换流，再交给字符缓冲流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            // 5. 读取上传的文件名字，用字符流br
            // 此处可能造成阻塞:readLine一次读一行，没有换行符表示没有结束工作，一直等待
            // 因此客户端bw需要调用newLine()进行换行，但是还是不行，字符缓冲流还需要flush或close才能收到信息
            String fileName = br.readLine();
            // 6. 回写确认信息，可以上传字节了
            bw.write("ok");
            bw.newLine();
            bw.flush();

            // 注意: 手动拼接服务器端的存储路径
            File file = new File("D:\\update", UUID.randomUUID().toString() + fileName);
            // 7. 创建本地字节流，用网络字节流读取，用本地字节流写出
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bys = new byte[1024];
            int len;
            // is是网络流，永远不可能读取到客户端的-1，因为客户端的数据要不等于-1才上传
            while ((len = is.read(bys)) != -1) {
                fos.write(bys, 0, len);
            }
            fos.close();

            // 8. 回写消息
            bw.write("上传成功！");
            bw.newLine();
            bw.flush();

            // 9. 释放资源
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
