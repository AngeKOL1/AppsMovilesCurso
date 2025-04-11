package com.example.colores.Services;

import com.example.colores.Entities.ColoresResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ColorService {
    // https://run.mocky.io/v3/b3da6d5b-5c2a-4812-8390-6a2d86ee7899?
    @GET("/api/colors")
    Call<ColoresResponse> getColors();

    @GET("/api/animes")
    Call<ColoresResponse> getAnimes();
}