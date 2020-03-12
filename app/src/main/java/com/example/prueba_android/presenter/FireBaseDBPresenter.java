package com.example.prueba_android.presenter;

import com.google.firebase.firestore.FirebaseFirestore;

public class FireBaseDBPresenter {

    private FirebaseFirestore db;

    public FireBaseDBPresenter(){
        db = FirebaseFirestore.getInstance();
    }
}
