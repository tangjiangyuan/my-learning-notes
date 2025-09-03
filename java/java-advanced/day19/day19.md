## day19、

<img src="D:\软件工程\Java\java-advanced\day19\assets\image-20250809233538967.png" alt="image-20250809233538967" style="zoom:67%;" />

## 一、方法引用

### 1、介绍

- 方法引用是 JDK8开始出现的，主要的作用是【进一步简化Lambda表达式】
- 方法应用使用一对冒号【：：】
- 通过方法的名字来指向一个方向；
- 可以使方法的构造更紧凑简洁，减少冗余代码。

![image-20250809235730401](D:\软件工程\Java\java-advanced\day19\assets\image-20250809235730401.png)

### 2、理解

![image-20250809235807198](D:\软件工程\Java\java-advanced\day19\assets\image-20250809235807198.png)

===问题：参数去哪里了？

===原因：因为【可推导可省略】原则，省略了参数。

### 3、静态方法和非静态方法的使用

- 静态方法：直接类名调用【类名::方法名】
- 非静态方法：创建对象调用【对象名::方法名】

## 二、单元测试

### 1、介绍

- 单元测试：就是针对最小的功能单元（方法），编写测试代码对其正确性进行测试。---一个工具，测试代码正确性。
- JUnit：最流行的 Java测试框架之一，提供了一些方法，方法程序进行单元测试（第三方公司提供）

### 2、与主方法测试的区别

![image-20250810000310276](D:\软件工程\Java\java-advanced\day19\assets\image-20250810000310276.png)

### 3、快速入门

- 在需要测试的方法上，加入【@Test】注解
- 在有外部网络的情况下根据提示敲回车。

![image-20250810000424174](D:\软件工程\Java\java-advanced\day19\assets\image-20250810000424174.png)

===注意：JUnit单元测试类名的命名规范为：XxxTest。JUnit单元测试的方法，必须声明为【public void】【**规定**】。

![image-20250810000531904](D:\软件工程\Java\java-advanced\day19\assets\image-20250810000531904.png)

===补充，测试的方法不能有返回值，因为没有人传参，也没有人接收参数

===错误演示：单个方法有错，并不会影响其它方法的测试。

![image-20250810000737004](D:\软件工程\Java\java-advanced\day19\assets\image-20250810000737004.png)

===小结

![image-20250810000755673](D:\软件工程\Java\java-advanced\day19\assets\image-20250810000755673.png)

## 三、XML

### 1、介绍

- 可扩展标记语言（Extensible Markup Language，简称XML），是一种标记语言。
- <>:开始；</>:结束
- 可扩展：表示尖括号内的名称可以由自己制定。

![image-20250810000938648](D:\软件工程\Java\java-advanced\day19\assets\image-20250810000938648.png)

### 2、作用

- 常用于【配置文件】和【存储数据】。

### 3、XML语法

- 创建一个XML类型的文件，要求文件的后缀必须使用xml，如：hello.xml；
- 编写文档声明（必须是第一行第一列）；

![image-20250810001116595](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001116595.png)

- 编写根标签（必须存在一个根标签，且有且只有一个），标签必须成对出现；

![image-20250810001204928](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001204928.png)

- 特殊的标签可以不成对，但是必须有结束标记<address/>；
- 标签中可以定义属性，属性和标签名空格隔开，属性值必须用引号引起来；

![image-20250810001324495](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001324495.png)

- 标签需要正确的嵌套

![image-20250810001341612](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001341612.png)

- 注释快捷键：ctrl + /

### 4、代码演示

（1）

![image-20250810001436785](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001436785.png)

查看效果：

![image-20250810001457868](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001457868.png)

![image-20250810001508933](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001508933.png)

（2）

![image-20250810001525141](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001525141.png)

![image-20250810001530357](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001530357.png)

### 5、XML约束（了解）

- 作用：有了约束，就可以根据提示，编写代码了，更加方便。

![image-20250810001634367](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001634367.png)

#### 5.1、dtd 约束

![image-20250810001642143](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001642143.png)

![image-20250810001704727](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001704727.png)

（1）本地引入

![image-20250810001718483](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001718483.png)

（2）内部引入---了解

![image-20250810001747864](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001747864.png)

（3）网络引入

![image-20250810001804920](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001804920.png)

#### 5.2、schema 约束

（1）介绍

![image-20250810001831848](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001831848.png)

（2）步骤

![image-20250810001921143](D:\软件工程\Java\java-advanced\day19\assets\image-20250810001921143.png)

![image-20250810002002224](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002002224.png)

（3）xml中引入单个xsd约束

![image-20250810002051307](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002051307.png)

