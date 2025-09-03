## day11、

![image-20250804234533529](D:\软件工程\Java\java-advanced\day11\assets\image-20250804234533529.png)

## 一、HashSet 集合

### 1、介绍

- HashSet 集合底层采取**哈希表**存储数据；
- 哈希表是一种对于增删改查数据性能较好的结构。

### 2、HashSet 集合存储自定义对象

![image-20250805000110503](D:\软件工程\Java\java-advanced\day11\assets\image-20250805000110503.png)

### 3、hashCode方法和equals方法的配合流程

![image-20250805000126647](D:\软件工程\Java\java-advanced\day11\assets\image-20250805000126647.png)

### 4、hashCode方法改造

```java
@Override
public int hashCode() {
    // 弊端 ： 如果hashCode 方法固定返回相同的值，数据都会挂在一个索引下面
    // name是String类型，因为String类继承了Object类，也重写了hashCode方法
    return age + name.hashCode();
}
```

```java
/*
    问题 ： 该如何重写 hashCode方法？
    回答 ： 应该将该类的所有属性，参与到哈希值的计算当中
                只有这样，（哈希值冲突）的概率，才会比较小。
 */
public static void main(String[] args) {
    // String类重写过 hashCode方法，是根据字符串的每一个字符进行计算
    System.out.println("通话".hashCode()); // 1179395
    System.out.println("重地".hashCode()); // 1179395
}
```



### 5、hashCode方法介绍

![image-20250805000730557](D:\软件工程\Java\java-advanced\day11\assets\image-20250805000730557.png)

```java
/*
    桶下标(索引)的计算

    为什么 & 操作运算效率比 % 操作效率高 ?
    --- (n - 1) & hash 是 位运算（按位与），比 hash % n 的 取模运算 更快，
        因为位运算直接由 CPU 支持，而取模运算涉及除法，效率较低。

    如何计算应存入的位置索引？
    答：通过对象的 hashCode()方法得到原始哈希值，再拿着原始哈希值向右移动16位做一次哈希扰动，
        然后再拿着扰动后的哈希值与原始哈希值做一次异或操作，来进行二次哈希操作。(这样做可以减少哈希冲突，得到的链表更散)；
        最后拿着 二次扰动后的哈希值 和 数组长度-1 做与运算

    补充---计算位置索引并不是直接拿着[哈希值 % 数组长度]，而是[(数组长度 - 1) & 哈希值]，因为后者的运算效率更高一些。
    当数组长度是 2^n 时 : (n - 1) & hash 等价于 hash % n（结果范围相同）。
 */
```

```java
public static void main(String[] args) {
    int aHash = "a".hashCode() ^ ("a".hashCode() >>> 16); // >>> 右移16位
    System.out.println(aHash % 16);
    System.out.println((16 - 1) & aHash);

    int bHash = "b".hashCode() ^ ("b".hashCode() >>> 16);
    System.out.println(bHash % 16);
    System.out.println((16 - 1) & bHash);

    int cHash = "c".hashCode() ^ ("c".hashCode() >>> 16);
    System.out.println(cHash % 16);
    System.out.println((16 - 1) & cHash);

    int pHash = "p".hashCode() ^ ("p".hashCode() >>> 16);
    System.out.println(pHash % 16);
    System.out.println((16 - 1) & pHash);

    int qHash = "q".hashCode() ^ ("q".hashCode() >>> 16);
    System.out.println(qHash % 16);
    System.out.println((16 - 1) & qHash);
}
```

===注意===

​	不能直接使用Object类中的hashCode方法，而是要自己重写hashCode方法。

### 6、HashSet 原理解析

#### 6.1、JDK7

![image-20250805000838093](D:\软件工程\Java\java-advanced\day11\assets\image-20250805000838093.png)

#### 6.2、JDK8

![image-20250805000924633](D:\软件工程\Java\java-advanced\day11\assets\image-20250805000924633.png)

![image-20250805001005251](D:\软件工程\Java\java-advanced\day11\assets\image-20250805001005251.png)

===如何提高查询性能？

![image-20250805001055597](D:\软件工程\Java\java-advanced\day11\assets\image-20250805001055597.png)

===如何在Debug时，让展示的信息更加详细？

![image-20250805001207934](D:\软件工程\Java\java-advanced\day11\assets\image-20250805001207934.png)

===小结===

![image-20250805001231607](D:\软件工程\Java\java-advanced\day11\assets\image-20250805001231607.png)

![image-20250805001237519](D:\软件工程\Java\java-advanced\day11\assets\image-20250805001237519.png)

## 二、LinkedHashSet 集合

### 1、概述和特点

- 有序、去重、无索引
- 原理：底层数据结构任然是哈希表，只是每个元素又额外多了一个双链表的机制记录存储顺序。

![image-20250805001401678](D:\软件工程\Java\java-advanced\day11\assets\image-20250805001401678.png)

