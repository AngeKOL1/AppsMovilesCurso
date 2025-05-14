package com.example.listapokemonesfirebase.Entidades;

import java.util.List;

public class Habilidades {
    public String idHabilidad;
    public String nombre;
    public int dano;
    public String tipo;

    public String linkImagen;
    List<Pokemon> portadores;


    public Habilidades(){

    }

    public Habilidades(String idHabilidad, String nombre, int dano, String tipo, String linkImagen, List<Pokemon> portadores) {
        this.idHabilidad = idHabilidad;
        this.nombre = nombre;
        this.dano = dano;
        this.tipo = tipo;
        this.linkImagen = linkImagen;
        this.portadores = portadores;
    }
}
