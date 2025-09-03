## day15、

![image-20250807232023619](D:\软件工程\Java\java-advanced\day15\assets\image-20250807232023619.png)

## 一、进程和线程

### 1、进程介绍（Process）

- 进程是计算机中的程序关于某数据集合上的一次运动活动，是系统进行资源分配的基本单位。
- 简单理解：就是正在运行的应用程序；程序的执行过程。

![image-20250807233153665](D:\软件工程\Java\java-advanced\day15\assets\image-20250807233153665.png)

### 2、特点

- **独立性**：每一个进程都有自己的空间（内存），在没有经过进程本身允许的情况下，一个进程不可以直接访问其它的进程空间。
- **动态性**：进程是动态产生，动态消亡的。
- 并发性：任何进程都可以同其他进程一起并发执行。

### 3、并发和并行

- **并发**：在同一时刻，有多个指令在**单个CPU**上【**交替**】执行；
- **并发**：在同一时刻，有多个指令在**多个CPU**上【**同时**】执行；

===补充

​	多个进程同时工作时，对于一个CPU而言，它是在多个进程之间轮换执行的。

### 4、线程介绍

​	进程中的任务，多线程就是多任务。

### 5、多线程的意义

===为什么需要多线程？

- 随着处理器上的核心数量越来越多，现在大多数计算机都比以往更加擅长并行计算（多核心）；
- 一个线程，在一个时刻，只能运行在一个处理器核心上，效率低；

![image-20250807234028409](D:\软件工程\Java\java-advanced\day15\assets\image-20250807234028409.png)

===意义

- 提高效率
- 可以同时处理多个任务

## 二、Java 开启线程的方式

### 1、继承 Thread类

```java
开启线程的第一种方法 继承 Thread类
    1. 编写一个类继承 Thread类
    2. 重写 run方法
    3. 将线程任务代码写到 run方法中
    4. 创建线程对象
    5. 调用 start方法开启线程

 细节 --- 调用start方法开启线程，会自动调用 run方法执行
 注意 --- 只有调用了start方法，才是开启了新线程
```

```java
// 1. 编写一个类继承 Thread类
class MyThread extends Thread {
    // 2. 重写 run方法
    @Override
    public void run() {
        // 3. 将线程任务代码写到 run方法中
        for (int i = 1; i <= 100; i++) {
            System.out.println("线程执行了:" + i);
        }
    }
}
```

```java
public static void main(String[] args) {
    // 4. 创建线程对象
    MyThread mt1 = new MyThread();
    MyThread mt2 = new MyThread();
    // 5. 调用 start方法开启线程
    mt1.start();
    mt2.start();
}
```

===补充

```java
/*
    Java 程序默认是多线程的，程序启动后默认会存在两条线程
        1. 主线程
        2. 垃圾回收线程
 */
```

![image-20250807234341256](D:\软件工程\Java\java-advanced\day15\assets\image-20250807234341256.png)

### 2、实现 Runnable接口

```java
开启线程的第二种方式 : 实现 Runnable接口 --- 扩展性更强
    1. 编写一个类实现 Runnable接口
    2. 重写 run方法
    3. 将线程任务代码写在 run方法中
    4. 创建线程任务资源
    5. 创建线程对象，将资源传入
    6. 使用线程对象调用 start方法，开启线程
```

```java
// 1. 编写一个类实现 Runnable接口
class MyRunnable implements Runnable {
    // 2. 重写 run方法
    @Override
    public void run() {
        // 3. 将线程任务代码写在 run方法中
        for (int i = 1; i <= 200; i++) {
            System.out.println("线程任务执行了" + i);
        }
    }
}
```

```java
public static void main(String[] args) {
    // 4. 创建线程任务资源
    MyRunnable mr = new MyRunnable();
    // 5. 创建线程对象，将资源传入
    Thread t = new Thread(mr);
    // 6. 使用线程对象调用 start方法，开启线程
    t.start();

    for (int i = 1; i <= 200; i++) {
        System.out.println("main线程执行了" + i);
    }
}
```

