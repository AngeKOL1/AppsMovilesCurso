package com.example.colores.Entities;

import com.google.gson.annotations.SerializedName;

public class Colores {
   @SerializedName("name")
   public String nombre;

   @SerializedName("colorhex")
   public String colorHex;


   public Colores(String nombre, String colorHex) {
    this.nombre = nombre;
    this.colorHex =colorHex;
   }
}