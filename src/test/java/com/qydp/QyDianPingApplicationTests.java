package com.qydp;

import com.qydp.entity.Shop;
import com.qydp.service.impl.ShopServiceImpl;
import com.qydp.utils.CacheClient;
import com.qydp.utils.RedisConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.cache.RedisCache;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class QyDianPingApplicationTests {

    @Autowired
    private CacheClient cacheClient;

    @Autowired
    private ShopServiceImpl shopService;

    @Test
    void testSaveShop() throws InterruptedException {
        shopService.saveShop2Redis(1L,10L);

        Shop shop = shopService.getById(1L);
        cacheClient.setWithLogicalExpire(RedisConstants.CACHE_SHOP_KEY+1L,shop,10L, TimeUnit.SECONDS);
    }
}
