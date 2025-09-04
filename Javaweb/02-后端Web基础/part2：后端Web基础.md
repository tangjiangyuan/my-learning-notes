# part2：后端Web基础

# 一、Maven、HTTP

## 1、Maven

### 1.1、Maven介绍

是一款用于**管理**和**构建**Java项目的工具，是apache旗下的一个开源项目。它基于项目对象模型（Project Object Model，POM）的概念，通过一小段描述信息来管理项目的构建。

官网：http://maven.apache.org/

![image-20250729145507657](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729145507657.png)

1.2、Maven的作用

（1）依赖管理：方便快捷的管理项目依赖的资源（jar包）。

（2）项目构建：标准化的跨平台（Linux、Windows、MacOS）的自动化项目构建方式。

（3）统一项目结构：提供标准、统一的项目结构。

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729150554702.png" alt="image-20250729150554702" style="zoom:67%;" />

## 2、Maven核心

### 2.1、Maven概述

结构：

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729151438855.png" alt="image-20250729151438855" style="zoom:67%;" />

仓库：本地、私服、中央

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729151829110.png" alt="image-20250729151829110" style="zoom:80%;" />

小结：

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729152318280.png" alt="image-20250729152318280" style="zoom:80%;" />

#### 2.1.1、Maven安装

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729152501532.png" alt="image-20250729152501532" style="zoom:67%;" />

验证：mvn -v

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729161235371.png" alt="image-20250729161235371" style="zoom:67%;" />

### 2.2、IDEA集成Maven

#### 2.2.1、创建Maven项目

![image-20250729163855196](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729163855196.png)

#### 2.2.2、Maven坐标

（1）介绍

Maven中的坐标是**资源（jar）的唯一标识，通过该坐标可以唯一定位资源位置**。

使用坐标来**定义项目**或**引入项目中需要的依赖**。

（2）Maven 坐标主要组成

- groupId：定义当前Maven项目隶属组织名称（通常是域名反写，例如：com.baidu）。
- artifactId：定义当前Maven项目名称（通常是模块名称，例如：maven-project）。
- version：定义当前项目的版本号。
  - SNAPSHOT：功能不稳定、尚处于开发中的版本，即快照版本。
  - RELEASE：功能趋于稳定、当前更新停止，可以用于发行的版本。

```xml
<groupId>com.tjy</groupId>
<artifactId>maven-project01</artifactId>
<version>1.0-SNAPSHOT</version>
```

#### 2.2.3、导入Maven项目

（1）方式一

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729165210288.png" alt="image-20250729165210288" style="zoom:67%;" />

（2）方式二

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729165246419.png" alt="image-20250729165246419" style="zoom: 80%;" />

小结：

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250729165538464.png" alt="image-20250729165538464" style="zoom:67%;" />

### 2.3、依赖管理

#### 2.3.1、介绍

指当前项目运行所需要的jar包，一个项目中可以引入多个依赖。

#### 2.3.2、配置

（1）在pom.xml 中编写<dependencies>标签

（2）在<dependencies>标签中，使用<dependency>引入坐标

（3）定义坐标的 groupId、artifactId、version

（4）点击刷新按钮，引入最新加入的坐标

Maven依赖官网：https://mvnrepository.com/

#### 2.3.3、依赖排除

![image-20250730193742535](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730193742535.png)

```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.2.7</version>
        <!--排除依赖-->
        <exclusions>
            <exclusion>
                <artifactId>io.micrometer</artifactId>
                <groupId>micrometer-observation</groupId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>
```

### 2.4、生命周期

#### 2.4.1、介绍

Maven的生命周期就是为了对所有的Maven项目构建过程进行抽象和统一。

#### 2.4.2、Maven中的3套项目独立的生命周期

（1）clean：清理工作。

（2）default：核心工作，如：编译、测试、打包、安装、部署等。

（3）site：生成报告、发布站点等。

![image-20250730195119723](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730195119723.png)

![image-20250730195302581](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730195302581.png)

--- 注意：在**同一套**声明周期中，当运行到后面的阶段时，前面的阶段都会运行。

在运行install时，除了clean，其它阶段都会运行，因为clean不属于default生命周期。

#### 2.4.3、执行指定生命周期的两种方式

（1）在idea中，右侧的maven工具栏，选中对应的生命周期，双击执行。

（2）在命令行中，通过命令执行。

### 2.5、单元测试

#### 2.5.1、测试

（1）测试：是一种用来促进鉴定软件的正确性、完整性、安全性和质量的过程。

（2）阶段划分：单元测试、继承测试、系统测试、验收测试。

![image-20250730200654076](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730200654076.png)

（3）测试方法：白盒测试、黑盒测试和灰盒测试。

![image-20250730200912062](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730200912062.png)

![image-20250730201008193](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730201008193.png)

#### 2.5.2、快速入门

（1）单元测试：就是针对最小的功能单元（方法），编写测试代码对其正确性进行测试。

（2）JUnit：最流行的Java测试框架之一，提供了一些功能，方便程序进行单元测试（第三方公司提供）。

![image-20250730201648209](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730201648209.png)

（3）案例

![image-20250730202025847](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730202025847.png)

![image-20250730201951706](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730201951706.png)

```xml
<!--JUnit依赖-->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.1</version>
    <scope>test</scope>
</dependency>
```

![image-20250730203503936](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730203503936.png)

（4）小结

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730203633157.png" alt="image-20250730203633157" style="zoom:80%;" />

#### 2.5.3、断言

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730203821300.png" alt="image-20250730203821300" style="zoom:67%;" />

（1）介绍

JUnit提供了一些辅助方法，用来帮助我们确定被测试的方法是否按照预期的效果正常工作，这种方式称为**断言**。

![image-20250730204511555](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730204511555.png)

（2）演示一

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730204824118.png" alt="image-20250730204824118" style="zoom:80%;" />

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730204859732.png" alt="image-20250730204859732" style="zoom:80%;" />

（3）演示二

![image-20250730205738365](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730205738365.png)

测试实际抛出的异常是否是我期望的异常，如果一致，则测试通过；反之，不通过。

![image-20250730205916233](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730205916233.png)

（4）小结

![image-20250730210028114](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730210028114.png)

#### 2.5.4、常见注解

（1）注解

![image-20250730214034304](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730214034304.png)

演示一：

