package com.example.curemeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivityR7 extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ItemR7> itemList;

    private final String myIP = "192.168.1.100";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r7);

        createEvents(savedInstanceState);



    }

    private void createEvents(Bundle bundle){
        RequestObjectR7 request = new RequestObjectR7();
        List<ItemR7> items;
        items = request.requestItems();

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapterR7 adapter = new ItemAdapterR7(this,items);
        recyclerView.setAdapter(adapter);
    }
}