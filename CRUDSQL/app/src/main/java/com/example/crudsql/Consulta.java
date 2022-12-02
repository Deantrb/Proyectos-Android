package com.example.crudsql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Consulta extends AppCompatActivity {
    TextView tv1;
    DataBaseKBD aBD;
    SQLiteDatabase db=null;
    protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);
        tv1=findViewById(R.id.textView);


        aBD=new DataBaseKBD(this,"KBDFANS",null,1);
        db = aBD.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM keyboards",null);
            while (cursor.moveToNext()){
                tv1.append("\n"+"Id: "+cursor.getString(0)+" " +"\nNombre: "+cursor.getString(1)+" "
                        +"\nMarca:"+cursor.getString(2)+"\nTipo: "+cursor.getString(3)+"\nLang: "+cursor.getString(4)+"\n");
            }//while
            cursor.close();
            db.close();
}
}


