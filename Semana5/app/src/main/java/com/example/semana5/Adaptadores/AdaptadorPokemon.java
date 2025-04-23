package com.example.semana5.Adaptadores;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana5.DetallePokemonActivity;
import com.example.semana5.Entidades.Pokemon;
import com.example.semana5.R;

import java.util.List;

public class AdaptadorPokemon extends RecyclerView.Adapter<AdaptadorPokemon.BasicViewHolder> {
    List<Pokemon> pokemons;
    public AdaptadorPokemon(List<Pokemon> pokemons){
        this.pokemons=pokemons;
    }
    @NonNull
    @Override
    public AdaptadorPokemon.BasicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listapokemon, parent, false);
        return new BasicViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPokemon.BasicViewHolder holder, int position) {
        Pokemon pokemon=pokemons.get(position);
        TextView nombrePokemon= holder.itemView.findViewById(R.id.nombrePokemon);
        nombrePokemon.setText(pokemon.name);

        LinearLayout linaerPokemon =holder.itemView.findViewById(R.id.linearPokemon);
        linaerPokemon.setOnClickListener(v->{
            Intent intent = new Intent(v.getContext(), DetallePokemonActivity.class);
            intent.putExtra("urlDetalle", pokemon.url);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public class BasicViewHolder extends RecyclerView.ViewHolder {
        public BasicViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
