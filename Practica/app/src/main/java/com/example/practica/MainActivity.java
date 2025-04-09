package com.example.practica;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica.Adaptadores.AdaptadorColores;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        List<colores> dataColors= new ArrayList<>();

        AdaptadorColores basicAdaptor = new AdaptadorColores(dataColors);
        RecyclerView rvBasic = findViewById(R.id.MostradorColores);
        rvBasic.setLayoutManager(new LinearLayoutManager(this));
        rvBasic.setAdapter(basicAdaptor);

       colores color1 = new colores("#121212", "Rojo");
       dataColors.add(color1);
       colores color2 = new colores("#153212", "Verde");
       dataColors.add(color2);
       colores color3 = new colores("#121212", "Azul");
       dataColors.add(color3);
       colores color4 = new colores("#121212", "Verde");
        dataColors.add(color4);
        colores color5 = new colores("#121212", "Amarillo");
        dataColors.add(color5);
        colores color6 = new colores("#121212", "Negro");
        dataColors.add(color6);
        colores color7 = new colores("#121212", "Violeta");
        dataColors.add(color7);
        colores color8 = new colores("#121212", "Marrón");
        dataColors.add(color8);
        colores color9 = new colores("#121212", "Morado");
        dataColors.add(color9);




        AdaptadorColores adaptadorcolores= new AdaptadorColores(dataColors);
        RecyclerView recyclerView= findViewById(R.id.MostradorColores);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptadorcolores);

    }
    public class colores{
        String nombre;
        String cod;

        public colores(String cod, String nombre) {
            this.cod = cod;
            this.cod= cod;
        }
    }
}