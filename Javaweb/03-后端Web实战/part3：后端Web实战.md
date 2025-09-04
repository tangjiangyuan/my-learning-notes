# part3：后端Web实战

===需求===

![image-20250805112159553](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805112159553.png)

## 一、部门管理

### 1、准备工作

#### 1.1、开发规范-开发模式

（1）前后端混合开发

<img src="D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805112710830.png" alt="image-20250805112710830" style="zoom:67%;" />

（2）前后端分离开发

<img src="D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805113352792.png" alt="image-20250805113352792" style="zoom:67%;" />

（3）开发流程

![image-20250805113500347](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805113500347.png)

（4）小结

![image-20250805113617568](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805113617568.png)

#### 1.2、开发规范-Resetful风格

（1）介绍

​	REST（REpresentational State Transfer），表述性状态转换，它是一种软件架构风格。

（2）Restfule风格url与传统风格url的区别

![image-20250805114144778](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805114144778.png)

===注意===

- REST是风格，是约定方式，不是规定，可以打破；
- 描述功能模块通常使用复数形式（加s），表示此类资源，而非单个资源。如users、books。。。

（3）小结

![image-20250805140638480](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805140638480.png)

![image-20250805140836630](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805140836630.png)

（4）apifox 

![image-20250805140949346](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805140949346.png)

===小结

![image-20250805142312281](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805142312281.png)

#### 1.3、工程搭建

![image-20250805143428112](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805143428112.png)

![image-20250805143506265](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805143506265.png)

### 2、查询部门

#### 2.1、接口开发

（1）思路分析

![image-20250805153031278](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805153031278.png)

（3）项目结构

![image-20250805161257846](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805161257846.png)

===DeptController.java

```java
package com.tjy.controller;

import com.tjy.pojo.Dept;
import com.tjy.pojo.Result;
import com.tjy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/5 15:18
 */
@SuppressWarnings("ALL")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /* 查询所有部门信息 */
    // 限定查询的类型
    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    public Result list() {
        System.out.println("查询所有部门信息");
        List<Dept> list =  deptService.findAll();
        return Result.success("查询成功！");
    }
}
```

===DeptServiceImpl.java

```java
package com.tjy.service.impl;

import com.tjy.mapper.DeptMapper;
import com.tjy.pojo.Dept;
import com.tjy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/5 15:18
 */
@SuppressWarnings("ALL")
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /* 查询所有部门信息 */
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
```

===DeptMapper.java

```java
package com.tjy.mapper;

import com.tjy.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    /* 查询所有部门信息 */
    @Select("select id, name, create_time, update_time from dept order by update_time desc;")
    List<Dept> findAll();
}

```

![image-20250805161918057](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805161918057.png)

===扩展===限定查询类型的两种方式

![image-20250805162434464](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805162434464.png)

（4）小结

![image-20250805162704742](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805162704742.png)

#### 2.2、结果封装

![image-20250805162813113](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805162813113.png)

##### 2.2.1、代码演示

（1）手动结果封装

```java
/* 查询所有部门信息 */
@Results({
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime")
})
@Select("select id, name, create_time, update_time from dept order by update_time desc;")
List<Dept> findAll();
```

（2）起别名

![image-20250805163854453](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805163854453.png)

```java
@Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc;")
List<Dept> findAll();
```

（3）开启驼峰命名-加入配置（推荐）

![image-20250805164430531](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805164430531.png)

===小结

![image-20250805164949869](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805164949869.png)

#### 2.3、前后端联调测试

![image-20250805165138187](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805165138187.png)

![image-20250805170550110](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805170550110.png)

===前端如何连接到Tomcat服务器？

​	Nginx的反向代理

![image-20250805170931271](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805170931271.png)

===小结

![image-20250805171239323](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805171239323.png)

### 3、删除部门

#### 3.1、思路分析

![image-20250805171646823](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805171646823.png)

#### 3.2、代码演示

（1）方式一：

```java
/* 删除部门 - 方式一：HttpServletRequest 获取请求参数 */
@DeleteMapping("/depts")
public Result delete(HttpServletRequest request) {
    String idStr = request.getParameter("id");
    int id = Integer.parseInt(idStr);
    System.out.println("根据id删除部门:" + id);
    return Result.success();
}
```

![image-20250805172510191](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805172510191.png)

===缺点

​	繁琐、需要手动类型转换

（2）方式二：

```java
/* 删除部门 - 方式二：@RequestParam 获取请求参数 */
// @RequestParam 获取前端传过来的值，绑定给deptId
// 一旦声明了@RequestParam，该参数在请求时必须传递，如果不传递将会报错，（默认required 为true）
@DeleteMapping("/depts")
public Result delete(@RequestParam("id") Integer deptId) {
    deptService.deleteById(deptId);
    return Result.success();
}
```

===注意

​	@RequestParam注解required属性值为true，代表该参数必须传递，如果不传递将报错。如果参数可选，可以将参数设置为false。

（3）方式三【推荐】

```java
/* 删除部门 - 方式三：如果请求参数名与形参变量名相同，直接定义方法形参即可接收。（省略@RequestParam） */
@DeleteMapping("/depts")
public Result delete(Integer id) {
    deptService.deleteById(id);
    return Result.success();
}
```

===小结

![image-20250805184142935](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805184142935.png)

![image-20250805184650367](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805184650367.png)

### 4、新增部门

#### 4.1、思路分析

![image-20250805190242483](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805190242483.png)

===扩展：如何接收JSON格式的数据？

![image-20250805190423663](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805190423663.png)

​	通过@RequestBody 注解来接收JSON格式的数据。

#### 4.2、代码演示

===controller

```java
/* 根据部门名称添加部门 */
@PostMapping("/depts")
public Result add(@RequestBody Dept dept) {
    deptService.addByName(dept);
    return Result.success();
}
```

===service

```java
/* 根据部门名称添加部门 */
@Override
public void addByName(Dept dept) {
    // 1. 补全基础属性 - create_time, update_time
    dept.setCreateTime(LocalDateTime.now());
    dept.setUpdateTime(LocalDateTime.now());
    // 2. 调用mapper接口，传入参数
    deptMapper.addByName(dept);
}
```

===mapper

```java
// 如果传入的参数是对象，则SQL语句中直接写对象的属性名，同时补全的信息也需要加入SQL语句中，否则补全的信息会被忽略
@Insert("insert into dept(name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime});")
void addByName(Dept dept);
```

![image-20250805193203708](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805193203708.png)

===小结

![image-20250805193433635](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805193433635.png)

### 5、修改部门

#### 5.1、查询回显

将查询的数据显示在页面中

![image-20250805193703817](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805193703817.png)

（1）思路分析

![image-20250805193945904](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805193945904.png)

![image-20250805194053787](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805194053787.png)

（2）代码演示

```java
/* 根据id查询部门 */
@GetMapping("/depts/{id}")
public Result getInfoById(@PathVariable("id") Integer deptId) {
    Dept dept = deptService.getInfoById(deptId);
    return Result.success(dept);
}
```

```java
@Override
public Dept getInfoById(Integer deptId) {
    Dept dept = deptMapper.getInfoById(deptId);
    return dept;
}
```

```java
@Select("select * from dept where id = #{id}")
Dept getInfoById(Integer id);
```

===省略写法

![image-20250805195322107](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805195322107.png)

![image-20250805200003495](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805200003495.png)

#### 5.2、修改数据

（1）思路分析

![image-20250805201208715](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805201208715.png)

（2）代码演示

```java
/* 修改部门信息 */
@PutMapping("/depts")
public Result update(@RequestBody Dept dept) {
    deptService.update(dept);
    return Result.success();
}
```

```java
/* 修改部门信息 */
@Override
public void update(Dept dept) {
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.update(dept);
}
```

```java
/* 修改部门信息 */
@Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
void update(Dept dept);
```

（3）代码优化

![image-20250805221337651](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805221337651.png)

===注意

​	一个完整的请求路径，应该是类上的 @RequestMapping 的value属性 + 方法上的 @RequestMapping的value属性。

![image-20250805221650233](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250805221650233.png)

### 6、日志技术

![image-20250806090554757](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806090554757.png)

#### 6.1、介绍

