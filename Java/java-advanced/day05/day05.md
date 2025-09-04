## day05、常见API

<img src="D:\软件工程\Java\java-advanced\day05\assets\image-20250803000906642.png" alt="image-20250803000906642" style="zoom:67%;" />

## 一、Object 类

### 1、介绍

​	所有类，都直接或间接的继承了Object类（祖宗类）；Object类的方法是一切子类都可以直接使用的，所以我们要学习Object类的方法。

### 2、成员方法

#### 2.1、toString()

```java
/*
public String toString()  返回对象的字符串表示形式。

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    getClass().getName() : 类名称，全类名(包名 + 类名)
    Integer.toHexString() : 转十六进制
    hashCode() : 返回的是对象的内存地址 + 哈希算法，算出来的整数(哈希值)
  ----------------------------------------------------------------
  细节 : 使用打印语句，打印对象名的时候，println方法，源码层面，会自动调用toString方法。

  public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
  }
*/
```

![image-20250803001328877](D:\软件工程\Java\java-advanced\day05\assets\image-20250803001328877.png)

#### 2.2、equals()

```java
/*
Object 类中的 equals()方法 :
    boolean equals(Object obj) 指示一些其他对象是否等于此。

    public boolean equals(Object obj) {
        // this : stu1
        // obj : stu2
        return (this == obj);
    }

    结论 : Object类中的equals方法，默认比较的是对象内存地址
        - 通常会重写 equals方法，让对象之间，比较内容
*/
```

（1）重写方式一：

```java
@Override
public boolean equals(Object obj) {
    if (obj instanceof Student) {
        // this : 发起比较的对象
        // obj : 被计较的对象
        // 向下转型的目的，是为了调用子类特有的成员
        Student stu = (Student) obj;
        // return this.age == obj.age
        return age == stu.age && name.equals(stu.name);
    } else {
        return false;
    }
}
```

（2）重写方法二：

```java
@Override
public boolean equals(Object o) {
    // 两个对象做地址值的比较，如果地址值相同，里面的内容也肯定相同，直接返回true
    if (this == o) return true;

    // 代码要是能够走到这里，代表地址值肯定不相同
    // 代码要是能够走到这里，代表stu1，肯定不是null，否则会产生 空指针异常
    // stu1不是null，stu2是null，就直接返回false

    // this.getClass() != o.getClass() : 两个对象的字节码是否相同
    // 如果字节码不相同，就意味着类型不同，直接返回false
    if (o == null || getClass() != o.getClass()) return false;

    // 代码要是走到这里，代表字节码相同，类型肯定相同。
    // 向下转型
    Student student = (Student) o;
    // 比较
    return age == student.age && Objects.equals(name, student.name);
}
```

### 3、Objects 类

#### 3.1、常用成员方法

![image-20250803002138600](D:\软件工程\Java\java-advanced\day05\assets\image-20250803002138600.png)

#### 3.2、equals(Object a, Object b)

```java
/*
public static boolean equals(Object a, Object b) {
    return (a == b) || (a != null && a.equals(b));
}
--------------------------------------------------------------
    a == b : 如果地址值相同，则返回true，短路 || 后面的判断就不执行了
           : 如果地址值不相同，则返回false，短路 || 后面的判断继续执行
 --------------------------------------------------------------
    a != null : 假设 a 是 null 值
            null != null : false
            && : 左边为false，右边不执行，记录着null值的a，就不会调用equals方法
                    - 避免空指针异常
 --------------------------------------------------------------
    a != null : 假设 a 不是 null 值

            stu1 != null : true
            && : 左边为true，右边继续执行，a.equals(b)，这里就不会出现空指针异常
 --------------------------------------------------------------
*/
```

3.3、isNull(Object obj) 

​	判断参数是否为空。

![image-20250803002406445](D:\软件工程\Java\java-advanced\day05\assets\image-20250803002406445.png)

## 二、Math 类

### 1、介绍

​	包含执行基本数字运算的方法。

### 2、成员方法

```java
/*
Math 静态类: 包含执行基本数字运算的方法
------------------------------------------------------------------
public static int abs(int a) : 获取参数绝对值
public static double ceil(double a) : 向上取整
public static double floor(double a) : 向下取整
public static int round(float a) : 四舍五入
public static int max(int a, int b) : 获取两个int值中的最大值
public static double pow(double a, double b) : 返回a的b次幂的值
public static double random() : 返回值为double的随机值，范围[0.0, 1.0) 无限接近 1
------------------------------------------------------------------
*/
```



## 三、System 类

### 1、介绍

​	System的功能是静态的，都是直接用类名调用即可。

### 2、成员方法

```java
/*
1. public static void exit(int status) : 终止当前运行的 JAVA虚拟机，非零表示异常终止
2. public static long currentTimeMillis() : 返回当前系统的时间毫秒值形式
   - 返回 1970年1月1日，0时0分0秒(c语言生日)，到现在所经历过的毫秒值
3. public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) : 拷贝数据
    
            1. Object src : 数据源数组
            2. int srcPos : 起始索引
            3. Object dest : 目的地数组
            4. int destPos : 起始索引
            5. int length : 拷贝个数
*/
```

