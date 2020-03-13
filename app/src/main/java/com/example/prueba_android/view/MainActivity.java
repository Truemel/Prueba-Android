package com.example.prueba_android.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.prueba_android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init(){
        BreedsFragment fragment = new BreedsFragment();
        changeFragment(fragment);
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameLay, fragment).commit();
    }
}
