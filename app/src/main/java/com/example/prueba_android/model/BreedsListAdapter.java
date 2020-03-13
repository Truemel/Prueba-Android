package com.example.prueba_android.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba_android.R;

import java.util.List;

public class BreedsListAdapter extends RecyclerView.Adapter<BreedsListAdapter.BreedHolder> implements View.OnClickListener {

    private OnBreedClickListener listener;
    private List<Breed> lista;
    private Context context;

    public BreedsListAdapter(Context context, List<Breed> lista, OnBreedClickListener listener){
        this.context = context;
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BreedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_breeds, parent, false);
        BreedHolder holder = new BreedHolder(view);
        holder.text = view.findViewById(R.id.races);
        holder.itemView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BreedHolder holder, int position) {
        holder.text.setText(lista.get(position).name);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onClick(View v) {
        if(lista.get((int)v.getTag()).altNames != null && lista.get((int)v.getTag()).altNames.length() >0)
            Toast.makeText(context, "Alternative name: "+lista.get((int)v.getTag()).altNames, Toast.LENGTH_LONG).show();
        listener.onBreedClick(lista.get((int)v.getTag()));
    }

    public class BreedHolder extends RecyclerView.ViewHolder{

        public TextView text;

        public BreedHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
