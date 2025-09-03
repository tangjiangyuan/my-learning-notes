## day05、

<img src="D:\软件工程\Java\java-basic\day05\assets\image-20250801235722800.png" alt="image-20250801235722800" style="zoom:67%;" />

## 一、一维数组

### 1、介绍

数组：指的是一种容器，可以用来存储同种数据类型的多个值。

使用场景：发现手里的数据有多个，并且这多个数据还属于同一组数据，就可以考虑使用数组容器进行维护。

### 2、数组初始化

#### 2.1、初始化

就是在内存中，为数组容器开辟空间，并将数据存入容器中的过程。

#### 2.2、数组定义格式

格式一：数据类型[ ] 数组名（推荐）

```java
int[] arr
```

格式二：数据类型 数组名[ ] 

```java
int arr[]
```

=== 注意：这种定义格式，定义出来的，只是数组类型的变量而已，内存中还没有创建出数组容器。

#### 2.3、静态初始化

##### 2.3.1、格式

```java
/*
格式：
    完整格式：
        数据类型[] 数组名 = new 数据类型[]{e1,e2,e3...en};
    简化格式：
        数据类型[] 数组名 = {e1,e2,e3...en};

    打印数组名
        [I@1eb44e46

        @ ： 分隔符
        [ ： 当前这个空间，是数组类型的
        I : 当前数组类型，是int类型
        1eb44e46 : 数组的十六进制内存地址
*/
```

##### 2.3.2、数组元素访问

```java
/*
数组元素访问格式：
    数组名[索引];
    索引 : 数组容器中空间所对应的编号，编号从0开始，逐个+1增长
*/
```

##### 2.3.3、一维数组遍历

遍历：将数组中所有的内容取出来，取出来之后可以（打印、求和、判断。。。）

=== 扩展 --- 数组名.length ：动态获取数组的元素个数（数组长度）

#### 2.4、动态初始化

##### 2.4.1、介绍

初始化时只指定数组长度，由系统为数组分配初始值。

```java
/*
    数组的动态初始化
    默认值：
        整数 : 0
        小数 : 0.0
        布尔 : false
        -----------
        字符 : '\u0000'   ---> Unicode码表 ---> 常见的体现是空白字符
        引用数据类型 : null
 */
```

##### 2.4.2、格式

```java
// 数据类型[] 数组名 = new 数据类型[数组长度];
```

#### 2.5、两种初始化的区别

动态初始化：手动指定数组长度，由系统给出默认初始化值。

静态初始化：手动指定数组元素，系统会根据元素个数，计算出数组的长度。

#### 2.6、数组内存图

（1）Java内存分配介绍

**方法区 ：字节码文件加载时进入的内存**

**栈 ： 方法运行时所进入的内存**

**堆 ： new 出来的东西会在这块内存中开辟空间并产生地址**

本地方法栈

寄存器

![image-20250802001725841](D:\软件工程\Java\java-basic\day05\assets\image-20250802001725841.png)

（2）方法参数传递问题

基本数据类型（byte、short、int、long、float、double、char、boolean）：传递的是数据值。

引用数据类型（数组、类、接口）：传递的是地址值。

=== 问题：Java到底是值传递？还是址传递？

回答：**在基本数据类型中传递的是数据值，在引用数据类型中传递的是地址值，它们传递的都是值。**

#### 2.7、数组常见问题

##### 2.7.1、数组索引越界异常

ArrayIndexOutOfBoundsException 当访问了数组中不存在的索引，就会引发索引越界异常。

##### 2.7.2、空指针异常

NullPointerException 当引用数据类型的变量，被赋值为null之后，就代表跟堆内存的连接切断了，如果还想去访问堆内存的数据，就会出现空指针异常。

#### 2.8、案例

```java
// 案例一 ：数组遍历 - 求偶数(even)和. 奇数(odd)
// 需求 ： 已知数组元素为 {11,22,33,44,55} 请将数组中偶数元素取出并求和，最后打印求和结果
```

```java
public static void main(String[] args) {
    int[] arr = {11, 22, 33, 44, 55};
    int evenSum = getEvenSum(arr);
    System.out.println("偶数和:" + evenSum);
  }

  public static int getEvenSum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 == 0) {
        sum += arr[i];
      }
    }
    return sum;
  }
```

```java
// 案例二 ： 数组遍历 - 求最大值
// 需求 ： 已知数组元素为 {5,44,33,55,22} 请找出数组中最大值并打印在控制台
```

```java
public static void main(String[] args) {
    int[] arr = {5, 44, 33, 55, 22};
    int max = getMax(arr);
    System.out.println("最大值是:" + max);
  }

  public static int getMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        int temp = arr[i];
        arr[i] = max;
        max = temp;
      }
    }
    return max;
  }
```

