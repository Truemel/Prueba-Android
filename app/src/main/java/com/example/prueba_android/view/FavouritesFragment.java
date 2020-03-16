package com.example.prueba_android.view;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prueba_android.R;
import com.example.prueba_android.model.Favorite;
import com.example.prueba_android.model.FavouriteListAdapter;
import com.example.prueba_android.presenter.FireBaseDBPresenter;
import com.example.prueba_android.presenter.OnFavourCatListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouritesFragment extends Fragment implements OnFavourCatListener {

    private RecyclerView recyclerView;
    private FireBaseDBPresenter fireDB;
    private ProgressDialog progress;

    public FavouritesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progress = ProgressDialog.show(getContext(), "Loading", "Now Loading", true);
    }

    /**
     * Inicializa firebase y pide a presentador de firebase que adquiera la lista de gatitos favoritos
     */
    private void init(){
        fireDB = new FireBaseDBPresenter(getContext(), this);
        fireDB.getFavouriteCatsList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cat_details, container, false);
        recyclerView = view.findViewById(R.id.recDetailsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        init();
        return view;
    }

    @Override
    public void onFavourCatGet(List<Favorite> favorite) {
        recyclerView.setAdapter(new FavouriteListAdapter(getContext(), favorite));
        progress.dismiss();
    }
}
