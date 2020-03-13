package com.example.prueba_android.presenter;

import com.example.prueba_android.model.Breed;
import com.example.prueba_android.model.Cat;

import java.util.List;

public interface OnCatRequestListener {
    public void onCatGot(Cat cat);
    public void onBreedsGot(List<Breed> breeds);
}
