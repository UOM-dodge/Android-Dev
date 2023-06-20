package com.example.curemeapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class R10_DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity_r10);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //Get TextViews
        TextView dateView, serviceNameView, priceView, doctorNameView, physioCenterView;

        dateView = findViewById(R.id.date);
        serviceNameView = findViewById(R.id.service_name);
        priceView = findViewById(R.id.price);
        doctorNameView = findViewById(R.id.doctor);
        physioCenterView = findViewById(R.id.location);


        //Bundle setText
        dateView.setText(bundle.getString("date"));
        serviceNameView.setText(bundle.getString("service_name"));
        priceView.setText(bundle.getString("price"));
        doctorNameView.setText(bundle.getString("doctor_name"));
        physioCenterView.setText(bundle.getString("physio_center"));


    }
}
