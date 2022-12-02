package com.example.hilosejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tvEsq;
    Button btn;
    int cont=0;
    int contEsq=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.textView);
        tvEsq=findViewById(R.id.textView2);
        btn=findViewById(R.id.button);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(""+(++cont));
            }
        });

        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cont=0;
                tv.setText("0");
                return true;
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable R1= new Runnable() {
                    @Override
                    public void run() {
                        proceso();
                    }
                };
                Thread hilo=new Thread(R1);
                hilo.start();
            }
        });
    }

    void proceso(){

        for (contEsq=1;contEsq<=10;contEsq++) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvEsq.setText(""+contEsq);
                }
            });
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"Proceso terminado !!", LENGTH_LONG).show();
            }
        });
    }

}