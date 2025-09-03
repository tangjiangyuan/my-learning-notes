## day16、

![image-20250808202252120](D:\软件工程\Java\java-advanced\day16\assets\image-20250808202252120.png)

## 一、线程通信

### 1、介绍

​	确保线程能够按照【预定的顺序】执行，并且能够【安全地】访问共享资源。使多条线程更好的进行协同工作。

### 2、使用场景

===不使用线程通信时

![image-20250808203610308](D:\软件工程\Java\java-advanced\day16\assets\image-20250808203610308.png)

![image-20250808203617560](D:\软件工程\Java\java-advanced\day16\assets\image-20250808203617560.png)

![image-20250808203624270](D:\软件工程\Java\java-advanced\day16\assets\image-20250808203624270.png)

===说明：结果杂乱无序

===解决：使用线程通信

![image-20250808203705277](D:\软件工程\Java\java-advanced\day16\assets\image-20250808203705277.png)

​	===补充：这些方法需要锁对象进行调用，建议使用类的class对象。

### 3、两条线程通信

```java
class Print1 {
    int flag = 1;
    public void print1() throws InterruptedException {

        if (flag != 1) {
            // 线程1等待
            Print1.class.wait();
        }

        System.out.print("床");
        System.out.print("前");
        System.out.print("明");
        System.out.print("月");
        System.out.print("光");
        System.out.println("");

        flag = 2;
        // 唤醒线程2
        Print1.class.notify(); // 没有睡眠的线程也可以 notify()
    }
    public void print2() throws InterruptedException {

        if (flag != 2) {
            // 线程2等待
            Print1.class.wait();
        }

        System.out.print("疑");
        System.out.print("似");
        System.out.print("地");
        System.out.print("上");
        System.out.print("霜");
        System.out.println("");

        flag = 1;
        // 唤醒线程1
        Print1.class.notifyAll(); // 也可以是使用notifyAll()
    }
}
```

```java
public static void main(String[] args) {
    Print1 p = new Print1();
    new Thread(() -> {
        while (true) {
            synchronized (Print1.class) {
                try {
                    p.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();

    new Thread(() -> {
        while (true) {
            synchronized (Print1.class) {
                try {
                    p.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
}
```

===结果显示：两句诗交替打印

### 4、三条线程通信

```java
class Print2 {
    int flag = 1;
    public void print1() throws InterruptedException {

        while (flag != 1) {
            Print2.class.wait();
        }

        System.out.print("床");
        System.out.print("前");
        System.out.print("明");
        System.out.print("月");
        System.out.print("光");
        System.out.println("");

        flag = 2;
        // notify()随机唤醒，唤醒时停留在 wait()语句，跳出if判断了
        Print2.class.notifyAll();
    }
    public void print2() throws InterruptedException {
        while (flag != 2) Print2.class.wait();
        System.out.print("疑");
        System.out.print("似");
        System.out.print("地");
        System.out.print("上");
        System.out.print("霜");
        System.out.println("");

        flag = 3;
        Print2.class.notifyAll();
    }
    public void print3() throws InterruptedException {
        while (flag != 3) Print2.class.wait();
        System.out.print("举");
        System.out.print("头");
        System.out.print("望");
        System.out.print("明");
        System.out.print("月");
        System.out.println("");

        flag = 1;
        Print2.class.notifyAll();
    }
}
```

```java
public static void main(String[] args) {
    Print2 p = new Print2();
    new Thread(() -> {
        while (true) {
            synchronized (Print2.class) {
                try {
                    p.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();

    new Thread(() -> {
        while (true) {
            synchronized (Print2.class) {
                try {
                    p.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();

    new Thread(() -> {
        while (true) {
            synchronized (Print2.class) {
                try {
                    p.print3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
}
```

![image-20250808203956896](D:\软件工程\Java\java-advanced\day16\assets\image-20250808203956896.png)

===结果显示：杂乱无序，不是预期结果

