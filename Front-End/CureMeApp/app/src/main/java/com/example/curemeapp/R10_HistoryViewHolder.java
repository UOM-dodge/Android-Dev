package com.example.curemeapp;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class R10_HistoryViewHolder extends RecyclerView.ViewHolder {


    TextView dateView, serviceNameView, priceView, itemIDView, doctorNameView, physioCenterView;
    ImageView cardButton;

    public R10_HistoryViewHolder(@NonNull View itemView) {
        super(itemView);
        dateView = itemView.findViewById(R.id.date);
        serviceNameView = itemView.findViewById(R.id.service_name);
        priceView = itemView.findViewById(R.id.price);
        cardButton = itemView.findViewById(R.id.button_image);
        itemIDView = itemView.findViewById(R.id.item_id);
        doctorNameView = itemView.findViewById(R.id.doctor_name);
        physioCenterView = itemView.findViewById(R.id.physio_center_name);
    }
}
