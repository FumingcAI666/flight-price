package com.haina.flight.price.service.impl;

import com.google.common.base.Joiner;
import com.haina.flight.price.dao.FlightPriceMapper;
import com.haina.flight.price.manager.ICacheManager;
import com.haina.flight.price.model.FlightPrice;
import com.haina.flight.price.service.FlightQueryService;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class FlightQueryServiceImpl implements FlightQueryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightQueryServiceImpl.class);

    @Autowired
    private FlightPriceMapper flightPriceMapper;
    @Resource(name = "redisCacheMangerImpl")
    private ICacheManager iCacheManager;

    @Override
    public List<FlightPrice> getFligthByODAnfDepartDate(String orgign, String dest, String departDate) {
        LOGGER.info("FlightQueryServiceImpl... 入参 orgign={} dest={} departDate={}", orgign, dest, departDate);

        // 从redis（cache）读取数据,如果取到了，直接返回
        // 如果没有取到，则查询数据库
        // 如果数据库返回了数据，则把数据插入到缓存

        // key = bjs-bkk-2019-05-20
        // del test 删除
        // get 查
        // set 增 改
        // lpush a abc (设置 a为key abc是值)
        // lrange a 0 10 (查询 从0 到 10)
        // hset map abc 123 map：应用变量（缓存key） abc（key） 123（value）
        // hget map abc
        // hgetall map (取出来所有键值对)
        //
        String key = generateKey(orgign, dest, departDate);
        List<FlightPrice> cacheDate = iCacheManager.getFromCache(key);
        LOGGER.info("FlightQueryServiceImpl... 缓存数据 cacheDate={} ", cacheDate);

        if (CollectionUtils.isNotEmpty(cacheDate)) {
            System.out.println("read from cache");
            return cacheDate;
        }

        List<FlightPrice> dbDate = flightPriceMapper.selectByODAndDepartDate(orgign, dest, departDate);
        LOGGER.info("FlightQueryServiceImpl... db数据 dbDate={} ", dbDate);

        if (CollectionUtils.isNotEmpty(dbDate)) {
            System.out.println("read from db,and save to cache");
            iCacheManager.saveToCache(key, dbDate);
        } else {
            // if 没有db找到，那么在redis 可以加一个null ，下次直接返回
            iCacheManager.saveToCache(key, null);
        }

        LOGGER.info("FlightQueryServiceImpl... 缓存数据 orgign={} dest={} departDate={}", orgign, dest, departDate);
        return dbDate;
    }

    /**
     * 生成key
     *
     * @param origin
     * @param dest
     * @param departDate
     * @return
     */
    private String generateKey(String origin, String dest, String departDate) {
        return Joiner.on("-").join(origin, dest, departDate);
    }
}
