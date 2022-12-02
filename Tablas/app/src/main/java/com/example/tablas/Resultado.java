package com.example.tablas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        txt=findViewById(R.id.textView);
        Bundle bu= getIntent().getExtras();
        String nom=bu.getString("NOMBRE");
        int num=bu.getInt("NUMBER");

        txt.append("Hola "+nom+"\n la tabla del "+num+ " es: \n");
        for(int i=1;i<=10;i++){
            txt.append(num+" x " + i+ "= "+(i*num)+"\n");
        }

    }
}