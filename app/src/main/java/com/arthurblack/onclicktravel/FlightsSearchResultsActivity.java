package com.arthurblack.onclicktravel;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.arthurblack.onclicktravel.Models.Flights.ItemsModel;
import com.arthurblack.onclicktravel.Models.Flights.SearchResultFlightModel;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class FlightsSearchResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights_search_result);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Log.d("TAGGG", "Task Starts");
                FlightsDataLoader fdl = new FlightsDataLoader(this);
                fdl.execute();
            Log.d("TAGGG", "Task Ends");
        }

    }
    
    class FlightsDataLoader extends AsyncTask {

        SearchResultFlightModel searchResultFlightModel = new SearchResultFlightModel();
        String url = "https://onclick.travel/Flights/SearchResultsJson?ReturnDate=2017-07-16T00%3A00%3A00&SelectedTicketSearchProfile=&PackageSearchId=&Price=&HotelId=0&TicketId=&HotelPageId=&RoomId=&SearchId=1412&DepartFrom=MOW&Destination=NYC&Adults=1&Kids=&Infants=&DepartDate=2017-07-09T00%3A00%3A00&UserIp=";
        Activity myContext;
        ArrayList<ItemsModel> routesModel = new ArrayList<>();
        FlightsViewAdapter fva;


        public FlightsDataLoader(Activity myContext) {
            this.myContext = myContext;
        }

        @Override
        protected Object doInBackground(Object[] params) {
            InputStreamReader reader;
            Log.d("TAGGG", "Start");

            try {
                URL connection = new URL(url);
                reader = new InputStreamReader(connection.openStream());
                searchResultFlightModel = new Gson().fromJson(reader, SearchResultFlightModel.class);

//                InputStream i = getResources().openRawResource(getResources().getIdentifier("req", "raw", getPackageName()));
//                JsonReader jsonReader = new JsonReader(new InputStreamReader(i));
//                searchResultFlightModel = new Gson().fromJson(jsonReader, SearchResultFlightModel.class);


                Log.d("TAGGG", "Success");
            } catch (Exception e) {
                Log.d("TAGGG", Log.getStackTraceString(e));
            }

            for(ItemsModel item: searchResultFlightModel.getItems()){
                routesModel.add(item);
            }

            fva = new FlightsViewAdapter(myContext, routesModel);
            Log.d("TAGGG", "END");
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {

            ListView lvflights = (ListView) findViewById(R.id.flights_search_results);

            lvflights.setAdapter(fva);
        }
    }
}