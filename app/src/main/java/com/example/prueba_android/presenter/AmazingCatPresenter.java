package com.example.prueba_android.presenter;


import android.content.Context;
import android.widget.Toast;

import com.example.prueba_android.model.Breed;
import com.example.prueba_android.model.Cat;
import com.example.prueba_android.model.RequestCaller;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AmazingCatPresenter {

    private RequestCaller request;
    private OnCatRequestListener listener;
    private Context context;

    public AmazingCatPresenter(OnCatRequestListener listener, Context context){
        request = new RequestCaller();
        this.context = context;
        this.listener = listener;
    }

    public void breedsRequest(){
        request.sendBreedsRequest(new Callback<List<Breed>>() {
            @Override
            public void onResponse(Call<List<Breed>> call, Response<List<Breed>> response) {
                if(response.isSuccessful())
                    listener.onBreedsGot(response.body());
            }

            @Override
            public void onFailure(Call<List<Breed>> call, Throwable t) {
                Toast.makeText(context, "Error, no se pudo recibir la lista de Breeds", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void catRequest(String id){
        request.sendCatRequest(id, new Callback<Cat>() {
            @Override
            public void onResponse(Call<Cat> call, Response<Cat> response) {
                if(response.isSuccessful())
                    listener.onCatGot(response.body());
            }

            @Override
            public void onFailure(Call<Cat> call, Throwable t) {
                Toast.makeText(context, "Error, no se pudo recibir la imagen de Cat", Toast.LENGTH_LONG).show();
            }
        });
    }

}
