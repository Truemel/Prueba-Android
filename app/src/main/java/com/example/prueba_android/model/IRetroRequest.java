package com.example.prueba_android.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IRetroRequest {
    @Headers("x-api-key: 836b953e-953b-407c-a015-242b0fe495d2")
    @GET("images/search?")
    public Call<List<Cat>> onCatGot(@Query("id") String breedId, @Query("limit") int limit);

    @Headers("x-api-key: 836b953e-953b-407c-a015-242b0fe495d2")
    @GET("breeds")
    public Call<List<Breed>> onBreedsGot();
}
