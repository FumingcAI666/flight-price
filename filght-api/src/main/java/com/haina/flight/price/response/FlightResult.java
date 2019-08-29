package com.haina.flight.price.response;

import com.haina.flight.price.model.Flight;

import java.util.List;

public class FlightResult {
    private int code;
    private String msg;
    private List<Flight> data;

    public static FlightResult success(List<Flight> data){
        FlightResult flightResult = new FlightResult();
        flightResult.setCode(0);
        flightResult.setMsg("success");
        flightResult.setData(data);
        return flightResult;
    }

    public static FlightResult fail(){
        FlightResult flightResult = new FlightResult();
        flightResult.setCode(2);
        flightResult.setMsg("server error");
        return flightResult;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Flight> getData() {
        return data;
    }

    public void setData(List<Flight> data) {
        this.data = data;
    }
}
