package com.example.quizzapp_berhil_moufid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private Button click;
    private ProgressBar progressBar;
    private int correctAnswers = 0;
    private int totalQuestions = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
// Dans ResultActivity.onCreate()
        Log.d("ResultActivity", "Correct Answers: " + correctAnswers);
        Log.d("ResultActivity", "Total Questions: " + totalQuestions);

        click = findViewById(R.id.btn_click);
        progressBar = findViewById(R.id.progress_bar);

        Intent intent = getIntent();
        if (intent != null) {
            correctAnswers = intent.getIntExtra("correctAnswers", 0);
            totalQuestions = intent.getIntExtra("totalQuestions", 1);
        }

        // Utilisez correctAnswers comme nécessaire dans votre activité
        // ...

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayResultsInProgressBar();
            }
        });
    }


    private void displayResultsInProgressBar() {
        float percentage = ((float) correctAnswers / totalQuestions) * 100;
        progressBar.setProgress(Math.round(percentage));
        click.setClickable(false);
    }

}
