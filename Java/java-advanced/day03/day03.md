## day03、

<img src="D:\软件工程\Java\java-advanced\day03\assets\image-20250802231144479.png" alt="image-20250802231144479" style="zoom:67%;" />

## 一、接口新特性

### 1、jdk8

```java
/*
jdk8的新特性 :
    1. 允许定义非抽象方法（默认、静态），需要加入default关键字
            - 作用 : 解决接口的升级问题
            - 注意事项 :
                    1. public 可以省略，但是default不能省略
                    2. 默认方法，实现类是允许重写的，但是需要去掉default关键字
                    3. 如果实现了多个接口，多个接口中存在相同的默认方法，实现类必须重写默认方法

    2. 允许定义静态方法
            - 理解 : 既然接口已经允许方法带有方法体了，干脆也放开静态方法，可以类名调用。
            - 注意事项 :
                1. public 可以省略，但是 static不能省略
                2. 接口中的静态方法，只允许接口名进行调用，不允许实现类通过对象调用
*/
```

### 2、jdk9

```java
// JDK9的新特性 : 允许定义私有方法
```

- 好处：提升代码复用性，减少冗余代码

<img src="D:\软件工程\Java\java-advanced\day03\assets\image-20250802232029295.png" alt="image-20250802232029295" style="zoom:67%;" />

<img src="D:\软件工程\Java\java-advanced\day03\assets\image-20250802232036180.png" alt="image-20250802232036180" style="zoom:67%;" />

## 二、代码块

### 1、介绍

​	使用{}括起来的代码被称为代码块

### 2、分类

```java
/*
分类 :
    1. 局部代码块
            位置：方法中的一对大括号中
            作用：限定变量的生命周期，提早释放内存

    2. 构造代码块（匿名代码块）
            位置：类中方法外的一对大括号
            特点：在创建对象，执行构造方法的时候，就会执行构造代码块（优先于构造方法执行）
            作用：将多个构造方法中，重复的代码，抽取到构造代码块中，从而提升代码的复用性
            注意：当调用子类空参时，一定会先执行父类的构造代码块和构造方法，然后再执行子类的构造构造代码块和构造方法

    3. 静态代码块
            位置：类中方法外的一对大括号，需要加入static关键字
            特点：随着类的加载而执行，因为类只加载一次，所以也就执行一次
            作用：对数据进行初始化
    4. 同步代码块

*/
```

## 三、内部类

### 1、介绍

​	内部类就是定义在一个类里面的类

```java
class Outer {
    // 内部类
    class Inner {
        
    }
}
```

### 2、创建对象的格式

```java
格式: 外部类名.内部类名 对象名 = new 外部类对象().new 内部类对象();
范例: Outer.Inner in = new Outer().new Inner();
```

### 3、成员访问细节

- 内部类中，访问外部类成员，直接访问，包括私有
- 外部类中，访问内部类，需要创建对象访问

### 4、面试题

![image-20250802232815740](D:\软件工程\Java\java-advanced\day03\assets\image-20250802232815740.png)

### 5、内部类的分类

#### 5.1、成员内部类（了解）

```java
// 类中方法外
```

#### 5.2、静态内部类（了解）

```java
/*
静态内部类：static 修饰的成员内部类
创建对象格式： 外部类名.内部类名 对象名 = new 外部类名.内部类对象();
范例：Outer.Inner in = new Outer.Inner();
*/
```

#### 5.3、局部内部类（了解）

#### 5.4、匿名内部类（掌握）

### 6、匿名内部类

#### 6.1、概述

​	匿名内部类本质上是一个特殊的局部内部类（定义在方法内部）

#### 6.2、前提

​	需要存在一个接口

#### 6.3、格式

```java
new 类名 / 接口名 () {

}
new 类名(){} : 代表继承这个类
new 接口名() {} : 代表实现这个接口（重写接口中的方法）
结论：匿名内部类可以使代码更加简洁，定义一个类的同时对其进行实例化
```

![image-20250802233604803](D:\软件工程\Java\java-advanced\day03\assets\image-20250802233604803.png)

#### 6.4、使用场景

​	形参类型是接口类型，调用方法时需要传入接口实现类对象的实参，这时有两种方法：

- 如果这个接口中的抽象方法较多时，直接写一个实现类；
- 如果这个接口中的抽象方法较少时，使用匿名内部类。

## 四、Lambda 表达式

### 1、概述

​	Lambda 表达式是 JDK8 之后出现的一种新语法形式。

### 2、作用

​	简化匿名内部类的代码写法。

### 3、简化格式

![image-20250802233904782](D:\软件工程\Java\java-advanced\day03\assets\image-20250802233904782.png)

### 4、注意事项

​	Lambda 表达式只能简化**函数式接口**的匿名内部类的写法形式。

=== 什么是函数式接口？

​	首先必须是接口，其次接口中有且只有一个抽象方法；可以通过@FunctionalInterface 注解来校验该接口是否是函数式接口。

### 5、省略写法

