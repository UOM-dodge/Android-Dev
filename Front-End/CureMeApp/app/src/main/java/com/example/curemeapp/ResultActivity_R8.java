package com.example.curemeapp;

import static com.example.curemeapp.LogInActivity.IP;
import static com.example.curemeapp.LogInActivity.SHARED_PREFS;
import static com.example.curemeapp.LogInActivity.USER_ID;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ResultActivity_R8 extends AppCompatActivity implements SelectListener_R8 {

    private String myIP, doctor_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity_r8);
        loadData();

        //LOGO ACTION BAR - START
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_200);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //LOGO ACTION BAR - END

        List<Event_R8> events = new ArrayList<>();

        SearchObject_R8 searchObject = new SearchObject_R8(myIP);


        Bundle bundle = getIntent().getExtras();

        String amka_id = bundle.getString("amka_id");
        String dateString = bundle.getString("date");
        String dateEnd = bundle.getString("dateEnd");

        if (!amka_id.equals("000")){
            events = searchObject.searchEvents(amka_id, dateString, dateEnd, doctor_id);
        }
        else {
            events = searchObject.searchEventsWithDate(dateString, dateEnd, doctor_id);
        }




        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new EventAdapter_R8(getApplicationContext(), events, this));



        populateSpinner();

        Button setButton = findViewById(R.id.set_button);
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner = findViewById(R.id.spinner);
                String[] serviceID = spinner.getSelectedItem().toString().split("- ");

                TextView eventIDView = findViewById(R.id.event_id_properties);
                String[] eventID = eventIDView.getText().toString().split(": ");

                TextView notesView = findViewById(R.id.notes);
                String notes = notesView.getText().toString();

                SearchObject_R8 searchObject = new SearchObject_R8(myIP);

                TextView type = findViewById(R.id.edit_type);
                String typeString = type.getText().toString();

                String response = null;
                //todo make toast for no change
                if(typeString.equals("REQUEST")){
                    LocalDateTime dateNow = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    String dateStringNow = dateNow.format(formatter);
                    response = searchObject.setService(eventID[1], serviceID[1], doctor_id, dateStringNow);
                    System.out.println(response);
                    Toast.makeText(getApplicationContext(), "Ραντεβού εκτελέστηκε!", Toast.LENGTH_SHORT).show();

                } else if (typeString.equals("SESSION")) {
                    response = searchObject.setService(eventID[1], serviceID[1], notes);
                    System.out.println(response);
                    Toast.makeText(getApplicationContext(), "Επεξεργασία επιτυχής!", Toast.LENGTH_SHORT).show();
                }


                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);

            }
        });







    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        myIP = sharedPreferences.getString(IP, "NOT_SET");
        doctor_id = sharedPreferences.getString(USER_ID, "NOT_SET");
    }



    private void populateSpinner(){
        Spinner spinner = findViewById(R.id.spinner);
        List<ServiceObject_R8> services = new ArrayList<>();

        SearchObject_R8 searchObject = new SearchObject_R8(myIP);
        services = searchObject.requestServices();

        ArrayList<String> serviceNames = new ArrayList<>();


        for (int i=0; i<services.size(); i++){
            serviceNames.add(services.get(i).getName()+ " - "+services.get(i).getId());
        }



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, serviceNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] serviceID =  parent.getItemAtPosition(position).toString().split("- ");


                System.out.println(serviceID[1]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onItemClicked(String eventID, String type) {
        RelativeLayout setProperties = findViewById(R.id.setProperties);
        setProperties.setVisibility(View.VISIBLE);

        TextView eventIDProperties = findViewById(R.id.event_id_properties);
        eventIDProperties.setText("Αρ. Ραντεβού: "+ eventID);
        TextView eventType = findViewById(R.id.edit_type);
        eventType.setText(type);

        if (type.equals("REQUEST")){
            EditText notes = findViewById(R.id.notes);
            notes.setVisibility(View.GONE);
            Button setButton = findViewById(R.id.set_button);
            setButton.setText("Προσθήκη Επίσκεψης");
        } else if (type.equals("SESSION")) {
            EditText notes = findViewById(R.id.notes);
            notes.setVisibility(View.VISIBLE);
            Button setButton = findViewById(R.id.set_button);
            setButton.setText("Επιβεβαίωση Επεξεργασίας");
        }


    }

    @Override
    public void onSetButtonClick(String serviceID) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        RelativeLayout setProperties = findViewById(R.id.setProperties);
        setProperties.setVisibility(View.GONE);

    }
}
