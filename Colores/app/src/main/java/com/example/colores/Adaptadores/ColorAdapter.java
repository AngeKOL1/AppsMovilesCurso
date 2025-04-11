package com.example.colores.Adaptadores;

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

    List<Colores> colores= new ArrayList<>();

    public ColorAdapter(ArrayList<Colores> colores){
        this.colores=colores;
    }

    @NonNull
    @Override
    public ColorAdapter.BasicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);
        return new BasicViewHolder(view );
    }

    @Override
    public void onBindViewHolder(@NonNull ColorAdapter.BasicViewHolder holder, int position) {
        Colores color= colores.get(position);

        TextView nView = holder.itemView.findViewById(R.id.nameColor);
        TextView cView= holder.itemView.findViewById(R.id.colorCod);
        View colorView= holder.itemView.findViewById(R.id.cColorBg);

        nView.setText(color.nombre);
        try {
            String hex = "#" + color.colorHex;
            cView.setText(hex);
            colorView.setBackgroundColor(android.graphics.Color.parseColor(hex));
        }catch (Exception ex){
            Log.d("Main App","Usando color por defecto");
        }
    }

    @Override
    public int getItemCount() {
        return colores.size();
    }
    public class BasicViewHolder extends RecyclerView.ViewHolder{

        public BasicViewHolder(@NonNull View itemView){
            super(itemView);

        }
    }
}
