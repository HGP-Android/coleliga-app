package com.hgp_android.coleliga;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegistroSignUp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_signup);
    }

    public void lanzarMainDesdeSignUp (View view)
    {
        Intent i = new Intent(this, PrincipalActivity.class);
        startActivity(i);
    }

}
