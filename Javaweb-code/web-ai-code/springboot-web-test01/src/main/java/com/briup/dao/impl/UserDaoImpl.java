package com.briup.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.briup.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/31 23:45
 */
// 将当前类交给 IOC容器管理
// @Component
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
        // 1. 加载并读取user.txt文件，获取用户数据
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> list = IoUtil.readLines(is, StandardCharsets.UTF_8, new ArrayList<>()); // IoUtil是hutoo-all 下的工具类
        return list;
    }
}
