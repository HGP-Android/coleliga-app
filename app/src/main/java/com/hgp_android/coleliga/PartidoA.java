package com.hgp_android.coleliga;


/**
 * Created by AnahiAramayo on 09/11/2017.
 */

public class PartidoA {
    private int resultadoA, resultadoB;
    private String name_equipoA, name_equipoB;
    private String fecha;
    private String lugar_cancha;
    private String hora;


    public int getResultadoA() {
        return resultadoA;
    }

    public void setResultadoA(int resultadoA) {
        this.resultadoA = resultadoA;
    }

    public int getResultadoB() {
        return resultadoB;
    }

    public void setResultadoB(int resultadoB) {
        this.resultadoB = resultadoB;
    }

    public String getName_equipoA() {
        return name_equipoA;
    }

    public void setName_equipoA(String name_equipoA) {
        this.name_equipoA = name_equipoA;
    }

    public String getName_equipoB() {
        return name_equipoB;
    }

    public void setName_equipoB(String name_equipoB) {
        this.name_equipoB = name_equipoB;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar_cancha() {
        return lugar_cancha;
    }

    public void setLugar_cancha(String lugar_cancha) {
        this.lugar_cancha = lugar_cancha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public PartidoA(int resultadoA, int resultadoB, String name_equipoA, String name_equipoB, String fecha, String lugar_cancha, String hora) {
        this.resultadoA = resultadoA;
        this.resultadoB = resultadoB;
        this.name_equipoA = name_equipoA;
        this.name_equipoB = name_equipoB;
        this.fecha = fecha;
        this.lugar_cancha = lugar_cancha;
        this.hora = hora;
    }

}
