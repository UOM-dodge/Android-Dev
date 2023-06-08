package com.example.curemeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class R1Activity extends MainActivity {

    final String myIP = "192.168.1.3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.r1);

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
                    PhysioCenterObject phCntr = new PhysioCenterObject(AFMView.getText().toString(),
                                                                        physioNameView.getText().toString(),
                                                                        addressView.getText().toString());

                    try {
                        SendObject sendObject = new SendObject();
                        String response = sendObject.sendPhysioData(phCntr);
                        System.out.println(response);
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                        Toast.makeText(R1Activity.this, "Προστέθηκε νέο Φυσιοθεραπευτήριο!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(R1Activity.this, "Σφάλμα στην Βάση Δεδομένων", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(R1Activity.this, "Συμπλήρωστε όλα τα πεδία", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
