package com.amnesia.seckill.service.impl;

import com.amnesia.seckill.pojo.Order;
import com.amnesia.seckill.mapper.OrderDao;
import com.amnesia.seckill.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author amnesia
 * @since 2022年11月04日
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

}
