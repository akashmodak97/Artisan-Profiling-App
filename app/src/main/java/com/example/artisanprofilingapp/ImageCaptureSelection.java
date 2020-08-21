package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImageCaptureSelection extends AppCompatActivity {
    Button saree, kurtya, tshirt, showpiece, bag, goina;
    private SharedPreferences myPref;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_capture_selection);
        saree = findViewById(R.id.saree);
        kurtya = findViewById(R.id.kurta);
        tshirt = findViewById(R.id.tshirt);
        showpiece = findViewById(R.id.showPiece);
        bag = findViewById(R.id.bag);
        goina = findViewById(R.id.goina);
        myPref = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
        mediaPlayer = MediaPlayer.create(this, R.raw.captureselectioninst);
        mediaPlayer.start();

        saree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPref.edit().putString("selected","saree").apply();
                myPref.edit().putString("track", "9").apply();
                mediaPlayer.stop();
                startActivity(new Intent(getApplicationContext(),Insert_image_instructionActivity.class));
            }
        });
        kurtya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPref.edit().putString("selected","kurta").apply();
                myPref.edit().putString("track", "9").apply();
                mediaPlayer.stop();
                startActivity(new Intent(getApplicationContext(),Insert_image_instructionActivity.class));
            }
        });
        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPref.edit().putString("selected","tshirt").apply();
                myPref.edit().putString("track", "9").apply();
                mediaPlayer.stop();
                startActivity(new Intent(getApplicationContext(),Insert_image_instructionActivity.class));
            }
        });
        showpiece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPref.edit().putString("selected","showpiece").apply();
                myPref.edit().putString("track", "9").apply();
                mediaPlayer.stop();
                startActivity(new Intent(getApplicationContext(),Insert_image_instructionActivity.class));
            }
        });
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPref.edit().putString("selected","bag").apply();
                myPref.edit().putString("track", "9").apply();
                mediaPlayer.stop();
                startActivity(new Intent(getApplicationContext(),Insert_image_instructionActivity.class));
            }
        });
        goina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPref.edit().putString("selected","goina").apply();
                myPref.edit().putString("track", "9").apply();
                mediaPlayer.stop();
                startActivity(new Intent(getApplicationContext(),Insert_image_instructionActivity.class));
            }
        });

    }


}