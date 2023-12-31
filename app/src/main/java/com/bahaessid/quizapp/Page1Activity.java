package com.bahaessid.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Page1Activity extends AppCompatActivity {
    // Déclaration des éléments de l'interface utilisateur
    private EditText editTextNom;
    private Button buttonSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        // Initialisation des éléments de l'interface utilisateur
        editTextNom = findViewById(R.id.editTextNom);
        buttonSuivant = findViewById(R.id.buttonSuivant);

        // Ajout d'un écouteur de clic sur le bouton "Suivant"
        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération du nom saisi par l'utilisateur
                String nomUtilisateur = editTextNom.getText().toString();

                // Passage à l'écran suivant en envoyant le nom en extra
                Intent intent = new Intent(Page1Activity.this, Page2Activity.class);
                intent.putExtra("nomUtilisateur", nomUtilisateur);
                startActivity(intent);
            }
        });
    }
}