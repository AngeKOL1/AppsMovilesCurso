package com.example.practica.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica.MainActivity;
import com.example.practica.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorColores extends RecyclerView.Adapter<AdaptadorColores.BasicViewHolder> {
        List<MainActivity.colores> Colores= new ArrayList<>();
        public AdaptadorColores(List<MainActivity.colores> Colores) {
        }
        @NonNull
        @Override
        public AdaptadorColores.BasicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_main, parent, false);
            return new BasicViewHolder(view );
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorColores.BasicViewHolder holder, int position) {
            TextView textView= holder.itemView.findViewById(R.id.MostradorColores);
            String tex= Colores.get(position).toString();
            textView.setText(tex);
        }

        @Override
        public int getItemCount() {
            return Colores.size();
        }

        public class BasicViewHolder extends RecyclerView.ViewHolder
        {
            public BasicViewHolder(@NonNull View itemView){
                super(itemView);
            }
        }
}

