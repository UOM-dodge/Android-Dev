package com.example.curemeapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyHolder> {
    ArrayList<ModelClass> arrayList;
    private RecyclerViewInterface itemClickListener;


    public void setFilteredList(ArrayList<ModelClass> filteredList) {
        this.arrayList = filteredList;
        notifyDataSetChanged();
    }
    public ContactsAdapter(ArrayList<ModelClass> arrayList){
        this.arrayList = arrayList;

    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder,final int position) {
        ModelClass test = arrayList.get(position);
        holder.getName().setText(test.getName());
        holder.getInfoTextView().setText(test.getAMKA());
        holder.getNumberTextView().setText(test.getPhone());
        holder.getImg().setImageResource(test.getImg());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
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
