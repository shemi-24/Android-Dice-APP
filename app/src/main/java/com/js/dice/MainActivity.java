package com.js.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.security.SecureRandom;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button dice;
    private ImageView dice_image1,dice_image2;
    int[] diceImages={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dice=findViewById(R.id.button);
        dice_image1=findViewById(R.id.imageView2);
        dice_image2=findViewById(R.id.imageView3);
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.dice_sound);
        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random obj=new Random();
                int myRandomNumber1=obj.nextInt(6);
                int myRandomNumber2=obj.nextInt(6);
                dice_image1.setImageResource(diceImages[myRandomNumber1]);
                dice_image2.setImageResource(diceImages[myRandomNumber2]);
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imageView2));
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imageView3));
                mediaPlayer.start();
            }
        });
    }
}