```java
@BeforeAll  // 在所有的单元测试方法运行之前，运行一次
public static void beforeAll() { // 静态
    System.out.println("before All");
}

@AfterAll   // 在所有的单元测试方法运行之后，运行一次
public static void afterAll() { // 静态
    System.out.println("after All");
}

@BeforeEach // 在每一个单元测试方法运行之前，都会运行一次，通常用来初始化
public void beforeEach() { // 非静态
    System.out.println("before Each");
}

@AfterEach  // 在每一个单元测试方法运行之后，都会运行一次
public void afterEach() { // 非静态
    System.out.println("after Each");
}
```

演示二：@ParameterizedTest、@ValueSource

![image-20250730231735243](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730231735243.png)

（2）小结

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730231930071.png" alt="image-20250730231930071" style="zoom:80%;" />

（3）单元测试-企业开发规范

原则：编写测试方法时，要尽可能的覆盖业务方法中所有可能的情况（尤其是边界值）。

![image-20250730232439181](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730232439181.png)

```java
@DisplayName("测试用户服务")
public class UserService2Test {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    @DisplayName("获取性别 - null值")
    public void testGetGender1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender(null));
    }

    @Test
    @DisplayName("获取性别 - 空值")
    public void testGetGender2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender(""));
    }

    @Test
    @DisplayName("获取性别 - 非法值小于18位")
    public void testGetGender3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender("100"));
    }

    @Test
    @DisplayName("获取性别 - 非法值大于18位")
    public void testGetGender4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender("11000020001001001111"));
    }

    @Test
    @DisplayName("正常获取性别 - 男")
    public void testGetGender5() {
        String gender = userService.getGender("110000200010010011");
        Assertions.assertEquals("男", gender);
    }

    @Test
    @DisplayName("正常获取性别 - 女")
    public void testGetGender6() {
        String gender = userService.getGender("110000200010010021");
        Assertions.assertEquals("女", gender);
    }
}
```

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730234709962.png" alt="image-20250730234709962" style="zoom:80%;" />

（4）单元测试 - 覆盖率

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730235307001.png" alt="image-20250730235307001" style="zoom:80%;" />

![image-20250730235329082](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250730235329082.png)

选择自己想要测试的类/包

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731000941097.png" alt="image-20250731000941097" style="zoom:67%;" />

（5）案例 --- 使用AI帮助我们完成单元测试

![image-20250731001133981](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731001133981.png)

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731001919531.png" alt="image-20250731001919531" style="zoom:67%;" />

#### 2.5.5、依赖范围

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731090800903.png" alt="image-20250731090800903" style="zoom:80%;" />

（1）介绍：依赖的jar包，默认情况下，可以在任何地方使用。可以通过<scope>...</scope>设置其作用范围。

（2）作用范围：

- 主程序范围有效。（main文件夹范围内）
- 测试程序范围有效。（test文件夹范围内）
- 是否参与打包运行。（package指令范围内）

![image-20250731091156166](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731091156166.png)

#### 2.5.6、maven常见异常

异常一：

![image-20250731101323363](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731101323363.png)

解决：到该路径下删除该插件版本，使用版本更高的插件

![image-20250731101339565](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731101339565.png)

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.5.2</version>
        </plugin>
    </plugins>
</build>
```

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731101524826.png" alt="image-20250731101524826" style="zoom:80%;" />

扩展 --- 当单元测试通过后，可以取消该按钮的选择，跳过测试。

![image-20250731101820018](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731101820018.png)

问题二：

![image-20250731102327897](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731102327897.png)

或者使用该.bat文件，即可删除

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731102631928.png" alt="image-20250731102631928" style="zoom:67%;" />

![image-20250731102711874](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731102711874.png)

## 3、Maven进阶

### 3.1、分模块设计

### 3.2、继承

### 3.3、聚合

### 3.4、私服

## 4、Web基础

### 4.1、引言

（1）静态资源：服务器上存储的不会改变的数据，通常不会根据用户的请求而变化。比如：HTML、CSS、JS、图片、视频等（负责页面展示）

（2）动态资源：服务器端根据用户请求和其它数据动态生成的，内容可能会在每次请求时都发生变化。比如：Servlet、JSP等（负责逻辑处理）

![image-20250731110523882](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731110523882.png)

![image-20250731110542983](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731110542983.png)

### 4.2、SpringBoot Web入门

#### 4.2.1、Spring

（1）官网：spring.io

（2）Spring发展到今天已经形成了一种开发生态圈，Spring提供了若干个子项目，每个项目用于完成特定的功能。

![image-20250731111232175](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731111232175.png)

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731111329440.png" alt="image-20250731111329440" style="zoom:80%;" />

#### 4.2.2、SpringBoot

（1）介绍：SpringBoot可以帮助我们非常快速的构建应用程序、简化开发、提高效率。

（2）入门程序

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731111712995.png" alt="image-20250731111712995" style="zoom:80%;" />

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731111908282.png" alt="image-20250731111908282" style="zoom:67%;" />

过程：

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731112337589.png" alt="image-20250731112337589" style="zoom:67%;" />

可以删除的文件：

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731112843293.png" alt="image-20250731112843293" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731112912016.png" alt="image-20250731112912016" style="zoom:67%;" />

（3）可能出现的异常

===start.spring.io

===start.aliyun.com

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731135539115.png" alt="image-20250731135539115"  />

（4）入门程序剖析

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731140559450.png" alt="image-20250731140559450" style="zoom:80%;" />

实际是启动了tomcat的服务器

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731140758024.png" alt="image-20250731140758024" style="zoom:80%;" />

### 4.3、HTTP协议

#### 4.3.1、介绍

概念：Hyper Test Transfer Protocol，超文本传输协议，规定了浏览器和服务器之间的数据传输规则。

![image-20250731141315295](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731141315295.png)

#### 4.3.2、特点

（1）基于TCP协议：面向连接，安全

（2）基于请求-响应模型的：一次请求对应一次响应

（3）HTTP协议是无状态（请求和响应之间是相互独立的）的协议：对于事务处理没有记忆能力。每次请求-响应都是独立的。

- 缺点：多次请求间不能共享数据。
- 优点：速度快。

#### 4.3.3、HTTP-请求协议

##### 4.3.3.1、请求数据格式

![](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731142529077.png)

（1）常见请求头

![image-20250731142446077](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731142446077.png)

（2）小结

![image-20250731142745638](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731142745638.png)

##### 4.3.3.2、请求数据获取

（1）Web服务器（Tomcat）对HTTP协议的请求数据进行解析，并进行了封装(HttpServletRequest)，在调用Controller方法的时候传递给了该方法。这样，就使得程序员不必直接对协议进行操作，让Web开发更加便捷。

（2）演示

```java
@RestController
public class RequestController {

    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        // 1. 获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式:" + method);
        // 2. 获取请求url路径
        String uri = request.getRequestURI(); // 获取资源访问路径 /request
        System.out.println("请求uri路径:" + uri);
        String url = request.getRequestURL().toString(); // 获取完整资源路径
        System.out.println("请求url路径:" + url);
        // 3. 获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议:" + protocol);
        // 4. 获取请求参数 - name
        String name = request.getParameter("name");
        System.out.println("请求参数:" + name);
        // 5. 获取请求头 - Accept
        String requestHeader = request.getHeader("Accept");
        System.out.println("请求头:" + requestHeader);
        return "OK";
    }

}
```

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731145052741.png" alt="image-20250731145052741" style="zoom:80%;" />

（3）小结

![image-20250731145252835](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731145252835.png)

#### 4.3.4、HTTP-响应协议

##### 4.3.4.1、响应数据格式

![image-20250731145503932](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731145503932.png)

（1）响应状态码

![image-20250731145625586](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731145625586.png)

扩展 --- 重定向

![image-20250731145759076](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731145759076.png)

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731150021419.png" alt="image-20250731150021419" style="zoom: 67%;" />

（2）小结

![image-20250731151036281](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731151036281.png)

##### 4.3.4.2、响应数据设置

（1）Web服务器对HTTP协议的响应数据进行了封装(HttpServletResponse)，并在调用Controller方法的时候传递给了该方法。这样，就使得程序员不必直接对协议进行操作，让Web开发更加便捷。

![image-20250731153244303](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731153244303.png)

（2）演示

```java
@SuppressWarnings("ALL")
@RestController
public class ResponseController {

