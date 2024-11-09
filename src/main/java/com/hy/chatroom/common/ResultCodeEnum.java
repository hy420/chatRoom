package com.hy.chatroom.common;


import lombok.Getter;

/**
 * 统一返回结果状态信息类
 *
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    ARGUMENT_VALID_ERROR(210, "参数校验异常"),
    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),
    ;

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
