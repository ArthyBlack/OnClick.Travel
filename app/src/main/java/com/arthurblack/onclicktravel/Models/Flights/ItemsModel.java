package com.arthurblack.onclicktravel.Models.Flights;


import java.util.ArrayList;

public class ItemsModel {

    private boolean _oneWay;
    private AirportModel arrivalBackAirport;
    private AirportModel arrivalToAirport;
    private AirportModel departureBackAirport;
    private AirportModel departureToAirport;
    private int duration;
    private boolean fareFamily;
    private String price;
    private float priceUsd;
    private float recomendationFactor;
    private ArrayList<RoutesModel> routes;
    private int stopsCount;
    private SupplierModel supplier;
    private ArrayList<SupplierModel> supplierList;
    private String supplierListTitle;
    private String ticketId;
    private String url;

    public boolean is_oneWay() {
        return _oneWay;
    }

    public void set_oneWay(boolean _oneWay) {
        this._oneWay = _oneWay;
    }

    public AirportModel getArrivalBackAirport() {
        return arrivalBackAirport;
    }

    public void setArrivalBackAirport(AirportModel arrivalBackAirportModel) {
        this.arrivalBackAirport = arrivalBackAirportModel;
    }

    public AirportModel getArrivalToAirport() {
        return arrivalToAirport;
    }

    public void setArrivalToAirport(AirportModel arrivalToAirportModel) {
        this.arrivalToAirport = arrivalToAirportModel;
    }

    public AirportModel getDepartureBackAirport() {
        return departureBackAirport;
    }

    public void setDepartureBackAirport(AirportModel departureBackAirport) {
        this.departureBackAirport = departureBackAirport;
    }

    public AirportModel getDepartureToAirport() {
        return departureToAirport;
    }

    public void setDepartureToAirport(AirportModel departureToAirport) {
        this.departureToAirport = departureToAirport;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isFareFamily() {
        return fareFamily;
    }

    public void setFareFamily(boolean fareFamily) {
        this.fareFamily = fareFamily;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public float getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(float priceUsd) {
        this.priceUsd = priceUsd;
    }

    public float getRecomendationFactor() {
        return recomendationFactor;
    }

    public void setRecomendationFactor(float recomendationFactor) {
        this.recomendationFactor = recomendationFactor;
    }

    public ArrayList<RoutesModel> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<RoutesModel> routes) {
        this.routes = routes;
    }

    public int getStopsCount() {
        return stopsCount;
    }

    public void setStopsCount(int stopsCount) {
        this.stopsCount = stopsCount;
    }

    public SupplierModel getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierModel supplier) {
        this.supplier = supplier;
    }

    public ArrayList<SupplierModel> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(ArrayList<SupplierModel> supplierList) {
        this.supplierList = supplierList;
    }

    public String getSupplierListTitle() {
        return supplierListTitle;
    }

    public void setSupplierListTitle(String supplierListTitle) {
        this.supplierListTitle = supplierListTitle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
