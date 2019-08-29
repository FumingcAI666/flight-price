package com.haina.flight.price.feign;

import com.haina.flight.price.model.Flight;
import com.haina.flight.price.model.FlightPrice;
import com.haina.flight.price.model.FlightRequest;
import com.haina.flight.price.service.FeignFlightQueryService;
import com.haina.flight.price.service.FlightQueryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FeignFlightQueryServiceImpl implements FeignFlightQueryService {
    @Resource
    private FlightQueryService flightQueryService;

    @Override
    public List<Flight> getFlightByODAndDepartDate(@RequestBody FlightRequest request) {
        List<FlightPrice> flightPriceList =  flightQueryService.getFligthByODAnfDepartDate(request.getOrigin(),request.getDest(),request.getDepartDate());

        return flightPriceList.stream().map(price -> convertFlightPrice(price)).collect(Collectors.toList());
    }

    //类型转换，把flightPrice类型转换成flight类型
    private Flight convertFlightPrice(FlightPrice flightPrice){
        Flight result = new Flight();
        result.setId(flightPrice.getId());
        result.setOrigin(flightPrice.getOrigin());
        result.setDest(flightPrice.getDest());
        result.setBaggage(flightPrice.getBaggage());
        result.setRule(flightPrice.getRule());
        result.setDepartDate(flightPrice.getDepartDate());
        result.setDepartTime(flightPrice.getDepartTime());
        result.setArrivalDate(flightPrice.getArrivalDate());
        result.setCarrier(flightPrice.getCarrier());
        result.setFlightNo(flightPrice.getFlightNo());
        result.setAircraft(flightPrice.getAircraft());
        result.setActFlightNo(flightPrice.getActFlightNo());
        result.setActCarrier(flightPrice.getActCarrier());
        result.setPrice(flightPrice.getPrice());
        result.setCarrierName("");
        return result;
    }
}
