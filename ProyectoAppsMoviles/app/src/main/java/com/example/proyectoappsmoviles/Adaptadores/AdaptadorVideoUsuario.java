package com.example.proyectoappsmoviles.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoappsmoviles.Entidades.Usuario;
import com.example.proyectoappsmoviles.R;

import java.util.List;

public class AdaptadorVideoUsuario extends RecyclerView.Adapter<AdaptadorVideoUsuario.BasicViewHolder> {
    List<Usuario> usuarios;
    public AdaptadorVideoUsuario(List<Usuario> usuarios){
        this.usuarios=usuarios;
    }
    @NonNull
    @Override
    public AdaptadorVideoUsuario.BasicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_mostrar_videos, parent, false);
        return new BasicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorVideoUsuario.BasicViewHolder holder, int position) {
        Usuario user= usuarios.get(position);
        TextView nombreP= holder.itemView.findViewById(R.id.nombreUsuarioP);
        nombreP.setText(user.getNombreUsuario());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class BasicViewHolder extends RecyclerView.ViewHolder{

        public BasicViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
