package com.arthurblack.onclicktravel;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.arthurblack.onclicktravel.Models.Flights.ItemsModel;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class FlightsViewAdapter extends BaseAdapter {

    private Context flghtsSearchReslutContext;
    private ArrayList<ItemsModel> routesModel = new ArrayList<>();
    private LayoutInflater linflater;
    private int position;
    HashMap<String, Bitmap> hashMap = new LinkedHashMap<>();
    HashMap<String, Integer> hashMapID = new LinkedHashMap<>();

    FlightsViewAdapter(Context mycontext, ArrayList<ItemsModel> routesModel){
        flghtsSearchReslutContext = mycontext;
        this.routesModel = routesModel;
        linflater = (LayoutInflater) flghtsSearchReslutContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return routesModel.size();
    }

    @Override
    public Object getItem(int position) {
        return routesModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        this.position = position;
        View view = convertView;

        if(routesModel.get(position).getSupplierList().size() == 1) {
            view = linflater.inflate(R.layout.my_list_view_when_1, parent, false);

            ((ImageView) view.findViewById(R.id.to_flight_logo)).setImageResource(getLogoIdFileName("https://onclick.travel" + routesModel.get(position).getSupplierList().get(0).getLogoUrl()));
            ((TextView) view.findViewById(R.id.to_departure_airport)).setText(routesModel.get(position).getDepartureToAirport().getCode());
            ((TextView) view.findViewById(R.id.to_arrival_airport)).setText(routesModel.get(position).getArrivalToAirport().getCode());
            ((TextView) view.findViewById(R.id.back_departure_airport)).setText(routesModel.get(position).getDepartureBackAirport().getCode());
            ((TextView) view.findViewById(R.id.back_arrival_airport)).setText(routesModel.get(position).getArrivalBackAirport().getCode());
            ((TextView) view.findViewById(R.id.to_flight_time)).setText(routesModel.get(position).getRoutes().get(0).getFlightTimeFormat());
            ((TextView) view.findViewById(R.id.back_flight_time)).setText(routesModel.get(position).getRoutes().get(1).getFlightTimeFormat());
            ((TextView) view.findViewById(R.id.to_departure_time)).setText(routesModel.get(position).getRoutes().get(0).getDepartureDate() + " " + routesModel.get(position).getRoutes().get(0).getDepartureTime());
            ((TextView) view.findViewById(R.id.to_arrival_time)).setText(routesModel.get(position).getRoutes().get(0).getArrivalDate() + " " + routesModel.get(position).getRoutes().get(0).getArrivalTime());
            ((TextView) view.findViewById(R.id.back_departure_time)).setText(routesModel.get(position).getRoutes().get(1).getDepartureDate() + " " + routesModel.get(position).getRoutes().get(1).getDepartureTime());
            ((TextView) view.findViewById(R.id.back_arrival_time)).setText(routesModel.get(position).getRoutes().get(1).getArrivalDate() + " " + routesModel.get(position).getRoutes().get(1).getArrivalTime());


            if(routesModel.get(position).getRoutes().get(0).getStops().size() > 0){
                ((TextView) view.findViewById(R.id.to_stops)).setText("stop at " + routesModel.get(position).getRoutes().get(0).getStops().get(0).getAirportCode());

            }else{
                ((TextView) view.findViewById(R.id.to_stops)).setText("no stops");
            }

            if(routesModel.get(position).getRoutes().get(1).getStops().size() > 0){
                ((TextView) view.findViewById(R.id.back_stops)).setText("stop at " + routesModel.get(position).getRoutes().get(1).getStops().get(0).getAirportCode());

            }else{
                ((TextView) view.findViewById(R.id.back_stops)).setText("no stops");
            }




        } else if (routesModel.get(position).getSupplierList().size() > 1){
            view = linflater.inflate(R.layout.my_list_view, parent, false);

            ((ImageView)view.findViewById(R.id.to_flight_logo)).setImageResource(getLogoIdFileName("https://onclick.travel" + routesModel.get(position).getSupplierList().get(0).getLogoUrl()));
            ((ImageView)view.findViewById(R.id.back_flight_logo)).setImageResource(getLogoIdFileName("https://onclick.travel" + routesModel.get(position).getSupplierList().get(1).getLogoUrl()));
            ((TextView) view.findViewById(R.id.to_departure_airport)).setText(routesModel.get(position).getDepartureToAirport().getCode());
            ((TextView) view.findViewById(R.id.to_arrival_airport)).setText(routesModel.get(position).getArrivalToAirport().getCode());
            ((TextView) view.findViewById(R.id.back_departure_airport)).setText(routesModel.get(position).getDepartureBackAirport().getCode());
            ((TextView) view.findViewById(R.id.back_arrival_airport)).setText(routesModel.get(position).getArrivalBackAirport().getCode());
            ((TextView) view.findViewById(R.id.to_flight_time)).setText(routesModel.get(position).getRoutes().get(0).getFlightTimeFormat());
            ((TextView) view.findViewById(R.id.back_flight_time)).setText(routesModel.get(position).getRoutes().get(1).getFlightTimeFormat());
            ((TextView) view.findViewById(R.id.to_departure_time)).setText(routesModel.get(position).getRoutes().get(0).getDepartureDate() + " " + routesModel.get(position).getRoutes().get(0).getDepartureTime());
            ((TextView) view.findViewById(R.id.to_arrival_time)).setText(routesModel.get(position).getRoutes().get(0).getArrivalDate() + " " + routesModel.get(position).getRoutes().get(0).getArrivalTime());
            ((TextView) view.findViewById(R.id.back_departure_time)).setText(routesModel.get(position).getRoutes().get(1).getDepartureDate() + " " + routesModel.get(position).getRoutes().get(1).getDepartureTime());
            ((TextView) view.findViewById(R.id.back_arrival_time)).setText(routesModel.get(position).getRoutes().get(1).getArrivalDate() + " " + routesModel.get(position).getRoutes().get(1).getArrivalTime());

            if(routesModel.get(position).getRoutes().get(0).getStops().size() > 0){
                ((TextView) view.findViewById(R.id.to_stops)).setText("stop at " + routesModel.get(position).getRoutes().get(0).getStops().get(0).getAirportCode());
            }else{
                ((TextView) view.findViewById(R.id.to_stops)).setText("no stops");
            }

            if(routesModel.get(position).getRoutes().get(1).getStops().size() > 0){
                ((TextView) view.findViewById(R.id.back_stops)).setText("stop at " + routesModel.get(position).getRoutes().get(1).getStops().get(0).getAirportCode());
            }else{
                ((TextView) view.findViewById(R.id.back_stops)).setText("no stops");
            }

        }

        return view;
    }

    private ItemsModel getRoute(int position){
        return ((ItemsModel) getItem(position));
    }

    int count=0;

    private Bitmap getLogoURL(String url){
        synchronized (hashMap) {
            try {
                if (hashMap.containsKey(url)) {
                    return hashMap.get(url);
                }
                Log.d("TAG", "Start");
                Log.d("TAG", String.valueOf(hashMap.size()));
                Bitmap bm;
                URL logoUrl = new URL(url);
                InputStream is = logoUrl.openStream();
                bm = BitmapFactory.decodeStream(is);
                is.close();
                hashMap.put(url, bm);
                count++;
                Log.d("TAG", String.valueOf(count));
                return bm;
            } catch (IOException e) {
                Log.getStackTraceString(e);
            }
        }
        return null;
    }

    private int getLogoIdFileName(String url) {
        synchronized (hashMapID) {
            try {
                if (hashMapID.containsKey(url)) {
                    return hashMapID.get(url);
                } else {
                    Log.d("TAG", "Start");
                    Log.d("TAG", String.valueOf(hashMapID.size()));
                    int id;
                    String middle = "";
                    URL logoUrl = new URL(url);
                    middle = logoUrl.toString();
                    StringBuilder reReverseUrl = new StringBuilder(new StringBuilder(middle).reverse().substring(4, 6)).reverse();
                    id = flghtsSearchReslutContext.getResources().getIdentifier("ba" + reReverseUrl.toString().toLowerCase(), "drawable", flghtsSearchReslutContext.getPackageName());
                    hashMapID.put(url, id);
                    count++;
                    Log.d("TAG", String.valueOf(count));
                    Log.d("TAG", reReverseUrl.toString());
                    return id;
                }
            } catch (IOException e) {
                Log.getStackTraceString(e);
            }
        }
        return 0;

    }
}