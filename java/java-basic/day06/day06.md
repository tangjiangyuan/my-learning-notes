## day06、专题案例

## 一、逢七跳过

```java
/*
案例 ： 逢7跳过
规则 ： 从任意一个数字开始报数，当你要报的数字包含 7或者 是 7的倍数时都要说：过。
在控制台打印出1~100之间的满足逢7比过规则的数据
 */
```

```java
public static void main(String[] args) {
    for(int i = 1; i <= 100; i++) {
      int ge = i % 10;
      int shi = i / 10 % 10;
      if (ge == 7 || shi == 7 || i % 7 == 0) {
        System.out.println(i + ":跳");
      } else {
        System.out.println(i);
      }
    }
  }
```

## 二、数组元素求和

```java
/*
    案例 : 数组元素求和
    需求 : 有这样一个数组，元素是 {68,27,95,88,171,996,51,210}
    求出该数组中满足要求的元素和
    要求 : 求和的元素个位和十位都不能是7，并且只能是偶数

    分析 ：
        1. 定义数组
        2. 定义求和变量
        3. 遍历数组，拿到每一个元素
        4. 数值拆分，拿到个位、十位，判断个位和十位不能是7，并且只能是偶数
     */
```

```java
public static void main(String[] args) {
    int[] arr = { 68, 27, 95, 88, 171, 996, 51, 210 };
    int sum = getSum(arr);
    System.out.println("和:" + sum);
  }

  public static int getSum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      int ge = arr[i] % 10;
      int shi = arr[i] / 10 % 10;
      if ((ge != 7 || shi != 7) && arr[i] % 2 == 0) {
        sum += arr[i];
      }
    }
    return sum;
  }
```

## 三、判断两个数组是否相同

```java
/*
    案例 : 判断两个数组元素是否相同
    需求 : 定义一个方法，用于比较两个数组的内容是否相同
    要求 : 长度，内容，顺序完全相同

    分析 ：
        1. 得到数组的长度 数组名.length
        2. 判断数组的内容 遍历两个数组，拿到每一个元素
        3. 顺序
 */
```

```java
public static void main(String[] args) {
    int[] arr1 = {11, 22, 33, 44, 55};
    int[] arr2 = {11, 22, 33, 44};
    boolean flag = check2Array(arr1, arr2);
    if (flag) {
      System.out.println("两个数组相等");
    } else {
      System.out.println("两个数组不相等");
    }
  }

  public static boolean check2Array(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length) {
      return false;
    }
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }
```

## 四、查找元素在数组中的索引

（1）数据在该数组中第一次出现的索引位置

```java
/*
    需求 : 设计一个方法，查找元素在数组中的索引位置
    已知一个数组 arr = {19,28,37,46,50};
    键盘录入一个数据，查找该数据在数组中的索引。并在控制台输出找到的索引值。
    如果没有查找到，则输出 -1；
 */
```

```java
public static void main(String[] args) {
    int[] arr = {19, 28, 37, 46, 50};
    int index = getIndex(arr, 28);
    if (index == -1) {
      System.out.println("数组中不存在该数据");
    } else {
      System.out.println("该数据在数中的索引是:" + index);
    }
  }

  public static int getIndex(int[] arr, int targetNum) {
    for (int i = 0; i < arr.length; i++) {
      if (targetNum == arr[i]) {
        return i;
      }
    }
    return -1;
  }
```

（2）元素在数组中出现的的所有索引位置 

```java
public static void main(String[] args) {
    int[] arr = { 19, 28, 37, 46, 50, 19, 29, 28, 28, 28};
    int[] indexs = getIndexs(arr, 28);
    if (indexs.length == 0) {
      System.out.println("该数据不在数组中");
    } else {
      System.out.println("该数据在数组中的位置有:" + Arrays.toString(indexs));
    }
  }

  public static int[] getIndexs(int[] arr, int targetNum) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == targetNum) {
        count++;
      }
    }
    int[] indexs = new int[count];
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == targetNum) {
        indexs[index] = i;
        index++;
      }
    }
    return indexs;
  }
```