![image-20250802234203385](D:\软件工程\Java\java-advanced\day03\assets\image-20250802234203385.png)

### 6、Lambda表达式和匿名内部类的区别

| 比较         | 使用限制           | 实现原理不同                             |
| ------------ | ------------------ | ---------------------------------------- |
| 匿名内部类   | 可以操作类、接口   | 编译之后，产生一个单独的.class字节码文件 |
| Lambda表达式 | 只能操作函数式接口 | 编译之后，不会产生字节码文件             |



## 五、窗体、组件和时间

### 1、创建窗体对象

```java
public static void main(String[] args) {
    // 创建窗体对象
    JFrame frame = new JFrame();

    // 设置窗体大小
    frame.setSize(500, 700); // 单位是像素px

    // 修改窗体的关闭模式(默认情况下，点击窗体的关闭按钮并不会停止运行)
    // 在 WindowConstants.EXIT_ON_CLOSE 模式下，当窗体结束后，JAVA程序也会终止
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // 设置窗体的标题
    frame.setTitle("第一个窗体。。。");

    // 取消默认布局
    frame.setLayout(null);

    // 设置窗体可见 (一定要放最后！！！)
    frame.setVisible(true);
}
```



### 2、组件

#### 2.1、按钮组件（JButton）

（1）格式

![image-20250802234651605](D:\软件工程\Java\java-advanced\day03\assets\image-20250802234651605.png)

（2）如何获取面板对象？

![image-20250802234656768](D:\软件工程\Java\java-advanced\day03\assets\image-20250802234656768.png)

（3）小结

![image-20250802234756469](D:\软件工程\Java\java-advanced\day03\assets\image-20250802234756469.png)

#### 2.2、图标组件（JLabel）

（1）格式

![image-20250802234837465](D:\软件工程\Java\java-advanced\day03\assets\image-20250802234837465.png)

### 3、事件

#### 3.1、概念

​	事件是可以被组件识别的操作，当你对组件干了某件操作之后，就会执行对应的代码。

#### 3.2、相关概念

- 事件源：按钮、图片、窗体。。。
- 事件操作：鼠标点击，键盘按下。。。
- 绑定监听：当事件源上发生了事件操作，触发了某段代码

#### 3.3、ActionListener：对鼠标点击、空格做监听

![image-20250802235408376](D:\软件工程\Java\java-advanced\day03\assets\image-20250802235408376.png)

#### 3.4、KeyListener：键盘监听

```java
public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(600,600);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    frame.addKeyListener(new java.awt.event.KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            // (fn ctrl esc 上下左右) 监听不到
        }

        @Override
        public void keyPressed(KeyEvent e) { // 键盘按下时触发
            int keyCode = e.getKeyCode();
            if (keyCode == 37 || keyCode == 65) {
                System.out.println("左移动业务");
            } else if (keyCode == 38 || keyCode == 87) {
                System.out.println("上移动业务");
            } else if (keyCode == 39 || keyCode == 68) {
                System.out.println("右移动业务");
            } else if (keyCode == 40 || keyCode == 83) {
                System.out.println("下移动业务");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) { // 键盘释放时触发

        }
    });
    frame.setVisible(true);
}
```

=== Tips===

```java
/*
    焦点：程序的注意力集中在了某一个组件上
    注意：按钮组件比较特殊，在创建好之后，程序的焦点，默认就停留在按钮组件上面
            - 但按钮组件，其实不需要占用程序的焦点
            - 可以通过 setFocusable(false); 取消焦点
 */
```



## 六、适配器（Adapter）设计模式

### 1、设计模式

​		是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。使用设计模式是为了可重用代码、让代码更容易被他人理解、保证代码的可靠性、程序的重要性。

### 2、适配器设计模式的作用

​	解决**接口**和**接口实现类**之间的矛盾问题

### 3、实现步骤

（1）编写一个 xxxAdapter 类，实现对应接口

（2）重写内部所有抽象方法，但方法都是空实现

（3）让自己的类去继承适配器类，重写自己需要的方法即可

（4）为了避免其他类创建适配器类的对象，使用 abstract 进行修饰

![image-20250803000048633](D:\软件工程\Java\java-advanced\day03\assets\image-20250803000048633.png)

![image-20250803000055105](D:\软件工程\Java\java-advanced\day03\assets\image-20250803000055105.png)

## 七、模板（Template）设计模式

### 1、概念

​	把抽象类整体看做成一个模板，模板中不能决定的东西定义成抽象方法，让使用模板的类（继承抽象类）去重写抽象方法的实现需求。

### 2、小结

​	模板设计模式的优势：模板已经定义了通用结构，使用者只需要关心自己需要实现的功能即可。

![image-20250803000306723](D:\软件工程\Java\java-advanced\day03\assets\image-20250803000306723.png)

![image-20250803000311759](D:\软件工程\Java\java-advanced\day03\assets\image-20250803000311759.png)

![image-20250803000315422](D:\软件工程\Java\java-advanced\day03\assets\image-20250803000315422.png)