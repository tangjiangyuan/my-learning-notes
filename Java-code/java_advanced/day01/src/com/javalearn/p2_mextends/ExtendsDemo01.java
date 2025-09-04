package com.javalearn.p2_mextends;

public class ExtendsDemo01 {
    public static void main(String[] args) {
        Coder c = new Coder();
        c.setName("张三");
        c.setAge(22);
        c.setSalary(12000.0);
        System.out.println(c.getName() + "---" + c.getAge() + "---" + c.getSalary());
    }
}
class Employee {
    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class Coder extends Employee{

}
class Manager extends Employee{

}
