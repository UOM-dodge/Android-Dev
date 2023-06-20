package com.example.curemeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class R10_DetailsActivity_Fragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_activity_r10, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        TextView dateView, serviceNameView, priceView, doctorNameView, physioCenterView;

        dateView = view.findViewById(R.id.date);
        serviceNameView = view.findViewById(R.id.service_name);
        priceView = view.findViewById(R.id.price);
        doctorNameView = view.findViewById(R.id.doctor);
        physioCenterView = view.findViewById(R.id.location);



        //Bundle setText
        dateView.setText(getArguments().getString("date"));
        serviceNameView.setText(getArguments().getString("service_name"));
        priceView.setText(getArguments().getString("price"));
        doctorNameView.setText(getArguments().getString("doctor_name"));
        physioCenterView.setText(getArguments().getString("physio_center"));
    }


}
