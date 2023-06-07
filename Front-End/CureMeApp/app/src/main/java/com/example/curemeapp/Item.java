package com.example.curemeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int image;
    private int requestID;
//    private String description;
    private String fullName;

    private String DateString;
    private LocalDateTime localDateTime;
    private String status;

    public Item(int requestID, String fullName, LocalDateTime localDateTime, String status, int image) {
        this.requestID = requestID;
        this.fullName = fullName;
        this.image = image;
        this.localDateTime = localDateTime;
        this.status = status;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateString = localDateTime.format(dateTimeFormatter);
        return DateString;
    }

    public void setDateString(String dateString) {
        DateString = dateString;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
