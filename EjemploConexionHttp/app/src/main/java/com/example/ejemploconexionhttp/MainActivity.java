package com.example.ejemploconexionhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView tv;
    Button btC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        btC = findViewById(R.id.button);

        btC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tarea T = new Tarea();
                T.execute("http://huasteco.tiburcio.mx/marvel");

            }
        });
    }

    public class Tarea extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            return ConexionWeb(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String salida="";
            try{
                JSONArray arr=new JSONArray(s);
                for(int i=0;i<arr.length();i++){
                    JSONObject renglon=arr.getJSONObject(i);
                    salida+=renglon.getString("id")+"\n";
                    salida+=renglon.getString("nombreP")+"\n";
                    salida+=renglon.getString("nombreR")+"\n";
                    salida+=renglon.getString("descripcion")+"\n";
                    salida+="================================";

                }
                tv.setText(salida);
            }catch(Exception e){
                tv.setText(e.getMessage());
            }
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

    @Override
    public void onClick(View v) {
        finish();
    }
}
