package com.example.curemeapp;

import static com.example.curemeapp.CalendarUtilsR6.daysInWeekArray;
import static com.example.curemeapp.CalendarUtilsR6.monthYearFromDate;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeekViewActivityR6 extends AppCompatActivity implements CalendarAdapterR6.OnItemListener{

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view_r6);
        initWidgets();
        CalendarUtilsR6.selectedDate = LocalDate.now();
        setWeekView();
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.MonthYearTV);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtilsR6.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtilsR6.selectedDate);

        CalendarAdapterR6 calendarAdapter = new CalendarAdapterR6(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);

    }

    public void previousWeekAction(View view)
    {
        CalendarUtilsR6.selectedDate = CalendarUtilsR6.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeekAction(View view)
    {
        CalendarUtilsR6.selectedDate = CalendarUtilsR6.selectedDate.plusWeeks(1);
        setWeekView();
    }

    public void onItemClick(int position, String dayText)
    {
            String message = "Selected Date " + dayText + " " + monthYearFromDate(CalendarUtilsR6.selectedDate);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}