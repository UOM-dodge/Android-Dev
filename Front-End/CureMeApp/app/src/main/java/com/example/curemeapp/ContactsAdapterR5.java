package com.example.curemeapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
       // Patient test = arrayList.get(position);
//        holder.getName().setText(test.getName());
//        holder.getInfoTextView().setText(test.getAMKA());
//        holder.getNumberTextView().setText(test.getPhone());
//        holder.getImg().setImageResource(test.getImg());
        holder.getName().setText(patientsList.get(position).getName());
        holder.getNumberTextView().setText(patientsList.get(position).getPhoneNumber());
        holder.getInfoTextView().setText(patientsList.get(position).getAMKA());
        holder.getImg().setImageResource(patientsList.get(position).getImage());

    }
//    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
//        holder.getName().setText(arrayList.get(position).getName());
//        holder.getNumberTextView().setText(arrayList.get(position).getPhoneNumber());
//        holder.getInfoTextView().setText(arrayList.get(position).getAMKA());
//        holder.getImg().setImageResource(arrayList.get(position).getImage());
//    }


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



        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.name);
            imageView=itemView.findViewById(R.id.image);
            infoTextView = itemView.findViewById(R.id.info);
            numberTextView = itemView.findViewById(R.id.number);
            appointmentTextView = itemView.findViewById(R.id.appointment);
            itemView.setOnClickListener(this);

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