![image-20250806090757641](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806090757641.png)

#### 6.2、作用

![image-20250806090815967](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806090815967.png)

#### 6.3、相关日志技术

![image-20250806091050728](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806091050728.png)

#### 6.4、Logback快速入门

![image-20250806091400669](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806091400669.png)

===补充

配置文件一般放在resources包下

![image-20250806092211081](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806092211081.png)

===固定格式

```java
private static final Logger log = LoggerFactory.getLogger(当前类.class);
```

#### 6.5、Logback配置文件详解

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!-- 控制台输出 -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <!--格式化输出：%d 表示日期，%thread 表示线程名，%-5level表示级别从左显示5个字符宽度，%logger显示日志记录器的名称， %msg表示日志消息，%n表示换行符 -->
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50}-%msg%n</pattern>
        </encoder>
    </appender>

    <!-- 系统文件输出 -->
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <!-- 日志文件输出的文件名, %i表示序号 -->
            <FileNamePattern>D:\Dev-work\web-ai-code2\tlias-%d{yyyy-MM-dd}-%i.log</FileNamePattern>
            <!-- 最多保留的历史日志文件数量 -->
            <MaxHistory>30</MaxHistory>
            <!-- 最大文件大小，超过这个大小会触发滚动到新文件，默认为 10MB -->
            <maxFileSize>10MB</maxFileSize>
        </rollingPolicy>

        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <!--格式化输出：%d 表示日期，%thread 表示线程名，%-5level表示级别从左显示5个字符宽度，%msg表示日志消息，%n表示换行符 -->
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50}-%msg%n</pattern>
        </encoder>
    </appender>

    <!-- 日志输出级别 -->
    <root level="ALL">
        <appender-ref ref="STDOUT" />
        <appender-ref ref="FILE" />
    </root>
</configuration>
```



#### 6.6、Logback日志级别

trace -> debug -> info -> warn -> error ; all、off

#### 6.7、优化项目

（1）项目中使用日志的两种方式

![image-20250806100105553](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806100105553.png)

![image-20250806101855758](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806101855758.png)

===补充

​	日志级别推荐选择info

（2）小结

![image-20250806102007145](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806102007145.png)

## 二、员工管理

### 1、多表

#### 1.1、多表关系

（1）介绍

​		项目开发中，在进行数据库表结构设计时，会根据业务需求及业务模块之间的关系，分析设计表结构。由于业务之间相互关联，所以各个表结构之间也存在着各种方法。

（2）一对多（多对一）

- 场景：部门与员工之间的关系（一个部门中有多个员工）

![image-20250806103113235](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806103113235.png)

===说明

在多的表中将一的表中的主键，在自己表内设为外键。

- 一对多的关系如何实现？
  - 在数据库表多的一方，添加字段，来关联一的一方的主键。

- 分析

![image-20250806111010077](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806111010077.png)

- 外键添加

![image-20250806111132184](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806111132184.png)

```sql
-- 添加外键（emp_id -> dept表的主键id）
alter table emp add constraint fk_emp_dept_id foreign key emp(dept_id) references dept(id);
```

![image-20250806112353602](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806112353602.png)

- 逻辑外键与物理外键

  ![image-20250806112900359](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806112900359.png)

- 小结

![image-20250806112929585](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806112929585.png)

（3）一对一

- 介绍

![image-20250806113219947](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806113219947.png)

- 添加外键

![image-20250806113838225](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806113838225.png)

- 小结

![image-20250806113956119](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806113956119.png)

（4）多对多

- 介绍

![image-20250806114302636](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806114302636.png)

![image-20250806141020899](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806141020899.png)

===总结

![image-20250806141135622](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806141135622.png)

（5）案例

![image-20250806143031721](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806143031721.png)

```sql
-- 案例：多表设计
-- dept(1) -> emp(n)       emp(1) -> emp_expr(n)
create table emp_expr(
    id int unsigned primary key auto_increment comment 'id, 主键',
    begin date comment '开始日期',
    end date comment '结束日期',
    company varchar(50) comment '公司名称',
    job varchar(50) comment '职位',
    emp_id int unsigned comment '关联的员工ID'
) comment '员工工作经历表';
```



#### 1.2、多表查询

##### 1.2.1、笛卡尔积

![image-20250806144547993](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806144547993.png)

（1）实例

```sql
select * from emp, dept where emp.dept_id = dept.id;
```

（2）分类

![image-20250806144721930](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806144721930.png)

##### 1.2.2、连接查询

（1）内连接

===基础语法

![image-20250806145043848](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806145043848.png)

===演示

![image-20250806150813167](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806150813167.png)

===起别名-as关键字可以省略

![image-20250806150917686](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806150917686.png)

![image-20250806151119163](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806151119163.png)

（2）外连接

![image-20250806151411777](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806151411777.png)

===演示

![image-20250806152753087](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806152753087.png)

===补充

对于外连接，常用的是左外连接，因为右外连接的SQL也可以改造成左外连接（两张表调换顺序）。

##### 1.2.3、子查询

（1）介绍

SQL语句中嵌套select语句，称为嵌套查询，又称为子查询。

（2）形式

```sql
select * from t1 where column1 = (select column1 from t2...)
```

（3）说明

子查询外部的语句可以是insert / update / delete / select 的任何一个，最常见的是select。

（4）分类

- 标量子查询：子查询返回的结果为单个值；
- 列子查询：子查询返回的结果为一列；
- 行子查询：子查询返回的结果为一行；
- 表子查询：子查询返回的结果为多行多列。

===补充

子查询的要点是，先对需求做差分，明确具体的步骤，然后再逐步编写SQL语句。

（5）标量子查询

===演示

![image-20250806165339834](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806165339834.png)

（6）列子查询

===演示

![image-20250806170123586](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806170123586.png)

（7）行子查询

===演示

![image-20250806170622638](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806170622638.png)

（8）表子查询

===演示

![image-20250806171931422](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806171931422.png)

（9）案例

![image-20250806183107631](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806183107631.png)

<img src="D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250806191920299.png" alt="image-20250806191920299"  />

### 2、员工列表查询

#### 2.1、准备工作

===需求

![image-20250807090850860](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807090850860.png)

===准备工作

![image-20250807090942206](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807090942206.png)

```sql
-- 需要使用左外连接，需要包含所有员工信息（即使没有部门）
select e.*, d.name from emp e left join dept d on e.dept_id = d.id;
```



#### 2.2、分页查询

##### 2.2.1、原始方式

![image-20250807095331801](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807095331801.png)

（2）结果封装类

```java
@Data
public class PageResult<T> {
    private long total; // 总记录数
    private List<T> rows; // 每行数据
}
```

（3）总结

![image-20250807095914654](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807095914654.png)

（4）代码实现

![image-20250807100128202](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807100128202.png)

![image-20250807100356741](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807100356741.png)

===controller

```java
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     *  分页查询
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询:{},{}", page, pageSize);
        PageResult<Emp> pageResult =  empService.page(page, pageSize);
        return Result.success(pageResult);
    }
}
```

===service

```java
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 1. 调用 mapper接口，查询总记录数
        Long total = empMapper.count();
        // 2. 调用 mapper 接口，获取数据列表
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);
        // 3. 封装为PageResult 对象
        return new PageResult<Emp>(total, rows);
    }
}
```

===mapper

```java
@Mapper
public interface EmpMapper {

    /* 获取总记录数 */
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id;")
    Long count();

