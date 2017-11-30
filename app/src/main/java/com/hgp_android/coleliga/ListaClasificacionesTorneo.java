package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnahiAramayo on 15/11/2017.
 */

public class ListaClasificacionesTorneo extends AppCompatActivity {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clasificacionestorneo);
// Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.clasificaionestorneos);
        recycler.setHasFixedSize(true);

        //Inicializar los elementos
        List items = new ArrayList();

        items.add(new Clasificaciones(R.drawable.ic_torneo, "ArdeIngenieria", "10","10","0","0","10"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "Jujenios", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "Jujenios", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "Jujenios", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "Jujenios", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "Jujenios", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "Profesionales de Jujuy", "18","3","14","1","36"));


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new ListaAdpaterClasificaciones(items);
        recycler.setAdapter(adapter);



        //Escuchador para la seleccion de los elementos del recyclerview
        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(ListaClasificacionesTorneo.this, new
                        RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View v, int position) {
                                // Aqui Va lo de Equipos Clasificados
                                Intent intent = new Intent(ListaClasificacionesTorneo.this, ListasTorneos.class);
                                startActivity(intent);
                            }
                        })
        );

    }
}