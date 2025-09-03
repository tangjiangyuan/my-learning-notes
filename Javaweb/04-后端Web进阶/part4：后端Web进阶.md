# part4：后端Web进阶

## 一、AOP

### 1、介绍

#### 1.1、AOP

​		Aspect Oriented Programming（面向切面编程、面向方面编程），可简单理解为就是面向特定方法编程。

#### 1.2、场景

​		案例中部分业务方法运行较慢，定位执行耗时较长的接口，此时需要统计每一个业务方法的执行耗时。

![image-20250814151526395](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814151526395.png)

#### 1.3、优势

- 减少重复代码
- 代码无侵入（源代码）
- 提高开发效率
- 维护方便

===补充：AOP是一种思想，而**在Spring框架中对这种思想进行的实现**，所以我们要学习Spring AOP。

### 2、AOP 基础

#### 2.1、快速入门

（1）需求

![image-20250814152429150](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814152429150.png)

（2）步骤

![image-20250814152704952](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814152704952.png)

```xml
<!--AOP依赖-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

```java
@Slf4j
@Aspect // 表示当前类是一个切面类
@Component
public class RecordTimeAspect {

    @Around("execution(* com.itheima.service.impl.*.*(..))") // 范围为 service.impl包下的所有的类和方法
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        // 1. 记录方法执行的开始时间
        long begin = System.currentTimeMillis();

        // 2. 执行原方法
        Object object = pjp.proceed();

        // 3. 记录方法执行的结束时间，并计算耗时
        long end = System.currentTimeMillis();
        log.info("方法:{},耗时:{}ms", pjp.getSignature(), end - begin);

        return object;
    }
}
```

（3）小结

![image-20250814165054005](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814165054005.png)

#### 2.2、核心概念

##### 2.2.1、连接点

​		JoinPoint，可以被AOP控制的方法（暗含方法执行时的相关信息）

![image-20250814165927173](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814165927173.png)

##### 2.2.2、通知

​		Advice，指哪些重复的逻辑，也就是共性功能（最终体现为一个方法）

![image-20250814170023854](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814170023854.png)

##### 2.2.3、切入点

​		PointCut，匹配连接点的条件，通知仅会在切入点方法执行时被应用

![image-20250814170210717](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814170210717.png)

===补充：切入点一定是连接点，而连接点不一定是切入点（因为连接点的范围大于切入点，包含关系）

##### 2.2.4、切面

​		Aspect，描述通知与切入点的对应关系（通知+切入点）

![image-20250814170607223](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814170607223.png)

##### 2.2.5、目标对象

​		Target，通知所引用的对象

![image-20250814170750761](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814170750761.png)

2.3、AOP执行流程

![image-20250814171110919](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814171110919.png)

===说明：实际上是**目标对象**将自己的方法**交给**了**动态代理对象**，controller层实际注入的是代理对象，controller中执行的方法实际上也是代理对象中的方法。

===补充：AOP的底层实际就是**动态代理技术**。

### 3、AOP 进阶

#### 3.1、通知类型

![image-20250814172943485](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814172943485.png)

```java
@Slf4j
@Aspect
@Component
public class MyAspect01 {

    // 前置通知 - 目标方法执行之前执行
    @Before("execution(* com.itheima.service.impl.*.*(..))")
    public void before() {
        log.info("before...");
    }

    // 环绕通知 - 目标方法执行之前、之后都会执行
    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around...before...");
        Object object =  pjp.proceed();
        log.info("around...after");
        return object;
    }

    // 后置通知 - 目标方法执行之后执行; 无论是否出现异常，都会执行，类似finally
    @After("execution(* com.itheima.service.impl.*.*(..))")
    public void after() {
        log.info("after...");
        System.out.println(10 / 0);
        log.info("after...exception...");
    }

    // 返回后通知 - 目标方法执行之后执行; 如果出现异常 不会 执行
    @AfterReturning("execution(* com.itheima.service.impl.*.*(..))")
    public void afterReturning() {
        log.info("afterReturning...");
    }

    // 抛出异常后通知 - 目标方法执行之后执行; 只有出现异常才会执行
    @AfterThrowing("execution(* com.itheima.service.impl.*.*(..))")
    public void afterThrowing() {
        log.info("afterThrowing...");
    }
}
```

#### ===扩展：@PointCut

![image-20250814185250601](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814185250601.png)

===优化

```java
@Slf4j
@Aspect
@Component
public class MyAspect01 {

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pc(){}

