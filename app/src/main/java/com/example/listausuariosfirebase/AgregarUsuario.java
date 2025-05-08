package com.example.listausuariosfirebase;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listausuariosfirebase.Entidades.Usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AgregarUsuario extends AppCompatActivity {
    private EditText nombre, telefono, genero, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_usuario);

        nombre= findViewById(R.id.nombreUsuario);
        telefono= findViewById(R.id.telefonoUsuario);
        genero = findViewById(R.id.generoUsuario);
        direccion= findViewById(R.id.direccionUsuario);

        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("usuarios");
        String id= dbRef.push().getKey();
        Button btnAgregarUsuario = findViewById(R.id.buttonGuardar);
        btnAgregarUsuario.setOnClickListener(v->{
            save();
        });
    }
    private void save() {
        Usuario usuario = new Usuario();

        usuario.nombre= nombre.getText().toString();
        usuario.telefono=telefono.getText().toString();
        usuario.genero= genero.getText().toString();
        usuario.direcccion=direccion.getText().toString();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        DatabaseReference colorRef = myRef.child("usuarios").push();
        usuario.id = colorRef.getKey();
        colorRef.setValue(usuario)
                .addOnSuccessListener(unused -> {
                    Toast.makeText(getApplicationContext(), "Usuario creado", Toast.LENGTH_LONG).show();
                }).addOnFailureListener(f -> {
                    Toast.makeText(getApplicationContext(), "Error al crear usuario", Toast.LENGTH_LONG).show();
                });



    }
}