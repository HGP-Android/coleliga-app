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
        int logo = R.drawable.ic_escudo;
        ArrayList<com.hgp_android.coleliga.Equipo> equipos = new ArrayList<com.hgp_android.coleliga.Equipo>();
        equipos.add(new com.hgp_android.coleliga.Equipo("Manolete Team",logo,"Castellón", 20, 20,"Guardiola",1));
        equipos.add(new com.hgp_android.coleliga.Equipo("algo Team",logo,"Madrid", 20, 16,"Mourinho",3));
        equipos.add(new com.hgp_android.coleliga.Equipo("OtroMas Team",logo,"Barcelona", 18, 14,"Manolo",7));
        equipos.add(new com.hgp_android.coleliga.Equipo("Barraca Team",logo,"Borriol", 21, 16,"Max",4));
        equipos.add(new com.hgp_android.coleliga.Equipo("Alaolla Team",logo,"Castellón", 16, 16,"Paco",2));
        equipos.add(new com.hgp_android.coleliga.Equipo("abc Team",logo,"Castellón", 20, 16,"Anahí",6));
        equipos.add(new com.hgp_android.coleliga.Equipo("cde Team",logo,"Alicante", 20, 16,"Osvaldo",5));
        equipos.add(new com.hgp_android.coleliga.Equipo("efg Team",logo,"Burriana", 20, 16,"Padre motivado",0));

        return equipos;
    }
}
