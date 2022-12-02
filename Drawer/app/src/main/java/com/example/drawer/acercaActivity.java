package com.example.drawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class acercaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        ImageView im=findViewById(R.id.imageView);
        Glide.with(getBaseContext()).load(R.mipmap.foto).apply(RequestOptions.circleCropTransform()).into(im);
    }
}