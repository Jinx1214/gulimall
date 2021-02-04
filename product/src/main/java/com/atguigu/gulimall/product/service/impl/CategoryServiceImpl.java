package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithtree() {
        //第一步先获取所有集合
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //第二步进行封装
        
        List<CategoryEntity> ca = entities.stream().filter((enety)->enety.getParentCid()==0).map((meau)->{
            meau.setChildren(getlist(meau,entities));
            return meau;
        }).collect(Collectors.toList());

       /* List<CategoryEntity> level1= new ArrayList<>();
        for (CategoryEntity entity : entities) {
            if(entity.getParentCid()==0){
                entity.setChildren(getlist(entity,entities));
                level1.add(entity);
            }
        }*/

        return ca;
    }

    @Override
    public void removeByMeauIds(Long[] catIds) {
        baseMapper.deleteBatchIds(Arrays.asList(catIds));
    }

    public List<CategoryEntity> getlist(CategoryEntity  root,List<CategoryEntity> all){
        List<CategoryEntity> collect = all.stream().filter((enety) -> enety.getParentCid() == root.getCatId()).map((meau)->{
            meau.setChildren(getlist(meau,all));
            return meau;
        }).collect(Collectors.toList());
        return  collect;
    }
    /*public List<CategoryEntity> getlist123(CategoryEntity  root,List<CategoryEntity> all){
        root.setChildren(new ArrayList<>());
        List<CategoryEntity> alls = new ArrayList<>();
        for (CategoryEntity categoryEntity : all) {
            if(categoryEntity.getParentCid()==root.getCatId()){
                alls.add(categoryEntity);
            }
        }
        return alls;
    }*/




}