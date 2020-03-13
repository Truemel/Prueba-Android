package com.example.prueba_android.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prueba_android.R;
import com.example.prueba_android.model.Breed;
import com.example.prueba_android.model.Cat;
import com.example.prueba_android.model.CatListAdapter;
import com.example.prueba_android.model.OnCatClickListener;
import com.example.prueba_android.presenter.AmazingCatPresenter;
import com.example.prueba_android.presenter.FireBaseDBPresenter;
import com.example.prueba_android.presenter.OnCatRequestListener;
import com.example.prueba_android.presenter.OnFavourCatListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatDetailsFragment extends Fragment implements OnCatRequestListener, OnCatClickListener {

    private List<Cat> catList;
    private RecyclerView recyclerView;
    private FireBaseDBPresenter fireDB;

    public CatDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        AmazingCatPresenter catPresenter = new AmazingCatPresenter(this, getContext());
        catPresenter.catRequest(getArguments().getString("id"), 100);
        fireDB = new FireBaseDBPresenter(getContext(), null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cat_details, container, false);
        recyclerView = view.findViewById(R.id.recDetailsView);

        return view;
    }

    @Override
    public void onCatGot(List<Cat> cat) {
        recyclerView.setAdapter(new CatListAdapter(getContext(), cat, this));
    }

    @Override
    public void onBreedsGot(List<Breed> breeds) {

    }

    @Override
    public void onCatClick(Cat cat) {
        fireDB.uploadFavourite(cat);
    }
}
