package com.hgp_android.coleliga.player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hgp_android.coleliga.R;

import java.util.ArrayList;

public class PlayerListActivity extends AppCompatActivity implements PlayerMVP.View {

    private ArrayList<Player> players = new ArrayList<Player>();

    private RecyclerView recycler;
    //private RecyclerView.Adapter adapter;
    //private RecyclerView.LayoutManager llm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        // Generamos los jugadores
        generatePlayer();

        recycler = (RecyclerView) findViewById(R.id.rvPlayerList);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recycler.setLayoutManager(llm);

        recycler.setAdapter(new PlayerAdapter(players));


    }


    private ArrayList<Player> generatePlayer(){

        //players = new ArrayList<Player>();

        players.add(new Player("Juanito Valderrama","Valde", "24/05/1916", "España","Torredelcampo", R.drawable.valderrama, "Defensa"));
        players.add(new Player("Juan Peña","Lebrijano", "08/08/1941", "España","Torredelcampo", R.drawable.lebrijano, "Delantero"));
        players.add(new Player("José Monje Cruz","Camarón", "05/12/1950", "España","Cadiz", R.drawable.camaron, "Portero"));
        players.add(new Player("Estrella Morente","Mora", "11/1/1980", "España","Granada", R.drawable.estrella_morente, "Defensa"));

        return players;

    }

}
