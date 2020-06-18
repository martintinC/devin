package com.devmobile.devin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;


//Cette classe gere la fin des parties
public class FinActivity extends Activity {

    protected int score = 0;
    protected int nombre = 0;
    protected int nb_aleatoire = 0;
    protected boolean gagne = false;
    protected boolean perdu = false;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //on affiche le layout activity_fin
        setContentView(R.layout.activity_fin);

        SharedPreferences settings = getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor = settings.edit();

        Intent intent = getIntent();
        if(intent != null){
            //on recupere les trois variables suivantes transmises par JauActivity
            nombre = intent.getIntExtra("nombre",0);
            nb_aleatoire = intent.getIntExtra("nb_aleatoire", 0);
            score = intent.getIntExtra("score", 0);

            //modification des textViews du layout pour afficher les variables
            TextView textView = (findViewById(R.id.nb_user));
            textView.setText(getString(R.string.nombre_selectionn) + " " + nombre);

            TextView textView2 = (findViewById(R.id.nb_al));
            textView2.setText(getString(R.string.nombre_deviner) + " " + nb_aleatoire);

            ImageView imageView = (findViewById(R.id.imgFin));
            TextView textView3 = (findViewById(R.id.score));

            //si le nombre choisit est egal au nombre aleatoire, on ajoute 3 à score et on passe gagne à tru
            if(nombre == nb_aleatoire){
                imageView.setImageResource(R.drawable.gagne);
                score += 3;
                gagne = true;
                textView3.setText(getString(R.string.score) + " " + score);
                //Sinon score - 1 et perdu à true
            }else{
                imageView.setImageResource(R.drawable.perdu);
                score -= 1;
                perdu = true;
                textView3.setText(getString(R.string.score) + " " + score);
            }

            //appele de la fonction update data expliquee plus bas
            updateData(score, gagne, perdu);

            gagne = false;
            perdu = false;

            //mise a jour des sharedPreferences
            editor.putInt("scoreCourant", score);
            editor.commit();

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    //appelé lors du clic sur le bouton rejouer
    public void rejouer(View v) {
        Intent intent=new Intent(this,JeuActivity.class);
        //On transmet le score à l'activité suivante : JeuActivity
        intent.putExtra("score", score);
        startActivity(intent);
    }

    //appelé lors du clic sur le bouton menu
    public void menu(View v) {
        //on lance l'activity TitreActivity
        Intent intent=new Intent(this,TitreActivity.class);
        startActivity(intent);
    }

    //fonction pour la mise à jour des sharedPreferences
    public void updateData(int score, boolean gagne, boolean perdu){

        //on recupere les valeurs dans les sharedPreferences
        SharedPreferences settings = getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor = settings.edit();
        int meilleur_score = settings.getInt("best_score",0);
        int pire_score = settings.getInt("worst_score",0);
        int jeux_gagne = settings.getInt("jeux_gagne",0);
        int jeux_perdu = settings.getInt("jeux_perdu",0);
        Date currentDate = new Date();

        //Si le score courant est plus grand que le meilleur score, on met a jour le meilleur score dans les sharedPreferences
        if(score > meilleur_score){
            editor.putInt("best_score", score);
            editor.putLong("best_date", currentDate.getTime());
        }

        //Si le score courant est plus petit que le pire score, on met a jour le pire score dans les sharedPreferences
        if(score < pire_score){
            editor.putInt("worst_score", score);
            editor.putLong("worst_date", currentDate.getTime());
        }

        //si le jeu est gagne, on incremente jeux_gagne dans les sharedPreferences
        if(gagne){
            editor.putInt("jeux_gagne", jeux_gagne + 1);
        }

        //si le jeu est perdu, on incremente jeux_perdu dans les sharedPreferences
        if(perdu){
            editor.putInt("jeux_perdu", jeux_perdu + 1);
        }

        editor.commit();
    }

}
