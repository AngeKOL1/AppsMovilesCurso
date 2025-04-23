package com.example.semana5.Entidades;

import com.google.gson.annotations.SerializedName;

public class Pokemon {
    @SerializedName("name")
    public String name;
    @SerializedName("url")
    public String url;

    public Pokemon(String name, String url){
        this.name=name;
        this.url=url;
    }
}