    /**
     * 方式一: HttpServletResponse 设置响应数据
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse  response) throws IOException {
        // 1. 设置响应状态码
        response.setStatus(401);
        // 2. 设置响应头
        response.setHeader("name", "tjy");
        // 3. 设置响应体
        response.getWriter().write("<h1>hello Response</h1>");
    }

    /**
     * 方式二: ResponseEntity 设置响应数据
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> responseEntity() {
        return ResponseEntity
                .status(401) // 响应状态码
                .header("name", "tom") // 响应头
                .body("<h1>hello ResponseEntity</h1>"); // 响应体
    }
}
```

（3）小结

![image-20250731153514059](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731153514059.png)

#### 4.3.5、常见状态码

| 状态码 | 英文描述                        | 解释                                                         |
| ------ | ------------------------------- | ------------------------------------------------------------ |
| 200    | OK                              | 客户端请求成功，即处理成功，这是我们最想看到的状态码         |
| 302    | Found                           | 指示所请求的资源已移动到由Location响应头给定的 URL，浏览器会自动重新访问到这个页面 |
| 304    | Not Modified                    | 告诉客户端，你请求的资源至上次取得后，服务端并未更改，你直接用你本地缓存吧。隐式重定向 |
| 400    | Bad Request                     | 客户端请求有语法错误，不能被服务器所理解                     |
| 403    | Forbidden                       | 服务器收到请求，但是拒绝提供服务，比如：没有权限访问相关资源 |
| 404    | Not Found                       | 请求资源不存在，一般是URL输入有误，或者网站资源被删除了      |
| 405    | Method Not Allowed              | 请求方式有误，比如应该用GET请求方式的资源，用了POST          |
| 428    | Precondition Required           | 服务器要求有条件的请求，告诉客户端要想访问该资源，必须携带特定的请求头 |
| 429    | Too Many Requests               | 指示用户在给定时间内发送了太多请求（“限速”），配合 Retry-After(多长时间后可以请求)响应头一起使用 |
| 431    | Request Header Fields Too Large | 请求头太大，服务器不愿意处理请求，因为它的头部字段太大。请求可以在减少请求头域的大小后重新提交。 |
| 500    | Internal Server Error           | 服务器发生不可预期的错误。服务器出异常了，赶紧看日志去吧     |
| 503    | Service Unavailable             | 服务器尚未准备好处理请求，服务器刚刚启动，还未初始化好       |



### 4.4、SpringBoot Web案例

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731160345580.png" alt="image-20250731160345580" style="zoom:67%;" />

--- 扩展：工具类，使用IO流更加便捷的读取文件

介绍：**Hutool**是一个小而全的Java工具类库，通过静态方法封装，降低相关API的学习成本，提高工作效率，使Java拥有函数式语言般的优雅，让Java语言也可以“甜甜的”。

```xml
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.8.27</version>
</dependency>
```

```java
/* 封装用户信息 */
@Data // Lombok 组件提供的注解，自动生成get、set方法
@NoArgsConstructor // 无参构造
@AllArgsConstructor // 有参构造
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;
}
```

```java
@SuppressWarnings("ALL")
@RestController // @ResponseBody -> 作用: 将controller返回值直接作为响应体的数据直接响应。返回值是集合/对象 -> json在返回
public class UserController {

