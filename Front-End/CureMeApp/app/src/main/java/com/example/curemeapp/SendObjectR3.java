package com.example.curemeapp;

public class SendObjectR3 {
    final String myIP = "192.168.1.2";
    PatientR3 patient;


    public String sendPatientData(PatientR3 patient){
        String url = "http://"+myIP+"/cure_db/sendPatientData.php?first_name="+patient.getFirstName()+
                        "&last_name="+patient.getLastName()+
                        "&email="+patient.getEmail()+
                        "&address="+patient.getAddress()+
                        "&amka="+patient.getAmka();

        String response = null;

        try {
            OkHttpHandlerR3 okHttpHandler = new OkHttpHandlerR3();
            response = okHttpHandler.sendPatientData(url);
        }catch (Exception e) {
            e.printStackTrace();
        }


        return response;
    }
}
