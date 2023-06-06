package com.example.curemeapp;

public class Patient {
    String name,phoneNumber,AMKA;
    int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAMKA() {
        return AMKA;
    }

    public void setAMKA(String AMKA) {
        this.AMKA = AMKA;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Patient(String name, String phoneNumber, String AMKA, int image) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.AMKA = AMKA;
        this.image = image;
    }
}
