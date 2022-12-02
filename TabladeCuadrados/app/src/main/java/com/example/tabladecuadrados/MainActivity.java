package com.example.tabladecuadrados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import geometria.Cuadrado;

public class MainActivity extends AppCompatActivity {
    TextView L,P,A;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L = findViewById(R.id.textView6);
        P = findViewById(R.id.textView7);
        A = findViewById(R.id.textView8);
        Cuadrado cuadrado = new Cuadrado();
        for(double i=0;i<=50;i+=.25){
            cuadrado.setLado(i);
            double p = cuadrado.perimetro();
            double a = cuadrado.area();
            L.append(String.format("\n%.3f",i));
            P.append(String.format("\n%.3f",p));
            A.append(String.format("\n%.3f",a));
        }
    }
}