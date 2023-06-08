package com.example.curemeapp;

import java.util.List;

public class SendObject {
    final String myIP = "192.168.1.2";
    Patient patient;


    public String sendPatientData(Patient patient){
        String url = "http://"+myIP+"/cure_db/sendPatientData.php?first_name="+patient.getFirstName()+
                        "&last_name="+patient.getLastName()+
                        "&email="+patient.getEmail()+
                        "&address="+patient.getAddress()+
                        "&amka="+patient.getAmka();

        String response = null;

        try {
            OkHttpHandler okHttpHandler = new OkHttpHandler();
            response = okHttpHandler.sendPatientData(url);
        }catch (Exception e) {
            e.printStackTrace();
        }


        return response;
    }
}
