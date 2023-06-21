package com.example.curemeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RequestHandle_R9 {
    private String myIP;
    private List<Event_R9> events = new ArrayList<>();

    public RequestHandle_R9(String myIP){
        this.myIP = myIP;

    }


    public String setPatientRequest(String patient_amka, String service_id, String date_time){
        String response = "SET FAILED";
        String url =    "http://"+myIP+"/cure_db/setPatientRequest.php"+
                        "?patient_amka="+patient_amka+
                        "&service_id="+service_id+
                        "&date_time="+date_time;

        try {
            OkHttpHandler_R9 okHttpHandler = new OkHttpHandler_R9();
            response = okHttpHandler.setPatientRequest(url);
        }catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }

    public List<Event_R9> requestUpcomingVisits(String patient_amka){
        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = dateNow.format(formatter);


        String url = "http://"+myIP+"/cure_db/requestUpcomingVisits.php?patient_amka="+patient_amka
                                                                        +"&date_time="+today;

        try {
            OkHttpHandler_R9 okHttpHandler = new OkHttpHandler_R9();
            this.events = okHttpHandler.requestUpcomingVisits(url);
        }catch (Exception e){
            e.printStackTrace();
        }

        return events;
    }

}
