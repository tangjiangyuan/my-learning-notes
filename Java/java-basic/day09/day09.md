## day09、

## 一、集合基础

### 1、概念

​	集合是一个容器，用来装数据的，类似数组。

### 2、集合与数组的区别

- 数组定义完成并启动后，长度就固定了；
- 集合大小可变，开发中使用的更多。

### 3、ArrayList 集合

​	=== ArrayList 长度可变原理 ===

（1）当创建 ArrayList 集合容器的时候，底层会存在一个长度为10个大小的空数组。
（2）如果装不下，会自动扩容原数组 1.5 倍大小的新数组。
（3）将原数组数据，拷贝到新数组。
（4）将新元素添加到新数组。

![image-20250802170956894](D:\软件工程\Java\java-basic\day09\assets\image-20250802170956894.png)

### 4、集合与数组的使用选择

- 数组：存储的元素个数固定
- 集合：存储的元素个数经常发生改变

### 5、ArrayList 集合快速入门

=== 细节===

​	创建String、StringBuilder和ArrayList 类的对象，打印对象名，都没有看到地址值，而是元素内容。因为重写了toString()方法

#### 5.1、构造方法

```java
public ArrayList() : 创建一个空的集合容器
```

#### 5.2、集合容器的创建细节

```java
ArrayList list = new ArrayList();
现象 : 可以添加任意类型数据
弊端 : 数据不够严谨

ArrayList<String> list = new ArrayList<>();

<> : 泛型
        目前 : 使用泛型，可以对集合中存储的数据，进行类型限制
        细节 : 泛型中，不允许编写基本数据类型
        问题 : 想要在集合中，存储 整数、小数、字符。。。这些数据，应该怎么办？
        解决 : 使用基本数据类型，所对应的包装类

                byte            Byte
                short           Short
                int             Integer     ***
                long            Long
                float           Float
                double          Double
                boolean         Boolean
                char            Character   ***
                其实只要输入首字母大写即可。
```

#### 5.3、成员方法

```java
1. 增
public boolean add(E e) : 将指定的元素追加到此列表的末尾。
public void add(int index, E element) : 在此列表中的指定位置插入指定的元素。

2. 删
public E remove(int index) : 根据索引做删除，返回被删除的元素。
public boolean remove(Object o) : 根据元素做删除。

3. 改
public E set(int index, E element) : 修改指定索引位置，为对应的元素。返回被覆盖掉的元素。

------------------------------------------------------------------
以上方法，返回值通常不做接收

4. 查
public E get(int index) : 根据索引，获取元素
public int size() : 返回集合中，元素的个数
```



## 二、综合案例 --- 学生管理系统

![](D:\软件工程\Java\java-basic\day09\assets\image-20250802170614590.png)

```java
public class StudentTest {
  public static void main(String[] args) {
    new StudentService();
  }
}
```

```java
public class StudentService {

  ArrayList<Student> list = new ArrayList<>();
  Scanner sc = new Scanner(System.in);
  
  public StudentService() {
    startStudentSystem();
  }

  public void startStudentSystem() {

    list.add(new Student("001", "张三", 23, "2000-01-01"));
    list.add(new Student("002", "李四", 24, "2000-02-03"));
    list.add(new Student("003", "王五", 25, "2000-04-04"));

    while (true) {
      System.out.println("==========学生信息管理系统==========");
      System.out.println("1. 添加学生");
      System.out.println("2. 删除学生");
      System.out.println("3. 修改学生");
      System.out.println("4. 查看学生");
      System.out.println("5. 查询所有学生");
      System.out.println("6. 退出");
      System.out.println("请输入:");
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          addStu();
          break;
        case 2:
          deleteStu();
          break;
        case 3:
          setStu();
          break;
        case 4:
          queryStu();
          break;
        case 5:
          queryAllStus();
          break;
        case 6:
          System.out.println("感谢使用！");
          System.exit(0);
        default:
          System.out.println("输入错误，请重试！");
          break;
      }
    }
  }

  // 添加学生
  public void addStu() {
    System.out.println("请输入学生ID:");
    String inputId = sc.next();
    int index = queryById(inputId);
    if (index == -1) { // 表示该学生不存在，可以添加
      System.out.println("请输入姓名:");
      String inputName = sc.next();
      System.out.println("请输入年龄:");
      int inputAge = sc.nextInt();
      System.out.println("请输入生日:");
      String inputBirthday = sc.next();

      list.add(new Student(inputId, inputName, inputAge, inputBirthday));
      System.out.println("添加成功！");
    } else {
      System.out.println("该学生已存在，无法添加！");
    }
  }

  // 删除学生
  public void deleteStu() {
    System.out.println("请输入学生ID:");
    String inputId = sc.next();
    int index = queryById(inputId);
    if (index == -1) {
      System.out.println("该学生不存在，无法删除！");
    } else {
      list.remove(index);
      System.out.println("删除成功！");
    }
  }

  // 修改学生
  public void setStu() {
    System.out.println("请输入学生ID:");
    String inputId = sc.next();
    int index = queryById(inputId);
    if (index == -1) {
      System.out.println("该学生不存在！");
    } else {
      System.out.println("请输入姓名:");
      String inputName = sc.next();
      System.out.println("请输入年龄:");
      int inputAge = sc.nextInt();
      System.out.println("请输入生日:");
      String inputBirthday = sc.next();

      list.set(index, new Student(inputId, inputName, inputAge, inputBirthday));
      System.out.println("修改成功！");
    }
  }

  // 查看学生
  public void queryStu() {
    if (list.size() == 0) {
      System.out.println("请添加学生后，再查看！");
    } else {
      System.out.println("请输入学生ID:");
      String inputId = sc.next();
      int index = queryById(inputId);
      if (index == -1) {
        System.out.println("该学生不存在。");
      } else {
        Student stu = list.get(index);
        System.out.println(stu.getId() + "---" + stu.getName() + "---" + 
        stu.getAge() + "---" + stu.getBirthday());
        System.out.println("查询成功！");
      }
    }
  }

  // 查询所有学生
  public void queryAllStus() {
    if (list.size() == 0) {
      System.out.println("请添加学生后，再查看！");
    } else {
      for (Student stu : list) {
        System.out.println(stu.getId() + "---" + stu.getName() + "---" + 
        stu.getAge() + "---" + stu.getBirthday());
      }
      System.out.println("查询成功！");
    }
  }

  // 通过学号查找学生在集合的索引
  public int queryById(String id) {
    for (int i = 0; i < list.size(); i++) {
      Student stu = list.get(i);
      if (id.equals(stu.getId())) {
        return i;
      }
    }
    return -1;
  }
}
```

```java
public class Student {
  private String id;
  private String name;
  private Integer age;
  private String birthday;
  
  public Student() {
  }

  public Student(String id, String name, Integer age, String birthday) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.birthday = birthday;
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
  }
}
```

