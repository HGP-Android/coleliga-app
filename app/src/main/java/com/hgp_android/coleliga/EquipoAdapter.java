package com.hgp_android.coleliga;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by carlos on 09/11/2017.
 */

public class EquipoAdapter extends
        RecyclerView.Adapter <EquipoAdapter.ListaViewHolder> {
    protected Equipos equipos;           //Lugares a mostrar
    protected LayoutInflater inflador;   //Crea Layouts a partir del XML
    protected Context contexto;          //Lo necesitamos para el inflador
    protected View.OnClickListener onClickListener;

    public static class ListaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item

        public ImageView imagen;
        public TextView nombre;
        public TextView jugadores;
        public TextView categoria;
        public ListaViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            jugadores = (TextView) v.findViewById(R.id.elementos);
            categoria = (TextView) v.findViewById(R.id.categoria);
        }
    }

    public EquipoAdapter(Context contexto, Equipos equipos) {
        this.contexto = contexto;
        this.equipos = equipos;
        inflador = (LayoutInflater) contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override public int getItemCount() {
        return equipos.tamanyo();
    }

    @Override public ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.elemento_equipo, viewGroup, false);
        return new ListaViewHolder(v);
    }

    @Override public void onBindViewHolder(ListaViewHolder viewHolder, int i) {
        Resources res = contexto.getResources();
        String categorias[] = res.getStringArray(R.array.tiposCategorias);
        viewHolder.imagen.setImageResource(equipos.elemento(i).getLogo());
        viewHolder.nombre.setText(equipos.elemento(i).getNombre());
        viewHolder.categoria.setText(categorias[equipos.elemento(i).getCategoria()]);
        viewHolder.jugadores.setText("Jugadores: " +String.valueOf(equipos.elemento(i).getJugadores_act()) + " / " +String.valueOf(equipos.elemento(i).getMax_jugadores()));
    }
}
