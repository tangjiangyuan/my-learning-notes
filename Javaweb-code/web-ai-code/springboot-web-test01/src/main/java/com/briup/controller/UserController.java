package com.briup.controller;

import com.briup.bean.User;
import com.briup.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/31 16:35
 */
@SuppressWarnings("ALL")
// @ResponseBody -> 作用: 将controller返回值直接作为响应体的数据直接响应。返回值是集合/对象 -> json在返回
@RestController
public class UserController {

    /* 1. 属性注入 */
    /*@Autowired
    private UserService userService;*/

    /* 2. 构造函数注入 */
    /*private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }*/

    /* 3. .setter注入 */
    private UserService userService;
    @Resource(name = "userServiceImpl2")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public List<User> list() throws Exception {
        List<User> userList = userService.findAll();
        // 3. 返回数据（json）会将类型自动转换为 json类型
        return userList;
    }
}

//    @RequestMapping("/list")
//    public List<User> list() throws Exception {
//        // 1. 加载并读取user.txt文件，获取用户数据
//        InputStream is = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        ArrayList<String> list = IoUtil.readLines(is, StandardCharsets.UTF_8, new ArrayList<>()); // IoUtil是hutoo-all 下的工具类
//        // 2. 解析用户信息，封装为User对象 -> list集合
//        List<User> userList = list.stream().map(lines -> {
//            String[] msg = lines.split(",");
//            Integer id = Integer.parseInt(msg[0]);
//            String username = msg[1];
//            String password = msg[2];
//            String name = msg[3];
//            Integer age = Integer.parseInt(msg[4]);
//            LocalDateTime updateTime = LocalDateTime.parse(msg[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            return new User(id, username, password, name, age, updateTime);
//        }).collect(Collectors.toList());
//
//        // 3. 返回数据（json）会将类型自动转换为 json类型
//        return userList;
//    }
