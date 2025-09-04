package com.javalearn.test;

import java.util.Scanner;

public class MovieService {

    private Movie[] movies;

    private Scanner sc = new Scanner(System.in);

    public MovieService(Movie[] movies) {
        this.movies = movies;// 传过来的数据是局部变量，通过给全局变量赋值，就可以在其他方法中使用局部变量的数据了
    }

    /**
     * 启动电影信息管理系统
     */
    public void star() {

        lo:
        while (true) {
            System.out.println("--------电影信息系统--------");
            System.out.println("1. 查询全部电影信息");
            System.out.println("2. 根据id查询电影信息");
            System.out.println("3. 退出");
            System.out.println("请输入您的选择 :");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    queryMovieInfos();
                    break;
                case 2:
                    queryMovieInfoById();
                    break;
                case 3:
                    System.out.println("欢饮您的使用！");
                    break lo;
                default:
                    System.out.println("输入有误，请重新输入！！！");
            }
        }
    }

    /**
     * 通过id查询电影信息
     */
    private void queryMovieInfoById() {

        System.out.println("请输入电影ID :");
        int id = sc.nextInt();

        /*switch (id) {
            case 1:
            case 2:
            case 3:
                System.out.println(movies[id-1].getTitle() + "---" + movies[id-1].getTime() + "---" + movies[id-1].getScore() + "---"
                        + movies[id-1].getArea() + "---" + movies[id-1].getType() + "---" + movies[id-1].getDirector() + "---"
                        + movies[id-1].getStarring());
                break;
            default:
                System.out.println("输入错误，请重试！！！");
                break;
        }*/
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            if (id == movie.getId()) {
                System.out.println(movie.getTitle() + "---" + movie.getTime() + "---" + movie.getScore()
                        + "---" + movie.getArea() + "---" + movie.getType() + "---" + movie.getDirector()
                        + "---" + movie.getStarring()
                );
                return;
            }
        }
        // 没有找到
        System.out.println("抱歉，没有找到该id的电影信息！");

    }

    /**
     * 展示电影的全部信息（名称、评分）
     */
    private void queryMovieInfos() {
        // 1. 遍历数组，取出每一个电影对象
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            // System.out.println(movie);  打印对象名，会看到内存地址
            // 2. 通过电影对象，调用内部getXxx方法，获取信息并打印
            System.out.println(movie.getTitle() + "---" + movie.getScore());
        }
    }
}
