package com.example.semana5.Services;

import com.example.semana5.Entidades.DetallePokemon;
import com.example.semana5.Entidades.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PokemonService {
    @GET("pokemon")
    Call<PokemonResponse> getPokemons(
            @Query("limit") int limit,
            @Query("offset") int offset
    );
    @GET
    Call<DetallePokemon> getDetallePokemon(@Url String url);
}
