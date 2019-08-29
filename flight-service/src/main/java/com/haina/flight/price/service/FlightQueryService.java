package com.haina.flight.price.service;

import com.haina.flight.price.model.FlightPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlightQueryService {

    List<FlightPrice> getFligthByODAnfDepartDate(String orgign,String dest,String departDate);

}
