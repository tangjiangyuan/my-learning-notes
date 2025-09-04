package com.javalearn.domain;

public class Student implements Comparable<Student>{

    // Comparable<T> 中的泛型是需要比较对象的类型
    // 例如，学生和学生作比较，类型就是Student

    private String name;
    private int age;

    // this.xxx - o.xxx 正序
    // o.xxx - this.xxx 倒叙
    @Override
    public int compareTo(Student o) {
        // 根据年龄做主要排序条件
        int ageResult = this.age - o.age;
        // 根据姓名做次要排序条件
        int nameResult = ageResult == 0 ? o.name.compareTo(this.name) : ageResult;
        // 判断姓名是否相同  极端情况 ：存在同名同年龄的学生，也需要保存下来（1或-1都可以）。
        // 如果有id则不考虑这种情况
        int result = nameResult == 0 ? 1 : nameResult;
        return result;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

}
