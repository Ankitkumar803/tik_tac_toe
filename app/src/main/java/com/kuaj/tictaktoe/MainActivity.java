package com.kuaj.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    //game state
    //0-x
    //1-0
    int activeplayer=0;
    boolean gameActive = true;
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};

    public void PlayerTap(View view){
    ImageView Img= (ImageView) view;
    int tappedImage=Integer.parseInt(Img.getTag().toString());
        if(!gameActive){
            reset(view);
        }

    if(gamestate[tappedImage]==2){
        gamestate[tappedImage]=activeplayer;
        Img.setTranslationY(-1000f);

        if(activeplayer==0){
            Img.setImageResource(R.drawable.x);
            activeplayer=1;
            TextView status = findViewById(R.id.status);
            status.setText("Player 2 Turn - Tap ");
        }

    else {
            Img.setImageResource(R.drawable.o);
            activeplayer=0;
            TextView status = findViewById(R.id.status);
            status.setText("Player 1 Turn - Tap ");
        }
    Img.animate().translationYBy(1000f).setDuration(300);
    }
        // Check if any player has won
        for(int[] winPosition: winPositions) {
            if (gamestate[winPosition[0]] == gamestate[winPosition[1]] &&
                    gamestate[winPosition[1]] == gamestate[winPosition[2]] &&
                    gamestate[winPosition[0]] != 2) {
                // Somebody has won! - Find out who!
                String winnerStr;
                gameActive = false;
                if (gamestate[winPosition[0]] == 0) {
                    winnerStr = "Player 1 has won";

                } else {
                    winnerStr = "Player 2 has won";

                }
                // Update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }

    }
    public void reset(View view) {
        gameActive = true;
        activeplayer = 0;
        for (int i = 0; i < gamestate.length; i++) {
            gamestate[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("Player 1 Turn - Tap to play");
    }
  /*  public void reset(View view){
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("Player 1 Turn - Tap to play");


    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}