    // 前置通知 - 目标方法执行之前执行
    @Before("pc()")
    public void before() {
        log.info("before...");
    }

    // 环绕通知 - 目标方法执行之前、之后都会执行
    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around...before...");
        Object object =  pjp.proceed();
        log.info("around...after");
        return object;
    }

    // 后置通知 - 目标方法执行之后执行; 无论是否出现异常，都会执行
    @After("pc()")
    public void after() {
        log.info("after...");
        log.info("after...exception...");
    }

    // 返回后通知 - 目标方法执行之后执行; 如果出现异常 不会 执行
    @AfterReturning("pc()")
    public void afterReturning() {
        log.info("afterReturning...");
    }

    // 抛出异常后通知 - 目标方法执行之后执行; 只有出现异常才会执行
    @AfterThrowing("pc()")
    public void afterThrowing() {
        log.info("afterThrowing...");
    }
}
```

===小结

![image-20250814185935507](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814185935507.png)

#### 3.2、通知顺序

![image-20250814191258683](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814191258683.png)



#### 3.3、切入点表达式

##### 3.3.1、介绍

![image-20250814191854800](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814191854800.png)

##### 3.3.2、形式一：execution

![image-20250814192258226](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814192258226.png)

===补充：根据业务需要，可以使用 且(&&)、或(||)、非(!)来组合比较复杂的切入点表达式。

===小结

![image-20250814194145716](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814194145716.png)

##### 3.3.3、形式二：@annotation

![image-20250814194245334](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814194245334.png)

===步骤

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogOperation {
}
```

```java
@Slf4j
@Order(7)
@Aspect
@Component
public class MyAspect05 {
    @Before("@annotation(com.itheima.anno.LogOperation)")
    public void before(){
        log.info("MyAspect5 -> before ...");
    }
}
```

```java
@LogOperation
@Override
public void delete(Integer id) {
    deptMapper.delete(id);
}
```

===说明：在需要的方法上加入注解即可。

#### 3.4、连接点

![image-20250814195259389](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814195259389.png)

![image-20250814195325264](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250814195325264.png)

### 4、AOP 案例

![image-20250815095707015](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815095707015.png)

#### 4.1、代码演示

```java
@Slf4j
@SuppressWarnings("all")
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    /**
     * 拦截 controller 包下所有打了 @Log 的方法
     */
    @Around("@annotation(com.tjy.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        // 目标类、方法
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        // 方法参数
        String methodParams = JSON.toJSONString(Arrays.asList(joinPoint.getArgs()));

        // 开始时间
        LocalDateTime operateTime = LocalDateTime.now();

        long start = System.currentTimeMillis();

        // 执行原方法
        Object result = joinPoint.proceed();

        // 耗时
        long costTime = System.currentTimeMillis() - start;

        // 返回值
        String returnValue = JSON.toJSONString(result);

        // 封装实体
        OperateLog opLog = new OperateLog();
        opLog.setOperateEmpId(getCurrentUserId());
        opLog.setOperateTime(operateTime);
        opLog.setClassName(className);
        opLog.setMethodName(methodName);
        opLog.setMethodParams(methodParams.length() > 2000 ? methodParams.substring(0, 2000) : methodParams);
        opLog.setReturnValue(returnValue.length() > 2000 ? returnValue.substring(0, 2000) : returnValue);
        opLog.setCostTime(costTime);

        // 入库
        log.info("记录操作日志: {}", opLog);
        operateLogMapper.insert(opLog);

        return result;
    }

    /**
     * 获取当前登录用户的id
     */
    public Integer getCurrentUserId() {
        return 1;
    }
}
```

#### 4.2、问题：如何从令牌中获取当前登录用户的id

![image-20250815111957558](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815111957558.png)

![image-20250815112018083](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815112018083.png)

#### 4.3、ThreadLocal

![image-20250815112229902](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815112229902.png)

- 单个线程演示

```java
public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("Main Message...");

        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("Thread Message...");
                System.out.println(Thread.currentThread().getName() + ":" + local.get());
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + ":" + local.get());

        local.remove();
        System.out.println(Thread.currentThread().getName() + ":" + local.get());
    }
}
```

