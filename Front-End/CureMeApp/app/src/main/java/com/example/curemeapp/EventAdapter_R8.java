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

public class EventAdapter_R8 extends RecyclerView.Adapter<EventViewHolder_R8> {
    Context context;
    List<Event_R8> events;
    Bundle bundle;
    SelectListener_R8 listener;


    public EventAdapter_R8(Context context, List<Event_R8> events, SelectListener_R8 listener) {
        this.context = context;
        this.events = events;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EventViewHolder_R8 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventViewHolder_R8(LayoutInflater.from(context).inflate(R.layout.event_view_r8, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder_R8 holder, @SuppressLint("RecyclerView") int position) {
        holder.nameView.setText(events.get(position).getPatientFullName());
        holder.dateView.setText("Ραντεβού: "+events.get(position).getDateString());
        holder.amkaView.setText("AMKA: " + events.get(position).getPatientAMKA());
        holder.eventIDView.setText("Αρ. Ραντεβού: " + events.get(position).getEvent_id());
        holder.imageView.setImageResource(events.get(position).getImage());
        holder.physioView.setText(events.get(position).getPhysio_center());
        holder.typeView.setText(events.get(position).getType());

        if (events.get(position).getType().equals("REQUEST")){
            holder.statusView.setText("Κατάσταση: ΕΠΙΒΕΒΑΙΩΜΕΝΗ");
            holder.statusView.setVisibility(View.VISIBLE);
        } else if (events.get(position).getType().equals("SESSION")) {
            holder.statusView.setText("Κατάσταση: ΕΚΤΕΛΕΣΤΗΚΕ");
            holder.statusView.setVisibility(View.VISIBLE);
        }

        if (!events.get(position).getServiceID().equals("null")){
            holder.serviceIDView.setText("Κωδ. Παροχής: "+events.get(position).getServiceID());
        } else {
            holder.serviceIDView.setText("Δεν έχει οριστεί παροχή");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventID = events.get(position).getEvent_id();
                String type = events.get(position).getType();
                listener.onItemClicked(eventID, type);

            }
        });

    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
