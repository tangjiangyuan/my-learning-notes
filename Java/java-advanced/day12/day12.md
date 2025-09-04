## day12、

![image-20250806000151424](D:\软件工程\Java\java-advanced\day12\assets\image-20250806000151424.png)

## 一、Stream流

### 1、介绍

​	配合Lambda表达式，简化集合和数组操作

===通过一个案例对比集合和Stream流的操作

![image-20250806000802360](D:\软件工程\Java\java-advanced\day12\assets\image-20250806000802360.png)

===集合

```java
private static void method1(List<String> list) {
    // 2. 把集合中所有以“张”开头的元素存储到一个新的集合
    ArrayList<String> list1 = new ArrayList<>();
    for (String s : list) {
        /*char c = s.charAt(0);*/
        if (s.startsWith("张")) {
            list1.add(s);
        }
    }

    // 3. 把“张”开头的集合中的长度为3的元素存储到一个新的集合
    ArrayList<String> list2 = new ArrayList<>();
    for (String s : list1) {
        if (s.length() == 3) {
            list2.add(s);
        }
    }

    // 4. 遍历上一步得到的集合中的元素输出
    for (String s : list2) {
        System.out.println(s);
    }
}
```

===Stream流

```java
public static void main(String[] args) {
    // 1. 创建一个集合，存储多个字符串元素
    List<String> list = new ArrayList<>();
    list.add("张无忌");
    list.add("张良");
    list.add("王二麻子");
    list.add("谢广坤");
    list.add("张三丰");
    list.add("张翠山");

    list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3)
            .forEach(s -> System.out.println(s));
}
```



### 2、Stream流思想

#### 2.1、将数据放入流中（获取流对象）

（1）集合获取流对象：单列直接获取，双列需要间接获取

```java
集合获取 Stream流对象（使用 Collection接口中的默认方法）
    default Stream<E> stream()

    * Map集合获取Stream流对象，需要间接获取
            - map.entrySet().stream()
```

```java
private static void method1() {
    List<String> list = new ArrayList<>();
    list.add("张无忌");
    list.add("张良");
    list.add("王二麻子");
    list.add("谢广坤");
    list.add("张三丰");
    list.add("张翠山");

    list.stream().forEach(s -> System.out.println(s));
    System.out.println("----------------");

    Set<String> set = new HashSet<>();
    set.add("张三丰");
    set.add("张无忌");
    set.add("张翠山");
    set.add("王二麻子");
    set.add("张良");
    set.add("谢广坤");

    set.stream().forEach(s -> System.out.println(s));
    System.out.println("----------------");

    Map<String, Integer> map = new HashMap<>();
    map.put("张三丰", 100);
    map.put("张无忌", 35);
    map.put("张翠山", 55);
    map.put("王二麻子", 22);
    map.put("张良", 30);
    map.put("谢广坤", 55);

    map.entrySet().stream().forEach(s -> System.out.println(s));
}
```

（2）数组获取流对象

```java
数组获取 Stream流对象（使用Arrays数组工具类的静态方法）
        static <T> Stream<T> stream(T[] array)
```

```java
private static void method2() {
    int[] arr1 = {11, 22, 33};
    double[] arr2 = {11.1, 22.2, 33.3};

    IntStream intStream = Arrays.stream(arr1);
    intStream.forEach(s -> System.out.println(s));

    Arrays.stream(arr2).forEach(s -> System.out.println(s));
}
```

（3）零散数据获取流对象

```java
零散的数据获取 Stream流对象（使用 Stream类中的静态方法）
        static <T> Stream<T> of(T...values)
```

```java
public static void main(String[] args) {
    Stream.of(1, 2, 3, 4, 5, 6).forEach(s -> System.out.println(s));
    Stream.of("友利奈绪", "雪之下雪乃", "蕾西亚").forEach(s -> System.out.println(s));
}
```



#### 2.2、中间方法

```java
Stream流的中间操作方法
    - 操作后返回Stream对象，可以继续操作

    Stream<T> filter(Predicate<? super T> predicate) : 用于对流中的数据进行过滤
    Stream<T> limit(long maxSize) : 获取前几个元素
    Stream<T> skip(long n) : 跳过前几个元素
    Stream<T> distinct() : 去除流中重复的元素依赖 (hashCode 和 equals 方法)
    static <T> Stream<T> concat(Stream a, Stream b) : 合并 a 和 b 两个流为一个流
--- 注意事项 : 流对象已经被消费过(使用过)，就不允许再次消费了；
    中间方法调用完成后返回新的Stream流对象，可以继续使用，支持链式编程。
```

