## day04、

![image-20250801230654700](D:\软件工程\Java\java-basic\day04\assets\image-20250801230654700.png)

## 一、流程控制语句

### 1、介绍

通过一些语句，来控制程序的执行流程。

### 2、分类

- 顺序结构：Java程序默认的执行流程，没有特定的语法结构，按照代码的先后顺序，依次执行。程序中大多数代码都是这样执行的。
- 分支结构：if语句、switch语句
- 循环语句：for循环、while循环、do...while循环

## 二、分支语句

### 1、if 语句

#### 1.1、第一种格式

![image-20250801231206481](D:\软件工程\Java\java-basic\day04\assets\image-20250801231206481.png)

=== 执行流程：

① 首先计算判断条件的结果

② 如果条件的结果为 true 就执行语句体

③ 如果条件的结果为 false 就不执行语句体

#### 1.2、第二种格式

![image-20250801231241301](D:\软件工程\Java\java-basic\day04\assets\image-20250801231241301.png)

=== 执行流程：

① 首先计算判断语句的结果

② 如果结果为 true 就执行语句1

③ 如果结果为 false 就执行语句2

#### 1.3、第三种格式

![image-20250801231302606](D:\软件工程\Java\java-basic\day04\assets\image-20250801231302606.png)

=== 执行流程：

① 首先计算判断条件1的值

② 如果值为true就执行语句体1；如果值为false就计算判断条件2的值

③ 如果值为true就执行语句体2；如果值为false就计算判断条件3的值

④ 。。。

⑤ 如果没有任何判断条件为true，就执行语句体n+1。

#### 1.4、案例

```java
/*
    案例：考试奖励
    需求：键盘录入考试成绩，根据成绩所在的区间，程序打印出不同的奖励机制
    95~100：一辆自行车
    90~94：游乐园
    80~89：变形金刚一个
    80以下：挨打
 */
```

```java
public class Test02 {
  public static void main(String[] args) {
    getAward();
  }

  public static void getAward() {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入您的分数:");
    double score = sc.nextDouble();

    if (score >= 95 && score <= 100) {
      System.out.println("奖励一辆自行车");
    } else if (score >= 90 && score <= 94) {
      System.out.println("奖励去一次游乐园");
    } else if (score >= 80 && score <= 89) {
      System.out.println("奖励一个变形金刚");
    } else {
      System.out.println("挨打");
    }
    sc.close();
  }
}
```

### 2、switch语句

#### 2.1、格式

![image-20250801231407653](D:\软件工程\Java\java-basic\day04\assets\image-20250801231407653.png)

#### 2.2、注意事项

（1）case 后面的值不允许重复；

（2） case 后面的值，只能是字面量，不能是变量；

（3）switch () 中可以接收的类型：

​	基本数据类型：byte、short、int、char；

​	引用数据类型：**jdk5**版本开始可以是**枚举**；**jdk7**版本开始可以是**String字符串**；**jdk14**版本开始，case后面允许编写多个数据，多个数据中间使用逗号分隔。

（4）case 穿透现象：即没写break（也可以避免编写重复代码）

![image-20250801231602387](D:\软件工程\Java\java-basic\day04\assets\image-20250801231602387.png)

=== jdk14版本开始：

![image-20250801231620055](D:\软件工程\Java\java-basic\day04\assets\image-20250801231620055.png)

### 3、if语句和switch语句的使用场景

- if 语句：适用于**范围性**的判断
- switch语句：使用与**固定值**的匹配

## 三、循环语句

### 1、for循环

#### 1.1、格式

![image-20250801231853733](D:\软件工程\Java\java-basic\day04\assets\image-20250801231853733.png)

#### 1.2、注意事项

（1）for循环 {} 中定义的变量，在**每一轮循环**结束后，都会从内存中释放。

（2） for循环 () 中定义的变量，在**整个循环**结束后，会从内存中释放。

（3）for循环 () 和 {} 之间，不能写 " ; "。

#### 1.3、嵌套循环

循环嵌套：在循环语句中，继续出现循环语句。

=== 扩展

```java
System.out.println(); // 打印数据后，自动换行

System.out.print(); // 打印数据后，不换行
```

1.4、案例

```java
// 案例：水仙花数
/*
 *  需求：在控制台输出所有的“水仙花数”
 *  什么是“水仙花数”？
 *  ① 水仙花数是一个三位数
 *  ② 水仙花的个位、十位、百位数字的立方和等于原数
 * */
```

```java
public class Test03 {
  public static void main(String[] args) {
    printNumbers();
  }
  public static void printNumbers() {
    for (int i = 100; i <= 999; i++) {
      int ge = i % 10;
      int shi = i / 10 % 10;
      int bai = i / 100;
      if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
        System.out.println("水仙花数:" + i);
      }
    }
  }
}
```

### 2、while循环

#### 2.1、格式

![image-20250801232122843](D:\软件工程\Java\java-basic\day04\assets\image-20250801232122843.png)

### 3、do...while循环

#### 3.1、格式

![image-20250801232142655](D:\软件工程\Java\java-basic\day04\assets\image-20250801232142655.png)

#### 3.2、特点

无论判断条件是否满足，都至少执行一次循环体。

### 4、三种循环语句的区别

（1）for循环和while循环（先判断再执行）

​		do...while循环（先执行再判断）

（2）for循环和while循环的区别：

- for循环中，控制循环的那个变量，在for循环结束后，就不能再次被访问到了；

- while循环中，控制循环的那个变量，在while循环结束后，该变量还能继续使用。

### 5、跳转控制语句

#### 5.1、break 语句

介绍：结束循环，结束 switch语句

注意事项：只能在循环中，或者是switch语句中进行使用。

#### 5.2、continue 语句

介绍：用来跳过本次循环，进入下一次循环。

注意事项：只能用在循环中。

=== return、break、continue共同注意事项：下面不允许写代码，因为执行不到，属于无效代码。

### 6、无限循环-死循环

```java
for(;;) {}
while(true) {} // 推荐
do {} while(true)
```

=== 扩展：标号 --- 给循环起名字

![image-20250801233058681](D:\软件工程\Java\java-basic\day04\assets\image-20250801233058681.png)

## 四、Random 随机数

### 1、格式

```java
public class RandomDemo01 {
    // 产生随机数 random
    public static void main(String[] args) {
        randomTest();
    }

    public static void randomTest() {

        Random r = new Random();

        int num1  = r.nextInt(100); // 生成一个 0~99 之间的随机数
        System.out.println(num1);
        int num2 = r.nextInt(100) + 1; // 生成一个 1~100 之间的随机数
        System.out.println(num2);

        System.out.println("----------------------------------");

        // 需求 ： 产生 20~80之间的随机数
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(61)+20;
            int n1 = r.nextInt(80 - 20 + 1) + 20;
            System.out.println(num);
            System.out.println(n1);
        }
    }
}
```

### 2、案例：猜数字小游戏

```java
public class Test04 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    int targetNum = random.nextInt(100) + 1;

    while (true) {
      System.out.println("请输入:");
      int guessNum = sc.nextInt();

      if (guessNum > targetNum) {
        System.out.println("猜大了");
      } else if (guessNum < targetNum) {
        System.out.println("猜小了");
      } else {
        System.out.println("恭喜你，猜对了");
        sc.close();
        System.exit(0);
      }
    }
  }
}
```

