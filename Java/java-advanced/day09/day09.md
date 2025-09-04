## day09、

<img src="D:\软件工程\Java\java-advanced\day09\assets\image-20250804005407018.png" alt="image-20250804005407018" style="zoom:67%;" />

## 一、集合体系结构

### 1、分类

![image-20250804222734269](D:\软件工程\Java\java-advanced\day09\assets\image-20250804222734269.png)

### 2、单列集合

![image-20250804222739775](D:\软件工程\Java\java-advanced\day09\assets\image-20250804222739775.png)

### 3、双列集合

![image-20250804222750873](D:\软件工程\Java\java-advanced\day09\assets\image-20250804222750873.png)

## 二、Collection 接口

### 1、常用成员方法

```java
public boolean add(E e) : 把给定的对象添加到当前集合中
public void clear() : 清空集合中所有的元素
public boolean remove(E e) : 把给定的对象在当前集合中删除
public boolean contains(Object obj) : 判断当前集合中是否包含给定的对象
public boolean isEmpty() : 判断当前集合是否为空
public int size() : 返回集合中元素的个数(集合的长度)
```

===注意===

​	remove() contains() 底层依赖对象的 equals方法

```java
public static void main(String[] args) {

    // 多态
    Collection<Student> c = new ArrayList<>();

    c.add(new Student("张三", 23));
    c.add(new Student("李四", 24));
    c.add(new Student("王五", 25));

    System.out.println(c);

    // remove() 方法，在删除数据时，比较的是地址值，想要删除数据，需要重写对象的equals方法
    c.remove(new Student("李四", 24));
    System.out.println(c);

    // contains() 方法，同样依赖重写的equals方法
    System.out.println(c.contains(new Student("李四", 24)));
}
```

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return age == student.age && Objects.equals(name, student.name);
}
```



### 2、集合通用的遍历方式

```java
public Iterator<E> iterator() : 返回此集合中的元素的迭代器。
public E next() : 从集合中获取一个元素。
public boolean hasNext() : 如果迭代具有更多元素，则返回 true 。

注意：如果调用多次next方法，当集合中没有元素时，就会报出 NoSuchElementException异常
```



#### 2.1、迭代器

![image-20250804223305495](D:\软件工程\Java\java-advanced\day09\assets\image-20250804223305495.png)

![image-20250804223311728](D:\软件工程\Java\java-advanced\day09\assets\image-20250804223311728.png)

===迭代器原码解析===

![image-20250804223339427](D:\软件工程\Java\java-advanced\day09\assets\image-20250804223339427.png)

===小结

![image-20250804223358903](D:\软件工程\Java\java-advanced\day09\assets\image-20250804223358903.png)

#### 2.2、增强 for循环

![image-20250804223418016](D:\软件工程\Java\java-advanced\day09\assets\image-20250804223418016.png)

![image-20250804223423996](D:\软件工程\Java\java-advanced\day09\assets\image-20250804223423996.png)

#### 2.3、foreach 方法

![image-20250804223436758](D:\软件工程\Java\java-advanced\day09\assets\image-20250804223436758.png)

## 三、List 接口

### 1、特点

​	存储有序、有索引、可存储重复的数据

### 2、List 独特API

```java
public void add(int index, E element) : 在指定的索引位置，添加元素
public E remove(int index) : 根据索引删除集合中的元素
public E set(int index, E element) : 根据索引修改集合的元素
public E get(int index) : 返回指定索引处的元素
```

### 3、并发修改异常

![image-20250804223749876](D:\软件工程\Java\java-advanced\day09\assets\image-20250804223749876.png)

```java
并发修改异常 ： ConcurrentModificationException
场景 ： 使用[迭代器]遍历集合的过程中，调用了[集合对象]的添加，删除方法，就会出现此异常

解决方案 ：迭代器的遍历过程中，不允许使用集合对象的添加或删除，那就使用迭代器，自己的添加或删除方法

删除方法 ： 普通的迭代器有，List集合也有
添加方法 ： 普通的迭代器没有，需要使用 List集合特有的迭代器
```



### 4、List集合的遍历方式

#### 4.1、迭代器

![image-20250804223837580](D:\软件工程\Java\java-advanced\day09\assets\image-20250804223837580.png)

==扩展===

​	迭代器遍历集合的过程中，使用集合的删除方法，删除倒数第二个元素，就不会出现错误。

#### 4.2、增强 for循环

```java
/**
 * 增强 for循环
 * @param list
 */
