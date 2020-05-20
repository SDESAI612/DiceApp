package com.sdesai612.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView dice1;
    ImageView dice2;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);

        final int diceImages[] = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        button = findViewById(R.id.rollButton);
        final MediaPlayer diceSound = MediaPlayer.create(this,R.raw.dice_sound);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                diceSound.start();

                Random rndObject = new Random();
                int myRandomNumber1 = rndObject.nextInt(6);
                int myRandomNumber2 = rndObject.nextInt(6);
                vibrator.vibrate(300);
                YoYo.with(Techniques.Shake)
                        .duration(200)
                        .repeat(1)
                        .playOn(findViewById(R.id.dice1));

                YoYo.with(Techniques.Shake)
                        .duration(300)
                        .repeat(1)
                        .playOn(findViewById(R.id.dice2));
                dice1.setImageResource(diceImages[myRandomNumber1]);
                dice2.setImageResource(diceImages[myRandomNumber2]);

            }
        });
    }
}
