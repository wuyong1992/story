package com.wuyong.story.controller;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.User;
import com.wuyong.story.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by JianGuo
 * on 2017/12/7
 * description: 用户控制器
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login")
    private ServerResponse login(String username, String password) {
        return userService.selectUser(username, password);
    }

    @RequestMapping(value = "register")
    private ServerResponse register(String username, String password) {
        return userService.insertUser(username, password);
    }
}
