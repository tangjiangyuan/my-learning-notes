## day18、

<img src="D:\软件工程\Java\java-advanced\day18\assets\image-20250809184827367.png" alt="image-20250809184827367" style="zoom:67%;" />

## 一、日志

### 1、介绍

- 好比生活中的日记，可以记录生活中的点点滴滴；
- 程序中的日志，使用记录应用程序的【运行信息、状态信息、错误信息等】

### 2、优点

- 数据追踪、性能优化、问题排查、系统监控

### 3、打印语句记录日志的弊端

![image-20250809222603330](D:\软件工程\Java\java-advanced\day18\assets\image-20250809222603330.png)

### 4、日志框架

![image-20250809222702279](D:\软件工程\Java\java-advanced\day18\assets\image-20250809222702279.png)

![image-20250809222709789](D:\软件工程\Java\java-advanced\day18\assets\image-20250809222709789.png)

### 5、Logback 快速入门

![image-20250809222729402](D:\软件工程\Java\java-advanced\day18\assets\image-20250809222729402.png)

![image-20250809222751627](D:\软件工程\Java\java-advanced\day18\assets\image-20250809222751627.png)

（1）在IDEA中创建lib，并导入三个jar包，lib包与src同级

![image-20250809222934417](D:\软件工程\Java\java-advanced\day18\assets\image-20250809222934417.png)

此时的jre包查看不了，通过右击lib包，选择 Add as Library，就可以查看了

![image-20250809222949488](D:\软件工程\Java\java-advanced\day18\assets\image-20250809222949488.png)

（2）导入配置文件 .xml，必须放在 src目录下

![image-20250809223016847](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223016847.png)

（3）获取日志对象使用

![image-20250809223029646](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223029646.png)

![image-20250809223033963](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223033963.png)

（4）阅读配置文件

![image-20250809223119984](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223119984.png)

- 第一个部分将日志记录输出到控制台
- 第二个部分将日志记录到文件中；
- 第三个部分是个开关，选择是否将日志记录到控制台或文件中。

第三个部分：日志打印的5个级别：从小到大

![image-20250809223252707](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223252707.png)

![image-20250809223303745](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223303745.png)

![image-20250809223316540](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223316540.png)

![image-20250809223325334](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223325334.png)

ALL表示：打印所有的级别；OFF：表示所有级别都不打印。

第一部分：

![image-20250809223453674](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223453674.png)

第二部分：%logger{36} ：表示logger对象的参数；36代表字符个数

![image-20250809223509342](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223509342.png)

## 二、枚举

### 1、介绍

- 是Java中的一种特殊类型，一般用来做【**信息的标志和分类**】。

### 2、基本使用

![image-20250809223657774](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223657774.png)

![image-20250809223703232](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223703232.png)

![image-20250809223708626](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223708626.png)

### 3、定义格式

![image-20250809223745875](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223745875.png)

### 4、特点

- 平时，枚举一般不写成员变量，构造方法，抽象方法。
- 一下只做了解

![image-20250809223909842](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223909842.png)

### 5、常用方法

![image-20250809223951467](D:\软件工程\Java\java-advanced\day18\assets\image-20250809223951467.png)

![image-20250809224017890](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224017890.png)

### 6、枚举如果有构造方法，如何给枚举类赋值？

![image-20250809224027644](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224027644.png)

## 三、类加载器

### 1、介绍

- 将类的字节码载入方法区中。
- 加载时机：用到就加载（创建对象的时候、调用类的静态成员、初始化继承体系、使用反射加载类的字节码）。

![image-20250809224242685](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224242685.png)

### 2、类加载器的加载过程

![image-20250809224300669](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224300669.png)

#### 2.1、加载

![image-20250809224327928](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224327928.png)

#### 2.2、链接

![image-20250809224420887](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224420887.png)

===解析：

没有实例化的B类：

![image-20250809224531598](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224531598.png)

![image-20250809224538812](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224538812.png)

![image-20250809224639256](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224639256.png)

![image-20250809224644605](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224644605.png)

![image-20250809224658490](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224658490.png)

点击之后输入 前一张图红框中的 类前面的数字

![image-20250809224724342](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224724342.png)

![image-20250809224730855](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224730855.png)

![image-20250809224734945](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224734945.png)

![image-20250809224740218](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224740218.png)

![image-20250809224746885](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224746885.png)

===说明：C只是一个符号

实例化B后：

![image-20250809224814707](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224814707.png)

重复上面的步骤

![image-20250809224826178](D:\软件工程\Java\java-advanced\day18\assets\image-20250809224826178.png)

此时C类就有地址了。

#### 2.3、初始化

- 就是给类的静态成员变量赋值。

### 3、类加载器的分类

