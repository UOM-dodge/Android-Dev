package com.example.curemeapp;

import static com.example.curemeapp.LogInActivity.IP;
import static com.example.curemeapp.LogInActivity.SHARED_PREFS;
import static com.example.curemeapp.LogInActivity.USER_ID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import android.app.TimePickerDialog;
import android.widget.Button;
import android.widget.TimePicker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainActivity_R8 extends AppCompatActivity
{
    Button timeButton;
    int hour, minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r8);

        //LOGO ACTION BAR - START
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_200);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //LOGO ACTION BAR - END



        TextView amkaView = findViewById(R.id.editTextNumber);
        CalendarView calendarView = findViewById(R.id.calendarView);
        final LocalDateTime[] localDateTime = {LocalDateTime.now()};


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                localDateTime[0] = LocalDateTime.of(year, month+1, dayOfMonth, 0, 0);

            }
        });

        Button searchBtn = findViewById(R.id.buttonSearch);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_R8.this, ResultActivity_R8.class);
                Bundle bundle = new Bundle();

                bundle.putString("amka_id", "000");
                if (!amkaView.getText().toString().isEmpty()) {
                    bundle.putString("amka_id", amkaView.getText().toString());
                }


                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                String dateString = localDateTime[0].format(dateTimeFormatter);
                localDateTime[0] = localDateTime[0].plusDays(1);
                String dateEnd = localDateTime[0].format(dateTimeFormatter);

                bundle.putString("date", dateString);
                bundle.putString("dateEnd", dateEnd);

                System.out.println(dateString);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

    }

}