![image-20250815112819184](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815112819184.png)

- 多个线程演示

```java
public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("Main Message...");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + local.get());
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + ":" + local.get());

        local.remove();
        System.out.println(Thread.currentThread().getName() + ":" + local.get());
    }
}
```

![image-20250815113440526](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815113440526.png)

===说明：子线程无法获取主线程中的数据

```java
public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("Main Message...");

        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("Thread Message...");
                System.out.println(Thread.currentThread().getName() + ":" + local.get());
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + ":" + local.get());

        local.remove();
        System.out.println(Thread.currentThread().getName() + ":" + local.get());
    }
}
```

![image-20250815113548333](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815113548333.png)

===说明：线程之间是相互隔离的。

![image-20250815150110398](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815150110398.png)

===说明：在一次请求响应中，tomcat服务器会从线程池中，取出一个线程来执行请求响应。

![image-20250815150450112](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815150450112.png)

![image-20250815150532646](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815150532646.png)

===优化

===ThreadHolder

```java
/**
 * @version 1.0
 * @date 2025/8/15 15:07
 * msg: ThreadLocal工具类
 */
public class CurrentHolder {

    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();

    public static void setCurrentID(Integer employeeId) {
        CURRENT_LOCAL.set(employeeId);
    }

    public static Integer getCurrentId() {
        return CURRENT_LOCAL.get();
    }

    public static void remove() {
        CURRENT_LOCAL.remove();
    }
}
```

===TokenFilter

```java
@Slf4j
@WebFilter(urlPatterns = "/*")
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
            Claims claims = JwtUtils.parseJWT(token);
            // 获取员工 ID
            Integer empId = Integer.valueOf(claims.get("id").toString());
            // 存入 ThreadLocal 中
            CurrentHolder.setCurrentID(empId);
            log.info("登录员工的ID: {}, 已存入ThreadLocal。", empId);
        } catch (Exception e) {
            log.info("令牌非法，响应401状态码");
            response.setStatus(401);
            return;
        }

        // 6. 校验通过，放行
        log.info("令牌合法，放行");
        filterChain.doFilter(request, response);

        // 7. 移除 ThreadLocal 中的数据，避免内存泄漏
        CurrentHolder.remove();
    }
}
```

```java
@Slf4j
@SuppressWarnings("all")
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    /**
     * 拦截 controller 包下所有加了 @Log 的方法
     */
    @Around("@annotation(com.tjy.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        // 目标类、方法
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        // 方法参数
        String methodParams = JSON.toJSONString(Arrays.asList(joinPoint.getArgs()));

        // 开始时间
        LocalDateTime operateTime = LocalDateTime.now();

        long start = System.currentTimeMillis();

        // 执行原方法
        Object result = joinPoint.proceed();

        // 耗时
        long costTime = System.currentTimeMillis() - start;

        // 返回值
        String returnValue = JSON.toJSONString(result);

        // 封装实体
        OperateLog opLog = new OperateLog();
        opLog.setOperateEmpId(getCurrentUserId());
        opLog.setOperateTime(operateTime);
        opLog.setClassName(className);
        opLog.setMethodName(methodName);
        opLog.setMethodParams(methodParams.length() > 2000 ? methodParams.substring(0, 2000) : methodParams);
        opLog.setReturnValue(returnValue.length() > 2000 ? returnValue.substring(0, 2000) : returnValue);
        opLog.setCostTime(costTime);

        // 入库
        log.info("记录操作日志: {}", opLog);
        operateLogMapper.insert(opLog);

        return result;
    }

    /**
     * 获取当前登录用户的id
     */
    public Integer getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}
```

===小结

![image-20250815152646349](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815152646349.png)

## 二、SpringBoot原理

### 1、配置优先级

#### 1.1、三种格式

![image-20250815162641018](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815162641018.png)

#### 1.2、优先级

​		.properties ->  .yml -> .yaml

===补充：虽然springboot支持多种格式配置文件，但是在项目开发时，推荐统一使用一种格式的配置（**yml是主流**）。

#### 1.3、另外两种配置方式

![image-20250815164101985](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815164101985.png)

===优先级：

​		命令行参数 -> Java系统属性 -> .properties -> .yml -> .yaml

