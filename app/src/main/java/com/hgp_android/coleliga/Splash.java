package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.google.android.gms.ads.MobileAds;

/**
 * Created by AnahiAramayo on 29/11/2017.
 */

public class Splash extends AppCompatActivity {
    LinearLayout l1, l2;
    Animation arriba_abajo, abajo_arriba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        l1= (LinearLayout) findViewById(R.id.l1);
        l2= (LinearLayout) findViewById(R.id.l2);

        arriba_abajo = AnimationUtils.loadAnimation(this,R.anim.arriba_abajo);
        l1.setAnimation(arriba_abajo);
        abajo_arriba = AnimationUtils.loadAnimation(this,R.anim.abajo_arriba);
        l2.setAnimation(abajo_arriba);

        Thread timerTread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Splash.this, RegistroActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerTread.start();

    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}