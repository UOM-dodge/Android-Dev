package com.example.curemeapp;

public class Item {
    private int image;
    private String description;
    private String name;

    public Item(String description, String name, int image) {
        this.description = description;
        this.name = name;
        this.image = image;
    }
    public String getDescription() {
        return description;
    }



    public String getName() {
        return name;
    }



    public int getImage() {
        return image;
    }








}
