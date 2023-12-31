package com.bahaessid.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Page7Activity extends AppCompatActivity {

    private String nomUtilisateur;
    private int score;

    private TextView textViewResult;
    private Button buttonRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7);

        // Récupérer les données de l'intent de l'écran précédent
        Intent intent = getIntent();
        if (intent.hasExtra("nomUtilisateur") && intent.hasExtra("score")) {
            nomUtilisateur = intent.getStringExtra("nomUtilisateur");
            score = intent.getIntExtra("score", 0);
        }

        // Initialiser les éléments de l'interface utilisateur
        textViewResult = findViewById(R.id.textViewResult);
        buttonRetour = findViewById(R.id.buttonRetour);

        // Construire la chaîne de résultat
        String resultText = "Bonjour " + nomUtilisateur + "! Votre score est : " + score;

        // Afficher le résultat
        textViewResult.setText(resultText);

        // Changer la couleur du texte en fonction du score
        if (score >= 10) {
            textViewResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            textViewResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }

        // Ajouter un écouteur de clic sur le bouton "Retour"
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retourner à l'écran des thèmes ou à l'écran initial selon votre logique
                // Exemple : Intent retourIntent = new Intent(Page7Activity.this, Page2Activity.class);
                // startActivity(retourIntent);
            }
        });
    }
}