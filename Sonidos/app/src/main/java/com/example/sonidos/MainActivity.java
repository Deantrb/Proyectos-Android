package com.example.sonidos;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button bReproducir;
    public SoundPool sp;
    public int flujodemusica[];
    Spinner spi;
    String sonidos[]={"bell","disparo","explosion","golpe","laser","miau","rugido","trueno","rana"};
    ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bReproducir=findViewById(R.id.btn);
        spi=findViewById(R.id.spinner);

        ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sonidos);
        spi.setAdapter(ad);

        sp = new SoundPool(9, AudioManager.STREAM_MUSIC, 0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        flujodemusica = new int[]{
                sp.load(this, R.raw.bell, 1),
                sp.load(this, R.raw.disparo, 1),
                sp.load(this, R.raw.explosion, 1),
                sp.load(this, R.raw.golpe, 1),
                sp.load(this, R.raw.laser, 1),
                sp.load(this, R.raw.miau, 1),
                sp.load(this, R.raw.rugido, 1),
                sp.load(this, R.raw.trueno, 1),
                sp.load(this, R.raw.rana, 1)
        };



        bReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=spi.getSelectedItemPosition();
                sp.play(flujodemusica[pos], 1, 1, 0, 0, 1);
            }
        });
    }
}
