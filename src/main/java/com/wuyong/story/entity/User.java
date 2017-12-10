package com.wuyong.story.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * created by JianGuo
 * on 2017/12/7
 * description: 用户类，主要处理个人后台登录
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer userId;
    /* 用户名 */
    private String username;
    /* 手机号 登录账号 */
    private String phone;
    /* 登录密码 */
    private String password;

    private Date createTime;
    private Date updateTime;
}
