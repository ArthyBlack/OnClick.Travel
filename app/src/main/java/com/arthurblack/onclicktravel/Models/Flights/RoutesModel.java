package com.arthurblack.onclicktravel.Models.Flights;

import java.util.ArrayList;

public class RoutesModel {

    private String arrivalAirportCode;
    private String arrivalAirportName;
    private String arrivalCityName;
    private String arrivalDate;
    private String arrivalTime;
    private String arrivalTimeFormat;
    private String departureAirportCode;
    private String departureAirportName;
    private String departureCityName;
    private String departureDate;
    private String departureTime;
    private String departureTimeFormat;
    private int flightTime;
    private String flightTimeFormat;
    private String serviceClass;
    private ArrayList<StopsModel> stops;
    private ArrayList<SupplierModel> supplierList;

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getArrivalCityName() {
        return arrivalCityName;
    }

    public void setArrivalCityName(String arrivalCityName) {
        this.arrivalCityName = arrivalCityName;
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

    public String getArrivalTimeFormat() {
        return arrivalTimeFormat;
    }

    public void setArrivalTimeFormat(String arrivalTimeFormat) {
        this.arrivalTimeFormat = arrivalTimeFormat;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getDepartureCityName() {
        return departureCityName;
    }

    public void setDepartureCityName(String departureCityName) {
        this.departureCityName = departureCityName;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeFormat() {
        return departureTimeFormat;
    }

    public void setDepartureTimeFormat(String departureTimeFormat) {
        this.departureTimeFormat = departureTimeFormat;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightTimeFormat() {
        return flightTimeFormat;
    }

    public void setFlightTimeFormat(String flightTimeFormat) {
        this.flightTimeFormat = flightTimeFormat;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public ArrayList<StopsModel> getStops() {
        return stops;
    }

    public void setStops(ArrayList<StopsModel> stops) {
        this.stops = stops;
    }

    public ArrayList<SupplierModel> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(ArrayList<SupplierModel> supplierList) {
        this.supplierList = supplierList;
    }
}
