## day07、事件类

<img src="D:\软件工程\Java\java-advanced\day07\assets\image-20250803140637209.png" alt="image-20250803140637209" style="zoom:67%;" />

## 一、时间API

![image-20250803140711294](D:\软件工程\Java\java-advanced\day07\assets\image-20250803140711294.png)

![image-20250803140715642](D:\软件工程\Java\java-advanced\day07\assets\image-20250803140715642.png)

## 二、JDK8之前

### 1、Date 类

#### 1.1、构造方法

```java
public Date():将当前时间，封装为Date日期对象 (常用)
public Date(long time):把时间毫秒值转换为Date日期对象
```

#### 1.2、成员方法

```java
public long getTime(): 返回从1970年1月1日 00:00:00 走到此刻的总的毫秒数 (常用)
public void setTime(long time): 设置日期对象的时间为当前时间毫秒值对应的时间
```

#### 1.3、演示

```java
public static void main(String[] args) {
    // 获取当前时间的年月日和时分秒
    Date now = new Date();
    System.out.println(now);

    // 获取从1970年1月1日 00:00:00 加1000ms的时间(有时差)
    Date date1 = new Date(1000L);
    System.out.println(date1);

    // 获取 1970年1月1日 00:00:00 到 指定时间 所经历的毫秒值
    System.out.println(now.getTime());
    System.out.println(date1.getTime());

    // 获取 将当前时间清空后的时间，即1970年1月1日 00:00:00
    Date date2 = new Date();
    date2.setTime(0L);
    System.out.println(date2);
}
```

### 2、SimpleDateFormar 类

#### 2.1、构造方法

```java
public SimpleDateFormat(): 创建一个日期格式化对象，使用[默认模式]
public SimpleDateFormat(String pattern): 创建一个日期格式化对象，[手动指定模式]
```

#### 2.2、成员方法

```java
public final String format(Date date): 将日期对象，转换为字符串
public final Date parse(String source): 将日期字符串，解析为日期类型 (字符串和指定格式的模式要一致才能匹配)
```

#### 2.3、演示

![image-20250803141534796](D:\软件工程\Java\java-advanced\day07\assets\image-20250803141534796.png)

```java
public static void main(String[] args) throws ParseException {
    /* String -> Date */
    String time1 = "2003-08-28";
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(time1);
    System.out.println(date); // Thu Aug 28 00:00:00 CST 2003

    /* Date -> String */
    String format = new SimpleDateFormat("yyyy/M/d").format(date);
    System.out.println(format); // 2003/8/28
}
```

#### 2.4、小结

![image-20250803141855535](D:\软件工程\Java\java-advanced\day07\assets\image-20250803141855535.png)

![image-20250803141901220](D:\软件工程\Java\java-advanced\day07\assets\image-20250803141901220.png)

### 3、Calendar 类

#### 3.1、介绍

​	代表的是系统此刻时间对应的日历，通过它可以单独获取、修改时间中的年、月、日、时、分、秒等。

#### 3.2、获取对象的方法

```java
public static Calendar getInstance() : 获取当前时间的日历对象
```

#### 3.3、成员方法

```java
public int get(int field):  取日历中的某个信息

        get方法的参数 : Calendar类中的静态常量
        c.get(Calendar.YEAR) : 获取年
        c.get(Calendar.MONTH) : 获取月,月份范围为[0~11]
        c.get(Calendar.DAY_OF_MONTH) : 获取日
        c.get(Calendar.DAY_OF_WEEK) : 获取周
        c.get(Calendar.HOUR) : 获取小时(12小时制)
        c.get(Calendar.HOUR_OF_DAY) : 获取小时(24小时制)
        c.get(Calendar.MINUTE) : 获取分钟


public void set(int field, int value):  修改日历的某个字段信息
public void add(int field, int amount): 为某个字段增加/减少指定的值
public final Date getTime() : 获取日期对象
public final setTime(Date date) : 给日历设置日期对象
```

