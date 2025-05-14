package com.example.listapokemonesfirebase.Adaptadores;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listapokemonesfirebase.EditarPokemon;
import com.example.listapokemonesfirebase.Entidades.Pokemon;
import com.example.listapokemonesfirebase.R;

import java.util.List;

public class PokemonAdaptador extends RecyclerView.Adapter<PokemonAdaptador.PokemonViewHolder> {
    private List<Pokemon> data;
    private Activity activity;

    public PokemonAdaptador(List<Pokemon> data, Activity activity){
        this.data= data;
        this.activity=activity;
    }

    @NonNull
    @Override
    public PokemonAdaptador.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itempokemon, parent, false);

        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdaptador.PokemonViewHolder holder, int position) {
        Pokemon pokemon = data.get(position);
        TextView tvNombrePoke= holder.itemView.findViewById(R.id.tvNombrePoke);
        TextView tvTipoPoke = holder.itemView.findViewById(R.id.tvTipoPoke);
        ImageView imgPoke= holder.itemView.findViewById(R.id.imagenPokemon);

        tvNombrePoke.setText(pokemon.nombre);
        tvTipoPoke.setText(pokemon.tipo);
        Glide.with(holder.itemView.getContext())
                .load(pokemon.linkImagen)
                .into(imgPoke);



        LinearLayout pokemonLinear= holder.itemView.findViewById(R.id.pokemonLinearLayout);
        pokemonLinear.setOnClickListener(v->{
            Intent intent = new Intent(activity, EditarPokemon.class);
            intent.putExtra("pokemon_id",pokemon.idPokemon);
            intent.putExtra("pokemon_link",pokemon.linkImagen);
            intent.putExtra("pokemon_nombre", pokemon.nombre);
            intent.putExtra("pokemon_tipo",pokemon.tipo);

            intent.putExtra("pokemon_tamano", pokemon.tamano != null ? pokemon.tamano.doubleValue() : 0.0);
            intent.putExtra("pokemon_peso", pokemon.peso != null ? pokemon.peso.doubleValue() : 0.0);


            activity.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class PokemonViewHolder extends RecyclerView.ViewHolder{
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

