package com.atguigu.gulimall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.ums.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author Jinx
 * @email 2649146148z@gmail.com
 * @date 2023-05-27 21:44:43
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

