package com.haina.flight.price.controller;

import com.haina.flight.price.model.Flight;
import com.haina.flight.price.model.FlightRequest;
import com.haina.flight.price.response.FlightResult;
import com.haina.flight.price.service.FeignFlightQueryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class ApiController {
    @Resource
    private FeignFlightQueryService feignFlightQueryService;

    @RequestMapping("getFlight")
    public FlightResult getFlight (String origin, String dest, String departDate){
        FlightRequest flightRequest = new FlightRequest();
        flightRequest.setDest(dest);
        flightRequest.setDepartDate(departDate);
        flightRequest.setOrigin(origin);

        try{
            List<Flight> data =feignFlightQueryService.getFlightByODAndDepartDate(flightRequest);
            return FlightResult.success(data);
        }catch (Exception e){
            return FlightResult.fail();
        }
    }
}
