package com.example.curemeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity_R9 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment_R9 homeFragment = new HomeFragment_R9();
    CalendarFragment_R9 calendarFragment = new CalendarFragment_R9();
    HistoryFragment_R9 historyFragment = new HistoryFragment_R9();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r9);


        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;
                } else if (itemId == R.id.calendar) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, calendarFragment).commit();
                    return true;
                } else if (itemId == R.id.history) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, historyFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }
}