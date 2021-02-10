package com.atguigu.gulimall.product.exceprtion;

import com.atguigu.common.utils.R;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/*
* 统一异常处理类
*
* */
@RestControllerAdvice
public class ExceptionAdviceHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R methodArgumentAdvice(MethodArgumentNotValidException exception){
        Map<String,Object> map = new HashMap<>();
        BindingResult bindingResult = exception.getBindingResult();
        bindingResult.getAllErrors().forEach((item)->{
            String defaultMessage = item.getDefaultMessage();
            String code = item.getCode();
            map.put("code",code);
            map.put("message",defaultMessage);
        });
        return  R.error().put("data",map);
    }
}

