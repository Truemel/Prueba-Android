package com.example.prueba_android.presenter;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.prueba_android.model.Cat;
import com.example.prueba_android.model.Favorite;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/**
 * Presentador para administrar firebase
 */
public class FireBaseDBPresenter implements OnSuccessListener<DocumentReference>, OnFailureListener, OnCompleteListener<QuerySnapshot> {

    private FirebaseFirestore db;
    private static final String FAVOURITES = "favourites";
    private Context context;
    private OnFavourCatListener onCatListener;

    public FireBaseDBPresenter(Context context, OnFavourCatListener onCatListener){
        this.context = context;
        this.onCatListener = onCatListener;
        db = FirebaseFirestore.getInstance();
    }

    /**
     * Subir gatito a favoritos en firebase
     * @param cat
     * @param breedName
     */
    public void uploadFavourite(Cat cat, String breedName){
        Favorite fav = new Favorite();
        if(cat.breeds != null && cat.breeds.length > 0)
            fav.raza = cat.breeds[0].name;
        else
            fav.raza = breedName;
        fav.url = cat.url;
        fav.timeStamp = System.currentTimeMillis()+"";
        CollectionReference collectionReference = db.collection(FAVOURITES);
        collectionReference.add(fav).addOnSuccessListener(this).addOnFailureListener(this);
    }

    /**
     * Obtener lista de gatitos favoritos
     */
    public void getFavouriteCatsList(){
        db.collection(FAVOURITES).get().addOnCompleteListener(this);
    }

    @Override
    public void onSuccess(DocumentReference documentReference) {
        Toast.makeText(context, "Imagen agregada se ha favoritos exitosamente", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(context, "Error, no se pudo guardar la imagen en favoritos", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if(task.isSuccessful()){
            ArrayList<Favorite> fav = new ArrayList<Favorite>();
            for(QueryDocumentSnapshot snapshot : Objects.requireNonNull(task.getResult())){
                Map<String, Object> map = snapshot.getData();
                Favorite favorite = new Favorite();
                favorite.url = map.get("url").toString();
                favorite.timeStamp = map.get("timeStamp").toString();
                if(map.get("raza") != null)
                    favorite.raza = map.get("raza").toString();
                fav.add(favorite);
            }
            onCatListener.onFavourCatGet(fav);
        }
    }
}