    /* 分页查询 */
    // 说明=== Emp中封装的部门名称变量名为deptName，所以此处需要起别名
    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
            "order by e.update_time desc " +
            "limit #{start}, #{pageSize}")
    List<Emp> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
}
```

![image-20250807114050091](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807114050091.png)

===补充

![image-20250807112721116](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807112721116.png)

```java
@GetMapping
public Result page(@RequestParam(defaultValue = "1") Integer page, 
                   @RequestParam(defaultValue = "10") Integer pageSize) {
    log.info("分页查询:{},{}", page, pageSize);
    PageResult<Emp> pageResult =  empService.page(page, pageSize);
    return Result.success(pageResult);
}
```

===总结

![image-20250807113227643](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807113227643.png)

##### 2.2.2、PageHelper 分页插件

===介绍

​	PageHelper 是第三方提供的在Mybatis框架中用来实现分页的插件，用来简化分页操作，提高开发效率。

===对比

![image-20250807113627083](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807113627083.png)

===操作步骤

![image-20250807113745888](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807113745888.png)

===依赖

```xml
<!-- 分页插件 PageHelper -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>1.4.7</version>
</dependency>
```

![image-20250807202244142](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250807202244142.png)

===mapper

```java
@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc ")
List<Emp> list();
```

===service

```java
@Override
public PageResult<Emp> page(Integer page, Integer pageSize) {
    // 1. 设置查询条件
    PageHelper.startPage(page, pageSize);
    // 2. 执行查询
    List<Emp> empList = empMapper.list(); // empList 实际类型就是 Page
    // 3. 解析查询结果，并封装
    Page<Emp> p = (Page<Emp>) empList; // p中可以获得 总记录数和 结果封装的集合
    return new PageResult<>(p.getTotal(), p.getResult());
}
```

（3）PageHelper 的实现机制

===改造一

![image-20250808092257787](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808092257787.png)

===改造二

![image-20250808092323683](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808092323683.png)

===注意事项

- 在使用PageHelper时，定义的SQL语句后面不能加分号。否则会导致SQL语法错误异常。-----  SQLSyntaxErrorException
  - 原因：在PageHelper 改造SQL语句添加分页时，会自动添加limit 关键字，而加了分号，会使limit在分号后面，出现语法错误。
  - 建议以后的sql语句不要加入分号

![image-20250808093601628](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808093601628.png)

- PageHelper 仅仅能对紧跟在其后面的第一个查询语句进行分页查询。

![image-20250808093659536](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808093659536.png)

===小结

![image-20250808093851509](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808093851509.png)

#### 2.3、条件分页查询

（1）需求

![image-20250808094727399](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808094727399.png)

（2）步骤

![image-20250808095626551](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808095626551.png)

===controller

```java
@GetMapping
public Result page(@RequestParam(defaultValue = "1") Integer page,
                   @RequestParam(defaultValue = "10") Integer pageSize,
                   String name, Integer gender,
                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
    log.info("分页查询:{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
    PageResult<Emp> pageResult =  empService.page(page, pageSize, name, gender, begin, end);
    return Result.success(pageResult);
}
```

===service

```java
@Override
public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
    // 1. 设置查询条件
    PageHelper.startPage(page, pageSize);
    // 2. 执行查询
    List<Emp> empList = empMapper.list(name, gender, begin, end); // empList 实际类型就是 Page
    // 3. 解析查询结果，并封装
    Page<Emp> p = (Page<Emp>) empList; // p中可以获得 总记录数和 结果封装的集合
    return new PageResult<>(p.getTotal(), p.getResult());
}
```

===mapper

```java
List<Emp> list(@Param("name") String name, @Param("gender") Integer gender, @Param("begin") LocalDate begin, @Param("end") LocalDate end);
```

===mapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.tjy.mapper.EmpMapper">
    <select id="list" resultType="com.tjy.pojo.Emp">
        select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id
        where e.name like concat('%', #{name}, '%')
          and e.gender = #{gender}
          and e.entry_date between #{begin} and #{end}
        order by e.update_time desc
    </select>
</mapper>
```

![image-20250808103959936](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808103959936.png)

===原因：程序模糊查询时不识别 '%#{name}%'，即问号不能出现在引号内

===解决：使用 concat() 字符串拼接函数

![image-20250808111034585](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808111034585.png)

===总结

![image-20250808111229353](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808111229353.png)

（3）代码优化

===优化一

![image-20250808111510505](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808111510505.png)

```java
@Data
public class EmpQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
}
```

===小结

![image-20250808113030141](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808113030141.png)

===优化二

![image-20250808113417661](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808113417661.png)

![image-20250808113631453](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808113631453.png)

![image-20250808114246869](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808114246869.png)

===补充

test中不能写 e.name != null

===优化三

当不输入name，输入gender时，会多一个and

解决：

![image-20250808140932794](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808140932794.png)

```java
<mapper namespace="com.tjy.mapper.EmpMapper">
    <select id="list" resultType="com.tjy.pojo.Emp">
        select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id
        <where>
            <if test="name != null and name != ''">
                e.name like concat('%', #{name}, '%')
            </if>
            <if test="gender != null">
                and e.gender = #{gender}
            </if>
            <if test="begin != null and end != null">
                and e.begin = #{begin} and e.end = #{end}
            </if>
        </where>
        order by e.update_time desc
    </select>
</mapper>
```

===小结

![image-20250808141718088](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808141718088.png)

### 3、员工添加功能

#### 3.1、新增员工

![image-20250808142347092](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808142347092.png)

===思路

![image-20250808144432700](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808144432700.png)

===步骤

![image-20250808150550352](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808150550352.png)

![image-20250808151955451](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808151955451.png)

===问题：添加的工作经历中的员工id需要获取上一个新增员工的id，如何获取？

EmpMapper:

![image-20250808153154524](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808153154524.png)

![image-20250808160610587](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808160610587.png)

===补充：易错点

在EmpMapper.xml中也要写如主键返回的参数

![image-20250808183159726](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808183159726.png)

在EmpExprMapper.xml中是item不是index

![image-20250808183249005](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808183249005.png)

===小结

![image-20250808201904868](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250808201904868.png)

#### 3.2、事物处理

===引言：如在保存基本信息和保存工作经历业务中间出现了异常？

![image-20250809112548607](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809112548607.png)

##### 3.2.1、介绍&操作

（1）概念：**事物** 是一组操作的集合，它是一个不可分割的工作单位。事物会把所有的操作作为一个整体一起向系统提交或撤销操作请求，即这些操作 **要么同时成功，要么同时失败**。

==注意：默认MySQL的事务是自动提交的，也就是说，当执行一条DML语句，MySQL会立即隐式的提交事物。

===为什么学习事务操作？

​		事务（/业务）中包含多步操作，要避免MySQL的隐式提交，保证所有操作要么同时成功，要么同时失败；不能个例成功，个例失败，这样会导致事务不严谨。

（2）操作：事物控制主要三步操作：开启事务、提交事务 / 回滚事务

![image-20250809114910157](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809114910157.png)

===补充：commit 和 rollback 是互斥的。只要回滚，成功的操作也会撤销，保证一致性。

===说明：此时已开启事务，并且两条SQL语句执行成功，但是对应的表中并没有显示对应的数据，只有commit 提交事务后，才会刷新对应的表。（此时编写SQL语句是可以通过控制台看到新增的数据的---事务隔离）

（3）小结

![image-20250809115557241](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809115557241.png)

##### 3.2.2、Spring 事务管理

（1）介绍

![image-20250809120050046](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809120050046.png)

（2）位置

![image-20250809120116127](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809120116127.png)

===说明

注解加在方法上：表示该方法是一个事务，需要事务管理；（推荐）

加在类上：表示该类中的所有方法都需要事务管理；

加在接口上：表示该接口的所有实现类都需要事务管理

===**不推荐**加载类、接口上。原因：类中或接口的实现类中的方法不一定都用到了SQL操作，会造成资源浪费。

===**推荐**加在操作了两次以上数据库增删改查的SQL语句的方法上。

（3）添加配置---专门查看该包下的debug信息

```properties
# 配置日志信息，查看spring 事务管理的底层日志
logging:
  level:
    org.springframework.jdbc.support.JdbcTransactionManager: debug
```

（4）小结

![image-20250809122203503](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809122203503.png)

##### 3.2.3、事务进阶&四大特性

（1）进阶 rollbackFor属性

===补充：事务管理 **默认**在出现**运行时异常** RuntimeException 时才会回滚，其它异常不会回滚，导致事务不一致、不完整。而 Transactional 中的 rollbackFor 这个属性很好的规避了这个现象。

