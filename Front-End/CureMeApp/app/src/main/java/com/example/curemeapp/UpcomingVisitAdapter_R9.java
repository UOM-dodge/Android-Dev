package com.example.curemeapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UpcomingVisitAdapter_R9 extends RecyclerView.Adapter<UpcomingVisitViewHolder_R9> {

    List<Event_R9> events;
    SelectListener_R9 listener;
    Context context;


    public UpcomingVisitAdapter_R9(Context context, List<Event_R9> events, SelectListener_R9 listener) {
        this.events = events;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public UpcomingVisitViewHolder_R9 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UpcomingVisitViewHolder_R9(LayoutInflater.from(context).inflate(R.layout.upcoming_view_r9, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingVisitViewHolder_R9 holder, int position) {
        holder.dateView.setText(events.get(position).getDateString());
        holder.serviceNameView.setText(events.get(position).getServiceName());
        holder.priceView.setText(events.get(position).getPrice()+"€");
        holder.itemIDView.setText(events.get(position).getItemID());
        holder.doctorNameView.setText(events.get(position).getDoctorName());
        holder.physioCenterView.setText(events.get(position).getPhysioCenterName());
        String daysLeft = events.get(position).getDaysLeft();
        if(daysLeft.equals("1")){
            holder.daysLeftView.setText("Σε 1 ημέρα");
        } else {
            String text = "Σε "+daysLeft+" ημέρες";
            holder.daysLeftView.setText(text);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                //prepare bundle to transfer info to R10_DetailsActivity
                bundle.putString("date", holder.dateView.getText().toString());
                bundle.putString("service_name", holder.serviceNameView.getText().toString());
                bundle.putString("price", holder.priceView.getText().toString());
                bundle.putString("item_id", holder.itemIDView.getText().toString());
                bundle.putString("doctor_name", holder.doctorNameView.getText().toString());
                bundle.putString("physio_center", holder.physioCenterView.getText().toString());
                bundle.putString("days_left", holder.daysLeftView.getText().toString());

                listener.onItemClicked(bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
