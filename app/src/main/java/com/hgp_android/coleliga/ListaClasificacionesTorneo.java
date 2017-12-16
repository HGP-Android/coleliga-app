package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
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
        final List items = new ArrayList();

        items.add(new Clasificaciones(R.drawable.ic_escudo, "Manolete Team", "10","10","0","0","10"));
        items.add(new Clasificaciones(R.drawable.ic_escudo2, "algo Team", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_escudo, "OtroMas Team", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_escudo2, "Barraca Team", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "Alaolla Team", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.logotorneo, "abc Team", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ico_pelota, "cde Team", "18","3","14","1","36"));
        items.add(new Clasificaciones(R.drawable.ico_pelota, "efg Team", "18","3","14","1","36"));


        /*TODO cambiar los logos, me faltan las imagenes de los logos en mi rama*/

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
                                Intent intent = new Intent(ListaClasificacionesTorneo.this, VistaEquipoActivity.class);
                                intent.putExtra("numeroEquipo", position);
                                intent.putExtra("insercion", false);
                                intent.putExtra(VistaEquipoActivity.ID, position);

                                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                        ListaClasificacionesTorneo.this,
                                        new Pair<View, String>(v.findViewById(R.id.logoequipo),getString(R.string.transition_name_escudo))
                                );
                                ActivityCompat.startActivity(ListaClasificacionesTorneo.this, intent, options.toBundle());

                                //startActivity(intent);
                            }
                        }));
    }
}