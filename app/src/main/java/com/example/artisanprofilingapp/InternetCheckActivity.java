package com.example.artisanprofilingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InternetCheckActivity extends AppCompatActivity {
    Button finish,newentry,done;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_check);

        mediaPlayer = MediaPlayer.create(this, R.raw.thankyouinst);
        mediaPlayer.start();

        finish = (Button) findViewById(R.id.finish);
        done = (Button) findViewById(R.id.done);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ThankYouActivity.this.finish();
//                System.exit(0);
                mediaPlayer.stop();
                finishAffinity();
                System.exit(0);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ThankYouActivity.this.finish();
//                System.exit(0);
                mediaPlayer.stop();
                Intent i=new Intent(InternetCheckActivity.this,SplashScreen.class);
                startActivity(i);
            }
        });

    }

}