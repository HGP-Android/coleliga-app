package com.hgp_android.coleliga;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by carlos on 09/11/2017.
 */

public class EquiposVector implements Equipos {
    protected List<com.hgp_android.coleliga.Equipo> vectorEquipos = ejemploEquipos();

    public EquiposVector(){
        vectorEquipos = ejemploEquipos();

    }

    public com.hgp_android.coleliga.Equipo elemento(int id) {
        return vectorEquipos.get(id);
    }

    public void anyade(com.hgp_android.coleliga.Equipo equipo) {
        vectorEquipos.add(equipo);
    }

    public int nuevo() {
        com.hgp_android.coleliga.Equipo equipo = new com.hgp_android.coleliga.Equipo();
        vectorEquipos.add(equipo);
        return vectorEquipos.size()-1;
    }
    public void borrar(int id) {
        vectorEquipos.remove(id);
    }
    public int tamanyo() {
        return vectorEquipos.size();
    }
    public void actualiza(int id, com.hgp_android.coleliga.Equipo lugar) {
        vectorEquipos.set(id, lugar);
    }

    public static ArrayList<com.hgp_android.coleliga.Equipo> ejemploEquipos() {
        ArrayList<com.hgp_android.coleliga.Equipo> equipos = new ArrayList<com.hgp_android.coleliga.Equipo>();
        equipos.add(new com.hgp_android.coleliga.Equipo("Manolete Team",1,"Castellón", 20, 20,4,3));
        equipos.add(new com.hgp_android.coleliga.Equipo("algo Team",1,"Madrid", 20, 16,4,3));
        equipos.add(new com.hgp_android.coleliga.Equipo("OtroMas Team",1,"Barcelona", 18, 14,4,3));
        equipos.add(new com.hgp_android.coleliga.Equipo("Barraca Team",1,"Borriol", 21, 16,4,3));
        equipos.add(new com.hgp_android.coleliga.Equipo("Alaolla Team",1,"Castellón", 16, 16,4,3));
        equipos.add(new com.hgp_android.coleliga.Equipo("abc Team",1,"Castellón", 20, 16,4,3));
        equipos.add(new com.hgp_android.coleliga.Equipo("cde Team",1,"Alicante", 20, 16,4,3));
        equipos.add(new com.hgp_android.coleliga.Equipo("efg Team",1,"Burriana", 20, 16,4,3));

        return equipos;
    }
}
