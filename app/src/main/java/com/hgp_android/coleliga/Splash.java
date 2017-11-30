package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by AnahiAramayo on 29/11/2017.
 */

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread timerTread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
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