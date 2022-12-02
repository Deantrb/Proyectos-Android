package com.example.ejemplohilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button bti,btp;
TextView tv,tv1;
ImageView iv;
    int contador=0,c=0,i=0,j=0,ids[]={
            R.mipmap.caba1,
            R.mipmap.caba2,
            R.mipmap.caba3,
            R.mipmap.caba4,
            R.mipmap.caba5,
            R.mipmap.caba6,
            R.mipmap.caba7,
            R.mipmap.caba8,
            R.mipmap.caba9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bti=findViewById(R.id.btincre);
        iv=findViewById(R.id.imageView);
        btp=findViewById(R.id.btproc);
        tv1=findViewById(R.id.textView);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread hilo3=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(i=0;i<=45;i++){
                            j+=1;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(j==9){
                                        j=0;
                                    }
                                    iv.setImageResource(ids[j]);
                                }
                            });
                            tiempo(100);
                        }
                    }
                });
                hilo3.start();
            }
        });

        bti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador=(contador==10)?0:contador+1;
                bti.setText(""+contador);
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread hilo2=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //tiempo(10000);
                        for(c=0;c<=100;c+=10){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv1.setText(""+ c);

                                }
                            });
                            tiempo(500);
                        }
                    }
                });
                hilo2.start();
            }
        });
        btp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Thread hilo1=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        tiempo(10000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"Proceso terminado",Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                });
                hilo1.start();
            }
        });
    }
    void tiempo(int t){
        try{
            Thread.sleep(t);
        }catch(Exception e){}
    }
}