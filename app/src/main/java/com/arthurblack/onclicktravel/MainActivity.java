package com.arthurblack.onclicktravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button flights = (Button) findViewById(R.id.button_flights);
        Button accommodations = (Button) findViewById(R.id.button_accommodations);
        Button trains = (Button) findViewById(R.id.button_trains);
        Button cars = (Button) findViewById(R.id.button_cars);
        Button allInOnes = (Button) findViewById(R.id.button_allinones);

        flights.setOnClickListener(this);
        accommodations.setOnClickListener(this);
        trains.setOnClickListener(this);
        cars.setOnClickListener(this);
        allInOnes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId()){
            case(R.id.button_flights):
                i = new Intent(MainActivity.this, FlightsActivity.class);
                startActivity(i);
                break;
            case(R.id.button_accommodations):
                i = new Intent(MainActivity.this, AccommodationsActivity.class);
                startActivity(i);
                break;
            case(R.id.button_trains):
                i = new Intent(MainActivity.this, TrainsActivity.class);
            case(R.id.button_cars):
                i = new Intent(MainActivity.this, CarsActivity.class);
                startActivity(i);
                break;
            case(R.id.button_allinones):
                i = new Intent(MainActivity.this, AllInOnesActivity.class);
                startActivity(i);
                break;
        }
    }
}