#### 3.1、Bootstrap class Loader

- 虚拟机的内置类加载器，通常表示为null，由C++实现，获取到的只能是null（通常加载JDK自带的类：String、ArrayList、包装类等。）

![image-20250809225036184](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225036184.png)

#### 3.2、Platform class Loader

- （JDK9 之后）平台类加载器，负责加载JDK中一些特殊的模块。如下图中modules里面的类：

![image-20250809225151229](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225151229.png)

#### 3.3、Extension class Loader

- （JDK 9 之前）扩展类加载器，负责加载该目录下的类

![image-20250809225249776](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225249776.png)

#### 3.4、Application class Loader

- 负责加载自己写的类。

#### 3.5、自定义类加载器

- 上级为 Application，目前不做讲解

### 4、类加载器的上下级之分

```java
BootstraptClassLoader -> ExtensionClassLoader/PlatformClassLoader
-> ApplicationClassLoader
```

===jdk17

![image-20250809225527122](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225527122.png)

===jdk8

![image-20250809225554461](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225554461.png)

### 5、双亲委派机模式

![image-20250809225603484](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225603484.png)

![image-20250809225638442](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225638442.png)

===详细图解

![image-20250809225701212](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225701212.png)

===小结

![image-20250809225746804](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225746804.png)

### 6、ClassLoader 成员方法

![image-20250809225808993](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225808993.png)

![image-20250809225835811](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225835811.png)

![image-20250809225845034](D:\软件工程\Java\java-advanced\day18\assets\image-20250809225845034.png)

## 四、反射

### 1、介绍

- 其实就是操作（/ 解剖）字节码对象 

![image-20250809230028441](D:\软件工程\Java\java-advanced\day18\assets\image-20250809230028441.png)

### 2、反射学习路径

- 获取类的字节码对象
- 反射类中的构造方法，随后创建对象
- 反射类中的成员变量，完成赋值和获取
- 反射类中的成员方法，调用成员方法

### 3、字节码对象

![image-20250809230220603](D:\软件工程\Java\java-advanced\day18\assets\image-20250809230220603.png)

![image-20250809230230717](D:\软件工程\Java\java-advanced\day18\assets\image-20250809230230717.png)

### 4、构造方法对象，并实例化

![image-20250809230302191](D:\软件工程\Java\java-advanced\day18\assets\image-20250809230302191.png)

![image-20250809230357405](D:\软件工程\Java\java-advanced\day18\assets\image-20250809230357405.png)

===说明：访问空参构造，不用写参数；访问带参构造，需要写参数。

![image-20250809230522875](D:\软件工程\Java\java-advanced\day18\assets\image-20250809230522875.png)

### 5、成员变量对象，获取和赋值

![image-20250809230530182](D:\软件工程\Java\java-advanced\day18\assets\image-20250809230530182.png)

![image-20250809230900583](D:\软件工程\Java\java-advanced\day18\assets\image-20250809230900583.png)

===**注意：反射中禁止使用暴力反射**

### 6、成员方法对象，调用成员方法

![image-20250809231011818](D:\软件工程\Java\java-advanced\day18\assets\image-20250809231011818.png)

![image-20250809231216037](D:\软件工程\Java\java-advanced\day18\assets\image-20250809231216037.png)

### 7、练习

（1）练习一：

![image-20250809231242820](D:\软件工程\Java\java-advanced\day18\assets\image-20250809231242820.png)

```java
public static void main(String[] args) throws Exception {
    // 1. 创建 List集合
    List<Integer> list = new ArrayList<>();
    Collections.addAll(list, 1, 2, 3);
    // 2. 获取集合的字节码对象
    Class<? extends List> aClass = list.getClass();
    // 3. 获取集合中的成员方法对象
    Method addMethod = aClass.getMethod("add", Object.class);
    // 4. 调用集合中的add方法，并添加字符串
    addMethod.invoke(list, "abcdef");

    System.out.println(list);
}
```

![image-20250809231838057](D:\软件工程\Java\java-advanced\day18\assets\image-20250809231838057.png)

（2）练习二

![image-20250809231847705](D:\软件工程\Java\java-advanced\day18\assets\image-20250809231847705.png)

![image-20250809233441399](D:\软件工程\Java\java-advanced\day18\assets\image-20250809233441399.png)

![image-20250809233444483](D:\软件工程\Java\java-advanced\day18\assets\image-20250809233444483.png)

![image-20250809233447902](D:\软件工程\Java\java-advanced\day18\assets\image-20250809233447902.png)

![image-20250809233451248](D:\软件工程\Java\java-advanced\day18\assets\image-20250809233451248.png)

![image-20250809233454125](D:\软件工程\Java\java-advanced\day18\assets\image-20250809233454125.png)