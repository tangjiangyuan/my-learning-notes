package com.tjy.controller;

import com.tjy.pojo.Emp;
import com.tjy.pojo.LoginInfo;
import com.tjy.pojo.Result;
import com.tjy.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @date 2025/8/13 15:41
 * msg:登录功能
 */
@Slf4j
@SuppressWarnings("all")
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    /**
     * 登录功能
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录:{}", emp);
        LoginInfo info =  empService.login(emp);
        // 判断返回的信息是否为空
        if (info != null) {
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }
}
