package com.hgp_android.coleliga;

/**
 * Created by AnahiAramayo on 15/11/2017.
 */

public class Torneo {
    private int imagen;
    private String nombre;
    private String elementos;

    public Torneo(int imagen, String nombre, String elementos) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.elementos = elementos;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getElementos() {
        return elementos;
    }

    public void setElementos(String elementos) {
        this.elementos = elementos;
    }


}
