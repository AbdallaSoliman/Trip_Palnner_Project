package com.example.heshammuhammed.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heshammuhammed.reminder.DTO.Trip;

public class Trip_Details extends AppCompatActivity {

    Intent intent;
    Trip trip;
    TextView tripName , startPoint , endPoint , startDate , endDate , tripstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_trip__details);
        tripName = findViewById(R.id.tripnameview);
        startPoint = findViewById(R.id.startpointview);
        endPoint = findViewById(R.id.endpointview);
        startDate = findViewById(R.id.startdateview);
        endDate = findViewById(R.id.enddateview);
        tripstatus = findViewById(R.id.tripstatusview);

        intent = getIntent();
        trip = (Trip) intent.getSerializableExtra("TRIPDETAILS");
        Toast.makeText(this,trip.getTripId()+" ",Toast.LENGTH_LONG).show();

        tripName.setText(trip.getTripId()+"");
        startPoint.setText(trip.getStartPointName());
        endPoint.setText(trip.getEndPointName());
        startDate.setText(trip.getStartDate().toString());
        endDate.setText(trip.getEndDate().toString());
        tripstatus.setText(trip.getStatus());
    }

}
