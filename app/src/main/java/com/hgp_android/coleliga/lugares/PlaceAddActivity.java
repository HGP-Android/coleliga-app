package com.hgp_android.coleliga.lugares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hgp_android.coleliga.R;

public class PlaceAddActivity extends AppCompatActivity {

    private Button btnCreatePlace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_add);

        btnCreatePlace = (Button) findViewById(R.id.btnSendPlaceAdd);

        final Place place = new Place("sitio 1", R.drawable.instalaciones_deportivas_2, "direccion", "horario todo el rato", "esto es la descricuon");

        btnCreatePlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), PlaceListActivity.class);
                intent.putExtra("PLACE", place);
                startActivity(intent);
                finish();
            }
        });

    }

}
