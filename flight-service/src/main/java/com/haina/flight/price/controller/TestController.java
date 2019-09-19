package com.haina.flight.price.controller;

import com.haina.flight.price.comstants.constants;
import com.haina.flight.price.dao.FlightPriceMapper;
import com.haina.flight.price.model.FlightPrice;
import com.haina.flight.price.service.FlightQueryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class TestController {

    @Resource
    private FlightPriceMapper flightPriceMapper;
    @Resource
    private FlightQueryService flightQueryService;

    @RequestMapping("/getFlight")
    public FlightPrice getFlightPrice(Long id){
        return flightPriceMapper.selectById(1L);
    }

    @RequestMapping("getFlight01")
    public List<FlightPrice> getFlightPrice01(Long id){
        return flightQueryService.getFligthByODAnfDepartDate("BJS","BKK","2019-05-20");
    }

    @RequestMapping("getValue")
    public String getVaule(){
        return "abc"+ constants.abc +"def"+constants.def;
    }

}
