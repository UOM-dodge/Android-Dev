package com.example.curemeapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.widget.Toast;
import android.widget.Button;




public class ItemAdapterR7 extends RecyclerView.Adapter<ItemAdapterR7.ItemViewHolder> {
    private final Context mCtx;
    private final List<ItemR7> itemList;

    public ItemAdapterR7(Context mCtx, List<ItemR7> itemList) {
        this.mCtx = mCtx;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_card2_r7,parent,false);
        return new ItemViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewName.setText(itemList.get(position).getFullName());
        holder.imageView.setImageResource(itemList.get(position).getImage());
        holder.textViewDate.setText(itemList.get(position).getDateString());




        // Set click listeners for accept and decline buttons
        holder.buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int requestID = itemList.get(position).getRequestID();
                    RequestObjectR7 request = new RequestObjectR7();
                    String response = request.requestConfirmed(requestID);
                    System.out.println(response);
                    //TODO make MainActivity refresh on btnClick (maybe Interface class)
                    Toast.makeText(mCtx, "Προστέθηκε νέο ραντεβού!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(mCtx, "Σφάλμα στην Βάση Δεδομένων", Toast.LENGTH_SHORT).show();
                }

            }
        });

        holder.buttonDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int requestID = itemList.get(position).getRequestID();
                    RequestObjectR7 request = new RequestObjectR7();
                    String response = request.requestCanceled(requestID);
                    System.out.println(response);
                    //TODO make MainActivity refresh on btnClick (maybe Interface class)
                    Toast.makeText(mCtx, "Απορρίφθηκε ραντεβού!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(mCtx, "Σφάλμα στην Βάση Δεδομένων", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName, textViewDesc, textViewDate;
        Button buttonAccept, buttonDecline;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.name);
            textViewDesc = itemView.findViewById(R.id.description);
            textViewDate = itemView.findViewById(R.id.date);
            buttonAccept = itemView.findViewById(R.id.buttonAccept);
            buttonDecline = itemView.findViewById(R.id.buttonDecline);
        }
    }

}
