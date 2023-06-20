package com.example.curemeapp.OLD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.curemeapp.R;
import com.example.curemeapp.R10_HistoryItem;
import com.example.curemeapp.R10_HistoryViewAdapter;
import com.example.curemeapp.R10_RequestObject;
import com.example.curemeapp.R10_SelectListener;

import java.util.List;

//OLD Activity --> Refactored to be a Fragment
public class R10_MainActivity extends AppCompatActivity implements R10_SelectListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r10);

        //todo connect with bundle to main
        String amka = "123456789";



        createItems(amka);
    }

    private void createItems(String patient_amka){
        String myIP = "192.168.1.100";
        R10_RequestObject request = new R10_RequestObject(myIP);

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