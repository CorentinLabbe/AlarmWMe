package com.example.alarmwme.controller;



import com.example.alarmwme.RestApiFood;
import com.example.alarmwme.model.Food;
import com.example.alarmwme.model.RestFoodResponse;
import com.example.alarmwme.view.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class Controller {

        public MainActivity view;
        private RestApiFood restApiFood;

        public Controller(MainActivity view, RestApiFood restApiFood) {
            this.view = view;
            this.restApiFood = restApiFood;
        }

        public void onCreate() {
            Call<RestFoodResponse> call = restApiFood.getFoodData();
            call.enqueue(new Callback<RestFoodResponse>() {
                @Override
                public void onResponse(Call<RestFoodResponse> call, Response<RestFoodResponse> response) {
                    RestFoodResponse restFoodResponse = response.body();
                    List<Food> foodList = restFoodResponse.getResults();
                    view.showList(foodList);
                }

                @Override
                public void onFailure(Call<RestFoodResponse> call, Throwable t) {

                }
            });
        }

}

