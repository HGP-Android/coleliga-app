package com.hgp_android.coleliga.player;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.hgp_android.coleliga.R;
import com.hgp_android.coleliga.RecyclerItemClickListener;

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

        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(PlayerListActivity.this,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override public void onItemClick(View v, int position) {
                                players.get(position).getName();
                                Intent intent = new Intent(PlayerListActivity.this, PlayerDetailActivity.class);
                                intent.putExtra("player_name", players.get(position).getName());
                                intent.putExtra("player_nickname", players.get(position).getNickname());
                                intent.putExtra("player_birthdate", players.get(position).getBirthdate());
                                intent.putExtra("player_country", players.get(position).getCountry());
                                intent.putExtra("player_city", players.get(position).getCity());
                                intent.putExtra("player_image", players.get(position).getImage());
                                intent.putExtra("player_position", players.get(position).getPosition());

                                startActivity(intent);
                            }
                        })
        );


    }


    private ArrayList<Player> generatePlayer(){

        players.add(new Player("Juanito Valderrama","Valde", "24/05/1916", "España","Torredelcampo", R.drawable.valderrama, "Defensa"));
        players.add(new Player("Juan Peña","Lebrijano", "08/08/1941", "España","Torredelcampo", R.drawable.lebrijano, "Delantero"));
        players.add(new Player("José Monje Cruz","Camarón", "05/12/1950", "España","Cadiz", R.drawable.camaron, "Portero"));
        players.add(new Player("Estrella Morente","Mora", "11/1/1980", "España","Granada", R.drawable.estrella_morente, "Defensa"));

        return players;

    }



}