#### 3.4、演示

```java
String string = new SimpleDateFormat("yyyy-M-d").format(Calendar.getInstance().getTime());
System.out.println(string);
```

```java
private static void getMethod() {
    // Calendar c : 抽象类
    // Calendar.getInstance() : 获取的是子类对象
    // 1. 获取当前时间的日历对象
    Calendar c = Calendar.getInstance();

    // 2. 调用get方法，取日历中的某个信息
    System.out.println(c.get(Calendar.YEAR) + "年");
    // 注意Calendar类的月份时 0~11，想要获取正常的月份，需要对结果 +1操作
    System.out.println(c.get(Calendar.MONTH) + 1 + "月"); // 月份范围为[0~11]
    System.out.println(c.get(Calendar.DAY_OF_MONTH) + "日");

    // 星期  : 日  一   二   三   四   五   六   (国外星期)
    //        1   2    3    4    5   6    7
    char[] weeks = {' ', '日', '一', '二', '三', '四', '五', '六'};
    //               0    1     2    3     4     5    6     7
    // 根据索引索取中国的星期
    // int weekIndex = c.get(Calendar.DAY_OF_WEEK);
    // System.out.println("星期" + weeks[weekIndex]);
    System.out.println("星期" + weeks[c.get(Calendar.DAY_OF_WEEK)]);

    // System.out.println(c.get(Calendar.HOUR)); // 12小时制
    System.out.println(c.get(Calendar.HOUR_OF_DAY)); // 24小时制
    System.out.println(c.get(Calendar.MINUTE));
}
```



### 4、练习

练习一：

![image-20250803142437935](D:\软件工程\Java\java-advanced\day07\assets\image-20250803142437935.png)

![image-20250803142443465](D:\软件工程\Java\java-advanced\day07\assets\image-20250803142443465.png)

练习二：

![image-20250803142547599](D:\软件工程\Java\java-advanced\day07\assets\image-20250803142547599.png)

```java
public static void main(String[] args) throws Exception{
    Calendar calendar = Calendar.getInstance();
    char[] weeks = {' ', '日', '一', '二', '三', '四', '五', '六'};
	// 2025.8.7
    calendar.set(Calendar.YEAR, 2025);
    calendar.set(Calendar.MONTH, 7); // 0~11，指定月份减一
    calendar.set(Calendar.DAY_OF_MONTH, 7);
    
    int weekIndex = calendar.get(Calendar.DAY_OF_WEEK);
    if (weeks[weekIndex] == '四') {
    	System.out.println("疯狂星期四！！！");
    } else {
    	System.out.println("不是疯狂星期四。");
    }
}
```

练习三：

![image-20250803143958090](D:\软件工程\Java\java-advanced\day07\assets\image-20250803143958090.png)

```java
// 方法一：
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入日期(xxxx-xx-xx):");
    String inputTime = sc.next();
    sc.close();

    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, Integer.parseInt(inputTime.split("-")[0]));
    calendar.set(Calendar.MONTH, Integer.parseInt(inputTime.split("-")[1]) - 1);
    calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(inputTime.split("-")[2]));

    int day = calendar.get(Calendar.DAY_OF_YEAR);
    System.out.println("这是一年中的第" + day + "天。");
  }
```

```java
// 方法二：
public static void main(String[] args) throws Exception{
    // 键盘录入日期
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入日期(xxxx-xx-xx):");
    String inputTime = sc.next();
    sc.close();

    // 通过SimpleDateFormat解析为Date类型对象
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");
    Date date = simpleDateFormat.parse(inputTime);

    // 将Date类型对象，交给Calendar对象调用的setTime()方法
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int day = calendar.get(Calendar.DAY_OF_YEAR);
    System.out.println("这是一年中的第" + day + "天。");
}
```



### 5、总结

![image-20250803145536048](D:\软件工程\Java\java-advanced\day07\assets\image-20250803145536048.png)

## 三、JDK8之后

### 1、常用类