    @RequestMapping("/list")
    public List<User> list() throws Exception {
        // 1. 加载并读取user.txt文件，获取用户数据
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> list = IoUtil.readLines(is, StandardCharsets.UTF_8, new ArrayList<>()); // IoUtil是hutoo-all 下的工具类
        // 2. 解析用户信息，封装为User对象 -> list集合
        List<User> userList = list.stream().map(lines -> {
            String[] msg = lines.split(",");
            Integer id = Integer.parseInt(msg[0]);
            String username = msg[1];
            String password = msg[2];
            String name = msg[3];
            Integer age = Integer.parseInt(msg[4]);
            LocalDateTime updateTime = LocalDateTime.parse(msg[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList());

        // 3. 返回数据（json）会将类型自动转换为 json类型
        return userList;
    }
}
```

![image-20250731172719696](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731172719696.png)

小结：

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731233155162.png" alt="image-20250731233155162" style="zoom:67%;" />

# 二、分层解耦

## 1、三层架构

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731233912879.png" alt="image-20250731233912879" style="zoom: 67%;" />

![image-20250731234114177](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250731234114177.png)

![image-20250801001342492](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801001342492.png)

dao层：

```java
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
        // 1. 加载并读取user.txt文件，获取用户数据
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> list = IoUtil.readLines(is, StandardCharsets.UTF_8, new ArrayList<>()); // IoUtil是hutoo-all 下的工具类
        return list;
    }
}
```

service层：

```java
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        List<String> list = userDao.findAll();
        // 2. 解析用户信息，封装为User对象 -> list集合
        List<User> userList = list.stream().map(lines -> {
            String[] msg = lines.split(",");
            Integer id = Integer.parseInt(msg[0]);
            String username = msg[1];
            String password = msg[2];
            String name = msg[3];
            Integer age = Integer.parseInt(msg[4]);
            LocalDateTime updateTime = LocalDateTime.parse(msg[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList());

        return userList;
    }
}
```

controller层：

```java
@RestController // @ResponseBody -> 作用: 将controller返回值直接作为响应体的数据直接响应。返回值是集合/对象 -> json在返回
public class UserController {
    
    private UserService userService = new UserServiceImpl();
    
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        List<User> userList = userService.findAll();
        // 3. 返回数据（json）会将类型自动转换为 json类型
        return userList;
    }
}
```

![image-20250801001703572](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801001703572.png)

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801002038348.png" alt="image-20250801002038348" style="zoom:80%;" />

## 2、分层解耦

### 2.1、耦合与内聚

#### 2.1.1、耦合

衡量软件中各个层/各个模块的依赖关联程度。

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801002709329.png" alt="image-20250801002709329" style="zoom:67%;" />

#### 2.1.2、内聚

软件中各个功能模块内部的功能联系。

#### 2.1.3、软件设计原则

高内聚低耦合

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801002832760.png" alt="image-20250801002832760" style="zoom:67%;" />

![image-20250801003916007](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801003916007.png)

思路：提供一个容器存放 UserService的实现类对象UserServiceImpl，当controller中的UserService对象需要通过实现类获取数据时，容器自动将实现类交给controller，那么如何存容器？如何让容器给出数据呢？

--- IOC（控制反转） & DI （依赖注入）

#### 2.1.4、控制反转

Inversion Of Control，简称IOC。对象的创建控制权由程序自身转移到外部（容器），这种思想称为控制反转。容器称为IOC容器或Spring容器。

#### 2.1.5、依赖注入

Dependency Injection，简称DI。容器为应用程序**提供**运行时，所依赖的资源，称之为依赖注入。

#### 2.1.6、Bean对象

IOC容器中创建、管理的对象，称之为Bean。

## 3、IOC & DI 入门

![image-20250801004503321](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801004503321.png)

### 3.1、@Component  和 @AutoWired

@Component：将当前类交给IOC容器管理。（将接口的实现类装入容器）

@AutoWired：应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量（为该接口自动匹配实现类）

```java
@Component // 将当前类交给 IOC容器管理
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
        // 加载并读取user.txt文件，获取用户数据
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> list = IoUtil.readLines(is, StandardCharsets.UTF_8, new ArrayList<>()); // IoUtil是hutoo-all 下的工具类
        return list;
    }
}
```

```java
@Component
public class UserServiceImpl implements UserService {

    @Autowired // 应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        List<String> list = userDao.findAll();
        // 解析用户信息，封装为User对象 -> list集合
        List<User> userList = list.stream().map(lines -> {
            String[] msg = lines.split(",");
            Integer id = Integer.parseInt(msg[0]);
            String username = msg[1];
            String password = msg[2];
            String name = msg[3];
            Integer age = Integer.parseInt(msg[4]);
            LocalDateTime updateTime = LocalDateTime.parse(msg[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList());

        return userList;
    }
}
```

```java
@RestController // @ResponseBody -> 作用: 将controller返回值直接作为响应体的数据直接响应。返回值是集合/对象 -> json在返回
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        List<User> userList = userService.findAll();
        // 返回数据（json）会将类型自动转换为 json类型
        return userList;
    }
}
```

（2）小结

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801005915665.png" alt="image-20250801005915665" style="zoom:67%;" />

## 4、IOC 详解

### 4.1、相关注解

@Component不仅可以放在控制层、业务层和数据访问层，还可以放在工具类上。

![image-20250801090459619](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801090459619.png)

![image-20250801093921964](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801093921964.png)

### 4.2、@Component 和 @SpringBootApplication

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801094445260.png" alt="image-20250801094445260" style="zoom:67%;" />

小结

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801094710012.png" alt="image-20250801094710012" style="zoom:67%;" />

## 5、DI 详解

### 5.1、依赖注入的三种方式

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801095048034.png" alt="image-20250801095048034" style="zoom:67%;" />

（1）成员变量注入

```java
@RestController
public class UserController {

    /* 1. 属性注入 */
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list() throws Exception {
        List<User> userList = userService.findAll();
        // 3. 返回数据（json）会将类型自动转换为 json类型
        return userList;
    }
}
```

（2）构造函数注入

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801095820032.png" alt="image-20250801095820032" style="zoom:67%;" />

（3）.setter注入

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801095941692.png" alt="image-20250801095941692" style="zoom:67%;" />

### 5.2、三种方式的优缺点

![image-20250801100752954](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801100752954.png)

具体的选择看组织的选择。

### 5.3、DI的注意事项

（1）@Autowired注解，默认是按照类型进行注入的。

（2）如果存在多个相同类型的bean，将会出现如下的错误：

![image-20250801101426650](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801101426650.png)

解决方法：

![image-20250801101507735](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801101507735.png)

（3）小结

![image-20250801102226286](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801102226286.png)

# 三、MySQL

## 1、MySQL概述

### 1.1、安装

（1）解压 -》 配置 -》 环境变量（MYSQL_HOME、PATH）-》管理员身份启动cmd（mysql）验证

（2）初始化：mysqld --initialize-insecure

（3）注册MySQL服务：mysqld -install

（4）启动MySQL服务

net start mysql // 启动mysql服务

net stop mysql // 停止mysql服务

（5）修改默认账户密码

mysqladmin -u root password 1223

（6）登录

mysql -uroot -p1223

![image-20250801103754250](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801103754250.png)

### 1.2、数据模型

#### 1.2.1、关系型数据库（RDB）

建立在关系模型基础上，由多张相互连接的二维表组成的数据库。

#### 1.2.2、特点

- 使用表存储数据，格式统一，便于维护。
- 使用SQL语言操作，标准统一，使用方便，可用于复杂查询。

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801111153252.png" alt="image-20250801111153252" style="zoom:67%;" />

小结：

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801111613669.png" alt="image-20250801111613669" style="zoom:80%;" />

## 2、SQL语句

#### 2.1、介绍

一门操作关系型数据库的**编程语言**，定义操作所有关系型数据库的**统一标准**。

#### 2.2、分类

| 分类 | 全称                       | 说明                                                     |
| ---- | -------------------------- | -------------------------------------------------------- |
| DDL  | Data Definition Language   | 数据定义语言，用来定义数据库对象（数据库、表、字段）     |
| DML  | Data manipulation Language | 数据操作语言，用来对数据库表中的数据进行增、删、改       |
| DQL  | Data Query Language        | 数据库查询语言，用来查询数据库中表的记录                 |
| DCL  | Data Control Language      | 数据库控制语言，用来创建数据库用户、控制数据库的访问权限 |

DCL由DBA（数据库管理员）来使用

#### 2.3、DDL

##### 2.3.1、数据库

操作语法

```sql
-- 查询所有数据库
show databases;

