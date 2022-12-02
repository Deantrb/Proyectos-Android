package com.example.ejemplotouch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView iv,iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.imageView);
        iv2=findViewById(R.id.imageView2);
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_UP:
                        iv.setImageResource(R.mipmap.wifunormal);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        iv.setImageResource(R.mipmap.wifuenojada);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        iv.setImageResource(R.mipmap.wifufeliz);
                        break;
                }
                return true;
            }
        });
        iv2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_UP:
                        iv2.setImageResource(R.mipmap.wifunormal);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        iv2.setImageResource(R.mipmap.wifuenojada);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        iv2.setImageResource(R.mipmap.wifufeliz);
                        break;
                }
                return true;
            }
        });
    }
}