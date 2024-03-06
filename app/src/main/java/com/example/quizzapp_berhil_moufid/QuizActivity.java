package com.example.quizzapp_berhil_moufid;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class QuizActivity extends AppCompatActivity {

    private Questions mQuestions = new Questions();
    private int mCorrectAnswers = 0;
    private int mQuestionNumber = 0;
    private TextView mQuizNumTextView;
    private TextView mQuestionTextView;
    private ImageView mQuizImageView;
    private EditText mInputEditText;
    private Button mSubmitButton;
    private String mCurrentFullLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = findViewById(R.id.question_textview);
        mQuizImageView = findViewById(R.id.quiz_image);
        mInputEditText = findViewById(R.id.inputEditText);
        mSubmitButton = findViewById(R.id.button_submit);
        mQuizNumTextView = findViewById(R.id.quiznum_textView);

        updateQuestion();

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void updateQuestionNumberText() {
        int totalQuestions = mQuestions.getLength();
        int currentQuestionNumber = mQuestionNumber + 1;
        mQuizNumTextView.setText(getString(R.string.quiz_number_format, currentQuestionNumber, totalQuestions));
    }

    private void updateQuestion() {
        mQuestionTextView.setText(mQuestions.getQuestion(mQuestionNumber));
        mQuizImageView.setImageResource(getResources().getIdentifier(
                mQuestions.getImage(mQuestionNumber), "drawable", getPackageName()));
        updateQuestionNumberText();
    }

    private void checkAnswer() {
        String userAnswer = mInputEditText.getText().toString().trim();
        String correctAnswer = mQuestions.getCorrectAnswer(mQuestionNumber);

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            showToastWithAnimation("Correct!");
            mCorrectAnswers++;

            // Set the full logo with animation
            setFullLogoWithAnimation();
        } else {
            showToast("Incorrect! La bonne réponse est : " + correctAnswer);
        }

        if (mQuestionNumber + 1 < mQuestions.getLength()) {
            mQuestionNumber++;
            updateQuestion();
        } else {
            showToast("Quiz terminé!");
            Intent resultIntent = new Intent(QuizActivity.this, ResultActivity.class);
            resultIntent.putExtra("correctAnswers", mCorrectAnswers);
            resultIntent.putExtra("totalQuestions", mQuestions.getLength());
            startActivity(resultIntent);
            finish();
        }

        mInputEditText.getText().clear();
    }
    private void setFullLogoWithAnimation() {
        // Load animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.correct_animation);

        // Stocke le nom du logo complet dans la variable mCurrentFullLogo
        mCurrentFullLogo = mQuestions.getImageFull(mQuestionNumber);

        // Set the full logo with animation
        mQuizImageView.setImageResource(getResources().getIdentifier(
                mCurrentFullLogo, "drawable", getPackageName()));
        mQuizImageView.startAnimation(animation);

        // Afficher un toast personnalisé avec le logo complet
        showToastWithFullLogo("Correct!");
    }


    private void showToastWithFullLogo(String message) {
        // Load animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.correct_animation);

        // Create a custom toast with animation
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        ImageView logoImageView = layout.findViewById(R.id.logo_image);
        logoImageView.setImageResource(getResources().getIdentifier(
                mQuestions.getImageFull(mQuestionNumber), "drawable", getPackageName()));
        logoImageView.startAnimation(animation);

        TextView text = layout.findViewById(R.id.text);
        text.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showToastWithAnimation(String message) {
        // Load animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.correct_animation);

        // Create a custom toast with animation
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = layout.findViewById(R.id.text);
        text.setText(message);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}

