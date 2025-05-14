package com.example.listapokemonesfirebase.Entidades;

import java.util.List;

public class Pokemon {
    public String idPokemon;
    public String nombre;
    public String tipo;
    public Double tamano;
    public Double peso;
    public List<Habilidades> habilidades;
    public String linkImagen;
    public List<Ubicacion> ubicaciones;
    public Pokemon(){

    }

    public Pokemon(String idPokemon, String nombre, String tipo, Double tamano, Double peso, List<Habilidades> habilidades, String linkImagen, List<Ubicacion> ubicaciones) {
        this.idPokemon = idPokemon;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamano = tamano;
        this.peso = peso;
        this.habilidades = habilidades;
        this.linkImagen = linkImagen;
        this.ubicaciones = ubicaciones;
    }

}
