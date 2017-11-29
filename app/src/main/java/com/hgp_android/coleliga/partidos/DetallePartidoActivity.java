package com.hgp_android.coleliga.partidos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.hgp_android.coleliga.R;

public class DetallePartidoActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_partido);


        /*
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


        */
    }


}