```java
/*
 案例三 --- 需求
        已知班级学生成绩为： int[] arr = {100,50,20,90,90};
        1. 找出数组最大值，并打印在控制台
        2. 找出数组最小值，并打印在控制台
        3. 求总成绩，并打印在控制台
        4. 计算出平均值，并打印在控制台
        5. 统计出低于平均值元素个数
 */
```

```java
public static void main(String[] args) {
    int[] arr = {100, 50, 20, 90, 90};
    start(arr);
  }

  public static void start(int[] arr) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("====成绩系统====");
      System.out.println("1. 求最大值");
      System.out.println("2. 求最小值");
      System.out.println("3. 求总成绩");
      System.out.println("4. 求平均值");
      System.out.println("5. 求低于平均值的个数");
      System.out.println("6. 退出");
      System.out.println("请输入:");
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          getMax(arr);
          break;
        case 2:
          getMin(arr);
          break;
        case 3:
          int sum = getSum(arr);
          System.out.println("总成绩:" + sum);
          break;
        case 4:
          double avg = getAvg(arr);
          System.out.println("平均值:" + avg);
          break;
        case 5:
          int count = getCount(arr);
          System.out.println("低于平均值的个数:" + count);
          break;
        case 6:
          System.out.println("感谢使用！");
          sc.close();
          System.exit(0);
        default:
          System.out.println("输入错误！");
          break;
      }
    }
  }

  public static void getMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        int temp = arr[i];
        arr[i] = max;
        max = temp;
      }
    }
    System.out.println("最大值:" + max);
  }

  public static void getMin(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < min) {
        int temp = arr[i];
        arr[i] = min;
        min = temp;
      }
    }
    System.out.println("最小值:" + min);
  }

  public static int getSum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }

  public static double getAvg(int[] arr) {
    int sum = getSum(arr);
    double avg = sum / (arr.length * 1.0);
    return avg;
  }

  public static int getCount(int[] arr) {
    int count = 0;
    double avg = getAvg(arr);
    for (int i = 0; i < arr.length; i++) {
      if (avg > arr[i]) {
        count++;
      }
    }
    return count;
  }
```

## 二、二维数组

### 1、介绍

二维数组是一种**容器**，该容器用于存储一维数组（地址值）。

使用思路：今后若要操作的**多组**数据，属于同一组数据，就可以考虑使用二维数组进行维护。

### 2、静态初始化

```java
// 1. 完整格式：
int[][] arr1 = new int[][]{{11, 22, 33}, {44, 55, 66}, {77, 88, 99}};

// 2. 简化格式：
int[][] arr2 = {
        {11, 22, 33},
        {44, 55, 66}
};
```

### 3、访问格式

```java
/*
    二维数组的元素访问格式：
            数组名[m索引][n索引] :
            m索引 : 指定访问哪一个一维数组
            n索引 : 访问一维数组中哪一个元素
 */
```

### 4、遍历

```java
public static void main(String[] args) {
    int[][] arr = {
            {11, 22, 33},
            {44, 55, 66}
    };
    printArray(arr);
    System.out.println("-----------");

    int result = getSum(arr);
    System.out.println("求和结果是 : " + result);
}

/**
 * 遍历并打印二维数组中元素
 * 已知一个二维数组 arr = {{11,22,33},{44,55,66}};
 * 遍历该数组，取出所有元素并打印
 */
public static void printArray(int[][] arr) {
    // 1. 遍历二维数组，得到一维数组的地址
    for (int i = 0; i < arr.length; i++) {
        // 2. 编列一维数组，得到每一个一维数组的元素
        for (int j = 0; j < arr[i].length; j++) {
            System.out.println(arr[i][j]);
        }
    }
}

/**
 * 遍历二维数组并求和
 * 已知一个二维数组 arr = {{11,22,33},{44,55,66}};
 * 对内部存储的元素累加求和，并将结果输出在控制台
 *
 * @param arr
 */
public static int getSum(int[][] arr) {
    // 1. 定义求和变量
    int sum = 0;
    // 2. 遍历二维数组，得到每一个一维数组
    for (int i = 0; i < arr.length; i++) {
        // 3. 遍历一维数组，得到所有元素
        for (int j = 0; j < arr[i].length; j++) {
            // 4. 累加求和
            sum += arr[i][j];
        }
    }
    // 5. 返回求和结果
    return sum;
}
```

5、动态初始化

```java
/*
二维数组的动态初始化：
格式 ： 数据类型[][] 数组名 = new 数据类型[m][n];
m : 表示有几个一维数组
n : 表示每个一维数组中有多少个元素
*/
```

```java
public static void main(String[] args) {
    // int[][] arr = new int[2][3];

    // 问题 ： 能不能将提前准备好的一维数组，直接存入二维数组中？
    // 回答 ： 可以
    int[] arr1 = {11, 22, 33};
    int[] arr2 = {44, 55, 66};
    int[][] arr = new int[2][3];

    arr[0] = arr1;
    arr[1] = arr2;

    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            System.out.println(arr[i][j]);
        }
    }
}
```

