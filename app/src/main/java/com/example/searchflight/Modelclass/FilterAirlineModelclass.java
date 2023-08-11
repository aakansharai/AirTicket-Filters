package com.example.searchflight.Modelclass;

public class FilterAirlineModelclass {

    int indigoimage;
    String AirlineName, AvailableAirline;
    Boolean checkbox;

    public FilterAirlineModelclass(int indigoimage, String airlineName, String availableAirline, Boolean checkbox) {
        this.indigoimage = indigoimage;
        AirlineName = airlineName;
        AvailableAirline = availableAirline;
        this.checkbox = checkbox;
    }

    public int getIndigoimage() {
        return indigoimage;
    }

    public void setIndigoimage(int indigoimage) {
        this.indigoimage = indigoimage;
    }

    public String getAirlineName() {
        return AirlineName;
    }

    public void setAirlineName(String airlineName) {
        AirlineName = airlineName;
    }

    public String getAvailableAirline() {
        return AvailableAirline;
    }

    public void setAvailableAirline(String availableAirline) {
        AvailableAirline = availableAirline;
    }

    public Boolean getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Boolean checkbox) {
        this.checkbox = checkbox;
    }
}
