package com.example.dell.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int []gamestate = {2,2,2,2,2,2,2,2,2};
    int [][] winningstate = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    int truth = 1;

    boolean pass = true;

    public void Appear(View view){

        int tappedstate;

        ImageView image = (ImageView) view;

        Log.i("Info", image.getTag().toString());

        tappedstate = Integer.parseInt(image.getTag().toString());

        if(gamestate[tappedstate] == 2 && pass) {

            gamestate[tappedstate] = truth;

            image.setTranslationY(-1500);

            if (truth == 1) {

                image.setImageResource(R.drawable.yellow);


                truth = 0;
            } else if (truth == 0) {

                image.setImageResource(R.drawable.red);


                truth = 1;

            }
            image.animate().translationYBy(1500).rotation(3600).setDuration(500);

            for (int[] win : winningstate) {

                if (gamestate[win[0]] == gamestate[win[1]] && gamestate[win[1]] == gamestate[win[2]] && gamestate[win[0]] != 2) {


                    pass = false;
                    String winner = "";

                    if (truth == 0) {
                        winner = "Yellow";
                    } else {
                        winner = "Red";
                    }


                    Button play = (Button) findViewById(R.id.button2);
                    TextView winnerText = (TextView) findViewById(R.id.textView);

                    winnerText.setText(winner + " Has WON!");

                    play.setVisibility(View.VISIBLE);
                    winnerText.setVisibility(View.VISIBLE);



                }

            }

        }
    }

    public void PlayAgain(View view){

        Button play = (Button) findViewById(R.id.button2);
        TextView winnerText = (TextView) findViewById(R.id.textView);

        play.setVisibility(View.INVISIBLE);
        winnerText.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0; i<gridLayout.getChildCount(); i++){

            ImageView image = (ImageView) gridLayout.getChildAt(i);
            image.setImageDrawable(null);
        }

        for(int i=0; i<gamestate.length; i++) {
            gamestate[i] = 2;
        }

        truth = 1;

        pass = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
