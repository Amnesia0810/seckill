package com.amnesia.seckill.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum RespBeanEnum {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"ERROR"),
    LOGIN_ERROR(50010,"用户名或密码错误");
    private int code;
    private String msg;
}
