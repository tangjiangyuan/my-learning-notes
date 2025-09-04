package com.tjy.mapper;

import com.tjy.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // 应用程序在运行时，会自动为改接口创建一个实现类对象(代理对象),并且会自动将改实现类对象存入IOC容器 - bean
public interface UserMapper {

    /**
     * 查询所有用户信息
     */
    // @Select("select id, username, password, name, age from user;")
    List<User> findAll();

    /**
     * 根据id删除用户
     */
    // @Delete("delete from user where id = #{id};") // #{id} 等价于 ? 也是占位符
    void deleteById(Integer id);

    /**
     * 新增用户
     */
    // 当添加字段过多时，可以考虑使用对象进行封装，再传输
    // @Insert(insert into user(username, password, name, age) values(#{username}, #{password}, #{name}, #{age}); ")
    void addUser(User user);

    /**
     * 根据id更新数据
     */
    // @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id};")
    void updateUser(User user);

    /**
     * 根据指定条件查询用户
     */
    // @Select("select * from user where username = #{username} and password = #{password};")
    User queryUser(User user);

    // @Param 注解的作用是为接口的方法形参起名字的。
    @Select("select * from user where username = #{username} and password = #{password}")
    User queryUser2(@Param("username") String username, @Param("password") String password);
}
