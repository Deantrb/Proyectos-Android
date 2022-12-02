package com.natanael.ejemploarchivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream archivo=getResources().openRawResource(R.raw.archivo);
                    InputStreamReader flujo=new InputStreamReader(archivo);
                    BufferedReader buffer = new BufferedReader(flujo);
                    String linea = buffer.readLine();
                    while (linea !=null){
                        String token[] =linea.split(":");
                        String nom=token[0];
                        String cd=token[1];
                        double costohora=Double.parseDouble(token[2]);
                        int horastrab=Integer.parseInt(token[3]);
                        tv.append("\n"+nom+" De "+cd+" Gana "+ costohora*horastrab+"\n");

                        linea=buffer.readLine();

                    }
                    buffer.close();
                    flujo.close();
                    archivo.close();

                }catch (Exception e){
                    tv.setText(e.getMessage());
                }
            }
        });


    }
}