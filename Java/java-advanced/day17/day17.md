## day17、

<img src="D:\软件工程\Java\java-advanced\day17\assets\image-20250809000732396.png" alt="image-20250809000732396" style="zoom:67%;" />

## 一、网络编程

### 1、介绍

- 指在【**网络通信协议**】下，不同计算机上运行的程序，进行数据传输。
- 网络通信协议：传输数据的规则。

### 2、软件架构分类

#### 2.1、CS架构

- Client Server（客户端-服务端）：在用户本地有一个客户端程序，在远程有一个服务端程序；
- 优点：画面精美、功能丰富、用户体验度更高；
- 缺点：需要开发客户端，也需要开发服务端；用户需要下载和更新的时候太麻烦。

#### 2.2、BS架构

- Browser Server（浏览器-服务器）：只需要一个浏览器，用户通过不同的网址，可以访问不同的服务端程序。
- 优点：不需要开发客户端，只需要开发服务器端；用户不需要下载，打开浏览器就能使用；
- 缺点：如果应用过大，用户体验受到影响。

#### 2.3、小结

![image-20250809002138289](D:\软件工程\Java\java-advanced\day17\assets\image-20250809002138289.png)

## 二、网络编程三要素

### 1、介绍

- IP：设备在网络中的唯一标识；
- 端口：程序在设备中的唯一标识；
- 协议：数据在网络中传输的规则，常见的协议有：UDP、TCP、http、https、ftp

### 2、IP

#### 2.1、简介

- 全称Internet Protocol，是互联网协议地址，也成为IP地址，是分配给上网设备的数字标签。
- 上网设备在网络中的地址，是唯一的；
- 分类：IPv4、IPv6

#### 2.2、IPv4

- 全称 Internet Protocol version 4，互联网通信协议第四版，采用32位地址长度，分成4组。

![image-20250809153149533](D:\软件工程\Java\java-advanced\day17\assets\image-20250809153149533.png)

#### 2.3、IPv6

- 全称：Internet Protocol version 6，互联网通信协议第六版，由于互联网的蓬勃发展，IP地址的需求也愈来愈大，而IPv4 的模式下的IP 的总数是有限的；采用128位地址长度，分成8组。

![image-20250809153346695](D:\软件工程\Java\java-advanced\day17\assets\image-20250809153346695.png)

===总结

![image-20250809153538276](D:\软件工程\Java\java-advanced\day17\assets\image-20250809153538276.png)

===问题：IPv4的地址已经用完了，为什么还是主流的方案？

===回答：

​		虽然IPv4地址在2011年已经耗尽，但仍是主流，核心在于**过度方案的成熟性和替换成本控制**：

- 技术层面：NAT技术让一个公网IP支撑数百内网设备，CIDR和DHCP进一步提升利用率；
- 经济层面：全球IPv4设备替换需万亿美元投入，且地址交易市场（如AWS租用IP）延缓了枯竭冲击；
- IPv6瓶颈：协议不兼容、运维复杂性和安全顾虑导致普及缓慢，目前依赖双栈/NAT64等过度方案。

- IPv4地址分为：公网地址（万维网使用）和私有地址（局域网使用）；192.168开头的就是私有地址，范围是192.168.0.0 --- 192.168.255.255；专门位组织机构内部使用，以此节省IP地址。

未来趋势：随着5G/IoT设备激增（需海量地址），IPv6部署将加速（国内IPv6流量占比已超40%），但完全替换仍需10年以上。

#### 2.4、特殊IP地址

![image-20250809160253529](D:\软件工程\Java\java-advanced\day17\assets\image-20250809160253529.png)

===问题：当自己电脑被交换机或路由器分配的IP地址为：192.168.0.1，和自己本地电脑的地址：127.0.0.1是一样的吗？

===回答：不一样。192.168.0.1是本地电脑在网络中的IP地址，而127.0.0.1是自己电脑的本地地址，表示的是本机唯一的虚拟地址。

#### 2.5、常用CMD命令

（1）ipconfig ：查看本机的IP地址

![image-20250809160717198](D:\软件工程\Java\java-advanced\day17\assets\image-20250809160717198.png)

（2）ping ：检查网络是否连通

![image-20250809160751414](D:\软件工程\Java\java-advanced\day17\assets\image-20250809160751414.png)

===小结

![image-20250809160825594](D:\软件工程\Java\java-advanced\day17\assets\image-20250809160825594.png)

===问题：为什么平时访问网页时，输入的是网址而不是IP地址？

===回答：DNS服务器会将网址解析为IP地址。

![image-20250809160942363](D:\软件工程\Java\java-advanced\day17\assets\image-20250809160942363.png)

#### 2.6、InetAddress 对象

- 为了方便我们对IP地址的获取和操作，Java提供了一个类InetAddress 供我们使用。
- InetAddress：此类表示Internet协议（IP）地址。

#### 2.6、成员方法

![image-20250809161058470](D:\软件工程\Java\java-advanced\day17\assets\image-20250809161058470.png)

