package com.example.curemeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityR1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r1);



        Button r1Btn = findViewById(R.id.r1Btn);
        r1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityR1.this, R1Activity.class);
                startActivity(intent);
            }
        });

//        Button r2Btn = findViewById(R.id.r2Btn);
//        r2Btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, R2Activity.class);
//                startActivity(intent);
//            }
//        });
    }

}