package com.example.curemeapp;

import static com.example.curemeapp.LogInActivity.IP;
import static com.example.curemeapp.LogInActivity.SHARED_PREFS;
import static com.example.curemeapp.LogInActivity.USER_ID;
import static com.example.curemeapp.LogInActivity.USER_TYPE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogInDetails extends MainActivityR1 {



    private String myIP, userType, userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_details);

        //LOGO ACTION BAR - START
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_200);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //LOGO ACTION BAR - END

        TextView usernameView, passwordView;

        usernameView = findViewById(R.id.username_input);
        passwordView = findViewById(R.id.password_input);

        Button r1CreateBtn = findViewById(R.id.connect_btn);

        r1CreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!usernameView.getText().toString().isEmpty() &&
                    !passwordView.getText().toString().isEmpty()){
                    // TODO TextInputLayout .setError




                    try {
                        //todo don't send password with GET
                        String url = "http://"+myIP+"/cure_db/connectUser.php?username="+usernameView.getText().toString()
                                                                        +"&password="+passwordView.getText().toString();
                        OkHttpHandler okHttpHandler = new OkHttpHandler();
                        String response = okHttpHandler.connectUser(url);
                        String[] data = response.split(",");
                        userType = data[0];
                        userID = data[1];
                        updateData();
                        chooseUserType();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(LogInDetails.this, "Συμπληρώστε όλα τα πεδία", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loadData();

    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        myIP = sharedPreferences.getString(IP, "NOT_SET");
        userType =sharedPreferences.getString(USER_TYPE, "NOT_SET");
        userID = sharedPreferences.getString(USER_ID, "NOT_SET");
    }

    public void updateData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(USER_TYPE, userType);
        editor.putString(USER_ID, userID);
        editor.apply();
    }

    public void chooseUserType(){
        if (userType.equals("PSF")){
            Intent intent = new Intent(getApplicationContext(), MainActivityR1.class);
            startActivity(intent);
        } else if (userType.equals("DOCTOR")) {
            Intent intent = new Intent(getApplicationContext(), DoctorMenuActivity.class);
            startActivity(intent);
        } else if (userType.equals("PATIENT")) {
            Intent intent = new Intent(getApplicationContext(), MainActivityR6.class);
            startActivity(intent);
        }
    }
}
