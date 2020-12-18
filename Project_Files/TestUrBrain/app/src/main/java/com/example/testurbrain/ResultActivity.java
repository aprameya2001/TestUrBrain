package com.example.testurbrain;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ResultActivity extends AppCompatActivity {

    TextView tvStar, tvCompliment, tvMarks;
    ImageView ivBadge;
    Button btnQuiz, btnGame;
    ActionBar actionBar;

    int correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Result");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvStar = findViewById(R.id.tvStar);
        tvCompliment = findViewById(R.id.tvCompliment);
        tvMarks = findViewById(R.id.tvMarks);
        ivBadge = findViewById(R.id.ivBadge);
        btnQuiz = findViewById(R.id.btnQuiz);
        btnGame = findViewById(R.id.btnGame);

        correct = getIntent().getIntExtra("correct", 0);

        if(correct==10)
        {
            Glide.with(this)
                    .load(R.drawable.star3)
                    .centerCrop()
                    .into(ivBadge);

            tvCompliment.setText("Perfect!!!");
            tvStar.setText("You have earned 3 stars!");
        }
        else if (correct>=7)
        {
            Glide.with(this)
                    .load(R.drawable.star2)
                    .centerCrop()
                    .into(ivBadge);

            tvCompliment.setText("Well Done!");
            tvStar.setText("You have earned 2 stars!");
        }
        else if(correct>=4)
        {
            Glide.with(this)
                    .load(R.drawable.star1)
                    .centerCrop()
                    .into(ivBadge);

            tvCompliment.setText("Not Bad!");
            tvStar.setText("You have earned 1 star!");
        }
        else
        {
            Glide.with(this)
                    .load(R.drawable.star0)
                    .centerCrop()
                    .into(ivBadge);

            tvCompliment.setText("Practice harder!");
            tvStar.setText("You have earned 0 stars!");
        }

        tvMarks.setText("Score: "+correct+" / 10");

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
        startActivity(intent);
    }
}
