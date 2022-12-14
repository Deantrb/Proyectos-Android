package com.example.ejemplobd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AyudanteBD extends SQLiteOpenHelper {
    //Sentencia para crear la tabla de Usuarios
    String sentenciaCreacionSQL="CREATE TABLE animales (id INTEGER primary key,nombre TEXT, grupo TEXT)";
    public AyudanteBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sentenciaCreacionSQL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // En la práctica deberemos migrar datos de la tabla antigua
        // a la nueva, por lo que este método deberá ser más elaborado.
        //Eliminamos la versión anterior de la tabla
        //db.execSQL("DROP TABLE IF EXISTS autos");
        //y luego creamos la nueva
        //db.execSQL(sqlCreate);
    }
}
