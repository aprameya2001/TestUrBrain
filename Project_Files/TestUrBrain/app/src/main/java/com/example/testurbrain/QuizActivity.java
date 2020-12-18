package com.example.testurbrain;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class QuizActivity extends AppCompatActivity {

    LinearLayout layoutSpace, layoutOops, layoutGK, layoutIP, layoutSports, layoutGS, layoutFP;
    ImageView ivSpace, ivOops, ivGK, ivIP, ivSports, ivGS, ivFP;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        layoutSpace = findViewById(R.id.layoutSpace);
        layoutOops = findViewById(R.id.layoutOops);
        layoutGK = findViewById(R.id.layoutGK);
        layoutIP = findViewById(R.id.layoutIP);
        layoutSports = findViewById(R.id.layoutSports);
        layoutGS = findViewById(R.id.layoutGS);
        layoutFP = findViewById(R.id.layoutFP);

        ivSpace = findViewById(R.id.ivSpace);
        ivOops = findViewById(R.id.ivOops);
        ivGK = findViewById(R.id.ivGK);
        ivIP = findViewById(R.id.ivIP);
        ivSports = findViewById(R.id.ivSports);
        ivGS = findViewById(R.id.ivGS);
        ivFP = findViewById(R.id.ivFP);

        actionBar = getSupportActionBar();
        actionBar.setTitle("It's Quiz Time!");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Glide.with(this)
                .load(R.drawable.space)
                .centerCrop()
                .into(ivSpace);

        Glide.with(this)
                .load(R.drawable.oops)
                .centerCrop()
                .into(ivOops);

        Glide.with(this)
                .load(R.drawable.gk)
                .centerCrop()
                .into(ivGK);

        Glide.with(this)
                .load(R.drawable.politics)
                .centerCrop()
                .into(ivIP);

        Glide.with(this)
                .load(R.drawable.sports)
                .centerCrop()
                .into(ivSports);

        Glide.with(this)
                .load(R.drawable.science)
                .centerCrop()
                .into(ivGS);

        Glide.with(this)
                .load(R.drawable.places)
                .centerCrop()
                .into(ivFP);

        layoutSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuizActivity.this, SpaceActivity.class);
                startActivity(intent);
            }
        });

        layoutOops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, OopsActivity.class);
                startActivity(intent);
            }
        });

        layoutGK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuizActivity.this, Gk2Activity.class);
                startActivity(intent);
            }
        });

        layoutIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, PoliticsActivity.class);
                startActivity(intent);
            }
        });

        layoutSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, SportsActivity.class);
                startActivity(intent);
            }
        });

        layoutGS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, GsActivity.class);
                startActivity(intent);
            }
        });

        layoutFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, FpActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(QuizActivity.this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
