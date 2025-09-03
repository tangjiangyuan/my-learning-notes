## part1：前端Web基础

## 一、Web前端开发初识

### 1、 初识Web前端

#### 1.1、网页由哪几部分组成？

文字、图片、视频、音频、超链接。。。

#### 1.2、我们看到的网页，背后本质是什么？

程序员写的 前端代码

#### 1.3、前端代码如何转换成用户眼中的网页？

通过**浏览器**转换成用户看到的网页。

浏览器对代码进行解析渲染的部分，称为**浏览器内核**。

**提示**：不同浏览器，内核不同，对于相同的前端代码解析的效果可能会存在差异。

### 2、web标准

- Web标准也称为 网页标准，由一系列的标准组成，大部分由 W3C(World Wild Web Consortium, 万维网联盟)负责指定。

- 三个组成部分：

  - HTML：负责网页的结构（页面元素和内容）。

  - CSS：负责网页的表现（页面元素的外观、位置等页面样式，如：颜色、大小等）。

  - JavaScript：负责网页的行为（交互效果）。

    ![image-20250726185214984](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726185214984.png)<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726185352320.png" alt="image-20250726185352320" style="zoom: 67%;" />

## 二、HTML-CSS

### 1、HTML、CSS介绍

#### 1.1、HTML（HyperText Markup Languge）

超文本标记语言。

- 超文本：超越了文本的限制，比普通文本更强大。除了文字信息，还可以定义图片、音频、视频等内容。
- 标记语言：由标签 "<标签名>" 构成的语言
  - HTML标签都是预定义好的。例如：使用<h1>展示标题，使用<img>展示图片，使用<video>展示视频。
  - HTML代码直接在浏览器中运行，HTML标签由浏览器解析。

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726190327605.png" alt="image-20250726190327605" style="zoom:50%;" />

#### 1.2、CSS（Cascading Style Sheet）

层叠样式表，用于控制页面的样式（表现）。



### 2、HTML快速入门

#### 2.1、入门案例

#### <img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726191757931.png" alt="image-20250726191757931" style="zoom: 50%;" />

#### 2.2、HTML语法特点

- 标签不区分大小写，大小写混用也可以（推荐**小写**）。
- 标签中的属性值可以用双引号或者单引号（推荐**双引号**）。
- 语法结构不严谨，即使不写结束标签也能生效。<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726192800705.png" alt="image-20250726192800705" style="zoom:67%;" />



### 3、前端开发工具

#### 3.1、介绍

- Visual Studio Code（简称VS Code）是Microsoft 于2015年4月发布的一款代码编辑器。
- VS Code 对前端代码有非常强大的支持，同时也支持其它的编程语言（例如：C++、Java、Python、PHP、Go等）。
- VS Code 提供了非常强大的插件库，大大提高了开发效率。
- 官网：https://code.visualstudio.com

#### 	3.2、vs code常用插件

#### <img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726194032609.png" alt="image-20250726194032609" style="zoom:67%;" />

#### 3.3、快捷键

（1）！：自动生成基本框架

​									<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726201041493.png" alt="image-20250726201041493" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726202000037.png" alt="image-20250726202000037" style="zoom:67%;" />

（2）ctrl + / ：注释

（3）alt + b ：运行前端代码

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726203916871.png" alt="image-20250726203916871" style="zoom:67%;" />

### 4、常见标签 & 样式

#### 4.1、央视新闻 - 标题

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726204257781.png" alt="image-20250726204257781" style="zoom: 50%;" />

##### 4.1.1、样式新闻 - 标题排版

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726223748078.png" alt="image-20250726223748078" style="zoom:50%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726223531799.png" alt="image-20250726223531799" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726223607215.png" alt="image-20250726223607215" style="zoom:67%;" />

##### 4.1.2、央视新闻-标题-样式

![image-20250726224149030](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726224149030.png)

![image-20250726225623323](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726225623323.png)

![](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726232601343.png)

##### 4.1.3、CSS选择器的优先级

ID选择器 --->  类选择器 --->   元素选择器

===补充：**去除**超链接下方的**下划线**

![image-20250726232400321](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250726232400321.png)

#### 4.2央视新闻 - 正文

##### 4.2.1、央视新闻-正文-排版

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727002746279.png" alt="image-20250727002746279" style="zoom:67%;" />

##### 4.2.2、央视新闻-正文-样式

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727094933667.png" alt="image-20250727094933667" style="zoom:67%;" />

![image-20250819094932651](D:\软件工程\JavaWeb + AI\01-前端Web基础\assets\image-20250819094932651.png)

===补充：使内容在页面中居中显示

![image-20250727105004411](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727105004411.png)

![image-20250727105021697](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727105021697.png)

##### 4.2.3、扩展 --- **盒子模型**

（1）介绍