### 2、单列集合的使用场景总结

![image-20250805001253542](D:\软件工程\Java\java-advanced\day11\assets\image-20250805001253542.png)

## 三、Collections 集合工具类

## 1、可变参数

#### 1.1、概念

- 可变参数用在形参中可以接收多个数据。
- 可变参数的格式：数据类型...参数名称（参数名称实际上是数组或集合名称）。

#### 1.2、特点

- 传输参数非常灵活、方便，可以不传输参数，可以传输一个或多个，也可以传输一个数组；
- 可变参数在方法内部本质上就是一个数据。

#### 1.3、注意事项

- 一个形参列表中可变参数只能有一个；
- 可变参数必须放在形参列表的最后。

![image-20250805230903836](D:\软件工程\Java\java-advanced\day11\assets\image-20250805230903836.png)

### 2、Collections 集合工具类的作用

- java.util.Collections : 是集合工具类；
- 作用：Collections 并不属于集合，是用来操作集合的工具类。

### 3、常见成员方法

![image-20250805231107575](D:\软件工程\Java\java-advanced\day11\assets\image-20250805231107575.png)

### 4、相关API

![image-20250805231142569](D:\软件工程\Java\java-advanced\day11\assets\image-20250805231142569.png)

```java
public static void main(String[] args) {

    ArrayList<String> list = new ArrayList<>();

    // 批量添加元素
    Collections.addAll(list, "a", "b", "c", "d");
    System.out.println(list);

    // 二分查找(前提：排好序的数据)
    int index = Collections.binarySearch(list, "c");
    System.out.println("'c' 的索引是:" + index);

    // 打乱（洗牌）
    Collections.shuffle(list);
    System.out.println(list);

    // 求最大、最小值
    ArrayList<Integer> nums = new ArrayList<>();
    Collections.addAll(nums, 1, 2, 3, 4, 5, 6);

    System.out.println("最大值:" + Collections.max(nums));
    System.out.println("最小值:" + Collections.min(nums));

    System.out.println("------");

    ArrayList<Student> stu = new ArrayList<>();
    Collections.addAll(stu, new Student("张三", 12),
            new Student("李四", 24),
            new Student("王五", 25));
    System.out.println(Collections.max(stu));
    System.out.println(Collections.min(stu));

    // 交换 (通过索引交换元素)
    Collections.swap(stu, 0, 2);
    System.out.println(stu);

    // sort ： 对集合排序
    ArrayList<Integer> box = new ArrayList<>();
    Collections.addAll(box, 1, 3, 5, 2, 4);
    Collections.sort(box, (o1, o2) -> o2 - o1);
    System.out.println(box);
}
```



## 四、Map 接口

### 1、介绍

![image-20250805231332691](D:\软件工程\Java\java-advanced\day11\assets\image-20250805231332691.png)

### 2、使用场景

![image-20250805231401947](D:\软件工程\Java\java-advanced\day11\assets\image-20250805231401947.png)

### 3、Map 常见API

```java
Map 集合常用 API
public V put(K key, V value) :  添加元素(修改 : 如果键已经存在，就会使用新值，替换旧值);
       --- V : 返回的是被覆盖的旧值，如果没有覆盖，返回的是null;无意义
public V remove(Object key) :  根据键删除键值对元素 (键是唯一的)
        --- V : 返回的是删除的键所对应的值
public void clear() : 移除所有的键值对元素
public boolean containsKey(Object key) :   判断集合是否包含指定的键
public boolean containsValue(Object value) :  判断集合是否包含指定的值
public boolean isEmpty() : 判断集合是否为空
public int size() : 集合的长度，也就是集合中键值对的个数
```

```java
public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("张三", "北京");
    map.put("李四", "上海");
    map.put("王五", "成都");
    System.out.println(map);
    System.out.println(map.size());
    System.out.println("------------------");

    System.out.println(map.containsKey("张三"));
    System.out.println(map.containsValue("北京"));
    System.out.println("------------------");

    map.remove("张三");
    System.out.println(map);
    System.out.println("------------------");

    map.clear();
    System.out.println(map);
    System.out.println("------------------");

    System.out.println(map.isEmpty());
    System.out.println(map.size());
    System.out.println("------------------");
}
```



### 4、Map相关集合的特点

- 双列集合的数据结构，都只针对**键有效**，和值没有关系；
- TreeMap：键（红黑树）；
- HashMap：键（哈希表）；
- LinkedHashMap：键（哈希表+双向列表）。

===补充

```java
TreeMap : 键排序(实现Comparable接口，重写CompareTo方法)
HashMap : 键唯一(重写 hashCode和equals方法)
LinkedHashMap : 键唯一，且可以保证存取顺序
```

