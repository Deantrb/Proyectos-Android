package com.example.listcontactos;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    ArrayList<String> arrayList,numeros,nombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.listView);
        arrayList = new ArrayList<String>();
        numeros = new ArrayList<String>();
        nombres = new ArrayList<String>();
        ObtenerDatos();
        lista.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b=new Bundle();
                b.putString("nom", nombres.get(i).toString());
                b.putString("num", numeros.get(i).toString());
                Intent in= new Intent(getApplicationContext(), mensajeActivity.class);
                in.putExtras(b);
                startActivity(in);
            }
        });
    }

    public void ObtenerDatos() {
        String[] contactos = new String[]{ContactsContract.Data.DISPLAY_NAME,
                                          ContactsContract.CommonDataKinds.Phone.NUMBER,
                                          ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER};
        String selectionClause = ContactsContract.Data.MIMETYPE + "='" +
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND "
                + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";
        String sortOrder = ContactsContract.Data.DISPLAY_NAME + " ASC";
        Cursor c = getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                contactos,
                selectionClause,
                null,
                sortOrder);

        HashSet<String> normalizedNumbersAlreadyFound = new HashSet<>();
        int indexOfNormalizedNumber = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NORMALIZED_NUMBER);
        while (c.moveToNext()) {
            String normalizedNumber = c.getString(indexOfNormalizedNumber);
            if (normalizedNumbersAlreadyFound.add(normalizedNumber)) {
                //*No se encuentra numero, lo agrega.
                arrayList.add(c.getString(0) +"\n"+ c.getString(1));
                nombres.add(c.getString(0));
                numeros.add(c.getString(1));
            }
        }
        c.close();
    }
}