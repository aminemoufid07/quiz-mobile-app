package com.example.quizzapp_berhil_moufid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private int correctAnswers = 0;
    private int totalQuestions = 0;
    private ImageView resultImage;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Log.d("ResultActivity", "Correct Answers: " + correctAnswers);
        Log.d("ResultActivity", "Total Questions: " + totalQuestions);

        resultImage = findViewById(R.id.result_image);
        resultText = findViewById(R.id.result_text);

        Intent intent = getIntent();
        if (intent != null) {
            correctAnswers = intent.getIntExtra("correctAnswers", 0);
            totalQuestions = intent.getIntExtra("totalQuestions", 1);
        }

        displayResults();
    }

    private void displayResults() {
        float percentage = ((float) correctAnswers / totalQuestions) * 100;

        // Affichage de l'image et du texte en fonction du pourcentage
        if (percentage >= 0 && percentage < 20) {
            resultImage.setImageResource(R.drawable.badscore);
            resultText.setText("Votre résultat est malheureusement très bas");
        } else if (percentage >= 20 && percentage < 50) {
            resultImage.setImageResource(R.drawable.mediumscore);
            resultText.setText("Votre résultat est assez médiocre");
        } else if (percentage >= 50 && percentage < 70) {
            resultImage.setImageResource(R.drawable.goodscore);
            resultText.setText("Votre résultat est assez bon");
        } else if (percentage >= 70 && percentage <= 100) {
            resultImage.setImageResource(R.drawable.perfectscore);
            resultText.setText("Excellent resultat");
        }
    }
}
