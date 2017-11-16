package com.hgp_android.coleliga.player;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hgp_android.coleliga.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paco on 15/11/17.
 */

public class PlayerAdapter extends RecyclerView.Adapter <PlayerAdapter.PlayerViewHolder> {

    private ArrayList<Player> items;

    public static class PlayerViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView image;
        public TextView name;
        public TextView city;
        public TextView position;


        public PlayerViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.cvPlayerImg);
            name = (TextView) v.findViewById(R.id.cvPlayerName);
            city = (TextView) v.findViewById(R.id.cvPlayerCity);
            position = (TextView) v.findViewById(R.id.cvPlayerPosition);
        }
    }


    public PlayerAdapter(ArrayList<Player> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_player_teaser, viewGroup, false);
        return new PlayerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlayerViewHolder viewHolder, int i) {
        viewHolder.image.setImageResource(items.get(i).getImage());
        viewHolder.name.setText(items.get(i).getName());
        viewHolder.position.setText(items.get(i).getPosition());
        viewHolder.city.setText(items.get(i).getCity());

    }
}