### 3、实现 Callable接口

```java
开启线程的第三种方法 --- 实现 Callable接口
    1. 编写一个实现 Callable接口
    2. 重写 call方法
    3. 将任务代码写在 call方法中
    4. 创建线程任务资源对象
    5. 创建线程任务对象，封装线程资源
    6. 创建线程对象，传入线程任务
    7. 使用线程对象调用 start开启线程

细节 --- Callable接口有泛型，call方法有返回值，返回值是什么类型，接口的泛型就是什么类型
```

```java
// 1. 编写一个实现 Callable接口
class MyCallable implements Callable<Integer> {
    // 2. 重写 call方法
    @Override
    public Integer call() throws Exception {
        // 3. 将任务代码写在 call方法中
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            // System.out.println("sum:" + sum);
        }
        return sum;
    }
}
```

![image-20250807234658058](D:\软件工程\Java\java-advanced\day15\assets\image-20250807234658058.png)

===开启多个线程，需要再创建线程任务对象

```java
public static void main(String[] args) throws Exception {
    // 4. 创建 线程 任务资源对象
    MyCallable mc = new MyCallable();
    // 5. 创建 线程 任务对象，封装线程资源
    FutureTask<Integer> task1 = new FutureTask<>(mc);
    FutureTask<Integer> task2 = new FutureTask<>(mc);
    // 6. 创建 线程 对象，传入线程任务
    Thread t1 = new Thread(task1);
    Thread t2 = new Thread(task2);
    // 7. 使用线程对象调用 start开启线程
    t1.start();
    t2.start();
    // 使用线程任务对象接收返回值
    Integer result1 = task1.get();
    Integer result2 = task2.get();
    System.out.println("task1结果是:" + result1);
    System.out.println("task2结果是:" + result2);
}
```

===总结

![image-20250807234814412](D:\软件工程\Java\java-advanced\day15\assets\image-20250807234814412.png)

## 三、线程相关方法

![image-20250807234938618](D:\软件工程\Java\java-advanced\day15\assets\image-20250807234938618.png)

### 1、getName()、setName()、currentThread()

（1）继承 Thread类

```java
class MyThread extends Thread {
    public MyThread() {}
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(super.getName() + "线程任务执行了" + i);
        }
    }
}
```

```java
public static void main(String[] args) {
        MyThread mt1 = new MyThread("A: ");
        MyThread mt2 = new MyThread("B: ");

//        mt1.setName("A: ");
//        mt2.setName("B: ");
        mt1.start();
        mt2.start();
    }
```