```java
@Transactional(rollbackFor = {Exception.class}) // 事务管理 - 所有异常都会进行回滚操作
@Override
public void save(Emp emp) {
    // 1. 新增员工基本信息 -- 前端不会转递创建时间和修改时间
    emp.setCreateTime(LocalDateTime.now());
    emp.setUpdateTime(LocalDateTime.now());
    empMapper.insert(emp);


    // 2. 新增员工的工作经历
    List<EmpExpr> exprList = emp.getExprList();
    if(!CollectionUtils.isEmpty(exprList) && emp.getId() != null){
        //遍历集合, 为empId赋值
        exprList.forEach(empExpr -> {
            empExpr.setEmpId(emp.getId());
        });
        empExprMapper.insertBatch(exprList);
    }
}
```

（2）进阶 propagation属性

事务传播行为：指的是当一个事务方法被另一个事务方法调用时，这个事务方法应该如何进行事务控制。

![image-20250809123524905](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809123524905.png)

===内部相关属性

![image-20250809123717553](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809123717553.png)

===案例---通过案例了解propagation的用法

![image-20250809123901814](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809123901814.png)

===步骤：注入EmpLogService -> 调用 insertLog() -> 放入 finally代码块中（无论。。。）

===为什么注入的是service， 而不是mapper？原因：事务的传播性只有在service层才能使用（事务管理）

演示：成功

```java
@Transactional(rollbackFor = {Exception.class}) // 事务管理 - 所有异常都会进行回滚操作
@Override
public void save(Emp emp) {
    try {
        // 1. 新增员工基本信息 -- 前端不会转递创建时间和修改时间
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        // 2. 新增员工的工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList) && emp.getId() != null){
            //遍历集合, 为empId赋值
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    } finally {
        // 记录操作日志 注入EmpLogService -> 调用 insertLog()
        EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工:" + emp);
        empLogService.insertLog(empLog);
    }
}
```

===说明：员工基本信息和工作经历，以及日志都正常上传到数据库中

演示：失败（在操作中加入异常）

===说明：员工基本信息和工作经历，以及日志上传数据库都失败了，原因：因为加入了rollbackFor属性，只要有异常，就会回滚，虽然日志记录操作放入了finally代码块中，但也进行了回滚。

===说明：不能让日志记录操作的事务处于基本操作事务中，而是单独处于自己的事务管理中。

===处理：在EmpLogServiceImpl中添加事务，Transactional中的propagation的默认值是REQUIRED，表示调用的方法中有事务就加入该事务，但是此刻需要自己的事务，因此将默认值改为REQUIRES.NEW

```java
@SuppressWarnings("ALL")
@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW) // 注意
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
```

===小结

![image-20250809131905544](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809131905544.png)

（3）四大特性（ACID）

![image-20250809131956931](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250809131956931.png)

#### 3.3、文件上传

##### 3.3.1、简介

（1）概念

- 文件上传：是指将本地图片、视频、音频等文件上传到服务器，供其他用户浏览或下载的过程。
- 文件上传在项目中应用非常广泛，我们经常发微信朋友圈、微博等都用到了文件上传功能。

（2）前后端行为

![image-20250810105821902](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250810105821902.png)

===说明：文件上传方式必须是 POST，且必须有该属性：enctype="multipart/form-data"。如果没有该属性，只会上传文件的名字，而不会上传文件的内容。

===补充：上传的文件会放在临时目录下，上传完毕后就消失了。

![image-20250810112623052](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250810112623052.png)

##### 3.3.2、本地存储

（1）操作

![image-20250810112456480](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250810112456480.png)

===说明：不能上传超过1MB大小的文件

（2）上传较大的文件

![image-20250810115008175](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250810115008175.png)

（3）小结

![image-20250810115316537](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250810115316537.png)

##### 3.3.3、阿里云OSS

（1）介绍

![image-20250811091852027](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811091852027.png)

![image-20250811091947087](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811091947087.png)

（2）第三方服务-通用思路

![image-20250811092123224](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811092123224.png)

===补充:SDK:（Software Development Kit 的缩写），软件开发工具包，包括辅助软件开发的依赖（jar包）、代码示例等，都可以叫做SDK。

（3）准备工作

![image-20250811092446256](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811092446256.png)

![image-20250811092518281](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811092518281.png)

（4）参照官方SDK

（5）集成使用

### 4、删除员工

#### 4.1、需求分析

![image-20250811095834186](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811095834186.png)

![image-20250811095955746](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811095955746.png)

#### 4.2、准备SQL语句

```sql
-- 删除员工
delete from emp where id in (1, 2, 3);

delete from emp_expr where emp_id in (1, 2, 3);
```

#### 4.3、三层架构

![image-20250811100444091](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811100444091.png)

#### 4.4、controller

![image-20250811100609818](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811100609818.png)

===推荐使用方式二，可以使用集合中的一系列方法

#### 4.5、小结

![image-20250811112455487](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811112455487.png)

### 5、修改员工

#### 5.1、需求分析

![image-20250811112631841](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811112631841.png)

#### 5.2、查询回显

（1）分析

![image-20250811112805334](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811112805334.png)

![image-20250811140538608](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811140538608.png)

（2）SQL语句

```sql
-- 修改员工

-- 根据 id查询员工的基本信息(emp)以及工作经历信息(emp_expr)
-- 应该使用外连接，内连接查询的是有交集的信息，即有工作经历的员工信息
select
    e.*,
    ex.id ex_id,
    ex.emp_id ex_empId,
    ex.begin ex_begin,
    ex.end ex_end,
    ex.company ex_company,
    ex.job ex_job
from emp e left join emp_expr ex on e.id = ex.emp_id
where e.id = 35;
```

（3）三层架构

![image-20250811140342999](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811140342999.png)

===controller

```java
/**
 * 数据回显 --- 根据id
 * @PathVariable 将路径参数与形参进行绑定
 */
@GetMapping("/{id}")
public Result getInfo(@PathVariable Integer id) {
    log.info("数据回显员工id:{}", id);
    Emp emp = empService.getInfo(id);
    return Result.success(emp);
}
```

===service

```java
/**
 * 根据id查询员工数据
 */
@Override
public Emp getInfo(Integer id) {
    Emp emp = empMapper.getInfo(id);
    return emp;
}
```

===mapper

```java
/**
 * 根据id查询员工的基本信息以及工作经历信息
 */
Emp getInfo(Integer id);
```

（4）示例

![image-20250811142741403](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811142741403.png)

===说明：如果员工有多段工作经历，就不会封装为一个对象，导致异常。

===解决：不使用自动封装，采用手动封装

![image-20250811142902592](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811142902592.png)

![image-20250811144531887](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811144531887.png)

（5）小结

![image-20250811144754018](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811144754018.png)

#### 5.3、修改数据

（1）需求分析

![image-20250811145217986](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811145217986.png)

（2）三层架构

![image-20250811145113849](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811145113849.png)

===controller

```java
/**
 * 修改员工信息
 * @RequestBody : JSON格式的数据要封装到对象中，需要该注解
 */
@PutMapping
public Result update(@RequestBody Emp emp) {
    log.info("修改员工信息:{}", emp);
    empService.update(emp);
    return Result.success();
}
```

===service

```java
/**
 * 修改员工信息
 */
// 因为多次操作了数据库，需要加入事务管理
@Transactional(rollbackFor = {Exception.class})
@Override
public void update(Emp emp) {
    // 1. 根据id修改员工的基本信息
    emp.setUpdateTime(LocalDateTime.now());
    empMapper.updateById(emp);

    // 2. 根据id修改员工的工作经历信息
    // 2.1 先根据员工的id，删除原有的工作经历信息
    empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
    // 2.2 再添加新的工作经历信息
    List<EmpExpr> exprList = emp.getExprList();
    // 说明: 先判断经历集合是否为空，不为空再遍历集合，为每一个工作经历的员工id赋值
    if (!CollectionUtils.isEmpty(exprList)) {
        exprList.forEach(expr -> expr.setEmpId(emp.getId()));
        empExprMapper.insertBatch(exprList);
    }
}
```

===mapper

```java
/**
 * 根据id修改员工的基本信息
 */
void updateById(Emp emp);
```

（3）程序优化---动态SQL

![image-20250811161950759](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811161950759.png)

![image-20250811162516764](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811162516764.png)

### 6、异常处理

#### 6.1、分析

![image-20250811164001553](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811164001553.png)

#### 6.2、全局异常处理器

（1）分析

![image-20250811164227096](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811164227096.png)

（2）代码演示