===原因：执行 notify() 语句时，会随机唤醒另外两个线程，并从 wait() 处唤醒，不执行 if判断，导致乱序或者数据丢失。

===解决：将 notify() 方法改为 notifyAll() 方法，用于唤醒所有线程；并将 if改为while。但是这样的方式，效率很低。

![image-20250808204327392](D:\软件工程\Java\java-advanced\day16\assets\image-20250808204327392.png)

```java
问题: sleep 方法 和 wait 方法的区别？
答 :
    sleep方法使线程睡眠，时间到了自动醒来，sleep方法在休眠的时候，不会释放锁。
    wait方法使线程等待，需要由其它线程进行notify唤醒，wait方法在等待期间，会释放锁。
```

===优化：使用ReentrantLock 互斥锁，提高效率

![image-20250808204944359](D:\软件工程\Java\java-advanced\day16\assets\image-20250808204944359.png)

```java
class Print3 {
    ReentrantLock lock = new ReentrantLock();

    // 第一次调用 await，Condition对象就会和线程绑定
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    int flag = 1;

    public void print1() throws InterruptedException {
        lock.lock();

        if (flag != 1) c1.await();

        System.out.print("床");
        System.out.print("前");
        System.out.print("明");
        System.out.print("月");
        System.out.print("光");
        System.out.println("");

        flag = 2;
        c2.signal();
        lock.unlock();
    }
    public void print2() throws InterruptedException {
        lock.lock();
        // 线程2等待，c2绑定线程2. 那个线程第一次调用await，就会绑定那个线程
        if (flag != 2) c2.await();
        System.out.print("疑");
        System.out.print("似");
        System.out.print("地");
        System.out.print("上");
        System.out.print("霜");
        System.out.println("");

        flag = 3;
        c3.signal();
        lock.unlock();
    }
    public void print3() throws InterruptedException {
        lock.lock();
        if (flag != 3) c3.await();
        System.out.print("举");
        System.out.print("头");
        System.out.print("望");
        System.out.print("明");
        System.out.print("月");
        System.out.println("");

        flag = 1;
        c1.signal();
        lock.unlock();
    }
}
```

```java
public static void main(String[] args) {
    Print3 p = new Print3();
    new Thread(() -> {
        while (true) {
            try {
                p.print1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();

    new Thread(() -> {
        while (true) {
            try {
                p.print2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();

    new Thread(() -> {
        while (true) {
            try {
                p.print3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
}
```

### 5、生产者消费者模式

#### 5.1、介绍

![image-20250808205253272](D:\软件工程\Java\java-advanced\day16\assets\image-20250808205253272.png)

#### 5.2、思路

![image-20250808205308242](D:\软件工程\Java\java-advanced\day16\assets\image-20250808205308242.png)

#### 5.3、代码实现

```java
public class WareHouse {
    public static boolean mark = false;
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition producer = lock.newCondition();
    public static Condition consumer = lock.newCondition();
}
```

```java
public class Producer implements Runnable {

    @Override
    public void run() {
        while (true) {
            WareHouse.lock.lock();

            if (WareHouse.mark) { // true : 有包子，生产者等待
                try {
                    WareHouse.producer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else  { // false : 无包子，生产者生产，唤醒消费者
                System.out.println(Thread.currentThread().getName() + "生产包子");
                WareHouse.mark = true;
                WareHouse.consumer.signal();
            }

            WareHouse.lock.unlock();
        }
    }
}
```

```java
public class Consumer implements Runnable {

    @Override
    public void run() {
        while (true) {
            WareHouse.lock.lock();

            if (WareHouse.mark) { // true : 有包子，消费者吃包子，改变mark，唤醒生产者
                System.out.println(Thread.currentThread().getName() + "吃包子");
                WareHouse.mark = false;
                WareHouse.producer.signal();
            } else { // false : 无包子，消费者等待
                try {
                    WareHouse.consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            WareHouse.lock.unlock();
        }
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        new Thread(new Producer(), "生产者").start();
        new Thread(new Consumer(), "消费者").start();
    }
}
```

