package com.example.curemeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    String event_id;
    String patientFullName;
    String amka_id;
    LocalDateTime date_time;
    String dateString;
    String status;
    int image;

    public Event(String event_id, String patientFullName, String amka_id, LocalDateTime date_time, String status, int image) {
        this.event_id = event_id;
        this.patientFullName = patientFullName;
        this.amka_id = amka_id;
        this.date_time = date_time;
        this.status = status;
        this.image = image;
    }

    public String getAmka_id() {
        return amka_id;
    }

    public void setAmka_id(String amka_id) {
        this.amka_id = amka_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
