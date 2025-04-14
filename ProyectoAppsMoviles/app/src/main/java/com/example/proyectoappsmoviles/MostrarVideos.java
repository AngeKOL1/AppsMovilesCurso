package com.example.proyectoappsmoviles;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoappsmoviles.Adaptadores.AdaptadorVideoUsuario;
import com.example.proyectoappsmoviles.Entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MostrarVideos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_videos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        List<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario(1, "Angelo","Angelo@gmail.com","ytusae","Hola","Peru",true);
        Usuario usuario2 = new Usuario(2, "Roeldiño","Roe@gmail.com","yewe","Hola","Peru",true);
        Usuario usuario3 = new Usuario(3, "Andy","Andy@gmail.com","yr3re","Hola","Peru",true);
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);

        AdaptadorVideoUsuario usuarioAdapter= new AdaptadorVideoUsuario(listaUsuarios);
        RecyclerView recyclerView = findViewById(R.id.recyclerP);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(usuarioAdapter);

    }
}