​		盒子：页面中所有的元素（标签），都可以看作是一个盒子，由盒子将页面中的元素包含在一个矩形区域内，通过盒子的视角更方便的进行页面布局。

（2）盒子模型组成

​		**内容区域（content）、内边距（padding）、边框区域（border）、外边距区域（margin）**

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727105447805.png" alt="image-20250727105447805" style="zoom: 67%;" />

（3）布局标签

​		网页开发中，会使用 div和 span这两个没有语义的布局标签。

（4）特点

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727105659570.png" alt="image-20250727105659570" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727120629737.png" alt="image-20250727120629737" style="zoom:67%;" />

#### 4.3、案例

- 页面原型：指在应用程序开发初期，由 产品经理制作的一个早期项目模型，它用于展示页面的基本布局、功能和交互设计。通常用来帮助设计师、开发者等更好地理解和讨论最终产品的外观和行为。

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727120952618.png" alt="image-20250727120952618" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727121339262.png" alt="image-20250727121339262" style="zoom:80%;" />

##### 4.3.1、**顶部导航栏**

（1）AI提示词

```
AI Prompt:
你是一名前端开发工程师，先需要制作一个HTML页面，这个页面共分为4个部分，先实现第一个部分-顶部导航栏。具体需求如下：
1.内容：要展示一个醒目（加粗加黑展示）的标题，标题内容：Tlias智能学习辅助系统；还要展示一个“退出登录”的超链接。
2.布局：标题和退出登录的超链接，展示在一行里面。标题居左展示，退出登录的超链接居右展示。
3.给整个顶部导航栏，设置一个灰色的背景色。请帮我生成这个HTML页面。
```

（2）flex 布局

- flex是flexible Box 的缩写，意为“弹性布局”，是一种一维的布局模型。flex布局可以为元素之间提供强大的空间分布和对齐能力。
- 通过给父容器添加flex的相关属性，来控制子元素的位置和排列方式。

![image-20250727125025642](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727125025642.png)

```html
<style>
        /* 顶部导航栏样式 */
        .top-nav {
            display: flex; /* flex弹性布局 */
            justify-content: space-between; /* 弹性布局的属性 */
            align-items: center; /* 弹性布局的属性 */
            
            background-color: #808080; /* 灰色背景 */
            padding: 10px;
            align-items: center; /* 垂直居中 */
        }

        /* 标题样式 */
        .top-nav h1 {
            font-weight: 900;
            color: white;
            font-size: 24px;
            /* 设置字体为楷体 */
            font-family: "楷体";
        }

        /* 退出链接样式 */
        .logout-link {
            color: white;
            text-decoration: none;
            font-size: 16px;
            transition: color 0.3s;
        }

        .logout-link:hover {
            color: #40a9ff;
            text-decoration: none;
        }
    </style>
```

```html
<body>
    <header class="top-nav">
        <h1>Tlias智能学习辅助系统</h1>
        <a href="#" class="logout-link">退出登录</a>
    </header>
</body>
```

![image-20250727144029862](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727144029862.png)

##### 4.3.2、**搜索表单区域**

（1）表单：在网页中主要负责数据采集功能，如：注册、登录等数据采集。

（2）表单-标签：<form>

- 表单项-标签：不同类型的 input元素、下拉列表、文本域等。

![image-20250727132328927](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727132328927.png)

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727134627343.png" alt="image-20250727134627343" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727134730756.png" alt="image-20250727134730756" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727135729596.png" alt="image-20250727135729596" style="zoom:67%;" />

（3）代码演示

```html
<!-- value: 表单项提交的值 -->
<form action="/save" method="post">
      姓名: <input type="text" name="name"> <br><br>
​     密码: <input type="password" name="password"> <br><br> 
​     性别: <input type="radio" name="gender" value="1"> 男
​          <label><input type="radio" name="gender" value="2"> 女 </label> <br><br>
​     
​     爱好: <label><input type="checkbox" name="hobby" value="java"> java </label>
​          <label><input type="checkbox" name="hobby" value="game"> game </label>
​          <label><input type="checkbox" name="hobby" value="sing"> sing </label> <br><br>
​     
​     图像: <input type="file" name="image">  <br><br>
​     生日: <input type="date" name="birthday"> <br><br>
​     时间: <input type="time" name="time"> <br><br>
​     日期时间: <input type="datetime-local" name="datetime"> <br><br>
​     学历: <select name="degree">
​               <option value="">----------- 请选择 -----------</option>
​               <option value="1">大专</option>
​               <option value="2">本科</option>
​               <option value="3">硕士</option>
​               <option value="4">博士</option>
​          </select>  <br><br>

​     描述: <textarea name="description" cols="30" rows="10"></textarea>  <br><br>
​     <input type="hidden" name="id" value="1">

​     <!-- 表单常见按钮 -->
​     <input type="button" value="按钮">
​     <input type="reset" value="重置"> 
​     <input type="submit" value="提交">   
​     <br>
</form>
```

