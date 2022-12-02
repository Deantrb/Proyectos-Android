package com.example.ejemploradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
RadioGroup rg;
Button btn;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.radioGrupo);
        tv = findViewById(R.id.textView);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=rg.getCheckedRadioButtonId();
                switch (i){
                    case R.id.radioButton:
                            tv.setText("*ROJO*");
                            tv.setTextColor(Color.RED);
                        break;
                    case R.id.radioButton2:
                        tv.setText("*VERDE*");
                        tv.setTextColor(Color.GREEN);
                        break;
                    case R.id.radioButton3:
                        tv.setText("*AZUL*");
                        tv.setTextColor(Color.BLUE);
                        break;
                    case R.id.radioButton4:
                        tv.setText("*MAGENTA*");
                        tv.setTextColor(Color.MAGENTA);
                        break;
                }
            }
        });
    }
}