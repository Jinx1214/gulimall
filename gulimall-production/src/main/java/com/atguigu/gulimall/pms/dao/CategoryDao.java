package com.atguigu.gulimall.pms.dao;

import com.atguigu.gulimall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author Jinx
 * @email 2649146148z@gmail.com
 * @date 2023-05-27 21:41:55
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
