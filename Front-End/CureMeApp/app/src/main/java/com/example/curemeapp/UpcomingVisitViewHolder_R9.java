package com.example.curemeapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UpcomingVisitViewHolder_R9 extends RecyclerView.ViewHolder {

    TextView daysLeftView, dateView, serviceNameView, priceView, itemIDView, doctorNameView, physioCenterView;


    public UpcomingVisitViewHolder_R9(@NonNull View itemView) {
        super(itemView);
        daysLeftView = itemView.findViewById(R.id.days_left);
        dateView = itemView.findViewById(R.id.date);
        serviceNameView = itemView.findViewById(R.id.service_name);
        priceView = itemView.findViewById(R.id.price);
        itemIDView = itemView.findViewById(R.id.item_id);
        doctorNameView = itemView.findViewById(R.id.doctor_name);
        physioCenterView = itemView.findViewById(R.id.physio_center_name);
    }
}