```java
public static void main(String[] args) {
    // 需求 --- 将集合中以 [张] 开头的数据，过滤出来并打印在控制台
    ArrayList<String> list = new ArrayList<>();
    list.add("林青霞");
    list.add("张曼玉");
    list.add("王祖贤");
    list.add("张慧敏");
    list.add("赵敏");
    list.add("张无忌");

    list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
    System.out.println("------------");

    // 需求1 --- 取前3个数据在控制台
    list.stream().limit(3).forEach(s -> System.out.println(s));
    System.out.println("------------");

    // 需求2 --- 跳过3个元素，把剩下的元素在控制台输出
    list.stream().skip(3).forEach(s -> System.out.println(s));
    System.out.println("------------");

    // 需求3 --- 跳过2个元素，把剩下的元素中前2个在控制台输出
    list.stream().skip(2).limit(2).forEach(s -> System.out.println(s));
    System.out.println("------------");

    // 需求4 --- 取前4个数据组成一个流
    Stream<String> limitStream = list.stream().limit(4);

    // 需求5 --- 跳过2个数据组成一个流
    Stream<String> skipStream = list.stream().skip(2);

    // 需求6 --- 合并需求4和需求5得到的流，并把结果在控制台输出
    Stream<String> stream = Stream.concat(limitStream, skipStream);
    // stream.forEach(s -> System.out.println(s));
    System.out.println("------------");

    // 需求7 --- 合并需求4和需求5得到的流，并把结果在控制台输出，要求字符串元素不能重复
    stream.distinct().forEach(s -> System.out.println(s));
}
```



#### 2.3、终结方法

```java
Stream流的终结操作方法
    - 流水线中的最后一道工序
public void forEach(Consumer action) : 对此流的每个元素执行遍历操作
public long count() : 返回流中的元素数
```

```java
public static void main(String[] args) {
    long count = Stream.of(1, 2, 3, 4, 5, 6).filter(s -> s % 2 == 0).count(); // 求流中的偶数个数
    System.out.println(count);
}
```



### 3、Stream 流收集操作

===说明===

把Stream流操作后的结果数据转到集合；

Stream流操作，不会修改数据。

![image-20250806002451096](D:\软件工程\Java\java-advanced\day12\assets\image-20250806002451096.png)

```java
Stream流的收集操作
    public R collect(Collector c) : 开始收集 Stream流，指定收集器

Collectors :
    public static <T> Collector toList() : 把元素收集到 List集合中
    public static <T> Collector toSet() : 把元素收集到 Set集合中
    public static Collector toMap(Function keyMapper, Function valueMapper) : 把元素收集到 Map集合中
```

（1）list和set

```java
public static void main(String[] args) {
    List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(s -> s % 2 == 0).collect(Collectors.toList());
    System.out.println(list);

    System.out.println("---------------");

    Set<Integer> set = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(s -> s % 2 != 0).collect(Collectors.toSet());
    System.out.println(set);
}
```

（2）map

![image-20250806002626162](D:\软件工程\Java\java-advanced\day12\assets\image-20250806002626162.png)

```java
/*
    创建一个 ArrayList集合，并添加以下字符串
        "张三,23"
        "李四,24"
        "王五,25"
        保留年龄大于等于24岁的人，并将结果收集到 Map集合中，姓名为键，年龄为值
 */
public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("张三,23");
    list.add("李四,24");
    list.add("王五,25");

    Map<String, Integer> map = list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24).collect(Collectors.toMap(
        s -> s.split(",")[0], 
        s -> Integer.parseInt(s.split(",")[1])));

    map.forEach((k, v) -> System.out.println(k + "---" + v));

    // list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24).forEach(s -> System.out.println(s));
}
```



### 4、综合案例

![image-20250806002634383](D:\软件工程\Java\java-advanced\day12\assets\image-20250806002634383.png)

![image-20250806002730984](D:\软件工程\Java\java-advanced\day12\assets\image-20250806002730984.png)

## 二、File 类

### 1、介绍

