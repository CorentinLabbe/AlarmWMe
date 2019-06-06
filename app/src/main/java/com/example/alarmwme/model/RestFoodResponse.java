package com.example.alarmwme.model;

import java.util.List;

public class RestFoodResponse {
    private int count;
    private String next;
    private List<Food> results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public List<Food> getResults() {
        return results;
    }
}

