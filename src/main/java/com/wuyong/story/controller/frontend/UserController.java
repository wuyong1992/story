package com.wuyong.story.controller.frontend;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by JianGuo
 * on 2017/12/10
 * description: 前端用户登录控制器
 */
@RestController
@RequestMapping(value = "/frontend/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login")
    private ServerResponse login(String phone, String password) {
        return userService.login(phone, password);
    }

    @RequestMapping(value = "register")
    private ServerResponse register(String username, String phone, String password) {
        return userService.register(username, phone, password);
    }
}
