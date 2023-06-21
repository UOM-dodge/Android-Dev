package com.example.curemeapp;

import java.util.ArrayList;

public class R4_Customer {
    ArrayList<R4_Visit> visits=new ArrayList<R4_Visit>();
    public R4_Customer(String ip,String patient_amka){
        //todo patient amka
        String url= "http://"+ip+"/cure_db/requestR4.php?patient_amka="+patient_amka;
        try {

            R4_OkHttpHandler okHttpHandler = new R4_OkHttpHandler();
            visits = okHttpHandler.cure(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<R4_Visit> getVisits() {
        return visits;
    }

}