package com.example.myapplication;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button play, stop, pause;
    MediaPlayer vectormp[] = new MediaPlayer[3];
    Spinner spi;
    String sonidos[]={"rugido","vamonos","trueno","titi"};
    ArrayAdapter<String> ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the MediaPlayer object reference with null

        play = (Button) findViewById(R.id.btnPlay);
        stop = (Button) findViewById(R.id.btnStop);
        pause = (Button) findViewById(R.id.btnPause);
        spi=findViewById(R.id.spinner);

        ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sonidos);
        spi.setAdapter(ad);


        vectormp[0] = MediaPlayer.create(this,R.raw.rugido);
        vectormp[1] = MediaPlayer.create(this,R.raw.vamonos);
        vectormp[2] = MediaPlayer.create(this,R.raw.trueno);
        vectormp[3]=MediaPlayer.create(this,R.raw.badbunnytiti);

        play.setOnClickListener(this::play);
        pause.setOnClickListener(this::pause);
        stop.setOnClickListener(this::stop);


    }

    private void stop(View view) {
        int pos=spi.getSelectedItemPosition();
        if(vectormp[pos]!=null){
            vectormp[pos].stop();


            vectormp[0] = MediaPlayer.create(this,R.raw.rugido);
            vectormp[1] = MediaPlayer.create(this,R.raw.vamonos);
            vectormp[2] = MediaPlayer.create(this,R.raw.trueno);
            vectormp[3]=MediaPlayer.create(this,R.raw.badbunnytiti);
            spi.setSelection(0);
        }


    }

    private void pause(View view) {
        int pos=spi.getSelectedItemPosition();
        if (vectormp[pos].isPlaying()) {
            vectormp[pos].pause();

        } else {
            Toast.makeText(  this,  "ya esta parada la cansion", Toast. LENGTH_SHORT).show();
        }
    }

    private void play(View view) {
        int pos=spi.getSelectedItemPosition();
        if (vectormp[pos].isPlaying()) {
            Toast.makeText(  this,  "Ya esta Reproduciendo una cansion", Toast. LENGTH_SHORT).show();


        } else {
            vectormp[pos].start();
        }
    }
}