​	File类代表操作系统的文件对象（文件、文件夹）

### 2、构造方法

```java
public File(String pathname) : 根据传入的字符串路径封装 File对象
public File(String parent, String child) : 根据传入的父路径和子路径来封装 File对象
public File(File parent, String child) : 根据传入的父路径(File类型)和子路径来封装 File对象
```

```java
public static void main(String[] args) throws IOException {
    // method1
    File f1 = new File("D:\\a.text");
    // f1.createNewFile();
    System.out.println(f1);

    File f2 = new File("D:\\text");
    System.out.println(f2.exists());

    // method2
    File f3 = new File("D:\\", "a.txt");
    System.out.println(f3.exists());

    // method3
    File f4 = new File(new File("D:\\"), "a.txt");
    System.out.println(f4.exists());
}
```

===补充===

​	File对象可以定义文件和文件夹；

​	File封装的对象仅仅是一个路径名，这个路径名可以是存在的，也可以是不存在的。

### 3、相对路径和绝对路径

#### 3.1、相对路径

​	相当于当前项目下

![image-20250806003047251](D:\软件工程\Java\java-advanced\day12\assets\image-20250806003047251.png)

#### 3.2、绝对路径

​	从盘符目录开始，一直到某个具体的文件或文件夹（完整路径）

![image-20250806003136257](D:\软件工程\Java\java-advanced\day12\assets\image-20250806003136257.png)

### 4、成员方法

#### 4.1、判断和获取的方法

```java
1. 判断相关
    public boolean isDirectory() : 判断是否是文件夹
    public boolean isFile() : 判断是否是文件
    public boolean exists() : 判断是否存在

2. 获取相关
    public long length() : 返回文件的大小(字节数量)
                    * 文件对象操作，返回正确的字节个数
                    * 文件夹对象操作，返回的是错误的字节个数
    public String getAbsolutePath() : 返回文件的绝对路径
    public String getPath() : 返回定义文件时使用的路径
    public String getName() : 返回文件的名称，带后缀
    public long lastModified() : 返回文件的最后修改时间(时间毫秒值)
```

```java
public static void main(String[] args) throws IOException {
    File f1 = new File("D:\\a.txt");
    // f1.createNewFile();
    System.out.println(f1.isDirectory());
    System.out.println(f1.isFile());
    System.out.println(f1.exists());

    System.out.println("---------------------");

    File f2 = new File("D:\\test");

    System.out.println(f1.length());
    System.out.println(f2.length());

    System.out.println("---------------------");

    File f3 = new File("a.txt");
    System.out.println(f3.getAbsolutePath());

    System.out.println("---------------------");

    long time = f1.lastModified();
    System.out.println(new Date(time)); // new Date(long time) 获取当前的时间对象
}
```



#### 4.2、案例

```
需求 : 键盘录入一个文件夹路径，如果输入错误就给出提示，并继续录入，直到正确为止
分析 :
    1. 输入的路径可能不存在
    2. 输入的路径可能是文件路径

    封装为 File对象
        调用 exists() 判断是否存在
        调用 isFile() 判断是否是文件
```

```java
public static void main(String[] args) {
    File dir = isDir();
    System.out.println(dir);
}

public static File isDir() {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("请输入一个文件夹路径:");
      String dirPath = sc.nextLine();

      File file = new File(dirPath);
      if (!file.exists()) {
        System.out.println("该文件夹路径不存在，请重新输入！");
      } else if (file.isFile()) {
        System.out.println("这是一个文件路径，不是文件夹！");
      } else {
        sc.close();
        return file;
      }
    }
}
```



#### 4.3、创建和删除的方法

```java
public boolean createNewFile() : 创建文件
public boolean mkdir() : 创建单级文件夹
public boolean mkdirs() : 创建多级文件夹
public boolean delete() : 删除文件或文件夹(不走回收站)
                - delete 方法删除文件夹，只能删除空的文件夹
```

```java
public static void main(String[] args) throws IOException {
    File f1 = new File("D:\\Dev-work\\java_advanced\\day12\\src\\com\\javalearn\\p2_file\\B.txt");
    System.out.println(f1.createNewFile());

    File f2 = new File("D:\\Dev-work\\java_advanced\\day12\\src\\com\\javalearn\\p2_file\\aaa\\bbb\\ccc");
    System.out.println(f2.mkdirs());

    File f3 = new File("D:\\Dev-work\\java_advanced\\day12\\src\\com\\javalearn\\p2_file\\C.txt");
    System.out.println(f3.mkdir());

    System.out.println(f1.delete());
    System.out.println(f2.delete());
}
```



