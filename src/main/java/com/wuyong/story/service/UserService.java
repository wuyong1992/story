package com.wuyong.story.service;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.User;

/**
 * created by JianGuo
 * on 2017/12/7
 * description:
 */
public interface UserService {


    ServerResponse login(String phone, String password);

    ServerResponse register(String username, String phone, String password);



}
