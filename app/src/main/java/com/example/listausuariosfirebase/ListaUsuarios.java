package com.example.listausuariosfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listausuariosfirebase.Adaptador.UsuarioAdaptador;
import com.example.listausuariosfirebase.Entidades.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaUsuarios extends AppCompatActivity {
    SearchView searchUsaurios;
    RecyclerView rvUsuarios;
    UsuarioAdaptador adaptador;
    int currentPage =1;
    String busqueda="";
    List<Usuario> data = new ArrayList<>();
    private static final int PAGE_SIZE = 15;
    private String lastKey = null;
    private boolean isLoading = false;
    private boolean isLastPage = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_usuarios);


        rvUsuarios=findViewById(R.id.rvListaUsuarios);
        rvUsuarios.setLayoutManager(new LinearLayoutManager(this));
        setUpSearchView();
        SetUpRecyclerView();
        CargarUsuarios(busqueda);
        IrAgregarUsuario();
    }
    public void IrAgregarUsuario(){
        Button btnAgregar= findViewById(R.id.btnAgregarUsuario);
        btnAgregar.setOnClickListener(v->{
            Intent intent = new Intent(ListaUsuarios.this, AgregarUsuario.class);
            startActivity(intent);
        });
    }
    public void SetUpRecyclerView(){
        adaptador = new UsuarioAdaptador(data, ListaUsuarios.this);
        rvUsuarios.setAdapter(adaptador);
    }
    public void CargarUsuarios(String query) {
        if (isLoading || isLastPage) return;
        isLoading = true;

        Query q;
        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference("usuarios");
        if (lastKey == null) {
            q = ref.orderByKey()
                    .limitToFirst(PAGE_SIZE);
        } else {
            q = ref.orderByKey()
                    .startAfter(lastKey)
                    .limitToFirst(PAGE_SIZE);
        }

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists() || snapshot.getChildrenCount() == 0) {
                    isLastPage = true;
                } else {
                    for (DataSnapshot child : snapshot.getChildren()) {
                        Usuario u = child.getValue(Usuario.class);
                        if (u != null &&
                                (query.isEmpty() ||
                                        u.nombre.toLowerCase()
                                                .contains(query.toLowerCase()))) {
                            data.add(u);
                            lastKey = child.getKey();
                        }
                    }
                    if (snapshot.getChildrenCount() < PAGE_SIZE) {
                        isLastPage = true;
                    }
                    adaptador.notifyDataSetChanged();
                }
                isLoading = false;
            }
            @Override public void onCancelled(@NonNull DatabaseError e) {
                isLoading = false;
            }
        });
    }

    private void setUpSearchView() {
        searchUsaurios = findViewById(R.id.searchUsuario);
        searchUsaurios.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("MAIN_APP", query);

                if(!Objects.equals(busqueda, query)) {
                    data.clear();
                    adaptador.notifyDataSetChanged();
                    busqueda = query;
                    currentPage = 1;
                    CargarUsuarios(busqueda);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("MAIN_APP", newText);
                if (newText.isEmpty()) {
                    data.clear();
                    adaptador.notifyDataSetChanged();
                    busqueda = "";
                    currentPage = 1;
                    CargarUsuarios(busqueda);
                }
                return false;
            }
        });
    }

}