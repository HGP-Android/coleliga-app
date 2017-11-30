package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegistroActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        // definimos la acción del botón
    }

    public void seleccionarCuenta(View view)
    {
        Intent i = new Intent(this,RegistroGoogle.class);
        startActivity(i);
    }

    public void lanzarFacebook(View view)
    {
        Intent i = new Intent(this,RegistroFacebbok.class);
        startActivity(i);
    }

    public void lanzarLogin(View view)
    {
        Intent i = new Intent(this,RegistroLogin.class);
        startActivity(i);
    }

    public void lanzarSignUp(View view)
    {
        Intent i = new Intent(this,RegistroSignUp.class);
        startActivity(i);
    }

    public void lanzarMainDesdeLogin(View view) {

            Intent i = new Intent(this, PrincipalActivity.class);
            startActivity(i);

    }
}
