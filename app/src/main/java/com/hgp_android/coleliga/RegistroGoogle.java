package com.hgp_android.coleliga;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistroGoogle extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_google);
    }

    public void lanzarMainDesdeGoogle (View view)
    {
        Intent i = new Intent(this, PrincipalActivity.class);
        startActivity(i);
    }


}
