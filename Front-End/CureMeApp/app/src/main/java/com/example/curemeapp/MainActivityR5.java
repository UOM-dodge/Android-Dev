package com.example.curemeapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivityR5 extends AppCompatActivity  {

    private final String myIP = "192.168.1.3";
            //"192.168.1.68";
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

        ContactsAdapter contactsAdapter = new ContactsAdapter(patientList);
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

                ContactsAdapter contactsAdapter = (ContactsAdapter) recyclerView.getAdapter();
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

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {@Override
//        public boolean onQueryTextSubmit(String query) {
//            return false;
//        }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                ArrayList<Patient> filteredList = new ArrayList<>();
//
//                for (Patient item : patientList) {
//                    if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
//                        filteredList.add(item);
//                    }
//                }
//
//                ContactsAdapter contactsAdapter = (ContactsAdapter) recyclerView.getAdapter();
//                //ayto to if den yphrxe mporei kai na to bgalw
//                if (contactsAdapter != null) {
//                    if (filteredList.isEmpty()) {
//                        // Show the "Item not found" message and image
//                        notFoundLayout.setVisibility(View.VISIBLE);
//                        recyclerView.setVisibility(View.GONE);
//                    } else {
//                        // Hide the "Item not found" message and image
//                        notFoundLayout.setVisibility(View.GONE);
//                        recyclerView.setVisibility(View.VISIBLE);
//                        contactsAdapter.setFilteredList(filteredList);
//                    }
//                }
//                return true;
//            }
//        });

    }


}





