package com.example.curemeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivityR2 extends AppCompatActivity {

    EditText code,name,description,cost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r2);

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
                            Toast.makeText(MainActivityR2.this, "Εισαγωγή παροχής επιτυχής", Toast.LENGTH_SHORT).show();
                            bottomSheetDialog.dismiss();

                            EditText code = (EditText) findViewById(R.id.code_input);
                            EditText name=(EditText) findViewById(R.id.name_input);
                            EditText description =(EditText) findViewById(R.id.description_input);
                            EditText cost=(EditText) findViewById(R.id.cost_input);

                            code.setText("");
                            name.setText("");
                            description.setText("");
                            cost.setText("");

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
}