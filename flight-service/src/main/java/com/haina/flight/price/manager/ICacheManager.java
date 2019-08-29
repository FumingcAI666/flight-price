package com.haina.flight.price.manager;

import com.haina.flight.price.model.FlightPrice;

import java.util.List;

/**
 * 缓存操作类
 * @date 2019-7-2-13:56
 */
public interface ICacheManager{
    /**
     * 存储数据到缓存
     * @param key
     * @param list
     */
    void saveToCache(String key, List<FlightPrice> list);

    /**
     * 从缓存中读取数据
     * @param key
     * @return
     */
    List<FlightPrice> getFromCache(String key);

}
