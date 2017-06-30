package com.arthurblack.onclicktravel;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.arthurblack.onclicktravel.SearchSuggests.Flights.AirportsSuggests;
import com.arthurblack.onclicktravel.SearchSuggests.Flights.SuggestItems;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


public class CountriesActivity extends AppCompatActivity {


    View view;
    private EditText city;
    ListView citiesList;
    StringBuilder term = new StringBuilder();
    private TextView cityListItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countries);


        citiesList = (ListView) findViewById(R.id.citylist);


        new CountriesListLoader(CountriesActivity.this).execute();
    }



    class CountriesListLoader extends AsyncTask implements  View.OnClickListener{
        ArrayList<SuggestItems> suggestItems = new ArrayList<>();
        Activity context;
        ArrayList<SuggestItems> cities = new ArrayList<>();
        CountriesListViewAdapter clva;

        public CountriesListLoader(Activity context){this.context = context;}

        @Override
        protected Object doInBackground(Object... params){

            String url = "https://onclick.travel/Suggest/List?term=" + term.toString() + "&type=Flight";
            InputStreamReader reader;
            try {
                URL cityLidtUrl = new URL(url);
                reader = new InputStreamReader(cityLidtUrl.openStream());
                suggestItems = new Gson().fromJson(reader, new TypeToken<ArrayList<SuggestItems>>(){}.getType());

            } catch(IOException e){
                Log.d("TAGGG", Log.getStackTraceString(e));
            }

            for(SuggestItems item: suggestItems){
                cities.add(item);
            }

            clva = new CountriesListViewAdapter(context, cities);
            Log.d("TAGGGG", "END");


            return null;
        }


        @Override
        protected void onPostExecute(Object o){

            city = (EditText) findViewById(R.id.city);
            city.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() != 0) {

                        term.append(city.getText());
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            citiesList.setAdapter(clva);

            cityListItem = (TextView) findViewById(R.id.city_list_item);
//            Log.d("TAGGGG", cityListItem.getText().toString());

            cityListItem.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("city", cityListItem.getText());

            setResult(RESULT_OK, intent);
            finish();
        }
    }

}

class CountriesListViewAdapter extends BaseAdapter{

    private Context countriesContext;
    private ArrayList<SuggestItems> cities = new ArrayList<>();
    private LayoutInflater linflater;
    private int position;
    private TextView cityListItem;
    View view;

    public CountriesListViewAdapter(Context myContext, ArrayList<SuggestItems> cities){
        countriesContext = myContext;
        this.cities = cities;
        linflater = (LayoutInflater) countriesContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        view = convertView;
        this.position = position;

        view = linflater.inflate(R.layout.city_item, parent, false);

        cityListItem = (TextView) view.findViewById(R.id.city_list_item);
        cityListItem.setText(cities.get(position).getName());

        return view;
    }

    public TextView getTextView(){
        return cityListItem;
    }
}
