package com.amnesia.seckill.controller;


import com.amnesia.seckill.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author amnesia
 * @since 2022年11月04日
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @RequestMapping("/toList")
    public String toList(HttpSession session, Model model, @CookieValue("userTicket") String ticket) {
        if(StringUtils.isEmpty(ticket)) {
            return "login";
        }
        User user = (User) (session.getAttribute(ticket));
        if(null == user ) {
            return "login";
        }
        model.addAttribute("user",user);
        return "goodsList";
    }
}