（4）引入多个xsd约束（掌握）

![image-20250810002140495](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002140495.png)

===补充：此时不能创建多个<student>标签，需要添加属性

![image-20250810002341740](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002341740.png)

===如果想要在标签中添加 id属性，则需要添加属性值

![image-20250810002508066](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002508066.png)

![image-20250810002512244](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002512244.png)

### 6、XML解析

#### 6.1、SAX 解析

![image-20250810002539435](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002539435.png)

#### 6.2、DOM 解析（推荐）

![image-20250810002559670](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002559670.png)

![image-20250810002617590](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002617590.png)

#### 6.3、解析使用的API

![image-20250810002622882](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002622882.png)

#### 6.4、Dom4j的使用

![image-20250810002657697](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002657697.png)

![image-20250810002711826](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002711826.png)

![image-20250810002717515](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002717515.png)

![image-20250810002723787](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002723787.png)

![image-20250810002740382](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002740382.png)

#### 6.5、常用方法

![image-20250810002824913](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002824913.png)

![image-20250810002910848](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002910848.png)

![image-20250810002930955](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002930955.png)

![image-20250810002945788](D:\软件工程\Java\java-advanced\day19\assets\image-20250810002945788.png)

## 四、注解

### 1、介绍

- Annotation 表示注解，JDK 1.5 的新特性

### 2、作用

- 对程序进行标注

### 3、理解

- 注释是给人看的，注解是给虚拟机看的；
- 通过注解可以给类增加额外的信息；
- 编译器或JVM可以根据注解来完成对应的功能。

#### 4、常见注解

#### 4.1、@Override

- 表示方法重写

#### 4.2、@Deprecated

- 表示修饰的方法已过时，只是提示，但还是可以使用

![image-20250810003322450](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003322450.png)

#### 4.3、@SupportWarning("ALL")

- 压制警告

![image-20250810003329451](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003329451.png)

![image-20250810003429267](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003429267.png)

#### 4.4、@FunctionalInterface

- 表示该接口是函数式接口（只有一个抽象方法）--- 可以使用 Lambda表达式

#### 4.5、@Document

- 属性值为：true，表示当 javadoc后将注解信息写入文档，让使用者看到；false，表示在 javadoc后注解信息不写入文档。

#### 4.6、@Inherited

- 属性值为：true，表示允许子类自动继承父类带有的注解；false，表示不允许子类自动继承父类带有的注解。

### 5、自定义注解

#### 5.1、介绍

- 自定义注解单独意义不大，一般会跟反射结合起来使用。

#### 5.2、格式

![image-20250810003513647](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003513647.png)

===补充：注解里的属性需要带有小括号，并不是方法

![image-20250810003610857](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003610857.png)

===补充：public abstract 可以省略

![image-20250810003630514](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003630514.png)

===补充：给属性赋值的方法---通过default关键字

![image-20250810003644482](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003644482.png)

===补充：注解中还可以添加常量

![image-20250810003733045](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003733045.png)

#### 5.3、自定义注解的使用

===补充：可以用在类、方法、变量上

![image-20250810003837992](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003837992.png)

===补充：如果在定义注解的时候没有赋值，必须要在使用注解的时候赋值

![image-20250810003924387](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003924387.png)

![image-20250810003928858](D:\软件工程\Java\java-advanced\day19\assets\image-20250810003928858.png)

===补充：如果数组中只有一个属性值，在使用时{}是可以省略的。

![image-20250810004041213](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004041213.png)

![image-20250810004045669](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004045669.png)

===补充：特殊的属性---value

​		定义的注解中如果有多个属性没有赋值，使用时需要全部赋值；

​		如果只有一个属性名字为value，没有赋值，使用时直接给出值，不需要写属性名。

![image-20250810004217462](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004217462.png)

### 6、案例

![image-20250810004236378](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004236378.png)

![image-20250810004251948](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004251948.png)

![image-20250810004257115](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004257115.png)

![image-20250810004308768](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004308768.png)

![image-20250810004341799](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004341799.png)

===问题：为什么在控制台没有打印信息？

===回答：我们编写的注解的生命周期只到字节码；活不到运行阶段

===解决：使用元注解

### 7、元注解

![image-20250810004524318](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004524318.png)

#### 7.1、@Target

![image-20250810004537989](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004537989.png)

===例如：@Override

![image-20250810004609908](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004609908.png)

#### 7.2、@Retention

![image-20250810004625610](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004625610.png)

===代码优化：

![image-20250810004700911](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004700911.png)

![image-20250810004704059](D:\软件工程\Java\java-advanced\day19\assets\image-20250810004704059.png)