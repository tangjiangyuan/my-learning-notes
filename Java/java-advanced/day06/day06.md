## day06、常见API

## 一、Arrays 工具类

### 1、介绍

​	数组操作工具类，专门用于操作数组。

### 2、成员方法

```java
public static String toString(类型[] a) : 将数组元素拼接为带有格式的字符串
public static boolean equals(类型[] a, 类型[] b) : 比较两个数组内容是否相同
public static int binarySearch(int[] a, int key) : 查找元素在数组中的索引(二分查找 : 保证数组的元素是排好序的!) - 如果查找的元素，在数组中不存在，返回 (-(插入点) + 1)
public static void sort(类型[] a) : 对数组进行默认升序排列
```

```java
public static void main(String[] args) {
    int[] arr1 = {11, 22, 33, 44, 55};
    int[] arr2 = {11, 22, 33, 44, 22};

    System.out.println(Arrays.toString(arr1)); // [11, 22, 33, 44, 55]
    System.out.println(Arrays.equals(arr1, arr2)); // false
    System.out.println(Arrays.binarySearch(arr1, 22)); // 1

    int[] arr3 = {55, 33, 44, 11, 22};
    Arrays.sort(arr3);
    for (int i = 0; i < arr3.length; i++) {
        System.out.println(arr3[i]);
    }
}
```

## 二、冒泡排序

![image-20250803121950231](D:\软件工程\Java\java-advanced\day06\assets\image-20250803121950231.png)

![image-20250803121955815](D:\软件工程\Java\java-advanced\day06\assets\image-20250803121955815.png)

```java
public static void main(String[] args) {
    int[] arr = {22, 44, 11, 55, 33, 77};
    bubbleSort(arr);
}

public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) { // 0 1 2 3
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(arr));
}
```

## 三、选择排序

![image-20250803123055933](D:\软件工程\Java\java-advanced\day06\assets\image-20250803123055933.png)

![image-20250803123114310](D:\软件工程\Java\java-advanced\day06\assets\image-20250803123114310.png)

```java
public static void main(String[] args) {
    int[] arr = {22, 44, 11, 55, 33, 77};
    selectSort(arr);
}

public static void selectSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(arr));
}
```



## 四、二分查找（折半查找）

![image-20250803123129456](D:\软件工程\Java\java-advanced\day06\assets\image-20250803123129456.png)

===前提===

​	必须是排好序的数据

```java
public static void main(String[] args) {
    int[] arr = {22, 44, 11, 55, 33, 77};
    selectSort(arr);
    int index = binarySearch(arr, 44);
    if (index == -1) {
      System.out.println("该数据不存在！");
    } else {
      System.out.println("该数据在数组中的索引:" + index);
    }
}

public static int binarySearch(int[] arr, int num) {
    int min = 0, max = arr.length - 1;
    int middle;
    while (min <= max) {
      middle = (max + min) / 2;
      if (num > arr[middle]) {
        min = middle + 1;
      } else if (num < arr[middle]) {
        max = middle - 1;
      } else {
        return middle;
      }
    }
    return -1;
}
```



## 五、正则（Regex）表达式

### 1、定义

​	本质来说就是一个字符串，可以指定一些规则，来校验其它字符串。

![image-20250803135705771](D:\软件工程\Java\java-advanced\day06\assets\image-20250803135705771.png)

### 2、字符类

```java
[abc]           :只能是a, b, c
[^abc]          :除了a, b, c之外的任何字符
[a-zA-Z0-9]     :a到z A到Z，包括范围
[a-d[m-p]]      :a到d，或m通过p:([a-dm-p]联合)
[a-z&&[def]]    :d, e, 或f(交集)
[a-z&&[^bc]]    :a到z，除了b和c:([ad-z]减法)
[a-z&&[^m-p]]   :a到z，除了m到p:([a-lq-z]减法)
```

```java
private static void regexTest1() {
        String regex1 = "[abc]";
        String regex2 = "[^abc]";
        String regex3 = "[a-zA-Z]";
        String regex4 = "[a-zA-Z0-9]";


        System.out.println("a".matches(regex1));
        System.out.println("x".matches(regex2));
        System.out.println("Y".matches(regex3));
        System.out.println("1".matches(regex4));
    }
```



