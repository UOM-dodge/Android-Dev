package com.example.curemeapp;

import static com.example.curemeapp.LogInActivity.IP;
import static com.example.curemeapp.LogInActivity.SHARED_PREFS;


import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivityR2 extends AppCompatActivity {
    private String myIP;
    EditText code,name,description,cost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r2);
        loadData();


        //LOGO ACTION BAR - START
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_200);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //LOGO ACTION BAR - END

        /*error message id text-fields are empty*/
        code= (EditText) findViewById(R.id.code_input);
        name=(EditText) findViewById(R.id.name_input);
        description=(EditText) findViewById(R.id.description_input);
        cost=(EditText) findViewById(R.id.cost_input);



        Button buttonShow = findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                /* message if text-fields are empty else button on*/

                if (code.length() == 0) {
                    code.setError("Πληκτρολογήστε κωδικό");
                }
                else if (name.length() == 0) {
                    name.setError("Πληκτρολογήστε όνομα");
                }
                else if (description.length() == 0) {
                    description.setError("Πληκτρολογήστε περιγραφή");
                }
                else if (cost.length() == 0) {
                    cost.setError("Πληκτρολογήστε κόστος");
                }
                else {


                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                            MainActivityR2.this, R.style.BottomSheetDialogTheme
                    );
                    View bottomSheetView = LayoutInflater.from(getApplicationContext())
                            .inflate(
                                    R.layout.layout_bottom_sheet_r2,
                                    (LinearLayout) findViewById(R.id.bottomSheetContainer)
                            );
                    bottomSheetView.findViewById(R.id.button_confirm).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ServiceSendObjectR2 sendObject = new ServiceSendObjectR2(myIP);
                            String response = sendObject.setServiceData(name.getText().toString(), code.getText().toString(), description.getText().toString(), cost.getText().toString());

                            if (!response.equals("SET FAILED")){
                                Toast.makeText(MainActivityR2.this, "Εισαγωγή παροχής επιτυχής", Toast.LENGTH_SHORT).show();
                                bottomSheetDialog.dismiss();


                                //Restart
                                finish();
                                overridePendingTransition(0,0);
                                startActivity(getIntent());
                                overridePendingTransition(0,0);

                            } else {
                                Toast.makeText(MainActivityR2.this, "Σφάλμα εισαγωγής", Toast.LENGTH_SHORT).show();
                                bottomSheetDialog.dismiss();

                                //Restart
                                finish();
                                overridePendingTransition(0,0);
                                startActivity(getIntent());
                                overridePendingTransition(0,0);
                            }


                        }
                    });
                    bottomSheetDialog.setContentView(bottomSheetView);

                    bottomSheetView.findViewById(R.id.button_exit).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivityR2.this, "Exit", Toast.LENGTH_SHORT).show();
                            bottomSheetDialog.dismiss();

                        }
                    });

                    bottomSheetDialog.show();

                }
            }
        });
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        myIP = sharedPreferences.getString(IP, "NOT_SET");
    }
}