package com.example.curemeapp;

public class PatientR3 {

    String fullName, firstName, lastName;
    String email;
    String amka;
    String address;


    public PatientR3(String fullName, String email, String amka, String address) {
        this.fullName = fullName;
        this.email = email;
        this.amka = amka;
        this.address = address;
    }

    public String getFirstName() {
        String[] splitString = fullName.split(" ");
        return splitString[0];
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        String[] splitString = fullName.split(" ");
        return splitString[1];
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
