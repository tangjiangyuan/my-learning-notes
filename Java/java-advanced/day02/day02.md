## day02、

<img src="D:\软件工程\Java\java-advanced\day02\assets\image-20250802210620699.png" alt="image-20250802210620699" style="zoom:67%;" />

## 一、包

![image-20250802210634338](D:\软件工程\Java\java-advanced\day02\assets\image-20250802210634338.png)

## 二、抽象类（Abstract）

### 1、介绍

​	抽象类是一种**特殊**的父类。

=== 特殊在哪？

​	内部允许编写抽象方法。

=== 什么是抽象方法？

​	当我们将共性的方法，抽取到父类之后，发现这个方法在父类中无法给出具体明确（描述不清），而且这个方法还是子类必须要有的方法，就可以设计为抽象方法。

### 2、抽象类和抽象方法的定义格式

```java
// 抽象方法的定义格式
public abstract 返回值类型 方法名(参数列表);
// 抽象类的定义格式
public abstract class 类名 {}
```

### 3、抽象类的注意事项

- 抽象类不能实例化（即不能创建对象）
  - 如果抽象类允许创建对象，就可以调用内部没有方法体的抽象方法了（无意义）
- 抽象类存在构造方法
- 抽象类中可存在普通方法
- 抽象类的子类要么重写抽象类中的所有抽象方法，要么也是抽象类；

### 4、abstract 关键字的冲突

- final ： 被 abstract 修饰的方法，强制要求子类重写，被 final 修饰的方法不能重写；
- private ： 被abstract 修饰的方法，强制要求子类重写，被 private 修饰的方法不能重写；
- static ： 被static修饰的方法可以通过类名调用，类名调用抽象方法没有意义。

## 三、接口（Interface）

### 1、介绍

​	体现的思想是对**[规则]**的声明，Java中的接口更多体现的是对行为的抽象。

### 2、定义格式

```java
interface 接口名 {}
// 注意：接口不允许实例化，接口和类之间是实现关系，通过implements关键字来完成。
```

### 3、实现方式

```java
class 类名 implements 接口名 { }

// 实现类（接口的子类）:
    1. 重写所有抽象方法
    2. 将实现类变成抽象类（用的少）
```

### 4、接口中的成员特点

- 成员变量：只能定义常量，因为系统会默认添加三个关键字（public static final）。这三个关键字没有顺序关系。
- 成员方法：只能定义抽象方法，因为系统会默认添加两个关键字（public abstract）。
- 构造方法：没有。

### 5、接口和类之间的各种关系

- 类和类之间：继承关系，只支持单继承，不支持多继承，但支持多层继承。
- 类和接口之间：实现关系，可以单实现，也可以多实现，甚至可以在继承一个类的同时，实现多个接口。

![image-20250802225306535](D:\软件工程\Java\java-advanced\day02\assets\image-20250802225306535.png)

- 接口和接口之间：继承关系，可以单继承，也可以多继承。

![image-20250802225349996](D:\软件工程\Java\java-advanced\day02\assets\image-20250802225349996.png)

### 6、抽象类和接口的对比

| 比较   | 构造方法 | 成员变量                     | 成员方法                             | 使用场景                 |
| ------ | -------- | ---------------------------- | ------------------------------------ | ------------------------ |
| 接口   | ×        | 只能定义常量                 | 只能定义抽象方法                     | 对行为抽象（制定规则）   |
| 抽象类 | √        | 可以定义变量，也可以定义常量 | 可以定义具体方法，也可以定义抽象方法 | 对事物做描述（描述事物） |



## 四、多态（Polymorphism）

### 1、介绍

​	同一种行为具有多个不同表现形式或形态的能力。

![image-20250802225914674](D:\软件工程\Java\java-advanced\day02\assets\image-20250802225914674.png)

### 2、前提

- 有继承/实现关系
- 有方法重写
- 有父类引用指向子类对象（或有接口指向实现类对象）

### 3、多态种类

（1）对象多态

​	方法形参是父类类型，调用方法时，可以传入父类的任意子类。

（2）行为多态

​	同一个方法，具有多种不同表现形式，或形态的能力。

### 4、多态的成员访问特点

```java
/*
多态的成员访问特点 :
1. 成员变量 : 编译看左边(父类)，运行看右边(父类)
2. 成员方法 : 编译看左边(父类)，运行看右边(子类)

        编译的时候，会检查父类中有没有这个方法
            没有 : 编译出错
            有 : 编译通过，但是运行的时候，一定会执行子类的方法逻辑

        原因 : 担心我们调用的方法，在父类中是一个抽象方法(没有方法体，无意义)。

--------------------------------------

多态创建对象，调用静态成员 :

    静态的成员，推荐使用类名进行调用
    细节 : 静态的成员，可以使用对象名调用，但这是一种假象
            - 生成字节码文件后，会自动将对象名调用，改为类名调用
*/
```

