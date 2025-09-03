## day07、

<img src="D:\软件工程\Java\java-basic\day07\assets\image-20250802142435090.png" alt="image-20250802142435090" style="zoom: 67%;" />

## 一、面向对象

### 1、介绍

面向对象并不是一种技术，而是一种**编程的指导思想**。

以什么形式，组织代码；以什么思路，解决问题。

### 2、为什么要学习面向对象？

因为在生活中，当我们遇到问题时，就是采用这种思想去解决问题的。所以，当我们写程序去解决问题时，如果也能采用这种指导思想，就会使编程变得非常简单，程序也便于人理解。

### 3、面向对象，重点学什么？

- 学习自己如何设计对象
- 学习如何使用已有对象

## 二、类和对象

### 1、类

Java中想要创建对象，就必须先要有类的存在。

概念：指的是一组相关属性和行为的集合，类是对象的设计图。

本质：就是对事物的描述。

### 2、对象

概念：是根据设计图（类），创建出来的实体。

### 3、类和对象的关系

- 依赖关系：Java中需要根据类，创建对象。
- 数量关系：一个类，可以创建出多个对象。

### 4、类的组成

#### 4.1、属性

成员变量：根之前定义变量的格式一样，只不过位置放在了方法的外面。

#### 4.2、行为

成员方法：跟之前定义方法的格式一样，只不过需要去掉static关键字。

### 5、创建对象的格式

```java
/*
 	创建Student类的对象进行使用
        1. 创建对象的格式
            类名 对象名 = new 类名();
        2. 使用对象成员变量的格式
            对象名.成员变量名;
        3. 使用对象成员方法的格式
            对象名.成员方法名();
        ----------------------------------
    细节：
        1. 打印对象名，可以看到对象的内存地址
                com.javalearn.oop.Student@6504e3b2
                全类名 : 包名 + 类名
        2. 成员变量就算没有赋值，也可以直接使用，使用的是对象的默认值
     */
```

## 三、对象内存图

### 1、单个对象内存图

![image-20250802144223895](D:\软件工程\Java\java-basic\day07\assets\image-20250802144223895.png)

​		首先，StudentTest类的字节码文件进入方法区。然后使用了Student类，Student类的字节码文件进入方法区。接着new了一个Student对象，有new进堆内存，开辟一个空间产生地址值，并将这个地址值传给stu变量。通过地址值去堆内存中找对应的数据，开始时并不会直接将方法放入堆内存，而是给方法一个地址值；调用方法时堆内存去方法区的字节码文件找方法，然后传给堆内存的地址。

### 2、两个对象内存图

![image-20250802144352816](D:\软件工程\Java\java-basic\day07\assets\image-20250802144352816.png)

### 3、两个引用指向相同的内存图

![image-20250802144359339](D:\软件工程\Java\java-basic\day07\assets\image-20250802144359339.png)

## 四、成员变量和局部变量

| 区别         | 成员变量                                   | 局部变量                                       |
| ------------ | ------------------------------------------ | ---------------------------------------------- |
| 类中位置不同 | 方法外                                     | 方法内                                         |
| 初始化值不同 | 有默认值                                   | 没有，使用之前必须完成赋值                     |
| 内存空间不同 | 堆内存                                     | 栈内存                                         |
| 生命周期不同 | 随着对象的创建而存在，随着对象的消失而消失 | 随着方法的调用而存在，随着方法的运行结束而消失 |
| 作用域       | 在自己所属的大括号内                       | 在自己所属的大括号内                           |

## 五、this 关键字

### 1、this 关键解决的问题

​		当局部变量和成员变量重名的时候，Java使用的是就近原则。如果想要使用成员变量，就可以使用this关键字。

​		即 this关键字可以解决局部变量和成员变量重名的问题。

### 2、作用

​		可以调用当前类的成员

### 3、省略规则

​		本类成员变量：没有重名的情况可以省略；

​		本类成员方法：没有前提条件，可以省略。

### 4、介绍

​		-- 代表当前类对象的引用（地址）。哪个对象调用方法，方法中的this，代表的就是哪个对象。

​		stu1.print() ---> this ---> stu1的地址

​		stu2.print() ---> this ---> stu2的地址

### 5、内存图

![image-20250802145205180](D:\软件工程\Java\java-basic\day07\assets\image-20250802145205180.png)