```java
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result exceptionHandler(Exception e) {
        log.error("出错了~",  e);
        return Result.error("对不起，服务异常，请稍后再试~");
    }

    /**
     * 全局异常处理器: 处理异常的机制的优先级: 先从当前异常出发，如果当前异常不能捕获，则继续抛给上级
     */
    @ExceptionHandler
    public Result handleDuplicateKey(DuplicateKeyException e) {
        /* 字段重复异常 */
        log.error("出错了~",  e);
        // : Duplicate entry '19109091234' for key 'emp.phone'
        String msg = e.getMessage();
        int i = msg.indexOf("Duplicate entry");
        String errMsg = msg.substring(i);
        String[] errArr = errMsg.split(" ");

        return Result.error(errArr[2] + "已存在！");
    }
}
```

（3）效果

![image-20250811171559491](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811171559491.png)

（4）小结

![image-20250811171836517](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811171836517.png)

===说明：@RequestBody 的作用是将数据直接以JSON格式传给前端

## 三、班级管理

### 1、班级列表查询

#### 1.1、原始分页查询

===controller

```java
/**
 * 分页查询
 */
@GetMapping
public Result page(Integer page, Integer pageSize) {
    log.info("分页查询:{},{}", page, pageSize);
    PageResult<Clazz> pageResult = clazzService.page(page, pageSize);
    return Result.success(pageResult);
}
```

===service

```java
/**
 * 分页查询班级信息
 */
@Override
public PageResult<Clazz> page(Integer page, Integer pageSize) {
    // 1. 调用mapper接口，查询总记录数
    Long total = clazzMapper.count();
    // 2. 调用mapper接口，获取数据列表
    Integer start = (page - 1) * pageSize;
    List<Clazz> rows = clazzMapper.list(start, pageSize);
    // 设置课程状态
    for (Clazz clazz : rows) {
        if (LocalDate.now().isAfter(clazz.getEndDate())) {
            clazz.setStatus("已结课");
        } else if (LocalDate.now().isBefore(clazz.getBeginDate())) {
            clazz.setStatus("未开班");
        } else {
            clazz.setStatus("在读中");
        }
    }
    // 3. 封装为 PageResult对象
    return new PageResult<>(total, rows);
}
```

===mapper

```java
/*----------原始分页查询----------------*/
/* 查询总记录数 */
@Select("select count(*) from clazz c left join emp e on c.master_id = e.id")
Long count();

@Select("select c.*, e.name masterName from clazz c left join emp e on c.master_id = e.id limit #{start}, #{pageSize}")
List<Clazz> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
```

#### 1.2、PageHelpaer 分页查询

===controller

```java
/**
 * 分页查询--pagehelper
 */
@GetMapping
public Result page(@Validated ClazzQueryParam cqp) {
    log.info("分页查询:{}", cqp);
    PageResult<Clazz> pageResult = clazzService.page(cqp);
    return Result.success(pageResult);
}
```

===service

```java
/**
 * 分页查询--PageHelper
 */
@Override
public PageResult<Clazz> page(ClazzQueryParam cqp) {
    // 1. 设置查询条件
    PageHelper.startPage(cqp.getPage(), cqp.getPageSize());
    // 2. 执行查询
    List<Clazz> clazzList = clazzMapper.list(cqp);
    // 设置班级状态
    for (Clazz clazz : clazzList) {
        if (LocalDate.now().isBefore(clazz.getBeginDate())) {
            clazz.setStatus("未开课");
        } else if (LocalDate.now().isAfter(clazz.getEndDate())) {
            clazz.setStatus("已结课");
        } else {
            clazz.setStatus("在读中");
        }
    }
    // 3. 解析查询结果，并封装
    Page<Clazz> p = (Page<Clazz>) clazzList;
    return new PageResult<>(p.getTotal(), p.getResult());
}
```

===mapper

```java
/**
 * 分页查询--PageHelper
 */
List<Clazz> list(ClazzQueryParam cqp);
```

===mapper.xml

```xml
<!--分页查询PageHelper-->
<select id="list" resultType="com.tjy.pojo.Clazz">
    select c.*, e.name masterName from clazz c left join emp e on c.master_id = e.id
    <where>
        <if test="name != null and name != ''">
            c.name like concat('%', #{name}, '%')
        </if>
        <if test="begin != null and end != null">
            and begin_date = #{begin} and end_date = #{end}
        </if>
    </where>
</select>
```

### 2、查询所有员工接口

===EmpController

```java
/**
 * 查询全部员工
 */
@GetMapping("/list")
public Result getEmpList() {
    log.info("查询全部员工");
    List<Emp> list = empService.getEmpList();
    return Result.success(list);
}
```

===service

```java
/**
 * 查询全部员工
 */
@Override
public List<Emp> getEmpList() {
    return empMapper.getEmpList();
}
```

===mapper

```java
/**
 * 查询全部员工
 */
List<Emp> getEmpList();
```

===mapper.xml

```xml
<!--查询全部员工-->
<select id="getEmpList" resultType="com.tjy.pojo.Emp">
    select id, username, password, name, gender, job, salary, image, entry_date, dept_id, create_time, update_time from emp
</select>
```

### 3、新增班级信息

===controller

```java
/**
 * 添加班级
 */
@PostMapping
public Result save(@RequestBody Clazz clazz) {
    log.info("添加班级:{}", clazz);
    clazzService.save(clazz);
    return Result.success();
}
```

===service

```java
/**
 * 添加班级
 */
@Override
public void save(Clazz clazz) {
    clazz.setCreateTime(LocalDateTime.now());
    clazz.setUpdateTime(LocalDateTime.now());
    clazzMapper.insert(clazz);
}
```

===mapper

```java
/**
 * 添加班级
 */
@Options(useGeneratedKeys = true, keyProperty = "id")
void insert(Clazz clazz);
```

===mapper.xml

```xml
<!--添加班级-->
<insert id="insert" useGeneratedKeys="true" keyProperty="id">
    insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time)
    values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})
</insert>
```

### 4、根据ID查询班级信息

===controller

```java
/**
 * 根据 ID查询
 */
@GetMapping("/{id}")
public Result getById(@PathVariable Integer id) {
    log.info("根据 ID查询:{}", id);
    Clazz clazz = clazzService.getById(id);
    return Result.success(clazz);
}
```

===service

```java
/**
 * 根据 ID查询
 */
@Override
public Clazz getById(Integer id) {
    return clazzMapper.getById(id);
}
```

===mapper

```java
/**
 * 根据 ID查询
 */
@Select("select * from clazz where id = #{id}")
Clazz getById(Integer id);
```

### 5、修改班级信息

===controller

```java
/**
 * 修改班级
 * 请求的参数为JSON格式，需要加@RequestBody注解
 */
@PutMapping
public Result update(@RequestBody Clazz clazz) {
    log.info("修改班级:{}", clazz);
    clazzService.update(clazz);
    return Result.success();
}
```

===service

```java
/**
 * 修改班级
 */
@Override
public void update(Clazz clazz) {
    clazz.setUpdateTime(LocalDateTime.now());
    clazzMapper.updateById(clazz);
}
```

===mapper

```java
/**
 * 修改班级
 */
void updateById(Clazz clazz);
```

===mapper.xml

```xml
<!--修改班级-->
<update id="updateById">
    update clazz
    <set>
        <if test="name != null and name != ''">name = #{name},</if>
        <if test="room != null and room != ''">room = #{room},</if>
        <if test="beginDate != null">begin_date = #{beginDate},</if>
        <if test="endDate != null">end_date = #{endDate},</if>
        <if test="masterId != null">master_id = #{masterId},</if>
        <if test="subject != null">subject = #{subject},</if>
    </set>
        where id = #{id}
</update>
```

### 6、删除班级信息

===mapper

```java
/**
 * 根据id删除班级
 */
@DeleteMapping("/{id}")
public Result delete(@PathVariable Integer id) {
    log.info("根据id删除班级:{}", id);
    clazzService.deleteById(id);
    return Result.success();
}
```

===service

```java
/**
 * 删除班级
 */
@Override
public void deleteById(Integer id) {
    clazzMapper.deleteById(id);
}
```

===mapper

```java
/**
 * 删除班级
 */
@Delete("delete from clazz where id = #{id}")
void deleteById(Integer id);
```

