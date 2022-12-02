package com.natanael.ejemplovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView vv;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        vv=findViewById(R.id.videoView);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        vv.setMediaController(new MediaController(this));
        String loc="android.resource://"+getPackageName()+"/"+R.raw.minions;
        vv.setVideoURI(Uri.parse(loc));
        vv.start();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc="android.resource://"+getPackageName()+"/"+R.raw.minions;
                vv.setVideoURI(Uri.parse(loc));
                vv.start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc="android.resource://"+getPackageName()+"/"+R.raw.pelea;
                vv.setVideoURI(Uri.parse(loc));
                vv.start();
            }
        });
    }
}