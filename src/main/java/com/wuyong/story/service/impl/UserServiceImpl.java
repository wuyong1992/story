package com.wuyong.story.service.impl;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.User;
import com.wuyong.story.mapper.UserMapper;
import com.wuyong.story.service.UserService;
import com.wuyong.story.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.PAData;

/**
 * created by JianGuo
 * on 2017/12/7
 * description:
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public ServerResponse selectUser(String username, String password) {
        password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectUserByUsernameAndPassword(username, password);
        if (user == null) {
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess(user);
    }

    @Override
    public ServerResponse insertUser(String username, String password) {
        if (username == null || password == null) {
            return ServerResponse.createByError();
        }
        password = MD5Util.MD5EncodeUtf8(password);
        // todo 先查username是否存在
        int result = userMapper.insertUserByUsernameAndPassword(username, password);
        log.info("插入结果：{}", result);
        if (result != 1) {
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccess();
    }
}
