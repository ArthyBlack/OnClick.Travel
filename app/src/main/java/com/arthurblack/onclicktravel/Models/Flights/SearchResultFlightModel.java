package com.arthurblack.onclicktravel.Models.Flights;


import java.util.ArrayList;


public class SearchResultFlightModel {


    private ArrayList<FilterModel> departureToAirports;
    private ArrayList<FilterModel> departureBackAirports;
    private ArrayList<FilterModel> arrivalToAirports;
    private ArrayList<FilterModel> arrivalBackAirports;
    private FlightModel flightBack;
    private FlightModel flightTo;
    private boolean hasItems;
    private String hash;
    private ArrayList<ItemsModel> items;
    private float maxPrice;
    private float minPrice;
    private long searchId;
    private ArrayList<FilterModel> stops;
    private ArrayList<FilterModel> supplier;


    public ArrayList<FilterModel> getDepartureToAirports() {
        return departureToAirports;
    }

    public void setDepartureToAirports(ArrayList<FilterModel> departureToAirports) {
        this.departureToAirports = departureToAirports;
    }

    public ArrayList<FilterModel> getDepartureBackAirports() {
        return departureBackAirports;
    }

    public void setDepartureBackAirports(ArrayList<FilterModel> departureBackAirports) {
        this.departureBackAirports = departureBackAirports;
    }

    public ArrayList<FilterModel> getArrivalToAirports() {
        return arrivalToAirports;
    }

    public void setArrivalToAirports(ArrayList<FilterModel> arrivalToAirports) {
        this.arrivalToAirports = arrivalToAirports;
    }

    public ArrayList<FilterModel> getArrivalBackAirports() {
        return arrivalBackAirports;
    }

    public void setArrivalBackAirports(ArrayList<FilterModel> arrivalBackAirports) {
        this.arrivalBackAirports = arrivalBackAirports;
    }

    public  FlightModel getFlightBack() {
        return flightBack;
    }

    public void setFlightBack(FlightModel flightBack) {
        this.flightBack = flightBack;
    }

    public FlightModel getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(FlightModel flightTo) {
        this.flightTo = flightTo;
    }

    public boolean isHasItems() {
        return hasItems;
    }

    public void setHasItems(boolean hasItems) {
        this.hasItems = hasItems;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public ArrayList<ItemsModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemsModel> items) {
        this.items = items;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    public long getSearchId() {
        return searchId;
    }

    public void setSearchId(long searchId) {
        this.searchId = searchId;
    }

    public ArrayList<FilterModel> getStops() {
        return stops;
    }

    public void setStops(ArrayList<FilterModel> stops) {
        this.stops = stops;
    }

    public ArrayList<FilterModel> getSupplier() {
        return supplier;
    }

    public void setSupplier(ArrayList<FilterModel> supplier) {
        this.supplier = supplier;
    }
}
