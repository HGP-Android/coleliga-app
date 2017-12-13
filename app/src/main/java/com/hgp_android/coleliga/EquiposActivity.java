package com.hgp_android.coleliga;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class EquiposActivity extends AppCompatActivity {
    public static Equipos equipos = new EquiposVector();

    private RecyclerView recycler;

    public EquipoAdapter adaptador;
    private RecyclerView.LayoutManager lManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adaptador = new EquipoAdapter(this,equipos);
        recycler.setAdapter(adaptador);

        // Creación escuchador para la seleccion de los elementos del RecyclerView
        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(EquiposActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {

                        StringBuilder tmp = new StringBuilder();
                        tmp.append("");
                        tmp.append(position);
                        /*String msg = "Se ha pulsado el elemento " + tmp.toString();
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();*/

                        Intent intent = new Intent(EquiposActivity.this, VistaEquipoActivity.class);
                        intent.putExtra("numeroEquipo", position);
                        intent.putExtra("insercion", false);
                        //ver position reemplazar luego por id
                        intent.putExtra(VistaEquipoActivity.ID, position);

                        //intent.putExtra(DetailsActivity.ID, Contact.CONTACTS[position].getId());

                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(

                                EquiposActivity.this,
                                new Pair<View, String>(v.findViewById(R.id.imagen),getString(R.string.transition_name_escudo))
                        );
                        ActivityCompat.startActivity(EquiposActivity.this, intent, options.toBundle());



                        //startActivity(intent);
                    }
                })
        );
        //Gestión botón flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EquiposActivity.this, EditarEquipoActivity.class);
                intent.putExtra("insercion", true);
                startActivity(intent);
            }
        });
    }
}
