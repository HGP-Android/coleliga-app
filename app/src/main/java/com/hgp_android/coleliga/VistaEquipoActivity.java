package com.hgp_android.coleliga;

import android.content.res.Resources;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VistaEquipoActivity extends AppCompatActivity {
    private Equipo equipo;
    private long id;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_equipo);
        CargaDatos();
    }

    void CargaDatos(){
        boolean insercion =  getIntent().getExtras().getBoolean( "insercion");
        if (!insercion) {
            int posicion =  getIntent().getExtras().getInt( "numeroEquipo");
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
        }
    }
}