```
AI Prompt：
接下来，在帮我生成第二个部分-搜索表单区域，具体说明如下：
1. 组成：包括三个表单项和两个操作按钮。
	1.1 表单项具体为：姓名（文本输入框）、性别（下拉选择，选项包括：男/女，默认为空）、职位（下拉选择，选择项包括班主任、讲师、学工主管、教研主管、咨询师，默认为空）。
	1.2 两个按钮：“查询”与“清空”按钮，用于提交表单 或 重置表单项。
2. 布局：所有表单项以按钮需水平排列与一行，确保美观大气。
```

```html
<!-- 搜索表单区域 -->
<!-- Tlias案例-搜索表单区域 -->
<form class="search-form" action="/search" method="post">
    <label for="name">姓名：</label>
    <input type="text" id="name" name="name" placeholder="请输入姓名">

    <label for="gender">性别：</label>
    <select id="gender" name="gender">
        <option value=""></option>
        <option value="1">男</option>
        <option value="2">女</option>
    </select>

    <label for="position">职位：</label>
    <select id="position" name="position">
        <option value=""></option>
        <option value="1">班主任</option>
        <option value="2">讲师</option>
        <option value="3">学工主管</option>
        <option value="4">教研主管</option>
        <option value="5">咨询师</option>
    </select>

    <button type="submit">查询</button>
    <button type="reset">清空</button>
</form>
```

```css
/* 搜索表单样式 */
.search-form {
    display: flex;
    flex-wrap: nowrap;
    align-items: center;
    gap: 10px; /* 控件之间的间距 */
    margin: 20px 0;
}
.search-form input[type="text"], .search-form select {
    padding: 5px; /* 输入框内边距 */
    width: 300px; /* 宽度 */
}
.search-form button {
    padding: 5px 15px; /* 按钮内边距 */
}
```

![image-20250727144059146](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727144059146.png)

（4）属性：

![image-20250727132428455](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727132428455.png)

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727134125569.png" alt="image-20250727134125569" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727133255240.png" alt="image-20250727133255240" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727133636035.png" alt="image-20250727133636035" style="zoom:67%;" />

​	注意：表单项必须有name属性，才能提交数据。

##### 4.3.3、**表格数据展示区**

```
AI Prompt:
再继续帮我生成第三个部分-表格展示区：
1. 表格结构：展示列包括姓名、性别（显示男/女）、头像（小图片）展示、职位（显示班主任/讲师/学工主管/教研主管/咨询师）、入职日期、最后操作时间、操作（里面包含两个按钮：编辑和删除）。
2. 测试数据：基于《笑傲江湖》小说人物在表格中生成3条测试数据，每条数据应包含上述所有列的信息，以体现实际应用场景。
3.样式：可适当调整表格样式，确保美观大气。
```

```html
<!-- 表格展示区 -->
<table>
    <!-- 表头 -->
    <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>头像</th>
            <th>职位</th>
            <th>入职日期</th>
            <th>最后操作时间</th>
            <th>操作</th>
        </tr>
    </thead>

    <!-- 表格主体内容 -->
    <tbody>
        <tr>
            <td>令狐冲</td>
            <td>男</td>
            <td><img class="avatar" src="https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg" alt="令狐冲"></td>
            <td>讲师</td>
            <td>2021-06-15</td>
            <td>2024-09-16 15:30</td>
            <td class="action-buttons">
                <button type="button">编辑</button>
                <button type="button">删除</button>
            </td>
        </tr>
        <tr>
            <td>任盈盈</td>
            <td>女</td>
            <td><img class="avatar" src="https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg" alt="任盈盈"></td>
            <td>咨询师</td>
            <td>2021-07-20</td>
            <td>2024-09-17 09:00</td>
            <td class="action-buttons">
                <button type="button">编辑</button>
                <button type="button">删除</button>
            </td>
        </tr>
        <tr>
            <td>向问天</td>
            <td>男</td>
            <td><img class="avatar" src="https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg" alt="向问天"></td>
            <td>教研主管</td>
            <td>2021-05-01</td>
            <td>2024-09-15 17:45</td>
            <td class="action-buttons">
                <button type="button">编辑</button>
                <button type="button">删除</button>
            </td>
        </tr>
        <tr>
            <td>任我行</td>
            <td>男</td>
            <td><img class="avatar" src="https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg" alt="向问天"></td>
            <td>教研主管</td>
            <td>2021-05-01</td>
            <td>2024-09-15 17:45</td>
            <td class="action-buttons">
                <button type="button">编辑</button>
                <button type="button">删除</button>
            </td>
        </tr>
    </tbody>
</table>
```

```css
/* 表格样式 */
table {
    width: 100%;
    border-collapse: collapse;
}
th, td {
    border: 1px solid #ddd; /* 边框 */
    padding: 8px; /* 单元格内边距 */
    text-align: center; /* 居中对齐 */
}
th {
    background-color: #f2f2f2;
    font-weight: bold;
}
tr:nth-child(even) {
    background-color: #f2f2f2;
}
.avatar {
    width: 50px;
    height: 50px;
}
```

