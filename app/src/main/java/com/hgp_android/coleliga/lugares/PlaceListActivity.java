package com.hgp_android.coleliga.lugares;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.hgp_android.coleliga.R;

import java.util.ArrayList;

public class PlaceListActivity extends AppCompatActivity {

    private ArrayList<Place> places = new ArrayList<Place>();

    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);


        //Generamos los lugares
        generatePlaces();

        //InitiField
        initField();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvPlacesList);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        PlaceAdapter adapter = new PlaceAdapter(places);
        recyclerView.setAdapter(adapter);

    }

    private void initField(){

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fabAddPlaces);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), PlaceAddActivity.class);
                startActivity(intent);
            }
        });


    }

    private void generatePlaces(){

        try{
            Place place = getIntent().getExtras().getParcelable("PLACE");
            places.add(place);
        } catch (Exception e) {

        }


        places.add(new Place("Instalaciones deportivas Max", R.drawable.imagen_147, "Calle solidaridad, 9. 28760, Gijón", "de 9:00H a 22:00H. Horario ininterrumpido", "Instalaciones deportivas con la última tecnología"));
        places.add(new Place("Pistas Carlos", R.drawable.futbol_1, "Calle de la carreta, 14. 14398, Alto del hierro", "de 9:00H a 14:00H. Solo mañanas", "Tranquilidad y buen ambiente"));
        places.add(new Place("Canchas Anahí", R.drawable.image_gallery, "Polígono indunstrial el cante, Parcela 7. 74512, Cadiz", "de 9:00H a 13:00H. de 15:00H - 21:00H", "Sitio inmejorable. Fácil acceso y con aparcamiento privado."));
        places.add(new Place("Polideportivo Paco", R.drawable.instalaciones_deportivas_2, "Calle la orotava, 32 . 48963, El peñon", "de 9:00H a 22:00H. Horario ininterrumpido", "Instalaciones oficiales"));
    }
}
