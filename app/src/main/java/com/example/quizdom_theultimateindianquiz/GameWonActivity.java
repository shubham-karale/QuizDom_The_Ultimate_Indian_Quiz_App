package com.example.quizdom_theultimateindianquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class GameWonActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView resultText;

    LinearLayout btnShare;

    int correct;

    int wrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_won);

        circularProgressBar = findViewById(R.id.circularProgressBar);

        resultText = findViewById(R.id.resultText);

        btnShare = findViewById(R.id.btnShare);

        Intent intent = getIntent();

        correct = intent.getIntExtra("correct", 0);

        wrong = intent.getIntExtra("wrong", 0);

        circularProgressBar.setProgress(correct);

        resultText.setText(correct + "/"+ (correct + wrong));

       btnShare.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Intent.ACTION_SEND);
               intent.setType("text/plain");
               String shareBody = "Hey, I have scored " + correct + " correct answers and " + wrong + " wrong answers in the quiz. Can you beat me? Download the app now from https://play.google.com/store/apps/details?id=com.example.quizdom_theultimateindianquiz";
               String shareSub = "Quizdom - The Ultimate Indian Quiz";
               intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
               intent.putExtra(Intent.EXTRA_TEXT, shareBody);
               startActivity(Intent.createChooser(intent, "Share using"));
           }
       });

    }
}