package com.example.curemeapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        List<Event> events = new ArrayList<>();
        LocalDateTime dateTime = LocalDateTime.now();

        SearchObject searchObject = new SearchObject();


        Bundle bundle = getIntent().getExtras();

        String amka_id = bundle.getString("amka_id");
        String dateString = bundle.getString("date");
        String dateEnd = bundle.getString("dateEnd");

        if (!amka_id.equals("000")){
            events = searchObject.searchEvents(amka_id, dateString, dateEnd);
        }
        else {
            events = searchObject.searchEventsWithDate(dateString, dateEnd);
        }


//        events.add(new Event("132", "Onoma Tade", "1236547987", dateTime, "UPCOMING", 0));
//        events.add(new Event("658", "Petros Kati", "894468748", dateTime, "UPCOMING", 0));



        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new EventAdapter(getApplicationContext(), events));

    }
}
