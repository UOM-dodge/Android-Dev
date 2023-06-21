package com.example.curemeapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class RequestFragment_R9 extends Fragment {

    private String myIP, patient_amka;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_request_r9, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        assert getArguments() != null;
        myIP = getArguments().getString("myIP");
        patient_amka = getArguments().getString("userID");

        CalendarView calendarView = view.findViewById(R.id.request_calendar);
        RadioGroup rg = view.findViewById(R.id.request_calendar_rg);


        final String[] time = new String[1];
        final String[] serviceID = new String[1];



        populateSpinner(view);
        Spinner spinner = view.findViewById(R.id.services_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] serviceArr =  parent.getItemAtPosition(position).toString().split("- ");
                serviceID[0] = serviceArr[1];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        rg.removeAllViews();
        rg.setDividerPadding(100);

        for(int i=9; i<21; i++){
            RadioButton rb = new RadioButton(view.getContext());
            rb.setButtonDrawable(new StateListDrawable());
            rb.setBackgroundResource(R.drawable.radio_button_background);
            rb.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            rb.setPadding(10, 10, 10, 10);
            rb.setHighlightColor(Color.WHITE);

            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(30,10,30,10);
            rb.setLayoutParams(params);

            String hour = i+":00";
            rb.setText(hour);
            rb.setId(i);

            if(i==9){
                rb.setChecked(true);
            }

            rg.addView(rb);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) view.findViewById(checkedId);
                time[0] = String.valueOf(checkedId);
            }
        });


        final LocalDateTime[] localDateTime = {LocalDateTime.now()};

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                if(!time[0].isEmpty()){
                    localDateTime[0] = LocalDateTime.of(year, month+1, dayOfMonth, Integer.parseInt(time[0]), 0);
                }else {
                    localDateTime[0] = LocalDateTime.of(year, month+1, dayOfMonth, 9, 0);
                }



            }
        });


        Button confirmButton = view.findViewById(R.id.set_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!serviceID[0].equals("000")){
                    RequestHandle_R9 requestHandle = new RequestHandle_R9(myIP);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    String dateString = localDateTime[0].format(formatter);


                    String response = requestHandle.setPatientRequest(patient_amka, serviceID[0], dateString);
                    System.out.println(response);

                    // Refresh Activity
                    Intent intent = new Intent(v.getContext(), MainActivity_R9.class);
                    v.getContext().startActivity(intent);
                    Toast.makeText(v.getContext(), "Προστέθηκε νέο ραντεβού!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(v.getContext(), "Διαλέξτε παροχή!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void populateSpinner(View view){
        Spinner spinner = view.findViewById(R.id.services_spinner);
        List<ServiceObject_R8> services = new ArrayList<>();

        SearchObject_R8 searchObject = new SearchObject_R8(myIP);
        services = searchObject.requestServices();

        ArrayList<String> serviceNames = new ArrayList<>();

        for (int i=0; i<services.size(); i++){
            serviceNames.add(services.get(i).getName()+ " - "+services.get(i).getId());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, serviceNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

    }
}