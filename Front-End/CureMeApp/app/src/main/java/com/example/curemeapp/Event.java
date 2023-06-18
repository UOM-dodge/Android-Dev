package com.example.curemeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Event {
    String dateString, serviceName, price, daysLeft, itemID, doctorName, physioCenterName, status;
    LocalDateTime dateTime;


    public Event(String serviceName, String price, String itemID, String doctorName, String physioCenterName, LocalDateTime dateTime, String status) {
        this.serviceName = serviceName;
        this.price = price;
        this.itemID = itemID;
        this.doctorName = doctorName;
        this.physioCenterName = physioCenterName;
        this.dateTime = dateTime;
        this.status = status;
    }

    public String getDateString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        dateString = dateTime.format(formatter);
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDaysLeft() {
        LocalDateTime dateNow = LocalDateTime.now();
        long left = dateNow.until(dateTime, ChronoUnit.DAYS);
        return String.valueOf(left);
    }

    public void setDaysLeft(String daysLeft) {
        this.daysLeft = daysLeft;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPhysioCenterName() {
        return physioCenterName;
    }

    public void setPhysioCenterName(String physioCenterName) {
        this.physioCenterName = physioCenterName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
