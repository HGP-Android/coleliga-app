package com.hgp_android.coleliga.partidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hgp_android.coleliga.EditarEquipoActivity;
import com.hgp_android.coleliga.EquipoAdapter;
import com.hgp_android.coleliga.Equipos;
import com.hgp_android.coleliga.EquiposActivity;
import com.hgp_android.coleliga.EquiposVector;
import com.hgp_android.coleliga.R;
import com.hgp_android.coleliga.RecyclerItemClickListener;
import com.hgp_android.coleliga.VistaEquipoActivity;


public class PartidosActivity  extends AppCompatActivity {

    public static PartidoVector partidos = new PartidoVector();

    private RecyclerView recycler;
    public  PartidoAdapter adaptador;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos);

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.recycler_partidos);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adaptador = new PartidoAdapter(this,partidos);
        recycler.setAdapter(adaptador);

        // Creación escuchador para la seleccion de los elementos del RecyclerView
        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(PartidosActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {

                        StringBuilder tmp = new StringBuilder();
                        tmp.append("");
                        tmp.append(position);
                        /*String msg = "Se ha pulsado el elemento " + tmp.toString();
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();*/
                        Intent intent = new Intent(PartidosActivity.this, DetallePartidoActivity.class);
                        intent.putExtra("numeroPartido", position);
                        intent.putExtra("insercion", false);
                        startActivity(intent);
                    }
                })
        );


        //Gestión botón flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_partidos);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PartidosActivity.this, EditarEquipoActivity.class);
                intent.putExtra("insercion", true);
                startActivity(intent);
            }
        });
    }


}
