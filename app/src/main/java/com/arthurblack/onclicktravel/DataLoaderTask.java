package com.arthurblack.onclicktravel;


import android.app.Activity;
import android.os.AsyncTask;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.arthurblack.onclicktravel.Models.Flights.SearchResultFlightModel;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.URL;


class DataLoaderTask extends AsyncTask{

    SearchResultFlightModel searchResultFlightModel;
    String[] departureToAirports;
    Activity context;

    public DataLoaderTask(Activity context){
        this.context = context;
    }


    @Override
    protected Object doInBackground(Object[] params) {
        String conUrl = "http://onclick.travel/Flights/SearchResultsJson?ReturnDate=2017-07-16T00%3A00%3A00&SelectedTicketSearchProfile=&PackageSearchId=&Price=&HotelId=0&TicketId=&HotelPageId=&RoomId=&SearchId=1412&DepartFrom=MOW&Destination=NYC&Adults=1&Kids=&Infants=&DepartDate=2017-07-09T00%3A00%3A00&UserIp=";

        InputStreamReader reader;
        try {
            URL connection = new URL(conUrl);
            reader = new InputStreamReader(connection.openStream());
            searchResultFlightModel = new Gson().fromJson(reader, SearchResultFlightModel.class);

        } catch (Exception e) {}

        return null;
    }


    @Override
    protected void onPostExecute(Object o) {

        ListView lvflights = (ListView) context.findViewById(R.id.flights_search_results);

        departureToAirports = new String[searchResultFlightModel.getDepartureToAirports().size()];
        try {
            for (int i = 0; i < searchResultFlightModel.getDepartureToAirports().size(); i++) {
                departureToAirports[i] = searchResultFlightModel.getDepartureToAirports().get(i).getTitle();
            }
        }catch(NullPointerException npe){
            Log.d("NULLPOINTER", npe.getMessage());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, departureToAirports);

        lvflights.setAdapter(adapter);

//        TextView t = (TextView) context.findViewById(R.id.airports);
//        t.setText(searchResultFlightModel.getArrivalBackAirports().get(0).getTitle());
    }
}

