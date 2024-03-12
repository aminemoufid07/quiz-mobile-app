package com.example.quizzapp_berhil_moufid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoadingResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loading_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // Add a delay of 3 seconds before redirecting to the quiz page
            Handler handler = new Handler();
            handler.postDelayed(() -> redirectToResultPage(), 3000); // 3000 milliseconds (3 seconds)

            return insets;
        });
    }

    private void redirectToResultPage() {
        Intent intent = new Intent(this, ResultActivity.class);
        // Add any necessary extras or data to the intent
        startActivity(intent);
        finish(); // Close the current activity if necessary
    }
}
