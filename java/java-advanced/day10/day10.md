## day10、

![image-20250804225501081](D:\软件工程\Java\java-advanced\day10\assets\image-20250804225501081.png)

## 一、泛型（Generics）

### 1、介绍

- JDK 5 引入的，可以在编译阶段约束操作的数据类型，并进行检查；
- 泛型的默认类型是 Object；
- 泛型只能使用引用数据类型。

### 2、好处

- 统一数据类型
- 将运行期错误提前到编译期

### 3、学习路径

#### 3.1、泛型类

```java
/*
    泛型类 : 创建对象的时候，要确定类型

    常见的泛型标识符 ： E V K T

        E : Element
        T : Type
        K : Key (键)
        V : Value (值)

    清楚不同的泛型，在什么时机能确定到具体的类型
*/
```



#### 3.2、泛型方法

```java
1. 非静态方法 ： 内部的泛型，会根据类的泛型去匹配
2. 静态方法 ： 静态方法中如果加入了泛型，必须声明出自己独立的泛型
        - 时机 ： 在调用方法，传入实际参数的时候，确定到具体的类型
```



#### 3.3、泛型接口

```java
1. 实现类，实现接口的时候确定到具体类型
2. 实现类实现接口，没有指定具体类型，就让接口的泛型，跟着类的泛型去匹配（实现类创建对象时给出具体类型）
```

```java
interface Inter<E> {
    void show(E e);
}

class InterAImpl implements Inter<String> {

    @Override
    public void show(String s) {}
}

class InterBImpl<E> implements Inter<E> {

    @Override
    public void show(E e) {
        System.out.println(e);
    }
}
```

```java
public static void main(String[] args) {
    InterBImpl<String> ib = new InterBImpl<>();
    ib.show("Hello World！");
}
```



#### 3.4、泛型通配符

```java
泛型通配符
    ? : 任意类型(不推荐)
    ? extends E : 可以传入的是 E 或者是 E 的子类。
    ? super E : 可以传入的是 E 或者是 E 的父类。
```



#### 3.5、泛型的限定

![image-20250804230854830](D:\软件工程\Java\java-advanced\day10\assets\image-20250804230854830.png)

## 二、数据结构（树）

### 1、介绍

![image-20250804231005279](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231005279.png)

![image-20250804231010852](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231010852.png)

### 2、相关名词概念

（1）度：每一个节点的子节点数量（二叉树中，任意节点的度 <= 2）；

（2）树高：树的层数；

（3）根节点：最顶层的节点；

（4）左子节点：左下方的节点；

（5）右子节点：右下方的节点；

（6）根节点的左子树：蓝色虚线；

（7）根节点的右子树：绿色虚线。

![image-20250804231340345](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231340345.png)

### 3、二叉树

#### 3.1、普通二叉树

​	特点：乱序，查询不方便。

![image-20250804231408376](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231408376.png)

#### 3.2、二叉查找树

​	特点：左边的数据都比根节点小，右边的数据都比根节点大。

![image-20250804231508662](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231508662.png)

### 4、二叉查找树（二叉排序树、二叉搜索树）

#### 4.1、特点

- 每一个节点节点上最多有两个子节点
- 任意节点左子树上的指都小于当前节点
- 任意节点右子树上的指都大于当前节点

#### 4.2、添加方法

- 第一个数据一般作为根节点；
- 小的存左边；
- 大的存右边；
- 一样的不存。

![image-20250804231712779](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231712779.png)

![image-20250804231718942](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231718942.png)

#### 4.3、弊端

​	可能形成瘸子树。

![image-20250804231740877](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231740877.png)

### 5、平衡二叉树（避免瘸子树）

![image-20250804231805879](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231805879.png)

#### 5.1、规则

​	任意节点左右子树的高度差不超过1.

![image-20250804231842539](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231842539.png)

![image-20250804231848718](D:\软件工程\Java\java-advanced\day10\assets\image-20250804231848718.png)

#### 5.2、旋转机制

- 触发时机：当添加一个节点之后，该树不再是一个平衡二叉树；
- 当左边数据多于右边时，进行右旋；当右边数据多于左边时，进行左旋；

（1）左旋

