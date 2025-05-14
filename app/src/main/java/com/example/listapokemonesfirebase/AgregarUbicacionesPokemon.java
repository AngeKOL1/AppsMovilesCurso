package com.example.listapokemonesfirebase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listapokemonesfirebase.Entidades.Pokemon;
import com.example.listapokemonesfirebase.Entidades.Ubicacion;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AgregarUbicacionesPokemon extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_ubicaciones_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        agregarUbicacion();
    }

    public void agregarUbicacion() {
        EditText latitudInput = findViewById(R.id.latitud);
        EditText longitudInput = findViewById(R.id.longitud);
        Button agregarBtn = findViewById(R.id.agregarDatosUbicacion);

        agregarBtn.setOnClickListener(v -> {
            String latStr = latitudInput.getText().toString();
            String lonStr = longitudInput.getText().toString();

            if (latStr.isEmpty() || lonStr.isEmpty()) {
                Toast.makeText(this, "Por favor completa latitud y longitud", Toast.LENGTH_SHORT).show();
                return;
            }

            double latitud = Double.parseDouble(latStr);
            double longitud = Double.parseDouble(lonStr);

            String idPokemon = getIntent().getStringExtra("pokemon_id");

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("pokemones").child(idPokemon);

            ref.get().addOnSuccessListener(snapshot -> {
                Pokemon pokemon = snapshot.getValue(Pokemon.class);
                if (pokemon != null) {
                    if (pokemon.ubicaciones == null) {
                        pokemon.ubicaciones = new ArrayList<>();
                    }

                    pokemon.ubicaciones.add(new Ubicacion(latitud, longitud));

                    ref.setValue(pokemon).addOnSuccessListener(unused -> {
                        Toast.makeText(this, "Ubicación agregada correctamente", Toast.LENGTH_SHORT).show();
                    });
                }
            });
        });
    }
}
