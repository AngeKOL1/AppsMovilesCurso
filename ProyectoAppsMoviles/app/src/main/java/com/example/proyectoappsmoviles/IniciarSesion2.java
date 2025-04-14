package com.example.proyectoappsmoviles.Entidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectoappsmoviles.MainActivity;
import com.example.proyectoappsmoviles.MostrarVideos;
import com.example.proyectoappsmoviles.R;

public class IniciarSesion2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_iniciar_sesion2);

        Button btnIrAMostrarVideos = findViewById(R.id.botonIniciar);
        btnIrAMostrarVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IniciarSesion2.this, MostrarVideos.class);
                startActivity(intent);
            }
        });
    }
}