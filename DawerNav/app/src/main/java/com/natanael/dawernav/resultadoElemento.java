package com.natanael.dawernav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class resultadoElemento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_elemento);

        Bundle bolsaR= getIntent().getExtras();
    }
}