package com.javalearn.p1_generics;

import java.util.ArrayList;

public class GenericsDemo5 {
    /*
        泛型通配符
                ? : 任意类型(不推荐)
                ? extends E : 可以传入的是 E 或者是 E 的子类。
                ? super E : 可以传入的是 E 或者是 E 的父类。
     */
    public static void main(String[] args) {

        ArrayList<Coder> list1 = new ArrayList<>();
        list1.add(new Coder());

        ArrayList<Manager> list2 = new ArrayList<>();
        list2.add(new Manager());

        method(list1);
        method(list2);
    }

    // ? extends Employee 限定了只能使用Employee这个体系中的类型(Coder、Manager)
    public static void method(ArrayList<? extends Employee> list) {
        for (Object o : list) {
            Employee e = (Employee) o;
            e.work();
        }
    }
}

abstract class Employee {
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract void work();

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Employee{name = " + name + ", salary = " + salary + "}";
    }
}

class Coder extends Employee {

    @Override
    public void work() {
        System.out.println("程序员写代码");
    }
}

class Manager extends Employee {

    @Override
    public void work() {
        System.out.println("管理员管理员工");
    }
}