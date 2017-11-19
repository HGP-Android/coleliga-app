package com.hgp_android.coleliga.lugares;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hgp_android.coleliga.R;

import java.util.ArrayList;

/**
 * Created by paco on 19/11/17.
 */

public class PlaceAdapter extends RecyclerView.Adapter <PlaceAdapter.PlaceViewHolder>{

    public ArrayList<Place> items;


    public static class PlaceViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView name;
        public TextView address;
        public TextView schedule;
        public TextView body;

        public PlaceViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.ivPlaceImage);
            name = (TextView) itemView.findViewById(R.id.tvPlaceName);
            address = (TextView) itemView.findViewById(R.id.tvPlaceAddress);
            body = (TextView) itemView.findViewById(R.id.tvPlaceBody);
            schedule = (TextView) itemView.findViewById(R.id.tvPlaceSchedule);

        }

    }

    public PlaceAdapter(ArrayList<Place> items) {
        this.items = items;
    }


    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_place_teaser, parent, false);
        return new PlaceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        holder.image.setImageResource(items.get(position).getImage());
        holder.name.setText(items.get(position).getName());
        //holder.name.setBackgroundColor(0xFF79D685);
        holder.address.setText(items.get(position).getAddress());
        holder.body.setText(items.get(position).getBody());
        holder.schedule.setText(items.get(position).getSchedule());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
