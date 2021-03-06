package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("coupon")
public interface couponServiceFeign {

    @RequestMapping("/coupon/coupon/getCoupon")
    public R get();
}
