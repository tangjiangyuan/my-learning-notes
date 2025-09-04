package com.javalearn.test;

public class MovieTest {
    /*
        需求 ：
        1. 展示系统中的全部电影（每部电影展示：名称、评分）。
        2. 允许用户根据电影编号（id）查询出某个电影的详细信息。
     */
    public static void main(String[] args) {

        Movie movie1 = new Movie(1,"东八区的先生们","2022",2.1,"中国大陆","剧情 戏剧","夏睿","张翰 王晓晨");
        Movie movie2 = new Movie(2,"上海堡垒","2019",2.9,"中国大陆","爱情 战争 科幻","滕华涛","鹿晗 舒淇");
        Movie movie3 = new Movie(3,"纯洁心灵·逐梦演艺圈","2015",2.2,"中国大陆","剧情 戏剧","毕志飞","朱一文 李彦漫");

        Movie[] movies = {movie1, movie2, movie3};

        // 如何将一个类中的数据，传递给另外一个类
        MovieService movieService = new MovieService(movies);
        movieService.star();
    }
}
