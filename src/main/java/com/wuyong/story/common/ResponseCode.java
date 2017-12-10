package com.wuyong.story.common;

/**
 * Created by 坚果
 * on 2017/9/16
 * 返回的状态码
 */
public enum ResponseCode {

    /* 0 成功 */
    SUCCESS(0, "SUCCESS"),

    /* 1 错误 */
    ERROR(1, "ERROR"),

    /* 100** 注册/登录 返回结果 */
    REGISTER_SUCCESS(10000, "注册成功"),
    REGISTER_ERROR(10001, "参数失败"),
    REGISTER_ERROR_PHONE_MISMATCH_RULE(100011, "注册失败，手机号不符合格式要求"),
    REGISTER_ERROR_PHONE_EXISTED(100012, "注册失败，该手机号已存在"),

    LOGIN_SUCCESS(10010, "登录成功"),
    LOGIN_ERROR(10011, "登录失败"),
    LOGIN_ERROR_PHONE_MISMATCH(100111, "登录失败,手机号不存在"),
    LOGIN_ERROR_PHONE_MISMATCH_RULE(100112, "登录失败,手机号不存在"),
    LOGIN_ERROR_PASSWORD_MISMATCH(100113, "登录失败,密码错误"),

    /* 2000*token错误 */
    TOKEN_ERROR(20000,"token错误"),

    TOKEN_ERROR_MISMATCH_RULE(20001,"token不匹配"),

    TOKEN_ERROR_EXPIRED(20002,"token过期"),

            ;


    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
    }
