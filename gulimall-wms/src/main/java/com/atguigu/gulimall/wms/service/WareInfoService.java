package com.atguigu.gulimall.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.wms.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author Jinx
 * @email 2649146148z@gmail.com
 * @date 2023-05-27 21:43:06
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

