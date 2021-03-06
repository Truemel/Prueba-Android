package com.example.prueba_android.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.prueba_android.R;
import com.example.prueba_android.model.Breed;
import com.example.prueba_android.model.Cat;
import com.example.prueba_android.presenter.AmazingCatPresenter;
import com.example.prueba_android.presenter.OnCatRequestListener;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnCatRequestListener {

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getBreeds();
    }

    /**
     * Mostrar progress dialog mientras le pide al presentador que pida la lista de razas de gatitos
     */
    private void getBreeds(){
        progress = ProgressDialog.show(this, "Loading", "Now Loading", true);
        AmazingCatPresenter catPresenter = new AmazingCatPresenter(this, this);
        catPresenter.breedsRequest();
    }

    /**
     * Inicia el fragmento de razas de gatitos
     * @param breeds
     */
    private void init(List<Breed> breeds){
        BreedsFragment fragment = new BreedsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("breeds", new Gson().toJson(breeds));
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLay, fragment).commit();
        progress.dismiss();
    }

    /**
     * Reemplazador de fragmentos
     * @param fragment
     */
    public void changeFragment(Fragment fragment){
        if(!isChangingConfigurations())
            getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameLay, fragment).commit();
    }

    @Override
    public void onCatGot(List<Cat> cat) {

    }

    @Override
    public void onBreedsGot(List<Breed> breeds) {
        if(!isChangingConfigurations())
            init(breeds);
    }
}
