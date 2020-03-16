package com.example.prueba_android.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prueba_android.R;
import com.example.prueba_android.model.Cat;
import com.example.prueba_android.model.CatListAdapter;
import com.example.prueba_android.model.OnCatClickListener;
import com.example.prueba_android.presenter.FireBaseDBPresenter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatDetailsFragment extends Fragment implements OnCatClickListener {

    private List<Cat> catList;
    private RecyclerView recyclerView;
    private FireBaseDBPresenter fireDB;
    private String breedName;

    public CatDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    /**
     * Inicializa firebase y agrega valores a variables
     */
    private void init(){
        fireDB = new FireBaseDBPresenter(getContext(), null);
        TypeToken<List<Cat>> typeToken = new TypeToken<List<Cat>>(){};
        catList = new Gson().fromJson(getArguments().getString("cats"), typeToken.getType());
        breedName = getArguments().getString("cat_name");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cat_details, container, false);
        recyclerView = view.findViewById(R.id.recDetailsView);
        initView();
        return view;
    }

    /**
     * Prepara recyclerview y le agrega el adaptador
     */
    private void initView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CatListAdapter(getContext(), catList, this));
    }

    @Override
    public void onCatClick(Cat cat) {
        fireDB.uploadFavourite(cat, breedName);
    }
}
