package com.natanael.dawernav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoCono extends AppCompatActivity {
    TextView ev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_cono);
        ev=findViewById(R.id.textView4);

        Bundle bolsaR= getIntent().getExtras();
        double val=bolsaR.getDouble("Dato1");
        double val2=bolsaR.getDouble("Dato2");


            double vol= Math.PI*(val*val)*val2;
            double res=vol/3;
            ev.setText(String.format("%4f",res));
            //ev.setText(String.format("%4f",res));


    }
}