## 四、学员管理

### 1、查询所有班级

### 2、条件分页查询接口

===controller

```java
/**
 * 分页查询学员信息
 */
@GetMapping
public Result page(StudentQueryParam sqp) {
    log.info("分页查询:{}", sqp);
    PageResult<Student> pageResult = studentService.page(sqp);
    return Result.success(pageResult);
}
```

===service

```java
/**
 * 分页查询学员信息
 */
@Override
public PageResult<Student> page(StudentQueryParam sqp) {
    // 1. 设置查询条件
    PageHelper.startPage(sqp.getPage(), sqp.getPageSize());
    // 2. 执行查询
    List<Student> studentList = studentMapper.page(sqp);
    Page<Student> p = (Page<Student>) studentList;
    return new PageResult<>(p.getTotal(), p.getResult());
}
```

===mapper

```java
/**
 * 分页查询学员信息
 */
List<Student> page(StudentQueryParam sqp);
```

===mapper.xml

```java
<!--分页查询学员信息-->
<select id="page" resultType="com.tjy.pojo.Student">
    select s.*, c.name clazzName from student s left join clazz c on c.id = s.clazz_id
    <where>
        <if test="name != null and name != ''">
            and s.name like concat('%', #{name}, '%')
        </if>
        <if test="degree != null">
            and s.degree = #{degree}
        </if>
        <if test="classId != null">
            and s.class_id = #{classId}
        </if>
    </where>
</select>
```

### 3、新增学生信息

===controller

```java
/**
 * 添加学员
 */
@PostMapping
public Result save(@RequestBody Student student) {
    log.info("添加学员:{}", student);
    studentService.save(student);
    return Result.success();
}
```

===service

```java
/**
     * 添加学员
     */
    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }
```

===mapper

```java
/**
 * 添加学员
 */
@Options(useGeneratedKeys = true, keyProperty = "id")
void insert(Student student);
```

===mapper.xml

```xml
<!--添加学员-->
<insert id="insert" useGeneratedKeys="true" keyProperty="id">
    insert into student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, create_Time, update_time)
    values (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{createTime}, #{updateTime})
</insert>
```

### 4、根据ID查询学生信息

===controller

```java
/**
 * 根据ID查询学员
 */
@GetMapping("/{id}")
public Result getById(@PathVariable Integer id) {
    log.info("根据ID查询:{}", id);
    Student student = studentService.getById(id);
    return Result.success(student);
}
```

===service

```java
@Override
public Student getById(Integer id) {
    return studentMapper.getById(id);
}
```

===mapper

```java
/**
 * 根据ID查询学员
 */
Student getById(Integer id);
```

===mapper.xml

```xml
<!--根据ID查询学员信息-->
<select id="getById" resultType="com.tjy.pojo.Student">
    select s.*, c.name clazzName from student s left join clazz c on s.clazz_id = c.id where s.id = #{id}
</select>
```

### 5、修改学生信息

===controller

```java
/**
 * 修改学员
 */
@PutMapping
public Result update(@RequestBody Student student) {
    log.info("修改学员:{}", student);
    studentService.update(student);
    return Result.success();
}
```

===service

```java
/**
 * 修改学员信息
 */
@Override
public void update(Student student) {
    student.setUpdateTime(LocalDateTime.now());
    studentMapper.update(student);
}
```

===mapper

```java
/**
 * 修改学员信息
 */
void update(Student student);
```

===mapper.xml

```xml
<!--修改学员信息-->
<update id="update">
    update student
    <set>
        <if test="name != null and name != ''">name = #{name},</if>
        <if test="no != null and no != ''">no = #{no},</if>
        <if test="gender != null">gender = #{gender},</if>
        <if test="phone != null and phone != ''">phone = #{phone},</if>
        <if test="degree != null">degree = #{degree},</if>
        <if test="idCard != null and idCard != ''">id_card = #{idCard},</if>
        <if test="isCollege != null and isCollege != ''">is_college = #{isCollege},</if>
        <if test="address != null and address != ''">address = #{address},</if>
        <if test="graduationDate != null">graduation_date = #{graduationDate},</if>
        <if test="violationCount != null">violation_count = #{violationCount},</if>
        <if test="violationScore != null">violation_score = #{violationScore},</if>
        <if test="clazzId != null">clazz_id = #{clazzId}</if>
    </set>
    where id = #{id}
</update>
```

### 6、删除学生信息

===controller

```java
/**
 * 批量删除学员
 */
@DeleteMapping("/{ids}")
public Result dalete(@PathVariable List<Integer> ids) {
    log.info("批量删除:{}", ids);
    studentService.deleteById(ids);
    return Result.success();
}
```

===service

```java
/**
 * 删除学员
 */
@Override
public void deleteById(List<Integer> ids) {
    studentMapper.deleteById(ids);
}
```

===mapper

```java
/**
 * 根据ID删除学员
 */
void deleteById(@Param("ids") List<Integer> ids);
```

===mapper.xml

```xml
<!--根据ID删除学员-->
<delete id="deleteById">
    delete from student where id in
    <foreach collection="ids" item="id" separator="," open="(" close=")">
        #{id}
    </foreach>
</delete>
```

### 7、违纪处理

===controller

```java
/**
 * 违纪处理
 */
@PutMapping("/violation/{id}/{score}")
public Result handleViolation(@PathVariable("id") Integer id, @PathVariable("score") Short score) {
    log.info("违纪处理:{}", id);
    studentService.handleViolation(id, score);
    return Result.success();
}
```

===service

```java
/**
 * 违纪处理
 */
@Transactional(rollbackFor = {Exception.class})
@Override
public void handleViolation(Integer id, Short score) {
    // 1. 通过id获取学员信息
    Student student = studentMapper.getById(id);
    if (student == null) {
        throw new StudentNotFoundException("ID为:" + id + "的学员不存在");
    }

    // 2. 计算新的违纪分数和次数
    short newScore = (short) (student.getViolationScore() + score);
    short newCount = (short) (student.getViolationCount() + 1);

    // 3. 通过id直接修改学员的违纪分数和次数
    studentMapper.handleViolation(id, newCount, newScore);
}
```

===mapper

```java
/**
 * 通过id修改学员的违纪分数
 */
void handleViolation(@Param("id") Integer id, @Param("count") Short count, @Param("score") Short score);
```

===mapper.xml

```xml
<!--通过id修改学员的违纪分数-->
<update id="handleViolation">
    update student set violation_count = #{count} ,violation_score = #{score} where id = #{id}
</update>
```

## 五、报表管理

### 1、员工信息统计

#### 1.1、职位统计

（1）效果演示

<img src="D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811172146655.png" alt="image-20250811172146655" style="zoom:67%;" />

（2）需求分析

![image-20250811183339900](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811183339900.png)

![image-20250811183429165](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811183429165.png)

（3）准备工作

![image-20250811183530537](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811183530537.png)

（4）SQL

![image-20250811185353311](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811185353311.png)

（5）三层架构

![image-20250811185321197](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250811185321197.png)

===controller

```java
/**
 * 统计各个职位的员工人数
 */
@GetMapping("/empJobData")
public Result getEmpJobData() {
    log.info("统计各个职位的员工人数");
    JobOption jobOption =  reportService.getEmpJobData();
    return Result.success(jobOption);
}
```

===service

```java
@Override
public JobOption getEmpJobData() {
    // 1. 获取返回的数据
    List<Map<String, Object>> list = empMapper.countJobData();
    // 2. 将数据进行组装并返回
    List<Object> jobList = list.stream().map(dataMap -> dataMap.get("position")).toList();
    List<Object> dataList = list.stream().map(dataMap -> dataMap.get("count")).toList();
    return new JobOption(jobList, dataList);
}
```

===mapper

```java
/**
 * 获取员工职位信息
 */
@MapKey("position")
List<Map<String, Object>> countJobData();
```

===mapper.xml

```xml
<!--获取员工职位信息-->
<select id="countJobData" resultType="java.util.Map">
    select
        (case when job = 1 then '班主任'
              when job = 2 then '讲师'
              when job = 3 then '学工主管'
              when job = 4 then '教研主管'
              when job = 5 then '咨询师'
              else '其他' end) position,
        count(*) count
    from emp group by job order by count;
</select>
```

