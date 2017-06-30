package com.arthurblack.onclicktravel.Models.Flights;

import java.util.ArrayList;

public class FlightModel {

    private String from;
    private ArrayList<FlightItemsModel> items;
    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public ArrayList<FlightItemsModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<FlightItemsModel> items) {
        this.items = items;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