![image-20250727150129743](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727150129743.png)

![image-20250727150051654](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727150051654.png)

##### 4.3.4、底部版权区域

```
AI Prompt:
再继续帮我生成第四个部分-页脚版权区域
1. 内容：第一行显示公司全称“江苏传智播客教育科技股份有限公司”；第二行展示版权信息，“版权所有 Copyright 2006-2024 All Rights Reserved"。
2. 设计：该区域应具有灰色背景，字体颜色为白色，居中对齐，以营造专业且同一的视觉效果。
```

```html
<!-- 页脚版权区域 -->
<footer class="footer">
    <p>江苏传智播客教育科技股份有限公司</p>
    <p>版权所有 Copyright 2006-2024 All Rights Reserved</p>
</footer>
```

```html
/* 页脚样式 */
.footer {
    background-color: #b5b3b3; /* 灰色背景 */
    color: white; /* 白色文字 */
    text-align: center; /* 居中文本 */
    padding: 10px 0; /* 上下内边距 */
    margin-top: 30px;
}

#container {
    width: 80%; /* 宽度为80% */
    margin: 0 auto; /* 水平居中 */
}
```

![image-20250727150518994](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727150518994.png)

### 5、总结

![image-20250727151719228](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727151719228.png)

![image-20250727152109420](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727152109420.png)

## 三、JS

### 1、介绍

JavaScript(简称：JS) 是一门跨平台、面向对象的脚本语言，用来控制网页行为，实现页面的交互效果。

JavaScript 和 Java 是完全不同的语言，不论是概念还是设计。但是基础语法类似。

### 2、组成

#### 2.1、ECMAScript

规定了JS基础语法核心知识，包括变量、数据类型、流程控制、函数、对象等。

![image-20250727153544738](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727153544738.png)

#### 2.2、BOM

浏览器对象模型，用于操作浏览器本身，如：页面弹窗、地址栏操作、关闭窗口等。

#### 2.3、DOM

文档对象模型，用于操作HTML文档，如：改变标签内的内容、改变标签内字体样式等。

### 3、JS 核心语法

#### 3.1、引入方式

##### 3.1.1、内部脚本

将JS代码定义在HTML页面中

```
JavaScript代码必须位于<script></script>标签之间
在HTML文档中，可以在任意地方，放置任意数量的<script>
一般会把脚本置于 <body>元素的底部，可以改善显示速度。
```

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727170543110.png" alt="image-20250727170543110" style="zoom:67%;" />

##### 3.1.2、外部脚本

将 JS代码定义在外部 JS文件中，然后引入到HTML页面中。

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727170650370.png" alt="image-20250727170650370" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727172204915.png" alt="image-20250727172204915" style="zoom:67%;" />

#### 3.2、基础语法

##### 3.2.1、变量 & 常量

（1）介绍

JS中用 **let关键字**来声明变量（**弱类型语言**，变量可以存放不同类型的值）。

===补充：在现代JavaScript开发中，优先使用`let`代替`var`，因为它更安全、可预测，并能避免许多常见错误。只在需要特殊行为（如函数作用域）或维护旧代码时使用`var`。

（2）变量命名规则

声明变量

- 只能用 字母、数字、下划线、美元符组成，且数字不能开头。
- 变量名严格区分大小写，如：name和 Name是不同的变量。
- 不能使用关键字，如：let、var、if、for 等。

声明常量

- JS 中用 **const 关键字**来声明常量。
- 一旦声明，常量的值就不能改变（不可以重新赋值）。

（3）小结

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727174601699.png" alt="image-20250727174601699" style="zoom:67%;" />

##### 3.2.2、数据类型

（1）分类

JavaScript 的数据类型分为：基本数据类型和引用数据类型（对象）。

（2）基本数据类型

- **number**：数字（整数、小数、NAN（Not a Number））
- **boolean**：布尔。true、false。
- **null**：对象为空。JavaScript是大小写敏感的，因此null、Null、NULL是完全不同的。
- **undefined**：当声明的变量未初始化时，该变量的默认值是 undefined。
- **String**：字符串，单引号、双引号、反引号皆可，推荐使用**单引号**。

--- 使用 **typeof 运算符**可以获取数据类型。

![image-20250727175501370](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727175501370.png)

--- **模板字符串**（反引号）：和${}一起使用，可以进行字符串的拼接。

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727180129143.png" alt="image-20250727180129143" style="zoom:67%;" />

