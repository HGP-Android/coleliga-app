package com.hgp_android.coleliga.lugares;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hgp_android.coleliga.R;

import java.util.ArrayList;

/**
 * Created by paco on 19/11/17.
 */

public class PlaceAdapter extends RecyclerView.Adapter <PlaceAdapter.PlaceViewHolder>{

    public ArrayList<Place> items;
    public Context c;


    public static class PlaceViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView name;
        public TextView address;
        public TextView schedule;
        public TextView body;
        public TextView share;

        public PlaceViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.ivPlaceImage);
            name = (TextView) itemView.findViewById(R.id.tvPlaceName);
            address = (TextView) itemView.findViewById(R.id.tvPlaceAddress);
            body = (TextView) itemView.findViewById(R.id.tvPlaceBody);
            schedule = (TextView) itemView.findViewById(R.id.tvPlaceSchedule);
            share = (TextView) itemView.findViewById(R.id.cvPlacesShare);


        }

    }

    public PlaceAdapter(ArrayList<Place> items, Context c) {
        this.items = items;
        this.c = c;
    }


    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_place_teaser, parent, false);
        return new PlaceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PlaceViewHolder holder, final int position) {
        holder.image.setImageResource(items.get(position).getImage());
        holder.name.setText(items.get(position).getName());
        //holder.name.setBackgroundColor(0xFF79D685);
        holder.address.setText(items.get(position).getAddress());
        holder.body.setText(items.get(position).getBody());
        holder.schedule.setText(items.get(position).getSchedule());

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareAppText("Visita " + items.get(position).getName() + " en coleapp http://play.google.com/store/apps/details?id="+
                c.getPackageName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    void shareAppText(String text) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, text);
        c.startActivity(Intent.createChooser(i, "Selecciona aplicación"));
    }


}
