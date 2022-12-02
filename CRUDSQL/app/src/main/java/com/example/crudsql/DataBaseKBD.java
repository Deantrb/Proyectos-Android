package com.example.crudsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseKBD extends SQLiteOpenHelper {
    //Sentencia para crear la tabla de Usuarios
    String sentenciaCreacionSQL="CREATE TABLE keyboards (id TEXT primary key,nombre TEXT, marca TEXT,tipo TEXT,lang TEXT)";
    public DataBaseKBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sentenciaCreacionSQL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}