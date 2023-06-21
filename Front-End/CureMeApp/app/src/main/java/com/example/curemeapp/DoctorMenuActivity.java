package com.example.curemeapp;

import static com.example.curemeapp.LogInActivity.IP;
import static com.example.curemeapp.LogInActivity.SHARED_PREFS;
import static com.example.curemeapp.LogInActivity.USER_ID;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DoctorMenuActivity extends AppCompatActivity {

    private String myIP, userID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_menu);
        loadData();


        //LOGO ACTION BAR - START
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_200);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //LOGO ACTION BAR - END


        Button addPatientBtn, addSessionBtn, searchPatientBtn, weeklyPlanBtn, manageRequestsBtn;

        addPatientBtn = findViewById(R.id.add_patient_btn);
        addSessionBtn = findViewById(R.id.add_edit_session);
        searchPatientBtn = findViewById(R.id.search_patient);
        weeklyPlanBtn = findViewById(R.id.weekly_plan);
        manageRequestsBtn = findViewById(R.id.manage_requests);

        TextView doctorNameView = findViewById(R.id.hello_text_name);
        doctorNameView.setText(getDoctorName());


        addPatientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivityR3.class);
                startActivity(intent);
            }
        });

        addSessionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity_R8.class);
                startActivity(intent);
            }
        });

        searchPatientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo R5 merged, no error so far
                Intent intent = new Intent(getApplicationContext(), MainActivityR5.class);
                startActivity(intent);
            }
        });

        weeklyPlanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo R6 not working
                Intent intent = new Intent(getApplicationContext(), MainActivityR6.class);
                startActivity(intent);
            }
        });

        manageRequestsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivityR7.class);
                startActivity(intent);
            }
        });


    }



    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        myIP = sharedPreferences.getString(IP, "NOT_SET");
        userID = sharedPreferences.getString(USER_ID, "NOT_SET");
    }

    public String getDoctorName(){
        String doctorName = "NOT_SET";
        String url = "http://"+myIP+"/cure_db/getDoctorName.php?doctor_id="+userID;

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            doctorName = okHttpHandler.getDoctorName(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return doctorName;
    }
}
