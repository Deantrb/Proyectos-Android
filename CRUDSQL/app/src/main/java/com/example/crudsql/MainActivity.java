package com.example.crudsql;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import google.zxing.integration.android.IntentIntegrator;
import google.zxing.integration.android.IntentResult;
public class MainActivity extends Activity implements View.OnClickListener, View.OnLongClickListener {
     EditText eid,enom,emar,etipo,elang;
     Button btnc,btnr,btnu,btnd,btn5;
     ImageView equis,mundo;
    DataBaseKBD aBD;
    SQLiteDatabase db=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eid=findViewById(R.id.editTextid);
        enom=findViewById(R.id.editTextnombre);
        emar=findViewById(R.id.editTextmarca);
        etipo=findViewById(R.id.editTexttipo);
        elang=findViewById(R.id.editTextlang);

        btnc=findViewById(R.id.button1);
        btnc.setOnClickListener(this);
        btnr=findViewById(R.id.button2);
        btnr.setOnClickListener(this);
        btnr.setOnLongClickListener(this);
        btnu=findViewById(R.id.button3);

        btnu.setOnClickListener(this);
        btnd=findViewById(R.id.button4);
        btnd.setOnClickListener(this);



        equis=(ImageView) findViewById(R.id.imageView);
        equis.setOnClickListener(this);
        mundo=(ImageView) findViewById(R.id.syncr);
        mundo.setOnClickListener(this);
        try{
            aBD=new DataBaseKBD(this,"KBDFANS",null,1);
            db = aBD.getWritableDatabase();
            if (db!=null) {
                db.close();
            }
            else
                Toast.makeText(getApplicationContext(),"Falla",Toast.LENGTH_SHORT).show();
        }//try
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"base de datos cargada",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClick(View view) {
    if(view.getId()==R.id.button1){
        if(eid.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"El campo de id esta vacio",Toast.LENGTH_SHORT).show();
        }else if(enom.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"El campo de nombre esta vacio",Toast.LENGTH_SHORT).show();
            }
        else if(emar.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"El campo de marca esta vacio",Toast.LENGTH_SHORT).show();
        }else if(etipo.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "El campo de tipo esta vacio", Toast.LENGTH_SHORT).show();
        }else if(elang.getText().toString().isEmpty()) {
        Toast.makeText(getApplicationContext(), "El campo de lang esta vacio", Toast.LENGTH_SHORT).show();
        }else{
            try {
                String ID=(eid.getText().toString());
                String Nom=enom.getText().toString();
                String Marca=emar.getText().toString();
                String Tipo=etipo.getText().toString();
                String Lang=elang.getText().toString();
                aBD=new DataBaseKBD(this,"KBDFANS",null,1);
                db = aBD.getReadableDatabase();
                String Cadema="INSERT INTO keyboards VALUES('"+ID+"','"+Nom+"','"+Marca+"','"+Tipo+"','"+Lang+"')";
                db.execSQL(Cadema);
                db.close();
                Toast.makeText(getApplicationContext(), "Insercion exitosa", Toast.LENGTH_SHORT).show();
                limpiar();
            }catch (Exception err){
                Toast.makeText(getApplicationContext(), "El id ya existe, ingrese uno nuevo", Toast.LENGTH_SHORT).show();
            }
        }
    }//ya no

        if(view.getId()==R.id.button2){
            try {
            String ID=(eid.getText().toString());
            aBD=new DataBaseKBD(this,"KBDFANS",null,1);
            db = aBD.getReadableDatabase();
            String qry="SELECT * FROM keyboards where(id='"+ID+"')";
            Cursor cursor=db.rawQuery(qry,null);
            cursor.moveToFirst();
            String ide=cursor.getString(0);
            String NOMBRE=cursor.getString(1);
            String MARCA=cursor.getString(2);
            String TIPO=cursor.getString(3);
            String LANG=cursor.getString(4);
            eid.setText(ide);
            enom.setText(NOMBRE);
            emar.setText(MARCA);
            etipo.setText(TIPO);
            elang.setText(LANG);
            btnu.setEnabled(true);
            btnd.setEnabled(true);
            cursor.close();
            db.close();

            }catch (Exception err){
                Toast.makeText(getApplicationContext(), "No se encontro el Id, por favor verificar que sea correcto", Toast.LENGTH_SHORT).show();
                limpiar();
            }
        }
        if(view.getId()==R.id.button3){
            if(eid.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"El campo de id esta vacio",Toast.LENGTH_SHORT).show();
            }else if(enom.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"El campo de pieza esta vacio",Toast.LENGTH_SHORT).show();
            }else if(emar.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"El campo de marca esta vacio",Toast.LENGTH_SHORT).show();
            }else if(etipo.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "El campo de precio esta vacio", Toast.LENGTH_SHORT).show();
            }else{
                try{
                    String ID=(eid.getText().toString());
                    String Nombre=enom.getText().toString();
                    String Marca=emar.getText().toString();
                    String Tipo=etipo.getText().toString();
                    String Lang=elang.getText().toString();
                    aBD=new DataBaseKBD(this,"KBDFANS",null,1);
                    db = aBD.getReadableDatabase();
                    String qry="UPDATE keyboards set nombre='"+Nombre+"',marca='"+Marca+"',tipo='"+Tipo+"',lang='"+Lang+"' where id='"+ID+"'";
                    db.execSQL(qry);
                    db.close();
                    Toast.makeText(getApplicationContext(), "Registro Actualizado", Toast.LENGTH_SHORT).show();
                    limpiar();
                }catch (Exception err){
                    Toast.makeText(getApplicationContext(), "Id no encontrado", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(view.getId()==R.id.button4){
            try {
            String ID=(eid.getText().toString());
            aBD=new DataBaseKBD(this,"KBDFANS",null,1);
            db = aBD.getReadableDatabase();
            String qry="DELETE FROM keyboards where(id='"+ID+"')";
            db.execSQL(qry);
            db.close();
            Toast.makeText(getApplicationContext(), "Registro Eliminado", Toast.LENGTH_SHORT).show();
            btnu.setEnabled(false);
            btnd.setEnabled(false);
                limpiar();
            }catch (Exception err){
                Toast.makeText(getApplicationContext(), "Id no encontrado", Toast.LENGTH_SHORT).show();
            }
        }
        if(view.getId()==R.id.syncr){
            System.out.println("Entrando a sync");
            int contN=0;
            String cadena="http://huasteco.tiburcio.mx/~a18091116/borrar2.php";
            Tarea2 t = new Tarea2();
            t.execute(cadena);
            try{
                aBD=new DataBaseKBD(this,"KBDFANS",null,1);
                db = aBD.getReadableDatabase();
                if (db!=null) {
                    // Ejemplo de DELETE y UPDATE
                    Cursor cursor8 = db.rawQuery("SELECT * FROM keyboards",null);
                    String url = "";
                    while (cursor8.moveToNext()){
                        url +="http://huasteco.tiburcio.mx/~a18091116/insertar.php?id="+cursor8.getString(0)+"&nombre="+cursor8.getString(1)+"&marca="+cursor8.getString(2)+"&tipo="+cursor8.getString(3)+"&lang="+cursor8.getString(4)+"#";

                    }//while
                    System.out.println(t.isCancelled()+"<-cancelado otro-> "+t.getStatus());
                    Tarea tc = new Tarea();
                    tc.execute(url);
                    cursor8.close();
                    db.close();
                    limpiar();
                }//if
                else
                    Toast.makeText(getApplicationContext(), "db fue null :-(", Toast.LENGTH_LONG).show();
            }//try
            catch (Exception e) {
                limpiar();
                Toast.makeText(getApplicationContext(), "Se ha producido un error "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        if(view.getId()==R.id.imageView){
            limpiar();
        }
    }
    public void limpiar(){
        eid.setText("");
        enom.setText("");
        emar.setText("");
        etipo.setText("");
        elang.setText("");
    }
    class Tarea extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            String[] datos = strings[0].split("#");
            System.out.println("Tarea 1 ejecutandose");
            for(String dInd : datos){
                System.out.println("Tarea"+dInd);
                ConexionWeb(dInd);
            }
            return "Sincronizado";
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        }
    }
    class Tarea2 extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
          return ConexionWeb(strings[0]);
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
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
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //Se obtiene el resultado del proceso de scaneo y se parsea
        super.onActivityResult(requestCode, resultCode, intent);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            //Quiere decir que se obtuvo resultado pro lo tanto:
            //Desplegamos en pantalla el contenido del código de barra scaneado
            String scanContent = scanningResult.getContents();
            eid.setText(scanContent);
            //Desplegamos en pantalla el nombre del formato del código de barra scaneado
        } else {
            //Quiere decir que NO se obtuvo resultado
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No se ha recibido datos del scaneo!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    @Override
    public boolean onLongClick(View view) {
       if(view.getId()==R.id.button2){
            Intent intent =new Intent(getApplicationContext(),Consulta.class);
            startActivity(intent);
       }
        return false;
    }
}


