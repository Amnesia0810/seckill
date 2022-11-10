package com.amnesia.seckill.exception;

import com.amnesia.seckill.common.RespBeanEnum;
import com.amnesia.seckill.vo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public RespBean exceptionHandler(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException ge = (GlobalException) e;
            return RespBean.error(ge.getRespBeanEnum());
        } else if (e instanceof BindException) {
            BindException be = (BindException) e;
            RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }
}