===代码演示

![image-20250809161117642](D:\软件工程\Java\java-advanced\day17\assets\image-20250809161117642.png)

### 3、端口

#### 3.1、简介

- 应用程序在设备中的唯一标识；
- 端口号：由两个字节表示的整数，取值范围：0~65535，其中0~1023之间的端口号用于一些知名的网络服务或者应用。我们自己使用1024以上的端口号就可以。
- **一个端口号只能被一个应用程序使用**。

### 4、协议

#### 4.1、简介

- 计算机网络中，连接和通信的规则被称为网络通信协议。

#### 4.2、UDP 协议

- 用户数据报协议（User Datagram Protocol）；

- UDP 是【面向无连接】的通信协议；

- 速度快；有大小限制，一次最多发送64k；数据不安全，易丢失数据。

  ![image-20250809162034050](D:\软件工程\Java\java-advanced\day17\assets\image-20250809162034050.png)

例如：网络会议、视频通话等。

#### 4.3、TCP协议

- 传输控制协议（Transmission Control Protocol）；
- TCP 协议是【面向连接】的通信协议；
- 速度慢；没有大小限制；数据安全。

## 三、UDP 协议

### 1、简介

### 2、发送数据

![image-20250809162227364](D:\软件工程\Java\java-advanced\day17\assets\image-20250809162227364.png)

![image-20250809162250544](D:\软件工程\Java\java-advanced\day17\assets\image-20250809162250544.png)

### 3、接收数据

![image-20250809162401877](D:\软件工程\Java\java-advanced\day17\assets\image-20250809162401877.png)

![image-20250809162523850](D:\软件工程\Java\java-advanced\day17\assets\image-20250809162523850.png)

### 4、练习

![image-20250809163615409](D:\软件工程\Java\java-advanced\day17\assets\image-20250809163615409.png)

![image-20250809164930837](D:\软件工程\Java\java-advanced\day17\assets\image-20250809164930837.png)

![image-20250809165000929](D:\软件工程\Java\java-advanced\day17\assets\image-20250809165000929.png)

## 四、TCP 协议

### 1、简介

### 2、客户端

![image-20250809165050578](D:\软件工程\Java\java-advanced\day17\assets\image-20250809165050578.png)

![image-20250809165056734](D:\软件工程\Java\java-advanced\day17\assets\image-20250809165056734.png)

### 3、服务端

![image-20250809165235180](D:\软件工程\Java\java-advanced\day17\assets\image-20250809165235180.png)

![image-20250809165254800](D:\软件工程\Java\java-advanced\day17\assets\image-20250809165254800.png)

### 4、TCP 协议细节补充

#### 4.1、三次握手

![image-20250809170526360](D:\软件工程\Java\java-advanced\day17\assets\image-20250809170526360.png)

![image-20250809173445105](D:\软件工程\Java\java-advanced\day17\assets\image-20250809173445105.png)

- 第一次：C -> S : 客户端向服务器端发送一个 SYN包，证明客户端的发送能力正常，服务器端的接收能力正常；
- 第二次：S -> C : 服务器端向客户端发送一个 SYN包 + ACK包，证明服务器端的发送能力正常，客户端的接收能力正常。

===问题：前两次已经证明了客户端和服务器端的接收数据能力正常了，为什么还需要第三次？

=== 回答：

假设为两次握手：

​		当客户端第一次发送 SYN包（因为某种原因）走丢了，客户端会再次发送一个 SYN包给服务器端，服务器端响应一个 SYN + ACK 包，此时双方认为这是一次连接；但是当第一次发送的 SYN包找回了并自动发送给服务器端，服务器端再次响应一个 SYN + ACK包，服务器端认为这又是一次连接。而客户端认为这是服务器端发送的错误信息，不构成连接，倒是对服务器端产生了不必要的消耗，以及资源浪费。

假设为三次握手：

​		当客户端第一次发送 SYN包（因某种原因）走丢了，客户端会再次发送一个 SYN包给服务器端，服务器端响应一个 SYN + ACK包，然后客户端再次发送一个 ACK包，此时双方认为这是一次连接；当第一次发送的 SYN包找回后自动发送给服务器端，服务器端响应一个 SYN + ACK包，而客户端认为这是一个错误信息，不会向服务器端发送 ACK包，服务器端迟迟没有等到 ACK包就会认为这是一次错误连接，避免了资源的浪费。

#### 4.2、四次挥手

![image-20250809174828425](D:\软件工程\Java\java-advanced\day17\assets\image-20250809174828425.png)

### 5、练习

（1）练习一

![image-20250809174909798](D:\软件工程\Java\java-advanced\day17\assets\image-20250809174909798.png)

