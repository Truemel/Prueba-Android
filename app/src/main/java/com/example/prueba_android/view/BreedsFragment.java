package com.example.prueba_android.view;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prueba_android.R;
import com.example.prueba_android.databinding.FragmentBreedsBinding;
import com.example.prueba_android.model.Breed;
import com.example.prueba_android.model.BreedsListAdapter;
import com.example.prueba_android.model.Cat;
import com.example.prueba_android.model.OnBreedClickListener;
import com.example.prueba_android.presenter.AmazingCatPresenter;
import com.example.prueba_android.presenter.OnCatRequestListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BreedsFragment extends Fragment implements View.OnClickListener, OnCatRequestListener, OnBreedClickListener {

    private FragmentBreedsBinding binder;
    private List<Breed> breeds;
    private ProgressDialog progress;
    private String breedSelectedName;

    public BreedsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    /**
     * Agrega valor a variable
     */
    private void init(){
        Type listType = new TypeToken<List<Breed>>(){}.getType();
        breeds = new Gson().fromJson(getArguments().getString("breeds"), listType);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_breeds, container, false);
        viewInit();
        return binder.getRoot();
    }

    /**
     * Prepara boton y recyclerview con su adaptador
     */
    private void viewInit(){
        binder.button.setOnClickListener(this);
        binder.recView.setLayoutManager(new LinearLayoutManager(getContext()));
        binder.recView.setAdapter(new BreedsListAdapter(getContext(), breeds, this));
    }

    @Override
    public void onClick(View v) {
        ((MainActivity)getActivity()).changeFragment(new FavouritesFragment());
    }

    @Override
    public void onCatGot(List<Cat> cat) {
        CatDetailsFragment fragment = new CatDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("cats", new Gson().toJson(cat));
        bundle.putString("cat_name", breedSelectedName);
        fragment.setArguments(bundle);
        ((MainActivity)getActivity()).changeFragment(fragment);
        progress.dismiss();
    }

    @Override
    public void onBreedsGot(List<Breed> breeds) {

    }

    @Override
    public void onBreedClick(Breed breed) {
        progress = ProgressDialog.show(getContext(), "Loading", "Now Loading", true);
        breedSelectedName = breed.name;
        AmazingCatPresenter catPresenter = new AmazingCatPresenter(this, getContext());
        catPresenter.catRequest(breed.id, 100);
    }
}
