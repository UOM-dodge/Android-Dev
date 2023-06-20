package com.example.curemeapp;

import static com.example.curemeapp.LogInActivity.IP;
import static com.example.curemeapp.LogInActivity.SHARED_PREFS;
import static com.example.curemeapp.LogInActivity.USER_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.List;

public class MainActivityR7 extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ItemR7> itemList;

    private String myIP, userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r7);
        loadData();

        //LOGO ACTION BAR - START
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_200);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //LOGO ACTION BAR - END

        createEvents();



    }

    private void createEvents(){
        RequestObjectR7 request = new RequestObjectR7(myIP);
        List<ItemR7> items;
        items = request.requestItems();

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapterR7 adapter = new ItemAdapterR7(this,items, myIP);
        recyclerView.setAdapter(adapter);
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        myIP = sharedPreferences.getString(IP, "NOT_SET");
        userID = sharedPreferences.getString(USER_ID, "NOT_SET");
    }
}