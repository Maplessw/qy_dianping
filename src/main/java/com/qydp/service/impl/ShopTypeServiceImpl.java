package com.qydp.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.qydp.dto.Result;
import com.qydp.entity.ShopType;
import com.qydp.mapper.ShopTypeMapper;
import com.qydp.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qydp.utils.RedisConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryTypeList() {
        String listStr = stringRedisTemplate.opsForValue().get(RedisConstants.CACHE_SHOP_TYPE_LIST);
        //redis里有缓存，直接返回
        if(StrUtil.isNotBlank(listStr)){
            return Result.ok(JSONUtil.toList(listStr,ShopType.class));
        }
        //没有缓存，对数据库进行查询
        List<ShopType> typeList = query().orderByAsc("sort").list();
        //数据不存在数据库中
        if(typeList == null){
            return Result.fail("分类数据不存在");
        }
        //数据存在，将数据存入redis进行缓存
        stringRedisTemplate.opsForValue().set(RedisConstants.CACHE_SHOP_TYPE_LIST,JSONUtil.toJsonStr(typeList));
        //返回分类数据
        return Result.ok(typeList);
    }

}