```html
<script>
    //1. 数据类型
    alert(typeof 10); // number
    alert(typeof 1.5); // number

    alert(typeof true); // boolean
    alert(typeof false); // boolean

    alert(typeof "Hello"); // String
    alert(typeof 'JS'); // String
    alert(typeof `JavaScript`); // String

    alert(typeof null); // object

    let a ;
    alert(typeof a); // undefined

    // 2. 模板字符串 -- 简化字符串的拼接
    let name = 'tom';
    let age = 18;
    console.log(`我是${name},今年${age}岁了。`);
</script>
```

（3）引用数据类型

#### 3.3、函数

##### 3.3.1、介绍

函数（**function**）是被设计用来执行特定任务的代码块，方便程序的封装复用。

##### 3.3.2、定义

JavaScript 中的函数通过 **function** 关键字进行定义。

![image-20250727181030823](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727181030823.png)

##### 3.3.3、调用：函数名(实际参数列表)

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727181259249.png" alt="image-20250727181259249" style="zoom:67%;" />

--- **注意**：由于 JS是弱类型语言，形参、返回值都不需要指定类型。在调用函数时，实参个数与形参个数可以不一致，但是建议一致。

##### 3.3.4、匿名函数

匿名函数是指一种没有名称的函数，可以通过两种方式定义：函数表达式 和 箭头函数。

![image-20250727182024311](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727182024311.png)

匿名函数定义后，可以通过变量名直接调用。

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727182159223.png" alt="image-20250727182159223" style="zoom:67%;" />

```html
<script>
    // 1. 函数定义及调用 --- 具名函数
    // function add(a, b) {
    //   return a + b;
    // }

    // let result = add(10, 20);
    // alert(result);

    // 1. 函数定义及调用 --- 匿名函数
    // 函数表达式
    // let add = function(a, b) {
    //   return a + b;
    // }
    // let result = add(10, 20);
    // alert(result);

    // 箭头函数
    let add = (a, b) => {
      return a + b;
    }
    let result = add(20, 30);
    alert(result);
</script>
```



#### 3.4、自定义对象

##### 3.4.1、定义格式

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727184239682.png" alt="image-20250727184239682" style="zoom:80%;" />

##### 3.4.2、调用格式

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727184331839.png" alt="image-20250727184331839" style="zoom:80%;" />

```html
<script>
    // 1. 自定义对象的定义
    // let user = {
    //   name: 'tom',
    //   age: 18,
    //   gender: 'male',
    //   sing:function() {
    //     alert(this.name + '正在唱歌');
    //   }
    // }

    // let user = {
    //   name: 'tom',
    //   age: 18,
    //   gender: 'male',
    //   sing() {
    //     alert(this.name + '正在唱歌');
    //   }
    // }

    let user = {
      name: 'tom',
      age: 18,
      gender: 'male',
      sing: () => { // 注意：使用箭头函数时，this并不指向当前对象，而是指向父级。【不建议使用】
        alert(this.name + '正在唱歌');
      }
    }

    // 2. 调用格式
    alert(user.name);
    user.sing();
</script>
```

### 4、json

#### 4.1、概念

**J**ava**S**cript **O**bject **N**otation， JavaScript 对象标记法（JS对象标记法书写的文本）。

由于其语法简单，层次结构鲜明，现多用于作为 **数据载体**，在网络中进行数据传输。

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727192609699.png" alt="image-20250727192609699" style="zoom:80%;" />

```js
// 3. JSON -- JS对象标记法
let person = {
  name : 'Tom',
  age : 18,
  gender : 'male'
}
alert(JSON.stringify(person)); // JS -> JSON 将对象转为字符串

let personJSON = '{"name" : "rose", "age" : 22, "gender" : "female"}';
alert(JSON.parse(personJSON).name); // 字符串转对象
```

![image-20250727202400577](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727202400577.png)

#### 4.2、DOM

##### 4.2.1、概念

Document Object Model，文档对象模型。

将标记语言的各个组成部分封装为对应的对象：

- Document：整个文档对象
- Element：元素对象
- Attribute：属性对象
- Test：文本对象
- Comment：注释对象

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250727203122372.png" alt="image-20250727203122372" style="zoom:67%;" />

##### 4.2.2、JavaScript 通过DOM，就能够对HTML进行操作

- 改变 HTML元素的内容
- 改变 HTML元素的样式（CSS）
- 对 HTML DOM事件作出反应
- 添加和删除 HTML元素

#### 4.3、DOM操作

##### 4.3.1、DOM操作的核心思想

将网页中所有的元素当作对象来处理。（标签的所有属性在该对象上都可以找到）

##### 4.3.2、操作步骤

（1）获取要操作的DOM元素对象

（2）操作DOM对象的属性或方法（查文档或AI）

##### 4.3.3、获取DOM对象

（1）根据CSS选择器来获取DOM元素，获取匹配到的第一个元素：document.querySelector('选择器')

ID选择器、类选择器、元素选择器

（2）根据CSS选择器来获取DOM元素，获取匹配到的所有元素：document.querySelectorAll('选择器')

