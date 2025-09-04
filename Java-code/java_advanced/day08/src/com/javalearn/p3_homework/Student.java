package com.javalearn.p3_homework;

public class Student {

    private String name;
    private int age;
    private double MathScore;
    private double ChineseScore;
    private double EnglishScore;

    public Student() {
    }

    public Student(String name, int age, double MathScore, double ChineseScore, double EnglishScore) {
        this.name = name;
        this.age = age;
        this.MathScore = MathScore;
        this.ChineseScore = ChineseScore;
        this.EnglishScore = EnglishScore;
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
        try {
          if (age >= 0 && age <= 120) {
              this.age = age;
          } else {
              throw new AgeRangeException("年龄范围出错！");
          }
        } catch (AgeRangeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("年龄类型错误，因该是整数类型！");
        }

    }

    /**
     * 获取
     * @return MathScore
     */
    public double getMathScore() {
        return MathScore;
    }

    /**
     * 设置
     * @param MathScore
     */
    public void setMathScore(double MathScore) {
        try {
            if (MathScore >= 0 && MathScore <= 100) {
                this.MathScore = MathScore;
            } else {
                throw new ScoreRangeException("成绩范围错误！");
            }
        } catch (ScoreRangeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("成绩类型错误！");
        }
    }

    /**
     * 获取
     * @return ChineseScore
     */
    public double getChineseScore() {
        return ChineseScore;
    }

    /**
     * 设置
     * @param ChineseScore
     */
    public void setChineseScore(double ChineseScore) {
        try {
            if (ChineseScore >= 0 && ChineseScore <= 100) {
                this.ChineseScore = ChineseScore;
            } else {
                throw new ScoreRangeException("成绩范围错误！");
            }
        } catch (ScoreRangeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("成绩类型错误！");
        }
    }

    /**
     * 获取
     * @return EnglishScore
     */
    public double getEnglishScore() {
        return EnglishScore;
    }

    /**
     * 设置
     * @param EnglishScore
     */
    public void setEnglishScore(double EnglishScore) {
        try {
            if (EnglishScore >= 0 && EnglishScore <= 100) {
                this.EnglishScore = EnglishScore;
            } else {
                throw new ScoreRangeException("成绩范围错误！");
            }
        } catch (ScoreRangeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("成绩类型错误！");
        }
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + ", MathScore = " + MathScore + ", ChineseScore = " + ChineseScore + ", EnglishScore = " + EnglishScore + "}";
    }
}
