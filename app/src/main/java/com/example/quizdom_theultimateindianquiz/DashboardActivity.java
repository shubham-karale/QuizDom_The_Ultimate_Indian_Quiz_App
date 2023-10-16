package com.example.quizdom_theultimateindianquiz;

import static com.example.quizdom_theultimateindianquiz.MainActivity.questionList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue = 50;

    ProgressBar progressBar;

    List<ModelClass> allqueList;

    ModelClass modelClass;

    int position = 0;

    int correctCount = 0;

    int wrongCount = 0;


    //    find the ids of all cards and textView
    TextView queText, option1text, option2text, option3text, option4text;
    CardView queCard, option1Card, option2Card, option3Card, option4Card;

    LinearLayout next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        Create function to find out ids

        findIds();

        allqueList = questionList;


        Collections.shuffle(allqueList);

        modelClass = allqueList.get(position);

        next_btn.setClickable(false);

//        Create Function to set data
        setData();

        countDownTimer = new CountDownTimer(40000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue--;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.dialog_timeout);
                dialog.show();
//                dialog.findViewById(R.id.btn_play_again).setOnClickListener(v -> {
//                    Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    dialog.dismiss();
//                });
                dialog.findViewById(R.id.btn_play_again).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                });
                dialog.show();
            }

        }.start();
    }

    private void findIds() {
        queText = findViewById(R.id.queText);
        option1text = findViewById(R.id.option1text);
        option2text = findViewById(R.id.option2text);
        option3text = findViewById(R.id.option3text);
        option4text = findViewById(R.id.option4text);

        queCard = findViewById(R.id.queCard);
        option1Card = findViewById(R.id.option1Card);
        option2Card = findViewById(R.id.option2Card);
        option3Card = findViewById(R.id.option3Card);
        option4Card = findViewById(R.id.option4Card);

        progressBar = findViewById(R.id.quizTimer);

        next_btn = findViewById(R.id.next_btn);
    }

    private void setData() {
        queText.setText(modelClass.getQuestion());
        option1text.setText(modelClass.getOption1());
        option2text.setText(modelClass.getOption2());
        option3text.setText(modelClass.getOption3());
        option4text.setText(modelClass.getOption4());
    }

    //    Create Methods for correct Answer
    public void correctAns(CardView card) {
        card.setCardBackgroundColor(getResources().getColor(R.color.green));
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                position++;
                modelClass = allqueList.get(position);
                resetColor();
                setData();
            }
        });


    }

    //    Create Methods for wrong answer
    public void wrongAns(CardView card) {
        card.setCardBackgroundColor(getResources().getColor(R.color.red));
        next_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wrongCount++;
                if (position < allqueList.size() - 1) {
                    position++;
                    modelClass = allqueList.get(position);
                    setData();
                    resetColor();
                } else {
                    GameWon();
                }
            }
        });
    }

    public void GameWon() {
        Intent intent = new Intent(DashboardActivity.this, GameWonActivity.class);
        intent.putExtra("correct", correctCount);
        intent.putExtra("wrong", wrongCount);
        startActivity(intent);
    }

//    Enable Buttons to click

    public void enableButton() {
        option1Card.setClickable(true);
        option2Card.setClickable(true);
        option3Card.setClickable(true);
        option4Card.setClickable(true);
    }

    //    Disable Buttons to click
    public void disableButton() {
        option1Card.setClickable(false);
        option2Card.setClickable(false);
        option3Card.setClickable(false);
        option4Card.setClickable(false);

    }

//    Reset the Color
   public void resetColor(){
        option1Card.setCardBackgroundColor(getResources().getColor(R.color.white));
        option2Card.setCardBackgroundColor(getResources().getColor(R.color.white));
        option3Card.setCardBackgroundColor(getResources().getColor(R.color.white));
        option4Card.setCardBackgroundColor(getResources().getColor(R.color.white));
    }

    public void option1Click(View view) {

        next_btn.setClickable(true);
        if (modelClass.getOption1().equals(modelClass.getCorrectOption())) {
            option1Card.setCardBackgroundColor(getResources().getColor(R.color.green));
//            correctAns();
//            disableButton();
            if (position < allqueList.size() - 1) {
//                position++;
//                modelClass = allqueList.get(position);
//                setData();
                correctAns(option1Card);



            } else {
                GameWon();
            }
        } else {
           wrongAns(option1Card);

        }


    }


// Option 2 Clicking
    public void option2Click(View view) {

        next_btn.setClickable(true);
        if (modelClass.getOption2().equals(modelClass.getCorrectOption())) {
            option2Card.setCardBackgroundColor(getResources().getColor(R.color.green));
//            correctAns();
//            disableButton();
            if (position < allqueList.size() - 1) {
//                position++;
//                modelClass = allqueList.get(position);
//                setData();
                correctAns(option2Card);



            } else {
                GameWon();
            }
        } else {
//            option2Card.setCardBackgroundColor(getResources().getColor(R.color.red));
//            wrongAns(option2Card);
            wrongAns(option2Card);


        }


    }


    public void option3Click(View view) {

        next_btn.setClickable(true);
        if (modelClass.getOption3().equals(modelClass.getCorrectOption())) {
            option3Card.setCardBackgroundColor(getResources().getColor(R.color.green));
//            correctAns();
//            disableButton();
            if (position < allqueList.size() - 1) {
//                position++;
//                modelClass = allqueList.get(position);
//                setData();
                correctAns(option3Card);



            } else {
                GameWon();
            }
        } else {
//            option3Card.setCardBackgroundColor(getResources().getColor(R.color.red));
            wrongAns(option3Card);


        }


    }


    public void option4Click(View view) {

        if (modelClass.getOption4().equals(modelClass.getCorrectOption())) {
            option4Card.setCardBackgroundColor(getResources().getColor(R.color.green));
//            correctAns();
//            disableButton();
            if (position < allqueList.size() - 1) {
//                position++;
//                modelClass = allqueList.get(position);
//                setData();
                correctAns(option4Card);



            } else {
                GameWon();
            }
        } else {
//            option4Card.setCardBackgroundColor(getResources().getColor(R.color.red));
            wrongAns(option4Card);


        }


    }


}