```java
public class Client {
    public static void main(String[] args) throws Exception {
        // 1. 创建 Socket对象
        Socket socket = new Socket("127.0.0.1", 9090);
        // 2. 获取网络输入输出字节流对象
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        // 3. 将网络字节流转换为字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        // 4. 装备文件对象
        File file = new File("D:\\gbk.txt");
        // 5. 先使用字符流上传文件的名称
        bw.write(file.getName());
        bw.newLine();
        bw.flush();
        // 6. 接收确认消息，上传文件的字节
        if (br.readLine().equals("ok")) {
            // 7. 创建字节流，关联到要上传的文件
            FileInputStream fis = new FileInputStream(file);
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                // 8. 使用网络字节流输出
                os.write(bytes, 0, len);
            }
            fis.close();
            // 9. 关闭输出流
            socket.shutdownOutput();
        }
        // 10. 接收服务器响应的信息
        String result = br.readLine();
        System.out.println(result);
        // 11. 释放资源
        socket.close();
    }
}
```

```java
public class Server {
    public static void main(String[] args) throws Exception {
        // 1. 创建 ServerSocket 对象
        ServerSocket server = new ServerSocket(9090);
        System.out.println("服务器端启动，等待客户端。。。");
        while (true) {
            // 2. 响应客户端的请求
            Socket socket = server.accept();
            // 3. 获取网络输入输出字节流对象
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            // 4. 将网络流转换为字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            // 5. 使用字符流读取传过来的文件名
            String fileName = br.readLine();
            // 6. 向客户端发送确认消息，可以上传文件的字节了
            bw.write("ok");
            bw.newLine();
            bw.flush();
            // 7. 创建字节输出流关联要写出的文件地址
            File file = new File("E:\\", fileName);
            FileOutputStream fos = new FileOutputStream(file);
            // 8. 使用网路字节流读取文件字节
            int len;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1) {
                // 9. 字节流写出
                fos.write(bytes, 0, len);
            }
            fos.close();
            // 10. 向客户端发送确认消息
            bw.write("上传成功!");
            bw.newLine();
            bw.flush();
        }
    }
}
```

（2）练习二

![image-20250809183233884](D:\软件工程\Java\java-advanced\day17\assets\image-20250809183233884.png)

===扩展 UUID

![image-20250809183252041](D:\软件工程\Java\java-advanced\day17\assets\image-20250809183252041.png)

===说明：文件名前加入UUID，防止多次上传文件名重名问题。

```java
public class Server {
    public static void main(String[] args) throws Exception {
        // 1. 创建 ServerSocket 对象
        ServerSocket server = new ServerSocket(9090);
        System.out.println("服务器端启动，等待客户端。。。");
        while (true) {
            // 2. 响应客户端的请求
            Socket socket = server.accept();
            // 3. 获取网络输入输出字节流对象
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            // 4. 将网络流转换为字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            // 5. 使用字符流读取传过来的文件名
            String fileName = br.readLine();
            // 6. 向客户端发送确认消息，可以上传文件的字节了
            bw.write("ok");
            bw.newLine();
            bw.flush();
            // 7. 创建字节输出流关联要写出的文件地址
            File file = new File("E:\\", UUID.randomUUID().toString() + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            // 8. 使用网路字节流读取文件字节
            int len;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1) {
                // 9. 字节流写出
                fos.write(bytes, 0, len);
            }
            fos.close();
            // 10. 向客户端发送确认消息
            bw.write("上传成功!");
            bw.newLine();
            bw.flush();
        }
    }
}
```

（3）练习三---考虑多线程

![image-20250809183524599](D:\软件工程\Java\java-advanced\day17\assets\image-20250809183524599.png)

```java
public class Server {
    public static void main(String[] args) throws Exception {
        // 1. 创建 ServerSocket 对象
        ServerSocket server = new ServerSocket(9090);
        System.out.println("服务器端启动，等待客户端。。。");
        while (true) {
            // 2. 响应客户端的请求
            Socket socket = server.accept();
            new Thread(new SubmitTask(socket)).start();
        }
    }
}
```

```java
public class SubmitTask implements Runnable {

    private Socket socket;

    public SubmitTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 3. 获取网络输入输出字节流对象
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            // 4. 将网络流转换为字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            // 5. 使用字符流读取传过来的文件名
            String fileName = br.readLine();
            // 6. 向客户端发送确认消息，可以上传文件的字节了
            bw.write("ok");
            bw.newLine();
            bw.flush();
            // 7. 创建字节输出流关联要写出的文件地址
            File file = new File("E:\\", UUID.randomUUID().toString() + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            // 8. 使用网路字节流读取文件字节
            int len;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1) {
                // 9. 字节流写出
                fos.write(bytes, 0, len);
            }
            fos.close();
            // 10. 向客户端发送确认消息
            bw.write("上传成功!");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

（4）使用线程池管理线程

```java
public class Server {
    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        // 1. 创建 ServerSocket 对象
        ServerSocket server = new ServerSocket(9090);
        System.out.println("服务器端启动，等待客户端。。。");
        while (true) {
            // 2. 响应客户端的请求
            Socket socket = server.accept();
            pool.submit(new SubmitTask(socket));
        }
    }
}
```