#### 4.4、遍历方法

```java
public File[] listFiles() : 获取当前目录下所有的 “一级文件对象”，返回 File数组
```

```java
public static void main(String[] args) {
    File f1 = new File("D:\\Dev-work\\java_advanced\\day12\\src\\com\\javalearn\\p2_file");
    File[] files = f1.listFiles();
    for (File file : files) {
        System.out.println(file);
    }
}
```



#### 4.5、案例

===案例一：

```
需求 --- 键盘录入一个文件夹路径，找出这个文件夹下的所有的 .java文件
```

```java
public static void main(String[] args) {
    File dir = Test11.isDir();
    printJavaFile(dir);
}

public static void printJavaFile(File dir) {
	File[] files = dir.listFiles();
	for (File file : files) {
  		if (file.isFile()) {
    		String name = file.getName();
    		String[] split = name.split("\\.");
    			if (split[split.length - 1].equals("java")) {
      				System.out.println(file);
    			}
  		} else {
    		if (file.listFiles() != null) {
      			printJavaFile(file);
    		}
         }
	}
}
```

![image-20250806005649182](D:\软件工程\Java\java-advanced\day12\assets\image-20250806005649182.png)

===注意===

当调用者File表示的路径不存在时，返回null；

当调用者File表示的路径是文件时，返回null；

当调用者File表示的路径是一个空文件夹时，返回一个长度为0的数组；

当调用者File表示的路径需要权限才能访问的文件夹时，返回null。

===案例二：

```java
/*
案例 ---
需求 : 设计一个方法，删除文件夹
注意 : delete() 只能删除空文件夹
    *** delete() 的删除不走回收站，不要拿重要的数据测试！！！
*/
```

```java
public static void main(String[] args) {
    File dir = Test11.isDir();
    deleteFile(dir);
  }

  public static void deleteFile(File filePath) {
    File[] listFiles = filePath.listFiles();
    for (File file : listFiles) {
      if (file.isFile()) {
        file.delete();
      } else {
        if (file.listFiles() != null) {
          deleteFile(file);
        }
      }
    }
    filePath.delete();
  }
```

===案例三：

```
案例 --- 需求: 键盘录入一个文件夹路径，统计文件夹的大小
```

```java
public static void main(String[] args) {
    File dir = Test11.isDir();
    long size = statisticsFileSize(dir);
    System.out.println("该文件的大小为:" + size);
  }

  public static long statisticsFileSize(File path) {
    long size = 0;
    File[] files = path.listFiles();
    for (File file : files) {
      if (file.isFile()) {
        size += file.length();
      } else {
        if (file.listFiles() != null) {
          size += statisticsFileSize(file);
        }
      }
    }
    return size;
  }
```

===练习四

```java
案例 --- 需求 : 键盘录入一个文件夹路径，统计文件夹中每种文件的个数并打印(考虑子文件)
        打印格式如下 :
            txt : 3个
            doc : 4个
            jpg : 6个
```

```java
static HashMap<String, Integer> hm = new HashMap<>();
  static int count = 0; // 统计没有后缀文件的个数

  public static void main(String[] args) {
    File dir = Test11.isDir();
    statisticsFileVariety(dir);
    hm.forEach((key, value) -> System.out.println(key + ":" + value + "个。"));
    System.out.println("没有后缀的文件的个数:" + count + "个。");
  }

  public static void statisticsFileVariety(File dir) {
    File[] files = dir.listFiles();
    
    for (File file : files) {
      if (file.isFile()) {
        String fileName = file.getName();
        if (fileName.contains(".")) {
          // 有后缀的文件
          String[] split = fileName.split("\\.");
          String type =  split[split.length - 1];
          if (!hm.containsKey(type)) {
            hm.put(type, 1);
          } else {
            hm.put(type, hm.get(type) + 1);
          }
        } else {
          // 没有后缀的文件
          count++;
        }
      } else {
        if (file.listFiles() != null) {
          statisticsFileVariety(file);
        }
      }
    }
  }
```