--- 注意：得到的是一个NodeList节点集合，是一个伪数组（有长度、索引的数组）

```html
<body>
  <h1 id="title1">11111</h1>
  <h1>22222</h1>
  <h1>33333</h1>

  <script>
    // 1. 修改第一个h1标签中的文本内容
    // 1.1 获取DOM对象
    // let h1 = document.querySelector('#title1');
    // let h1 = document.querySelector('h1');
    let hs = document.querySelectorAll('h1');
    // 1.2 调用 DOM对象中的属性或方法
    hs[0].innerHTML = '修改后的文本内容';
  </script>
</body>
```

### 5、JS 事件监听

#### 5.1、事件

HTML事件是发生在HTML元素上的“事情”。如：

- 按钮被点击
- 鼠标移动到元素上
- 按下键盘按键

#### 5.2、事件监听

JavaScript可以在事件触发时，就立即调用一个函数作出响应，也称为 **事件绑定**和**注册事件**。

#### 5.3、事件监听语法

##### 5.3.1、语法

事件源.addEventListener('事件类型', 事件出发执行的函数);

##### 5.3.2、事件监听三要素

（1）事件源：哪个dom元素触发了事件，要获取dom元素。

（2）事件类型：用什么方式触发，比如：鼠标单击 click。

（3）事件触发执行的函数：要做什么事。

示例：

```html
<body>
  <input type="button" id="btn1" value="点我一下试试1">
  <input type="button" id="btn2" value="点我一下试试2">
  <script>
    // 事件监听
    document.querySelector('#btn1').addEventListener('click', function() {
      alert('试试就试试');
    });
    // 事件绑定 --- 早期写法
    document.querySelector('#btn2').onclick = () => {
      alert('hello');
    }
  </script>
</body>
```

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728185022509.png" alt="image-20250728185022509" style="zoom: 80%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728185715255.png" alt="image-20250728185715255" style="zoom:67%;" />

#### 5.4、案例

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728185833053.png" alt="image-20250728185833053" style="zoom:67%;" />

```html
<script>
    //通过JS为上述的表格中数据行添加事件监听, 实现鼠标进入后, 背景色#f2e2e2; 鼠标离开后, 背景色需要设置为#fff; (JS新版本的语法)
    // 获取所有 tr标签
    let trs = document.querySelectorAll('tr');
    // 遍历 tr标签
    for (let i = 0; i < trs.length; i++) {
        trs[i].addEventListener('mouseenter', function () { // mouseenter 鼠标进入事件
            trs[i].style.backgroundColor = '#f2e2e2';
        });
        trs[i].addEventListener('mouseleave', function () { // mouseleave 鼠标移出事件
            trs[i].style.backgroundColor = '#fff';
        });
    }
</script>
```

#### 5.5、常见事件

##### 5.5.1、鼠标事件

- click：鼠标点击
- mouseenter：鼠标移入
- mouseleave：鼠标移出

##### 5.5.2、键盘事件

- keydown：键盘按下时触发
- keyup：键盘抬起时触发

##### 5.5.3、焦点事件

- focus：获得焦点触发
- blur：失去焦点触发

##### 5.5.4、表单事件

- input：用户输入时触发
- submit：用户提交时触发

#### 5.6、JS代码的优化（import、export）

当一个js文件中，多个方法中使用了共同的语句，就可以将其抽取出来放入一个新建的utils.js文件中，

在文件开头需要导入该js文件的路径，以及使用的方法。同时该js文件需要加入export关键字。

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728195037890.png" alt="image-20250728195037890" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728195139125.png" alt="image-20250728195139125" style="zoom:67%;" />

在HTML文件中的<script>标签中也要声明该模块。

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728195254501.png" alt="image-20250728195254501" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728195411209.png" alt="image-20250728195411209" style="zoom:80%;" />

## 四、Vue3

### 1、Vue 介绍

Vue 是一款用于**构建用户界面**的**渐进式**的JavaScript**框架**。（官方：https://cn.vuejs.org/）

（1）构建用户界面

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728195910838.png" alt="image-20250728195910838" style="zoom:67%;" />

（2）渐进式：根据项目的需要，使用vue中的功能

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728200357404.png" alt="image-20250728200357404" style="zoom:67%;" />

（3）框架

- 框架：就是一套完整的项目解决方案，用于快速构建项目。
- 优点：大大提升了前端项目的开发效率。
- 缺点：需要理解记忆框架的使用规则。

### 2、Vue 快速入门

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728201038686.png" alt="image-20250728201038686" style="zoom:67%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728201105539.png" alt="image-20250728201105539" style="zoom:80%;" />

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728201322470.png" alt="image-20250728201322470" style="zoom:67%;" />

```html
<body>
  <div id="app">
    <h1>{{ message }}</h1>
    <h1>{{ count }}</h1>
  </div>

  <script type="module">
    import { createApp, ref } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js'
    createApp({
      data() {
        return {
          message: "Hello Vue",
          count: 100
        }
      }
    }).mount("#app");
  </script>
</body>
```

