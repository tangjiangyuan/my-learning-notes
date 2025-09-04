package com.javalearn.p3_homework;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        final int STUDENT_COUNT = 3;

        for (int i = 0; i < STUDENT_COUNT; i++) {

            System.out.println("请输入第" + (i + 1) + "名学生的姓名:");
            String name = sc.nextLine();

            int age = getValidInput(sc, "年龄", "请输入第" + (i + 1) + "名学生的年龄:", 0, 120);
            double mathScore = getValidInput(sc, "数学成绩", "请输入第" + (i + 1) + "名学生的数学成绩:", 0.0, 100.0);
            double chineseScore = getValidInput(sc, "语文成绩", "请输入第" + (i + 1) + "名学生的语文成绩:", 0.0, 100.0);
            double englishScore = getValidInput(sc, "英语成绩", "请输入第" + (i + 1) + "名学生的英语成绩:", 0.0, 100.0);

            Student stu = new Student(name, age, mathScore, chineseScore, englishScore);
            list.add(stu);
        }

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getName() + "---" + stu.getAge() + "---"
                    + stu.getMathScore() + "---" + stu.getChineseScore() + "---" + stu.getEnglishScore());
        }

        sc.close();
    }

    private static int getValidInput(Scanner sc, String inputType, String prompt, int min, int max) {
        while (true) {
            System.out.println(prompt);
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    throw new AgeRangeException(inputType + "范围错误，应为" + min + "~" + max + "之间，请重新输入！");
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println(inputType + "类型错误，应为整数！");
            } catch (AgeRangeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double getValidInput(Scanner sc, String inputType, String prompt, double min, double max) {
        while (true) {
            System.out.println(prompt);
            try {
                double input = Double.parseDouble(sc.nextLine());
                if (input < min || input > max) {
                    throw new ScoreRangeException(inputType + "范围错误，应为" + min + "~" + max + "之间，请重新输入！");
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println(inputType + "类型错误，应为数字！");
            } catch (ScoreRangeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
