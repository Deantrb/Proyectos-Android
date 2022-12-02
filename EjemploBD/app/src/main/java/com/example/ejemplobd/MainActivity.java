package com.example.ejemplobd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    AyudanteBD aBD;
    SQLiteDatabase db=null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.tv1);
        tv1.setText("Bases de datos.\n");
        //creacion de una bd e insercion de datos
        try{
            aBD=new AyudanteBD(this,"AnimalesBD",null,1);
            db = aBD.getWritableDatabase();
            if (db!=null) {
                db.execSQL("INSERT INTO animales values (1,'Tigre','Mamifero')");
                db.execSQL("INSERT INTO animales values (2,'Rana','Anfibio')");
                db.execSQL("INSERT INTO animales values (3,'Ganso','Ave')");
                db.execSQL("INSERT INTO animales values (4,'Elefante','Mamifero')");
                db.execSQL("INSERT INTO animales values (5,'Tiburon','Pez')");
                db.execSQL("INSERT INTO animales values (6,'Hormiga','Insecto')");
                db.execSQL("INSERT INTO animales values (7,'Jirafa','Mamifero')");
                db.close();
            }
            else
                tv1.setText("db fue null :-(");
        }//try
        catch (Exception e)
        {
            tv1.setText(e.getMessage()+"\n\n");
        }
        // Ahora va la consulta de los registros.
        // Antes de realizar la consulta se ejemplifica una baja y una
        // modificación de registros.
        try{
            aBD=new AyudanteBD(this,"AnimalesBD",null,1);
            db = aBD.getReadableDatabase();
            if (db!=null) {
        // Ejemplo de DELETE y UPDATE
                db.execSQL("DELETE FROM animales WHERE id=3");
                db.execSQL("UPDATE animales set nombre='Caiman',grupo='Reptil' WHERE id=7");
                        Cursor cursor = db.rawQuery("SELECT * FROM animales",null);
                int numcol=cursor.getColumnCount();
                int numren=cursor.getCount();
                tv1.append("Cursor con "+numren+" registros\n"+numcol+" columnas\n");
                while (cursor.moveToNext()){
                    tv1.append("\n"+cursor.getInt(0)+" " +cursor.getString(1)+" "
                            +cursor.getString(2));
                }//while
                cursor.close();
                db.close();
            }//if
            else
                tv1.setText("db fue null");
        }//try
        catch (Exception e) {
            tv1.setText("ERROR "+e.getMessage());
        }//catch
    } //onCreate
}// class

