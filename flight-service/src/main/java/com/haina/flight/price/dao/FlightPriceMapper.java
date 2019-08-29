package com.haina.flight.price.dao;

import com.haina.flight.price.model.FlightPrice;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author MC.F
 * @date 2019/6/26
 */
public interface FlightPriceMapper {
        int deleteByPrimaryKey(Long id);

        int insert(FlightPrice record);

        int insertSelective(FlightPrice record);

        FlightPrice selectByPrimaryKey(Long id);

        int updateByPrimaryKeySelective(FlightPrice record);

        int updateByPrimaryKey(FlightPrice record);

        FlightPrice selectById(Long id);

        List<FlightPrice> selectByODAndDepartDate(@Param("origin") String origin, @Param("dest") String dest, @Param("departDate") String departDate);
    }