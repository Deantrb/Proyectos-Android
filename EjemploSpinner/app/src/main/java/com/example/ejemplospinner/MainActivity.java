package com.example.ejemplospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv;
Spinner sp;
Button bt;
String frutas[]={"Platano","Manzana","Durazno","Guayaba","Pera","Papaya","Piña"};
//Declarar un adaptador
ArrayAdapter<String>adSp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        sp=findViewById(R.id.spinner);
        bt=findViewById(R.id.btn);
        adSp=new ArrayAdapter<String>(this, R.layout.mi_layout,frutas);
        sp.setAdapter(adSp);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String frut=sp.getSelectedItem().toString();

                tv.setText(sp.getSelectedItemId()+""+frut);
            }
        });
    }
}