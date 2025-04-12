package com.example.proyectoappsmoviles.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String email;
    private String contraseña;
    private String bio;
    private byte[] fotoPerfil;
    private String pais;
    private boolean estadoCuenta;
    private List<Video> videos;

    public Usuario(int idUsuario, String nombreUsuario, String email, String contraseña, String bio, byte []fotoPerfil, String pais, boolean estadoCuenta, List<Video> videos) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contraseña = contraseña;
        this.bio = bio;
        this.fotoPerfil = fotoPerfil;
        this.pais = pais;
        this.estadoCuenta = estadoCuenta;
        this.videos = videos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
