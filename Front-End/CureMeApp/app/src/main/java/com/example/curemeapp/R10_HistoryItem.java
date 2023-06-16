package com.example.curemeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class R10_HistoryItem {
    String dateString, serviceName, price, itemID, doctorName, physioCenterName;
    LocalDateTime dateTime;

    public R10_HistoryItem(String serviceName, String price, LocalDateTime dateTime, String itemID, String doctorName, String physioCenterName) {
        this.serviceName = serviceName;
        this.price = price;
        this.dateTime = dateTime;
        this.itemID = itemID;
        this.doctorName = doctorName;
        this.physioCenterName = physioCenterName;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
}