### 3、预定义的字符类

```java
.   : 任何字符
\d  : 一个数字:[0-9] (常用)
\D  : 非数字:[^0-9]
\s  : 一个空白字符:[ \t\n\x0B\f\r]
\S  : 非空白字符:[^\s]
\w  : [a-zA-Z_0-9] 英文、数字、下划线 (常用)
\W  : [^\w] 一个非单词字符

\   : 转义字符
System.out.println("\t");     \ ---> t ---> 解密成功 ---> tab键
```

```java
private static void regexTest2() {
    String regex1 = "."; // ".+" : 表示不受数量限制，否则只能对应一个字符
    String regex2 = "\\d";
    String regex3 = "\\D";
    String regex4 = "\\s";
    String regex5 = "\\S";
    String regex6 = "\\w";
    String regex7 = "\\W";


    System.out.println("1".matches(regex1));
    System.out.println("1".matches(regex2));
    System.out.println("a".matches(regex3));
    System.out.println(" ".matches(regex4));
    System.out.println("a".matches(regex5));
    System.out.println("!".matches(regex6));
    System.out.println("!".matches(regex7));

    System.out.println("\"");
    System.out.println('\'');
}
```



### 4、量词

```java
X?      : X,0次或一次
X*      : X,零次或多次(任意次数)
X+      : X,一次或多次(至少一次)(常用)
X{n}    : X,正好n次
X{n, }  : X,至少n次
X{n, m} : X,至少n但不超过m次
```



### 5、练习

![image-20250803140157890](D:\软件工程\Java\java-advanced\day06\assets\image-20250803140157890.png)

![image-20250803140204988](D:\软件工程\Java\java-advanced\day06\assets\image-20250803140204988.png)

### 6、String 类与正则有关的方法

```java
 /*
String 类中与正则有关的常见方法 :
        public String replaceAll(String regex, String newStr) : 按照正则表达式匹配的内容进行替换
*/
```

```java
public static void main(String[] args) {
    String s = "先帝1创业2未半而中道3崩殂4，今5天下三分6，益州疲弊7，此8诚危急存亡之秋也。然9侍卫之臣不懈于内，忠志之士忘身10于外者，盖追先帝之殊遇11，欲报之于陛下也。诚宜12开张圣听13，以光14先帝遗德，恢弘15志士之气，不宜妄自菲薄16，引喻失义17，以塞忠谏之路也18。\n" +
            "宫中府中，俱为一体19；陟罚臧否20，不宜异同：若有作奸犯科21及为忠善者22，宜付有司23论其刑赏24，以昭陛下平明之理25；不宜偏私26，使内外异法也27。";

    s = s.replaceAll("\\d", "");
    System.out.println(s);
}
```

### 7、使用正则表达式爬取信息

![image-20250803140410519](D:\软件工程\Java\java-advanced\day06\assets\image-20250803140410519.png)

```java
public static void main(String[] args) {
    String data = "来黑马程序员学习Java，" +
            "电话：18139553548，19119390827或者联系" +
            "邮箱：boniu@itcast.cn 邮箱：bozai@itcast.cn 邮箱2：dlei0009@163.com" +
            "座机电话：01036517895，010-98951256" +
            "热线电话：400-618-9090，400-618-4000，4006184000，4006189090";

    String regex = "[1][3-9]\\d{9}|" +
            "\\w+[@][\\w&&[^_]]+(\\.[a-z]{2,3})+|" +
            "[0]\\d{2,3}-?\\d{7,8}|" +
            "\\d{3}-?\\d{3}-?\\d{4}";

    // 1. 将正则表达式封装为 Pattern 对象
    Pattern pattern = Pattern.compile(regex);

    // 2. 获取匹配器对象
    Matcher matcher = pattern.matcher(data);

    // System.out.println(matcher.find()); // 调用一次，爬取一次
    // System.out.println(matcher.group());

    while (matcher.find()) {
        System.out.println(matcher.group());
    }
}
```

