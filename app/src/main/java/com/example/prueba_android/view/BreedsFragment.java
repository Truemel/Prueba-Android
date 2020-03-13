package com.example.prueba_android.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BreedsFragment extends Fragment implements View.OnClickListener, OnCatRequestListener, OnBreedClickListener {

    private FragmentBreedsBinding binder;
    private List<Breed> breeds;

    public BreedsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AmazingCatPresenter catPresenter = new AmazingCatPresenter(this, getContext());
        catPresenter.breedsRequest();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_breeds, container, false);
        return binder.getRoot();
    }

    private void viewInit(){
        binder.button.setOnClickListener(this);
        binder.recView.setAdapter(new BreedsListAdapter(getContext(), breeds, this));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCatGot(List<Cat> cat) {

    }

    @Override
    public void onBreedsGot(List<Breed> breeds) {
        if(breeds != null)
            this.breeds = breeds;
    }

    @Override
    public void onBreedClick(Breed breed) {

    }
}
