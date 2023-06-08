package com.example.curemeapp;

public class PhysioCenterObject {
    final String myIP = "192.168.1.3";

    String AFM, address, physioName;

    public PhysioCenterObject(String AFM, String address, String physioName) {
        this.AFM = AFM;
        this.address = address;
        this.physioName = physioName;
    }

    public String getMyIP() {
        return myIP;
    }

    public String getAFM() {
        return AFM;
    }

    public void setAFM(String AFM) {
        this.AFM = AFM;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhysioName() {
        return this.physioName;
    }

    public void setPhysioName(String physioName) {
        this.physioName = physioName;
    }
}
