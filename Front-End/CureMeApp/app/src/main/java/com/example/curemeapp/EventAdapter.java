package com.example.curemeapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {
    Context context;
    List<Event> events;
    Bundle bundle;


    public EventAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventViewHolder(LayoutInflater.from(context).inflate(R.layout.event_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.nameView.setText(events.get(position).getPatientFullName());
        holder.dateView.setText("Επόμενο Ραντεβού: "+events.get(position).getDateString());
        holder.amkaView.setText("AMKA: " + events.get(position).getAmka_id());
        holder.eventIDView.setText("Αρ. Ραντεβού: " + events.get(position).getEvent_id());
        holder.imageView.setImageResource(events.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
