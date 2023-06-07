package com.example.curemeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RequestObject {
    String range_start;
    private List<Item> items = new ArrayList<>();

    private final String myIP = "192.168.1.100";

    public RequestObject() {

    }

    public List<Item> requestItems() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        range_start = localDateTime.format(f);


        String url = "http://"+myIP+"/cure_db/requestItems.php?range_start="+range_start;

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            this.items = okHttpHandler.requestItems(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    public String requestConfirmed(int requestID){
        String url = "http://"+myIP+"/cure_db/requestConfirmed.php?requestID="+requestID;
        String response = null;
        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            response = okHttpHandler.requestConfirmed(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public String requestCanceled(int requestID){
        String url = "http://"+myIP+"/cure_db/requestCanceled.php?requestID="+requestID;
        String response = null;
        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            response = okHttpHandler.requestConfirmed(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
