package com.natanael.dawernav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Elemento extends AppCompatActivity {
    Spinner element;
    String elementos[]={"Hierro", "Potasio","Cobalto","Oro","Helio"};
    ArrayAdapter<String> adF;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elemento);
        element=findViewById(R.id.spinner);
        adF=new ArrayAdapter<String>(this, R.layout.mi_layout,elementos);
        element.setAdapter(adF);
        btn2=findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bolsa=new Bundle();
                Intent int1=new Intent(getApplicationContext(),resultadoElemento.class);
                int1.putExtras(bolsa);
            }
        });



    }
}