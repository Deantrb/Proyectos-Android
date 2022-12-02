package com.example.ejemplomusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btp,bts,bte;
MediaPlayer np=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        btp=findViewById(R.id.button);
        bts=findViewById(R.id.button2);
        bte=findViewById(R.id.button3);

        bts.setEnabled(false);

        btp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               np=MediaPlayer.create(getApplicationContext(),R.raw.crazylittle);
               np.start();
               bts.setEnabled(true);
               bte.setEnabled(false);
               btp.setEnabled(false);
            }
        });
        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                np.stop();
                btp.setEnabled(true);
                bte.setEnabled(true);
                bts.setEnabled(false);
            }
        });
        bte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}