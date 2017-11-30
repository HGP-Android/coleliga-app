package com.hgp_android.coleliga;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AnahiAramayo on 15/11/2017.
 */

public class ListaAdpaterClasificaciones extends
        RecyclerView.Adapter <ListaAdpaterClasificaciones.ListaViewHolder> {
    private List<Clasificaciones> items;
    public static class ListaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView pj,pg,pe,pp,pts;
        public ListaViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.logoequipo);
            nombre = (TextView) v.findViewById(R.id.nombreequipo);
            pj = (TextView) v.findViewById(R.id.partidosjugados);
            pg = (TextView) v.findViewById(R.id.partidosganados);
            pe = (TextView) v.findViewById(R.id.partidosempatados);
            pp = (TextView) v.findViewById(R.id.partidosperdidos);
            pts = (TextView) v.findViewById(R.id.partidospuntos);
        }
    }
    public ListaAdpaterClasificaciones(List<Clasificaciones> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.elemento_clasificaciontorneo, viewGroup, false);
        return new ListaViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ListaViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.pj.setText(String.valueOf(items.get(i).getPj()));
        viewHolder.pg.setText(String.valueOf(items.get(i).getPg()));
        viewHolder.pe.setText(String.valueOf(items.get(i).getPe()));
        viewHolder.pp.setText(String.valueOf(items.get(i).getPp()));
        viewHolder.pts.setText(String.valueOf(items.get(i).getPts()));

    }
}