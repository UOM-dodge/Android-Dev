package com.example.curemeapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ContactsAdapterR5 extends RecyclerView.Adapter<ContactsAdapterR5.MyHolder> {
    List<PatientR5> patientsList;
    ArrayList<PatientR5> arrayList;
    private RecyclerViewInterfaceR5 itemClickListener;


    public void setFilteredList(List<PatientR5> patientsList) {
        this.patientsList = patientsList;
        notifyDataSetChanged();
    }
    public ContactsAdapterR5(List<PatientR5> patientsList){
        this.patientsList = patientsList;


    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view_r5,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder,int position) {
        holder.getName().setText(patientsList.get(position).getName());
        holder.getNumberTextView().setText(patientsList.get(position).getPhoneNumber());
        holder.getInfoTextView().setText(patientsList.get(position).getAMKA());
        holder.getImg().setImageResource(patientsList.get(position).getImage());
        holder.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String patient_amka = holder.infoTextView.getText().toString();
                Intent intent = new Intent(v.getContext(), R4_MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("patient_amka", patient_amka);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return patientsList.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        ImageView imageView;
        TextView nameTextView;
        TextView infoTextView;
        TextView numberTextView;
        TextView appointmentTextView;
        Button infoButton;



        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.name);
            imageView=itemView.findViewById(R.id.image);
            infoTextView = itemView.findViewById(R.id.info);
            numberTextView = itemView.findViewById(R.id.number);
            appointmentTextView = itemView.findViewById(R.id.appointment);
            infoButton = itemView.findViewById(R.id.info_button);

        }

        public TextView getName(){
            return nameTextView;
        }

        public ImageView getImg(){
            return imageView;
        }

        public TextView getNumberTextView(){return numberTextView;}

        public TextView getInfoTextView(){return infoTextView;}

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener.onItemClick(arrayList.get(position));
                }
            }
        }
    }
}
