package com.example.searchflight;

import java.util.List;

public class FilterMy {
    public static Integer INDEX_STOPS = 0;

    public static Integer INDEX_DEPARTURE = 1;
    public static Integer INDEX_ARRIVAL = 2;
    public static Integer INDEX_PRICE = 3;
    public static Integer INDEX_AIRLINE = 4;

    private String name;
    private List<String> values;
    private List<String> selected;

    public FilterMy(String name, List<String> values, List<String> selected) {
        this.name = name;
        this.values = values;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(List<String> selected) {
        this.selected = selected;
    }
}
