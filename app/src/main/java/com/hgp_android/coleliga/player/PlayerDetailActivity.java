package com.hgp_android.coleliga.player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.hgp_android.coleliga.R;

public class PlayerDetailActivity extends AppCompatActivity {

    private TextView tvPlayerName;
    private TextView tvPlayerNickName;
    private TextView tvPlayerBirthDate;
    private TextView tvPlayerPosition;
    private TextView tvPlayerCountry;
    private TextView tvPlayerCity;
    private ImageView tvPlayerImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);


        //tvPlayerName = (TextView) findViewById(R.id.tvPlayerName);

        initField();

        String player_name = (String) getIntent().getExtras().getSerializable("player_name");
        String player_nickname = (String) getIntent().getExtras().getSerializable("player_nickname");
        String player_birthdate = (String) getIntent().getExtras().getSerializable("player_birthdate");
        String player_position = (String) getIntent().getExtras().getSerializable("player_position");
        String player_country = (String) getIntent().getExtras().getSerializable("player_country");
        String player_city = (String) getIntent().getExtras().getSerializable("player_city");
        int player_img = (int) getIntent().getExtras().getSerializable("player_image");

        tvPlayerName.setText(player_name);
        tvPlayerNickName.setText(player_nickname);
        tvPlayerBirthDate.setText(player_birthdate);
        tvPlayerPosition.setText(player_position);
        tvPlayerCountry.setText(player_country + " /");
        tvPlayerCity.setText(player_city);
        tvPlayerImg.setImageResource(player_img);


    }



    private void initField(){

        tvPlayerName = (TextView) findViewById(R.id.tvPlayerName);
        tvPlayerNickName = (TextView) findViewById(R.id.tvPlayerNickName);
        tvPlayerBirthDate = (TextView) findViewById(R.id.tvPlayerBirthDate);
        tvPlayerCity = (TextView) findViewById(R.id.tvPlayerCity);
        tvPlayerCountry = (TextView) findViewById(R.id.tvPlayerCountry);
        tvPlayerPosition = (TextView) findViewById(R.id.tvPlayerPosition);
        tvPlayerImg = (ImageView) findViewById(R.id.tvPlayerImage);
    }
}
