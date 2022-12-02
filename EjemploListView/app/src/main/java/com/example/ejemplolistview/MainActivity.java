package com.example.ejemplolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String sistemas[] = {"Android","Linux","MacOs","Symbian","Windows","BlackBerry","FireFoxOs",
    "ChromeOs","Armony","Unix","GNX","VAX/DMS","MINX","Debian","FEDORIA","UBUNTU"};
    ArrayAdapter <String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sistemas);
        lv.setAdapter(adaptador);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Has pulsado el: " + sistemas[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}