package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by AnahiAramayo on 28/11/2017.
 */

public class TorneoModalidad extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.torneomodalidad);
    }

    public void Liguilla(View v){
        // Aqui Va lo de Equipos Clasificados
        Intent intent = new Intent(TorneoModalidad.this, FormTorneoActivity.class);
        startActivity(intent);
    }
    public void Eliminatoria(View v){
        // Aqui Va lo de Equipos Clasificados
        Intent intent = new Intent(TorneoModalidad.this, FormTorneoActivity.class);
        startActivity(intent);
    }
    public void Directa(View v){
        // Aqui Va lo de Equipos Clasificados
        Intent intent = new Intent(TorneoModalidad.this, FormTorneoActivity.class);
        startActivity(intent);
    }
    public void Mixta(View v){
        // Aqui Va lo de Equipos Clasificados
        Intent intent = new Intent(TorneoModalidad.this, FormTorneoActivity.class);
        startActivity(intent);
    }
    public void Manual(View v){
        // Aqui Va lo de Equipos Clasificados
        Intent intent = new Intent(TorneoModalidad.this, FormTorneoActivity.class);
        startActivity(intent);
    }

}
