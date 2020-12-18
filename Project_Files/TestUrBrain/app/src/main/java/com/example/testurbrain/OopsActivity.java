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

public class OopsActivity extends AppCompatActivity {

    TextView tvNumber, tvQuestion, tvScore;
    Button btnSubmit, btnQuit;
    RadioGroup answersgrp;
    RadioButton rb1, rb2, rb3, rb4;
    ActionBar actionBar;

    String[] questions = {
            "Which of the following is shred structure of a set of similar objects?",
            "Which of the following does not have a body?",
            "Which of the following is a pure Object oriented programming language?",
            "Which keyword is used to inherit a class or abstract class?",
            "Which of the following is not related to OOPS?",
            "Which language doesn't support single level inheritance?",
            "How many catch blocks can you use with a single Try block?",
            "Which of the following is universal class for exception handling?",
            "In OOPS public,private and protected are ",
            "We cannot create an instance of "
    };
    String[] answers = {"A Class","An Abstract Method","SmallTalk","extends","Structure and Union","C language","As many as required","Exceptions","Access Modifiers","Abstract class"};
    String[] opt = {
            "Encapsulation","A Class","Inheritance","None of the Above",
            "An Interface","A Class","An Abstract Method","None of the Above",
            "Java","SmallTalk","C++","Kotlin",
            "extends","extend","implement","inherit",
            "Class and Object","Constructor and Destructor","Structure and Union","Inheritance and Polymorphism",
            "C language","Java","Kotlin","C++",
            "Only 2","Only 1","Maximum 256","As many as required",
            "Object","Errors","Exceptions","Maths",
            "Classes","Access Modifiers","Interfaces","Method signature",
            "Anonymous class","Nested class","Parent class","Abstract class"
    };

    String statement;

    int flag=0;
    int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);

        actionBar = getSupportActionBar();
        actionBar.setTitle("OOPS");

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

                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(OopsActivity.this, R.style.AlertDialogStyle));
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
                        Intent intent = new Intent(OopsActivity.this, QuizActivity.class);
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(OopsActivity.this, R.style.AlertDialogStyle));
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
                Intent intent = new Intent(OopsActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        builder.show();
    }
}
