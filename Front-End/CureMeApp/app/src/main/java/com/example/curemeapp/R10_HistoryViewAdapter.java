package com.example.curemeapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class R10_HistoryViewAdapter extends RecyclerView.Adapter<R10_HistoryViewHolder> {

    List<R10_HistoryItem> items;
    R10_SelectListener listener;

    Context context;

    public R10_HistoryViewAdapter(Context context, List<R10_HistoryItem> items, R10_SelectListener listener) {
        this.context = context;
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public R10_HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new R10_HistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.history_item_view_r10, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull R10_HistoryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.dateView.setText(items.get(position).getDateString());
        holder.serviceNameView.setText(items.get(position).getServiceName());
        holder.priceView.setText(items.get(position).getPrice()+"€");
        holder.itemIDView.setText(items.get(position).getItemID());
        holder.doctorNameView.setText(items.get(position).getDoctorName());
        holder.physioCenterView.setText(items.get(position).getPhysioCenterName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                bundle.putString("date", holder.dateView.getText().toString());
                bundle.putString("service_name", holder.serviceNameView.getText().toString());
                bundle.putString("price", holder.priceView.getText().toString());
                bundle.putString("item_id", holder.itemIDView.getText().toString());
                bundle.putString("doctor_name", holder.doctorNameView.getText().toString());
                bundle.putString("physio_center", holder.physioCenterView.getText().toString());

                listener.onItemClicked(bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
