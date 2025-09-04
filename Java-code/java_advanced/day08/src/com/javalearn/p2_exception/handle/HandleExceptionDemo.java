package com.javalearn.p2_exception.handle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HandleExceptionDemo {
    /*
        异常处理方式 ：
                1. try...catch 捕获异常
                    好处 ： 异常对象可以被捕获，后续的代码可以继续执行
                    格式 ：
                        try {
                            可能会出现异常的代码
                        } catch(异常名称 对象名) {
                            异常的处理方案
                        }

                    执行流程 ：
                        1. 执行 try {} 中的代码，看是否有异常对象产生
                        2. 没有 ： catch 就不会捕获，后续代码继续执行
                        3. 有 ： catch 捕获异常对象，执行catch {} 中的处理方案，后续代码继续执行

                2. throws 抛出异常

          ---------------------------------------------------------------------------------

          问题 ： 正在面临的异常，是否需要暴露出来
                    - 不需要暴露出来 ： try...catch 捕获
                    - 需要暴露出来 ： throws 抛出异常

          - 如果是别的程序员，调用我们所编写的方法时，在可能出错的地方，使用throws将异常抛出给调用者，告诉他为什么错了
          - 如果是用户，在使用我们的程序时，不能将异常展现给用户，就要使用try...catch捕获异常
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        throwsDemo();
    }

    private static void throwsDemo() throws ParseException, FileNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = sdf.parse("abc");
        System.out.println(date);

        FileReader fr = new FileReader("F://a.txt");
    }

    private static void tryCatchDemo() {
        System.out.println("开始");

        try {
            int[] arr = null;
            System.out.println(arr[10]);
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {   // ArithmeticException e = new ArithmeticException();
            System.out.println("捕获到了运算异常！");
        } catch (NullPointerException e) {  // NullPointerException e = new NullPointerException();
            System.out.println("捕获了空指针异常！");
        } catch (Exception e) {
            System.out.println("捕获了异常！");
        }

        System.out.println("结束");
    }
}
