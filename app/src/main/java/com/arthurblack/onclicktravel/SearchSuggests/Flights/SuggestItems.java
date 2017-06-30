package com.arthurblack.onclicktravel.SearchSuggests.Flights;


import java.util.ArrayList;

public class SuggestItems {

    private String name;
    private String code;
    private String countryName;
    private ArrayList<AirportsSuggests> airports;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ArrayList<AirportsSuggests> getAirports() {
        return airports;
    }

    public void setAirports(ArrayList<AirportsSuggests> airports) {
        this.airports = airports;
    }
}
