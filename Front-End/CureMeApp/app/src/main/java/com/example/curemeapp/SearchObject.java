package com.example.curemeapp;

import java.util.ArrayList;
import java.util.List;

public class SearchObject {
    final String myIP = "192.168.1.61";
    private List<Event> events = new ArrayList<>();


    public SearchObject(){

    }

    public List<Event> searchEvents(String amka_id, String range, String range_end){
        String url = "http://"+myIP+"/cure_db/searchEvents.php?amka_id="+amka_id+"&range="+range+"&range_end="+range_end;


        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            this.events = okHttpHandler.searchEvents(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

    public List<Event> searchEventsWithAmka(String amka_id){
        String url = "http://"+myIP+"/cure_db/searchEvents.php?amka_id="+amka_id;


        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            this.events = okHttpHandler.searchEvents(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

    public List<Event> searchEventsWithDate(String range, String range_end){
        String url = "http://"+myIP+"/cure_db/searchEvents.php?range="+range+"&range_end="+range_end;


        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            this.events = okHttpHandler.searchEvents(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

}
