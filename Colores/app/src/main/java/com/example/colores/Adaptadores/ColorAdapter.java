package com.example.colores.Adaptadores;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colores.Entities.Colores;
import com.example.colores.R;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.BasicViewHolder> {

    List<Colores> colores;

    public ColorAdapter(List<Colores> colores) {
        this.colores = colores;
    }

    @NonNull
    @Override
    public BasicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcolor, parent, false);
        return new BasicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BasicViewHolder holder, int position) {
        Colores color = colores.get(position);
        holder.nameView.setText(color.nombre);

        try {
            String hex = color.colorHex;
            holder.codeView.setText(hex);
            holder.colorBg.setBackgroundColor(Color.parseColor(hex));
        } catch (Exception ex) {
            Log.d("Main App", "Color inválido: " + ex.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return colores.size();
    }

    public static class BasicViewHolder extends RecyclerView.ViewHolder {
        TextView nameView, codeView;
        View colorBg;

        public BasicViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.nameColor);
            codeView = itemView.findViewById(R.id.colorCod);
            colorBg = itemView.findViewById(R.id.cColorBg);
        }
    }
}
