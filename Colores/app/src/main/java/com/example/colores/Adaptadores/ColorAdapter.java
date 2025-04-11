package com.example.colores.Adaptadores;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colores.Colores;
import com.example.colores.MainActivity;
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

        TextView nView = holder.nombreView.findViewById(R.id.nameView);
        nView.setText(color.name);
        View cView= holder.colorView.findViewById(R.id.colorView);

        try {
            String hex = "#" + color.hex;
            cView
        }catch (){

        }
    }

    @Override
    public int getItemCount() {
        return colores.size();
    }
    public class BasicViewHolder extends RecyclerView.ViewHolder{
        TextView colorView;
        TextView nombreView;
        public BasicViewHolder(@NonNull View itemView){
            super(itemView);
            colorView = itemView.findViewById(R.id.colorView);
            nombreView=itemView.findViewById(R.id.nameView);
        }
    }
}
