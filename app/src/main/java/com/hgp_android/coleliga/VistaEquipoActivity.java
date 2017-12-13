package com.hgp_android.coleliga;

import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VistaEquipoActivity extends AppCompatActivity {
    private Equipo equipo;
    private int posicion;

    public final static String ID= "ID";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_equipo);
        CargaDatos();

        //Gestión botón flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VistaEquipoActivity.this, EditarEquipoActivity.class);
                intent.putExtra("numeroEquipo", posicion);
                intent.putExtra("insercion", false);
                startActivity(intent);
            }
        });
    }

    void CargaDatos(){
        //boolean insercion =  getIntent().getExtras().getBoolean( "insercion");
        //if (!insercion) {
            posicion =  getIntent().getExtras().getInt( "numeroEquipo");
            equipo = EquiposActivity.equipos.elemento((int)posicion);
            TextView nombre, categoria, entrenador, ubicacion, jugadores;
            ImageView logo = (ImageView) findViewById(R.id.escudo);
            nombre = (TextView) findViewById(R.id.titulo);
            categoria = (TextView) findViewById(R.id.categoria);
            entrenador = (TextView) findViewById(R.id.entrenador);
            ubicacion = (TextView) findViewById(R.id.direccion);
            jugadores = (TextView) findViewById(R.id.jugadores_max);

            Resources res = this.getResources();
            String categorias[] = res.getStringArray(R.array.tiposCategorias);

            logo.setImageResource(equipo.getLogo());
            nombre.setText(equipo.getNombre());
            categoria.setText(categorias[equipo.getCategoria()]);
            entrenador.setText(equipo.getId_entrenador());
            ubicacion.setText(equipo.getUbicacion());
            jugadores.setText(equipo.getJugadores_act() + " de " + equipo.getMax_jugadores() + " posibles");
        //}
    }

    void EditarEquipo(View view){
        Intent intent = new Intent(VistaEquipoActivity.this, EditarEquipoActivity.class);
        intent.putExtra("posicion", posicion);
        intent.putExtra("insercion", false);
        startActivity(intent);
    }
}
