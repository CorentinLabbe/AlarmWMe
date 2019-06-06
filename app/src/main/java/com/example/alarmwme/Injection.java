package com.example.alarmwme;

import com.example.alarmwme.controller.Controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Cette classe permet de me retourner des instances d'objets
public class Injection {
    private static RestApiFood restApiFood;

    //Singleton
    public static RestApiFood getRestApi(){
        if(restApiFood == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://evening-citadel-85778.herokuapp.com:443/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restApiFood = retrofit.create(RestApiFood.class);
        }
        return restApiFood;
    }
}