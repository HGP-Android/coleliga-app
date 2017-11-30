package com.hgp_android.coleliga.partidos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.hgp_android.coleliga.EquiposActivity;
import com.hgp_android.coleliga.R;

public class DetallePartidoActivity extends AppCompatActivity {

    private int posicion;
    private Partido partido;

    TextView nickname_partido,lugar,fecha,equipo_a,equipo_b,jugadores_max;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_partido);

        posicion =  getIntent().getExtras().getInt( "numeroPartido");
        partido = PartidosActivity.partidos.elemento(posicion);

        nickname_partido    = (TextView)findViewById(R.id.nickname_partido);
        lugar               = (TextView)findViewById(R.id.lugar);
        fecha               = (TextView)findViewById(R.id.fecha);
        equipo_a            = (TextView)findViewById(R.id.equipo_a);
        equipo_b            = (TextView)findViewById(R.id.equipo_b);
        jugadores_max       = (TextView)findViewById(R.id.jugadores_max);

        nickname_partido.setText(partido.getNicknamePartido());
        lugar.setText(partido.getPlace());
        fecha.setText(partido.getFecha());
        equipo_a.setText(partido.getTeamA());
        equipo_b.setText(partido.getTeamB());
        jugadores_max.setText("Máxmimos Jugadores: "+partido.getMaxPlayers());




    }


}
