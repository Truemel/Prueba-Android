package com.example.prueba_android.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IRetroRequest {
    @Headers("x-api-key: 836b953e-953b-407c-a015-242b0fe495d2")
    @GET("search")
    public Call<Cat> onCatGot();
}
