package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import java.util.ArrayList;

import java.util.List;

public class ListaPartidos extends AppCompatActivity {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_fixture);

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.listafixture);
        recycler.setHasFixedSize(true);

        //Inicializar los elementos
        final List items = new ArrayList();

        items.add(new PartidoA(2,1,"EquipoA","EquipoB","12/12/17","CANCHA - 15:00hs","15"));
        items.add(new PartidoA(2,1,"EquipoA","EquipoB","12/12/17","CANCHA - 15:00hs","15"));
        items.add(new PartidoA(2,1,"EquipoA","EquipoB","12/12/17","CANCHA - 15:00hs","15"));
        items.add(new PartidoA(2,1,"EquipoA","EquipoB","12/12/17","CANCHA - 15:00hs","15"));

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new PartidoAdapter(items);
        recycler.setAdapter(adapter);

        //Escuchador para la seleccion de los elementos del recyclerview
        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(ListaPartidos.this, new
                        RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View v, int position) {
                                // Aqui Va lo de Equipos Clasificados
                                Intent intent = new Intent(ListaPartidos.this, VistaEquipoActivity.class);
                                /*intent.putExtra("numeroEquipo", position);
                                intent.putExtra("insercion", false);
                                intent.putExtra(VistaEquipoActivity.ID, position);

                                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                        ListaPartidos.this,
                                        new Pair<View, String>(v.findViewById(R.id.logoequipoA),getString(R.string.transition_name_escudo))
                                );
                                ActivityCompat.startActivity(ListaPartidos.this, intent, options.toBundle());
                                */

                                startActivity(intent);
                            }
                        }));
    }
}