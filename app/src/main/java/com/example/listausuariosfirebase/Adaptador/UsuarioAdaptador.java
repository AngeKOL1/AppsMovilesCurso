package com.example.listausuariosfirebase.Adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listausuariosfirebase.Entidades.Usuario;
import com.example.listausuariosfirebase.ListaUsuarios;
import com.example.listausuariosfirebase.R;

import java.util.ArrayList;
import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.UsuarioViewHolder> {
    private List<Usuario> data ;
    private Activity activity;
    public UsuarioAdaptador(List<Usuario> data, Activity activity){
        this.data=data;
        this.activity=activity;
    }
    @NonNull
    @Override
    public UsuarioAdaptador.UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_usuario, parent, false);

        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdaptador.UsuarioViewHolder holder, int position) {
        Usuario usuario= data.get(position);
        TextView nombre = holder.itemView.findViewById(R.id.tvNombreUsuario);
        TextView telefono= holder.itemView.findViewById(R.id.tvTelefonoUsuario);
        nombre.setText(usuario.nombre);
        telefono.setText(usuario.telefono);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder{

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
