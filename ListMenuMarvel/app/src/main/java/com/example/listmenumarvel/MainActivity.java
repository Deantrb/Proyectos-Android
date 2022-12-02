package com.example.listmenumarvel;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adaptador;
    ListView lv;
    String[] id=new String[14],nomp=new String[14],nomr=new String[14],des=new String[14],foto=new String[14];
    String f;
    int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listv);
        Tarea T = new Tarea();
        T.execute("http://huasteco.tiburcio.mx/marvel");
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
                JSONArray arr=new JSONArray(s);
                for(int i=0;i<arr.length();i++){
                    JSONObject renglon=arr.getJSONObject(i);
                    id[i]= renglon.getString("id");
                    nomp[i]= renglon.getString("nombreP");
                    nomr[i]= renglon.getString("nombreR");
                    des[i]= renglon.getString("descripcion");
                    foto[i]= renglon.getString("foto");
                }
                adaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,nomp);
                lv.setAdapter(adaptador);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Bundle b=new Bundle();
                        b.putString("NOMP",nomp[i]);
                        b.putString("NOMR",nomr[i]);
                        b.putString("DES",des[i]);
                        b.putString("FOTO",foto[i]);
                        Intent int1 = new Intent(getApplicationContext(), resultActivity.class);
                        int1.putExtras(b);
                        startActivity(int1);
                        Toast.makeText(getApplicationContext(),nomp[i],Toast.LENGTH_SHORT).show();
                    }
                });
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