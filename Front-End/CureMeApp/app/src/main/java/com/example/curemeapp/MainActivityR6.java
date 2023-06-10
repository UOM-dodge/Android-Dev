package com.example.curemeapp;

import static com.example.curemeapp.CalendarUtilsR6.daysInMonthArray;
import static com.example.curemeapp.CalendarUtilsR6.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivityR6 extends AppCompatActivity implements CalendarAdapterR6.OnItemListener{

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r6);
        initWidgets();
        CalendarUtilsR6.selectedDate = LocalDate.now();
        setMonthView();
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.MonthYearTV);
    }

    private void setMonthView()
    {
        monthYearText.setText(monthYearFromDate(CalendarUtilsR6.selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(CalendarUtilsR6.selectedDate);

        CalendarAdapterR6 calendarAdapter = new CalendarAdapterR6(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);

    }


    public void previousMonthAction(View view)
    {
        CalendarUtilsR6.selectedDate = CalendarUtilsR6.selectedDate.minusMonths(1);
        setMonthView();
    }

    public void nextMonthAction(View view)
    {
        CalendarUtilsR6.selectedDate = CalendarUtilsR6.selectedDate.plusMonths(1);
        setMonthView();
    }

    @Override
    public void onItemClick(int position, String dayText)
    {
       if(dayText.equals(""))
       {
           String message = "Selected Date " + dayText + " " + monthYearFromDate(CalendarUtilsR6.selectedDate);
           Toast.makeText(this, message, Toast.LENGTH_LONG).show();
       }

    }

    public void weeklyAction(View view)
    {
        startActivity(new Intent(this , WeekViewActivityR6.class));
    }


}