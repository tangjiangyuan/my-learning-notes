## day08、API、String、StringBuilder

<img src="D:\软件工程\Java\java-basic\day08\assets\image-20250802155137230.png" alt="image-20250802155137230" style="zoom:67%;" />

## 一、常见API

### 1、API介绍

​	API（Application Programming Interface）：应用程序编程接口。就是别人写好的一些类，给程序员直接拿去调用即可解决问题的。如：Scanner、Random等。

### 2、API帮助文档的使用流程

（1）在索引位置搜索自己要查看的类

（2）看包。目的：是java.lang(核心包),不需要编写导包代码(import)；不是java.lang包，都需要编写导包代码。

（3）看这个类的介绍。目的：搞清楚这个类的作用。

（4）看这个类的构造方法。目的：为了将该类的对象，创建出来。

（5）看这个类的成员方法（方法摘要）（方法名、参数、返回值和介绍）。

### 3、Scanner 补充

```java
/*
Scanner 键盘录入字符串 :
    String next() : 遇到了空格，或者是tab键就不再录入了。
    String nextLine() : 可以解决遇到空格或者是tab键不可继续录入的情况。以回车作为录入结束（下班）的标记。

    弊端 :
            1. next() : 数据可能录入不完整。
            2. nextLine() : 之前调用过nextInt(),nextDouble()...,nextLine()方法，就不执行了。

    解决方案 : 不需要解决
            Scanner : 采集用户信息（只在学习过程中用得到）
    目前的使用方案 :
        需求如果要键盘录入字符串
                如果所有的数据，全部都是字符串，直接nextLine();
                    举例 :
                            键盘录入用户名，键盘录入用户密码

                如果数据除了字符串，还有其他类型，需要调用next()方法
                    举例 :
                            键盘录入用户名，键盘录入用户年龄，用户身高
*/
```

## 二、String 类

### 1、特点

- Java程序中所有的双引号字符串，都是String类的对象。
- 字符串一旦被创建，就不可更改（内容不可更改）；如果想要更改，只能使用新对象，做替换。
- String字符串虽然不可改变，但是可被共享。

=== 扩展：字符串常量池（StringTable）

​	当我们使用双引号创建字符串对象时，会检查常量池中是否存在该数据。

​	不存在：创建；

​	存在：复用。

**![image-20250802160449667](D:\软件工程\Java\java-basic\day08\assets\image-20250802160449667.png)**

### 2、常见构造方法

```java
/*
    String 类常见构造方法 :
        public String() : 创建一个空白字符，里面不包含任何内容
        public String(char[] chs) : 根据传入的字符数组，创建字符串对象
        public String(String original) : 根据传入的字符串，来创建字符串对象
     ----------------------------------------------------------

        1. 打印对象名，会看到对象的内存地址，这里打印字符串对象，为什么没有看到地址值
        回答 : 暂不解释
        TODO : 面向对象（继承），方法重写，Object类，toString方法

        2. 这三个构造方法，创建字符串对象，都没有双引号直接创建来的方便
    ----------------------------------------------------------
        字符串对象，两种创建方式的区别
                1. 双引号直接创建（推荐）
                2. 通过构造方法创建
 */
```

### 3、面试题

（1）

![image-20250802160724730](D:\软件工程\Java\java-basic\day08\assets\image-20250802160724730.png)

（2）新创建的对象数据是从常量池中拷贝来的（拷贝的是对象的字节数组的地址值）。字符串在源码中其实就是一个byte类型的字节数组。字符串两种创建方式的区别：内存中的地址不一样。

String s2 = new String("abc"); 这句代码有两个对象。一个（new）在堆内存中的一个独立空间中，一个（"abc"）在常量池中。

![image-20250802160814188](D:\软件工程\Java\java-basic\day08\assets\image-20250802160814188.png)

（3）s3 会在推内存中开辟一个StringBuilder的空间，至此处进行拼接；拼接完后不能直接将StringBuilder的地址值传给s3，要先通过toString方法，装换位String类型，再将String的地址值传给s3.

![image-20250802160910838](D:\软件工程\Java\java-basic\day08\assets\image-20250802160910838.png)

（4）结果为 true，因为常量优化机制，会直接进行拼接

