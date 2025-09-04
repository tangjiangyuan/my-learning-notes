package com.javalearn.test3;

public class Test {
    /*
        案例 ---
            -- 程序员类
            成员变量：姓名，年龄，工资
            成员方法：work方法
            姓名为张三，年龄为23，工资为15000的程序员正在编写代码

            -- 项目经理类
            成员变量：姓名，年龄，工资，奖金
            成员方法：work方法
            姓名为李四，年龄为24，工资为18000，奖金为5000的项目经理正在分配任务。。。
     */
    public static void main(String[] args) {
        Coder coder = new Coder("张三", 23, 15000);
        coder.work();

        Manager manager = new Manager("李四", 24, 18000, 5000);
        manager.work();
    }
}
