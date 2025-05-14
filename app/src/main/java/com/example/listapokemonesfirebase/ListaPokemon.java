package com.example.listapokemonesfirebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listapokemonesfirebase.Adaptadores.PokemonAdaptador;
import com.example.listapokemonesfirebase.Entidades.Habilidades;
import com.example.listapokemonesfirebase.Entidades.Pokemon;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListaPokemon extends AppCompatActivity {
    RecyclerView rvPokemones;
    PokemonAdaptador adaptador;
    List<Pokemon> data =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvPokemones = findViewById(R.id.rvPokemon);
        rvPokemones.setLayoutManager(new LinearLayoutManager(this));
        setUpRecyclerView();
        CambiarPokeHabi();
        CargarPokemones();
        IrActividadAgregarPokemon();


    }

    public void setUpRecyclerView(){
        adaptador = new PokemonAdaptador(data, ListaPokemon.this);
        rvPokemones.setAdapter(adaptador);
    }
    public void IrActividadAgregarPokemon()
    {
        Button btnNuevo= findViewById(R.id.botonAgregar);
        btnNuevo.setOnClickListener(v->{
            Intent intent = new Intent(ListaPokemon.this, AgregarPokemon.class);
            startActivity(intent);
        });
    }
    public void CargarPokemones(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("pokemones");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot Snapshot : snapshot.getChildren()) {
                    Pokemon pokemon = Snapshot.getValue(Pokemon.class);
                    if (pokemon!= null) {
                        data.add(pokemon);
                    }
                }
                adaptador.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }

    public void CambiarPokeHabi(){
        TextView listaPokemon = findViewById(R.id.tvListaPokemones);
        listaPokemon.setOnClickListener(v->{
            recreate();
        });
        TextView listaHabilidades = findViewById(R.id.tvListaHabilidades);
        listaHabilidades.setOnClickListener(v->{
            Intent intent = new Intent(ListaPokemon.this, ListaHabilidades.class);
            startActivity(intent);
        });
    }

}