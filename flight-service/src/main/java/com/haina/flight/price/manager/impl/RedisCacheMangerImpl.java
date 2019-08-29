package com.haina.flight.price.manager.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.haina.flight.price.manager.ICacheManager;
import com.haina.flight.price.model.FlightPrice;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


@Service
public class RedisCacheMangerImpl implements ICacheManager {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, List<FlightPrice>> redisTemplate;

    private LoadingCache<String, List<FlightPrice>> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(60, TimeUnit.SECONDS)
            .concurrencyLevel(10)
            .build(new CacheLoader<String, List<FlightPrice>>() {
                @Override
                public List<FlightPrice> load(String key) throws Exception {
                    System.out.println("load data ");
                    return Lists.newArrayList();
                }
            });

    @Override
    public void saveToCache(String key, List<FlightPrice> list) {
        redisTemplate.opsForValue().set(key, list, 60, TimeUnit.SECONDS);
    }

    @Override
    public List<FlightPrice> getFromCache(String key) {
        try {
            List<FlightPrice> localData = cache.get(key);
            if (CollectionUtils.isNotEmpty(localData)) {
                System.out.println("read from local");
                return localData;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        List<FlightPrice> list = redisTemplate.opsForValue().get(key);
        if (CollectionUtils.isNotEmpty(list)) {
            cache.put(key, list);
        }
        return list;
    }
}
