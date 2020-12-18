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

public class PoliticsActivity extends AppCompatActivity {

    TextView tvNumber, tvQuestion, tvScore;
    Button btnSubmit, btnQuit;
    RadioGroup answersgrp;
    RadioButton rb1, rb2, rb3, rb4;
    ActionBar actionBar;

    String[] questions = {
            "Who proposed the Preamble before the Drafting Committee of the Constitution?",
            "Union Budget is always presented first in ____ ",
            "In which year Sikkim became part of India?",
            "Who was the only Lok Sabha speaker to have become the President of India?",
            "Who is the guardian of fundamental Rights enumerated in Indian Constitution?",
            "The Constitution of India borrowed the scheme of Indian Federation from the constitution of",
            "The first Law Officer of the Government of India is the",
            "Right to property was removed from the list of Fundamental Rights during the rule of",
            "Who have the power to decide an election petition?",
            "By virtue of which Act, Diarchy was introduced in India?"
    };
    String[] answers = {"Jawaharlal Nehru","The Lok Sabha","1975","Neelam Sanjiva Reddy","Judiciary","Canada","Attorney-General for India","Morarji Desai Government","High Courts","Indian Independence Act,1947"};
    String[] opt = {
            "Jawaharlal Nehru","B.R. Ambedkar","B.N.Rau","Mahatma Gandhi",
            "The Lok Sabha","The Rajya Sabha","Joint session of the Parliament","Meeting of the Union Cabinet",
            "1972","1975","1977","1980",
            "VV Giri","Zail Singh","Neelam Sanjiva Reddy","S Radhakrishnan",
            "Supreme Court","Parliament","Judiciary","President",
            "USA","Canada","United Kingdom","Ireland",
            "Union Law Minister","Secreatary,Ministry of Law","Attorney-General for India","Chief Justice of the Supreme Court",
            "Indhira Gandhi Government","Morarji Desai Government","Narasimha Rao Government","Vajpayee Government",
            "Parliament","Supreme Court","High Courts","Election Commission",
            "Indian Council Act,1909","Government of India Act,1919","Government of India Act,1935","Indian Independence Act,1947"
    };

    String statement;

    int flag=0;
    int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Indian Politics");

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

                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(PoliticsActivity.this, R.style.AlertDialogStyle));
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
                        Intent intent = new Intent(PoliticsActivity.this, QuizActivity.class);
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(PoliticsActivity.this, R.style.AlertDialogStyle));
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
                Intent intent = new Intent(PoliticsActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        builder.show();
    }
}
