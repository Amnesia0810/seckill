package com.amnesia.seckill.service.impl;

import com.amnesia.seckill.common.RespBeanEnum;
import com.amnesia.seckill.exception.GlobalException;
import com.amnesia.seckill.pojo.User;
import com.amnesia.seckill.mapper.UserDao;
import com.amnesia.seckill.service.UserService;
import com.amnesia.seckill.utils.CookieUtil;
import com.amnesia.seckill.utils.MD5Util;
import com.amnesia.seckill.utils.UUIDUtil;
import com.amnesia.seckill.vo.LoginVo;
import com.amnesia.seckill.vo.RespBean;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author amnesia
 * @since 2022年11月04日
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    @SneakyThrows
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        User user = userDao.selectById(mobile);
        if(null==user) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        if(!MD5Util.fromPassToDbPass(password,user.getSalt()).equals(user.getPassword())) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        String ticket = UUIDUtil.uuid();
        request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success();
    }
}
