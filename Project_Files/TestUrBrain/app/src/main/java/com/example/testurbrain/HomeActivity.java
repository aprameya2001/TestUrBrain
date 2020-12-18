package com.example.testurbrain;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity {

    ImageView ivQuiz, ivGame, ivAbout;
    ActionBar actionBar;
    LinearLayout layoutQuiz, layoutGame, layoutAbout;
    String name = "Friend";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences pref = getSharedPreferences("MyPref", MODE_PRIVATE);
        if(pref.contains("LoggedInUser"))
        {
            name = pref.getString("LoggedInUser", "Friend");
        }

        actionBar = getSupportActionBar();
        actionBar.setTitle("Welcome "+name+" !");

        ivQuiz = findViewById(R.id.ivQuiz);
        ivGame = findViewById(R.id.ivGame);
        ivAbout = findViewById(R.id.ivAbout);
        layoutQuiz = findViewById(R.id.layoutQuiz);
        layoutGame = findViewById(R.id.layoutGame);
        layoutAbout = findViewById(R.id.layoutAbout);

        Glide.with(this)
                .load(R.drawable.quiz_time)
                .centerCrop()
                .into(ivQuiz);

        Glide.with(this)
                .load(R.drawable.game_time)
                .centerCrop()
                .into(ivGame);

        Glide.with(this)
                .load(R.drawable.question)
                .centerCrop()
                .into(ivAbout);

        layoutQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuizActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        layoutGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, GameActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        layoutAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AboutActivity.class));
            }
        });
    }

    private Boolean exit = false;

    //What happens when back button is pressed
    @Override
    public void onBackPressed() {
        if(exit)
        {
            finish();
        }
        else
        {
            Toast.makeText(this, "Press Back again to Exit.", Toast.LENGTH_SHORT).show();

            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3*1000);
        }
    }
}
