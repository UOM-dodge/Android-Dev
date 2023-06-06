package com.example.curemeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList=new ArrayList<>();

        itemList.add(
                new Item("Μαρία","Αίτημα για ραντεβού στις:",R.drawable.maria)
        );
        itemList.add(
                new Item("Κώστας","Αίτημα για ραντεβού στις:",R.drawable.kostas)
        );
        itemList.add(
                new Item("Βαγγέλης","Αίτημα για ραντεβού στις:",R.drawable.vaggelis)
        );

        ItemAdapter adapter=new ItemAdapter(this,itemList);
        recyclerView.setAdapter(adapter);




    }
}