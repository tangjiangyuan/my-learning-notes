## day14、

![image-20250807002708291](D:\软件工程\Java\java-advanced\day14\assets\image-20250807002708291.png)

## 一、字符缓冲流

### 1、介绍

![image-20250807220046881](D:\软件工程\Java\java-advanced\day14\assets\image-20250807220046881.png)

### 2、构造方法

![image-20250807220106710](D:\软件工程\Java\java-advanced\day14\assets\image-20250807220106710.png)

![image-20250807220137191](D:\软件工程\Java\java-advanced\day14\assets\image-20250807220137191.png)

![image-20250807220202967](D:\软件工程\Java\java-advanced\day14\assets\image-20250807220202967.png)

===补充

​	字符缓冲流和字节缓冲流一样，底层同样内置了8192个大小的数组。

### 3、字符流特有成员方法

![image-20250807220300937](D:\软件工程\Java\java-advanced\day14\assets\image-20250807220300937.png)

### 4、BufferedReader

![image-20250807220332467](D:\软件工程\Java\java-advanced\day14\assets\image-20250807220332467.png)

![image-20250807220345348](D:\软件工程\Java\java-advanced\day14\assets\image-20250807220345348.png)

===**注意**===

​	读取到末尾不再是 -1 ，而是 null。

![image-20250807220419317](D:\软件工程\Java\java-advanced\day14\assets\image-20250807220419317.png)

### 5、BufferedWriter

![image-20250807220510198](D:\软件工程\Java\java-advanced\day14\assets\image-20250807220510198.png)

===优化 ->

![image-20250807220555625](D:\软件工程\Java\java-advanced\day14\assets\image-20250807220555625.png)

### 6、案例

===案例一：

```
/*
    案例 --- 请对D:\Dev-work\java_advanced\day14\出师表.txt 文件做排序操作
 */
```

```java
public static void main(String[] args) throws IOException {
    exercise1();
}

private static void exercise1() throws IOException {
    // 创建 TreeSet集合 存放每一行(备份)
    TreeSet<String> ts = new TreeSet<>();
    BufferedReader br = new BufferedReader(new FileReader("D:\\Dev-work\\java_advanced\\day14\\出师表.txt"));
    String line;
    while ((line = br.readLine()) != null) {
        ts.add(line);
    }
    br.close();

    // ts.forEach(s -> System.out.println(s));
    // 创建字符输出流接收排好序的数据
    BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\出师表.txt"));
    for (String content : ts) {
        // 写出数据
        bw.write(content);
        bw.newLine();
    }
    bw.close();
}
```

===案例二：

```
/*
    案例 --- 读写 Student学生信息
    现有三个学生对象 (张三,23) (李四,24) (王五,25)
    请将这些学生对象的信息保存到本地文件中 D:\stu.txt
    每个学生信息占一行，格式要求
    张三-23
    李四-24
    王五-25
    随后读取这个文件，将学生信息读取到程序，封装为对象，并存入集合
    最后遍历打印集合中的学生信息
 */
```

```java
public static void main(String[] args) throws Exception {
    writeToFile();
    readFromFile();
  }

public static void writeToFile() throws Exception {
    Student stu1 = new Student("张三", 23);
    Student stu2 = new Student("李四", 24);
    Student stu3 = new Student("王五", 25);
    BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\stu.txt"));

    bw.write(stu1.getName() + "-" + stu1.getAge());
    bw.newLine();
    bw.write(stu2.getName() + "-" + stu2.getAge());
    bw.newLine();
    bw.write(stu3.getName() + "-" + stu3.getAge());
    bw.newLine();
    bw.close();
}

public static void readFromFile() throws Exception {
    List<Student> list = new ArrayList<>();
    BufferedReader br = new BufferedReader(new FileReader("D:\\stu.txt"));
    String line;
    while ((line = br.readLine()) != null) {
      list.add(new Student(line.split("-")[0], Integer.parseInt(line.split("-")[1])));
    }	
    br.close();
    for (Student stu : list) {
      System.out.println(stu.getName() + "-" + stu.getAge());
    }
}
```

===总结

![image-20250807222605840](D:\软件工程\Java\java-advanced\day14\assets\image-20250807222605840.png)

## 二、转换流

### 1、分类

​	**InputStreamReader** 和 **OutputStreamWriter**

### 2、作用

- 按照指定的字符编码读写操作；
- 将字节流转换为字符流进行操作。

### 3、为什么要使用转换流？

- 字符流默认使用的是UTF-8 格式读取，不能使用其它格式；
- 而转换流提供了可以使用其它编码方式的构造方法；
- 有些时候获取的流对象不是我们自己创建的而是通过方法获取到的，就需要用到转化流。

![image-20250807222943173](D:\软件工程\Java\java-advanced\day14\assets\image-20250807222943173.png)

### 4、构造方法

```
/*
    转换流 按照指定编码格式读写
    构造方法
    InputStreamReader(InputStream in, String CharsetName)
    OutputStreamWriter(OutputStream in, String CharsetName)
    --- 构造方法中也可以不指定编码格式，系统会按照默认的编码格式读写
 */
```

