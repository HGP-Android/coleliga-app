package com.hgp_android.coleliga;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class EditarEquipoActivity extends AppCompatActivity {
    private Equipo equipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_equipo);
        CargaDatos();
    }

    void CargaDatos(){
        boolean insercion =  getIntent().getExtras().getBoolean( "insercion");
        if (!insercion) {

            int posicion =  getIntent().getExtras().getInt( "numeroEquipo");
            equipo = EquiposActivity.equipos.elemento((int)posicion);
            TextView nombre, entrenador, ubicacion, jugadores;
            Button boton = (Button) findViewById(R.id.aceptar);
            boton.setText("Actualizar");
            Spinner categoria;
            ImageView logo = (ImageView) findViewById(R.id.escudo);
            nombre = (TextView) findViewById(R.id.titulo);
            categoria = (Spinner) findViewById(R.id.golA);
            entrenador = (TextView) findViewById(R.id.entrenador);
            ubicacion = (TextView) findViewById(R.id.direccion);
            jugadores = (TextView) findViewById(R.id.jugadores_max);

            logo.setImageResource(equipo.getLogo());
            nombre.setText(equipo.getNombre());
            categoria.setSelection(equipo.getCategoria());
            entrenador.setText(equipo.getId_entrenador());
            ubicacion.setText(equipo.getUbicacion());
            jugadores.setText(equipo.getMax_jugadores()+"");
        }
        else{
            equipo = new Equipo();
            Button boton = (Button) findViewById(R.id.aceptar);
            boton.setText("Crear");
        }
    }

    void CargaImagen(View view){
        Snackbar.make(view, "Se cargará una imagen de la galeria", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    void Confirmar(View view){
        TextView nombre, entrenador, ubicacion, jugadores;
        Spinner categoria;
        ImageView logo = (ImageView) findViewById(R.id.escudo);
        nombre = (TextView) findViewById(R.id.titulo);
        categoria = (Spinner) findViewById(R.id.golA);
        entrenador = (TextView) findViewById(R.id.entrenador);
        ubicacion = (TextView) findViewById(R.id.direccion);
        jugadores = (TextView) findViewById(R.id.jugadores_max);
        int cat = categoria.getSelectedItemPosition();
        equipo.setCategoria(cat);
        equipo.setNombre(nombre.getText().toString());
        equipo.setId_entrenador(entrenador.getText().toString());
        equipo.setUbicacion(ubicacion.getText().toString());
        Integer jug = Integer.parseInt((jugadores.getText().toString().equals(""))?"0":jugadores.getText().toString());
        equipo.setMax_jugadores(jug);
        EquiposActivity.equipos.anyade(equipo);
        Intent intent = new Intent(EditarEquipoActivity.this, EquiposActivity.class);
        startActivity(intent);
        finish();
    }
}
