package com.devmobile.devin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;


//Cette classe gere l'ecran de jeu
public class JeuActivity extends Activity {

    protected int nb_aleatoire;
    protected int score;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //affiche le layout activity_jeu
        setContentView(R.layout.activity_jeu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //affiche le layout activity_jeu
        setContentView(R.layout.activity_jeu);

        //on tire un nombre aleatoire entre 1 et 4
        nb_aleatoire = 1 + (int)(Math.random()*((4-1)+1));

        Intent intent = getIntent();
        //on recupere le score courant
        if(intent != null) {
            score = 0;
            score = intent.getIntExtra("score", 0);
        }
    }

    //Les 4 boutons suivants fonctionnent de la meme maniere :
    //On envoie le nombre choisit, le nombre aleatoire et le score actuel à l'activité suivante : FinActivity
    public void bouton1(View v) {
        Intent intent=new Intent(this,FinActivity.class);
        intent.putExtra("nombre", 1);
        intent.putExtra("nb_aleatoire", nb_aleatoire);
        intent.putExtra("score", score);
        startActivity(intent);
    }

    public void bouton2(View v) {
        Intent intent=new Intent(this,FinActivity.class);
        intent.putExtra("nombre", 2);
        intent.putExtra("nb_aleatoire", nb_aleatoire);
        intent.putExtra("score", score);
        startActivity(intent);
    }

    public void bouton3(View v) {
        Intent intent=new Intent(this,FinActivity.class);
        intent.putExtra("nombre", 3);
        intent.putExtra("nb_aleatoire", nb_aleatoire);
        intent.putExtra("score", score);
        startActivity(intent);
    }

    public void bouton4(View v) {
        Intent intent=new Intent(this,FinActivity.class);
        intent.putExtra("nombre", 4);
        intent.putExtra("nb_aleatoire", nb_aleatoire);
        intent.putExtra("score", score);
        startActivity(intent);
    }

}