```java
public static void main(String[] args) {

    //  3. public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) : 拷贝数据
    int[] arr = {11, 22, 33, 44, 55};
    int[] destArr = new int[3];

    System.arraycopy(arr, 2, destArr, 0, 3);

    for (int i = 0; i < destArr.length; i++) {
        System.out.println(destArr[i]);
    }
}
```



## 四、BigDecimal 类

### 1、介绍

​	用于解决小数运算中，出现的不精确问题

### 2、构造方法

```java
public BigDecimal(double val) : 不推荐，无法保证小数运算的精确
public BigDecimal(String val)
public static BigDecimal valueOf(double val)
```

### 3、成员方法

```java
public BigDecimal add(BigDecimal b) : 加法
public BigDecimal subtract(BigDecimal b) : 减法
public BigDecimal multiply(BigDecimal b) : 乘法
public BigDecimal divide(BigDecimal b) : 除法
public BigDecimal divide(另一个BigDecimal对象，精确几位，舍入模式) : 除法
// 注意 : 如果使用BigDecimal运算，出现了除不尽的情况，就会出现异常
```

```java
public static void main(String[] args) {

    double num1 = 0.1;
    double num2 = 0.2;
    // System.out.println(num1 + num2); // 0.30000000000000004

    BigDecimal bd1 = BigDecimal.valueOf(10.0);
    BigDecimal bd2 = BigDecimal.valueOf(3.0);
    System.out.println(bd1.divide(bd2, 2, RoundingMode.HALF_UP)); // 四舍五入
    System.out.println(bd1.divide(bd2, 2, RoundingMode.UP)); // + 1
    System.out.println(bd1.divide(bd2, 2, RoundingMode.DOWN)); // 截取，即小数点后两位的数据都不要了

    System.out.println("-------------------------------------");

    BigDecimal result = bd1.divide(bd2, 2, RoundingMode.HALF_UP);
    double v = result.doubleValue();
    Math.abs(v);
}
```

=== doubleValue() 将BigDecimal 的值的类型转换为 double类型，其它类型同理。

## 五、包装类

### 1、介绍

​	将基本数据类型，包装成类（变成引用数据类型）

​	好处：变成类，就可以创建对象了，对象就可以调用方法方便的解决问题了。

### 2、常用包装类

![image-20250803003551400](D:\软件工程\Java\java-advanced\day05\assets\image-20250803003551400.png)

### 3、Integer 类

```java
手动装箱 : 调用方法，手动将基本数据类型，包装成类
public Integer(int value) : 通过构造方法(已过时，不推荐)
public static Integer valueOf(int i) : 通过静态方法

手动拆箱 : 调用方法，手动将包装类，拆成（转换为）基本数据类型
public int intValue() : 以 int 类型返回该 Integer的值
```

```java
JDK5版本开始，出现了自动拆装箱 :
1. 自动装箱 : 可以将基本数据类型，直接赋值给包装类的变量 valueOf()
2. 自动拆箱 : 可以将包装类的数据，直接赋值给基本数据类型的变量 inValue()

结论 : 基本数据类型，和对应的包装类，可以直接做运算了，不需要操心转换的问题了
```

```java
public static void main(String[] args) {
    int num = 10;
    Integer i1 = Integer.valueOf(num);
    int num_i = i1.intValue();

    System.out.println("--------------------");

    int num2 = 10;
    Integer i2 = num2;
    int  num_i2 = i2;
}
```

### 4、Integer 常用成员方法

```java
public static String toBinaryString(int i)  : 转二进制
public static String toOctalString(int i)   : 转八进制
public static String toHexString(int i)     : 转十六进制
public static int parseInt(String s)        : 将数字字符串，转换为数字(重点掌握)
```

```java
public static void main(String[] args) {
    int num1 = 120;
    String s = "123";
    System.out.println(Integer.toBinaryString(num1));
    System.out.println(Integer.toOctalString(num1));
    System.out.println(Integer.toHexString(num1));

    int i = Integer.parseInt(s);
    System.out.println(i);
    System.out.println(Double.parseDouble(s) + 100.0);

}
```

### 5、练习

![image-20250803004207497](D:\软件工程\Java\java-advanced\day05\assets\image-20250803004207497.png)

![image-20250803004201691](D:\软件工程\Java\java-advanced\day05\assets\image-20250803004201691.png)

### 6、面试题

![image-20250803004218998](D:\软件工程\Java\java-advanced\day05\assets\image-20250803004218998.png)

```java
/*
自动装箱的时候，如果装箱的数据范围是 [-128,127]， “==” 号比较的结果是true，反之都是false
------------------------------------------------------------------
自动装箱的原理 : 自动帮我们调用了 Integer.valueOf(127);

    public static Integer valueOf(int i) {
        if (i >= -128 && i <= 127) {
            return IntegerCache.cache[i + (-IntegerCache.low)];
        }
        return new Integer(i);
    }

如果装箱的数据，不在 -128~127 之间，会重新创建新的对象；
如果装箱的数据，在 -128~127 之间，不会创建新的对象，而是从底层的数组中，取出一个提前创建好的Integer对象返回。
    -Integer类中，底层存在一个长度为 256的数组，Integer[] cache
            在数组中，存储了256个Integer对象，分别是 -128~127
*/
```