```java
public static void main(String[] args) throws IOException {
    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\Test.txt", true), "GBK");
    osw.write("哈哈");
    osw.close();
}

private static void read() throws IOException {
    // ANSI 相当于系统默认的gbk
    InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\Test.txt"), "gbk");
    int i;
    while ((i = isr.read()) != -1) {
        System.out.println((char) i);
    }
    isr.close();
}
```

## 三、序列化流（对象流）

### 1、作用

​	可以在流中，以字节的形式直接读写对象。

![image-20250807223246412](D:\软件工程\Java\java-advanced\day14\assets\image-20250807223246412.png)

### 2、分类

​	**ObjectInputStream** ：反序列化流

​	**ObjectOutputStream** ：序列化流

### 3、构造方法

![image-20250807223345068](D:\软件工程\Java\java-advanced\day14\assets\image-20250807223345068.png)

### 4、成员方法

```java
成员方法
    readObject();
    writeObject();
```



### 5、序列化和反序列化

（1）序列化：将对象写出的过程

（2）反序列化：将对象读取的过程

![image-20250807224011843](D:\软件工程\Java\java-advanced\day14\assets\image-20250807224011843.png)

### 6、序列化流操作流程

![image-20250807224019064](D:\软件工程\Java\java-advanced\day14\assets\image-20250807224019064.png)

===说明

​		当对象实现了 Serializable 接口后，就会自动生成一个 serialVersionUID，Java程序调用 writeObject 方法将对象写出到文件时，同时也会把 这个UID一起写出；

​		当程序再调用 readBoject 方法读取文件中的对象时，也会一起读取UID，并拿着这个UID 与类中的 UID 进行比对，如果相同不会报错，如果不相同（即 写出后对类的属性进行了更改），就会报错；

===解决方法

（1）写死这个UID。好处：保证类中的UID 和文件中的 UID 一致，不至于修改类后，会报错。

![image-20250807224456546](D:\软件工程\Java\java-advanced\day14\assets\image-20250807224456546.png)

（2）修改IDEA 中的设置

![image-20250807224511299](D:\软件工程\Java\java-advanced\day14\assets\image-20250807224511299.png)

![image-20250807224518256](D:\软件工程\Java\java-advanced\day14\assets\image-20250807224518256.png)

![image-20250807224551720](D:\软件工程\Java\java-advanced\day14\assets\image-20250807224551720.png)

![image-20250807224601614](D:\软件工程\Java\java-advanced\day14\assets\image-20250807224601614.png)

===扩展---**transient** 关键字

![image-20250807224633115](D:\软件工程\Java\java-advanced\day14\assets\image-20250807224633115.png)

===总结

![image-20250807224649310](D:\软件工程\Java\java-advanced\day14\assets\image-20250807224649310.png)

### 7、案例

![image-20250807224839013](D:\软件工程\Java\java-advanced\day14\assets\image-20250807224839013.png)

===方法一

```java
public static void main(String[] args) throws IOException, ClassNotFoundException {
    // writeObject();
    readObject();
}

private static void readObject() throws IOException, ClassNotFoundException {
    // writeObject();
    // 准备反序列化流，读取对象
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\stu.txt"));
    ArrayList<Student> list = (ArrayList<Student>) ois.readObject(); // 向下转型，可以通过循环遍历list
    for (Student stu : list) {
        System.out.println(stu);
    }
    ois.close();
}

private static void writeObject() throws IOException {
    Student stu1 = new Student("张三", 23);
    Student stu2 = new Student("李四", 24);
    Student stu3 = new Student("王五", 25);

    ArrayList<Student> list = new ArrayList<>();
    Collections.addAll(list, stu1, stu2, stu3);

    // 准备序列化流,写出对象
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\stu.txt"));
    oos.writeObject(list);
    oos.close();
}
```

===方法二：

```java
public static void main(String[] args) throws IOException, ClassNotFoundException {
    // writeObject();
    // 准备反序列化流，读取对象
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\stu.txt"));
    while (true) {
        try {
            Object o = ois.readObject(); // 反序列流读取到末尾没有标志，只会报错，因此可以 try...catch
            System.out.println(o);
        } catch (EOFException e) { // 捕获到 EOF异常就结束循环
            break;
        }
    }
    ois.close();
}

private static void writeObject() throws IOException {
    Student stu1 = new Student("张三", 23);
    Student stu2 = new Student("李四", 24);
    Student stu3 = new Student("王五", 25);

    // 准备序列化流,写出对象
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\stu.txt"));
    oos.writeObject(stu1);
    oos.writeObject(stu2);
    oos.writeObject(stu3);
    oos.close();
}
```

## 四、PrintStream 打印流

### 1、介绍

- 打印流可以实现方便、高效的打印数据到文件中，并且可以指定字符编码；
- 可以实现打印什么数据就是什么数据，例如打印正数 97，写出去就是 97.

