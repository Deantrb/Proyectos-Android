package com.example.insertar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
Button btn;
EditText id,tipo,marca;
TextView tv;
String uri="http://huasteco.tiburcio.mx/~a18091116/insertar.php?id=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        id=findViewById(R.id.id);
        tipo=findViewById(R.id.tipo);
        marca=findViewById(R.id.marca);
        tv=findViewById(R.id.textView2);
        Tarea c=new Tarea();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uri=uri+id.getText()+"&tipo=";
                uri=uri+tipo.getText()+"&marca=";
                uri=uri+marca.getText()+";";

                c.execute(uri);
            }
        });

    }
    class Tarea extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            return ConexionWeb(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                Toast.makeText(getApplicationContext(),s ,Toast.LENGTH_SHORT).show();

            }catch (Exception e){}

        }
    }

    String ConexionWeb(String direccion) {
        String pagina = "";
        try {
            URL url = new URL(direccion);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new
                        InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                while (linea != null) {
                    pagina += linea + "\n";
                    linea = reader.readLine();
                }
                reader.close();
            } else {
                pagina += "ERROR: " + conexion.getResponseMessage() + "\n";
            }
            conexion.disconnect();

        } catch (Exception e) {
            pagina += e.getMessage();
        }

        return pagina;
    }
}