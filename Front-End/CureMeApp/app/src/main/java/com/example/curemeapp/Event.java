package com.example.curemeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    String event_id;
    String patientFullName;
    String patientAMKA;
    LocalDateTime date_time;
    String dateString;
    String serviceID;
    int image;
    String physio_center;

    public Event(String event_id, String patientFullName, String patientAMKA, LocalDateTime date_time, String serviceID, int image, String physio_center) {
        this.event_id = event_id;
        this.patientFullName = patientFullName;
        this.patientAMKA = patientAMKA;
        this.date_time = date_time;
        this.serviceID = serviceID;
        this.image = image;
        this.physio_center = physio_center;
    }

    public String getPatientAMKA() {
        return patientAMKA;
    }

    public void setPatientAMKA(String patientAMKA) {
        this.patientAMKA = patientAMKA;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public String getDateString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        dateString = date_time.format(dateTimeFormatter);
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
