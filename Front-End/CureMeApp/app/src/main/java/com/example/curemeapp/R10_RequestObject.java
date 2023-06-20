package com.example.curemeapp;

import java.util.ArrayList;
import java.util.List;

public class R10_RequestObject {
    private String myIP;

    private List<R10_HistoryItem> items = new ArrayList<>();

    public R10_RequestObject(String myIP){
        this.myIP = myIP;
    }


    public List<R10_HistoryItem> requestItems(String patient_amka){

        String url = "http://"+myIP+"/cure_db/requestHistoryItems.php?patient_amka="+patient_amka;


        try {
            R10_OkHttpHandler okHttpHandler = new R10_OkHttpHandler();
            this.items = okHttpHandler.requestItems(url);
        } catch (Exception e) {
            e.printStackTrace();
        }



        return items;
    }
}
