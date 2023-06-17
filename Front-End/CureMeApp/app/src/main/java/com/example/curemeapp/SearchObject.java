package com.example.curemeapp;

import java.util.ArrayList;
import java.util.List;

public class SearchObject {
    final String myIP = "192.168.1.100";
    private List<Event> events = new ArrayList<>();
    private List<ServiceObject> services = new ArrayList<>();


    public SearchObject(){

    }

    public List<Event> searchEvents(String amka_id, String range, String range_end, String doctor_id){
        String url = "http://"+myIP+"/cure_db/searchEvents.php?amka_id="+amka_id+"&range="+range+"&range_end="+range_end+"&doctor_id="+doctor_id;


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

    public List<Event> searchEventsWithDate(String range, String range_end, String doctor_id){
        String url = "http://"+myIP+"/cure_db/searchEvents.php?range="+range+"&range_end="+range_end+"&doctor_id="+doctor_id;


        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            this.events = okHttpHandler.searchEvents(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }


    public List<ServiceObject> requestServices(){
        String url = "http://"+myIP+"/cure_db/requestServices.php?";

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            this.services = okHttpHandler.requestServices(url);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return services;
    }


    public String setService(String eventID, String serviceID, String notes){
        String response = "SET FAILED";
        String url = "";

        if (!serviceID.equals("000")){
            url = "http://"+myIP+"/cure_db/setServices.php?event_id="+eventID+"&service_id="+serviceID+"&notes="+notes;
            //todo add notes as output stream on POST body


        }

        else {
            url = "http://"+myIP+"/cure_db/setServices.php?event_id="+eventID+"&notes="+notes;
        }

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            response = okHttpHandler.setServices(url);
        } catch (Exception e){
            e.printStackTrace();
            return "SET FAILED";
        }

        return response;

    }


}
