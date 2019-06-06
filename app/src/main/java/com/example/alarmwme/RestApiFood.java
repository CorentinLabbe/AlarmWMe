package com.example.alarmwme;





        import com.example.alarmwme.model.RestFoodResponse;

        import retrofit2.Call;
        import retrofit2.http.GET;

        public interface RestApiFood {

    @GET("whiskey/")
    Call<RestFoodResponse> getFoodData();

}

