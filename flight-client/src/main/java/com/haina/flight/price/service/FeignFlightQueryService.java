package com.haina.flight.price.service;

import com.haina.flight.price.model.Flight;
import com.haina.flight.price.model.FlightRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 查询航班使用的fegin接口
 */
@FeignClient("fegin-flight-service")
public interface FeignFlightQueryService {

    @RequestMapping(value = "getFligthByODAnfDepartDate", method = RequestMethod.POST)
    List<Flight> getFlightByODAndDepartDate(FlightRequest request);

}