### 6、小结

![image-20250802145220339](D:\软件工程\Java\java-basic\day07\assets\image-20250802145220339.png)

## 六、构造方法

### 1、构造器

​		初始化一个新建的对象，构建、创造对象的时候，所调用的方法。

### 2、格式

- 方法名与类名一致，大小写也一致；
- 没有返回值类型，连void也没有；
- 没有具体的返回值，不能由return带回数据。

### 3、执行时机

- 在创建对象的时候，就被调用执行；
- 每创建一次对象，就会执行一次构造方法。

### 4、作用

- 本质作用：创建对象。
- 结合执行时机：可以在创建对象的时候，给对象中的成员变量初始化。

### 5、注意事项

- 一个类中，如果没有编写构造方法，系统会提供一个**默认**的、**无参**的构造方法；
- 一个类中，如果手动编写了构造方法，系统就不会提供哪个默认的无参构造方法了；
- 构造方法不允许手动调用。
- ![image-20250802145836433](D:\软件工程\Java\java-basic\day07\assets\image-20250802145836433.png)

## 七、封装（Encapsulation）

### 1、面向对象三大特征

​		继承、封装、多态

### 2、封装介绍

​		使用类设计对象时，将需要处理的数据，以及处理这些数据的方法，设计到对象中。

### 3、优点

- 更好地维护数据；
- 使用者无须关系内部实现，只需要知道如何使用即可。

### 4、设计规范

- 合理隐藏、合理暴露

### 5、权限修饰符

| 权限修饰符    | 同一个类 | 同一个包 (非子类) | 不同包的子类 | 不同包的非子类 |
| ------------- | -------- | ----------------- | ------------ | -------------- |
| **public**    | ✅        | ✅                 | ✅            | ✅              |
| **protected** | ✅        | ✅                 | ✅            | ❌              |
| **(default)** | ✅        | ✅                 | ❌            | ❌              |
| **private**   | ✅        | ❌                 | ❌            | ❌              |

### 6、标准JavaBean

- JavaBean ：实体类：封装数据的类（例如Student、Book、Phone）
- 标准 JavaBean ：
  - 这个类中的成员都要私有，并且对外提供相应的getXxx和setXxx方法；
  - 类中提供无参和带参构造方法。

=== 扩展 ptg插件 --- ctrl + shift + 逗号

​		快捷生成无参、带参、getXxx和setXxx

![image-20250802150522149](D:\软件工程\Java\java-basic\day07\assets\image-20250802150522149.png)

<img src="D:\软件工程\Java\java-basic\day07\assets\image-20250802150529539.png" alt="image-20250802150529539" style="zoom:67%;" />

=== 问题：实体类的使用场景？

​	实体类只负责数据存储，而对数据的处理交给其它类来完成，以实现数据和数据业务相分离。

## 八、练习

练习一：

```java
/*
    练习 --- 类的定义与对象的创建和使用
    编写一个图书类（Book）
        属性 : 编号（id），书名（name），价格（price）
        行为 : 展示（show）
                该方法中需要展示出图书的所有属性信息

    编写一个图书测试类（BookTest）
        创建3个图书对象，分别赋值位
            (001,三国,88.88)
            (002,水浒,88.88)
            (003,富婆通讯录,10000)
        调用3个对象，各自的show方法展示属性信息
 */
```

```java
public class Book {
  private String id;
  private String name;
  private Double price;
  
  public Book() {
  }

  public Book(String id, String name, Double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public void show() {
    System.out.println("(" + id + "," + name + "," + price + ")");
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
  }
}
```

```java
public class BookTest {
  public static void main(String[] args) {
    Book book1 = new Book("001", "三国", 88.88);
    Book book2 = new Book("002", "水浒", 88.88);
    Book book3 = new Book("003", "富婆通讯录", 10000.0);

    book1.show();
    book2.show();
    book3.show();
  }
}
```

练习二、

```java
/*
    练习 -- 类的定义与对象的创建和使用
    定义一个手机类（Phone）
        属性:(品牌 brand，颜色 color，价格 price)
        行为:
            打电话（call）
                - 输出给xxx打电话
            发短信（sendMessage）
                - 输出群发消息
    编写一个手机测试类（PhoneTest）
        创建两个手机对象，并给属性赋值
            1. 小米，白色，4999
            2. 华为，黑色，6999
        赋值后，校验自己有没有赋值成功，使用打印语句校验，调用两个对象各自的成员方法
 */
```

