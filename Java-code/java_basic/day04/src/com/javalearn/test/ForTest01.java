package com.javalearn.test;

public class ForTest01 {
    public static void main(String[] args) {
        int result = forTest5();
        System.out.println("水仙花数的个数为：" + result);
    }

    // 需求：使用循环，在控制台打印出10次黑马程序员
    public static void forTest1(int n) {

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                System.out.println("黑马程序员");
            }
        } else {
            System.out.println("输入错误！");
        }

    }

    // 案例：模拟计时器
    // 需求：使用循环在控制台打印数字1-3和3-1的数据
    public static void forTest2() {

        for (int i = 1; i <= 3; i++) {// 积累思路：循环中控制循环的那个变量，可以在循环中，继续使用
            System.out.println(i);
        }

        System.out.println("-----------");

        for (int j = 3; j >= 1; j--) {
            System.out.println(j);
        }
    }

    // 案例：求和
    // 需求：求1~100之间的偶数和，并把求和结果在控制台输出
    public static int forTest3() {

        int sum = 0;
        /*for (int i = 1;i <= 100;i++){
            if (i % 2 == 0){
                sum += i;
                // System.out.println(sum);
            }
        }*/
        for (int i = 2; i <= 100; i += 2) {
            sum += i;
        }
        return sum;
    }

    // 案例：水仙花数
    /*
     *  需求：在控制台输出所有的“水仙花数”
     *  什么是“水仙花数”？
     *  ① 水仙花数是一个三位数
     *  ② 水仙花的个位、十位、百位数字的立方和等于原数
     * */
    public static void forTest4() {
        // 1. 拿到所有三位数
        for (int i = 100; i <= 999; i++) {
            // 2. 得到每个三位数的个位、十位、百位
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100;
            // 3. 判断
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                // 4. 打印
                System.out.println(i + "是水仙花数");
            }
        }
    }

    // 案例：统计水仙花数
    // 需求：在控制台输出所有的”水仙花数“，并统计出水仙花数的个数
    public static int forTest5() {
        // 1. 定义一个变量，接收水仙花的个数
        int num = 0;
        // 2. 得到所有三位数
        for (int i = 100; i <= 999; i++) {
            // 3. 得到每个三位数的个位、十位、百位
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100;
            // 4. 判断水仙花数
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                System.out.println(i);
                // 5. 每判断出一个水仙花数，变量+1
                num++;
            }
        }
        // 6. 返回变量
        return num;
    }
}
