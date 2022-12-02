package com.example.canvasconanimacion;

import android.app.Activity;

import android.graphics.drawable.AnimationDrawable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btnIniciar,btnDetener,btnVerCanvas;
    private ImageView ivAnimacion;
    private AnimationDrawable savingAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnIniciar = (Button)findViewById(R.id.button);
        btnDetener = (Button)findViewById(R.id.button2);
        btnVerCanvas = (Button)findViewById(R.id.button3);
        btnIniciar.setOnClickListener(this);
        btnDetener.setOnClickListener(this);
        btnVerCanvas.setOnClickListener(this);
        ivAnimacion = (ImageView)findViewById(R.id.imageView);
        ivAnimacion.setBackgroundResource(R.drawable.animacion);
        savingAnimation = (AnimationDrawable)ivAnimacion.getBackground();
    }

    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        switch(v.getId()){
            case R.id.button:
                savingAnimation.start();
                break;
            case R.id.button2:
                savingAnimation.stop();
                break;
            case R.id.button3:
                setContentView(new EjemploCanvasView(this));
                break;
        }
    }
}