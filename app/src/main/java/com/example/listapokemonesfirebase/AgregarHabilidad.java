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

import com.example.listapokemonesfirebase.Entidades.Habilidades;
import com.example.listapokemonesfirebase.Entidades.Pokemon;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AgregarHabilidad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_habilidad);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("habilidades");
        String id = dbRef.push().getKey();
        Button btnAdd= findViewById(R.id.botonAddNuevaH);

        btnAdd.setOnClickListener(v->{
            EditText nombreHabilidad = findViewById(R.id.nombreHabilidad);
            String nombreH= nombreHabilidad.getText().toString();

            EditText danoHabilidad = findViewById(R.id.danoHabilidad);
            int danoH= Integer.parseInt(danoHabilidad.getText().toString());

            EditText tipoHabilidad = findViewById(R.id.tipoPokemonH);
            String tipoH= tipoHabilidad.getText().toString();

            List<Pokemon> portadores= new ArrayList<>();

            String tipo = tipoH.toLowerCase(Locale.ROOT);
            String linkImagen;
            switch(tipo) {
                case "fuego":
                    linkImagen = "https://ih3.redbubble.net/image.10995181.8994/sticker,375x360.png";
                    break;
                case "planta":
                    linkImagen = "https://d2bzx2vuetkzse.cloudfront.net/fit-in/0x450/unshoppable_producs/6bac775b-18ba-424e-a520-7b732d5bb7a3.png";
                    break;
                default:
                    linkImagen = "https://ih1.redbubble.net/image.4810549878.0710/st,small,507x507-pad,600x600,f8f8f8.u2.jpg";
            }



            Habilidades nuevo= new Habilidades(id, nombreH, danoH, tipoH,linkImagen, portadores);
            dbRef.child(id).setValue(nuevo)
                    .addOnSuccessListener(aVoid->{
                        Toast.makeText(this, "Habilidach guardada", Toast.LENGTH_SHORT).show();
                    });
        });
    }
}