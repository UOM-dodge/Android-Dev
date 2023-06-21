package com.example.curemeapp;


import static com.example.curemeapp.LogInActivity.IP;
import static com.example.curemeapp.LogInActivity.SHARED_PREFS;
import static com.example.curemeapp.LogInActivity.USER_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivityR5 extends AppCompatActivity  {

    private String myIP, userID;
    List<PatientR5> patientList;
    SearchView searchView;
    RecyclerView recyclerView;
    TextView notFoundTextView;

    RelativeLayout notFoundLayout;
    ImageView notFoundImageView;
    ArrayList<PatientR5> arrayList = new ArrayList<PatientR5>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r5);
        loadData();

        //LOGO ACTION BAR - START
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_200);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //LOGO ACTION BAR - END



        ImageView imageView = findViewById(R.id.imageView);
        notFoundLayout = findViewById(R.id.notFoundLayout);
        searchView = findViewById(R.id.searchView);
        notFoundTextView = findViewById(R.id.notFoundTextView);
        notFoundImageView = findViewById(R.id.notFoundImageView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        searchView.setIconified(false);
        searchView.clearFocus();


        String url = "http://"+myIP+"/cure_db/requestPatientData.php";

        try {
            OkHttpHandlerR5 okHttpHandler = new OkHttpHandlerR5();
             this.patientList = okHttpHandler.requestPatientData(url);
            arrayList.addAll(okHttpHandler.requestPatientData(url));
        } catch (Exception e) {
            e.printStackTrace();
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivityR5.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ContactsAdapterR5 contactsAdapter = new ContactsAdapterR5(patientList);
        recyclerView.setAdapter(contactsAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<PatientR5> filteredList = new ArrayList<>();

                for (PatientR5 item : patientList) {
                    if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                        filteredList.add(item);
                    }
                }

                ContactsAdapterR5 contactsAdapter = (ContactsAdapterR5) recyclerView.getAdapter();
                if (contactsAdapter != null) {
                    if (filteredList.isEmpty()) {
                        // Show the "Item not found" message and image
                        notFoundLayout.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                    } else {
                        // Hide the "Item not found" message and image
                        notFoundLayout.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        contactsAdapter.setFilteredList(filteredList);
                    }
                }
                return true;
            }
        });


    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        myIP = sharedPreferences.getString(IP, "NOT_SET");
        userID = sharedPreferences.getString(USER_ID, "NOT_SET");
    }


}





