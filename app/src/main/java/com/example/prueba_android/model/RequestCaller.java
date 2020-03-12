package com.example.prueba_android.model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class RequestCaller {

    private Callback<Cat> callBack;
    private IRetroRequest request;

    public RequestCaller(Callback<Cat> callBack){
        this.callBack = callBack;
        request = RetrofitClient.getRetrofit().create(IRetroRequest.class);
    }

    public void sendRequest(){
        Call<Cat> call = request.onCatGot();
        call.enqueue(callBack);
    }


}
