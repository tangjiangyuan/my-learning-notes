## day08、

<img src="D:\软件工程\Java\java-advanced\day08\assets\image-20250803153346392.png" alt="image-20250803153346392" style="zoom:67%;" />

## 一、递归

### 1、介绍

​	方法直接或间接调用本身。

### 2、注意事项

​	递归如果没有控制好终止，会出现递归死循环，导致**栈内存**出现溢出现象。

### 3、使用场景

​	一些算法题的实现，都需要使用递归。

### 4、使用递归求5的阶乘（factorial）

#### 4.1、内存图

![image-20250803234142732](D:\软件工程\Java\java-advanced\day08\assets\image-20250803234142732.png)

![image-20250803234148479](D:\软件工程\Java\java-advanced\day08\assets\image-20250803234148479.png)

#### 4.2、演示

```java
public static void main(String[] args) {
    int result = factorial(5);
    System.out.println(result);
}

public static int factorial(int num) {
    if (num >= 0 && num <= 1) {
      return 1;
    }
    return num * factorial(num - 1);
}
```



### 5、斐波那契数列（fibonacci）

#### 5.1、原理

![image-20250803234513742](D:\软件工程\Java\java-advanced\day08\assets\image-20250803234513742.png)

#### 5.2、演示

```java
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入:");
    int index = sc.nextInt();
    sc.close();
    int num = fibonacci(index);
    System.out.println("索引为:" + index + "的值是:" + num);
}

public static int fibonacci(int index) {
    if (index > 0 && index < 3) {
      return 1;
    } 
    return fibonacci(index - 1) + fibonacci(index - 2);
}
```



### 6、总结

![image-20250803235124279](D:\软件工程\Java\java-advanced\day08\assets\image-20250803235124279.png)

## 二、异常

### 1、介绍

​	指的是程序在编译或执行过程中，出现的非正常情况（错误）。

===注意===

​	语法错误，不是异常。

### 2、异常学什么？

#### 2.1、能看懂异常信息

```java
阅读异常信息：从下往上看
1. 找异常错误位置
2. 异常名称
3. 异常原因
```

#### 2.2、异常体系结构

![image-20250803235433499](D:\软件工程\Java\java-advanced\day08\assets\image-20250803235433499.png)

```java
/*
    编译时异常 ： 编译阶段就出现的错误 (语法错误不算)
                    - 需要在运行之前，给出解决方案
    运行时异常 ： 编译过了，运行期间 [可能会出现的错误]
 */
```



### 3、异常处理方式

#### 3.1、Java默认处理异常的流程

![image-20250803235504976](D:\软件工程\Java\java-advanced\day08\assets\image-20250803235504976.png)

#### 3.2、第一种方式

```java
try...catch 捕获异常
    好处 ： 异常对象可以被捕获，后续的代码可以继续执行
    格式 ：
        try {
            可能会出现异常的代码
        } catch(异常名称 对象名) {
            异常的处理方案
        }

    执行流程 ：
        1. 执行 try {} 中的代码，看是否有异常对象产生
        2. 没有 ： catch 就不会捕获，后续代码继续执行
        3. 有 ： catch 捕获异常对象，执行catch {} 中的处理方案，后续代码继续执行
```

===注意===

- 如果要捕获多个异常，最大的异常一定要放在最后；
- 子类不能抛出父类没有的异常，或者比父类大的异常。

#### 3.3、第二种方式

![image-20250804000107909](D:\软件工程\Java\java-advanced\day08\assets\image-20250804000107909.png)

#### 3.4、总结

![image-20250804000124944](D:\软件工程\Java\java-advanced\day08\assets\image-20250804000124944.png)

```java
问题 ： 正在面临的异常，是否需要暴露出来
        - 不需要暴露出来 ： try...catch 捕获
        - 需要暴露出来 ： throws 抛出异常

- 如果是别的程序员，调用我们所编写的方法时，在可能出错的地方，使用throws将异常抛出给调用者，告诉他为什么错了
- 如果是用户，在使用我们的程序时，不能将异常展现给用户，就要使用try...catch捕获异常
```



#### 3.5、throw 和 throws 的区别

![image-20250804000555689](D:\软件工程\Java\java-advanced\day08\assets\image-20250804000555689.png)

| 比较维度           | throw                                                        | throws                                                       |
| ------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **所在位置**       | **方法体内部**（必须跟一条语句）                             | **方法签名尾部**（形参列表之后）                             |
| **功能作用**       | **实际抛出**一个异常对象（生成并向外“扔”异常）               | **声明**该方法可能抛出的异常类型（告诉调用者需要处理）       |
| **语法形式**       | `throw new XxxException();`                                  | `返回类型 方法名(...) throws X1Exception, X2Exception { ... }` |
| **抛出异常个数**   | **一次只能抛一个**异常对象                                   | **可声明多个**异常类型，用逗号分隔                           |
| **异常类型范围**   | **只能抛出** `Throwable` 及其子类的**实例**                  | **可以声明** `Throwable` 及其子类的**类型**（包括受检 & 运行时） |
| **与异常分类关系** | <ul><li>运行时异常：编译器不强制处理</li><li>受检异常：所在方法必须捕获或在签名用 `throws` 继续声明</li></ul> | <ul><li>声明受检异常：调用方必须捕获或继续声明</li><li>声明运行时异常：仅作提示，调用方可不处理</li></ul> |
| **是否发生异常**   | 执行到 `throw` 时**一定产生**异常流程                        | 只是**可能性声明**，实际未必抛出                             |
| **示例代码**       | `throw new IOException("文件未找到");`                       | `public void read() throws IOException { ... }`              |