### 5、多态的好处和弊端

- 好处：提高了程序的扩展性
- 弊端：不能使用子类的特有的成员

### 6、多态的转型---多态弊端的解决方式

- 向上转型：父类引用指向子类对象
- 向下转向：将父类引用所指向的对象，转交给子类类型

![image-20250802230628106](D:\软件工程\Java\java-advanced\day02\assets\image-20250802230628106.png)

### 7、多态中的类型转换问题

![image-20250802230655318](D:\软件工程\Java\java-advanced\day02\assets\image-20250802230655318.png)

![image-20250802230701565](D:\软件工程\Java\java-advanced\day02\assets\image-20250802230701565.png)

![image-20250802230707756](D:\软件工程\Java\java-advanced\day02\assets\image-20250802230707756.png)

### 8、案例

案例一：国内外订单

```java
public class Test {
    /*
        ClassCastException : 类型转换异常

            在引用数据类型的强转中，[实际类型]和[目标类型]不匹配，就会出现此异常。
     */
    public static void main(String[] args) {

        OrderService orderService = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入 : 1. 国内订单       2. 国外订单");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                // 创建国内订单的业务
                orderService = new OrderServiceImpl();
                break;
            case 2:
                // 创建国外订单的业务
                orderService = new OverseasServiceImpl();
                break;
        }

        // instanceof : 判断左边的引用，是否是右边的数据类型
        if (orderService instanceof OverseasServiceImpl) {
            OverseasServiceImpl overseasService = (OverseasServiceImpl) orderService;// 向下转型
            overseasService.check();// 调用子类特有成员
        }

        orderService.create();
        orderService.findOne();
        orderService.findList();
        orderService.cancel();
        orderService.finish();
        orderService.paid();
    }
}
```

```java
public interface OrderService {

    /**
     * 创建订单
     */
    void create();

    /**
     * 查询单个订单
     */
    void findOne();

    /**
     * 查询订单列表
     */
    void findList();

    /**
     * 取消订单
     */
    void cancel();

    /**
     * 完成订单
     */
    void finish();

    /**
     * 支付订单
     */
    void paid();
}
```

```java
public class OrderServiceImpl implements OrderService{

    @Override
    public void create() {
        System.out.println("创建订单");
    }

    @Override
    public void findOne() {
        System.out.println("查询单个订单");
    }

    @Override
    public void findList() {
        System.out.println("查询订单列表");
    }

    @Override
    public void cancel() {
        System.out.println("取消订单");
    }

    @Override
    public void finish() {
        System.out.println("完成订单");
    }

    @Override
    public void paid() {
        System.out.println("支付订单");
    }
}
```

```java
public class OverseasServiceImpl implements OrderService{

    public void check() {
        System.out.println("检查IP地址");
    }

    @Override
    public void create() {
        System.out.println("海外业务---创建订单");
    }

    @Override
    public void findOne() {
        System.out.println("海外业务---查询单个订单");
    }

    @Override
    public void findList() {
        System.out.println("海外业务---查询订单列表");
    }

    @Override
    public void cancel() {
        System.out.println("海外业务---取消订单");
    }

    @Override
    public void finish() {
        System.out.println("海外业务---完成订单");
    }

    @Override
    public void paid() {
        System.out.println("海外业务---支付订单");
    }
}
```

案例二：模拟支付接口

![image-20250802230944613](D:\软件工程\Java\java-advanced\day02\assets\image-20250802230944613.png)

```java
public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Paid paid = null;

        System.out.println("请选择支付方式: 1. 支付平台支付  2. 银行卡网银支付  3. 信用卡快捷支付");
        System.out.println("请输入您的支付方式:");
        int choice = sc.nextInt();
        System.out.println("请输入您的支付金额:");
        double payMoney = sc.nextDouble();

        switch (choice) {
            case 1:
                paid = new PaymentPlatformsImpl();
                break;
            case 2:
                paid = new BankCardImpl();
                break;
            case 3:
                paid = new CreditCardImpl();
                break;
        }

        paid.paid(payMoney);

    }
}
```

```java
public interface Paid {

    /**
     * 支付功能
     */
    void paid(double money);
}
```

```java
public class BankCardImpl implements Paid{

    @Override
    public void paid(double money) {
        System.out.println("通过银行卡网银支付了:" + money + "元！");
    }
}
```

