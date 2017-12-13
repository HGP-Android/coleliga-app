package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.hgp_android.coleliga.lugares.PlaceListActivity;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        CardView equipoCard = (CardView) findViewById(R.id.equiposCard);
        equipoCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarEquipos(view);
            }
        });
        CardView entrenamientoCard = (CardView) findViewById(R.id.entrenamientosCard);
        entrenamientoCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarEntrenamientos(view);
            }
        });
        CardView partidoCard = (CardView) findViewById(R.id.partidosCard);
        partidoCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarPartidos(view);
            }
        });
        CardView resultadosCard = (CardView) findViewById(R.id.resultadosCard);
        resultadosCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarResultados(view);
            }
        });
        CardView clasificacionCard = (CardView) findViewById(R.id.clasificacionCard);
        clasificacionCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarClasificaciones(view);
            }
        });
        CardView lugaresCard = (CardView) findViewById(R.id.lugaresCard);
        lugaresCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarLugares(view);
            }
        });
        CardView perfilCard = (CardView) findViewById(R.id.perfilesCard);
        perfilCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarPerfil(view);
            }
        });
    }
    void lanzarEquipos(View view){
        Toast.makeText(this,"Equipo",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,
                EquiposActivity.class);
        startActivity(i);
    }
    void lanzarEntrenamientos(View view){
        Toast.makeText(this,"Entrenamiento",Toast.LENGTH_SHORT).show();
    }
    void lanzarPartidos(View view){
        Toast.makeText(this,"Partido",Toast.LENGTH_SHORT).show();

    }
    void lanzarResultados(View view){
        Intent i = new Intent(this,
        //        ListaPartidos.class);
        Resultado.class);
        startActivity(i);
        //Toast.makeText(this,"Resultado",Toast.LENGTH_SHORT).show();
    }
    void lanzarClasificaciones(View view){
        Intent i = new Intent(this,
                ListasTorneos.class);
        startActivity(i);
    }
    void lanzarLugares(View view){
        Toast.makeText(this,"Lugares",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,
                PlaceListActivity.class);
        startActivity(i);
    }
    void lanzarPerfil(View view){
        Toast.makeText(this,"Perfil",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,
                RegistroFull.class);
        startActivity(i);
    }
}
