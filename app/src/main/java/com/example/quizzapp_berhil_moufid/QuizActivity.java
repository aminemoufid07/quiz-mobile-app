package com.example.quizzapp_berhil_moufid;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private ImageView mQuizImage;
    private String mAnswer;
    private int mScore = 0;
    private int mQuizNum = 1;
    private int QuestionNum = 0;
    private TextView mQuizNumView;
    private TextView mQuestionView;
    private Questions mQuestions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionView = findViewById(R.id.question_textview);
        mQuizNumView = findViewById(R.id.quiznum_textView);

        updateQuestions();

        Button submit = findViewById(R.id.button_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mQuestions.getType(QuestionNum) == "radiobutton"){

                    if(mQuestions.getCorrectAnswers(QuestionNum).equals(mAnswer)){

                        mScore++ ;
                        displayToastCorrectAnswer();
                    }else {
                        displayToastWrongAnswer();
                    }
                }
                SystemClock.sleep(1000);

                if(QuestionNum == mQuestions.getLength() -1){
                    //Result Activity

                    QuestionNum = 0;
                    mQuizNum = 0;
                    mScore = 0;

                }else {
                    QuestionNum++ ;
                    mQuizNum++ ;
                }

                updateQuestions();

            }
        });

    }

    private void displayToastCorrectAnswer(){
        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
    }

    private void displayToastWrongAnswer(){
        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
    }

    private void updateQuestions(){

        LinearLayout answer_layout = findViewById(R.id.answers_layout);
        answer_layout.removeAllViews();
        mAnswer="";

        mQuizNumView.setText(mQuizNum + "/" + String.valueOf(mQuestions.getLength()));
        mQuestionView.setText(mQuestions.getQuestions(QuestionNum));
        if(mQuestions.getType(QuestionNum) == "radiobutton"){

            showRadioButtonAnswers(QuestionNum);
        }

        showMainImage();

        ScrollView sv = findViewById(R.id.scrollView);
        sv.smoothScrollTo(0, 0);

    }

    private void showMainImage(){

        mQuizImage = findViewById(R.id.quiz_image);

        String img = mQuestions.getImages(QuestionNum);

        mQuizImage.setImageResource(getResources().getIdentifier(img, "drawable", getPackageName()));

    }

    private void showRadioButtonAnswers(int qnum){

        final LinearLayout answerLayout = findViewById(R.id.answers_layout);
        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(RadioGroup.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        rg.setLayoutParams(lp);
        rg.setPadding(90,0,0,0);

        final RadioButton[] rb1 = new RadioButton[3];

        for(int i =0; i<=2; i++){
            rb1[i] = new RadioButton(this);
            rb1[i].setText(mQuestions.getChoice(qnum) [i]);
            rb1[i].setTextColor(Color.BLACK);
            rb1[i].setPadding(8,16,8,16);
            rb1[i].setTextSize(26);
            rb1[i].setId(i);
            rb1[i].setWidth(600);

            rg.addView(rb1[i]);

        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int Id) {

                mAnswer = mQuestions.getChoice(QuestionNum)[Id];

            }
        });
        answerLayout.addView(rg);
    }


}


