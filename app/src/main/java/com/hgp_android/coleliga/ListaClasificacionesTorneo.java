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

        items.add(new Clasificaciones(R.drawable.logotorneo, "Manolete Team", "10","10","0","0","10"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "algo Team", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "OtroMas Team", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "Barraca Team", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "Alaolla Team", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "abc Team", "9","5","4","1","6"));
        items.add(new Clasificaciones(R.drawable.ic_torneo, "cde Team", "18","3","14","1","36"));
        items.add(new Clasificaciones(R.drawable.logo, "efg Team", "18","3","14","1","36"));

        /*equipos.add(new com.hgp_android.coleliga.Equipo("Manolete Team",logo,"Castellón", 20, 20,"Guardiola",1));
        equipos.add(new com.hgp_android.coleliga.Equipo("algo Team",logo2,"Madrid", 20, 16,"Mourinho",3));
        equipos.add(new com.hgp_android.coleliga.Equipo("OtroMas Team",logo,"Barcelona", 18, 14,"Manolo",7));
        equipos.add(new com.hgp_android.coleliga.Equipo("Barraca Team",logo2,"Borriol", 21, 16,"Max",4));
        equipos.add(new com.hgp_android.coleliga.Equipo("Alaolla Team",logo2,"Castellón", 16, 16,"Paco",2));
        equipos.add(new com.hgp_android.coleliga.Equipo("abc Team",logo,"Castellón", 20, 16,"Anahí",6));
        equipos.add(new com.hgp_android.coleliga.Equipo("cde Team",logo2,"Alicante", 20, 16,"Osvaldo",5));
        equipos.add(new com.hgp_android.coleliga.Equipo("efg Team",logo,"Burriana", 20, 16,"Padre motivado",8));
        * */
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