（2）实现 Runnable接口

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "执行了" + i);
        }
    }
}
```

```java
public static void main(String[] args) {
    MyRunnable mr = new MyRunnable();
    Thread t = new Thread(mr, "A: ");
    t.start();

    for (int i = 1; i <= 200; i++) {
        System.out.println(Thread.currentThread().getName() + "执行了" + i);
    }
}
```

（3）实现 Callable接口

```java
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            System.out.println(Thread.currentThread().getName() + "sum:" + sum);
        }
        return sum;
    }
}
```

```java
public static void main(String[] args) throws Exception {
    MyCallable mc = new MyCallable();
    FutureTask<Integer> task1 = new FutureTask<>(mc);
    FutureTask<Integer> task2 = new FutureTask<>(mc);
    Thread t1 = new Thread(task1, "线程A: ");
    Thread t2 = new Thread(task2, "线程B: ");

    t1.start();
    t2.start();
    Integer result1 = task1.get();
    Integer result2 = task2.get();
    System.out.println(t1.getName() + "结果是:" + result1);
    System.out.println(t2.getName() + "结果是:" + result2);
}
```

### 2、sleep()

```java
休眠线程的方法
public static void sleep(long time) : 让线程休眠指定时间，单位为毫秒
```

```java
public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 5; i++) {
        System.out.println("倒计时:" + (i + 1) + "秒");
        Thread.sleep(1000);
    }
}
```

### 3、线程优先级

```java
线程优先级的方法 :
public setPriority(int newPriority) : 设置线程优先级
public final int getPriority() : 获取线程优先级
优先级：1 ~ 10, 默认 5
```

===补充

​	线程的调度方法---Java使用的是抢占式调度方式

- 抢占式调度（随机）：线程的优先级越高，抢到CPU执行权的概率越高；
- 非抢占式调度

```java
public static void main(String[] args) {
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "执行了:" + (i + 1));
            }
        }
    }, "线程A: ");

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "执行了:" + (i + 1));
            }
        }
    }, "线程B: ");

    t1.setPriority(1);
    t2.setPriority(10);

    System.out.println(t1.getPriority());
    System.out.println(t2.getPriority());

    t1.start();
    t2.start();
}
```

### 4、守护线程

```java
public final void setDaemon(boolean on) : 设置为守护线程
```

```java
public static void main(String[] args) {
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "---" + (i + 1));
            }
        }
    }, "线程A: ");

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 200; i++) {
                System.out.println(Thread.currentThread().getName() + "---" + (i + 1));
            }
        }
    }, "线程B: ");

    // 将 t2设置为守护线程，t1结束后，t2也会马上结束(殉情)
    // 守护线程会随着所有非守护线程的结束而结束，所以如果有两条非守护线程，一条结束了守护线程不会也跟着结束
    t2.setDaemon(true);

    t1.start();
    t2.start();
}
```

## 四、线程安全和同步

### 1、练习

```
/*
    需求 : 某电影院目前正在上映国产大片，共有100张票，而它有3个窗口买票，请输入即一个程序模拟该电影院买票
 */
```

![image-20250808000102586](D:\软件工程\Java\java-advanced\day15\assets\image-20250808000102586.png)

![image-20250808000108439](D:\软件工程\Java\java-advanced\day15\assets\image-20250808000108439.png)

![image-20250808000422559](D:\软件工程\Java\java-advanced\day15\assets\image-20250808000422559.png)

===说明

​	结果显示的数据，表示线程不安全；

===为什么会产生这样的结果？

​	因为多条线程共享操作同一份资源，cpu在多个线程中来回转换，导致了线程不安全。

### 2、线程安全问题出现的条件

（1）是多线程环境

（2）有共享数据

（3）有多条语句操作共享数据

### 3、同步技术

===说明：将多条语句操作的共享数据的代码给【锁】起来，让任意时刻只能有一个线程可以执行。

（1）同步代码块

（2）同步方法

（3）Lock 锁

### 4、同步代码块

#### 4.1、格式

![image-20250808001211397](D:\软件工程\Java\java-advanced\day15\assets\image-20250808001211397.png)

#### 4.2、实现 Runnable接口

```java
class TicketTask implements Runnable {
    private Object o = new Object();
    private int tickets = 2000;

