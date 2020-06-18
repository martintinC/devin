package com.devmobile.devin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


//Cette classe gere la page de statistiques
public class StatsActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        //on recupere toutes les valeurs suivantes dans les sharedPreferences
        SharedPreferences settings = getSharedPreferences("PREFS",0);
        int score_courant = settings.getInt("scoreCourant",0);
        int meilleur_score = settings.getInt("best_score",0);
        int pire_score = settings.getInt("worst_score",0);
        int jeux_gagne = settings.getInt("jeux_gagne",0);
        int jeux_perdu = settings.getInt("jeux_perdu",0);
        long worst_date = settings.getLong("worst_date", new Date().getTime());
        long best_date = settings.getLong("best_date", new Date().getTime());

        //definition d'un format de date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");


        //modification des textViews pour afficher les données récupérées precedement
        TextView textView = (findViewById(R.id.score_actuel));
        //textView.setText("Score actuel : " + score_courant);
        textView.setText(getString(R.string.score_actuel) + " " + score_courant);

        TextView textView2 = (findViewById(R.id.score_max));
        //textView2.setText("Score max : " + meilleur_score + " le " + format.format(best_date));
        textView2.setText(getString(R.string.score_max) + " " + meilleur_score + " " + getString(R.string.le) + " " + format.format(best_date));

        TextView textView3 = (findViewById(R.id.score_min));
        //textView3.setText("Score min : " + pire_score + " le " + format.format(worst_date));
        textView3.setText(getString(R.string.score_min) + " " + pire_score + " " + getString(R.string.le) + " " + format.format(worst_date));

        TextView textView4 = (findViewById(R.id.jeux_gagne));
        //textView4.setText("Jeux gagnés : " + jeux_gagne);
        textView4.setText(getString(R.string.jeux_gagn_s) + " " + jeux_gagne);

        TextView textView5 = (findViewById(R.id.jeux_perdu));
        //textView5.setText("Jeux perdus : " + jeux_perdu);
        textView5.setText(getString(R.string.jeux_perdus) + " " + jeux_perdu);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    //appelé lors du clic sur le bouton retour
    public void menu(View v) {
        //lance l'activité TitreActivity
        Intent intent=new Intent(this,TitreActivity.class);
        startActivity(intent);
    }

}
