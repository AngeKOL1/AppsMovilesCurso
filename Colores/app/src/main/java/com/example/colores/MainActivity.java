package com.example.colores;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
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
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView rvColors = findViewById(R.id.rvListColors);
        rvColors.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.csscolorsapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ColorService service = retrofit.create(ColorService.class);

        service.getColors().enqueue(new Callback<ColoresResponse>() {
            @Override
            public void onResponse(Call<ColorResponse> call, Response<ColorResponse> response) {

                if (!response.isSuccessful()) return;

                List<Colores> data = response.body().colors;

                ColorAdapter adapter = new ColorAdapter(data);
                rvColors.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ColoresResponse> call, Throwable throwable) {

            }
        });


    }
}