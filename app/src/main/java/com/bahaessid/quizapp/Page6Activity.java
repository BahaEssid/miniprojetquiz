package com.bahaessid.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Page6Activity extends AppCompatActivity {

    private String nomUtilisateur;
    private String themeSelectionne;
    private int currentQuestionIndex;
    private int score;

    // Exemple de données de quiz
    private ArrayList<Question> questions;

    private TextView textViewQuestion;
    private Button buttonOption1, buttonOption2, buttonOption3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        // Récupérer les données de l'intent de l'écran précédent
        Intent intent = getIntent();
        if (intent.hasExtra("nomUtilisateur") && intent.hasExtra("themeSelectionne")) {
            nomUtilisateur = intent.getStringExtra("nomUtilisateur");
            themeSelectionne = intent.getStringExtra("themeSelectionne");
        }

        // Initialiser les données de quiz (à adapter en fonction de votre structure de données)
        initializeQuestions();

        // Initialiser les éléments de l'interface utilisateur
        textViewQuestion = findViewById(R.id.textViewQuestion);
        buttonOption1 = findViewById(R.id.buttonOption1);
        buttonOption2 = findViewById(R.id.buttonOption2);
        buttonOption3 = findViewById(R.id.buttonOption3);

        // Initialiser le score et l'index de la première question
        score = 0;
        currentQuestionIndex = 0;

        // Afficher la première question
        showQuestion();

        // Ajouter un écouteur de clic sur les boutons d'options
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(0); // 0 correspond à l'indice de la première option
            }
        });

        buttonOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1); // 1 correspond à l'indice de la deuxième option
            }
        });

        buttonOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(2); // 2 correspond à l'indice de la troisième option
            }
        });
    }

    // Méthode pour initialiser les questions (à adapter en fonction de votre structure de données)
    private void initializeQuestions() {
        // Exemple : questions = VotreManagerDeQuiz.getQuestions(themeSelectionne);
        // Assurez-vous de remplacer cette ligne par la logique réelle pour récupérer les questions du thème sélectionné.
    }

    // Méthode pour afficher une question
    private void showQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);

            // Mettez à jour le texte de la question et des options
            textViewQuestion.setText(currentQuestion.getQuestion());
            buttonOption1.setText(currentQuestion.getOption1());
            buttonOption2.setText(currentQuestion.getOption2());
            buttonOption3.setText(currentQuestion.getOption3());
        } else {
            // L'utilisateur a répondu à toutes les questions, passez à l'écran suivant
            goToNextScreen();
        }
    }

    // Méthode pour vérifier la réponse de l'utilisateur
    private void checkAnswer(int selectedOptionIndex) {
        Question currentQuestion = questions.get(currentQuestionIndex);

        // Vérifier si la réponse est correcte
        if (selectedOptionIndex == currentQuestion.getCorrectOptionIndex()) {
            score += 5; // Ajouter des points si la réponse est correcte
            Toast.makeText(this, "Bonne réponse !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Mauvaise réponse.", Toast.LENGTH_SHORT).show();
        }

        // Passer à la question suivante
        currentQuestionIndex++;
        showQuestion();
    }

    // Méthode pour passer à l'écran suivant (à adapter en fonction de votre structure de données)
    private void goToNextScreen() {
        Intent intent = new Intent(Page6Activity.this, Page7Activity.class);
        intent.putExtra("nomUtilisateur", nomUtilisateur);
        intent.putExtra("score", score);
        startActivity(intent);
    }
}