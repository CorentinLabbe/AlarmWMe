package com.example.alarmwme.model;

public class Food {
    private String title;
    private String id;
    private String region;
    private String price;
    private String rating;

    public String getName() {
        return title;
    }

    public String getUrl() {
        return id;
    }

    public String getRegion() { return region; }

    public String getPrice() { return price; }

    public String getRating() { return rating; }
}
