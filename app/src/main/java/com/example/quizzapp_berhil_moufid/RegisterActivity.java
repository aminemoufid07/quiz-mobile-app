package com.example.quizzapp_berhil_moufid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button signUpButton;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialisation des vues
        usernameEditText = findViewById(R.id.newUsername);
        passwordEditText = findViewById(R.id.newPassword);
        confirmPasswordEditText = findViewById(R.id.confirmPassword);
        signUpButton = findViewById(R.id.signupButton);

        // Initialisation des préférences partagées
        sharedPreferences = getSharedPreferences("user_credentials", Context.MODE_PRIVATE);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
        TextView loginTextView = findViewById(R.id.loginText);
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirection vers la page de connexion (MainActivity)
                goToLoginActivity();
            }
        });
    }
    private void goToLoginActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();  // Cela ferme l'activité d'inscription pour éviter qu'elle soit empilée sur la pile
    }
    private void registerUser() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        // Vérification de la correspondance entre le mot de passe et la confirmation du mot de passe
        if (!password.equals(confirmPassword)) {
            // Affichez un message d'erreur ou effectuez une action appropriée si les mots de passe ne correspondent pas
            return;
        }

        // Enregistrement du nom d'utilisateur et du mot de passe dans SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();

        // Affichez un message de réussite
        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();

        // Redirigez l'utilisateur vers la page de connexion
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();  // Fermez cette activité pour éviter de revenir en arrière
    }

}
