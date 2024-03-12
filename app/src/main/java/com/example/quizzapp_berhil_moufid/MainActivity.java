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

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        TextView signupTextView = findViewById(R.id.signupText);
        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirection vers la page d'inscription (RegisterActivity)
                goToRegisterActivity();
            }
        });

        checkIfUserIsRegistered();
    }

    private void loginUser() {
        // Exemple de vérification si l'utilisateur est enregistré
        SharedPreferences sharedPreferences = getSharedPreferences("user_credentials", Context.MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");

        String enteredUsername = username.getText().toString();
        String enteredPassword = password.getText().toString();

//        Log.d("Login", "Entered Username: " + enteredUsername);
//        Log.d("Login", "Entered Password: " + enteredPassword);
//        Log.d("Login", "Saved Username: " + savedUsername);
//        Log.d("Login", "Saved Password: " + savedPassword);

        if (enteredUsername.equals(savedUsername) && enteredPassword.equals(savedPassword)) {
            // Les informations d'identification saisies correspondent à celles enregistrées
            Toast.makeText(MainActivity.this, "Connexion réussie !", Toast.LENGTH_SHORT).show();

            // Redirigez l'utilisateur vers la page principale
            Intent loadingAnimation = new Intent(this, LoadingLoginActivity.class);
            startActivity(loadingAnimation);
            finish();  // Fermez cette activité pour éviter de revenir en arrière
        } else {
            // Affichez un message Toast en cas d'échec d'authentification
            Toast.makeText(MainActivity.this, "Échec de la connexion. Veuillez vérifier vos informations d'identification.", Toast.LENGTH_SHORT).show();
        }
    }



    private void goToRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void checkIfUserIsRegistered() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_credentials", Context.MODE_PRIVATE);

        // Vérifiez si la clé "registered" existe dans les préférences partagées
        boolean isRegistered = sharedPreferences.getBoolean("registered", false);

        if (isRegistered) {
            // L'utilisateur est enregistré, redirigez-le vers la page principale (ou toute autre page après la connexion)
            Intent intent = new Intent(this, QuizActivity.class);  // Remplacez HomeActivity par le nom de votre activité principale
            startActivity(intent);
            finish();  // Fermez cette activité pour éviter de revenir en arrière
        } else {
            // L'utilisateur n'est pas enregistré, laissez-le sur la page d'inscription
        }
    }
}
