package com.example.curemeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.time.LocalDateTime;
import java.util.List;

public class R10_MainActivity extends AppCompatActivity implements R10_SelectListener{

    private final String amka = "123456789";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r10);



        createItems(amka);
    }

    private void createItems(String patient_amka){
        R10_RequestObject request = new R10_RequestObject();

        List<R10_HistoryItem> items;
        items = request.requestItems(patient_amka);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new R10_HistoryViewAdapter(getApplicationContext(), items, this));


    }

    @Override
    public void onItemClicked(Bundle bundle) {
        Intent intent = new Intent(this, R10_DetailsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}