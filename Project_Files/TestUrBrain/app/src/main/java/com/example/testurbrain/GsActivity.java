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

public class GsActivity extends AppCompatActivity {

    TextView tvNumber, tvQuestion, tvScore;
    Button btnSubmit, btnQuit;
    RadioGroup answersgrp;
    RadioButton rb1, rb2, rb3, rb4;
    ActionBar actionBar;

    String[] questions = {
            "The blue colour of the clear sky is due to",
            "Which one of the following types of waves are used in a night vision apparatus?",
            "As you go down into a well, your weight",
            "The weight of an object will be minimum when it is placed at  ?",
            "Which of the following is used in pencils?",
            "In fireworks, the green flame is produced because of",
            "Brass gets discoloured due to the presence of which of the following gases in air?",
            "What does airbag, used for safety of car driver, contain?",
            "Which one of the following types of laser is used in laser printers?",
            "Potassium Permanganate is used for purifying drinking water, because"
    };
    String[] answers = {"Dispersion of light","Infra-red wave","decreases slightly","The center of the Earth","Graphite","Barium","Hydrogen Sulphide","Sodium azide","Semiconductor Laser","it is an oxidising agent"};
    String[] opt = {
            "Diffraction of light","Dispersion of light","Reflection of light","Refraction of light",
            "Radio wave","Microwaves","Infra-red wave","None of the above",
            "increases slightly","decreases slightly","remains exactly the same","None of the above",
            "The North Pole","The South Pole","The Equator","The center of the Earth",
            "Silicon","Phosphorous","Graphite","Charcoal",
            "Sodium","Potassium","Barium","Mercury",
            "Oxygen","Hydrogen Sulphide","Carbon Dioxide","Nitrogen",
            "Sodium bicarbon","Sodium azide","Sodium nitrite","Sodium peroxide",
            "Semiconductor Laser","Dye laser","Gas laser","Excimer laser",
            "it is a sterilising agent","it dissolves the impurities of water","it is a reducing agent","it is an oxidising agent"
    };

    String statement;

    int flag=0;
    int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);

        actionBar = getSupportActionBar();
        actionBar.setTitle("General Science");

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

                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(GsActivity.this, R.style.AlertDialogStyle));
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
                        Intent intent = new Intent(GsActivity.this, QuizActivity.class);
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(GsActivity.this, R.style.AlertDialogStyle));
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
                Intent intent = new Intent(GsActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        builder.show();
    }
}
