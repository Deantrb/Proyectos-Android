package com.example.ejemplocheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button bt;
TextView tv;
CheckBox chb[]=new CheckBox[4];
String paises[]={"Alemania","Polonia","Arabia","Mexico"},
        capitales[]={"Berlin","Varsovia","Riad","Ciudad de México"} ;
int poblacion[]={1000,500,1500,2000},sum=0;

int ids[]={R.id.checkBox2,R.id.checkBox3,R.id.checkBox4,R.id.checkBox5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.button);
        tv=findViewById(R.id.textView);
        for(int i=0;i<4;i++) {
            chb[i] = findViewById(ids[i]);
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String salida="";
                sum=0;
                for(int i=0;i<4;i++){
                    if(chb[i].isChecked()){
                        salida+=capitales[i]+"\n";
                        sum+=poblacion[i];
                    }
                }
                tv.setText(salida+"Total poblacion:"+ sum);
            }
        });
    }
}