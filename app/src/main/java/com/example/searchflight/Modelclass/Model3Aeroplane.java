package com.example.searchflight.Modelclass;

public class Model3Aeroplane {
    int aeroplaneimage, stops, departureTime, arrivalTime;
    String aeroplaneName, price, aeroplaneTime, aeroplaneNonstop;

    public Model3Aeroplane(int aeroplaneimage, String aeroplaneName, String price, String aeroplaneTime, String aeroplaneNonstop, int stops, int departureTime, int arrivalTime) {
        this.aeroplaneimage = aeroplaneimage;
        this.aeroplaneName = aeroplaneName;
        this.price = price;
        this.aeroplaneTime = aeroplaneTime;
        this.departureTime = departureTime;
        this.aeroplaneNonstop = aeroplaneNonstop;
        this.stops = stops;

    }

    public int getAeroplaneimage() {
        return aeroplaneimage;
    }

    public void setAeroplaneimage(int aeroplaneimage) {
        this.aeroplaneimage = aeroplaneimage;
    }

    public String getAeroplaneName() {
        return aeroplaneName;
    }

    public void setAeroplaneName(String aeroplaneName) {
        this.aeroplaneName = aeroplaneName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAeroplaneTime() {
        return aeroplaneTime;
    }

    public void setAeroplaneTime(String aeroplaneTime) {
        this.aeroplaneTime = aeroplaneTime;
    }

    public String getAeroplaneNonstop() {
        return aeroplaneNonstop;
    }

    public void setAeroplaneNonstop(String aeroplaneNonstop) {
        this.aeroplaneNonstop = aeroplaneNonstop;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