===简记===

​	**`throw`** 是“点火”（真正抛异常），**`throws`** 是“贴警示牌”（声明可能抛异常）。

### 4、自定义异常

#### 4.1、分类

（1）自定义编译时异常：创建一个类，继承Exception；

（2）自定义运行时异常：创建一个类，继承RunTimeException；

#### 4.2、自定义异常的必要性

- Java 无法为这个世界上全部的问题提供异常类。
- 如果企业想通过异常的方式来管理自己的某个业务问题，就需要定义异常类了。

#### 4.3、Throwable的常用方法

```java
public String getMessage() : 获取异常的错误原因
public void printStackTrace() : 展示完整的异常错误信息
```

### 5、练习

![image-20250804001117699](D:\软件工程\Java\java-advanced\day08\assets\image-20250804001117699.png)

```java
public class StudentTest {
  public static void main(String[] args) {
    new StudentService();
  }
}
```

```java
public class StudentService {

  Scanner sc = new Scanner(System.in);
  ArrayList<Student> list = new ArrayList<>();

  public StudentService() {
    addStuSystem();
    // System.out.println(list);
  }

  private void addStuSystem() {
    for (int i = 1; i <= 3; i++) {
      System.out.println("请输入第" + i + "名学生的姓名:");
      String inputName = sc.nextLine();
      
      Integer inputAge = initialValidDate("年龄", "请输入第" + i + "名学生的年龄:", 0, 120);
      Double mathScore = initialValidData("数学成绩", "请输入第" + i + "名学生的数学成绩:", 0.0, 100.0);
      Double chineseScore = initialValidData("语文成绩", "请输入第" + i + "名学生的语文成绩:", 0.0, 100.0);
      Double englishScore = initialValidData("英语成绩", "请输入第" + i + "名学生的英语成绩:", 0.0, 100.0);
      list.add(new Student(inputName, inputAge, mathScore, chineseScore, englishScore));
    }
  }

  private Integer initialValidDate(String type, String prompt, Integer min, Integer max) {
    while (true) {
      System.out.println(prompt);
      try {
        Integer ageInput = Integer.parseInt(sc.nextLine());
        if (ageInput < min || ageInput > max) {
          throw new AgeRangeException(type + "范围错误，应为:" + min + "~" + max + "之间。");
        }
        return ageInput;
      } catch (NumberFormatException e) {
        System.out.println(type + "类型错误，应为正数类型。");
      } catch (AgeRangeException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private Double initialValidData(String type, String prompt, Double min, Double max) {
    while (true) {
      System.out.println(prompt);
      try {
        Double score = Double.parseDouble(sc.nextLine());
        if (score < min || score > max) {
          throw new ScoreRangeException(type + "范围错误，应为:" + min + "~" + max + "之间。");
        }
        return score;
      } catch (NumberFormatException e) {
        System.out.println(type + "类型错误，应该是小数类型");
      } catch (ScoreRangeException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
```

```java
public class Student {
  private String name;
  private Integer age;
  private Double mathScore;
  private Double chineseScore;
  private Double englishScore;
  
  public Student() {
  }

  public Student(String name, Integer age, Double mathScore, Double chineseScore, Double englishScore) {
    this.name = name;
    this.age = age;
    this.mathScore = mathScore;
    this.chineseScore = chineseScore;
    this.englishScore = englishScore;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    if (age > 0 && age <= 120) {
      this.age = age;
    } else {
      throw new AgeRangeException("年龄范围错误，应为：0~120之间");
    }
  }

  public Double getMathScore() {
    return mathScore;
  }

  public void setMathScore(Double mathScore) {
    if (mathScore > 0 && mathScore <= 100) {
      this.mathScore = mathScore;
    } else {
      throw new ScoreRangeException("成绩范围错误，应为:0~100之间");
    }
  }

  public Double getChineseScore() {
    return chineseScore;
  }

  public void setChineseScore(Double chineseScore) {
    if (mathScore > 0 && mathScore <= 100) {
      this.chineseScore = chineseScore;
    } else {
      throw new ScoreRangeException("成绩范围错误，应为:0~100之间");
    }
  }

  public Double getEnglishScore() {
    return englishScore;
  }

  public void setEnglishScore(Double englishScore) {
    if (mathScore > 0 && mathScore <= 100) {
      this.englishScore = englishScore;
    } else {
      throw new ScoreRangeException("成绩范围错误，应为:0~100之间");
    }
  }

  @Override
  public String toString() {
    return "Student [name=" + name + ", age=" + age + ", mathScore=" + mathScore + ", chineseScore=" + chineseScore
        + ", englishScore=" + englishScore + "]";
  }
}
```

