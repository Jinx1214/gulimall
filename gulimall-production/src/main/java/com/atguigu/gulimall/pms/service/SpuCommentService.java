package com.atguigu.gulimall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.pms.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author Jinx
 * @email 2649146148z@gmail.com
 * @date 2023-05-27 21:41:55
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

