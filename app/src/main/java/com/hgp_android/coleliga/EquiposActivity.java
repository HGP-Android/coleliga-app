package com.hgp_android.coleliga;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class EquiposActivity extends AppCompatActivity {
    public static Equipos equipos = new EquiposVector();

    private RecyclerView recycler;

    public EquipoAdapter adaptador;
    private RecyclerView.LayoutManager lManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adaptador = new EquipoAdapter(this,equipos);
        recycler.setAdapter(adaptador);

        // Creación escuchador para la seleccion de los elementos del RecyclerView
        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(EquiposActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View v, int position) {

                        StringBuilder tmp = new StringBuilder();
                        tmp.append("");
                        tmp.append(position);
                        /*String msg = "Se ha pulsado el elemento " + tmp.toString();
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();*/
                        Intent intent = new Intent(EquiposActivity.this, VistaEquipoActivity.class);
                        intent.putExtra("numeroEquipo", position);
                        intent.putExtra("insercion", false);
                        startActivity(intent);
                    }
                })
        );
    }
}
