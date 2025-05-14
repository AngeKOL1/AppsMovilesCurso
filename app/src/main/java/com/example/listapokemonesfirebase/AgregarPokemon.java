package com.example.listapokemonesfirebase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.listapokemonesfirebase.Entidades.Habilidades;
import com.example.listapokemonesfirebase.Entidades.Pokemon;
import com.example.listapokemonesfirebase.Entidades.Ubicacion;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AgregarPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("pokemones");
        String id = dbRef.push().getKey(); // genera ID único
        Button btnAgregarPokemon= findViewById(R.id.botonAddNuevo);
        btnAgregarPokemon.setOnClickListener(v->{

            EditText nombrePokemon=findViewById(R.id.nombrePokemon);
            String nombre=nombrePokemon.getText().toString();

            EditText tipoPokemon = findViewById(R.id.tipoPokemon);
            String tipo = tipoPokemon.getText().toString();

            EditText tamanoPokemon = findViewById(R.id.tamanoPokemon);
            Double tamano= Double.parseDouble(tamanoPokemon.getText().toString());

            EditText pesoPokemon= findViewById(R.id.pesoPokemon);
            Double peso = Double.parseDouble( pesoPokemon.getText().toString());

            List<Habilidades> habilidades= new ArrayList<>();

            EditText linkImagenPokemon= findViewById(R.id.linkImagenPokemon);
            String linkImagen = linkImagenPokemon.getText().toString();

            List<Ubicacion> ubicaciones = new ArrayList<>();

            Pokemon nuevo = new Pokemon(id, nombre, tipo, tamano, peso, habilidades, linkImagen, ubicaciones);

            dbRef.child(id).setValue(nuevo)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(this, "¡Pokemon guardado!", Toast.LENGTH_SHORT).show();
                    });
        });

        PrevisualizarPokemon();
    }
    public void  PrevisualizarPokemon (){
        Button cargarImagen= findViewById(R.id.btn_visualizarImagen);

        cargarImagen.setOnClickListener(v->
        {
            EditText linkImagenPokemon= findViewById(R.id.linkImagenPokemon);
            String linkImagen = linkImagenPokemon.getText().toString();
            ImageView preimgPoke= findViewById(R.id.preImagen);
            Glide.with(this)
                    .load(linkImagen)
                    .into(preimgPoke);
        });
    }
}
