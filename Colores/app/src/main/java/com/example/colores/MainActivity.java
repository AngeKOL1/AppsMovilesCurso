package com.example.colores;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colores.Adaptadores.ColorAdapter;
import com.example.colores.Entities.Colores;
import com.example.colores.Entities.ColoresResponse;
import com.example.colores.Services.ColorService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
            );
            return insets;
        });

        // Verifica que RecyclerView exista
        rvColors = findViewById(R.id.rvListColors);
        if (rvColors == null) {
            Toast.makeText(this, "Error: RecyclerView no encontrado", Toast.LENGTH_LONG).show();
            Log.e("MainActivity", "RecyclerView con id rvListColors no existe");
            return;
        }

        rvColors.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://6805422aca467c15be68af6b.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ColorService service = retrofit.create(ColorService.class);

        Call<List<Colores>> call = service.getColors();

        call.enqueue(new Callback<List<Colores>>() {
            @Override
            public void onResponse(Call<List<Colores>> call, Response<List<Colores>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Error en la respuesta: " + response.code(), Toast.LENGTH_SHORT).show();
                    Log.e("MainActivity", "Respuesta fallida: " + response.code());
                    return;
                }

                List<Colores> colores = response.body();
                if (colores == null || colores.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Lista vacía", Toast.LENGTH_SHORT).show();
                    Log.e("MainActivity", "Lista vacía");
                    return;
                }

                rvColors.setAdapter(new ColorAdapter(colores));
            }

            @Override
            public void onFailure(Call<List<Colores>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fallo en la conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("MainActivity", "Error de red o JSON: ", t);
            }
        });

    }
}
