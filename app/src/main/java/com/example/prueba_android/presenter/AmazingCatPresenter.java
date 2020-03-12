package com.example.prueba_android.presenter;

import com.example.prueba_android.model.Cat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AmazingCatPresenter implements Callback<Cat> {

    @Override
    public void onResponse(Call<Cat> call, Response<Cat> response) {

    }

    @Override
    public void onFailure(Call<Cat> call, Throwable t) {

    }
}
