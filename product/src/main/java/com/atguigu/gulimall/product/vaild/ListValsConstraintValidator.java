package com.atguigu.gulimall.product.vaild;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

public class ListValsConstraintValidator implements ConstraintValidator<Listvals,Integer> {

    private Set<Integer> setInt = new HashSet<>();

    @Override
    public void initialize(Listvals constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        if(vals==null){
            throw new RuntimeException();
        }
        for (int val : vals) {
            setInt.add(val);
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return setInt.contains(value);
    }
}
