package com.javalearn.distinction;

import java.time.LocalDateTime;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        // JDK8版本之前：
        // 都是可变对象，修改后会丢失最开始的时间信息
        Date time = new Date();
        System.out.println("修改前获取时间:" + time);
        // 修改后
        time.setTime(1000);
        System.out.println("修改后获取时间:" + time);

        System.out.println("------------------------------");

        // JDK8版本之后：
        // 都是不可变休想，修改后会返回新的时间对象，不会丢失最开始的时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("修改前获取时间:" + now);

        LocalDateTime afterTime = now.withYear(2008);
        System.out.println("修改后获取时间:" + afterTime);
        System.out.println("修改后获取时间:" + now);
    }
}
