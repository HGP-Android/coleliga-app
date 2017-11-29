package com.hgp_android.coleliga.partidos;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.hgp_android.coleliga.EquipoAdapter;
import com.hgp_android.coleliga.Equipos;
import com.hgp_android.coleliga.R;


public class PartidoAdapter extends
        RecyclerView.Adapter <PartidoAdapter.ListaViewHolder>   {

    protected PartidoVector partidos;           //Partidos a mostrar
    protected LayoutInflater inflador;          //Crea Layouts a partir del XML
    protected Context contexto;                 //Contexto para el inflador
    protected View.OnClickListener onClickListener;



    public static class ListaViewHolder extends RecyclerView.ViewHolder {

        // Campos para un elemento del cardview de un partido
        public TextView nickname_partido;
        public TextView fecha_partido;
        public TextView jugadores_partido;
        public ListaViewHolder(View v) {
            super(v);
            nickname_partido    = (TextView) v.findViewById(R.id.nickname_partido);
            fecha_partido       = (TextView) v.findViewById(R.id.fecha_partido);
            jugadores_partido   = (TextView) v.findViewById(R.id.jugadores_partido);
        }
    }

    public PartidoAdapter(Context contexto, PartidoVector partidos) {
        this.contexto = contexto;
        this.partidos = partidos;
        inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override public int getItemCount() {
        return this.partidos.tamanyo();
    }

    @Override public PartidoAdapter.ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.elemento_partido, viewGroup, false);
        return new PartidoAdapter.ListaViewHolder(v);
    }

    @Override public void onBindViewHolder(PartidoAdapter.ListaViewHolder viewHolder, int i) {
        viewHolder.nickname_partido.setText(partidos.elemento(i).getNicknamePartido());
        viewHolder.fecha_partido.setText(partidos.elemento(i).getFecha());
        viewHolder.jugadores_partido.setText("Jugadores: " + partidos.elemento(i).getPlayers().size() + " / " + partidos.elemento(i).getMaxPlayers());
    }
}
