package com.haina.flight.price.model;

import java.util.Date;

public class FlightPrice {
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

    private Date createTime;

    private Date updateTime;

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
        this.origin = origin == null ? null : origin.trim();
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest == null ? null : dest.trim();
    }

    public String getBaggage() {
        return baggage;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage == null ? null : baggage.trim();
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule == null ? null : rule.trim();
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate == null ? null : departDate.trim();
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime == null ? null : departTime.trim();
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate == null ? null : arrivalDate.trim();
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime == null ? null : arrivalTime.trim();
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier == null ? null : carrier.trim();
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo == null ? null : flightNo.trim();
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft == null ? null : aircraft.trim();
    }

    public String getActFlightNo() {
        return actFlightNo;
    }

    public void setActFlightNo(String actFlightNo) {
        this.actFlightNo = actFlightNo == null ? null : actFlightNo.trim();
    }

    public String getActCarrier() {
        return actCarrier;
    }

    public void setActCarrier(String actCarrier) {
        this.actCarrier = actCarrier == null ? null : actCarrier.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }



}