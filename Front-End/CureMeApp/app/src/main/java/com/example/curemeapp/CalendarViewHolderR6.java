package com.example.curemeapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarViewHolderR6 extends RecyclerView.ViewHolder implements View.OnClickListener{

    public final View parentView;
    public final TextView dayofMonth;
    private final CalendarAdapterR6.OnItemListener onItemListener;
    public CalendarViewHolderR6(@NonNull View itemView, CalendarAdapterR6.OnItemListener onItemListener)
    {
        super(itemView);
        parentView = itemView.findViewById(R.id.parentView);
        dayofMonth = itemView.findViewById(R.id.cellDayText);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        onItemListener.onItemClick(getAdapterPosition(), (String) dayofMonth.getText());
    }

}
