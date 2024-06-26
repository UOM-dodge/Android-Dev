package com.example.curemeapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarAdapterR6 extends RecyclerView.Adapter<CalendarViewHolderR6> {

    private final ArrayList<LocalDate> days;
    private final OnItemListener onItemListener;

    public CalendarAdapterR6(ArrayList<LocalDate> days, OnItemListener onItemListener)
    {
        this.days = days;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public CalendarViewHolderR6 onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell_r6, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (days.size() > 15 )
            layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        else
            layoutParams.height = (int) parent.getHeight();

        return new CalendarViewHolderR6( view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolderR6 holder, int position)
    {

        final LocalDate date = days.get(position);
        if (date == null)
            holder.dayofMonth.setText("");
        else
        {
            holder.dayofMonth.setText(String.valueOf(date.getDayOfMonth()));
            if (date.equals(CalendarUtilsR6.selectedDate))
                holder.parentView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount()
    {
        return days.size();
    }

    public interface OnItemListener
    {
        void onItemClick(int position, String dayText);
    }

}
