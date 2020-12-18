package com.example.testurbrain;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tic2Activity extends AppCompatActivity {

    Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;
    TextView tvResult, tvPlayer1, tvPlayer2;
    Button btnReset, btnQuitGame, btnSwap;
    int count=0, winner=0;
    int[][] sq= new int[3][3];
    int i, j;
    String player1, player2;
    ActionBar actionBar;

    void disable_button()
    {
        btn00.setEnabled(false);
        btn01.setEnabled(false);
        btn02.setEnabled(false);
        btn10.setEnabled(false);
        btn11.setEnabled(false);
        btn12.setEnabled(false);
        btn20.setEnabled(false);
        btn21.setEnabled(false);
        btn22.setEnabled(false);
    }

    void check_draw()
    {
        if(count==9) tvResult.setText("DRAW");
    }

    void winner_player1()
    {
        //String player1= getIntent().getStringExtra("player1");
        tvResult.setText("Winner: "+ player1.toUpperCase());
        Toast.makeText(getApplicationContext(), player1.toUpperCase()+" won the game!", Toast.LENGTH_LONG).show();
    }

    void winner_player2()
    {
        //String player2= getIntent().getStringExtra("player2");
        tvResult.setText("Winner: "+player2.toUpperCase());
        Toast.makeText(getApplicationContext(), player2.toUpperCase() +" won the game!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic2);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Tic Tac Toe");

        btn00 = findViewById(R.id.button00);
        btn01 = findViewById(R.id.button01);
        btn02 = findViewById(R.id.button02);
        btn10 = findViewById(R.id.button10);
        btn11 = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);
        btn20 = findViewById(R.id.button20);
        btn21 = findViewById(R.id.button21);
        btn22 = findViewById(R.id.button22);
        tvResult = findViewById(R.id.tvResult);
        tvPlayer1 = findViewById(R.id.tvPlayer1);
        tvPlayer2 = findViewById(R.id.tvPlayer2);
        btnReset = findViewById(R.id.btnReset);
        btnSwap = findViewById(R.id.btnSwap);
        btnQuitGame = findViewById(R.id.btnQuitGame);

        player1 = getIntent().getStringExtra("player1");
        player2 = getIntent().getStringExtra("player2");

        tvPlayer1.setText(player1);
        tvPlayer2.setText(player2);

        for (i=0; i<3; i++)
            for(j=0; j<3; j++)
                sq[i][j]=0;

        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                check_draw();

                if(count%2 == 1)
                {
                    sq[0][0]=1;
                    btn00.setText("X");

                    if((sq[0][0]==1 && sq[0][1]==1 && sq[0][2]==1)  || (sq[0][0]==1 && sq[1][0]==1 && sq[2][0]==1) || (sq[0][0]==1 && sq[1][1]==1 && sq[2][2]==1))
                    {
                        winner_player1();
                        disable_button();
                    }
                }

                else
                {
                    sq[0][0]=2;
                    btn00.setText("O");

                    if((sq[0][0]==2 && sq[0][1]==2 && sq[0][2]==2)  || (sq[0][0]==2 && sq[1][0]==2 && sq[2][0]==2) || (sq[0][0]==2 && sq[1][1]==2 && sq[2][2]==2))
                    {
                        winner_player2();
                        disable_button();
                    }
                }
                btn00.setEnabled(false);
            }
        });

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                check_draw();

                if(count%2 == 1)
                {
                    sq[0][1]=1;
                    btn01.setText("X");

                    if((sq[0][0]==1 && sq[0][1]==1 && sq[0][2]==1)  || (sq[0][1]==1 && sq[1][1]==1 && sq[2][1]==1))
                    {
                        winner_player1();
                        disable_button();
                    }
                }

                else
                {
                    sq[0][1]=2;
                    btn01.setText("O");

                    if((sq[0][0]==2 && sq[0][1]==2 && sq[0][2]==2)  || (sq[0][1]==2 && sq[1][1]==2 && sq[2][1]==2))
                    {
                        winner_player2();
                        disable_button();
                    }
                }
                btn01.setEnabled(false);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                check_draw();

                if(count%2 == 1)
                {
                    sq[0][2]=1;
                    btn02.setText("X");

                    if((sq[0][0]==1 && sq[0][1]==1 && sq[0][2]==1)  || (sq[0][2]==1 && sq[1][2]==1 && sq[2][2]==1) || (sq[0][2]==1 && sq[1][1]==1 && sq[2][0]==1))
                    {
                        winner_player1();
                        disable_button();
                    }
                }

                else
                {
                    sq[0][2]=2;
                    btn02.setText("O");

                    if((sq[0][0]==2 && sq[0][1]==2 && sq[0][2]==2)  || (sq[0][2]==2 && sq[1][2]==2 && sq[2][2]==2) || (sq[0][2]==2 && sq[1][1]==2 && sq[2][0]==2))
                    {
                        winner_player2();
                        disable_button();
                    }
                }
                btn02.setEnabled(false);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                check_draw();

                if(count%2 == 1)
                {
                    sq[1][0]=1;
                    btn10.setText("X");

                    if((sq[1][0]==1 && sq[1][1]==1 && sq[1][2]==1)  || (sq[0][0]==1 && sq[1][0]==1 && sq[2][0]==1))
                    {
                        winner_player1();
                        disable_button();
                    }
                }

                else
                {
                    sq[1][0]=2;
                    btn10.setText("O");

                    if((sq[1][0]==2 && sq[1][1]==2 && sq[1][2]==2)  || (sq[0][0]==2 && sq[1][0]==2 && sq[2][0]==2))
                    {
                        winner_player2();
                        disable_button();
                    }
                }
                btn10.setEnabled(false);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                check_draw();

                if(count%2 == 1)
                {
                    sq[1][1]=1;
                    btn11.setText("X");

                    if((sq[1][0]==1 && sq[1][1]==1 && sq[1][2]==1)  || (sq[0][1]==1 && sq[1][1]==1 && sq[2][1]==1)  || (sq[0][0]==1 && sq[1][1]==1 && sq[2][2]==1) || (sq[0][2]==1 && sq[1][1]==1 && sq[2][0]==1))
                    {
                        winner_player1();
                        disable_button();
                    }
                }

                else
                {
                    sq[1][1]=2;
                    btn11.setText("O");

                    if((sq[1][0]==2 && sq[1][1]==2 && sq[1][2]==2)  || (sq[0][1]==2 && sq[1][1]==2 && sq[2][1]==2)  || (sq[0][0]==2 && sq[1][1]==2 && sq[2][2]==2) || (sq[0][2]==2 && sq[1][1]==2 && sq[2][0]==2))
                    {
                        winner_player2();
                        disable_button();
                    }
                }
                btn11.setEnabled(false);
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                check_draw();

                if(count%2 == 1)
                {
                    sq[1][2]=1;
                    btn12.setText("X");

                    if((sq[1][0]==1 && sq[1][1]==1 && sq[1][2]==1)  || (sq[0][2]==1 && sq[1][2]==1 && sq[2][2]==1))
                    {
                        winner_player1();
                        disable_button();
                    }
                }

                else
                {
                    sq[1][2]=2;
                    btn12.setText("O");

                    if((sq[1][0]==2 && sq[1][1]==2 && sq[1][2]==2)  || (sq[0][2]==2 && sq[1][2]==2 && sq[2][2]==2))
                    {
                        winner_player2();
                        disable_button();
                    }
                }
                btn12.setEnabled(false);
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                check_draw();

                if(count%2 == 1)
                {
                    sq[2][0]=1;
                    btn20.setText("X");

                    if((sq[2][0]==1 && sq[2][1]==1 && sq[2][2]==1)  || (sq[0][0]==1 && sq[1][0]==1 && sq[2][0]==1) || (sq[0][2]==1 && sq[1][1]==1 && sq[2][0]==1))
                    {
                        winner_player1();
                        disable_button();
                    }
                }

                else
                {
                    sq[2][0]=2;
                    btn20.setText("O");

                    if((sq[2][0]==2 && sq[2][1]==2 && sq[2][2]==2)  || (sq[0][0]==2 && sq[1][0]==2 && sq[2][0]==2) || (sq[0][2]==2 && sq[1][1]==2 && sq[2][0]==2))
                    {
                        winner_player2();
                        disable_button();
                    }
                }
                btn20.setEnabled(false);
            }
        });

        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                check_draw();

                if(count%2 == 1)
                {
                    sq[2][1]=1;
                    btn21.setText("X");

                    if((sq[2][0]==1 && sq[2][1]==1 && sq[2][2]==1)  || (sq[0][1]==1 && sq[1][1]==1 && sq[2][1]==1))
                    {
                        winner_player1();
                        disable_button();
                    }
                }

                else
                {
                    sq[2][1]=2;
                    btn21.setText("O");

                    if((sq[2][0]==2 && sq[2][1]==2 && sq[2][2]==2)  || (sq[0][1]==2 && sq[1][1]==2 && sq[2][1]==2))
                    {
                        winner_player2();
                        disable_button();
                    }
                }
                btn21.setEnabled(false);
            }
        });

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                check_draw();

                if(count%2 == 1)
                {
                    sq[2][2]=1;
                    btn22.setText("X");

                    if((sq[2][0]==1 && sq[2][1]==1 && sq[2][2]==1)  || (sq[0][2]==1 && sq[1][2]==1 && sq[2][2]==1) || (sq[0][0]==1 && sq[1][1]==1 && sq[2][2]==1))
                    {
                        winner_player1();
                        disable_button();
                    }
                }

                else
                {
                    sq[2][2]=2;
                    btn22.setText("O");

                    if((sq[2][0]==2 && sq[2][1]==2 && sq[2][2]==2)  || (sq[0][2]==2 && sq[1][2]==2 && sq[2][2]==2) || (sq[0][0]==2 && sq[1][1]==2 && sq[2][2]==2))
                    {
                        winner_player2();
                        disable_button();

                    }
                }
                btn22.setEnabled(false);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn00.setEnabled(true);
                btn01.setEnabled(true);
                btn02.setEnabled(true);
                btn10.setEnabled(true);
                btn11.setEnabled(true);
                btn12.setEnabled(true);
                btn20.setEnabled(true);
                btn21.setEnabled(true);
                btn22.setEnabled(true);

                btn00.setText("");
                btn01.setText("");
                btn02.setText("");
                btn10.setText("");
                btn11.setText("");
                btn12.setText("");
                btn20.setText("");
                btn21.setText("");
                btn22.setText("");

                tvResult.setText("");
                count=0;

                for (i=0; i<3; i++)
                    for(j=0; j<3; j++)
                        sq[i][j]=0;
            }
        });

        btnQuitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(Tic2Activity.this, R.style.AlertDialogStyle));
                builder.setTitle("Please Confirm");
                builder.setMessage("Are you sure you want to quit this game?");
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
                        Intent intent= new Intent(Tic2Activity.this, Tic1Activity.class);
                        startActivity(intent);
                    }
                });

                builder.show();
            }
        });

        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count==0)
                {
                    String temp;

                    temp = player1;
                    player1 = player2;
                    player2 = temp;

                    tvPlayer1.setText(player1);
                    tvPlayer2.setText(player2);

                    Toast.makeText(getApplicationContext(), "Players swapped!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Players can only be swapped after resetting the game.", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(Tic2Activity.this, R.style.AlertDialogStyle));
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
                Intent intent= new Intent(Tic2Activity.this, Tic1Activity.class);
                startActivity(intent);
            }
        });

        builder.show();
    }
}
