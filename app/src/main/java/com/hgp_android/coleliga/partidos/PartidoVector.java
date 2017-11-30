package com.hgp_android.coleliga.partidos;

import com.hgp_android.coleliga.Equipo;
import com.hgp_android.coleliga.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class PartidoVector {

    private List<Partido> vectorPartidos;

    public PartidoVector() {
        this.vectorPartidos = partidosMock();
    }

    //Obtener un partido
    public Partido elemento(int id) {
        return this.vectorPartidos.get(id);
    }

    //Añade un partido
    public void anyade(Partido partido) {
        this.vectorPartidos.add(partido);
    }

    //Elimina un objeto del arreglo
    public void borrar(int id) {
        this.vectorPartidos.remove(id);
    }

    //Retorna el tamaño del arreglo de partidos
    public int tamanyo() {
        return this.vectorPartidos.size();
    }

    public static ArrayList<Partido> partidosMock() {
        ArrayList<Partido> partidos = new ArrayList<Partido>();

        partidos.add(new Partido("Partido 1",new Date(),"Manolete Team","algo Team","Instalaciones deportivas Max",10));
        partidos.add(new Partido("Partido 2",new Date(),"Manolete Team","algo Team","Instalaciones deportivas Max",10));
        partidos.add(new Partido("Partido 3",new Date(),"Manolete Team","algo Team","Instalaciones deportivas Max",10));
        partidos.add(new Partido("Partido 4",new Date(),"Manolete Team","algo Team","Instalaciones deportivas Max",10));

        return partidos;
    }



}
