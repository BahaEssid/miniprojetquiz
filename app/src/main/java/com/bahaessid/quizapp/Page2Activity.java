package com.bahaessid.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class Page2Activity extends AppCompatActivity {

    private String nomUtilisateur;
    private RecyclerView recyclerViewThemes;
    private ThemeAdapter themeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        // Récupérer le nom d'utilisateur de l'intent de l'écran précédent
        Intent intent = getIntent();
        if (intent.hasExtra("nomUtilisateur")) {
            nomUtilisateur = intent.getStringExtra("nomUtilisateur");
        }

        // Initialiser la RecyclerView des thèmes
        recyclerViewThemes = findViewById(R.id.recyclerViewThemes);
        recyclerViewThemes.setLayoutManager(new LinearLayoutManager(this));

        // les données de thèmes
        ArrayList<String> themesList = new ArrayList<>(Arrays.asList("Histoire", "Géographie", "Sport", "Politique"));

        // Adapter pour la RecyclerView
        themeAdapter = new ThemeAdapter(themesList, new ThemeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String themeSelectionne) {
                // Passer à la Page correspondante en fonction du thème
                Intent intent = null;
                switch (themeSelectionne) {
                    case "Histoire":
                        intent = new Intent(Page2Activity.this, Page3Activity.class);
                        break;
                    case "Géographie":
                        intent = new Intent(Page2Activity.this, Page4Activity.class);
                        break;
                    case "Sport":
                        intent = new Intent(Page2Activity.this, Page5Activity.class);
                        break;
                    case "Politique":
                        intent = new Intent(Page2Activity.this, Page6Activity.class);
                        break;

                }

                if (intent != null) {
                    intent.putExtra("nomUtilisateur", nomUtilisateur);
                    startActivity(intent);
                }
            }
        });
        recyclerViewThemes.setAdapter(themeAdapter);
    }
}