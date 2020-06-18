package com.devmobile.devin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//Cette classe gere le splashscreen au lancement de l'application

public class SplashScreen extends Activity {

    //temps d'affichage de l'ecran (2 secondes)
    private static int SPLASH_TIME_OUT = 2000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //affiche le layout activity_splash
        setContentView(R.layout.activity_splash);

        //au bout de deux secondes, on passe a l'activité TitreActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, TitreActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