![image-20250815164547236](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815164547236.png)

===补充：SpringBoot项目进行打包时，需要引入插件 spring-boot-maven-plugin (基于官网骨架创建项目，会自动添加该插件)

1.4、演示

![image-20250815165444705](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815165444705.png)

![image-20250815165645391](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815165645391.png)

![image-20250815165755356](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815165755356.png)

### 2、Bean 管理

#### 2.1、Bean的作用域

（1）类型

![image-20250815170110199](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815170110199.png)

（2）singleton

```java
/**
 * @version 1.0
 * @date 2025/8/15 17:07
 * msg: 测试Spring Bean作用域 - singleton
 */
@SpringBootTest
public class ScopeTest {

    @Autowired // 获取IOC容器
    private ApplicationContext applicationContext;

    @Test
    public void testScope() {
        for (int i = 0; i < 1000; i++) {
            Object deptController = applicationContext.getBean("deptController");
            System.out.println(deptController);
        }
    }
}
```

![image-20250815171620886](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815171620886.png)

===补充：@Lazy注解可将bean的创建延迟到第一次调用的时候

![image-20250815171646113](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815171646113.png)

![image-20250815172113150](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815172113150.png)

（3）prototype

![image-20250815172027500](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815172027500.png)

![image-20250815172040724](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815172040724.png)

（4）singleton 和 prototype 的使用场景

![image-20250815172732170](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815172732170.png)

#### ===面试题

![image-20250815172941786](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815172941786.png)

#### 2.2、第三方Bean

（1）方法一（不推荐）

![image-20250815204022208](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815204022208.png)

===补充

​		如果第三方bean需要依赖其它bean对象，直接在bean定义方法中设置形参即可，容器会根据就类型自动装配。

​		通过@Bean注解的name或value属性可以声明bean的名称，如果不指定，默认bean的名称就是方法名。

![image-20250815205102948](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815205102948.png)

（2）方法二（推荐）

![image-20250815205253778](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815205253778.png)

![image-20250815205336562](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815205336562.png)

（3）小结

![image-20250815205451166](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250815205451166.png)

### 3、SpringBoot 原理

#### 3.1、起步依赖

原理：依赖传递

![image-20250818090828740](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818090828740.png)

#### 3.2、自动配置

##### 3.2.1、介绍

![image-20250818091035704](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818091035704.png)

![image-20250818091158289](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818091158289.png)

![image-20250818091911615](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818091911615.png)

![image-20250818091934578](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818091934578.png)

##### 3.2.2、实现方案

（1）自动配置设置方案

![image-20250818092041058](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818092041058.png)

===导入第三方工具包

![image-20250818092448742](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818092448742.png)

===说明：导入pom.xml文件即可，在需要使用该第三方工具包的项目中，引入该依赖。

![image-20250818092643002](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818092643002.png)

===注入该bean，调用方法

![image-20250818093753788](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818093753788.png)

![image-20250818093905428](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818093905428.png)

![image-20250818093501989](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818093501989.png)

===问题：那么如何使用第三方的工具包呢？

​		手动扫描组件。

（2）自动配置设置方案一：@Component + @ComponentScan

![image-20250818094248923](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818094248923.png)

![image-20250818094700249](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818094700249.png)

![image-20250818094947647](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818094947647.png)

===缺点：使用繁琐、性能低

如果需要使用多个第三方工具包时，那么启动类上要扫描的范围会非常冗杂，影响系统性能。

（3）自动配置设置方案二：

![image-20250818095420311](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818095420311.png)

===注入普通类

![image-20250818100121230](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818100121230.png)

===注入配置类

![image-20250818100754197](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818100754197.png)

===导入ImportSelector的接口实现类

![image-20250818101249462](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818101249462.png)

====通过第三方提供的注解导入

![image-20250818102157303](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818102157303.png)

===小结

![image-20250818102953515](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818102953515.png)

![image-20250818103124809](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818103124809.png)

##### 3.2.3、源码跟踪

![image-20250818111409295](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818111409295.png)

![image-20250818111620309](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818111620309.png)

===问题：当web服务器启动时，...AutoConfiguration.imports包下的所有bean都会注册为IOC容器下的bean？

===回答：不会。SpringBoot会根据@Conditianl相关注解条件装配。

##### 3.2.4、自定义配置---@Conditional

