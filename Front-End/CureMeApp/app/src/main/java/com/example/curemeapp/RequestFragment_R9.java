package com.example.curemeapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class RequestFragment_R9 extends Fragment {

    private String myIP, userID;

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
        userID = getArguments().getString("userID");

        CalendarView calendarView = view.findViewById(R.id.request_calendar);
        RadioGroup rg = view.findViewById(R.id.request_calendar_rg);
        Spinner spinner = view.findViewById(R.id.services_spinner);

        rg.removeAllViews();
        rg.setDividerPadding(100);

        for(int i=9; i<21; i++){
            RadioButton rb = new RadioButton(view.getContext());
            rb.setButtonDrawable(new StateListDrawable());
            rb.setBackgroundResource(R.drawable.radio_button_background);
            rb.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
            rb.setPadding(10, 10, 10, 10);
            rb.setHighlightColor(Color.BLACK);

            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(30,10,30,10);
            rb.setLayoutParams(params);

            String hour = i+":00";
            rb.setText(hour);
            rb.setId(i);
            rg.addView(rb);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) view.findViewById(checkedId);
                Toast.makeText(view.getContext(), String.valueOf(checkedId), Toast.LENGTH_SHORT).show();
            }
        });





    }
}