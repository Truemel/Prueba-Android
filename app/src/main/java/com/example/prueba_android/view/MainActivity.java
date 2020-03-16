package com.example.prueba_android.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ProgressBar;

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

    private void getBreeds(){
        progress = ProgressDialog.show(this, "Loading", "Now Loading", true);
        AmazingCatPresenter catPresenter = new AmazingCatPresenter(this, this);
        catPresenter.breedsRequest();
    }

    private void init(List<Breed> breeds){
        BreedsFragment fragment = new BreedsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("breeds", new Gson().toJson(breeds));
        fragment.setArguments(bundle);
        changeFragment(fragment);
        progress.dismiss();
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameLay, fragment).commit();
    }

    @Override
    public void onCatGot(List<Cat> cat) {

    }

    @Override
    public void onBreedsGot(List<Breed> breeds) {
        init(breeds);
    }
}
