package com.example.listapokemonesfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class EditarPokemon extends AppCompatActivity {
    String idPokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_editar_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        PasarDatosPokemon();

        IrIngresarUbicacionPokemon();
        IrUbicacionPokemon();
    }
    public void IrUbicacionPokemon(){
        Button btn = findViewById(R.id.irUbicaciones);
        btn.setOnClickListener(v->{
            Intent intent = new Intent(EditarPokemon.this, UbicacionPokemon.class);
            intent.putExtra("pokemon_id", idPokemon);
            startActivity(intent);
        });
    }
    public void PasarDatosPokemon(){
         idPokemon= getIntent().getStringExtra("pokemon_id");

        ImageView imagenPokemo = findViewById(R.id.imagenPokemon);
        String linkImagen = getIntent().getStringExtra("pokemon_link");
        Glide.with(this)
                .load(linkImagen)
                .into(imagenPokemo);
        EditText linkImagenPokemon= findViewById(R.id.linkImagenPokemon);
        linkImagenPokemon.setText(getIntent().getStringExtra("pokemon_link"));

        EditText nombre = findViewById(R.id.nombrePokemon);
        nombre.setText(getIntent().getStringExtra("pokemon_nombre"));

        EditText tipo = findViewById(R.id.tipoPokemon);
        tipo.setText(getIntent().getStringExtra("pokemon_tipo"));

        double tamano = getIntent().getDoubleExtra("pokemon_tamano", 0.0);
        double peso = getIntent().getDoubleExtra("pokemon_peso", 0.0);

        EditText etTamano = findViewById(R.id.tamanoPokemon);
        EditText etPeso = findViewById(R.id.pesoPokemon);

        etTamano.setText(String.valueOf(tamano));
        etPeso.setText(String.valueOf(peso));

    }
    public void IrIngresarUbicacionPokemon() {
        Button btnIrAUbicacion = findViewById(R.id.irAnadirUbicaciones);
        btnIrAUbicacion.setOnClickListener(v -> {
            Intent intent = new Intent(EditarPokemon.this, AgregarUbicacionesPokemon.class);
            intent.putExtra("pokemon_id", idPokemon);
            startActivity(intent);
        });
    }


}