![image-20250803145555027](D:\软件工程\Java\java-advanced\day07\assets\image-20250803145555027.png)

![image-20250803145601755](D:\软件工程\Java\java-advanced\day07\assets\image-20250803145601755.png)

### 2、日历类

#### 2.1、获取对象的方法

![image-20250803150409547](D:\软件工程\Java\java-advanced\day07\assets\image-20250803150409547.png)

#### 2.2、LocalDate

```java
public static void localDateTest() {
    LocalDate ld = LocalDate.now(); // 获取当前年月日
    LocalDate ld2 = LocalDate.of(2003, 6, 26); // 指定年月日
    System.out.println(ld);
    System.out.println(ld2);

    System.out.println(ld.getYear());
    System.out.println(ld.getMonthValue());
    System.out.println(ld.getDayOfMonth());

    System.out.println(ld.getDayOfYear()); // 一年中第几天
    System.out.println(ld.getDayOfWeek()); // 星期
    System.out.println(ld.getDayOfWeek().getValue());
    System.out.println(ld.getMonth()); // 月份

    // isBefore & isAfter
    System.out.println(ld2 + "是否在" + ld + "之前?" + ld2.isBefore(ld));
    System.out.println(ld2 + "是否在" + ld + "之后?" + ld2.isAfter(ld));

    // equals
    System.out.println(ld2 + "是否和" + ld + "相同?" + ld2.equals(ld));
}
```



#### 2.3、LocalTime

```java
public static void localTimeTest() {
    LocalTime lt = LocalTime.now();
    LocalTime lt2 = LocalTime.of(8, 8, 8);
    System.out.println(lt);
    System.out.println(lt2);

    System.out.println(lt.getHour()); // 时
    System.out.println(lt.getMinute()); // 分
    System.out.println(lt.getSecond()); // 秒
    System.out.println(lt.getNano()); // 纳秒
}
```



#### 2.4、LocalDateTime

```java
public static void localDateTimeTest() {
    LocalDateTime ldt = LocalDateTime.now();
    LocalDateTime ldt2 = LocalDateTime.of(2003, 6, 26, 8, 8, 8);
    System.out.println(ldt);
    System.out.println(ldt2);

    // get
    System.out.println(ldt.getYear());
    System.out.println(ldt.getMonthValue());
    System.out.println(ldt.getDayOfMonth());
    System.out.println(ldt.getHour());
    System.out.println(ldt.getMinute());
    System.out.println(ldt.getSecond());
    System.out.println(ldt.getNano());

    // minus 减
    System.out.println("减去一个小时" + ldt.minusHours(1));

    // plus 加
    System.out.println("加一年:" + ldt.plusYears(1));

    // with 设置
    System.out.println("将月份设为6月:" + ldt.withMonth(6));
}
```



#### 2.5、修改年月日时分秒的方法

![image-20250803150612252](D:\软件工程\Java\java-advanced\day07\assets\image-20250803150612252.png)

#### 2.6、小结

![image-20250803150728447](D:\软件工程\Java\java-advanced\day07\assets\image-20250803150728447.png)

### 3、日期格式化类

#### 3.1、格式化对象的获取

```java
public static DateTimeFormatter ofPattern(格式) : 获取格式对象
```

#### 3.2、格式化方法

```java
String format(时间) : 按照指定方式格式化
时间类型: LocalDate, LocalTime, LocalDateTime
```

#### 3.3、解析方法

```java
LocalDateTime.parse("解析字符串", 格式化对象);
LocalDate.parse("解析字符串", 格式化对象);
LocalTime.parse("解析字符串", 格式化对象);
```

#### 3.4、演示

![image-20250824161803263](D:\软件工程\Java\java-advanced\day07\assets\image-20250824161803263.png)

```java
public static void main(String[] args) {
    String time = DateTimeFormatter.ofPattern("yyyy-M-d").format(LocalDate.now());
    System.out.println(time); // 2025-8-24 

    LocalDate parse = LocalDate.parse(time, DateTimeFormatter.ofPattern("yyyy-M-d"));
    System.out.println(parse); // 2025-08-24
}
```

