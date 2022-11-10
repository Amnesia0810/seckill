package com.amnesia.seckill.service;

import com.amnesia.seckill.exception.GlobalException;
import com.amnesia.seckill.pojo.User;
import com.amnesia.seckill.vo.LoginVo;
import com.amnesia.seckill.vo.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author amnesia
 * @since 2022年11月04日
 */
public interface UserService extends IService<User> {
    @SneakyThrows
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) ;
}
