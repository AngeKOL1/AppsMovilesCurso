package com.example.semana5;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.semana5.Entidades.DetallePokemon;
import com.example.semana5.Services.PokemonService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetallePokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_pokemon);
        String urlDetalle = getIntent().getStringExtra("urlDetalle");

        // Ahora llamamos a Retrofit con esa URL
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);

        service.getDetallePokemon(urlDetalle).enqueue(new Callback<DetallePokemon>() {
            @Override
            public void onResponse(Call<DetallePokemon> call, Response<DetallePokemon> response) {
                if (response.isSuccessful()) {
                    DetallePokemon detalle = response.body();
                    TextView idPokemon=findViewById(R.id.idPokemon);
                    idPokemon.setText(String.valueOf(detalle.id));

                    TextView nombrePokemon= findViewById(R.id.nombrePokemon);
                    nombrePokemon.setText(detalle.name);

                    TextView tallaPokemon= findViewById(R.id.alturaPokemon);
                    tallaPokemon.setText(String.valueOf(detalle.weight));

                    TextView pesoPokemon= findViewById(R.id.pesoPokemon);
                    pesoPokemon.setText(String.valueOf(detalle.height));

                    String urlImagen = detalle.sprites.front_default;
                    ImageView imagenPokemon = findViewById(R.id.imagenPokemon);
                    Glide.with(DetallePokemonActivity.this)
                            .load(urlImagen)
                            .into(imagenPokemon);
                }
            }

            @Override
            public void onFailure(Call<DetallePokemon> call, Throwable t) {
                Log.e("API", "Error al obtener detalle: " + t.getMessage());
            }
        });

    }
}