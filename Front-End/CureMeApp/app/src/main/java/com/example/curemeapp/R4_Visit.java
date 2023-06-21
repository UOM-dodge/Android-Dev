package com.example.curemeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class R4_Visit {
    private String dateString, patient_amka, service_id, fullName;
    LocalDateTime dateTime;


    public R4_Visit(LocalDateTime dateTime, String patient_amka, String fullName, String service_id){
        this.dateTime = dateTime;
        this.patient_amka = patient_amka;
        this.fullName = fullName;
        this.service_id = service_id;
    }


    public String getDateString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dateString = dateTime.format(formatter);

        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getPatient_amka() {
        return patient_amka;
    }

    public void setPatient_amka(String patient_amka) {
        this.patient_amka = patient_amka;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

