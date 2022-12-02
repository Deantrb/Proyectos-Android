package com.example.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 TextView tv,d,r;
 Button ad,at;
 int i=0,j;
 double ra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        d=findViewById(R.id.doble);
        r=findViewById(R.id.raiz);
        at=findViewById(R.id.button);
        ad=findViewById(R.id.button2);


        at.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 0){}else{i--;}
                tv.setText("" + i);
                ra=Math.sqrt(i);
                j=(i*i);
                d.setText(""+j);
                r.setText(String.format("%.2f",ra));
            }
        });
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 10){}else{i++;}
                tv.setText(""+i);
                ra=Math.sqrt(i);
                j=(i*i);
                d.setText(""+j);
                d.setText(""+(i*i));
                r.setText(String.format("%.2f",ra));
            }
        });

    }
    @Override
    protected void onSaveInstanceState(Bundle os){
        super.onSaveInstanceState(os);
        os.putInt("doble",j);
        os.putInt("Cont",i);
        os.putDouble("raiz",ra);
    }
    @Override
    protected void onRestoreInstanceState(Bundle os){
        super.onRestoreInstanceState(os);
        i=(os.getInt("Cont"));
        tv.setText(""+i);
        j=(os.getInt("doble"));
        d.setText(""+j);
        ra=(os.getDouble("raiz"));
        r.setText(String.format("%.2f",ra));
    }
}