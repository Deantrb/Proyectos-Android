package com.example.tablas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edtv,edtn;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtv=findViewById(R.id.etxtValor);
        edtn=findViewById(R.id.etxtNom);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String nom=edtn.getText().toString();
                    int num= Integer.parseInt(edtv.getText().toString());
                    //Se declaro un objeto de la clase bundle
                    Bundle b=new Bundle();
                    b.putString("NOMBRE",nom);
                    b.putInt("NUMBER",num);

                    Intent int1=new Intent(getApplicationContext(),Resultado.class);
                    int1.putExtras(b);
                    startActivity(int1);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Ocurrio un error inesperado",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}