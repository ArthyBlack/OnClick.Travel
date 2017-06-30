package com.arthurblack.onclicktravel;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.arthurblack.onclicktravel.SearchSuggests.Flights.SuggestItems;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class CitiesActivity extends AppCompatActivity implements View.OnClickListener{

    StringBuilder term = new StringBuilder();
    Button btnRed;
    Button btnGreen;
    Button btnBlue;
    EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        city = (EditText) findViewById(R.id.city_input);
        btnRed = (Button) findViewById(R.id.button_red);
        btnGreen = (Button) findViewById(R.id.button_green);
        btnBlue = (Button) findViewById(R.id.button_blue);

        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);



        city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(s.length() !=0);
                term.append(city.getText().toString());

                new SuggestsLoaderTask(CitiesActivity.this).execute();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });



    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent();

        switch(v.getId()){
            case R.id.button_red:
                intent.putExtra("color", Color.RED);
                intent.putExtra("city", city.getText().toString());

                break;
            case R.id.button_green:
                intent.putExtra("color", Color.GREEN);
                intent.putExtra("city", city.getText().toString());
                break;
            case R.id.button_blue:
                intent.putExtra("color", Color.BLUE);
                intent.putExtra("city", city.getText().toString());
                break;
        }

        setResult(RESULT_OK, intent);
        finish();
    }

    class SuggestsLoaderTask extends AsyncTask {
        SuggestsViewAdapter suggestsViewAdapter;
        ArrayList<SuggestItems> suggestItems, cities = new ArrayList<>();
        Activity citiesActivity;
        View v;


        public SuggestsLoaderTask(Activity mActivity){citiesActivity = mActivity;}


        @Override
        protected Object doInBackground(Object[] objects) {

            String url = "https://onclick.travel/Suggest/List?term=" + term.toString() + "&type=Flight";

            InputStreamReader reader;
            try {
                URL cityListUrl = new URL(url);
                reader = new InputStreamReader(cityListUrl.openStream());
                suggestItems = new Gson().fromJson(reader, new TypeToken<ArrayList<SuggestItems>>() {
                }.getType());

            } catch (IOException e) {
                Log.d("TAGGG", Log.getStackTraceString(e));
            }

            for(SuggestItems item : suggestItems) {
                cities.add(item);
            }
            suggestsViewAdapter = new SuggestsViewAdapter(citiesActivity, suggestItems);

            return null;
        }


        @Override
        protected void onPostExecute(Object o) {
            Log.d("TAGGG", "Start");
            ListView citiesSuggestsList = (ListView) findViewById(R.id.city_suggests);
            citiesSuggestsList.setAdapter(suggestsViewAdapter);
            Log.d("TAGGG", "End");
        }
    }

}