![image-20250728215449358](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728215449358.png)

### 3、Vue 常用指令

#### 3.1、指令

HTML标签上带有 v- 前缀的特殊属性，不同的指令具有不同的含义，可以实现不同的功能。

#### 3.2、常用指令

![image-20250728220729532](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728220729532.png)

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728221202491.png" alt="image-20250728221202491" style="zoom:80%;" />

##### 3.2.1、v - for

![image-20250728221703242](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728221703242.png)

--- 注意：遍历的数组，必须在data中定义；要想让哪个标签循环展示多次，就在哪个标签上使用 v - for指令。

##### 3.2.2、v - bind

![image-20250728231104802](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728231104802.png)

##### 3.2.3、v - if / v - else - if / v - else

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728231807847.png" alt="image-20250728231807847" style="zoom: 80%;" />

![image-20250728231848894](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728231848894.png)

##### 3.2.4、v - show

![image-20250728231828626](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728231828626.png)

```html
<!-- 表格展示区 -->
<table>
    <!-- 表头 -->
    <thead>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>头像</th>
            <th>职位</th>
            <th>入职日期</th>
            <th>最后操作时间</th>
            <th>操作</th>
        </tr>
    </thead>

    <!-- 表格主体内容 -->
    <tbody>
        <tr v-for="(emp, index) in empList" :key="emp.id">
            <td>{{index + 1}}</td>
            <td>{{emp.name}}</td>
            <td>{{emp.gender == 1 ? '男' : '女'}}</td>
            <!-- 插值是不能出现在标签内部的 -->
             <!-- :src="emp.image" -->
            <td><img class="avatar"  v-bind:src="emp.image" :alt="emp.name"></td>
            <!-- v-if:控制元素的显示和隐藏 -->
            <td>
                <span v-if="emp.job == 1">班主任</span>
                <span v-else-if="emp.job == 2">讲师</span>
                <span v-else-if="emp.job == 3">学工主管</span>
                <span v-else-if="emp.job == 4">教研主管</span>
                <span v-else-if="emp.job == 5">咨询师</span>
                <span v-else>其他</span>
            </td>
            <!-- v-if:控制元素的显示和隐藏 -->
            <!-- <td>
                <span v-show="emp.job == 1">班主任</span>
                <span v-show="emp.job == 2">讲师</span>
                <span v-show="emp.job == 3">学工主管</span>
                <span v-show="emp.job == 4">教研主管</span>
                <span v-show="emp.job == 5">咨询师</span>
            </td> -->
            <td>{{emp.entrydate}}</td>
            <td>{{emp.updatetime}}</td>
            <td class="action-buttons">
                <button type="button">编辑</button>
                <button type="button">删除</button>
            </td>
        </tr>
    </tbody>
</table>
```

```html
<script type="module">
  import { createApp } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js'

  createApp({
    data() {
      return {
        empList: [
          { "id": 1,
            "name": "谢逊",
            "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/4.jpg",
            "gender": 1,
            "job": "1",
            "entrydate": "2023-06-09",
            "updatetime": "2024-09-30T14:59:38"
          },
          {
            "id": 2,
            "name": "韦一笑",
            "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg",
            "gender": 1,
            "job": "1",
            "entrydate": "2020-05-09",
            "updatetime": "2024-09-01T00:00:00"
          },
          {
            "id": 3,
            "name": "黛绮丝",
            "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/2.jpg",
            "gender": 2,
            "job": "2",
            "entrydate": "2021-06-01",
            "updatetime": "2024-09-01T00:00:00"
          }
        ]
      }
    }
  }).mount('#container')
</script>
```

![image-20250728233100513](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728233100513.png)

![image-20250728233201105](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728233201105.png)

##### 3.2.5、v - model

![image-20250728233607611](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728233607611.png)

![image-20250728233808632](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728233808632.png)

![image-20250728233835446](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250728233835446.png)

##### 3.2.6、v - on

![image-20250729004759412](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729004759412.png)

![image-20250729010132354](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729010132354.png)

--- 注意：当绑定的按钮，type值不是button时，在@click后加入.prevent，避免默认提交。

![image-20250729091949188](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729091949188.png)

## 五、Ajax/Axios

### 1、入门

#### 1.1、介绍

Asynchronous JavaScript And XML，**异步** 的JavaScript 和 XML。

#### 1.2、作用

（1）数据交换：通过Ajax可以给服务器发送请求，并获取服务器响应的数据。

（2）异步交互：可以在不重新加载页面的情况下，与服务器交换数据并更新部分网页的技术，如：搜索联想、用户名是否可用的校验等等。

#### 1.3、同步和异步

![image-20250729093236161](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729093236161.png)

### 2、Axios

#### 2.1、介绍

