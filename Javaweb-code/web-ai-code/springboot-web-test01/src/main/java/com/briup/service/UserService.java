package com.briup.service;

import com.briup.bean.User;

import java.util.List;

public interface UserService {
    /* 处理用户信息 */
    List<User> findAll();
}
