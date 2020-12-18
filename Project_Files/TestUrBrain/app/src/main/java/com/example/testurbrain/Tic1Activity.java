package com.example.testurbrain;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tic1Activity extends AppCompatActivity {

    EditText etPlayer1, etPlayer2;
    Button btnStart, btnAboutGame;
    String player1, player2;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic1);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Tic Tac Toe");
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        etPlayer1 = findViewById(R.id.etPlayer1);
        etPlayer2 = findViewById(R.id.etPlayer2);
        btnStart = findViewById(R.id.btnStart);
        btnAboutGame = findViewById(R.id.btnAboutGame);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                player1= etPlayer1.getText().toString().trim();
                player2= etPlayer2.getText().toString().trim();

                if(TextUtils.isEmpty(player1))
                {
                    etPlayer1.setError("Enter the name of player1!");
                    etPlayer1.requestFocus();
                }
                else if(TextUtils.isEmpty(player2))
                {
                    etPlayer2.setError("Enter the name of player2!");
                    etPlayer2.requestFocus();
                }
                else if(player1.equals(player2))
                {
                    etPlayer2.setText("");
                    etPlayer2.setError("Both Players can not have the same name!");
                    etPlayer2.requestFocus();
                }
                else
                {
                    Intent intent = new Intent(Tic1Activity.this, Tic2Activity.class);
                    intent.putExtra("player1", player1);
                    intent.putExtra("player2", player2);
                    startActivity(intent);
                }
            }
        });

        btnAboutGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(Tic1Activity.this, R.style.AlertDialogStyle));
                builder.setTitle("About this game:");
                builder.setMessage("Tic-tac-toe, noughts and crosses or X's and O's is a game for 2 players, X and O, who take turns marking the spaces in a 3x3 grid. " +
                        "The player who succeeds in placing three of their marks in a horizontal, vertical or diagonal row is the winner. " +
                        "Proper Strategy and careful observation is an integral part of this game. " +
                        "So, invite a friend and get started now!");
                builder.setIcon(R.drawable.info);
                builder.setCancelable(false);

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Tic1Activity.this, GameActivity.class);
        startActivity(intent);
    }
}
