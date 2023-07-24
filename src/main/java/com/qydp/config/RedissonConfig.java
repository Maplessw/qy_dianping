package com.qydp.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: JavaCode
 * @description:
 * @author: Maple
 * @create: 2023-07-24 15:36
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient(){
        //配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.174.132:6379").setPassword("ssw200212");
        //创建RedissonClient对象
        return Redisson.create();
    }

}
