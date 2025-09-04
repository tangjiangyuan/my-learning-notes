package com.javalearn.p1_stream;

import com.javalearn.p1_stream.domain.Actor;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test {
    /*
        综合案例 ---
            现在有两个 ArrayList集合，分别存储6名男演员和6名女演员，要求完成如下的操作：
            - 男演员只要名字为3个字的前两人
            - 女演员只要姓林的，并且不要第一个
            - 把过滤后的男演员和女演员姓名合并到一起
            - 把上一步操作后的元素作为构造方法的参数创建演员对象，遍历数据
            - 演员Actor，里面有一个成员变量，一个带参构造方法，以及成员变量对应的get/set方法
     */
    public static void main(String[] args) {
        ArrayList<String> male = new ArrayList<>(); // 男性
        ArrayList<String> female = new ArrayList<>(); // 女性

        male.add("丁真");
        male.add("吕小布");
        male.add("关谷神奇");
        male.add("周星驰");
        male.add("陆展博");
        male.add("王源");

        female.add("鞠婧祎");
        female.add("林青霞");
        female.add("林允儿");
        female.add("杨幂");
        female.add("张慧敏");
        female.add("林志玲");

        Stream<String> maleStream = male.stream().filter(s -> s.length() == 3).limit(2);
        Stream<String> femaleStream = female.stream().filter(s -> s.startsWith("林")).skip(1);

        Stream.concat(maleStream, femaleStream).forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                Actor actor = new Actor(name);
                System.out.println(actor);
            }
        });

    }


}
