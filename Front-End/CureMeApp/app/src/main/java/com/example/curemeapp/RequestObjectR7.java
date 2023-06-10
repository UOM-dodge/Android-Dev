package com.example.curemeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RequestObjectR7 {
    String range_start;
    private List<ItemR7> items = new ArrayList<>();

    private final String myIP = "192.168.1.100";

    public RequestObjectR7() {

    }

    public List<ItemR7> requestItems() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        range_start = localDateTime.format(f);


        String url = "http://"+myIP+"/cure_db/requestItems.php?range_start="+range_start;

        try {
            OkHttpHandlerR7 okHttpHandler = new OkHttpHandlerR7();
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
            OkHttpHandlerR7 okHttpHandler = new OkHttpHandlerR7();
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
            OkHttpHandlerR7 okHttpHandler = new OkHttpHandlerR7();
            response = okHttpHandler.requestConfirmed(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
