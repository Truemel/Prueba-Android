package com.example.prueba_android.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class RequestCaller {

    private IRetroRequest request;

    public RequestCaller(){
        request = RetrofitClient.getRetrofit().create(IRetroRequest.class);
    }

    public void sendCatRequest(String id, Callback<Cat> callBack){
        Call<Cat> call = request.onCatGot(id);
        call.enqueue(callBack);
    }

    public void sendBreedsRequest(Callback<List<Breed>> breedCallBack){
        Call<List<Breed>> call = request.onBreedsGot();
        call.enqueue(breedCallBack);
    }




}
