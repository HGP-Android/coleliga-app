package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnahiAramayo on 15/11/2017.
 */

public class ListasTorneos extends AppCompatActivity {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creartorneo);

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.listatorneos);
        recycler.setHasFixedSize(true);

        //Inicializar los elementos
        List items = new ArrayList();

        items.add(new Torneo(R.drawable.ic_torneo, "Torneo Jujuy", "Liguilla"));
        items.add(new Torneo(R.drawable.logotorneo, "LogoTorneo", "Eliminatoria"));
        items.add(new Torneo(R.drawable.logotorneo, "LogoTorneo", "Manual"));
        items.add(new Torneo(R.drawable.logotorneo, "LogoTorneo", "Eliminación Directa"));

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new ListaAdapterTorneos(items);
        recycler.setAdapter(adapter);



        //Escuchador para la seleccion de los elementos del recyclerview
        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(ListasTorneos.this, new
                        RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View v, int position) {
                               // Aqui Va lo de Equipos Clasificados
                                Intent intent = new Intent(ListasTorneos.this, ListaClasificacionesTorneo.class);
                                startActivity(intent);
                            }
                        })
        );

        //Gestión botón flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListasTorneos.this, FormTorneoActivity.class);
                intent.putExtra("insercion", true);
                startActivity(intent);
            }
        });
    }
}

