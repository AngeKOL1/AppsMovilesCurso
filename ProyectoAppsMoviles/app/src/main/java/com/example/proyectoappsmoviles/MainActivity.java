package com.example.proyectoappsmoviles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectoappsmoviles.Entidades.IniciarSesion2;
import com.example.proyectoappsmoviles.Entidades.Usuario;
import com.example.proyectoappsmoviles.Entidades.Video;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.iniciarsesion);


        Button btnIrAIniciarSesion2 = findViewById(R.id.inicioGoogle);
        btnIrAIniciarSesion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IniciarSesion2.class);
                startActivity(intent);
            }
        });

    }
}