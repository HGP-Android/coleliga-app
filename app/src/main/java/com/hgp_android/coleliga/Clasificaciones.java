package com.hgp_android.coleliga;

/**
 * Created by AnahiAramayo on 29/11/2017.
 */

public class Clasificaciones {
    // Campos respectivos de un item de  clasificaciones
    private int imagen;
    private String nombre;
    private String pj;
    private String pg;
    private String pe;
    private String pp;
    private String pts;

    public Clasificaciones(int imagen, String nombre, String pj, String pg, String pe, String pp, String pts) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.pts = pts;
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

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getPts() {
        return pts;
    }

    public void setPts(String pts) {
        this.pts = pts;
    }
}
