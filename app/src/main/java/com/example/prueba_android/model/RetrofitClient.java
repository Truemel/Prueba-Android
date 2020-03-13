package com.example.prueba_android.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String PATH = "https://api.thecatapi.com/v1/";

    private static Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder().baseUrl(PATH).addConverterFactory(GsonConverterFactory.create()).build();
    }


    public static Retrofit getRetrofit(){
        synchronized (RetrofitClient.class){
            if(retrofit == null)
                new RetrofitClient();
        }
        return retrofit;
    }
}