![image-20250802160951663](D:\软件工程\Java\java-basic\day08\assets\image-20250802160951663.png)

### 4、常用的成员方法

#### 4.1、比较

```java
public equals(Object anObject) : 将此字符串与指定对象进行比较。
public equalsIgnoreCase(String anotherString) : 将此 String与其他 String比较，忽略案例注意事项，不考录大小写。
```

#### 4.2、遍历

```java
public char[] toCharArray(){} : 将此字符串转换为新的字符数组。
public char charAt(int index){} : 返回 char指定索引处的值。
public int length(){} : 返回此字符串的长度。

// 比较而言，第一种遍历方式效率更高
```

```java
public static void main(String[] args) {
        print1();
        System.out.println("----");
        print2();
    }
	// 字符串遍历的第二种遍历方式
    private static void print2() {
        String s = "ayaka";
        for (int i = 0; i < s.length(); i++) { // 循环中重复调用length()方法，一直进栈弹栈，影响代码运行效率
            char c = s.charAt(i);
            System.out.println(c);
        }
    }
	// 字符串遍历的第一种方式
    private static void print1() {
        String s = "violet";
        char[] chars = s.toCharArray(); // 只调用了一次方法
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
```

#### 4.3、截取

```java
public String substring(int beginIndex) : 返回一个(从开始索引到字符串末尾的)字符串。
public String substring(int beginIndex, int endIndex) 返回一个(在起始索引到结束索引之间的所包含的)字符串.
        但是不包括结束索引的字符。左闭右开。

// 注意 : 截取出来的内容，是作为新的字符串返回，需要找变量接收。
```

#### 4.4、替换

```java
public String replace(CharSequence target, CharSequence replacement)
    target : 旧值
    replace : 新值
```

```java
public static void main(String[] args) {
    String s = "i love you";
    String re = s.replace("love", "hate");
    System.out.println(re);
}
```

#### 4.5、切割

```java
 public String[] split(String regex) : 根据传入的字符串作为规则，切割当前字符串
// 建议 : 先正常指定切割规则，后来发现没有得到自己要的效果，就可以尝试在规则前面，加入 '\\'
```

```java
public static void main(String[] args) {
        String s = "192-168-1-1";
        String[] sArr = s.split("-"); // "." 表示正通规则，可代表任意字符；通过"\\."来切割
        // String[] sArr = s.split(".");

        for (int i = 0; i < sArr.length; i++) {
            System.out.println(sArr[i]);
        }
    }
```

#### 4.6、方法小结

![image-20250802161806545](D:\软件工程\Java\java-basic\day08\assets\image-20250802161806545.png)

### 5、练习

练习一：

```java
/*
案例 : 用户登录
需求 : 已知正确的用户名和密码，请用程序实现模拟用户登录。总共给三次机会，登录之后，给出相应的提示。
 */
```

```java
public class Test20 {
  public static void main(String[] args) {
    String username = "admin";
    String password = "1223";
    login(username, password);
  }

  public static void login(String username, String password) {
    Scanner sc = new Scanner(System.in);
    for (int i = 1; i <= 3; i++) {
      System.out.println("用户名:");
      String inputUsername = sc.nextLine();
      System.out.println("密  码:");
      String inputPassword = sc.nextLine();
      if (inputUsername.equals(username) && inputPassword.equals(password)) {
        System.out.println("登录成功！");
        sc.close();
        System.exit(0);
      } else {
        if (i == 3) {
          System.out.println("登录失败，您没有登录次数了。");
        } else {
          System.out.println("登录失败，您还剩:" + (3 - i) + "次机会");
        }
      }
    }
  }
```

练习二：

```java
/*
案例 : 统计字符次数
需求 : 键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数（不考虑其他字符）
例如 : aAb3&c2B*4CD1
小写字母 : 3个
大写字母 : 4个
数字字符 : 4个
*/
```

```java
public static void main(String[] args) {
    statisticsCounts();
  }

  public static void statisticsCounts() {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入:");
    String msg = sc.nextLine();
    sc.close();
    
    char[] charArray = msg.toCharArray();
    int lowercase = 0;
    int uppercase = 0;
    int number = 0;

    for (char c : charArray) {
      if (c >= 'a' && c <= 'z') {
        lowercase++;
      }
      if (c >= 'A' && c <= 'Z') {
        uppercase++;
      }
      if (c >= '0' && c <= '9') {
        number++;
      }
    }
    System.out.println("小写字母:" + lowercase + "个。");
    System.out.println("大写字母:" + uppercase + "个。");
    System.out.println("数字字符:" + number + "个。");
  }
```

