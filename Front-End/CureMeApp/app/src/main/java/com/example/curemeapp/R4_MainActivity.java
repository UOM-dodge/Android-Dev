package com.example.curemeapp;

import static com.example.curemeapp.LogInActivity.IP;
import static com.example.curemeapp.LogInActivity.SHARED_PREFS;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class R4_MainActivity extends AppCompatActivity {



    private String myIP, patient_amka;


    TextView textView;

    ListView listView;

    ArrayList<String> dateList=new ArrayList<String>();
    ArrayList<String> eventIdList =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.r4_activity_main);
        loadData();

        //LOGO ACTION BAR - START
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_200);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //LOGO ACTION BAR - END

        Bundle bundle = getIntent().getExtras();
        patient_amka = bundle.getString("patient_amka");


        textView= (TextView) findViewById(R.id.R4_nameText);
        listView=(ListView) findViewById(R.id.R4_listViewId);


        R4_Customer customer = new R4_Customer(myIP, patient_amka);

        String[] fullName = customer.getVisits().get(1).getFullName().split(" ");


        textView.setText(" "+fullName[0]+ "\n "+fullName[1]);
        for(R4_Visit i: customer.getVisits()){
            dateList.add(i.getDateString());
            eventIdList.add(i.getService_id());

        }

        R4_CustomAdapter arrayAdapter=new R4_CustomAdapter
                (getApplicationContext(), eventIdList, dateList);
        listView.setAdapter(arrayAdapter);

    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        myIP = sharedPreferences.getString(IP, "NOT_SET");
    }
}