![image-20250808230123586](D:\软件工程\Java\java-advanced\day16\assets\image-20250808230123586.png)

## 二、线程生命周期

### 1、介绍

- 线程启动后的各种状态；
- 线程被创建并启动后，它并不是一启动就进入执行状态，也不是一直处于执行状态；
- 线程对象在不同的时期有不同的状态。
- ![image-20250808230343453](D:\软件工程\Java\java-advanced\day16\assets\image-20250808230343453.png)

### 2、流程图

![image-20250808230351188](D:\软件工程\Java\java-advanced\day16\assets\image-20250808230351188.png)

## 三、线程池

### 1、介绍

- 像池塘一样，里面有许多线程，使用时取出，不用时放回； 

![image-20250808230532788](D:\软件工程\Java\java-advanced\day16\assets\image-20250808230532788.png)

### 2、学习路径

![image-20250808230710240](D:\软件工程\Java\java-advanced\day16\assets\image-20250808230710240.png)

### 3、理解线程池的好处

- 将线程交给线程池维护，可以**降低系统成本**，从而**提升系统的性能**。

### 4、使用JDK提供的线程池

![image-20250808230957624](D:\软件工程\Java\java-advanced\day16\assets\image-20250808230957624.png)

===static ExecutorService newCachedThreadPool() : 创建一个默认的线程池

```java
private static void method1() {
    // 1. 创建线程池对象
    ExecutorService pool = Executors.newCachedThreadPool();
    // 2. 提交任务
    for (int i = 1; i <= 100; i++) {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "提交了任务。");
            }
        });
    }
    // 3. 关闭池子
    pool.shutdown();
}
```

线程复用：

![image-20250808231239167](D:\软件工程\Java\java-advanced\day16\assets\image-20250808231239167.png)

===static newFixedThreadPool(int nThreads) : 创建一个指定最多线程数量的线程池：指定线程池中有10个线程。

```java
public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(10);
    for (int i = 1; i <= 100; i++) {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行了任务...");
            }
        });
    }
    pool.shutdown();
}
```

### 5、自定义线程池

#### 5.1、创建 ThreadPoolExecutor 类的对象

#### 5.2、构造方法

![image-20250808231412105](D:\软件工程\Java\java-advanced\day16\assets\image-20250808231412105.png)

```java
/*
    自定义线程池
    参数5 : 任务队列
        1) 有界队列 :  new ArrayBlockingQueue<>(num);
        2) 无界队列 :  new LinkedBlockingDeque<>(); 无界(概念无界，实际有界Integer.MAX_VALUE)
 */
public static void main(String[] args) {
    ThreadPoolExecutor pool = new ThreadPoolExecutor(
            2, // 核心线程(正式员工)
            5, // 总线程数(正式员工 + 临时员工)
            60,
            TimeUnit.MILLISECONDS, // 时间单位 毫秒
            new ArrayBlockingQueue<>(10), // 指定任务队列为10
            Executors.defaultThreadFactory(), // 系统默认线程工厂
            new ThreadPoolExecutor.AbortPolicy() // 拒绝策略 : 提交新任务时拒绝
    );
    // 只有超过（核心线程数 + 任务队列数）才会创建普通线程(招聘临时工)
    // 只有超过（总线程数 + 任务队列数）时，才会出发拒绝策略
    for (int i = 1; i <= 16; i++) {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "提交了任务...");
            }
        });
    }
    pool.shutdown();
}
```

===扩展---提交任务不仅可以使用 submit，还可以使用 execute；

但是execute 只能实现Runnable 接口，而submit 不仅可以实现Runnable 接口，还可以实现 Callable 接口。

===**面试：execute 和 submit 的区别？**

- 返回值：execute() 无返回值；submit() 返回 Future 对象获取结果；
- 任务类型：execute() 只支持 Runnable；submit() 支持Runnable 和 Callable；
- 异常处理：execute() 需在任务内手动捕获异常；submit() 将异常封装到 Future对象中，调用 get() 时统一处理，因此，简单任务使用 execute() ，需要结果或异常处理的任务用submit()