练习三：

```java
/*
    案例 : 手机号屏蔽(shield)
    需求 : 以字符串的形式从键盘接受一个手机号，将中间四位号码屏蔽
    最终效果为 : 156****1234
 */
```

```java
public static void main(String[] args) {
    String shieldPhoneNum = shieldPhoneNum("18139553548");
    System.out.println(shieldPhoneNum);
  }

  public static String shieldPhoneNum(String phoneNum) {
    String start = phoneNum.substring(0, 3);
    String end = phoneNum.substring(7);
    return start + "****" + end;
  }
```

练习四：

```java
/*
    案例 : 敏感词(Sensitive Words)替换
    需求 : 键盘录入一个字符串，如果字符串包含（TMD），则使用***替换
 */
```

```java
public static void main(String[] args) {
    String replaceSensitiveWords = replaceSensitiveWords("你TMD，臭贝贝");
    System.out.println(replaceSensitiveWords);
  }

  public static String replaceSensitiveWords(String info) {
    String replaceInfo = info.replace("TMD", "***");
    return replaceInfo;
  }
```

## 三、StringBuilder 类

### 1、介绍

- 一个可变的字符序列；
- StringBuilder 是字符串缓冲区，将其理解是一个容器，这个容器可以存储任意数据类型的数据，但只要进入这个容器，就都会变成字符串。

### 2、特点

- 提高字符串的操作效率。

### 3、构造方法

```java
public StringBuilder() : 创建一个空白的字符串缓冲区（容量），初始容量为16个字符。(如果不够，会自动扩容)

 public StringBuilder(String str) : 创建一个空白的字符串缓冲区（容量），容器创建好之后，就会带有参数的内容。
```



### 4、成员方法

```java
public StringBuilder append(任意类型) : 添加数据，并返回自己

public StringBuilder reverse() : 将缓冲区中的内容，进行反转

public int length() : 返回长度

public String toString() : 将缓冲区中的数据，以String字符串类型返回
```



### 5、练习

练习一：

```java
/*
需求 : 键盘接收一个字符串，程序判断(judge)出该字符串是否是对称(symmetry)字符串，并在控制台打印是或不是
        对称字符串 : 123321、111
        非对称字符串 : 123123
*/
```

```java
public static void main(String[] args) {
    boolean flag = checkSymmetryString("123321");
    if (flag) {
      System.out.println("是对称字符串");
    } else {
      System.out.println("不是对称字符串");
    }
  }

  public static boolean checkSymmetryString(String msg) {
    String reverseMsg = new StringBuilder(msg).reverse().toString();
    if (!msg.equals(reverseMsg)) {
      return false;
    }
    return true;
  }
```

练习二：

```java
/*
    需求 :
        定义一个方法，把int数组中的数据按照指定的格式拼接(splicing)成一个字符串返回
        调用该方法，并在控制台输出结果。

        例如 : 数组 int[] arr = {1,2,3};
        执行方法后的输出结果为 : [1, 2, 3]
 */
```

```java
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    String splicing = splicing(arr);
    System.out.println(splicing);
  }

  public static String splicing(int[] arr) {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < arr.length; i++) {
      if (i == arr.length - 1) {
        sb.append(arr[i] + "]");
      } else {
        sb.append(arr[i] + ", ");
      }
    }
    return sb.toString();
  }
```

### 6、提高效率的原因

- String 进行字符串的拼接时，会浪费资源。每拼接一次就会产生两个对象，对象的创建和消失都需要时间。

![image-20250802163518394](D:\软件工程\Java\java-basic\day08\assets\image-20250802163518394.png)

### 7、StringBuilder和StringBuffer的区别

- 相同：构造方法和成员方法一模一样

- 不同：
  - StringBuffer 是从 JDK 1.0版本出现的；StringBuilder是从 JDK 1.5版本出现的。
  - StringBuffer 是线程安全的可变字符序列，但是效率低；StringBuilder 的实例用于多个线程是不安全的，但是效率高。

​	