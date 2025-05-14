package com.example.listapokemonesfirebase;

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

import com.example.listapokemonesfirebase.Adaptadores.HabilidadesAdaptador;
import com.example.listapokemonesfirebase.Adaptadores.PokemonAdaptador;
import com.example.listapokemonesfirebase.Entidades.Habilidades;
import com.example.listapokemonesfirebase.Entidades.Pokemon;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaHabilidades extends AppCompatActivity {
    RecyclerView rvHabilidades;
    HabilidadesAdaptador adaptador;

    List<Habilidades> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_habilidades);

        rvHabilidades = findViewById(R.id.rvHabilidades);
        rvHabilidades.setLayoutManager(new LinearLayoutManager(this));
        setUpRecyclerView();
        IrNuevaHabilidad();
        CambiarPokeHabi();
        CargarHabilidades();


    }
    public void setUpRecyclerView(){
        adaptador = new HabilidadesAdaptador(data, ListaHabilidades.this);
        rvHabilidades.setAdapter(adaptador);
    }
    public void CambiarPokeHabi(){
        TextView listaPokemon = findViewById(R.id.tvListaPokemones);
        listaPokemon.setOnClickListener(v->{
            Intent intent= new Intent(ListaHabilidades.this,ListaPokemon.class);
            startActivity(intent);
        });
        TextView listaHabilidades = findViewById(R.id.tvListaHabilidades);
        listaHabilidades.setOnClickListener(v->{
            recreate();
        });
    }
    public void IrNuevaHabilidad(){
        Button button = findViewById(R.id.botonAgregarH);
        button.setOnClickListener(v->{
            Intent intent = new Intent(ListaHabilidades.this, AgregarHabilidad.class);
            startActivity(intent);
        });
    }
    public void CargarHabilidades(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("habilidades");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot Snapshot : snapshot.getChildren()) {
                    Habilidades habilidades = Snapshot.getValue(Habilidades.class);
                    if (habilidades!= null) {
                        data.add(habilidades);
                    }
                }
                adaptador.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }

}