#### 1.2、性别统计

（1）分析

![image-20250812094315307](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250812094315307.png)

![image-20250812094346729](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250812094346729.png)

（2）SQL语句

```sql
-- 统计员工性别信息
-- if(条件, true_value, false_value)
select
    (if(gender = 1, '男性员工', '女性员工')) as name,
    count(*) value
from emp group by gender;
```

（3）三层架构

===controller

```java
/**
 * 统计员工性别信息
 */
@GetMapping("/empGenderData")
public Result getEmpGenderData() {
    log.info("统计员工性别信息");
    List<Map<String, Object>> genderList = reportService.getEmpGenderData();
    return Result.success(genderList);
}
```

===service

```java
/**
 * 统计员工性别信息
 */
@Override
public List<Map<String, Object>> getEmpGenderData() {
    List<Map<String, Object>> genderList = empMapper.countGenderData();
    return genderList;
}
```

===mapper

```java
/**
 * 统计员工性别信息
 */
@MapKey("name")
List<Map<String, Object>> countGenderData();
```

===mapper.xml

```xml
<!--统计员工性别信息-->
<select id="countGenderData" resultType="java.util.Map">
    select
        (if(gender = 1, '男性员工', '女性员工')) as name,
        count(*) value
    from emp group by gender;
</select>
```

（4）小结

![image-20250812101226574](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250812101226574.png)

### 2、学员信息统计

#### 2.1、统计学生学历信息

===controller

```java
/**
 * 统计学生学历信息
 */
@GetMapping("/studentDegreeData")
public Result getStudentDegree() {
    log.info("统计学生学历信息");
    List<Map<String, Object>> degreeList = reportService.getStudentDegree();
    return Result.success(degreeList);
}
```

===service

```java
/**
 * 统计学生学历信息
 */
@Override
public List<Map<String, Object>> getStudentDegree() {
    List<Map<String, Object>> degreeList = studentMapper.countStudentDegree();
    return degreeList;
}
```

===mapper

```java
/**
 * 统计学员学历信息
 */
@MapKey("name")
List<Map<String, Object>> countStudentDegree();
```

===mapper.xml

```xml
<!--统计学员学历信息-->
<select id="countStudentDegree" resultType="java.util.Map">
    select
        (case when degree = 1 then '初中'
              when degree = 2 then '高中'
              when degree = 3 then '大专'
              when degree = 4 then '本科'
              when degree = 5 then '硕士'
              when degree = 6 then '博士'
              else '' end) as name,
        count(*) as value
    from student group by degree;
</select>
```

#### 2.2、统计各个班级的学员数量

===pojo

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuNumberOption {
    private List clazzList;
    private List dataList;
}
```

===controller

```java
/**
 * 统计各个班级的学员数量
 */
@GetMapping("/studentCountData")
public Result getStudentNumber() {
    log.info("统计各个班级的学员数量");
    StuNumberOption sno = reportService.getStudentNumber();
    return Result.success(sno);
}
```

===service

```java
/**
 * 统计各个班级的学员数量
 */
@Override
public StuNumberOption getStudentNumber() {
    List<Map<String, Object>> list = studentMapper.getStuNumber();
    List<Object> clazzList = list.stream().map(msgList -> msgList.get("clazzName")).toList();
    List<Object> dataList = list.stream().map(msgList -> msgList.get("stuCount")).toList();
    return new StuNumberOption(clazzList, dataList);
}
```

===mapper

```java
/**
 * 统计各个班级的学员数量
 */
@MapKey("clazzName")
List<Map<String, Object>> getStuNumber();
```

===mapper.xml

```xml
<!--统计各个班级的学员数量-->
<select id="getStuNumber" resultType="java.util.Map">
    select c.name clazzName, a.stu_count stuCount
    from clazz c, (select clazz_id, count(*) stu_count from student group by clazz_id) a
    where c.id = a.clazz_id
</select>
```

## 六、登录认证

### 1、登录功能

#### 1.1、需求分析

![image-20250813153010354](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813153010354.png)

![image-20250813153739564](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813153739564.png)

![image-20250813153759908](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813153759908.png)

（2）三层架构

![image-20250813153904957](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813153904957.png)

===controller

```java
/**
 * 登录功能
 */
@PostMapping("/login")
public Result login(@RequestBody Emp emp) {
    log.info("登录:{}", emp);
    LoginInfo info =  empService.login(emp);
    // 判断返回的信息是否为空
    if (info != null) {
        return Result.success(info);
    }
    return Result.error("用户名或密码错误");
}
```

===service

```java
/**
 * 登录
 */
@Override
public LoginInfo login(Emp emp) {
    Emp e = empMapper.selectByUsernameAndPassword(emp);
    if (e != null) {
        log.info("登录成功:{}", e);
        return new LoginInfo(e.getId(), e.getUsername(), e.getName(), "");
    }
    return null;
}
```

===mapper

```java
/**
 * 登录
 */
@Select("select * from emp where username = #{username} and password = #{password}")
Emp selectByUsernameAndPassword(Emp emp);
```

===问题

![image-20250813160720903](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813160720903.png)

===解决思路

![image-20250813184706226](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813184706226.png)

### 2、登录校验

#### 2.1、会话技术

##### 2.1.1、会话介绍

​		用户打开浏览器，访问web服务器的资源，会话建立，直到有一方断开连接，会话结束。在一次会话中可以包含多次请求和响应。

![image-20250813185217108](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813185217108.png)

##### 2.1.2、会话跟踪

​		一种**维护**浏览器状态的方法，服务器端需要识别多次请求是否来自于同一浏览器，以便在同一次会话的多次请求间【**共享数据**】。

![image-20250813185647059](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813185647059.png)

===说明：登录时，获取验证码发起请求，并将结果保存下来，点击登录后，将输入的数据于保存的结果进行比对，这也是一次请求。

##### 2.1.3、会话跟踪方案

（1）客户端会话跟踪技术：Cookie

![image-20250813191606670](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813191606670.png)

===小结

![image-20250813192057896](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813192057896.png)

（2）服务端会话跟踪技术：Session

![image-20250813193057153](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813193057153.png)

===说明：服务器集群情况下，每一次负载均衡服务器都会计算当前请求发给哪个服务器，第一次可能发给1号服务器并且用户登录。等下一次用户登录时，负载均衡服务器再次计算发送给哪个服务器，如果和第一次发送的服务器不同，则用户需要重新登录。

===小结

![image-20250813193412196](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813193412196.png)

（3）令牌技术（推荐）

![image-20250813193637575](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813193637575.png)

#### 2.2、JWT令牌

##### 2.2.1、介绍

全称：JSON Web Token （https://jwt.io/）

定义了一种简洁的、自包含的格式，用于在通信双方以json数据格式安全地传输数据。

组成：

- 第一部分：header（头），记录令牌类型、签名算法等。例如:{"alg":"HS256", "type":"JWT"}
- 第二部分：Payload（有效载荷），携带一些自定义信息、默认信息等。例如:{"id":"1", "username":"Tom"}
- 第三部分：Signature（签名），防止Tokent被篡改、确保安全性。将header、payloader融入，并加入指定密钥，通过指定签名算法计算而来。

![image-20250813194547015](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813194547015.png)

===补充：等号（=）在Base64编码中相当于补位符号，当出现符号不够时就可以使用等号进行补位。

![image-20250813194825766](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813194825766.png)

===说明：签名（第三部分）并不是Base64编码，而是融入了前两个部分再加上自己指定的密钥。

##### 2.2.2、JWT令牌的构建

![image-20250813195205759](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813195205759.png)

```xml
<!--JWT依赖-->
<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>
```

===说明：

java.lang.ClassNotFoundException: javax.xml.bind.DatatypeConverter

该异常说明在Java9及以上版本该依赖无法使用，还需要加入以下依赖

```xml
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
    <version>2.3.1</version>
</dependency>
```

===代码演示

```java
/**
 * 生成JWT令牌
 */
