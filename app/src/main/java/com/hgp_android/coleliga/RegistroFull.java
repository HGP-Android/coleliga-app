package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by MAPALEU on 15/11/2017.
 */

public class RegistroFull extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_full);
    }

    public void jugadorNuevo(View view)
    {
        Intent i = new Intent(this,RegistroFullJugador.class);
        startActivity(i);
    }

    public void entrenadorNuevo(View view)
    {
        Intent i = new Intent(this,RegistroFullEntrenador.class);
        startActivity(i);
    }

    public void organizdorNuevo(View view)
    {
        Intent i = new Intent(this,RegistroFullOrganizador.class);
        startActivity(i);
    }

    public void duenioNuevo(View view)
    {
        Intent i = new Intent(this,RegistroFullDuenio.class);
        startActivity(i);
    }



}
