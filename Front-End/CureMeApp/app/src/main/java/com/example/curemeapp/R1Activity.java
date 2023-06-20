package com.example.curemeapp;

import static com.example.curemeapp.LogInActivity.IP;
import static com.example.curemeapp.LogInActivity.SHARED_PREFS;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class R1Activity extends MainActivityR1 {

    private String myIP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r1);
        loadData();

        //LOGO ACTION BAR - START
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_200);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //LOGO ACTION BAR - END

        TextView AFMView, physioNameView, addressView;

        AFMView =  findViewById(R.id.code_input);
        physioNameView = findViewById(R.id.name_input);
        addressView = findViewById(R.id.description_input);

        Button r1CreateBtn = findViewById(R.id.r1CreateBtn);

        r1CreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!AFMView.getText().toString().isEmpty() &&
                    !physioNameView.getText().toString().isEmpty() &&
                    !addressView.getText().toString().isEmpty()) {
                    // TODO TextInputLayout .setError


                    // TODO AFM check
                    PhysioCenterObjectR1 phCntr = new PhysioCenterObjectR1(AFMView.getText().toString(),
                                                                        addressView.getText().toString(),
                                                                        physioNameView.getText().toString());

                    try {
                        SendObjectR1 sendObject = new SendObjectR1(myIP);
                        String response = sendObject.sendPhysioData(phCntr);
                        System.out.println(response);
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                        if (response.equals("1")){
                            Toast.makeText(R1Activity.this, "Προστέθηκε νέο Φυσιοθεραπευτήριο!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(R1Activity.this, "Σφάλμα στην Βάση Δεδομένων", Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                } else {
                    Toast.makeText(R1Activity.this, "Συμπλήρωστε όλα τα πεδία", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        myIP = sharedPreferences.getString(IP, "NOT_SET");
    }
}
