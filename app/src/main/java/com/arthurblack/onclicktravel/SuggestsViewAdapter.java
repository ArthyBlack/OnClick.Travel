package com.arthurblack.onclicktravel;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.arthurblack.onclicktravel.SearchSuggests.Flights.SuggestItems;

import java.util.ArrayList;
import java.util.Calendar;

public class SuggestsViewAdapter extends BaseAdapter {
    View view;
    private Context suggestsLoaderTask;
    private ArrayList<SuggestItems> suggestItems = new ArrayList<>();
    Button listviewItemBtn;
    private LayoutInflater mSuggestsListViewInflater;
    private int position;

    public SuggestsViewAdapter(Context mContext, ArrayList<SuggestItems> cities){
        suggestsLoaderTask = mContext;
        this.suggestItems = cities;
        mSuggestsListViewInflater = (LayoutInflater) suggestsLoaderTask.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return suggestItems.size();
    }

    @Override
    public Object getItem(int position) {
        return suggestItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("TAGGG", "getView starts");
        this.position = position;

        convertView = mSuggestsListViewInflater.inflate(R.layout.activity_cities, parent, false);
        Log.d("TAGGG", "inflating view");
        Log.d("TAGGG", "setting id to button");

        listviewItemBtn = (Button) convertView.findViewById(R.id.listview_item);
        Log.d("TAGGG", listviewItemBtn.toString());


        listviewItemBtn.setText("БЛИИИН");

        return convertView;
    }
}
