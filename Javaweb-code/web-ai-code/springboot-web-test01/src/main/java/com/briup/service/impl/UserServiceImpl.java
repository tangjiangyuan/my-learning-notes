package com.briup.service.impl;

import com.briup.bean.User;
import com.briup.dao.UserDao;
import com.briup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/31 23:47
 */
//@Component
@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {

    @Autowired // 应用程序运行时，会自动的查询该类型的bean对象，并赋值给该成员变量
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        List<String> list = userDao.findAll();
        // 2. 解析用户信息，封装为User对象 -> list集合
        List<User> userList = list.stream().map(lines -> {
            String[] msg = lines.split(",");
            Integer id = Integer.parseInt(msg[0]);
            String username = msg[1];
            String password = msg[2];
            String name = msg[3];
            Integer age = Integer.parseInt(msg[4]);
            LocalDateTime updateTime = LocalDateTime.parse(msg[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList());

        return userList;
    }
}
