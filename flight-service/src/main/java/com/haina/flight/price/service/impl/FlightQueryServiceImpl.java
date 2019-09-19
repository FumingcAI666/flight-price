package com.haina.flight.price.service.impl;

import com.google.common.base.Joiner;
import com.haina.flight.price.dao.FlightPriceMapper;
import com.haina.flight.price.manager.ICacheManager;
import com.haina.flight.price.manager.impl.RedisCacheMangerImpl;
import com.haina.flight.price.model.FlightPrice;
import com.haina.flight.price.service.FlightQueryService;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class FlightQueryServiceImpl implements FlightQueryService {
    @Resource
    private FlightPriceMapper flightPriceMapper;
    @Resource(name = "redisCacheMangerImpl")
    private ICacheManager iCacheManager;

    @Override
    public List<FlightPrice> getFligthByODAnfDepartDate(String orgign, String dest, String departDate) {

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
        if (CollectionUtils.isNotEmpty(cacheDate)) {
            System.out.println("read from cache");
            return cacheDate;
        }
        List<FlightPrice> dbDate = flightPriceMapper.selectByODAndDepartDate(orgign, dest, departDate);
        if (CollectionUtils.isNotEmpty(dbDate)) {
            System.out.println("read from db,and save to cache");
            iCacheManager.saveToCache(key, dbDate);
        }
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
