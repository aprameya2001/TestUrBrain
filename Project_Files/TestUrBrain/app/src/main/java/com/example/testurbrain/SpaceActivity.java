package com.example.testurbrain;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SpaceActivity extends AppCompatActivity {

    TextView tvNumber, tvQuestion, tvScore;
    Button btnSubmit, btnQuit;
    RadioGroup answersgrp;
    RadioButton rb1, rb2, rb3, rb4;
    ActionBar actionBar;

    String[] questions = {
            "Which of the following phenomena cannot be observed on the surface of the Moon?",
            "Which of the following planets has a revolution time which is shorter than its rotation time?",
            "Which planet looks reddish in the night sky?",
            "Which female astronaut spent the maximum time in space?",
            "Which planet has the fastest revolution time?",
            "An astronaut in outer space will observe the sky as ",
            "Which of the following planets rotates in a direction opposite to the direction of earth's rotation?",
            "What is the average distance (approximate) between the Sun and the Earth?",
            "NASA's Deep Impact space mission was employed to take detailed pictures of which comet nucleus?",
            "Which of the following planets has a lesser rotation time than the Earth?"
    };
    String[] answers = {"Twinkling of stars","Venus","Mars","Sunita Williams","Mercury","Black","Venus","150 million km","Tempel 1","Jupiter"};
    String[] opt = {
            "Rising and setting of the Sun","Solar eclipse","Motion of comets","Twinkling of stars",
            "Jupiter","Venus","Mars","Uranus",
            "Jupiter","Venus","Mars","Mercury",
            "Lisa Norwak","Kalpana Chawla","Sunita Williams","None of these",
            "Mercury","Uranus","Neptune","Jupiter",
            "White","Black","Blue","Red",
            "Mars","Jupiter","Venus","Mercury",
            "70 million km","100 million km","110 million km","150 million km",
            "Halley's Comet","Hale-Bopp","Hyakutake","Tempel 1",
            "Jupiter","Mars","Mercury","Venus"
    };

    String statement;

    int flag=0;
    int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Space and Technology");

        tvNumber = findViewById(R.id.tvNumber);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvScore = findViewById(R.id.tvScore);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnQuit = findViewById(R.id.btnQuit);
        answersgrp = findViewById(R.id.answersgrp);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        statement = "Question "+ (flag + 1);

        tvNumber.setText(statement);
        tvQuestion.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        tvScore.setText("Score: 0");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answersgrp.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton rbSelected = findViewById(answersgrp.getCheckedRadioButtonId());

                    String ansText = rbSelected.getText().toString();

                    if(ansText.equals(answers[flag])) {
                        correct++;
                        Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        wrong++;
                        Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    }

                    flag++;

                    if (tvScore != null)
                        tvScore.setText("Score: "+correct);

                    if(flag<questions.length)
                    {
                        statement = "Question "+ (flag + 1);

                        tvNumber.setText(statement);
                        tvQuestion.setText(questions[flag]);
                        rb1.setText(opt[flag*4]);
                        rb2.setText(opt[flag*4 +1]);
                        rb3.setText(opt[flag*4 +2]);
                        rb4.setText(opt[flag*4 +3]);
                    }
                    else
                    {
                        marks=correct;
                        Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                        intent.putExtra("correct", correct);
                        intent.putExtra("wrong", wrong);
                        Log.d("CHECK", correct + " " + wrong);
                        startActivity(intent);
                    }

                    answersgrp.clearCheck();
                }
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(SpaceActivity.this, R.style.AlertDialogStyle));
                builder.setTitle("Please Confirm");
                builder.setMessage("Are you sure you want to quit this quiz?");
                builder.setIcon(R.drawable.warning);
                builder.setCancelable(false);

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(SpaceActivity.this, QuizActivity.class);
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });


    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(SpaceActivity.this, R.style.AlertDialogStyle));
        builder.setTitle("Please Confirm");
        builder.setMessage("Are you sure you want to quit this quiz?");
        builder.setIcon(R.drawable.warning);
        builder.setCancelable(false);

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(SpaceActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        builder.show();
    }
}
