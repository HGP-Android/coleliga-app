package com.hgp_android.coleliga.partidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hgp_android.coleliga.R;

import java.util.Date;

public class EditarPartidoActivity extends AppCompatActivity {

    private int posicion;
    private boolean editar;
    private Partido partido = null;
    TextView nickname_partido,lugar,fecha,equipo_a,equipo_b,jugadores_max;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_partido);

        nickname_partido    = (TextView)findViewById(R.id.nickname_partido);
        lugar               = (TextView)findViewById(R.id.lugar);
        fecha               = (TextView)findViewById(R.id.fecha);
        equipo_a            = (TextView)findViewById(R.id.equipo_a);
        equipo_b            = (TextView)findViewById(R.id.equipo_b);
        jugadores_max       = (TextView)findViewById(R.id.jugadores_max);


        editar = getIntent().getExtras().getBoolean( "editar");
        if(editar)
        {
            posicion =  getIntent().getExtras().getInt( "numeroPartido");
            partido = PartidosActivity.partidos.elemento(posicion);

            nickname_partido.setText(partido.getNicknamePartido());
            lugar.setText(partido.getPlace());
            fecha.setText(partido.getFecha());
            equipo_a.setText(partido.getTeamA());
            equipo_b.setText(partido.getTeamB());
            jugadores_max.setText(String.valueOf(partido.getMaxPlayers()));
        }

        //Gestión botón flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_save_partido);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editar)
                {
                    partido.setNicknamePartido(nickname_partido.getText().toString());
                    partido.setPlace(lugar.getText().toString());
                    partido.setFecha(new Date());
                    partido.setTeamA(equipo_a.getText().toString());
                    partido.setTeamB(equipo_b.getText().toString());
                    partido.setMaxPlayers(Integer.valueOf(jugadores_max.getText().toString()));
                }
                else
                    {
                        partido = new Partido(nickname_partido.getText().toString(),
                                new Date(),
                                equipo_a.getText().toString(),
                                equipo_b.getText().toString(),
                                lugar.getText().toString(),
                                Integer.valueOf(jugadores_max.getText().toString()));

                        PartidosActivity.partidos.anyade(partido);
                    }




                EditarPartidoActivity.this.finish();
            }
        });

    }

}
