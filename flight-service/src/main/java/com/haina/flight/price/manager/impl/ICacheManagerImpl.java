package com.haina.flight.price.manager.impl;

import com.haina.flight.price.manager.ICacheManager;
import com.haina.flight.price.model.FlightPrice;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ICacheManagerImpl implements ICacheManager {

    @Resource
    private RedisTemplate<String,List<FlightPrice>> redisTemplate;

    @Override
    public void saveToCache(String key, List<FlightPrice> list) {
        redisTemplate.opsForValue().set(key,list);
    }

    @Override
    public List<FlightPrice> getFromCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
