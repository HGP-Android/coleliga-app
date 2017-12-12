package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.hgp_android.coleliga.lugares.PlaceListActivity;
import com.hgp_android.coleliga.partidos.PartidosActivity;

public class PrincipalActivity extends AppCompatActivity {
    private AdView adView;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobileAds.initialize(this,"ca-app-pub-3405615265490445~2278870838");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        CardView equipoCard = (CardView) findViewById(R.id.equiposCard);
        equipoCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarEquipos(view);
            }
        });
        CardView entrenamientoCard = (CardView) findViewById(R.id.entrenamientosCard);
        entrenamientoCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarEntrenamientos(view);
            }
        });
        CardView partidoCard = (CardView) findViewById(R.id.partidosCard);
        partidoCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarPartidos(view);
            }
        });
        CardView resultadosCard = (CardView) findViewById(R.id.resultadosCard);
        resultadosCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarResultados(view);
            }
        });
        CardView clasificacionCard = (CardView) findViewById(R.id.clasificacionCard);
        clasificacionCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarClasificaciones(view);
            }
        });
        CardView lugaresCard = (CardView) findViewById(R.id.lugaresCard);
        lugaresCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarLugares(view);
            }
        });
        CardView perfilCard = (CardView) findViewById(R.id.perfilesCard);
        perfilCard.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                lanzarPerfil(view);
            }
        });

        CardView shareCardview = (CardView) findViewById(R.id.shareApp);
        shareCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "Coleliga: App para crear torneos. ";
                shareAppText(text +
                        "Puedes descargarla en : http://play.google.com/store/apps/details?id="+
                        getPackageName());
            }
        });

        //Lanzamiento anuncio banner
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("9796B949D295ECF0BE1E8A93DE8C3095").build();
        adView.loadAd(adRequest);
        //Lanzamiento anuncio intersticial
        interstitialAd = new InterstitialAd(this); interstitialAd.setAdUnitId("ca-app-pub-9661377198510780/3437897421");
        interstitialAd.loadAd(new AdRequest.Builder().addTestDevice( "9796B949D295ECF0BE1E8A93DE8C3095").build());

        interstitialAd.setAdListener(new AdListener() {
            @Override public void onAdClosed() {
                interstitialAd.loadAd(new AdRequest.Builder()
                        .addTestDevice("9796B949D295ECF0BE1E8A93DE8C3095").build());
                Intent i = new Intent(PrincipalActivity.this, EquiposActivity.class);
                startActivity(i);
            } });
    }
    void lanzarEquipos(View view){
         if (interstitialAd.isLoaded()) {
             interstitialAd.show();
         } else {
                Toast.makeText(PrincipalActivity.this, "El Anuncio no esta disponible aun", Toast.LENGTH_LONG).show();
             Intent i = new Intent(PrincipalActivity.this, EquiposActivity.class);
             startActivity(i);
         }


    }
    void lanzarEntrenamientos(View view){
        Toast.makeText(this,"Entrenamiento",Toast.LENGTH_SHORT).show();
    }
    void lanzarPartidos(View view){
        Intent i = new Intent(this,
                PartidosActivity.class);
        startActivity(i);
        Toast.makeText(this,"Partido",Toast.LENGTH_SHORT).show();

    }
    void lanzarResultados(View view){
        Toast.makeText(this,"Resultado",Toast.LENGTH_SHORT).show();
    }
    void lanzarClasificaciones(View view){
        Intent i = new Intent(this,
                ListasTorneos.class);
        startActivity(i);
    }
    void lanzarLugares(View view){
        Toast.makeText(this,"Lugares",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,
                PlaceListActivity.class);
        startActivity(i);
    }
    void lanzarPerfil(View view){
        Toast.makeText(this,"Perfil",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,
                RegistroFull.class);
        startActivity(i);
    }

    void shareAppText(String text) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(i, "Selecciona aplicación"));
    }

}
