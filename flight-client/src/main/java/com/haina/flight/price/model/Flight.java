package com.haina.flight.price.model;

public class Flight {
    private Long id;

    private String origin;

    private String dest;

    private String baggage;

    private String rule;

    private String departDate;

    private String departTime;

    private String arrivalDate;

    private String arrivalTime;

    private String carrier;

    private String flightNo;

    private String aircraft;

    private String actFlightNo;

    private String actCarrier;

    private Integer price;

    private  String carrierName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getActFlightNo() {
        return actFlightNo;
    }

    public void setActFlightNo(String actFlightNo) {
        this.actFlightNo = actFlightNo;
    }

    public String getActCarrier() {
        return actCarrier;
    }

    public void setActCarrier(String actCarrier) {
        this.actCarrier = actCarrier;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }
}