（1）介绍

![image-20250818113746807](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818113746807.png)

（2）@ConditionalOnClass

![image-20250818114144778](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818114144778.png)

![image-20250818141150700](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818141150700.png)

（3）@ConditionalOnMissingBean

![image-20250818141456779](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818141456779.png)

（4）@ConditionalOnProperty

![image-20250818142207465](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818142207465.png)

===解决：在配置文件添加对应属性

![image-20250818143630354](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818143630354.png)

![image-20250818143650559](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818143650559.png)

（5）小结

![image-20250818144251059](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818144251059.png)

### 4、自定义starter

#### 4.1、场景

​		在实际开发中，经常会发生一些公共组件，提供给各个项目团队使用。而在SpringBoot的项目中，一般会将这些公共组件封装为SpringBoot的starter（包含了起步依赖和自动配置的功能）。

![image-20250818145105008](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818145105008.png)

#### 4.2、步骤

![image-20250818145733987](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818145733987.png)

（1）创建新模块aliyun-oss-spring-boot-starter

![image-20250818150538702](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818150538702.png)

（2）修改pom.xml文件，保持版本，取出多余的依赖，保证pom.xml文件的简洁

![image-20250818150612530](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818150612530.png)

（3）再创建一个新模块aliyun-oss-spring-boot-autoconfigure

![image-20250818151043081](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818151043081.png)

（4）修改pom.xml文件

![image-20250818151400087](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818151400087.png)

（5）修改模块结构。删除test包、启动类

![image-20250818151440695](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818151440695.png)

（6）在aliyun-oss-spring-boot-starter中引入该依赖

![image-20250818151718764](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818151718764.png)

（7）在aliyun-oss-spring-boot-autoconfigure中导入aliyunoss的依赖

```xml
<!--阿里云oss依赖-->
<dependency>
    <groupId>com.aliyun.oss</groupId>
    <artifactId>aliyun-sdk-oss</artifactId>
    <version>3.17.4</version>
</dependency>

<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>
<dependency>
    <groupId>javax.activation</groupId>
    <artifactId>activation</artifactId>
    <version>1.1.1</version>
</dependency>
<!--no more than 2.3.3-->
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
    <version>2.3.3</version>
</dependency>
```

（8）代码演示

===AliyunOSSOperator

```java
@SuppressWarnings("all")
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSOperator {
    private AliyunOSSProperties aliyunOSSProperties;

    public AliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties) {
        this.aliyunOSSProperties = aliyunOSSProperties;
    }

    public String upload(byte[] content, String originalFilename) throws Exception {
        String endpoint = aliyunOSSProperties.getEndpoint();
        String bucketName = aliyunOSSProperties.getBucketName();
        String region = aliyunOSSProperties.getRegion();

        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

        // 填写Object完整路径，例如2024/06/1.png。Object完整路径中不能包含Bucket名称。
        //获取当前系统日期的字符串,格式为 yyyy/MM
        String dir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
        //生成一个新的不重复的文件名
        String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        String objectName = dir + "/" + newFileName;

        // 创建OSSClient实例。
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(credentialsProvider)
                .clientConfiguration(clientBuilderConfiguration)
                .region(region)
                .build();

        try {
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content));
        } finally {
            ossClient.shutdown();
        }

        return endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + objectName;
    }
}
```

===AliyunOSSProperties

```java
@SuppressWarnings("all")
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String region;

    public AliyunOSSProperties() {
    }

    public AliyunOSSProperties(String endpoint, String bucketName, String region) {
        this.endpoint = endpoint;
        this.bucketName = bucketName;
        this.region = region;
    }

    /**
     * 获取
     * @return endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * 设置
     * @param endpoint
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * 获取
     * @return bucketName
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * 设置
     * @param bucketName
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * 获取
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    public String toString() {
        return "AliyunOSSProperties{endpoint = " + endpoint + ", bucketName = " + bucketName + ", region = " + region + "}";
    }
}
```

===AliyunOSSAutoConfiguration

```java
@SuppressWarnings("all")
@EnableConfigurationProperties(AliyunOSSProperties.class)
@Configuration
public class AliyunOSSAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AliyunOSSOperator aliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties){
        return new AliyunOSSOperator(aliyunOSSProperties);
    }
}
```

