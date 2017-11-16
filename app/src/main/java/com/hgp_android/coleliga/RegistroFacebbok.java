package com.hgp_android.coleliga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegistroFacebbok extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_facebook);
    }

    public void signIn(View view)
    {
        Intent i = new Intent(this,RegistroFacebookSignIn.class);
        startActivity(i);
    }

}
