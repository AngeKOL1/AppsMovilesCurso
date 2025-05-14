package com.example.listapokemonesfirebase.Adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listapokemonesfirebase.Entidades.Habilidades;
import com.example.listapokemonesfirebase.R;

import java.util.List;

public class HabilidadesAdaptador extends RecyclerView.Adapter<HabilidadesAdaptador.HabilidadesViewHolder> {
    private List<Habilidades> data;
    private Activity activity;

    public HabilidadesAdaptador(List<Habilidades> data, Activity activity){
        this.data=data;
        this.activity=activity;
    }
    @NonNull
    @Override
    public HabilidadesAdaptador.HabilidadesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemhabilidad, parent, false);
        return new HabilidadesAdaptador.HabilidadesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabilidadesAdaptador.HabilidadesViewHolder holder, int position) {
        Habilidades habilidades = data.get(position);
        TextView tvNombre= holder.itemView.findViewById(R.id.tvNombreHabilidad);
        TextView tvDano=holder.itemView.findViewById(R.id.tvDanoHabilidad);
        ImageView imagenHabilidad = holder.itemView.findViewById(R.id.imagenHabilidad);
        tvNombre.setText(habilidades.nombre);
        tvDano.setText(String.valueOf(habilidades.dano));
        Glide.with(holder.itemView.getContext())
                .load(habilidades.linkImagen)
                .into(imagenHabilidad);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class HabilidadesViewHolder extends RecyclerView.ViewHolder{

        public HabilidadesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
