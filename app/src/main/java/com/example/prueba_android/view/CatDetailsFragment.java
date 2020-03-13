package com.example.prueba_android.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prueba_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatDetailsFragment extends Fragment {

    public CatDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat_details, container, false);
    }
}
