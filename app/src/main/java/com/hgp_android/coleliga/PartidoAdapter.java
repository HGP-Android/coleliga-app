package com.hgp_android.coleliga;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


/**
 * Created by AnahiAramayo on 11/12/17.
 */

public class PartidoAdapter extends
        RecyclerView.Adapter <PartidoAdapter.ListaViewHolder> {
    private List<Partido> items;
    public static class ListaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView resultadoA;
        public TextView resultadoB;
        public TextView name_equipoA;
        public TextView name_equipoB;
        public TextView fecha;
        public TextView lugar_cancha, goleadorA, goleadorB;
        public String hora;
        public ImageView logo_equipoA, logo_equipoB;


        public ListaViewHolder(View v) {
            super(v);
            logo_equipoA = (ImageView) v.findViewById(R.id.logoequipoA);
            logo_equipoB = (ImageView) v.findViewById(R.id.logoequipoB);
            name_equipoA = (TextView) v.findViewById(R.id.name_equipoA);
            name_equipoB = (TextView) v.findViewById(R.id.name_equipoB);
            lugar_cancha = (TextView) v.findViewById(R.id.cancha);
            resultadoA = (TextView) v.findViewById(R.id.golA);
            resultadoB = (TextView) v.findViewById(R.id.golB);
            fecha = (TextView) v.findViewById(R.id.fecha);
            goleadorA = (TextView) v.findViewById(R.id.name_goleadorA);
            goleadorB = (TextView) v.findViewById(R.id.name_goleadorB);
        }
    }
    public PartidoAdapter(List<Partido> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.elemento_fixture, viewGroup, false);
        return new ListaViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ListaViewHolder viewHolder, int i) {
        //viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.name_equipoA.setText(items.get(i).getName_equipoA());
        viewHolder.name_equipoB.setText(items.get(i).getName_equipoB());
        viewHolder.lugar_cancha.setText(items.get(i).getLugar_cancha());
        viewHolder.resultadoA.setText(items.get(i).getResultadoA());
        viewHolder.resultadoB.setText(items.get(i).getResultadoB());
        viewHolder.fecha.setText(items.get(i).getFecha());


    }
}