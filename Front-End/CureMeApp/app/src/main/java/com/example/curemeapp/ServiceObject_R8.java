package com.example.curemeapp;

public class ServiceObject_R8 {

    String name, id, physioCenter;


    public ServiceObject_R8(String name, String id, String physioCenter) {
        this.name = name;
        this.id = id;
        this.physioCenter = physioCenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhysioCenter() {
        return physioCenter;
    }

    public void setPhysioCenter(String physioCenter) {
        this.physioCenter = physioCenter;
    }
}
