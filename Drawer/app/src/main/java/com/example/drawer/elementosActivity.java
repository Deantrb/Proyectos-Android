package com.example.drawer;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
public class elementosActivity extends AppCompatActivity {
Spinner sp;
Button bt;
CheckBox ch[]=new CheckBox[4];
String[] nom= new String[10];
String[] sym= new String[10];
int[] nat=new int[10];
int[] grup=new int[10];
Double[] pat=new Double[10];
ArrayAdapter<String> adSp;
int idsc[]={R.id.checkBox,R.id.checkBox2,R.id.checkBox3,R.id.checkBox4},id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementos);
        TextView tv=findViewById(R.id.textView7);
        bt=findViewById(R.id.button2);
        sp=findViewById(R.id.spinner);
        RadioGroup rg = findViewById(R.id.radioGrupo);
        spinnerElements();
        for(int i=0;i<4;i++) {
            ch[i] = findViewById(idsc[i]);
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cad="",color="";
                int id= (int) sp.getSelectedItemId();
                cad=cad+"Elemento:\n"+nom[id]+"\n";
                if(ch[0].isChecked())
                    cad=cad+"Simbolo: "+sym[id]+"\n";
                if(ch[1].isChecked())
                    cad=cad+"N. Atomico: "+nat[id]+"\n";
                if(ch[2].isChecked())
                    cad=cad+"Peso Atomico: "+pat[id]+"\n";
                if(ch[3].isChecked())
                    cad=cad+"Grupo: "+grup[id];
                int i=rg.getCheckedRadioButtonId();
                switch (i){
                    case R.id.radioButton:
                        color="A";
                        break;
                    case R.id.radioButton2:
                        color="R";
                        break;
                    case R.id.radioButton3:
                        color="V";
                        break;
                }
                Bundle b=new Bundle();
                        b.putString("CADENA", cad);
                        b.putString("COLOR", color);
                        Intent int1 = new Intent(getApplicationContext(), elementosResActivity.class);
                        int1.putExtras(b);
                        startActivity(int1);
            }
        });
    }
    public void spinnerElements(){
        try{
            InputStream archivo=getResources().openRawResource(R.raw.elementos);
            InputStreamReader flujo=new InputStreamReader(archivo);
            BufferedReader buffer = new BufferedReader(flujo);
            String linea = buffer.readLine();
            while (linea !=null){
                String token[] = linea.split(":");
                nom[id]=token[0];
                sym[id]=token[1];
                nat[id]=Integer.parseInt(token[2]);
                pat[id]=Double.parseDouble(token[3]);
                grup[id]=Integer.parseInt(token[4]);
                id++;
                linea=buffer.readLine();
            }
            buffer.close();
            flujo.close();
            archivo.close();
            adSp=new ArrayAdapter<String>(this, R.layout.mi_layout,nom);
            sp.setAdapter(adSp);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
}