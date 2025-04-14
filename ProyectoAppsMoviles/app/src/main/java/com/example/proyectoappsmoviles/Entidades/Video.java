package com.example.proyectoappsmoviles.Entidades;

import java.util.Date;
import java.util.List;

public class Video {
    private int idVideo;
    private String titulo;
    private String fechaSubida;

    private int duracionSegundos;
    private int numLikes;
    private int numComentarios =0;
    private int numReproducciones =0;
    private String privacidad;
    private Usuario creador;



    public Video(int idVideo, String titulo, String fechaSubida, int duracionSegundos, int numLikes, int numComentarios, int numReproducciones, String privacidad, Usuario creador) {
        this.idVideo = idVideo;
        this.titulo = titulo;
        this.fechaSubida = fechaSubida;

        this.duracionSegundos = duracionSegundos;
        this.numLikes = numLikes;
        this.numComentarios = numComentarios;
        this.numReproducciones = numReproducciones;
        this.privacidad = privacidad;
        this.creador = creador;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(String fechaSubida) {
        this.fechaSubida = fechaSubida;
    }



    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public int getNumComentarios() {
        return numComentarios;
    }

    public void setNumComentarios(int numComentarios) {
        this.numComentarios = numComentarios;
    }

    public int getNumReproducciones() {
        return numReproducciones;
    }

    public void setNumReproducciones(int numReproducciones) {
        this.numReproducciones = numReproducciones;
    }

    public String getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }
}