### 2、分类

#### 2.1、System.out 标准输出流

#### 2.2、System.in 标准输入流

#### 2.3、System.err 标准错误输出流

```java
public static void main(String[] args) {
    PrintStream out = System.out; // 打印流也是一个字节流
    out.println("哈哈");

    // System.out --- "标准"输出流
    System.out.println();
    // System.in --- "标准"输入流
    Scanner sc = new Scanner(System.in);
    // System.err --- "标准"错误输出流
    System.err.println("哈哈");
}
```

### 3、构造方法

```java
public PrintStream(OutputStream os)
public PrintStream(File file)
public PrintStream(File file, String csn)
public PrintStream(String filePath)
public PrintStream(String filePath, String csn)
```

### 4、成员方法

```java
write() :   写出一个字节，不建议使用，无法原样写入
print() :   原样写入数据，无换行
println() : 原样写入数据，带有换行
```

===演示

![image-20250807225733284](D:\软件工程\Java\java-advanced\day14\assets\image-20250807225733284.png)

===指定编码

![image-20250807225750232](D:\软件工程\Java\java-advanced\day14\assets\image-20250807225750232.png)

===开启追加功能

![image-20250807225820911](D:\软件工程\Java\java-advanced\day14\assets\image-20250807225820911.png)

### 5、PrintWriter 字符打印流

#### 5.1、构造方法和成员方法

![image-20250807230205520](D:\软件工程\Java\java-advanced\day14\assets\image-20250807230205520.png)

![image-20250807230133995](D:\软件工程\Java\java-advanced\day14\assets\image-20250807230133995.png)

![image-20250807230328094](D:\软件工程\Java\java-advanced\day14\assets\image-20250807230328094.png)

===补充

​	只有字节流或字符流可以开启自动刷出功能 - autoFlush；

​	autoFlush 只对 print 生效

![image-20250807230457130](D:\软件工程\Java\java-advanced\day14\assets\image-20250807230457130.png)

#### 5.2、总结

![image-20250807230453286](D:\软件工程\Java\java-advanced\day14\assets\image-20250807230453286.png)

## 五、Properties 集合

===补充

​	Properties 继承了 HashTable

### 1、HashMap 和 HashTable的区别

- **HashTable** 是从 **JDK 1.0** 开始的，此实现是**同步**的，即线程是**安全**的；
- **HashMap** 是从 **JDK 1.2** 开始的，此实现是**不同步**的，即线程不安全。

### 2、介绍

- Properties 类表示一组持久的属性；
- Properties 可以保存到流中，或者从流中加载；
- 属性列表中的每个键值对都是一个字符串；
- 其实就是一个 map集合；
- 内部存放着两个方法，可以很方便地将集合中的键值对写入到文件，也可以方便地从文件中读取。常用于加载配置文件。

![image-20250807230950188](D:\软件工程\Java\java-advanced\day14\assets\image-20250807230950188.png)



### 3、构造方法

```java
Properties() : 创建一个没有默认值地空属性列表
```

### 4、成员方法

![image-20250807231342838](D:\软件工程\Java\java-advanced\day14\assets\image-20250807231342838.png)

### 5、作为集合使用

```java
Properties 作为集合的使用
    Object setProperty(String key, String value) : 类似 Map集合的put方法
    String getProperty(String key) :    类似 Map集合的get方法
    Set<String> stringPropertyNames() :  类似 Map集合的keySet方法
```

===补充

 因为Properties 集合继承了 HashTable， 所以无法保证存入顺序

![image-20250807231520637](D:\软件工程\Java\java-advanced\day14\assets\image-20250807231520637.png)

===Properties 集合地遍历

![image-20250807231547185](D:\软件工程\Java\java-advanced\day14\assets\image-20250807231547185.png)

### 6、和 IO 流有关的方法

```java
Properties 和 IO 有关的方法
    void load(InputStream inStream) : 从输入字节流读取属性列表(键和元素对)
    void load(Reader reader) :          从输入字符流读取属性列表(键和元素对)
    void store(OutputStream out, String comments) : 将集合的键值对写出到文件(字节流)
    void store(Writer writer, String comments) :    将集合的键值对写出到文件(字符流)

    --- String comments 注释
```

===字节流

![image-20250807231707454](D:\软件工程\Java\java-advanced\day14\assets\image-20250807231707454.png)

![image-20250807231746207](D:\软件工程\Java\java-advanced\day14\assets\image-20250807231746207.png)

===字符流-输出

![image-20250807231758882](D:\软件工程\Java\java-advanced\day14\assets\image-20250807231758882.png)

![image-20250807231810816](D:\软件工程\Java\java-advanced\day14\assets\image-20250807231810816.png)

===字符流-输入（读取）

![image-20250807231831526](D:\软件工程\Java\java-advanced\day14\assets\image-20250807231831526.png)

===总结

![image-20250807231857238](D:\软件工程\Java\java-advanced\day14\assets\image-20250807231857238.png)
