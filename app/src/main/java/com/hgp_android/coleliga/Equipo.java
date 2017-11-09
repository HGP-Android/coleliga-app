package com.hgp_android.coleliga;
/**
 * Created by carlos on 09/11/2017.
 */

public class Equipo {
    private String nombre;
    private int logo;
    private String ubicacion;
    private int max_jugadores;
    private int jugadores_act;
    private int id_entrenador;
    private int categoria;

    public Equipo(String nombre, int logo, String ubicacion, int max_jugadores,int jugadores_act, int id_entrenador, int categoria) {
        this.nombre = nombre;
        this.logo = logo;
        this.ubicacion = ubicacion;
        this.max_jugadores = max_jugadores;
        this.jugadores_act = jugadores_act;
        this.id_entrenador = id_entrenador;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getMax_jugadores() {
        return max_jugadores;
    }

    public void setMax_jugadores(int max_jugadores) {
        this.max_jugadores = max_jugadores;
    }

    public int getId_entrenador() {
        return id_entrenador;
    }

    public void setId_entrenador(int id_entrenador) {
        this.id_entrenador = id_entrenador;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getJugadores_act() {
        return jugadores_act;
    }

    public void setJugadores_act(int jugadores_act) {
        this.jugadores_act = jugadores_act;
    }

    public Equipo() {
        this.nombre = "vacio";
    }
}