Axios对原生的 Ajax进行了封装，简化书写，快速开发。

#### 2.2、官网

https://www.axios-http.cn/

#### 2.3、步骤

（1）引入Axios的文件(参照官网)

```html
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
```

（2）使用Axios发送请求，并获取响应结果

![image-20250729094142395](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729094142395.png)

===注意：使用Axios发起异步请求的时候，url只能使用小写，不能使用大写，否则不能识别。

错误示例：

![image-20250729101644401](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729101644401.png)

![image-20250729101735953](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729101735953.png)

正常情况：

![image-20250729101622487](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729101622487.png)

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729101827354.png" alt="image-20250729101827354" style="zoom:67%;" />

```html
<body>
    <input type="button" value="获取数据GET" id="btnGet">
    <input type="button" value="操作数据POST" id="btnPost">

    <script src="./js/axios.js"></script>
    <script>
        //发送GET请求
        document.querySelector('#btnGet').addEventListener('click', () => {
            // axios发起异步请求
            axios({
                url:'https://mock.apifox.cn/m1/3083103-0-default/emps/list',
                method:'GET'
            }).then((result) => { // 成功回调函数
                console.log(result.data); // 拿到数据需要 .data
            }).catch((error) => { // 失败回调函数
                console.log(error);
            })
        })

        //发送POST请求
        document.querySelector('#btnPost').addEventListener('click', () => {
            axios({
                url:'https://mock.apifox.cn/m1/3083103-0-default/emps/update',
                method:'POST',
                data:{id:1} // POST请求的参数,建议使用对象格式
            }).then((result) => {
                console.log(result.data);
            }).catch((error) => {
                console.log(error);
            })
        })
    </script>
</body>
```

（3）Axios简化格式（推荐使用）

--- 成功回调函数和失败回调函数的快捷键 : thenc

![image-20250729102623500](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729102623500.png)

```html
<body>
    <input type="button" value="获取数据GET" id="btnGet">
    <input type="button" value="操作数据POST" id="btnPost">

    <script src="js/axios.js"></script>
    <script>
        //发送GET请求
        document.querySelector('#btnGet').addEventListener('click', () => {
            // 成功回调函数和失败回调函数的快捷键 : thenc
            // 说明：then后面是等服务器返回数据之后，再执行then中的回调函数，所以会先执行下面语句。
            axios.get('https://mock.apifox.cn/m1/3083103-0-default/emps/list').then((result) => {
                console.log(result.data);
            });
            console.log('================================='); // 先执行
        })

        //发送POST请求
        document.querySelector('#btnPost').addEventListener('click', () => {
            axios.post('https://mock.apifox.cn/m1/3083103-0-default/emps/update','id=1').then((result) => {
                console.log(result.data);
            }).catch((error) => {
                console.log(error);
            });
        })
    </script>
</body>
```

#### 2.4、同步

（1）场景：当异步操作的数据过多时，程序会先执行下面的逻辑，下面处理完成之后再返回执行，达不到预期效果。此时需要使用同步的关键词。

（2）介绍：可以通过 async、await可以让异步变成同步操作，

async就是来声明一个异步方法，await是用来等待异步任务执行。

（3）优点：可读性强、便于维护

--- 注意：await必须出现在async修饰的异步中。

```HTML
<script type="module">
    import { createApp } from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js'

    createApp({
        data() {
            return {
                searchForm: { // 封装用户输入的查询条件
                    name: '',
                    gender: '',
                    job: ''
                },
                empList: []
            }
        },
        // 方法
        methods: {
            async search() { // 加入同步之后，就不需要回调函数了
                // 异步请求获取员工列表数据
                let result = await axios.get(`https://web-server.itheima.net/emps/list?name=${this.searchForm.name}&gender=${this.searchForm.gender}&job=${this.searchForm.job}`);
                // 成功回调后，将数据赋给 empList
                // 说明：第一个data是axios的响应属性，用来封装服务器返回的数据
                // 第二个data是服务器的数据
                this.empList = result.data.data;
            },
            clear() {
                this.searchForm = { name: '', gender: '', job: '' };
                // 清空后的同时也要在页面上展示所有数据
                this.search();
            }
        },
    }).mount('#container')
</script>
```

（5）如何在页面加载完毕之后自动发起请求，请求服务器端？

--- Vue声明周期

### 3、Vue 生命周期

#### 3.1、介绍

生命周期：指一个对象从创建到销毁的整个过程。

生命周期的八个阶段：每触发一个声明周期事件，会自动执行一个声明周期方法（钩子）。

#### 3.2、八个钩子函数

![image-20250729144737220](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729144737220.png)

演示：

<img src="D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729144632528.png" alt="image-20250729144632528" style="zoom:67%;" />

小结：

![image-20250729144935558](D:\软件工程\JavaWeb + AI\01-前端Web基础\imgs\image-20250729144935558.png)