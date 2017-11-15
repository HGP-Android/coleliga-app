package com.hgp_android.coleliga;

/**
 * Created by carlos on 09/11/2017.
 */

public interface Equipos {
    com.hgp_android.coleliga.Equipo elemento(int id);
    void anyade(com.hgp_android.coleliga.Equipo equipo); //Añade el elemento indicado
    int nuevo(); //Añade un elemento en blanco y devuelve su id
    void borrar(int id); //Elimina el elemento con el id indicado
    int tamanyo(); //Devuelve el número de elementos
    void actualiza(int id, com.hgp_android.coleliga.Equipo Equipo); //Reemplaza un elemento
}
