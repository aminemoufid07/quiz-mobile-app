package com.example.quizzapp_berhil_moufid;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activer le traitement des bords
        EdgeToEdge.enable(this);

        // Définir le contenu de l'activité
        setContentView(R.layout.activity_splash);

        // Obtenir la référence de l'animation Lottie
        LottieAnimationView anim = findViewById(R.id.loadingapp);

        // Ajouter un écouteur d'événements pour l'animation Lottie
        anim.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // Laisser vide
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // Démarrer l'activité principale après la fin de l'animation
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                // Laisser vide
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // Laisser vide
            }
        });

        // Configurer l'animation pour qu'elle ne se répète pas
        anim.setRepeatCount(0);

        // Utiliser un gestionnaire pour retarder l'affichage de l'animation
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Rendre la vue visible et démarrer l'animation
                anim.setVisibility(View.VISIBLE);
                anim.playAnimation();
            }
        }, 3000); // Assurez-vous d'ajuster la durée de retard en fonction de votre animation Lottie
    }
}
