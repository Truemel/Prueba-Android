package com.example.prueba_android.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba_android.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CatListAdapter extends RecyclerView.Adapter<CatListAdapter.CatHolder> implements View.OnLongClickListener {

    private List<Cat> lista;
    private Context context;
    private OnCatClickListener listener;

    public CatListAdapter(Context context, List<Cat> lista, OnCatClickListener listener){
        this.context = context;
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_favorites, parent, false);
        CatHolder holder = new CatHolder(view);
        holder.image = view.findViewById(R.id.favorites);
        holder.itemView.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder holder, int position) {
        Picasso.get().load(lista.get(position).url).into(holder.image);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public boolean onLongClick(View v) {
        if(lista.get((int)v.getTag()).url != null && lista.get((int)v.getTag()).url.length() > 0)
            Toast.makeText(context, "Agregando imagen a favoritos", Toast.LENGTH_LONG).show();
        listener.onCatClick(lista.get((int)v.getTag()));
        return true;
    }

    public class CatHolder extends RecyclerView.ViewHolder{

        public ImageView image;

        public CatHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