private static void method2(List<String> list) {
    for (String s : list) {
        System.out.println(s);
    }
}
```



#### 4.3、foreach方法

```java
**
 * foreach 方法
 * @param list
 */
private static void method3(List<String> list) {
    list.forEach(new Consumer<String>() {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    });
}
```



#### 4.4、普通 for循环

```java
/**
 * 普通 for循环
 * @param list
 */
private static void method4(List<String> list) {
    for (int i = 0; i < list.size(); i++) {
        String s = list.get(i);
        System.out.println(s);
    }
}
```



#### 4.5、ListIerator（List集合特有的迭代器）

```java
public static void main(String[] args) {

    List<String> list = new ArrayList<>();
    list.add("张三");
    list.add("李四");
    list.add("王五");

    ListIterator<String> it = list.listIterator();

    // 正序遍历
    while (it.hasNext()) {
        System.out.println(it.next());
    }
    System.out.println("---------------------");

    // 倒叙遍历
    while (it.hasPrevious()) {
        System.out.println(it.previous());
    }
}
```



## 四、数据结构

### 1、介绍

- 数据结构是计算机底层存储、组织数据的方式，是指数据之间以什么方式排列在一起的；
- 通常情况下，精心选择的数据结构可以带来更高的运行或存储效率。

===总结===

![image-20250804224534194](D:\软件工程\Java\java-advanced\day09\assets\image-20250804224534194.png)

### 2、栈

![image-20250804224539504](D:\软件工程\Java\java-advanced\day09\assets\image-20250804224539504.png)

### 3、队列

![image-20250804224547994](D:\软件工程\Java\java-advanced\day09\assets\image-20250804224547994.png)

### 4、数组

![image-20250804224553410](D:\软件工程\Java\java-advanced\day09\assets\image-20250804224553410.png)

### 5、链表

![image-20250804224629220](D:\软件工程\Java\java-advanced\day09\assets\image-20250804224629220.png)

#### 5.1、介绍

​	链表中的结点是独立的对象，在内存中是不连续的，每个结点包含数据值和下一个结点的地址。

#### 5.2、优缺点

（1）优点

​	链表增删相对快；

（2）缺点

​	链表查询慢，无论查询哪个数据都要从头开始找。

===注意===

​	链表是一种增删块的模型（对比数组）

![image-20250804224933201](D:\软件工程\Java\java-advanced\day09\assets\image-20250804224933201.png)

#### 5.3、单链表

![image-20250804224942617](D:\软件工程\Java\java-advanced\day09\assets\image-20250804224942617.png)

#### 5.4、双链表

![image-20250804224947677](D:\软件工程\Java\java-advanced\day09\assets\image-20250804224947677.png)

## 五、ArrayList 类

### 1、介绍

​	ArrayList 底层是基于数组实现的，查询元素快，增删相对慢。

### 2、扩容原理

![image-20250804225047364](D:\软件工程\Java\java-advanced\day09\assets\image-20250804225047364.png)

​	开始时，集合中没有元素，集合的长度为0；

![image-20250804225114440](D:\软件工程\Java\java-advanced\day09\assets\image-20250804225114440.png)

​	只有调用一次add方法后，集合才会扩容为10；

![image-20250804225144710](D:\软件工程\Java\java-advanced\day09\assets\image-20250804225144710.png)

## 六、LinkedList 类

### 1、介绍

​	LinkedList 底层基于双链表实现的，查询元素慢，增删首尾元素是非常快的。

### 2、常用成员方法

```java
public void addFirst(E e) : 头部添加
public void addLast(E e) : 尾部添加
public E getFirst() : 获取第一个
public E getLast() :  获取最后一个
public E removeFirst() : 删除第一个
public E removeLast() : 删除最后一个
```

===补充===

```java
/*
    LinkedList 集合，底层是双向链表结构，查找元素的时候会从头部，或者尾部逐个查找，
    但是它是属于 List体系中的集合，也可以使用 get方法，根据索引直接获取元素.

    通过 get方法获取传入的索引，get方法中再调用一个node(结点)方法，将传入的索引与结点通过位运算之后的值比较
    如果小于该值，则从头部开始查找，否则，从尾部开始查找
 */
```

