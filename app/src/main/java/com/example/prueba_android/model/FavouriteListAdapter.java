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

public class FavouriteListAdapter extends RecyclerView.Adapter<FavouriteListAdapter.FavouriteHolder> implements View.OnClickListener {

    private List<Favorite> lista;
    private Context context;

    public FavouriteListAdapter(Context context, List<Favorite> lista){
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public FavouriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_favorites, parent, false);
        FavouriteHolder holder = new FavouriteHolder(view);
        holder.image = view.findViewById(R.id.favorites);
        holder.image.setOnClickListener(this);
        return holder;
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteHolder holder, int position) {
        Picasso.get().load(lista.get(position).url).into(holder.image);
        holder.image.setTag(position);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, lista.get((int)v.getTag()).raza, Toast.LENGTH_LONG).show();
    }

    public class FavouriteHolder extends RecyclerView.ViewHolder{

        public ImageView image;

        public FavouriteHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
