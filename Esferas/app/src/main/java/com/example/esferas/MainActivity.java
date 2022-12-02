package com.example.esferas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import geometria.Esfera;

public class MainActivity extends AppCompatActivity {
    TextView r,a,v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=findViewById(R.id.rd);
        a=findViewById(R.id.ar);
        v=findViewById(R.id.vo);
        Esfera esfera= new Esfera();

        for(double i =0; i<=100;i+=0.25){
            esfera.setRadio(i);
            r.append(String.format("\n%.3f",i));
            a.append(String.format("\n%.3f",esfera.area()));
            v.append(String.format("\n%.3f",esfera.volumen()));
        }
    }
    }
