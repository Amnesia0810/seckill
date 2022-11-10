package com.amnesia.seckill.mapper;

import com.amnesia.seckill.pojo.SeckillOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 秒杀订单表 Mapper 接口
 * </p>
 *
 * @author amnesia
 * @since 2022年11月04日
 */
@Mapper
public interface SeckillOrderDao extends BaseMapper<SeckillOrder> {

}
