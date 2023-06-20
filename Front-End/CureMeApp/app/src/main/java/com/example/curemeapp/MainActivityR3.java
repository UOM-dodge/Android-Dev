package com.example.curemeapp;

import static com.example.curemeapp.LogInActivity.IP;
import static com.example.curemeapp.LogInActivity.SHARED_PREFS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivityR3 extends AppCompatActivity {

    private String myIP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r3);
        loadData();

        //LOGO ACTION BAR - START
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_200);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //LOGO ACTION BAR - END


        Button addButton = findViewById(R.id.addButtonR3);
        TextView fullNameView, emailView, addressView, amkaView;

        fullNameView = findViewById(R.id.nameTextR3);
        emailView = findViewById(R.id.emailTextR3);
        addressView = findViewById(R.id.addressTextR3);
        amkaView = findViewById(R.id.amkaTextR3);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!fullNameView.getText().toString().isEmpty() &&
                    !emailView.getText().toString().isEmpty() &&
                    !addressView.getText().toString().isEmpty() &&
                    !amkaView.getText().toString().isEmpty()) {

                    // TODO TextInputLayout .setError


                    /* TODO make fullName check
                        TODO make emailView check example@something.com
                        TODO make addressView check
                        TODO make amkaView check

                     */

                    PatientR3 patient = new PatientR3(  fullNameView.getText().toString(),
                            emailView.getText().toString(),
                            addressView.getText().toString(),
                            amkaView.getText().toString());


                    try {
                        SendObjectR3 sendObject = new SendObjectR3(myIP);
                        String response = sendObject.sendPatientData(patient);
                        System.out.println(response);
                        finish();
                        overridePendingTransition(0, 0);
                        // todo go back to doctor_menu WITH delay, after successful entry
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                        if (response.equals("1")){
                            Toast.makeText(MainActivityR3.this, "Προστέθηκε νέος ασθενής!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivityR3.this, "Σφάλμα στην Βάση Δεδομένων", Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                } else {
                    Toast.makeText(MainActivityR3.this, "Συμπλήρωστε όλα τα πεδία", Toast.LENGTH_SHORT).show();
                }



            }
        });


    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        myIP = sharedPreferences.getString(IP, "NOT_SET");
    }
}