-- 查询当前数据库
select database();

-- 使用/切换数据库
use 数据库名;

-- 创建数据库
create database [if not exists] 数据库名 [default charset utf8mb4];

-- 删除数据库
drop database [if exists] 数据库名;
-- 上述的 database 也可以替换为 schema;mysql 8版本中没有指定字符集，默认也是 utf8mb4
```

（1）小结：

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801114244644.png" alt="image-20250801114244644" style="zoom:67%;" />

--- 扩展：使用命令行：无提示、关闭命令行后没有上次的历史记录、使用不方便。

图像化工具：DataGrip、Navicat

DataGrip介绍：是JetBrains旗下的一款数据库管理工具，是管理和开发MySQL、Oracle、PostgreSQL的理想解决方案。

官网:https://www.jetbrains.com/datagrip/#

===补充：ctrl + e：打开最近console

##### 2.3.2、表结构-创建

（1）创建表的语法：

![image-20250801171730796](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801171730796.png)

演示：

```sql
-- 创建表
create table user(
    id int comment 'ID，唯一标识',
    username varchar(50) comment '用户名',
    name varchar(10) comment '姓名',
    age int comment '年龄',
    gender char(1) comment '性别'
) comment '用户信息表';
```

（2）约束：约束是作用于表中字段上的规则，用于限制存储在表中的数据。

|     约束     | 描述                                             | 关键字          |
| :----------: | :----------------------------------------------- | :-------------- |
|   非空约束   | 限制该字段指不能为null                           | not null        |
|   唯一约束   | 保证字段的所有数据都是唯一、不重复的             | unique          |
| **主键**约束 | 主键是一行数据的唯一标识，要求非空且唯一         | **primary key** |
|   默认约束   | 保存数据时，如果未指定该字段值，则采用默认值     | default         |
| **外键**约束 | 让两张表的数据建立连接，保证数据的一致性和完整性 | foreign key     |

演示：

```sql
-- 创建表(约束)
create table user(
    -- 主键约束 auto_increment 自动增长
     id int primary key auto_increment comment 'ID，唯一标识',  
     username varchar(50) not null unique comment '用户名', -- 非空 唯一
     name varchar(10) not null comment '姓名', -- 非空约束
     age int comment '年龄',
     gender char(1) default '男' comment '性别' -- 默认约束
) comment '用户信息表';
```

===小结===

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250801193109843.png" alt="image-20250801193109843" style="zoom:67%;" />

（3）约束的目的：保证数据库中数据的正确性、有效性和完整性。

（4）数据类型

- 数值

![image-20250803180116994](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803180116994.png)

- 字符串类型

![image-20250803180859233](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803180859233.png)

![image-20250803180710770](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803180710770.png)

- 时间类型

![image-20250803181102318](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803181102318.png)

===小结===

![image-20250803181245353](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803181245353.png)

（5）===案例===设计员工表

![image-20250803194030060](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803194030060.png)

![image-20250803194328955](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803194328955.png)

![image-20250803194507755](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803194507755.png)

![image-20250803194614644](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803194614644.png)

演示：

```sql
-- 案例：设计员工表---emp
-- 基础字段: id 主键; create_time 创建时间; update_time 修改时间;
create table emp(
    id int unsigned primary key auto_increment comment 'ID, 主键',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment '密码', -- 因为经过 md5加密后密码就是 32位
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别, 1:男;2:女', -- 数据空库中，性别一般用数字表示男女
    phone char(11) not null unique comment '手机号',
    job tinyint unsigned comment '职位, 1:班主任; 2:讲师; 3:学工主管; 4:校验主管; 5:咨询师',
    salary int unsigned comment '薪资',
    entry_date date comment '入职日期',
    image varchar(255) comment '头像',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment '员工信息表';
```



##### 2.3.3、表结构-查询、修改、删除

（1）基本语法

![image-20250803221257349](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803221257349.png)

（2）演示：

```sql
-- 查询当前数据库所有表
show tables;

-- 查看表结构
desc emp;

-- 查询建表语句
show create table emp;

-- 字段：添加字段 qq varchar(13)
alter table emp add qq varchar(13) comment 'QQ号码';

-- 字段：修改字段类型 qq varchar(15)
alter table emp modify qq varchar(15) comment 'QQ号码';

-- 字段：修改字段名 qq -> qq_num varchar(15)
alter table emp change qq qq_num varchar(15) comment 'QQ号码';

-- 字段：删除字段 qq_num
alter table emp drop column qq_num;

-- 修改表名
alter table emp rename to employee;

-- 删除表
drop table employee;
```



#### 	2.4、DML

##### 		2.4.1、介绍

​	DML英文全称是Date Manipulation Language（数据操作语言），用来对数据库中表的数据记录进行增、删、改、操作。

##### 		2.4.2、添加数据（insert）

（1）基本语法

![image-20250803224611411](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803224611411.png)

（2）演示：

![image-20250803231212486](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803231212486.png)

===注意===

- 插入数据时，指定的字段顺序需要与值的顺序是一一对应的。
- 字符串和日期型数据应该包含在引号中（单引号、双引号都可以）。
- 插入的数据大小/长度，应该在字段的规定范围内。

##### 2.4.3、修改数据（update）

（1）基本语法
![image-20250803231714119](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803231714119.png)

===注意===

修改语句的条件可以有，也可以没有，如果没有条件，则会修改整张表的所有数据。

（2）演示

![image-20250803232726378](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803232726378.png)

##### 2.4.4、删除数据（delete）

（1）基础语法

![image-20250803232709575](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803232709575.png)

===注意===

- DELETE 语句的条件可以有，也可以没有，如果没有条件，则会删除整张表的所有数据。
- DELETE 语句不能删除某一个字段的值（如果要操作，可以使用UPDATE，将该字段的值置为NULL）。

（2）演示

![image-20250803233705714](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250803233705714.png)

#### 2.5、DQL

##### 2.5.1、完整的DQL语句格式

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804091610188.png" alt="image-20250804091610188" style="zoom:67%;" />

##### 2.5.2、基本查询

（1）基本语法

![image-20250804094028099](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804094028099.png)

（2）演示

![image-20250804093955066](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804093955066.png)

##### 2.5.3、条件查询

（1）基本语法-条件构建

![image-20250804094321548](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804094321548.png)

（2）演示

```sql
--  =================== DQL: 条件查询 ======================
-- 1. 查询 姓名 为 柴进 的员工
select *  from employee where name = '柴进';

-- 2. 查询 薪资小于等于5000 的员工信息
select * from employee where salary <= 5000;

-- 3. 查询 没有分配职位 的员工信息
select * from employee where job is null;

-- 4. 查询 有职位 的员工信息
select * from employee where job is not null;

-- 5. 查询 密码不等于 '123456' 的员工信息
select * from employee where password != '123456';
select * from employee where password <> '123456';

-- 6. 查询 入职日期 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间的员工信息
-- between '最小值' and '最大值' 格式不能改
select * from employee
where entry_date between '2000-01-01' and '2010-01-01';

-- 7. 查询 入职时间 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间 且 性别为女 的员工信息
-- 可以将不同的条件用括号括起来
select * from employee
where (entry_date between '2000-01-01' and '2010-01-01') && gender = 2;

select * from employee
where (entry_date between '2000-01-01' and '2010-01-01') and gender = 2;

-- 8. 查询 职位是 2 (讲师), 3 (学工主管), 4 (教研主管) 的员工信息
select * from employee where job in (2, 3, 4);
select * from employee where job = 2 or job = 3 or job = 4;

-- 9. 查询 姓名 为两个字的员工信息 -- 模糊匹配
select * from employee where name like '__';


-- 10. 查询 姓 '李' 的员工信息
select * from employee where name like '李%';

-- 11. 查询 姓名中包含 '二' 的员工信息
select * from employee where name like '%二%';
```



##### 2.5.4、分组查询-聚合函数

（1）聚合函数：将一列数据作为一个整体，进行纵向计算。

| 函数  | 功能     |
| ----- | -------- |
| count | 统计数量 |
| max   | 最大值   |
| min   | 最小值   |
| avg   | 平均值   |
| sum   | 求和     |

（2）演示

===聚合函数

```sql
--  =================== DQL: 分组查询 ======================
-- 聚合函数
-- 注意：所有聚合函数不参与null值计算

-- 1. 统计该企业员工数量
-- count 三种用法：count(字段)、count(*)、count(常量)
-- count(字段) 推荐使用非空字段
select count(id) from employee;
select count(job) from employee;

-- count(*) 推荐
select count(*) from employee;

-- count(常量) 推荐 原理:有一行数据就标记一个常量值
select count(1) from employee;

-- 2. 统计该企业员工的平均薪资
select avg(salary) from employee;

-- 3. 统计该企业员工的最低薪资
select min(salary) from employee;

-- 4. 统计该企业员工的最高薪资
select max(salary) from employee;

-- 5. 统计该企业每月要给员工发放的薪资总额(薪资之和)
select sum(salary) from employee;
```

===注意===

- null值不参与所有聚合函数的运算
- 统计数量可以使用：count(*)推荐、count(字段)、count(常量)推荐；
- count(*) 和 count(常量) 性能一致

（3）分组语法

![image-20250804111045699](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804111045699.png)

===where和having的区别===

- 执行时机不同：where 是分组之前进行过滤的，不满足where条件，不参与分组；而having是分组之后对结果进行过滤。
- 判断条件不同：where不能对聚合函数进行判断，而having可以。

（4）演示

```sql
-- 分组
-- 注意：[分组之后，select 后的字段列表]不能随意书写，能写的一般是分组字段 + 聚合函数；
-- 1. 根据性别分组 , 统计男性和女性员工的数量
select gender, count(*) from employee group by gender;

-- 2. 先查询入职时间在 '2015-01-01' (包含) 以前的员工 , 并对结果根据职位分组 , 获取员工数量大于等于2的职位
-- 先查询入职时间在 '2015-01-01' (包含) 以前的员工
select * from employee where entry_date <= '2015-01-01';
-- 并对结果根据 职位 分组
select job from employee where entry_date <= '2015-01-01' group by job;
-- 获取员工数量
select job, count(*) from employee where entry_date <= '2015-01-01' group by job;
-- 获取员工数量大于等于2的职位
select job, count(*) from employee where entry_date <= '2015-01-01' group by job having count(*) >= 2;
```

（5）小结

![image-20250804112932549](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804112932549.png)

##### 2.5.5、排序查询

（1）基础语法

![image-20250804113205188](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804113205188.png)

===注意===

- 如果是多字段排序，当第一个字段值相同时，才会根据第二个字段进行排序。

（2）演示

```sql
--  =================== 排序查询 ======================
-- 1. 根据入职时间, 对员工进行升序排序 asc 是默认排序
select * from employee order by entry_date asc;
select * from employee order by entry_date;

-- 2. 根据入职时间, 对员工进行降序排序
select * from employee order by entry_date desc;

-- 3. 根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 更新时间 进行降序排序
select * from employee order by entry_date, update_time desc;
```

（3）小结

![image-20250804114422569](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804114422569.png)

- 根据age进行升序排序；
- 现根据age进行降序排序，当age相同时，再根据成绩及进行升序排序；
- 现根据age升序排序，当age相同时，再根据成绩升序排序，最后当age个score相同时，根据update_time做降序排序。

##### 2.5.6、分页查询

（1）基本语法

![image-20250804140312226](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804140312226.png)

===说明===

- 起始索引从0开始。
- 分页查询是数据库的方言，不同的数据库有不同的实现，MySQL中是LIMIT。
- 如果起始索引为0，起始索引可以省略，直接简写 为： limit 10。

（2）演示

```sql
--  =================== 分页查询 ======================
-- 1. 从起始索引0开始查询员工数据, 每页展示5条记录
select * from employee limit 5;
select * from employee limit 0, 5;

-- 2. 查询 第1页 员工数据, 每页展示5条记录
select * from employee limit 0, 5;

-- 3. 查询 第2页 员工数据, 每页展示5条记录
select * from employee limit 5, 5;

-- 4. 查询 第3页 员工数据, 每页展示5条记录
select * from employee limit 10, 5;

-- 页码计算公式：
-- 起始索引 = (页码 - 1) * 每页记录数
```

（3）小结

![image-20250804141452353](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804141452353.png)

# 四、JDBC

### 1、介绍

​	JDBC：（Java DataBase Connectivity），就是使用Java语言操作关系型数据库的一套API。

![image-20250804141817203](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804141817203.png)

### 2、本质

- sun公司官方定义的一套操作所有关系型数据库的规范，即接口。
- 各个数据库厂商去实现这套接口，提供数据库驱动jar包。
- 我们可以使用这套接口（JDBC）编程，真正执行代码时驱动jar包中的实现类。

![image-20250804142313161](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804142313161.png)

### 3、入门程序

![image-20250804142530118](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804142530118.png)

#### 3.1、准备依赖

```xml
<dependencies>
        <!--mysql-connector-j-->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.0.33</version>
        </dependency>
        <!--junit-->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.11.4</version>
            <scope>test</scope>
        </dependency>
        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
        </dependency>
    </dependencies>
```



#### 3.2、注册驱动

（1）Class.forName()，按两下shift，搜索Driver，选择如下选项

![image-20250804144058626](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804144058626.png)

![image-20250804144142464](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804144142464.png)

```java
// 1. 注册驱动
Class.forName("com.mysql.cj.jdbc.Driver");
```

#### 3.3、获取数据库连接

```java
// 2. 获取数据库连接
String url = "jdbc:mysql//localhost:3306/web01";
String username = "root";
String password = "1223";
Connection connection = DriverManager.getConnection(url, username, password);
```

#### 3.4、余下操作

```java
// 3. 获取SQL 语句执行对象
Statement statement = connection.createStatement();
// 4. 执行SQL
// executeUpdate 用来执行 DML语句和DDL语句
// executeQuery 用来执行 DQL语句
int i = statement.executeUpdate("update user set age = 25 where id = 1;");
System.out.println("SQL语句执行完毕影响的记录:" + i);
// 5. 释放资源
statement.close();
connection.close();
```

```java
@Test
public void testUpdate01() throws Exception {
    // 1. 注册驱动
    Class.forName("com.mysql.cj.jdbc.Driver");
    // 2. 获取数据库连接
    String url = "jdbc:mysql://localhost:3306/web01";
    String username = "root";
    String password = "1223";
    Connection connection = DriverManager.getConnection(url, username, password);
    // 3. 创建sql语句
    Statement statement = connection.createStatement();
    // 4. 执行sql语句
    // 说明: executeUpdate() 方法用来执行 DML(增删改)、DDL(创建定义)语句; executeQuery() 方法用来执行 DQL语句
    int i = statement.executeUpdate("update user set age = 22 where id = 1");
    System.out.println("sql语句影响的结果:" + i + "条。");
    // 5. 释放资源
    statement.close();
    connection.close();
}
```

### 4、JDBC-查询数据

![image-20250804152537606](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804152537606.png)

#### 4.1、AI-prompt

```java
你是一名java开发工程师，帮我基于JDBC程序来操作数据库，执行如下SQL语句：select id,username,password,name,age from user  where username = 'daqiao' and password = '123456';
并将查询的每一行记录，都封装到实体类User中，然后将User对象的数据输出到控制台中。
User 实体类属性如下：
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id; //ID
    private String username; //用户名
    private String password; //密码
    private String name; //姓名
    private Integer age; //年龄
}

