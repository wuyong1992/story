package com.wuyong.story.common;

/**
 * Created by 坚果
 * on 2017/9/16
 * 返回的状态码
 */
public enum ResponseCode {

    /** 0 成功 */
    SUCCESS(0, "SUCCESS"),

    /** 1 错误 */
    ERROR(1, "ERROR"),

    /** 2 参数错误 */
    ILLEGAL_ARGUMENT(2,"参数错误"),

    /** 3 保存错误 */
    SAVE_EXCEPTIONS(3,"保存错误"),

    /** 4 删除错误 */
    DEL_EXCEPTIONS(4,"删除错误"),

    /** 5 用户已存在 */
    USER_EXIST(5,"用户已存在"),

    /** 6 用户不存在 */
    USER_NO_EXIST(5,"用户不存在"),

    /** 7 用户不存在 */
    PASSWORD_ERROR(7,"密码错误"),

    /** 8 token错误 */
    TOKEN_ERROR(8,"token错误"),

    /** 9 保存错误 */
    UPDATE_EXCEPTIONS(9,"更新错误"),
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