```java
public static void dateTimeFormatterTest() {
    // 格式化
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
    LocalDate ld = LocalDate.now();
    System.out.println("格式化之前:" + ld);
    System.out.println("格式化之后:" + dtf.format(ld));

    // 解析
    String time = "2003-6-26";
    System.out.println(LocalDate.parse(time, dtf));
}
```



### 4、时间类

#### 4.1、ZoneId 类

（1）获取对象方法

```java
static ZoneId systemDefault() : 获取系统默认时区
static ZoneId of(String zoneId) : 获取一个指定时区
```

（2）常用方法

```java
static Set<String> getAvailableZoneIds() : 获取 Java中支持的所有时区
```

（3）演示

```java
public static void zoneIdTest() {
    // 获取Java中支持的所有时区
    Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
    // System.out.println(availableZoneIds);
    System.out.println(availableZoneIds.size()); // 603

    // 获取系统默认时区
    ZoneId zoneId = ZoneId.systemDefault();
    System.out.println(zoneId); // Asia/Shanghai

    // 指定时区
    ZoneId of = ZoneId.of("America/Marigot");
    System.out.println(of);

    ZonedDateTime zonedDateTime = Instant.now().atZone(of);
    System.out.println(zonedDateTime);
}
```



#### 4.2、Instant 时间戳

（1）获取对象的方法

```java
static Instant now() : 获取当前时间的 Instant对象（标准时间）
static Instant ofXxx(long epochMilli) : 根据（秒/毫秒/纳秒）获取 Instant对象
```

（2）常用方法

```java
ZonedDateTime atZone(ZoneId zone) : 指定时区
boolean isXxx(Instant otherInstant) : 判断系列的方法
Instant minusXxx(long millisToSubtract) : 减少时间系列的方法
Instant plusXxx(long millisToSubtract) : 增加时间系列的方法
```

（3）演示

```java
public static void instantTest() throws Exception {
    // 获取当前时间戳
    Instant instant = Instant.now();
    System.out.println(instant);

    // 指定时间戳
    ZonedDateTime atZone = Instant.now().atZone(ZoneId.of("America/Marigot"));
    System.out.println(atZone);

    // 根据(秒/毫秒/纳秒) 获取 Instant对象
    Instant insOf1 = Instant.ofEpochSecond(100);
    Instant insOf2 = Instant.ofEpochMilli(1000);
    System.out.println(insOf1);
    System.out.println(insOf2);

    // isBefore & isAfter
    System.out.println(instant.isBefore(insOf1));
    System.out.println(instant.isAfter(insOf1));
}
```



#### 4.3、ZoneDateTime 带时区的时间对象

（1）获取对象的方法

```java
static ZonedDateTime now() : 获取当前时间的 ZoneDateTime对象
static ZonedDateTime ofXxx() : 获取指定时间的ZoneDateTime对象
```

（2）常用方法

```java
ZonedDateTime withXxx() : 修改时间系列的方法
ZonedDateTime minusXxx() : 减少时间系列的方法
ZonedDateTime plusXxx() : 增加时间系列的方法
```

（3）演示

```java
public static void zonedDateTimeTest() {
    ZonedDateTime now = ZonedDateTime.now();
    System.out.println(now);

    ZonedDateTime of = ZonedDateTime.of(2003, 6, 26, 
        8, 8, 8, 8, ZoneId.of("America/Marigot"));
    System.out.println(of);

    // 修改事件的方法
    System.out.println(now.withYear(2003));
    System.out.println(now.minusMonths(1));
    System.out.println(now.plusDays(1));
}
```



### 5、工具类

#### 5.1、Duration

（1）介绍

​	用于计算两个”时间“间隔（秒、纳秒）

（2）演示

