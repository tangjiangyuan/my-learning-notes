package com.javalearn.p1_stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo2 {
    /*
        Stream流的中间操作方法
            - 操作后返回Stream对象，可以继续操作

            Stream<T> filter(Predicate<? super T> predicate) : 用于对流中的数据进行过滤
            Stream<T> limit(long maxSize) : 获取前几个元素
            Stream<T> skip(long n) : 跳过前几个元素
            Stream<T> distinct() : 去除流中重复的元素依赖 (hashCode 和 equals 方法)
            static <T> Stream<T> concat(Stream a, Stream b) : 合并 a 和 b 两个流为一个流

                --- 注意事项 : 流对象已经被消费过(使用过)，就不允许再次消费了
     */
    public static void main(String[] args) {
        // 需求 --- 将集合中以 [张] 开头的数据，过滤出来并打印在控制台
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("张慧敏");
        list.add("赵敏");
        list.add("张无忌");

        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
        System.out.println("------------");

        // 需求1 --- 取前3个数据在控制台
        list.stream().limit(3).forEach(s -> System.out.println(s));
        System.out.println("------------");

        // 需求2 --- 跳过3个元素，把剩下的元素在控制台输出
        list.stream().skip(3).forEach(s -> System.out.println(s));
        System.out.println("------------");

        // 需求3 --- 跳过2个元素，把剩下的元素中前2个在控制台输出
        list.stream().skip(2).limit(2).forEach(s -> System.out.println(s));
        System.out.println("------------");

        // 需求4 --- 取前4个数据组成一个流
        Stream<String> limitStream = list.stream().limit(4);

        // 需求5 --- 跳过2个数据组成一个流
        Stream<String> skipStream = list.stream().skip(2);

        // 需求6 --- 合并需求4和需求5得到的流，并把结果在控制台输出
        Stream<String> stream = Stream.concat(limitStream, skipStream);
        // stream.forEach(s -> System.out.println(s));
        System.out.println("------------");

        // 需求7 --- 合并需求4和需求5得到的流，并把结果在控制台输出，要求字符串元素不能重复
        stream.distinct().forEach(s -> System.out.println(s));
    }
}
