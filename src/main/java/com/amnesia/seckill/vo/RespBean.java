package com.amnesia.seckill.vo;

import com.amnesia.seckill.common.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private int code;
    private String msg;
    private Object obj;
    public static RespBean success() {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMsg(),null);
    }
    public static RespBean success(Object obj) {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMsg(),obj);
    }
    public static RespBean error(RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMsg(),null);
    }
    public static RespBean error(RespBeanEnum respBeanEnum,Object obj) {
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMsg(),obj);
    }
}
