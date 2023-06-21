package com.example.curemeapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventViewHolder_R8 extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, eventIDView, amkaView, dateView, serviceIDView, physioView, typeView, statusView;



    public EventViewHolder_R8(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.patient_name);
        eventIDView = itemView.findViewById(R.id.event_id);
        amkaView = itemView.findViewById(R.id.amka_id);
        dateView = itemView.findViewById(R.id.date);
        serviceIDView = itemView.findViewById(R.id.service_id);
        physioView = itemView.findViewById(R.id.physio_center);
        typeView = itemView.findViewById(R.id.type);
        statusView = itemView.findViewById(R.id.status);



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
