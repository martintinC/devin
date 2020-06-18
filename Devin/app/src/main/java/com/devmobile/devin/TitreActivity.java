package com.devmobile.devin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;


//Cette classe gere la page d'acceuil
public class TitreActivity extends Activity {

    protected int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //affiche le layout activity_titre
        setContentView(R.layout.activity_titre);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //affiche le layout activity_titre
        setContentView(R.layout.activity_titre);
    }


    //appelé lors du clic sur le bouton jouer
    public void jouer(View v) {
        Intent intent=new Intent(this,JeuActivity.class);

        //on recupere le score courant dans les sharedPreferences, 0 si "scoreacourant" n'existe pas
        SharedPreferences settings = getSharedPreferences("PREFS",0);
        score = settings.getInt("scoreCourant",0);

        //ajout du score à l'intent
        intent.putExtra("score", score);
        //demarage de l'activité suivante : JeuActivity
        startActivity(intent);
    }

    //appelé lors du clic sur le bouton statistiques
    public void stats(View v) {
        //dirige vers l'activité StatsActivity
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }
}