## 五、数组元素反转

```java
/*
    案例 : 数组元素反转
    需求 :
    已知一个数组 arr = {11,22,33,44,55};用程序实现把数组中的元素值交换，
    交换后的数组 arr = {55,44,33,22,11};并在控制台输出交换后的数组元素。
 */
```

```java
public static void main(String[] args) {
    int[] arr = {11, 22, 33, 44, 55};
    method3(arr);
  }

  public static void method1(int[] arr) {
    int[] tempArr = new int[arr.length];
    int count = 0;
    for (int i = arr.length - 1; i >= 0; i--) {
      tempArr[count] = arr[i];
      count++;
    }
    System.out.println(Arrays.toString(tempArr));
  }

  public static void method2(int[] arr) {
    for (int start = 0, end = arr.length - 1; start <= end; start++, end--) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }

  public static void method3(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }
```

## 六、评委打分

```java
/*
    案例 : 评委打分
    需求 : 在编程竞赛中，有6个评委为参赛的选手打分，分数为0-100
    选手的最后得分为 : 去掉一个最高分和一个最低分后 的4个评委平均值

    分析 :
    1. 先考虑只有一个选手的情况，Scanner键盘录入6个评委的打分，存入一个数组中
    2. 定义两个方法，得到最高分和最低分
    3. 计算最终得分
 */
```

```java
public static void main(String[] args) {
    scoreSystem();
  }

  public static void scoreSystem() {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入评委人数:");
    int judges = sc.nextInt();
    // 定义存放分数的数组
    double[] scores = new double[judges];
    // 遍历评委人数，获得所有评分
    for (int i = 0; i < judges; i++) {
      System.out.println("请输入第" + (i + 1) + "位评委的打分:");
      double score = sc.nextDouble();
      scores[i] = score;
    }
    sc.close();
    // double max = getSum(scores);
    // System.out.println(max);
    double avg = getAvg(scores, judges);
    System.out.println("改名选手的最终得分是:" + avg);
  }

  public static double getAvg(double[] scores, int judges) {
    double max = getMax(scores);
    
    double min = getMin(scores);
    
    double sum = getSum(scores);
    System.out.println(sum);
    return (sum - min - max) / (judges - 2);
  }

  public static double getMax(double[] scores) {
    double max = scores[0];
    for (int i = 1; i < scores.length; i++) {
      if (scores[i] > max) {
        max = scores[i];
      }
    }
    return max;
  }

  public static double getMin(double[] scores) {
    double min = scores[0];
    for (int i = 1; i < scores.length; i++) {
      if (scores[i] < min) {
        min = scores[i];
      }
    }
    return min;
  }

  public static double getSum(double[] scores) {
    double sum = 0;
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i];
    }
    return sum;
  }
```

八、产生随机验证码

```java
/*
    案例 : 随机产生验证码(captcha)
    需求 : 请从26个英文字母（大小写都包含），以及数字0-9中，随机产生一个5位的字符串验证码
    并打印在控制台
    效果 : uYq8I, 3r4Zj
 */
```

```java
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String captcha = provideCaptcha();
    while (true) {
      System.out.println("验证码:" + captcha);
      System.out.print("请输入:");
      String inputInfo = sc.nextLine();

      if (captcha.equals(inputInfo)) {
        System.out.println("验证成功！！！");
        sc.close();
        break;
      } else {
        System.out.println("请重新输入！");
      }
    }
  }
  public static String provideCaptcha() {
    char[] chars = new char[26 + 26 + 10];
    int count = 0;
    for (char c = 'a'; c <= 'z'; c++) {
      chars[count] = c;
      count++;
    }
    for (char c = 'A'; c <= 'Z'; c++) {
      chars[count] = c;
      count++;
    }
    for (char c = '0'; c <= '9'; c++) {
      chars[count] = c;
      count++;
    }

    Random random = new Random();
    String captcha = "";
    for (int i = 0; i < 6; i++) {
      int index = random.nextInt(chars.length);
      captcha += chars[index];
    }
    return captcha;
  }
```

