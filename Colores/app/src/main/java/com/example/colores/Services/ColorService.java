package com.example.colores.Services;

import com.example.colores.Entities.Colores;
import com.example.colores.Entities.ColoresResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ColorService {

    @GET("colores")
    Call<List<Colores>> getColors();



}