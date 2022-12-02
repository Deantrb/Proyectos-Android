package com.example.listmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimacionActivity extends AppCompatActivity implements View.OnClickListener{
    Button bp,bs;
    private ImageView ivAn;
    private AnimationDrawable saveAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animacion);
        bp = (Button)findViewById(R.id.bp);
        bs = (Button)findViewById(R.id.bs);
        bp.setOnClickListener(this);
        bs.setOnClickListener(this);

        ivAn = (ImageView)findViewById(R.id.imageView);
        ivAn.setBackgroundResource(R.drawable.animacion);
        saveAnim = (AnimationDrawable)ivAn.getBackground();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bp:
                saveAnim.start();
                break;
            case R.id.bs:
                saveAnim.stop();
                break;
        }
    }
}