    @Override
    public void run() {
        while (true) {
            synchronized (o) { // 锁对象可以是任意对象
                if (tickets <= 0) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "号票");
                tickets--;
            }
        }
    }
}
```

```java
public static void main(String[] args) {
    TicketTask tt = new TicketTask();
    Thread t1 = new Thread(tt, "窗口1:");
    Thread t2 = new Thread(tt, "窗口2:");
    Thread t3 = new Thread(tt, "窗口3:");

    t1.start();
    t2.start();
    t3.start();
}
```

===结果显示没有负数票和重复票了。

#### 4.3、继承 Thread类

![image-20250808001814039](D:\软件工程\Java\java-advanced\day15\assets\image-20250808001814039.png)

![image-20250808001821145](D:\软件工程\Java\java-advanced\day15\assets\image-20250808001821145.png)

![image-20250808001833144](D:\软件工程\Java\java-advanced\day15\assets\image-20250808001833144.png)

===结果显示没有负数票了，但是出现了重复票。

===为什么会出现重复票？

​	因为创建了三个线程，在堆内存中开辟了3个空间，每个空间都存放了一个锁和票数，不是共享的。

===如何解决？

​	加入static 关键字，修饰需要共享的数据，使得它们被当前类的所有对象锁共享。

```java
class TicketTask2 extends Thread {
    private static int tickets = 2000;
    private static Object o = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (o) {
                if (tickets == 0) {
                    break;
                }
                System.out.println(getName() + "卖出第" + tickets + "号票。");
                tickets--;
            }
        }
    }
}
```

```java
public static void main(String[] args) {
    TicketTask2 t1 = new TicketTask2();
    TicketTask2 t2 = new TicketTask2();
    TicketTask2 t3 = new TicketTask2();

    t1.setName("窗口1: ");
    t2.setName("窗口2: ");
    t3.setName("窗口3: ");

    t1.start();
    t2.start();
    t3.start();
}
```

===优化：锁对象使用当前类的字节码，唯一且只加载一次

```java
class TicketTask3 extends Thread {
    private static int tickets = 2000;
    @Override
    public void run() {
        while (true) {
            // 使用类的字节码作为锁对象，应为类的字节码只加载一次(推荐今后使用)
            synchronized (TicketTask3.class) {
                if (tickets == 0) {
                    break;
                }
                System.out.println(getName() + "卖出第" + tickets + "号票。");
                tickets--;
            }
        }
    }
}
```

![image-20250808002500590](D:\软件工程\Java\java-advanced\day15\assets\image-20250808002500590.png)

===原因：因为当线程1执行任务代码时上锁，线程2、3需要排队等待，所以运行效率低。

### 5、同步方法

![image-20250808002859456](D:\软件工程\Java\java-advanced\day15\assets\image-20250808002859456.png)

![image-20250808003214539](D:\软件工程\Java\java-advanced\day15\assets\image-20250808003214539.png)

===面试题：同步方法中的锁对象？

（1）静态方法：当前类的字节码对象；

（2）非静态方法：this，当前类；

![image-20250808004107723](D:\软件工程\Java\java-advanced\day15\assets\image-20250808004107723.png)

### 6、Lock 锁

![image-20250808004118677](D:\软件工程\Java\java-advanced\day15\assets\image-20250808004118677.png)

#### 6.1、介绍

​	Lock 是接口，无法直接创建对象。

#### 6.2、构造方法

![image-20250808004156639](D:\软件工程\Java\java-advanced\day15\assets\image-20250808004156639.png)

#### 6.3、成员方法

![image-20250808004211485](D:\软件工程\Java\java-advanced\day15\assets\image-20250808004211485.png)

```java
class TicketTask6 implements Runnable {
    private int tickets = 100;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets == 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "号票。");
                tickets--;
            } finally {
                lock.unlock();
            }
        }
    }
}
```

```java
public static void main(String[] args) {
    TicketTask6 task = new TicketTask6();
    Thread t1 = new Thread(task, "窗口1:");
    Thread t2 = new Thread(task, "窗口2:");
    Thread t3 = new Thread(task, "窗口3:");

    t1.start();
    t2.start();
    t3.start();
}
```



### 7、死锁

#### 7.1、介绍

​	由于两个或者多个线程互相持有对方所需要的资源，导致这些线程处于等待状态，无法前往执行。

#### 7.2、产生死锁的情况

=== 同步嵌套

![image-20250808004525359](D:\软件工程\Java\java-advanced\day15\assets\image-20250808004525359.png)

![image-20250808004529507](D:\软件工程\Java\java-advanced\day15\assets\image-20250808004529507.png)

![image-20250808004533816](D:\软件工程\Java\java-advanced\day15\assets\image-20250808004533816.png)