```java
public static void durationTest() {
    LocalDateTime now = LocalDateTime.now();
    System.out.println("今天:" + now);

    LocalDateTime yestoday = LocalDateTime.of(2025, 7, 19, 0, 0, 0);
    System.out.println("昨天:" + yestoday);

    Duration duration = Duration.between(yestoday, now); // 第二个参数减第一个参数

    System.out.println("两天相差的天数:" + duration.toDays());
    System.out.println("两天相差的小时数:" + duration.toHours());
    System.out.println("两天相差的分钟数:" + duration.toMinutes());
    System.out.println("两天相差的秒数:" + duration.toSeconds());
    System.out.println("两天相差的毫秒数:" + duration.toMillis());
    System.out.println("两天相差的纳秒数:" + duration.toNanos());
}
```



#### 5.2、Period

（1）介绍

​	用于计算两个”日期“间隔（年、月、日）

（2）演示

```java
public static void periodTest() {
    LocalDate now = LocalDate.now();
    System.out.println("今天:" + now);

    LocalDate yestoday = LocalDate.of(2025, 7, 19);
    System.out.println("昨天:" + yestoday);

    Period period = Period.between(yestoday, now); // 后 - 前
    System.out.println("间隔多少年:" + period.getYears());
    System.out.println("间隔多少月:" + period.getMonths());
    System.out.println("间隔多少天:" + period.getDays());
    System.out.println("间隔多少总月份:" + period.toTotalMonths());
}
```



#### 5.3、ChronoUnit

（1）介绍

​	用于计算两个”日期“间隔

（2）演示

```java
public static void main(String[] args) {
    // 本地日期时间对象：此刻的
    LocalDateTime today = LocalDateTime.now();
    System.out.println(today);

    // 生日时间
    LocalDateTime birthday = LocalDateTime.of(2003, 8, 28, 0, 0, 0);
    System.out.println(birthday);

    System.out.println("相差的年数:" + ChronoUnit.YEARS.between(birthday, today));
    System.out.println("相差的月数:" + ChronoUnit.MONTHS.between(birthday, today));
    System.out.println("相差的周数:" + ChronoUnit.WEEKS.between(birthday, today));
    System.out.println("相差的天数:" + ChronoUnit.DAYS.between(birthday, today));
    System.out.println("相差的时数:" + ChronoUnit.HOURS.between(birthday, today));
    System.out.println("相差的分数:" + ChronoUnit.MINUTES.between(birthday, today));
    System.out.println("相差的秒数:" + ChronoUnit.SECONDS.between(birthday, today));
    System.out.println("相差的毫秒数:" + ChronoUnit.MILLIS.between(birthday, today));
    System.out.println("相差的微秒数:" + ChronoUnit.MICROS.between(birthday, today));
    System.out.println("相差的纳秒数:" + ChronoUnit.NANOS.between(birthday, today));
    System.out.println("相差的半天数:" + ChronoUnit.HALF_DAYS.between(birthday, today));
    System.out.println("相差的十年数:" + ChronoUnit.DECADES.between(birthday, today));
    System.out.println("相差的世纪（百年）数:" + ChronoUnit.CENTURIES.between(birthday, today));
    System.out.println("相差的千年数:" + ChronoUnit.MILLENNIA.between(birthday, today));
    System.out.println("相差的纪元数:" + ChronoUnit.ERAS.between(birthday, today));

}
```



### 6、案例

```java
// 需求 ： 键盘录入用户生日，计算出用户的实际年龄
```

```java
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入您的生日(xxxx-xx-xx):");
    String birthdya = sc.nextLine();
    sc.close();

    LocalDate bithdayDate = LocalDate.of(Integer.parseInt(birthdya.split("-")[0]),
        Integer.parseInt(birthdya.split("-")[1]),
        Integer.parseInt(birthdya.split("-")[2]));
    LocalDate todayDate = LocalDate.now();

    System.out.println("您的实际年龄:" + ChronoUnit.YEARS.between(bithdayDate, todayDate) + "岁。");
}
```

