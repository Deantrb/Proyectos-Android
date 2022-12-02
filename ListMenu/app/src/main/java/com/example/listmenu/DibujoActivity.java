package com.example.listmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DibujoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo);
        setContentView(new canvas(getApplicationContext()));
    }
}