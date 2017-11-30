package com.hgp_android.coleliga.partidos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.hgp_android.coleliga.EquiposActivity;
import com.hgp_android.coleliga.R;

public class DetallePartidoActivity extends AppCompatActivity {

    private int posicion;
    private Partido partido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_partido);

        posicion =  getIntent().getExtras().getInt( "numeroPartido");
        partido = PartidosActivity.partidos.elemento(posicion);




    }


}
