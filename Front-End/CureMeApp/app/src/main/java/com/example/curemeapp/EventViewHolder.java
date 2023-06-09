package com.example.curemeapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, eventIDView, amkaView, dateView;



    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.patient_name);
        eventIDView = itemView.findViewById(R.id.event_id);
        amkaView = itemView.findViewById(R.id.amka_id);
        dateView = itemView.findViewById(R.id.date);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
