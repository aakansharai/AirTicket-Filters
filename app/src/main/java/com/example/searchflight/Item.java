package com.example.searchflight;

public class Item {

    private String stops;
    private String departureTime;
    private Integer arrivalTime;
    private Double price;
    private String airline;

    public Item(String name, String color, Integer size, Double price, String airline) {
        this.stops = name;
        this.departureTime = color;
        this.arrivalTime = size;
        this.price = price;
        this.airline = airline;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
