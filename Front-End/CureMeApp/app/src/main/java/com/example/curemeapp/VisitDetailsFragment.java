package com.example.curemeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VisitDetailsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.visit_details_fragment, container, false);

        TextView daysLeftView, dateView, serviceNameView, priceView, doctorNameView, physioCenterView;

        daysLeftView = view.findViewById(R.id.days_left);
        dateView = view.findViewById(R.id.date);
        serviceNameView = view.findViewById(R.id.service_name);
        priceView = view.findViewById(R.id.price);
        doctorNameView = view.findViewById(R.id.doctor);
        physioCenterView = view.findViewById(R.id.location);

        //Set Text
        daysLeftView.setText(getArguments().getString("days_left"));
        dateView.setText(getArguments().getString("date"));
        serviceNameView.setText(getArguments().getString("service_name"));
        priceView.setText(getArguments().getString("price"));
        doctorNameView.setText(getArguments().getString("doctor_name"));
        physioCenterView.setText(getArguments().getString("physio_center"));





        return view;
    }
}
