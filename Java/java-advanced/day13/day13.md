## day13、

<img src="D:\软件工程\Java\java-advanced\day13\assets\image-20250806231033506.png" alt="image-20250806231033506" style="zoom:67%;" />

## 一、IO 流

### 1、介绍

- I ： input 输入（读取）；
- O ： output 输出（写出）。

### 2、作用

![image-20250806232154025](D:\软件工程\Java\java-advanced\day13\assets\image-20250806232154025.png)

### 3、IO 流体系结构

#### 3.1、使用场景

​	在操作纯文本文件时，使用字符流；其它情况下，使用字节流。

#### 3.2、字节流

​	也称万能流，计算机中，数据都以字节的形式存储。

![image-20250806232338311](D:\软件工程\Java\java-advanced\day13\assets\image-20250806232338311.png)

#### 3.3、字符流

​	纯文本文件，里面都是字；字节流操作纯文本文件时，会出现乱码问题。

![image-20250806232430878](D:\软件工程\Java\java-advanced\day13\assets\image-20250806232430878.png)

### 4、FileOutputStream 字节输出流

#### 4.1、构造方法

![image-20250806232623185](D:\软件工程\Java\java-advanced\day13\assets\image-20250806232623185.png)

#### 4.2、成员方法

![image-20250806232634738](D:\软件工程\Java\java-advanced\day13\assets\image-20250806232634738.png)

===补充===

​	输出流关联文件时，文件如果不存在：会自动创建出来；如果文件存在，：会先**清空**文件中的所有数据，然后再写入，除非开启追加功能。

​	流对象使用完毕后，记得调用 close 方法关闭流，不然会占用资源。

```java
public static void main(String[] args) throws IOException {
    // 输出流关联文件，文件路径以字符串形式给出
    // true : 表示开启追加写入模式
    FileOutputStream fos = new FileOutputStream("D:\\a.txt", true);  
    // 写出数据
    fos.write(97); // a
    fos.write(98); // b
    fos.write(99); // c

    byte[] bys = {99, 100, 101, 102};
    fos.write(bys);
    fos.write("你好你好".getBytes()); // 将文字输入到文件中
    fos.write(bys, 1, 3); // 字节数组、起始索引、写入个数

    fos.close();
}
```



#### 4.3、IO 流处理异常的方法

（1）jdk7之前

```java
public static void main(String[] args) throws IOException {
    FileOutputStream fos = null;
    try {
        // System.out.println(10 / 0);
        fos = new FileOutputStream("D:\\B.txt");
        fos.write("abc".getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        // fos不为null，表示和流建立联系了，需要关流
        if (fos != null) { 
            fos.close();
        }
    }
}
```

===扩展：final 和 finally 的区别

```
- final ： 是java中的关键字，用于修饰变量(常量)、类(最终类，无法继承)、方法(最终方法，无法重写)
- finally ： 是 Java 异常处理机制中的一个关键字，用于保证某段代码一定会被执行，无论是否发生异常、是否提前 return。
- 无论 try 块中发生什么（异常、return、break），finally 里的代码都会被执行；finally 是“保险机制”，确保关键清理代码一定会执行，常用于资源释放。
finally 关键字的作用：
- 资源释放：关闭文件、数据库连接、网络连接等
- 清理工作：比如释放锁、记录日志等
- 避免资源泄露：即使中途出异常，也能保证资源被正确关闭
注意：
- 如果 JVM 崩溃（如 System.exit(0)），finally 不会执行。
- finally 中如果抛出异常，会覆盖 try/catch 中的异常。
```

（2）jdk7之后

![image-20250806233450720](D:\软件工程\Java\java-advanced\day13\assets\image-20250806233450720.png)

```java
public static void main(String[] args) {
    // 会自动关流
    try (FileOutputStream fos = new FileOutputStream("D:\\B.txt")) 	  { 
        fos.write("abc".getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```



### 5、FileInputStream 字节输入流

#### 5.1、构造方法

![image-20250806234039679](D:\软件工程\Java\java-advanced\day13\assets\image-20250806234039679.png)

#### 5.2、成员方法

![image-20250806234030644](D:\软件工程\Java\java-advanced\day13\assets\image-20250806234030644.png)

```java
public static void main(String[] args) throws IOException {
    FileInputStream fis = new FileInputStream("D:\\a.txt");
    int i;
    while ((i = fis.read()) != -1) { // 当读取到最后一个元素时，再读取只会返回-1
        System.out.println((char) i); // 将字节转换为字符
    }
    fis.close();
}
```

```java
public static void main(String[] args) throws IOException {
    FileInputStream fis = new FileInputStream("D:\\a.txt");
    // 准备字节数组，装字节
    byte[] bys = new byte[2];
    int len;
    while ((len = fis.read(bys)) != -1) {
        String s = new String(bys, 0, len);
        System.out.print(s);
    }
    fis.close();
}
```

