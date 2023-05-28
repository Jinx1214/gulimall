package com.atguigu.gulimall.oms.dao;

import com.atguigu.gulimall.oms.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author Jinx
 * @email 2649146148z@gmail.com
 * @date 2023-05-27 21:09:30
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
