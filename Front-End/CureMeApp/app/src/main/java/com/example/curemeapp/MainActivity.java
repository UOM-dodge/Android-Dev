package com.example.curemeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.widget.Button;
import android.widget.TimePicker;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity
{
    Button timeButton;
    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        timeButton = findViewById(R.id.buttonTime);
//
//        Spinner spinnerActions = (Spinner) findViewById(R.id.spinner_actions);

        // Create an ArrayAdapter using the string array and a default spinner
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.actions,
//                        android.R.layout.simple_spinner_item);
//
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
//        spinnerActions.setAdapter(adapter);



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
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
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

    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
             timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
            }
        };

        //int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);

        timePickerDialog.setTitle("Ώρα επίσκεψης");
        timePickerDialog.show();

    }
}