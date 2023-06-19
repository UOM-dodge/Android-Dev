package com.example.curemeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivityR3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r3);


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
                        SendObjectR3 sendObject = new SendObjectR3();
                        String response = sendObject.sendPatientData(patient);
                        System.out.println(response);
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                        Toast.makeText(MainActivityR3.this, "Προστέθηκε νέος ασθενής!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivityR3.this, "Σφάλμα στην Βάση Δεδομένων", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivityR3.this, "Συμπλήρωστε όλα τα πεδία", Toast.LENGTH_SHORT).show();
                }



            }
        });








    }
}