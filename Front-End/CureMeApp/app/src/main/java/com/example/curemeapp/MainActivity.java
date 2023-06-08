package com.example.curemeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

                    Patient patient = new Patient(  fullNameView.getText().toString(),
                            emailView.getText().toString(),
                            addressView.getText().toString(),
                            amkaView.getText().toString());


                    try {
                        SendObject sendObject = new SendObject();
                        String response = sendObject.sendPatientData(patient);
                        System.out.println(response);
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                        Toast.makeText(MainActivity.this, "Προστέθηκε νέος ασθενής!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Σφάλμα στην Βάση Δεδομένων", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Συμπλήρωστε όλα τα πεδία", Toast.LENGTH_SHORT).show();
                }



            }
        });








    }
}