===补充

```java
String 类的构造方法
--- public String(byte[] bytes, int offset, int length) : 将字符数组装换为字符串
        - 参数1 : 字符数组
        - 参数2 : 起始索引
        - 参数3 : 转换个数
```



#### 5.3、案例

```java
/*
    案例 --- 文件拷贝
    将 D:\\嘿嘿.png，拷贝到 E:\\ 根目录下
    1. 创建输入流对象读取文件
    2. 创建输出流对象关联到数据目的地
    3. 读写操作
    4. 关流释放内存
 */
```

```java
public static void main(String[] args) throws IOException {
    // 1. 创建输入流对象读取文件
    FileInputStream fis = new FileInputStream("D:\\嘿嘿.png");
    // 2. 创建输出流对象关联到数据目的地
    FileOutputStream fos = new FileOutputStream("E:\\嘿嘿.png");
    // 3. 读写操作
    byte[] bys = new byte[1024]; // 将需要读取的数据存放入字节数组中
    int len; // 有效字节数
    while ((len = fis.read(bys)) != -1) {
        fos.write(bys, 0, len); // 有效字节数为多少，就读多少
    }
    // 4. 关流释放内存
    fis.close();
    fos.close();
}
```



### 6、字节缓冲流

#### 6.1、介绍

​	字节流缓冲流在源代码中布置了字节数组，可以**提高读写效率**。

#### 6.2、构造方法

![image-20250806234851910](D:\软件工程\Java\java-advanced\day13\assets\image-20250806234851910.png)

```java
/*
    字节缓冲流在源代码中内置了字节数组，可以提高读写效率

        字节缓冲输入流 : BufferedInputStream(InputStream in)
        字节缓冲输出流 : BufferedOutputStream(OutputStream out)

        缓冲流 : 39ms
        普通流 : 6369ms
 */
public static void main(String[] args) throws IOException {

    long start = System.currentTimeMillis();

    FileInputStream fis = new FileInputStream("D:\\猪猪侠.ogg");
    FileOutputStream fos = new FileOutputStream("E:\\猪猪侠2.ogg");
    int i;
    while ((i = fis.read()) != -1) {
        fos.write(i);
    }
    fis.close();
    fos.close();

    long end = System.currentTimeMillis();
    System.out.println(end - start);
}

private static void bufferedStreamMethod() throws IOException {
    // 1. 创建字节缓冲输入流
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\猪猪侠.ogg"));
    // 2. 创建字节缓冲输出流
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\猪猪侠.ogg"));
    // 3. 读写操作
    int i;
    while ( (i = bis.read()) != -1) {
        bos.write(i);
    }
    // 4. 关流
    bis.close();
    bos.close();
}
```



#### 6.3、缓冲流的读写过程

![image-20250806235601593](D:\软件工程\Java\java-advanced\day13\assets\image-20250806235601593.png)

```java
/*
    字节缓冲流输入流，读取数据的过程
 */
public static void main(String[] args) throws IOException {
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\c.txt"));
    int i = bis.read();
    System.out.println(i);
    bis.close();
}
```

```java
public static void main(String[] args) throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\d.txt"));
    for (int i = 1; i <= 8192; i++) {
        bos.write(97);
    }
    bos.close();
}
```

===补充

```java
字节缓冲输出流，写入数据的过程
- 注意 : 不会直接写入到文件，而是会先写到缓冲流的字节数组中，只有字节大小超过8192，才会写入到文件。
但是，关流，会提前将数据写入到文件（即写入的数据不够8192个字节大小，也会写入到文件）。
```



#### 6.4、案例

![image-20250806235848337](D:\软件工程\Java\java-advanced\day13\assets\image-20250806235848337.png)

