package com.haina.flight.price.model;

public class FlightRequest {
    private String origin;
    private String dest;
    private String departDate;

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

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    @Override
    public String toString() {
        return "FlightRequest{" +
                "origin='" + origin + '\'' +
                ", dest='" + dest + '\'' +
                ", departDate='" + departDate + '\'' +
                '}';
    }
}
