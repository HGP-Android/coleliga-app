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

public class ListaAdapterTorneos extends
    RecyclerView.Adapter <ListaAdapterTorneos.ListaViewHolder> {
        private List<Torneo> items;
        public static class ListaViewHolder extends RecyclerView.ViewHolder {
            // Campos respectivos de un item
            public ImageView imagen;
            public TextView nombre;
            public TextView elementos;
            public ListaViewHolder(View v) {
                super(v);
                imagen = (ImageView) v.findViewById(R.id.imagen);
                nombre = (TextView) v.findViewById(R.id.p);
                elementos = (TextView) v.findViewById(R.id.elementos);
            }
        }
        public ListaAdapterTorneos(List<Torneo> items) {
            this.items = items;
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
        @Override
        public ListaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.elemento_torneo, viewGroup, false);

            /*MaterialRippleLayout.on(inflater.inflate(R.layout.demo_recycler_item, viewGroup, false))
                    .rippleOverlay(true)
                    .rippleAlpha(0.2f)
                    .rippleColor(0xFF585858)
                    .rippleHover(true)
                    .create()
            );*/




            return new ListaViewHolder(v);
        }
        @Override
        public void onBindViewHolder(ListaViewHolder viewHolder, int i) {
            viewHolder.imagen.setImageResource(items.get(i).getImagen());
            viewHolder.nombre.setText(items.get(i).getNombre());
            viewHolder.elementos.setText(String.valueOf(items.get(i).getElementos()));

        }
    }