```

#### 4.2、演示

```java
@Test
public void testSelectAI() {
    String url = "jdbc:mysql://localhost:3306/web01";
    String username = "root";
    String password = "1223";

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null; //封装查询返回的结果

    try {
        // 1. 注册 JDBC 驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 打开链接
        conn = DriverManager.getConnection(url, username, password);

        // 3. 执行查询
        String sql = "SELECT id, username, password, name, age FROM user WHERE username = ? AND password = ?"; //预编译SQL  ?:占位符
        stmt = conn.prepareStatement(sql);

        stmt.setString(1, "daqiao");
        stmt.setString(2, "123456");

        rs = stmt.executeQuery();

        // 4. 处理结果集
        while (rs.next()) {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getInt("age")
            );
            System.out.println(user); // 使用 Lombok 的 @Data 自动生成的 toString 方法
        }
    } catch (SQLException se) {
        // Handle errors for JDBC
        se.printStackTrace();
    } catch (Exception e) {
        // Handle errors for Class.forName
        e.printStackTrace();
    } finally {
        // 5. 关闭资源
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
```

===优化：代码更加简洁、健壮性更强

```java
/**
 * 优化
 * 从JDBC 4.0开始，不再需要编写注册驱动的代码，采用自驱动方式，简化代码
 */
@Test
public void testQuery02() {
    String url = "jdbc:mysql://localhost:3306/web01";
    String username = "root";
    String password = "1223";

    try (
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement("select * from user where id = ?")
    ) { // conn、stmt、rs 都继承了 AutoCloseable，可以自动释放资源

        stmt.setInt(1, 7);
        try (
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
                System.out.println(user);
            }
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
```

4.3、小结

![image-20250804161201700](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804161201700.png)

### 5、预编译SQL语句

#### 5.1、了解

![image-20250804161447845](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804161447845.png)

#### 5.2、优势

（1）可以防止SQL注入，更安全。

===SQL注入===

​	通过控制输入来修改事先定义好的SQL语句，以达到代码对服务器进行攻击的方法。

<img src="D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804163742814.png" alt="image-20250804163742814" style="zoom:67%;" />

===说明===

​	当密码输入含有攻击性的字符串，就可以直接登录，无需验证用户名和密码。

```sql
-- 'or'1' = '1
select * from employee where username = 'songjiang' and password = '123456';
select * from employee where username = 'songjiang' and password = ''or'1' = '1';
```

（2）性能更高

![image-20250804163818202](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804163818202.png)

===说明===

预编译sql -> SQL语法解析检查 -> 优化SQL -> 编译SQL 之后存入缓存中，当执行时，用数据替换占位符；

同理，此后的数据也是如此。

而，硬编码每要执行一次，就要通过改流程一次，占用缓存。

（3）小结

![image-20250804164144662](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804164144662.png)

# 五、MyBatis

### 1、介绍

![image-20250804164522036](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804164522036.png)

### 2、与JDBC的比较

![image-20250804164419061](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804164419061.png)

### 3、入门程序

![image-20250804164918667](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804164918667.png)

===提示===

​	Mybatis的持久层接口命名规范为XxxMapper，也成为Mapper接口。

#### 3.1、步骤

![image-20250804171846463](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804171846463.png)

#### 3.2、相关代码

UserMapper.java:

```java
package com.tjy.mapper;

import com.tjy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 应用程序在运行时，会自动为改接口创建一个实现类对象(代理对象),并且会自动将改实现类对象存入IOC容器 - bean
public interface UserMapper {

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from user;")
    List<User> findAll();
}

```

运行测试类

```java
package com.tjy;

import com.tjy.mapper.UserMapper;
import com.tjy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // SpringBoot单元测试的注解-当前测试类中的测试方法运行时，会启动springboot项目-IOC容器就创建好了
class MybatisDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }
}
```

#### 3.3、小结

![image-20250804171806595](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804171806595.png)

#### 3.4、辅助配置-配置SQL提示

![image-20250804172428758](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804172428758.png)

![image-20250804173812603](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804173812603.png)

#### 3.5、开启Mybatis日志输出

![image-20250804174240891](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804174240891.png)

### 4、JDBC vs Mybatis

![image-20250804183453404](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804183453404.png)

### 5、数据库连接池

#### 5.1、介绍

- 数据库连接池是个容器，负责分配、管理数据库连接（Connection）。
- 它允许应用程序重复使用一个现有的数据库连接，而不是再重新建立一个。
- 释放空闲时间超过最大空闲时间的连接，来避免因为没有释放连接而引起的**数据库连接遗漏**。

#### 5.2、优点

- 资源重用（连接复用）
- 提升系统响应速度（不用频繁创建连接、释放连接）
- 避免数据库连接遗漏

![image-20250804184516229](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804184516229.png)

#### 5.3、了解

![image-20250804184816562](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804184816562.png)

#### 5.4、切换连接池

![image-20250804185018538](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804185018538.png)

### 6、增删改查操作

#### 6.1、删除操作

（1）格式

![image-20250804191301950](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804191301950.png)

（2）# 与 ￥的区别

![image-20250804191620558](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804191620558.png)

（3）演示

```java
/**
* 根据id删除用户
*/
@Delete("delete from user where id = #{id};") // #{id} 等价于 ? 也是占位符
void deleteById(Integer id);
```

```java
/**
* 根据id删除测试
*/
@Test
public void testDeleteById() {
	userMapper.deleteById(6);
}
```

（4）小结

![image-20250804191810958](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804191810958.png)

#### 6.2、新增操作

（1）格式

![image-20250804192928377](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804192928377.png)

（2）演示

```java
/**
* 新增用户
*/
// 当添加字段过多时，可以考虑使用对象进行封装，再传输
@Insert("insert into user(username, password, name, age) values(#{username}, #{password}, #{name}, #{age}) ")
void addUser(User user);
```

```java
/**
* 添加用户测试
*/
@Test
public void testAddUser() {
	userMapper.addUser(new User(null, "luban", "1234567", "鲁班", 20));
}	
```



#### 6.3、更新操作

（1）格式

![image-20250804194447744](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804194447744.png)

（2）演示

```java
/**
* 根据id更新数据
*/
@Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
void updateUser(User user);
```

```java
/**
* 更新用户测试
*/
@Test
public void testUpdateUser() {
	userMapper.updateUser(new User(7, "zhugeliang", "12345678", "诸葛亮", 20));
}
```



#### 6.4、查询操作

（1）格式

![image-20250804200435391](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804200435391.png)

（2）演示

```java
/**
* 根据指定条件查询用户
* @param user
* @return
*/
@Select("select * from user where username = #{username} and password = #{password};")
User queryUser(User user);

// @Param 注解的作用是为接口的方法形参起名字的。
@Select("select * from user where username = #{username} and password = #{password}")
User queryUser2(@Param("username") String username, @Param("password") String password);
```

```java
/**
* 根据指定条件查询用户
*/
@Test
public void testQueryUser() {
    User user = userMapper.queryUser(new User(null, "daqiao", "123456", null, null));
    System.out.println(user);
}

@Test
public void testQueryUser2() {
    User user = userMapper.queryUser2("zhugeliang", "12345678");
    System.out.println(user);
}
```

===扩展===

![image-20250804200927199](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804200927199.png)

（3）小结

![image-20250804201934430](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250804201934430.png)

### 7、XML映射配置

#### 7.1、默认规则

![image-20250805090826232](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250805090826232.png)

===注意===

![image-20250805091159565](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250805091159565.png)

在resource包下创建包，不能使用点，必须使用‘/’。

#### 7.2、xml文件的默认配置

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="">
  
</mapper>
```

===问题：在Mybatis的开发中，到底使用注解开发还是使用XML开发呢？

​	当SQL语句只是简单的增删改查使用注解即可，当处理复杂SQL语句时使用XML文件映射。

===小结

![image-20250805095802814](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250805095802814.png)

#### 7.3、常见异常情况

（1）BindingException

![image-20250805100001482](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250805100001482.png)

===说明：这时映射文件没有和实体类放在同包下。

===那如果想要在其它地方放置映射文件中呢？

![image-20250805100237123](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250805100237123.png)

### 8、SpringBoo项目配置文件

===如何解决配置文件臃肿的问题？

![image-20250805101111191](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250805101111191.png)

#### 8.1、项目文件配置（properties、yaml、yml）

![image-20250805101512438](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250805101512438.png)

#### 8.2、yml配置文件

（1）格式

![image-20250805101852562](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250805101852562.png)

（2）演示

```yml
# 定义对象/Map集合
user:
  name: tom
  age: 18
  gender: 男

# 定义数组/List/Set集合
hobby:
  - Java
  - Game
  - Sport
```

===注意===

​	在yml格式的配置文件中，如果配置项的值是0开头的，值需要使用''引起来，因为以0开头在yml中表示8进制的数据。

application.properties

```properties
spring.application.name=mybatis-demo
# 配置数据库连接细信息
# 切换为德鲁伊数据库连接池
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.url=jdbc:mysql://localhost:3306/web01
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=1223
#下面这些内容是为了让MyBatis映射
#指定Mybatis的Mapper文件
mybatis.mapper-locations=classpath:mappers/*.xml
#指定Mybatis的实体目录
mybatis.type-aliases-package=com.tjy.mybatis.pojo
#配置Mybatis的日志输出
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

application.yml

```yml
spring:
  # 项目名称
  application:
    name: mybatis-demo
  datasource:
    # 切换为德鲁伊数据库连接池
    type: com.alibaba.druid.pool.DruidDataSource
    # 配置数据库连接池信息
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/web01
    username: root
    password: 1223

# mybatis 相关配置
mybatis:
  # 指定Mybatis的Mapper文件
  mapper-locations: classpath:mapper/*.xml
  # 指定Mybatis的实体目录
  type-aliases-package: com.tjy.mybatis.pojo
  # 配置Mybatis的日志输出
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

（3）小结

![image-20250805111920219](D:\软件工程\JavaWeb + AI\02-后端Web基础\assets\image-20250805111920219.png)