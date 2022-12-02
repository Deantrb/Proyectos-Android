package com.natanael.dawernav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragmento_cono extends AppCompatActivity {
    Button btn;
    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento_cono);
        btn = findViewById(R.id.button);
        ed1=findViewById(R.id.editTextcono);
        ed2=findViewById(R.id.editTextH);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valor=Double.parseDouble(ed1.getText().toString());
                double valor2=Double.parseDouble(ed2.getText().toString());
                Bundle bolsa=new Bundle();
                bolsa.putDouble("Dato1",valor);
                bolsa.putDouble("Dato2",valor2);
                //deseo de comunicarse con otra actividad
                Intent int1=new Intent(getApplicationContext(),ResultadoCono.class);
                int1.putExtras(bolsa);
                startActivity(int1);
            }
        });

    }
}