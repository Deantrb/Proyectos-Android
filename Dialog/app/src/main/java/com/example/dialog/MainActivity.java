package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView sal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sal=findViewById(R.id.imageView);

        sal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new SalidaFragmentDialog("ADVERTENCIA","SEGURO QUE DESEA SALIR?","ACEPTAR","CANCELAR").show(getSupportFragmentManager(), "SimpleDialog");;
            }
        });

    }

}