- 以不平衡的点作为支点；
- 把支点左旋降级，变成左子节点；
- 晋升原来的右子节点。

例一：在平衡二叉树的右子节点加入新节点，使其不平衡

![image-20250804232307770](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232307770.png)

![image-20250804232311927](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232311927.png)

![image-20250804232318348](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232318348.png)

![image-20250804232329127](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232329127.png)

![image-20250804232334945](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232334945.png)

例二：

![image-20250804232426599](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232426599.png)

![image-20250804232455317](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232455317.png)

（2）右旋

- 以不平衡的点作为支点；
- 把支点右旋降级，变成右子节点；
- 晋升原来的左子节点。

例一：在平衡二叉树的左字节加入新节点，使其不平衡

![image-20250804232600545](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232600545.png)

![image-20250804232607077](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232607077.png)

![image-20250804232640880](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232640880.png)

![image-20250804232706714](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232706714.png)

![image-20250804232711489](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232711489.png)

例二：

![image-20250804232721757](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232721757.png)

![image-20250804232729302](D:\软件工程\Java\java-advanced\day10\assets\image-20250804232729302.png)

#### 5.3、需要旋转的四种情况

（1）左左：一次右旋

![image-20250804233036897](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233036897.png)

（2）左右：先局部左旋，再整体右旋

![image-20250804233104359](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233104359.png)

![image-20250804233125442](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233125442.png)

![image-20250804233134691](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233134691.png)

（3）右右：一次左旋

![image-20250804233151075](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233151075.png)

![image-20250804233159853](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233159853.png)

（4）右左：先局部右旋，再整体左旋

![image-20250804233205360](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233205360.png)

![image-20250804233211031](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233211031.png)

![image-20250804233216691](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233216691.png)

### 6、红黑树

#### 6.1、概念

- 红黑树是一种**自平衡**的**二叉查找树**，是计算机科学中用到的一种数据结构；
- 1972年出现的，当时被称为平衡二叉B树。后来，1978年被修改为如今的“红黑树”；
- 它是一种特殊的二叉查找树，红黑树的每一个节点上都有存储位表示节点的颜色；
- 每一个节点可以是红色或者黑色；红黑树**不是高度平衡的**，它的平衡是通过“**红黑规则**”进行实现的。

![image-20250804233533643](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233533643.png)

#### 6.2、红黑树与二叉平衡树的区别

![image-20250804233541463](D:\软件工程\Java\java-advanced\day10\assets\image-20250804233541463.png)

#### 6.3、红黑规则

- 每一个节点要么是红色，要么是黑色的；
- 根节点必须是黑色的；
- 如果一个节点没有子节点或者父节点，则该节点相应的属性值为Nill，这些Nill视为叶节点，每个叶节点（Nill）都是黑色的；
- 如果某一个节点是红色，那么它的子节点必须是黑色（不能出现两个红色节点相连的情况）；
- 对每一个节点，从该节点到其所有后代节点的简单路径上，均包含形同数目的黑色节点。

#### 6.4、加点原则

​	默认颜色：添加节点的颜色默认是红色的（效率更高）

**![image-20250804234039906](D:\软件工程\Java\java-advanced\day10\assets\image-20250804234039906.png)**

## 三、TreeSet 集合

### 1、特点

​	排序、去重

### 2、作用

​	对集合中的元素进行排序操作（底层红黑树实现）

![image-20250804234128618](D:\软件工程\Java\java-advanced\day10\assets\image-20250804234128618.png)

### 3、排序

#### 3.1、自然排序

![image-20250804234210639](D:\软件工程\Java\java-advanced\day10\assets\image-20250804234210639.png)

![image-20250804234226955](D:\软件工程\Java\java-advanced\day10\assets\image-20250804234226955.png)

#### 3.2、比较器排序

![image-20250804234340699](D:\软件工程\Java\java-advanced\day10\assets\image-20250804234340699.png)

![image-20250804234401933](D:\软件工程\Java\java-advanced\day10\assets\image-20250804234401933.png)

#### 3.3、两种排序的使用场景

===注意===

​	比较器的优先级高于自然排序

![image-20250804234428251](D:\软件工程\Java\java-advanced\day10\assets\image-20250804234428251.png)