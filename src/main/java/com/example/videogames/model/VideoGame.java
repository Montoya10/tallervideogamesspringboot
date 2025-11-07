package com.example.videogames.model;

public class VideoGame {

    private String title;
    private String description;
    private double price;
    private String image; // nombre del archivo de imagen

    public VideoGame(String title, String description, double price, String image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getImage() { return image; }
}
