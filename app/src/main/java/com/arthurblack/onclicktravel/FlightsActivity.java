package com.arthurblack.onclicktravel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FlightsActivity extends AppCompatActivity implements View.OnClickListener{


    Button departureCity;
    Button arrivalCity;
    Button toDepartureDate;
    Button backDepartureDate;
    Button passenges;
    Button flightSearch;

    final int REQUEST_CODE_DEPT_CITY = 1;
    final int REQUEST_CODE_ARR_CITY = 2;
    final int REQUEST_CODE_TO_DEPT_DATE = 3;
    final int REQUEST_CODE_BACK_DEPT_DATE = 4;
    final int REQUEST_CODE_PASSENGERS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights);

        departureCity = (Button) findViewById(R.id.depatrure_city);
        arrivalCity = (Button) findViewById(R.id.arrival_city);
        toDepartureDate = (Button) findViewById(R.id.to_departure_date);
        backDepartureDate = (Button) findViewById(R.id.back_departure_date);
        passenges = (Button) findViewById(R.id.passengers);
        flightSearch = (Button) findViewById(R.id.flight_search_button);

        departureCity.setOnClickListener(this);

    }


    @Override
    public void onClick(View v){
        Intent intent;
        switch(v.getId()){
            case(R.id.depatrure_city):
                intent = new Intent(this, CitiesActivity.class);
                startActivityForResult(intent, REQUEST_CODE_DEPT_CITY);
                Log.d("TAGGGG", "НАЖАЛОСЬ");
                break;
//            case(R.id.arrival_city):
//                intent = new Intent(this, CountriesActivity.class);
//                startActivityForResult(intent, REQUEST_CODE_ARR_CITY);
//                break;
//            case(R.id.to_departure_date):
//                intent = new Intent(this, CountriesActivity.class);
//                startActivityForResult(intent, REQUEST_CODE_TO_DEPT_DATE);
//                break;
//            case(R.id.back_departure_date):
//                intent = new Intent(this, CountriesActivity.class);
//                startActivityForResult(intent, REQUEST_CODE_BACK_DEPT_DATE);
//                break;
//            case(R.id.passengers):
//                intent = new Intent(this, CountriesActivity.class);
//                startActivityForResult(intent, REQUEST_CODE_PASSENGERS);
//                break;
//            case(R.id.flight_search_button):
//                intent = new Intent(this, FlightsSearchResultsActivity.class);
//                startActivity(intent);
//                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            switch (requestCode){
                case REQUEST_CODE_DEPT_CITY:
                    int color = data.getIntExtra("color", Color.WHITE);
                    departureCity.setTextColor(color);
                    String city =  data.getStringExtra("city");
                    departureCity.setText(city);
                    break;
            }

        }
    }
}
