package com.wuyong.story.service;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.User;

/**
 * created by JianGuo
 * on 2017/12/7
 * description:
 */
public interface UserService {

    ServerResponse selectUser(String username, String password);

    ServerResponse insertUser(String username, String password);

}
