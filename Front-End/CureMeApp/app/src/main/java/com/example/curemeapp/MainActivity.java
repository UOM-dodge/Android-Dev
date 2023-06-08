package com.example.curemeapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private final String myIP = "192.168.1.3";
            //"192.168.1.68";
    List<Patient> patientList;
    SearchView searchView;
    RecyclerView recyclerView;
    TextView notFoundTextView;

    RelativeLayout notFoundLayout;
    ImageView notFoundImageView;
    ArrayList<Patient> arrayList = new ArrayList<Patient>();

//    String[] contactList = new String[]{"Mary Ting", "George Papas", "Athina Pratsoulaki"};
//
//    int[] imgList = new int[]{R.drawable.cont2, R.drawable.images, R.drawable.contact3};
//
//    String[]AMKAList = new String[]{"04060912836","09018374217","2507826102938"};
//    String[]phoneList = new String[]{"6987345672","6978823965","6904350867"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            this.patientList = okHttpHandler.requestPatientData(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < contactList.length; i++) {
//            ModelClass modelClass = new ModelClass();
//            modelClass.setPhone(phoneList[i]);
//            modelClass.setName(contactList[i]);
//            modelClass.setImg(imgList[i]);
//            modelClass.setAMKA(AMKAList[i]);
//            arrayList.add(modelClass);
//        }


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ContactsAdapter contactsAdapter = new ContactsAdapter(arrayList,patientList);
        recyclerView.setAdapter(contactsAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {@Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Patient> filteredList = new ArrayList<>();

                for (Patient item : arrayList) {
                    if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                        filteredList.add(item);
                    }
                }

                ContactsAdapter contactsAdapter = (ContactsAdapter) recyclerView.getAdapter();
                //ayto to if den yphrxe mporei kai na to bgalw
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


}





