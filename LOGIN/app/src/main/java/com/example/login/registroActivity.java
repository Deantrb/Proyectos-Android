package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registroActivity extends AppCompatActivity {
EditText no,ex,h,email;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btn=findViewById(R.id.btnr);
        no=findViewById(R.id.nom);
        ex=findViewById(R.id.exp);
        h=findViewById(R.id.hora);
        email=findViewById(R.id.email);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Se declaro un objeto de la clase bundle
                    Bundle bu=new Bundle();
                    bu.putString("SOMBRE",no.getText().toString());
                    bu.putString("EXPERIENCE",ex.getText().toString());
                    bu.putString("HORA",h.getText().toString());
                    bu.putString("EMAIL",email.getText().toString());


                    Intent intent=new Intent(getApplicationContext(),Reporte.class);
                    intent.putExtras(bu);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ocurrio un error inesperado",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}