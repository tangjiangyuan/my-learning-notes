package com.java_learn.p4_reflect.exer02.test;

import com.java_learn.p4_reflect.exer02.domain.Student;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 22:31
 */
public class ReflectTest {
    /*
        练习 --- 反射练习
        编写三个任意的 Javabean类，Student类、Teacher类、Worker类
        属性为: name,age
        方法要求:
            Student里面写学习study和吃饭eat的方法(方法无参返回)
            Teacher里面写学习teach和吃饭eat的方法(方法无参返回)
            Worker里面写学习work和吃饭sleep的方法(方法无参返回)
        本地新建配置文件properties
            属性 : className = Student类的全类名  methodName = study
        在测试类中读取 properties文件中的两个属性值
        利用反射创建学生类的对象，并调用方法
        修改配置文件，不修改代码，运行老师类中的上课方法
        修改配置文件，不修改代码，运行工人类中的工作方法
     */
    public static void main(String[] args) throws Exception {
        // 1. 加载配置文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("info.properties");
        // 2. 创建 Properties集合，加载数据
        Properties prop = new Properties();
        prop.load(is);
        is.close();
        // 3. 获取数据
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");
        // 4. 获取类的字节码对象
        Class<?> aClass = Class.forName(className);
        // 5. 反射构造方法对象
        Object o = aClass.getConstructor().newInstance();
        // 6. 反射成员方法对象
        Method method = aClass.getMethod(methodName);
        // 7. 让方法执行
        method.invoke(o);
    }
}
