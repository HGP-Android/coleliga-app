package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by MAPALEU on 09/11/2017.
 */

public class RegistroLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
    }

    public void lanzarMainDesdeLogin (View view)
    {
        Intent i = new Intent(this, PrincipalActivity.class);
        startActivity(i);
    }

    public void lanzarFacebook (View view)
    {
        Intent i = new Intent(this, RegistroFacebbok.class);
        startActivity(i);
    }

    public void seleccionarCuenta (View view)
    {
        Intent i = new Intent(this, RegistroGoogle.class);
        startActivity(i);
    }



}