```java
public class Phone {
  private String brand;
  private String color;
  private Double price;
  
  public Phone() {
  }

  public Phone(String brand, String color, Double price) {
    this.brand = brand;
    this.color = color;
    this.price = price;
  }

  public void call(String name) {
    System.out.println("给" + name + "打电话。");
  }

  public void sendMsg() {
    System.out.println("hello!");
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Phone [brand=" + brand + ", color=" + color + ", price=" + price + "]";
  }
}
```

```java
public class PhoneTest {
  public static void main(String[] args) {
    Phone phone1 = new Phone("小米", "白色", 4999.0);
    Phone phone2 = new Phone("华为", "黑色", 6999.0);

    phone1.call("张三");
    phone2.call("李四");
    phone1.sendMsg();
  }
}
```

## 九、案例

![image-20250802151928319](D:\软件工程\Java\java-basic\day07\assets\image-20250802151928319.png)

```java
/*
    需求 ：
    1. 展示系统中的全部电影（每部电影展示：名称、评分）。
    2. 允许用户根据电影编号（id）查询出某个电影的详细信息。
 */
```

```java
public class Movie {
  private Integer id; // 编号
  private String name; // 片名
  private String year; // 日期
  private Double score; // 评分
  private String area; // 地区
  private String type; // 类型
  private String director; // 导演
  private String starring; // 主演
  
  public Movie() {
  }

  public Movie(Integer id, String name, String year, Double score, String area, String type, String director,
      String starring) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.score = score;
    this.area = area;
    this.type = type;
    this.director = director;
    this.starring = starring;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Movie [id=" + id + ", name=" + name + ", year=" + year + ", score=" + score + ", area=" + area + ", type="
        + type + ", director=" + director + ", starring=" + starring + "]";
  }
}
```

```java
public class MovieService {

  Movie[] movies;
  Scanner sc = new Scanner(System.in);

  public MovieService(Movie[] movies) {
    this.movies = movies;
  }

  public void startMovieSystem() {
    while (true) {
      System.out.println("==========电影信息系统==========");
      System.out.println("1. 查询全部电影信息");
      System.out.println("2. 根据id查询电影信息");
      System.out.println("3. 退出");
      System.out.println("请输入:");
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          queryAllInfosOfMovie();
          break;
        case 2:
          queryInfosById();
          break;
        case 3:
          System.out.println("感谢使用！");
          System.exit(0);
        default:
          System.out.println("输入错误！");
          break;
      }
    }
  }

  public void queryAllInfosOfMovie() {
    for (int i = 0; i < movies.length; i++) {
      Movie movie = movies[i];
      System.out.println(movie.getName() + "---" + movie.getScore());
    }
  }

  public void queryInfosById() {
    System.out.println("请输入电影的id:");
    int inputId = sc.nextInt();
    for (int i = 0; i < movies.length; i++) {
      Movie movie = movies[i];
      if (movie.getId() == inputId) {
        System.out.println(movie.getId() + "---" + movie.getName() + "---" +
            movie.getYear() + "---" + movie.getScore() + "---" + movie.getArea() + "---" +
            movie.getType() + "---" + movie.getDirector() + "---" + movie.getStarring());
        return;
      }
    }
    System.out.println("抱歉，没有该电影信息！");
  }
}
```

```java
public class MovieTest {
  public static void main(String[] args) {
    Movie movie1 = new Movie(1, "东八区的先生们", "2022", 2.1, "中国大陆", "剧情 喜剧", "夏睿", "张翰 王晓晨");
    Movie movie2 = new Movie(2, "上海堡垒", "2019", 2.9, "中国大陆", "爱情 战争 科幻", "滕化涛", "鹿晗 舒淇");
    Movie movie3 = new Movie(3, "纯洁心灵·逐梦演艺圈", "2015", 2.2, "中国大陆", "剧情 喜剧", "毕志飞", "朱一文 李彦漫");
    
    Movie[] movies = {movie1, movie2, movie3};
    MovieService movieService = new MovieService(movies);
    movieService.startMovieSystem();
  }
}
```