```java
public static void main(String[] args) throws IOException{
    /*FileOutputStream fos = new FileOutputStream("D:\\a.txt");
    for (int i = 1; i <= 10000; i++) {
        fos.write(97);
    }
    fos.close();*/
    long start = System.currentTimeMillis();

    copyMethod4();

    long end = System.currentTimeMillis();
    System.out.println(end - start);
}

/**
 * 1. 普通流单个字节拷贝
 */
public static void copyMethod1() throws IOException {
    FileInputStream fis = new FileInputStream("D:\\a.txt");
    FileOutputStream fos = new FileOutputStream("E:\\a1.txt");
    int i;
    while ((i = fis.read()) != -1) {
        fos.write(i);
    }
    fis.close();
    fos.close();
}

/**
 * 2. 普通流 + 自定义数组拷贝
 */
public static void copyMethod2() throws IOException{
    FileInputStream fis = new FileInputStream("D:\\a.txt");
    FileOutputStream fos = new FileOutputStream("E:\\a2.txt");
    int len;
    byte[] bys = new byte[1024];
    while ((len = fis.read(bys)) != -1) {
        fos.write(bys, 0, len);
    }
    fis.close();
    fos.close();
}

/**
 * 3. 缓冲流单个字节拷贝
 */
public static void copyMethod3() throws IOException{
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\a.txt"));
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\a3.txt"));
    int i;
    while ((i = bis.read()) != -1) {
        bos.write(i);
    }
    bis.close();
    bos.close();
}

/**
 * 4. 缓冲流 + 自定义数组拷贝
 */
public static void copyMethod4() throws IOException{
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\a.txt"));
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\a4.txt"));
    int len;
    byte[] bys = new byte[1024]; // 或者8192
    while ((len = bis.read(bys)) != -1) {
        bos.write(bys, 0, len);
    }
    bis.close();
    bos.close();
}
```

![image-20250807000008558](D:\软件工程\Java\java-advanced\day13\assets\image-20250807000008558.png)

### 7、FileReader 字符输入流

#### 7.1、介绍

​	使用字节流读取纯文本文件时，若文件中只有汉字，通过字节数组没有问题，但是如果文件中不仅有汉字，还有标点符号，也会出现乱码。

#### 7.2、作用

​	用于读取纯文本文件，解决中文乱码问题。

#### 7.3、构造方法

```java
1. public FileReader(String fileName) : 字符输入流关联文件，路径以字符串形式给出
2. public FIleReader(File file) : 字符输入流关联文件，路径以File对象形式给出
```



#### 7.4、成员方法

```java
1. public int read() : 读取单个字符
2. public int read(char[] cbuf) : 读取一个字符数组，返回读取到的有效字符个数
```

```java
public static void main(String[] args) throws IOException {
    FileReader fr = new FileReader("D:\\A.txt");
    char[] chars = new char[1024];
    int len;
    while ((len = fr.read(chars)) != -1) {
        String s = new String(chars, 0, len);
        System.out.println(s);
    }
}

private static void method1() throws IOException {
    FileReader fr = new FileReader("D:\\A.txt");
    int i;
    while ((i = fr.read()) != -1) {
        System.out.print((char) i);
    }
    fr.close();
}
```



#### 7.5、字符集，字符编码

（1）字符集：是指多个字符的集合

![image-20250807000728131](D:\软件工程\Java\java-advanced\day13\assets\image-20250807000728131.png)

（2）常见字符集

![image-20250807000748662](D:\软件工程\Java\java-advanced\day13\assets\image-20250807000748662.png)

===注意

​	Unicode字符集：国际标准字符集，它将世界各种语言的每个字符定义一个唯一的编码，以满足跨语言、跨平台的文本信息转换。

（3）字符编码：一种规则，将字符转换为字节的规则

​	使用这个规则，可以将某个字符映射成其它形式的数据以便在计算机中存储和传输。

![image-20250807000937975](D:\软件工程\Java\java-advanced\day13\assets\image-20250807000937975.png)



#### 7.6、编码和解码

（1）编码：字符转字节

![image-20250807001225625](D:\软件工程\Java\java-advanced\day13\assets\image-20250807001225625.png)

![image-20250807001231001](D:\软件工程\Java\java-advanced\day13\assets\image-20250807001231001.png)

（2）解码：字节转字符

![image-20250807001333677](D:\软件工程\Java\java-advanced\day13\assets\image-20250807001333677.png)

![image-20250807001340298](D:\软件工程\Java\java-advanced\day13\assets\image-20250807001340298.png)

===总结

![image-20250807001418244](D:\软件工程\Java\java-advanced\day13\assets\image-20250807001418244.png)

===问题：问什么FileReader 读取字符，可以解决乱码？

![image-20250807001432653](D:\软件工程\Java\java-advanced\day13\assets\image-20250807001432653.png)

### 8、FileWriter 字符输出流

#### 8.1、构造方法

```java
构造方法 :
FileWriter(String fileName) : 字符输出流关联文件，路径以字符串形式给出
FileWriter(String fileName, boolean append) : 参数2表示 开启追加功能
FileWriter(File file) :  字符输出流关联文件，路径以File对象形式给出
FileWriter(File file, boolean) : 参数2表示 开启追加功能
```



#### 8.2、成员方法

```java
public void write(int c) :  写出单个字符
public void write(char[] cbuf) : 写出一个字符数组
public void write(char[] cbuf, int off, int len) : 写出一个字符数组的一部分
public void write(String str) : 写出字符串
public void write(String str, int off, int len) :   写出字符串的一部分
```