```java
public static void showTreeMap() {
    TreeMap<Person, String> tm = new TreeMap<>((o1, o2) -> o2.getAge() - o1.getAge());
    tm.put(new Person("李四", 24), "北京");
    tm.put(new Person("张三", 23), "上海");
    tm.put(new Person("王五", 25), "成都");
    tm.put(new Person("赵六", 25), "成都");
    System.out.println(tm);
}

public static void showHashMap() {
    // 与 HashSet一样，底层都是哈希表，需要重写 equals()和 hashCode()方法，才能保证元素唯一性
    HashMap<Person, String> hm = new HashMap<>();
    hm.put(new Person("李四", 24), "北京");
    hm.put(new Person("张三", 23), "上海");
    hm.put(new Person("王五", 25), "成都");
    hm.put(new Person("王五", 25), "成都");
    System.out.println(hm);
}

public static void showLinkedHashMap() {
    LinkedHashMap<Person, String> lhm = new LinkedHashMap<>();
    lhm.put(new Person("李四", 24), "北京");
    lhm.put(new Person("张三", 23), "上海");
    lhm.put(new Person("王五", 25), "成都");
    lhm.put(new Person("王五", 25), "成都");
    System.out.println(lhm);
}
```

===总结

![image-20250805232043539](D:\软件工程\Java\java-advanced\day11\assets\image-20250805232043539.png)

### 5、Map 集合的遍历

#### 5.1、通过键找值

![image-20250805232145680](D:\软件工程\Java\java-advanced\day11\assets\image-20250805232145680.png)

![image-20250805232151155](D:\软件工程\Java\java-advanced\day11\assets\image-20250805232151155.png)

```java
public static void main(String[] args) {
    HashMap<String, String> hm = new HashMap<>();
    hm.put("张三", "北京");
    hm.put("李四", "上海");
    hm.put("王五", "成都");
}
```

```java
private static void method1(HashMap<String, String> hm) {
    /* 通过键找值*/
    // 1.获取到所有的键
    Set<String> keySet = hm.keySet();
    // 2.遍历set集合，得到每一个键
    for (String key : keySet) {
        String value = hm.get(key);
        System.out.println(key + "---" + value);
    }
}
```



#### 5.2、通过键值对对象获取键和值

![image-20250805232340980](D:\软件工程\Java\java-advanced\day11\assets\image-20250805232340980.png)

![image-20250805232356944](D:\软件工程\Java\java-advanced\day11\assets\image-20250805232356944.png)

```java
private static void method2(HashMap<String, String> hm) {
    // 2.获取到所有的键值对对象
    Set<Map.Entry<String, String>> entrySet = hm.entrySet();
    // 遍历set集合，得到每一个键值对对象
    for (Map.Entry<String, String> stringEntry : entrySet) {
        System.out.println(stringEntry.getKey() + "---" + stringEntry.getValue());
    }
}
```



#### 5.3、foreach方法

![image-20250805232501700](D:\软件工程\Java\java-advanced\day11\assets\image-20250805232501700.png)

```java
private static void method3(HashMap<String, String> hm) {
    hm.forEach((key, value) -> System.out.println(key + "---" + value));
}
```



### 6、练习

===练习一：

```java
/*
练习 --- Map集合练习
需求 ： 字符串 aababcabcdabcde
        统计字符串每一个字符出现的次数，并按照一下格式输出
        输出结果：
            a(5)b(4)c(3)d(2)e(1)
*/
```

```java
public static void main(String[] args) {
	print("aababcabcdabcde");
}

public static void print(String msg) {
    TreeMap<Character, Integer> tm = new TreeMap<>();
    char[] chars = msg.toCharArray();

    for (char c : chars) {
      if (!tm.containsKey(c)) {
        tm.put(c, 1);
      } else {
        tm.put(c, tm.get(c) + 1);
      }
    }
    tm.forEach((key, value) -> System.out.print(key + "(" + value + ")"));
}
```

===练习二：

```java
/*
    练习 --- Map集合练习
    定义一个Map集合，键用来表示省份名称，值表示市，但是市会有多少个。
    添加完毕后，遍历结果：
    格式如下：
    江苏省=南京市, 扬州市, 苏州市, 无锡市, 常州市
    湖北省=武汉市, 孝感市, 十堰市, 宜昌市, 鄂州市
    四川省=成都市, 锦阳市, 自贡市, 攀枝花市, 泸州市
 */
```

```java
public static void main(String[] args) {
    HashMap<String, ArrayList> hm = new HashMap<>();
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    ArrayList<String> list3 = new ArrayList<>();
    Collections.addAll(list1, "南京市", "扬州市", "苏州市", "无锡市", "常州市");
    Collections.addAll(list2, "武汉市", "孝感市", "十堰市", "宜昌市", "鄂州市");
    Collections.addAll(list3, "成都市", "锦阳市", "自贡市", "攀枝花市", "泸州市");

    hm.put("江苏省", list1);
    hm.put("湖北省", list2);
    hm.put("四川省", list3);

    hm.forEach((key, value) -> System.out.println(key + "=" + value));
  }
```

