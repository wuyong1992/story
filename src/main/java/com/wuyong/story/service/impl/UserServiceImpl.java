package com.wuyong.story.service.impl;

import com.wuyong.story.common.ResponseCode;
import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.User;
import com.wuyong.story.mapper.UserMapper;
import com.wuyong.story.service.UserService;
import com.wuyong.story.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * created by JianGuo
 * on 2017/12/7
 * description:
 */
@Service("userService")
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public ServerResponse login(String phone, String password) {
        if (!this.checkPhone(phone)) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.LOGIN_ERROR_PHONE_MISMATCH_RULE.getCode(), ResponseCode.LOGIN_ERROR_PHONE_MISMATCH_RULE.getDesc());
        }
        password = MD5Util.MD5EncodeUtf8(password);
        // 校验手机号对应用户是否存在，密码也校验了
        if (!this.userExisted(phone, password)) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.LOGIN_ERROR_PHONE_MISMATCH.getCode(), ResponseCode.LOGIN_ERROR_PHONE_MISMATCH.getDesc());
        }

        // todo 构建TOKEN 保存redis 返回token
        String token = "token";
        return ServerResponse.createBySuccess(token);
    }

    @Override
    public ServerResponse register(String username, String phone, String password) {
        if (username == null || phone == null || password == null) {
            return ServerResponse.createByError();
        }
        if (!this.checkPhone(phone)) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.REGISTER_ERROR_PHONE_MISMATCH_RULE.getCode(), ResponseCode.REGISTER_ERROR_PHONE_MISMATCH_RULE.getDesc());
        }

        password = MD5Util.MD5EncodeUtf8(password);
        if (!this.userExisted(phone, password)) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.REGISTER_ERROR_PHONE_EXISTED.getCode(), ResponseCode.REGISTER_ERROR_PHONE_EXISTED.getDesc());
        }

        int result = userMapper.insertUserByUsernameAndPassword(username, phone, password);
        log.info("插入结果：{}", result);
        if (result != 1) {
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccessMessage(ResponseCode.REGISTER_SUCCESS.getDesc());
    }


    /**
     * 校验手机号是否符合规范
     *
     * @param phone 手机号
     * @return true:符合 false:不符合
     */
    private Boolean checkPhone(String phone) {
        // todo 正则校验手机号
        return true;
    }


    /**
     * 检测数据库是否已经存在该手机号对应的用户
     *
     * @param phone    手机号
     * @param password 密码
     * @return true:用户已存在  false:用户不存在
     */
    private Boolean userExisted(String phone, String password) {
        Boolean flag = false;
        User user = userMapper.selectUserByUsernameAndPassword(phone, password);
        if (user != null) {
            flag = true;
        }
        return flag;
    }
}