![image-20250818164610314](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818164610314.png)

=== [org.springframework.boot.autoconfigure.AutoConfiguration.imports](..\..\..\Dev-work\web-ai-code2\aliyun-oss-spring-boot-autoconfigure\src\main\resources\META-INF\spring\org.springframework.boot.autoconfigure.AutoConfiguration.imports) 

```
com.aliyun.oss.AliyunOSSAutoConfiguration
```

（9）测试自定义starter

===创建新模块，并在pom文件中引入aliyun-oss-spring-boot-starter的依赖

![image-20250818170116601](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818170116601.png)

![image-20250818170004871](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818170004871.png)

![image-20250818170450647](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818170450647.png)

## 三、Maven高级

### 1、分模块设计与开发

#### 1.1、为什么要分模块？

​		将一个大项目拆分为若干个子模块，方便项目的管理维护、扩展，也方便模块间的**相互引用**，**资源共享**。

![image-20250818171149553](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818171149553.png)

![image-20250818171311215](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818171311215.png)

#### 1.2、策略

![image-20250818171641892](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818171641892.png)

===具体的选择根据项目组的先择而定

#### 1.3、演示

![image-20250818171857718](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818171857718.png)

#### 1.4、步骤

![image-20250818172031852](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818172031852.png)

![image-20250818172956924](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818172956924.png)

===补充：根据警告，引入对应的依赖

===补充：如何取消pom文件中的黄色波浪线？

![image-20250818175513436](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818175513436.png)

===小结

![image-20250818180844085](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818180844085.png)

### 2、继承与聚合

#### 2.1、继承

##### 2.1.1、引言

![image-20250818181048227](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818181048227.png)

##### 2.1.2、概念

​		maven中的**继承**描述的是两个工程间的关系，与java中的继承相似，子工程可以继承父工程的配置信息，常见于依赖关系的继承。

##### 2.1.3、作用

- 简化依赖配置
- 统一管理依赖

##### 2.1.4、实现

```xml
<parent>...</parent>
```

![image-20250818183808648](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818183808648.png)

##### 2.1.5、三种打包方式

![image-20250818184253301](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818184253301.png)

##### 2.1.6、继承关系

![image-20250818184541212](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818184541212.png)

===小结

![image-20250818192242044](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818192242044.png)

##### 2.1.7、版本锁定

![image-20250818193709919](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818193709919.png)

===补充：自定义属性/引用属性

![image-20250818194554837](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818194554837.png)

![image-20250818195035275](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818195035275.png)

![image-20250818195106864](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818195106864.png)

===小结

![image-20250818195456418](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818195456418.png)

#### 2.2、聚合

![image-20250818200002090](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818200002090.png)

![image-20250818200331784](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818200331784.png)

===小结

![image-20250818200642509](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818200642509.png)

### 3、私服

#### 3.1、介绍

![image-20250818201829269](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818201829269.png)

![image-20250818201951109](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818201951109.png)

​		私服是一种特殊的远程仓库，它是架设在局域网内的仓库服务，用来代理位于外部的中央仓库，用于解决团队内部的资源共享与资源同步问题。

===注意：私服在企业项目开发中，一个项目/公司，只需要一台即可（无需我们自己搭建，会使用即可）。

===小结

![image-20250818202304923](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250818202304923.png)

#### 3.2、资源上传与下载

##### 3.2.1、私服中的三个仓库

![image-20250819091128173](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250819091128173.png)

##### 3.2.2、上传资源

![image-20250819091301529](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250819091301529.png)

##### 3.2.3、下载资源

![image-20250819091439479](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250819091439479.png)

##### 3.2.4、操作步骤

（1）上传步骤

![image-20250819091539843](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250819091539843.png)

（2）

![image-20250819091640881](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250819091640881.png)

（3）下载步骤

![image-20250819091718964](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250819091718964.png)

![image-20250819091930565](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250819091930565.png)

![image-20250819092002461](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250819092002461.png)

### 四、后端web总结

![image-20250819093326908](D:\软件工程\JavaWeb + AI\04-后端Web进阶\assets\image-20250819093326908.png)

===补充：SpringMVC其实就是SpringFramework的一部分

===SSM：SpringMVC、Springframework、Mybatis。SSM开发都是基于SpringBoot快速构建的。