```java
public static void main(String[] args) throws Exception{
    FileWriter fw = new FileWriter("D:\\c.txt");

    char[] chars = {'a', 'b', 'c'};

    fw.write('a'); // a
    fw.write(chars); // aabc
    fw.write(chars , 0 , 2); // aabcab
    fw.write("你好你好~"); // aabcab你好你好~
    fw.write("哈哈哈哈哈", 0, 2); // aabcab你好你好~哈哈

    fw.close();
}
```

===注意

![image-20250807001811759](D:\软件工程\Java\java-advanced\day13\assets\image-20250807001811759.png)

#### 8.3、案例

===案例一：

```java
/*
    例一 图片文件加密和解密
    加密思路 ： 改变原始文件中的字节，就无法打开了
            字节^2
    解密思路： 将文件中的字节还原成原始字节即可
            字节^2
    注意 : 一个数连续异或两次得到的还是原数
    加密 : 运行一次
    解密 : 运行两次
 */
public static void main(String[] args) throws Exception{
    method();
}


public static void method() throws IOException{
    FileInputStream fis = new FileInputStream("D:\\a.png");
    ArrayList<Integer> list = new ArrayList<>();
    int i;
    if ((i = fis.read()) != -1) {
        list.add(i);
    }
    fis.close();

    FileOutputStream fos = new FileOutputStream("D:\\a.png");
    for (Integer myByte : list) {
        fos.write(myByte ^ 2);
    }
    fos.close();
}
```

```java
/*
    注意 : 一个数连续异或两次得到的还是原数
    加密 : 运行一次
    解密 : 运行两次
 */
public static void main(String[] args) throws IOException {
    // 1. 创建输入流对象，关联到要加密的图片
    FileInputStream fis = new FileInputStream("D:\\a.jpg");
    // 2. 创建一个Integer类型的集合，来存放读取到的字节
    ArrayList<Integer> list = new ArrayList<>();
    // 3. 循环读取文件中的字节，并存入集合
    int i;
    if ((i = fis.read()) != -1) {
        list.add(i);
    }
    // 4. 关闭输入流对象
    fis.close();

    // 5. 创建输出流对象，关联到图片文件
    FileOutputStream fos = new FileOutputStream("D:\\a.jpg");
    // 6. 遍历集合，从集合中取出字节，并写出
    for (Integer myByte : list) {
        fos.write(myByte ^ 2); // 在调用一次相当于 myByte ^ 2 ^ 2
    }
    // 7. 关闭输出流对象
    fos.close();
}
```

===案例二：

```java
/*
    案例 - 统计字符次数
    如 : A(1)B(2)C(3)
*/
public static void main(String[] args) throws IOException {
    method2();
}

private static void method1() throws IOException {
    // 使用TreeMap收集字母的对应次数
    TreeMap<Character, Integer> tm = new TreeMap<>();
    // 使用字符流读取文件
    FileReader fr = new FileReader("D:\\a.txt");
    // 通过字符串拼接文件中的字符
    String s = null;
    // 读取文件中的所有字符
    int len;
    char[] chars = new char[10];
    while ((len = fr.read(chars)) != -1) {
        s = new String(chars, 0, len);
    }
    // 关流
    fr.close();
    // 将字符串转换为字符数组
    char[] charArray = s.toCharArray();
    // 遍历字符数组
    for (char c : charArray) {
        // 统计每一个字符以及该字符的个数
        if (!tm.containsKey(c)) {
            tm.put(c, 1);
        } else {
            tm.put(c, tm.get(c) + 1);
        }
    }
    // 将结果输出到控制台
    tm.forEach((k, v) -> System.out.print(k + "(" + v + ")"));
}
```

===案例三：

``` java
/*
    拷贝一个文件夹，包括子文件夹
 */
public static void main(String[] args) throws IOException{
    File src = new File("D:\\a.txt");
    File dest = new File("E:\\");

    if (src.equals(dest)) {
        System.out.println("目标文件夹是源文件夹的子文件夹");
    } else {
        copyDir(src, dest);
    }
}

public static void copyDir(File src, File dest) throws IOException {
    // 重点 ： windows不会自动创建文件夹，只能通过File对象创建
    File newDir = new File(dest, src.getName());
    newDir.mkdirs();

    // 从数据源中获取数据
    File[] files = src.listFiles();
    for (File file : files) { // 文件或文件夹
        // 如果是文件
        if (file.isFile()) {
            // 则直接拷贝
            FileInputStream fis = new FileInputStream(file); // 读取当前文件
            // 重点 ： 写出到目标文件夹下
            FileOutputStream fos = new FileOutputStream(new File(newDir, file.getName()));

            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            fis.close();
            fos.close();
        } else { // 如果是文件夹，则递归调用本方法
            copyDir(file, newDir);
        }
    }
}
```