package com.tjy;

import com.tjy.mapper.UserMapper;
import com.tjy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // SpringBoot单元测试的注解-当前测试类中的测试方法运行时，会启动springboot项目-IOC容器就创建好了
class MybatisDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询测试
     */
    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    /**
     * 根据id删除测试
     */
    @Test
    public void testDeleteById() {
        userMapper.deleteById(6);
    }

    /**
     * 添加用户测试
     */
    @Test
    public void testAddUser() {
        userMapper.addUser(new User(null, "luban", "1234567", "鲁班", 20));
    }

    /**
     * 更新用户测试
     */
    @Test
    public void testUpdateUser() {
        userMapper.updateUser(new User(7, "zhugeliang", "12345678", "诸葛亮", 20));
    }

    /**
     * 根据指定条件查询用户
     */
    @Test
    public void testQueryUser() {
        User user = userMapper.queryUser(new User(null, "daqiao", "123456", null, null));
        System.out.println(user);
    }

    @Test
    public void testQueryUser2() {
        User user = userMapper.queryUser2("zhugeliang", "12345678");
        System.out.println(user);
    }
}
