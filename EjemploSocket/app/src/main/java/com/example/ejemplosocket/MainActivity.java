package com.example.ejemplosocket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends Activity implements View.OnClickListener{
    TextView resultado;
    Button btn1;
    EditText et1,et2,et3;
    String animal,ip,puerto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado=findViewById(R.id.textView);
        btn1=findViewById(R.id.button);
        btn1.setOnClickListener(this);
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
    }
    public String ejecutaCliente(String nombre,String ipserv,int puerto) {
        String registroeventos="Conectando al socket " + ipserv + ":" + puerto+"\n";
        try {
            Socket sk = new Socket(ipserv,puerto);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()),true);
            registroeventos+="Conexion establecida !!!\n";
            registroeventos+="enviando al servidor la palabra -->"+nombre+"\n";
            salida.println(nombre);
            registroeventos+="recibiendo del servidor...\n";
            registroeventos+=entrada.readLine()+"\n";
            sk.close();
        }
        catch (Exception e) {
            registroeventos="Error !!\n " + e.toString()+"\n";
        }
        return registroeventos;
    } //ejecutaCliente
    public class Tarea extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            return ejecutaCliente(strings[0],strings[1],Integer.parseInt(strings[2]));
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            resultado.setText(s);
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button){
            animal=et1.getText().toString().trim();
            ip=et2.getText().toString().trim();
            puerto=et3.getText().toString().trim();
            Tarea T=new Tarea();
            T.execute(animal,ip,puerto);
        }
    }
}