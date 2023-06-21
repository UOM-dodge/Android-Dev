package com.example.curemeapp;

import java.util.ArrayList;
import java.util.List;

public class SearchObject_R8 {
    final String myIP = "192.168.1.100";
    private List<Event_R8> events = new ArrayList<>();
    private List<ServiceObject_R8> services = new ArrayList<>();


    public SearchObject_R8(){

    }

    public List<Event_R8> searchEvents(String amka_id, String range, String range_end, String doctor_id){
        String url = "http://"+myIP+"/cure_db/searchEvents.php?amka_id="+amka_id+"&range="+range+"&range_end="+range_end+"&doctor_id="+doctor_id;


        try {
            OkHttpHandler_R8 okHttpHandler = new OkHttpHandler_R8();
            this.events = okHttpHandler.searchEvents(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

    public List<Event_R8> searchEventsWithAmka(String amka_id){
        String url = "http://"+myIP+"/cure_db/searchEvents.php?amka_id="+amka_id;


        try {
            OkHttpHandler_R8 okHttpHandler = new OkHttpHandler_R8();
            this.events = okHttpHandler.searchEvents(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }

    public List<Event_R8> searchEventsWithDate(String range, String range_end, String doctor_id){
        String url = "http://"+myIP+"/cure_db/searchEvents.php?range="+range+"&range_end="+range_end+"&doctor_id="+doctor_id;


        try {
            OkHttpHandler_R8 okHttpHandler = new OkHttpHandler_R8();
            this.events = okHttpHandler.searchEvents(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return events;
    }


    public List<ServiceObject_R8> requestServices(){
        String url = "http://"+myIP+"/cure_db/requestServices.php?";

        try {
            OkHttpHandler_R8 okHttpHandler = new OkHttpHandler_R8();
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
            OkHttpHandler_R8 okHttpHandler = new OkHttpHandler_R8();
            response = okHttpHandler.setServices(url);
        } catch (Exception e){
            e.printStackTrace();
            return "SET FAILED";
        }

        return response;

    }


    public String setService(String eventID, String serviceID, String doctor_id, String dateNow) {
        String response = "SET FAILED";
        String url = "";

        if (!serviceID.equals("000")){
            //todo new
            url = "http://"+myIP+"/cure_db/completeRequest.php?event_id="+eventID+"&doctor_id="+doctor_id+"&date="+dateNow+"&service_id="+serviceID;
        }

        else {
            //todo new
            url = "http://"+myIP+"/cure_db/completeRequest.php?event_id="+eventID+"&doctor_id="+doctor_id+"&date="+dateNow;
        }

        try {
            OkHttpHandler_R8 okHttpHandler = new OkHttpHandler_R8();
            response = okHttpHandler.setServices(url);
        } catch (Exception e){
            e.printStackTrace();
            return "SET FAILED";
        }

        return response;
    }
}