@Test
public void testGenerateJwt() {
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("id", 1);
    dataMap.put("username", "tjy");
    String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "dGFuZ2ppYW5neXVhbg==") // 指定加密算法，密钥(Base64)
            .addClaims(dataMap) // 添加自定义数据
            .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置过期时间(当前时间往后一个小时)
            .compact(); // 生成JWT令牌
    System.out.println(jwt);
}
```

##### 2.2.3、JWT令牌的解析

![image-20250813195340253](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813195340253.png)

===代码演示

```java
/**
     * 解析JWT令牌
     */
    @Test
    public void testParseJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJ0ankiLCJleHAiOjE3NTUwOTA3ODF9.i095w0TzwToVAlqO8gQLUXOs3TfqqsraHc77z78IMvw";
        Claims claims = Jwts.parser().setSigningKey("dGFuZ2ppYW5neXVhbg==") // 指定密钥(Base64)
                .parseClaimsJws(token) // 解析JWT令牌
                .getBody(); // 获取自定义数据
        System.out.println(claims);
    }
```

===小结

![image-20250813214919225](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250813214919225.png)

##### 2.2.4、案例

![image-20250814090725909](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814090725909.png)

```java
public class JwtUtils {
    private static final String signKey = "TE9HSU5TVUNFU1M=";
    private static final Long expire = 43200000L; // 12小时

    /**
     * 生成JWT令牌
     */
    public static String generateJwt(Map<String,Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
```

```JAVA
/**
 * 登录
 */
@Override
public LoginInfo login(Emp emp) {
    // 1. 调用 mapper接口，根据用户名和密码查询员工
    Emp e = empMapper.selectByUsernameAndPassword(emp);
    // 2. 根据查询的结果进行判断，如果不为空，则返回登录信息
    if (e != null) {
        log.info("登录成功:{}", e);
        // 2.1 生成JWT令牌
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", e.getId());
        dataMap.put("username", e.getUsername());

        String token = JwtUtils.generateJwt(dataMap);
        return new LoginInfo(e.getId(), e.getUsername(), e.getName(), token);
    }
    // 3. 返回null
    return null;
}
```

![image-20250814093403788](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814093403788.png)

===补充：用户登录成功后，系统会自动下发JWT令牌，然后在后续的每次请求中，都需要在请求头header中携带到服务端，请求头的名称为 `token` ，值为 登录时下发的JWT令牌。 如果检测到用户未登录，则直接响应 **401** 状态码 。

#### 2.3、过滤器 Filter

##### 2.3.1、介绍

- 概念：Filter过滤器，是JavaWeb三大组件(Servlet、Filter、Listener)之一。

- 过滤器可以把对资源的请求**拦截**下来，从而实现一些特殊的功能。
- 过滤器一般完成一些**通用**的操作，比如：登录校验、同一编码处理、敏感字符处理。

##### 2.3.2、快速入门

![image-20250814094440308](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814094440308.png)

===代码演示

```java
@Slf4j
@WebFilter(urlPatterns = "/*") // 拦截所有请求
public class DemoFilter implements Filter {

    // 初始化过滤器，web服务器启动的时候执行，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化过滤器...");
    }

    // 过滤器核心方法，拦截到请求之后执行，每次请求都会执行
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到了请求...");
        // 放行，让请求继续往下执行，如果不写，请求会被拦截
        filterChain.doFilter(servletRequest, servletResponse);
    }

    // 销毁过滤器，web服务器关闭的时候执行，只执行一次
    @Override
    public void destroy() {
        log.info("destroy 销毁过滤器...");
    }
}
```

===小结

![image-20250814100121659](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814100121659.png)

##### 2.3.3、令牌校验 Filter

![image-20250814100446369](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814100446369.png)

（1）校验流程

![image-20250814112314894](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814112314894.png)

（2）代码演示

```java
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 前提: 进行强转
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 1. 获取请求路径
        String requestURI = request.getRequestURI(); // 不包含前面的 http://localhost:8080

        // 2. 判断是否是登录请求，如果路径中包含 /login, 说明是登录操作，放行
        if (requestURI.contains("/login")) {
            log.info("登录请求, 放行");
            filterChain.doFilter(request, response);
            return; // 确保在放行后不会继续执行后续代码
        }

        // 3. 获取请求头中的令牌(token)
        String token = request.getHeader("token");

        // 4. 判断token是否存在，如果不存在，说明用户未登录，返回错误信息(响应401状态码)
        if (token == null || token.isEmpty()) {
            log.info("令牌为空，响应401状态码");
            response.setStatus(401);
            return;
        }

        // 5. 如果token存在，校验令牌，如果校验失败，返回错误信息(响应401状态码)
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("令牌非法，响应401状态码");
            response.setStatus(401);
            return;
        }

        // 6. 校验通过，放行
        log.info("令牌合法，放行");
        filterChain.doFilter(request, response);

    }
}
```

##### 2.3.4、详解

（1）执行流程

![image-20250814112828211](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814112828211.png)

![image-20250814113110762](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814113110762.png)

（2）拦截路径

![image-20250814113433239](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814113433239.png)

（3）过滤器链

![image-20250814113724808](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814113724808.png)

===小结

![image-20250814114124991](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814114124991.png)

#### 2.4、拦截器 Interceptor

##### 2.4.1、介绍

- 概念：是一种动态拦截方法调用的机制，类似于过滤器。Spring框架中提供的，主要用来动态拦截控制器方法的执行。
- 作用：拦截请求，在指定的方法调用前后，根据业务需要执行预先设定的代码。

![image-20250814140630839](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814140630839.png)

##### 2.4.2、快速入门

（1）准备

![image-20250814140853997](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814140853997.png)

![image-20250814141016642](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814141016642.png)

（2）代码演示

```java
/**
 * @version 1.0
 * @date 2025/8/14 14:11
 * msg: 拦截器
 */
@Slf4j
@Component // 因为HandlerInterceptor是Spring中的接口，所以要添加到spring容器中
public class DemoInterceptor implements HandlerInterceptor {

    // 目标资源方法执行之前执行 - 返回值为true放行，为false拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle ...");
        return true;
    }

    // 目标资源方法执行之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle ...");
    }

    // 试图渲染之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion ...");
    }
}
```

```java
/**
 * @version 1.0
 * @date 2025/8/14 14:18
 * msg: 配置类 --- 用来添加拦截器
 */
@SuppressWarnings("all")
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 注入DemoInterceptor
     */
    @Autowired
    private DemoInterceptor demoInterceptor;

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor).addPathPatterns("/**"); // 拦截所有路径
    }
}
```

（3）小结

![image-20250814142750045](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814142750045.png)

##### 2.4.3、令牌校验

```java
/**
 * @version 1.0
 * @date 2025/8/14 14:29
 * msg: 定义令牌校验拦截器
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 获取资源访问路径
        String requestURI = request.getRequestURI();
        // 2. 判断是否包含 /login true -> 放行; false -> 拦截
        if (requestURI.contains("/login")) {
            log.info("放行");
            return true;
        }
        // 3. 获取JWT令牌
        String token = request.getHeader("token");
        // 4. 判断令牌是否存在，如果存在，则通过，否则拦截
        if (token == null || token.isEmpty()) {
            log.info("令牌为空，响应401");
            response.setStatus(401);
            return false;
        }
        // 5. 解析令牌，如果解析成功，则通过，否则拦截
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("用户未登录，请先登录");
            response.setStatus(401);
            return false;
        }
        // 6. 放行
        log.info("令牌合法，放行");
        return true;
    }
}
```

```java
/**
 * @version 1.0
 * @date 2025/8/14 14:39
 * @msg 令牌拦截器配置类
 */
@Slf4j
@SuppressWarnings("all")
@Configuration
public class TokenConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**");
    }
}
```

##### 2.4.4、详解

（1）拦截路径

![image-20250814145716548](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814145716548.png)

（2）执行流程

![image-20250814150218461](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814150218461.png)

（3）Filter 和 Interceptor 的区别

- 接口规范不同：过滤器需要实现Filter接口，而拦截器需要实现HandlerInterceptor接口；
- 拦截范围不同：过滤器 Filter会拦截所有的资源，而 Interceptor只会拦截 Spring环境中的资源。

（4）小结

![image-20250814150848897](D:\软件工程\JavaWeb + AI\03-后端Web实战\assets\image-20250814150848897.png)