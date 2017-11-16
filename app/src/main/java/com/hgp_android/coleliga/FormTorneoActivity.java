package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by AnahiAramayo on 15/11/2017.
 */

public class FormTorneoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_creartorneo);


        Button boton = (Button) findViewById(R.id.boton_aceptar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(FormTorneoActivity.this, ListasTorneos.class);
                startActivity(intent);

            }
        });

        Button boton_cancelar = (Button) findViewById(R.id.boton_cancelar);
        boton_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(FormTorneoActivity.this, ListasTorneos.class);
                startActivity(intent);

            }
        });
    }
}