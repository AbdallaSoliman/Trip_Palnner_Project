package com.example.heshammuhammed.reminder.AddingTrip;

import android.content.Context;
import android.util.Log;

import com.example.heshammuhammed.reminder.DTO.Trip;
import com.example.heshammuhammed.reminder.Database.Tripbase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by abdalla on 3/8/2018.
 */

public class SaveTripInDataBase {
    private int tripId;
    private String tripName;
    private double startPointLatitude ;
    private double startPointLongitude ;
    private double endPointLatitude ;
    private double endPointLongitude;
    private String startPointName;
    private String endPointName;
    private Date startDate;
    private Date endDate;
    private String status;
    private float distance;
    private String imageLink;
    private String url;
    private Context context;

    public SaveTripInDataBase() {
    }

    public SaveTripInDataBase(int tripId, String tripName, double startPointLatitude, double startPointLongitude, double endPointLatitude, double endPointLongitude, String startPointName, String endPointName, Date startDate, Date endDate, String status, float distance, String imageLink,Context context) {
        this.tripId = tripId;
        this.tripName = tripName;
        this.startPointLatitude = startPointLatitude;
        this.startPointLongitude = startPointLongitude;
        this.endPointLatitude = endPointLatitude;
        this.endPointLongitude = endPointLongitude;
        this.startPointName = startPointName;
        this.endPointName = endPointName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.distance = distance;
        this.imageLink = imageLink;
        this.context=context;
    }

    public SaveTripInDataBase(String tripName, double startPointLatitude, double startPointLongitude
            , double endPointLatitude, double endPointLongitude, String startPointName, String endPointName,
                              String url,Context context) {
        Log.i("Hamada","I Am Here");
        this.tripName = tripName;
        this.startPointLatitude = startPointLatitude;
        this.startPointLongitude = startPointLongitude;
        this.endPointLatitude = endPointLatitude;
        this.endPointLongitude = endPointLongitude;
        this.startPointName = startPointName;
        this.endPointName = endPointName;
        this.url = url;
        this.context=context;
        threadServerCall(url,context);
    }
    public void threadServerCall(final String urls,Context context){
        final StringBuilder stringBuilder = new StringBuilder();
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
              //  String myUrl = "";
                HttpURLConnection urlConnection = null;
                try {
                    Log.i("Hamada","gggggggggggggggggggggggggg");

                    url = new URL(urls);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                    int data = in.read();
                    while (data != -1) {
                        char current = (char) data;
                        data = in.read();
                        stringBuilder.append((char) current);
                      //  myUrl[0] +=""+current;
                     //   System.out.print(current);
                    }
                } catch (MalformedURLException e) {
                    Log.i("Hamada","0000000000000000000000");

                    e.printStackTrace();
                } catch (IOException e) {
                    Log.i("Hamada","111111111111111111");

                    e.printStackTrace();
                } finally {
                    if(urlConnection !=null) {
                        Log.i("Hamada","--------------------------------");
                        parseJson(stringBuilder.toString());
                        urlConnection.disconnect();
                    }
                }

            }
        }).start();
    }




    public void parseJson(final String response){

        Log.i("abdallatest", response);
            double dist;
        try {

            JSONObject jsonObject = new JSONObject(response);

          //  Log.i("abdallatest", response);

                JSONArray array = jsonObject.getJSONArray("routes");

                JSONObject routes = array.getJSONObject(0);

                JSONArray legs = routes.getJSONArray("legs");

                JSONObject steps = legs.getJSONObject(0);

                JSONObject distance = steps.getJSONObject("distance");

                Log.i("Distance", distance.toString());
                dist = Double.parseDouble(distance.getString("text").replaceAll("[^\\.0123456789]","") );

            Log.i("DoubleDistance", ""+dist);
            JSONObject overview_polyline=routes.getJSONObject("overview_polyline");
            Log.i("overview_polyline", overview_polyline.toString());
            imageLink=overview_polyline.getString("points");
            Log.i("Hamada",context.getPackageName());

            Tripbase tripTest=new Tripbase(context);

        long i= tripTest.CreateTrip(new Trip(  tripName, startPointLatitude, startPointLongitude, endPointLatitude,endPointLongitude, startPointName,
                endPointName, new Date(), new Date(), "UPCOMING", dist, imageLink));
        Log.i("Hamada",i+"Saved !!!!");
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }







}
