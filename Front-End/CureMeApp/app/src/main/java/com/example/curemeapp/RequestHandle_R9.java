package com.example.curemeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RequestHandle_R9 {
    private final String myIP = "192.168.1.100";
    private List<Event_R9> events = new ArrayList<>();

    public RequestHandle_R9(){

    }


    public String setPatientRequest(String patient_amka, String physio_center, String date_time){
        String response = "SET FAILED";
        String url =    "http://"+myIP+"cure_db/setPatientRequest.php"+
                        "?patient_amka="+patient_amka+
                        "&physio_center="+physio_center+
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
