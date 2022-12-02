package com.example.listmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MelodiaActivity extends AppCompatActivity {
    Button btplay,btstop,btexit,btsig,btant,btrep;
    MediaPlayer mp;
    ImageView iv;
    TextView tx;
    SeekBar sk;
    int rep=2,posi=0;

    MediaPlayer plist[]=new MediaPlayer[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_melodia);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        btplay=findViewById(R.id.play);
        btstop=findViewById(R.id.stop);
        btsig=findViewById(R.id.siguiente);
        btant=findViewById(R.id.anterior);
        btrep=findViewById(R.id.repetir);
        tx=findViewById(R.id.textView);

        iv=(ImageView)findViewById(R.id.imageView);
        btexit=findViewById(R.id.exit);

        plist[0]=MediaPlayer.create(this, R.raw.microcuts);
        plist[1]=MediaPlayer.create(this, R.raw.darkshine);
        plist[2]=MediaPlayer.create(this, R.raw.spacede);
        plist[3]=MediaPlayer.create(this, R.raw.newborn);
        tx.setText("Muse - Micro Cuts");
        sk=findViewById(R.id.seekBar2);

        btplay.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                PlayPause();
            }});
        btstop.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {Stop();}});
        btsig.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {Siguiente();}});
        btant.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {Anterior();}});
        btrep.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {Repetir();}});
        btexit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {finish(); plist[posi].stop();}});

        sk.setMax(plist[posi].getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sk.setProgress(plist[posi].getCurrentPosition());
            }
        }, 0,100);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    plist[posi].seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void PlayPause(){
        if(plist[posi].isPlaying()){
            plist[posi].pause();
            btplay.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this,"Pausa",Toast.LENGTH_SHORT).show();
        }else{
            plist[posi].start();
            btplay.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        }

    }
    public void Stop(){
        if(plist[posi]!=null){
            plist[posi].stop();

            plist[0]=MediaPlayer.create(this, R.raw.microcuts);
            plist[1]=MediaPlayer.create(this, R.raw.darkshine);
            plist[2]=MediaPlayer.create(this, R.raw.spacede);
            plist[3]=MediaPlayer.create(this, R.raw.newborn);
            posi=0;
            btplay.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.muse);
            Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();
        }
    }
    public void Repetir(){
        if(rep==1){
            btrep.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this,"No repetir",Toast.LENGTH_SHORT).show();
            plist[posi].setLooping(false);
            rep=2;
        }else{
            btrep.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this,"Repetir",Toast.LENGTH_SHORT).show();
            plist[posi].setLooping(true);
            rep=1;
        }
    }
    public void Siguiente(){
        if(posi < plist.length-1){
            if(plist[posi].isPlaying()){
                plist[posi].stop();
                posi++;
                plist[posi].start();
                if(posi==0){iv.setImageResource(R.drawable.muse);tx.setText("Muse - Micro Cuts");}
                else if(posi==1){iv.setImageResource(R.drawable.darkshine);tx.setText("Muse - Dark Shines");}
                else if(posi==2){iv.setImageResource(R.drawable.spacedemetia);tx.setText("Muse - Space Dementia");}
                else if(posi==3){iv.setImageResource(R.drawable.newborn);tx.setText("Muse - New Born");}
            }else{
                posi++;
                if(posi==0){iv.setImageResource(R.drawable.muse);tx.setText("Muse - Micro Cuts");}
                else if(posi==1){iv.setImageResource(R.drawable.darkshine);tx.setText("Muse - Dark Shines");}
                else if(posi==2){iv.setImageResource(R.drawable.spacedemetia);tx.setText("Muse - Space Dementia");}
                else if(posi==3){iv.setImageResource(R.drawable.newborn);tx.setText("Muse - New Born");}
            }
        }else{
            Toast.makeText(this,"No hay mas canciones",Toast.LENGTH_SHORT).show();
        }
    }
    public void Anterior(){
        if(posi>=1){
            if(plist[posi].isPlaying()){
                plist[posi].stop();
                plist[0]=MediaPlayer.create(this, R.raw.microcuts);
                plist[1]=MediaPlayer.create(this, R.raw.darkshine);
                plist[2]=MediaPlayer.create(this, R.raw.spacede);
                plist[3]=MediaPlayer.create(this, R.raw.newborn);
                posi--;

                if(posi==0){iv.setImageResource(R.drawable.muse);tx.setText("Muse - Micro Cuts");}
                else if(posi==1){iv.setImageResource(R.drawable.darkshine);tx.setText("Muse - Dark Shines");}
                else if(posi==2){iv.setImageResource(R.drawable.spacedemetia);tx.setText("Muse - Space Dementia");}
                else if(posi==3){iv.setImageResource(R.drawable.newborn);tx.setText("Muse - New Born");}

                plist[posi].start();
            }else{
                posi--;

                if(posi==0){iv.setImageResource(R.drawable.muse);tx.setText("Muse - Micro Cuts");}
                else if(posi==1){iv.setImageResource(R.drawable.darkshine);tx.setText("Muse - Dark Shines");}
                else if(posi==2){iv.setImageResource(R.drawable.spacedemetia);tx.setText("Muse - Space Dementia");}
                else if(posi==3){iv.setImageResource(R.drawable.newborn);tx.setText("Muse - New Born");}
            }
        }
        else{
            Toast.makeText(this,"No hay mas canciones",Toast.LENGTH_SHORT).show();
        }
    }



}