===避坑

- submit() 吞异常问题：即使任务抛异常，若不调用 future.get() ，异常会被静默丢弃！解决：通过 future.get() 触发异常处理或者 使用 CompletableFuture.
- 资源泄露风险：长时间不调用 future.get() 会导致 FutureTask 对象堆积（尤其是大任务量时）。最佳实践：用超时机制：future.get(5, TimeUnit.SECONDS)。

#### 5.3、拒绝策略

![image-20250808233411038](D:\软件工程\Java\java-advanced\day16\assets\image-20250808233411038.png)

## 四、单例设计模式

### 1、介绍

- 单例指单个实例，保证类的对象在内存中只有一份。

### 2、使用场景

- 如果创建一个对象需要消耗的资源过多，比如 IO与 数据库的连接，并且这个对象完全是可以复用的，我们就可以考虑将其设置为单例的对象。

### 3、饿汉式

```java
class Singleton1 {
    // 1. 私有该类的构造方法，防止创建对象
    private Singleton1() {}
    // 2. 定义一个变量接收自己创建的对象
    private static final Singleton1 Instance = new Singleton1();
    // 3. 提供一个唯一的全局接入点
    public static Singleton1 getInstance() {
        return Instance;
    }
}
```

```java
public static void main(String[] args) {
    Singleton1 instance1 = Singleton1.getInstance();
    Singleton1 instance2 = Singleton1.getInstance();
    System.out.println(instance1 == instance2); // true
}
```

### 4、懒汉式（延迟加载模式）

（1）初始

```java
class Singleton2 {
    private Singleton2() {}

    private static Singleton2 Instance;

    public static Singleton2 getInstance() {
        if (Instance == null) { // 保证不会创建两个对象，导致地址值不同
            Instance = new Singleton2();
        }
        return Instance;
    }
}
```

===弊端：在多线程并发操作时，有可能创建出多个对象。

![image-20250808234437205](D:\软件工程\Java\java-advanced\day16\assets\image-20250808234437205.png)

![image-20250808234443388](D:\软件工程\Java\java-advanced\day16\assets\image-20250808234443388.png)

===原因：加入线程1创建出来进入 if判断后，刚要实例化时，线程2抢到了CPU执行权，线程1进入就绪状态；而线程2实例化后，线程1也进行了实例化，导致创建出多个对象。

===解决：加入同步代码块

![image-20250808234822721](D:\软件工程\Java\java-advanced\day16\assets\image-20250808234822721.png)

![image-20250808235228497](D:\软件工程\Java\java-advanced\day16\assets\image-20250808235228497.png)

===结果：解决了多对象的创建，但还存在着弊端。

===弊端：当线程1进入同步代码块后，线程2阻塞，当线程1实例完后，释放锁，线程2得到锁进入同步代码块实例化，而线程1进入阻塞，导致执行效率低。

===解决：在同步代码块外层再进行一次判断，减少阻塞，提升运行效率。

（2）优化

```java
class Singleton2 {
    private Singleton2() {}

    private static Singleton2 Instance;

    public static Singleton2 getInstance() {
        if (Instance == null) { // 双检测，减少阻塞，提高运行效率
            synchronized (Singleton2.class) {
                if (Instance == null) { // 保证不会创建两个对象，导致地址值不同
                    Instance = new Singleton2();
                }
            }
        }
        return Instance;
    }
}
```

===模拟：当线程1进入外层判断时，线程2也同样进入判断，线程1进入同步代码块后，线程2阻塞；当线程1实例完释放锁后，再次来到外层判断，此时结果为false，直接实例化，而无需再同步；线程2进入同步代码块，内层判断为false，不用实例化而再次到达外层判断，同线程1一样直接实例化。至此，只有一次实例化。

===面试：懒汉式中，外层判断的作用是什么？同步代码块的作用是什么？

同步代码块：避免创建多个对象；

外层判断：进行双检测，减少阻塞，提升效率。