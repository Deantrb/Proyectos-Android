package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView cab,der,izq;
    int nf=0,ids[]={
            R.mipmap.caballo1,
            R.mipmap.caballo2,
            R.mipmap.caballo3,
            R.mipmap.caballo4,
            R.mipmap.caballo5,
            R.mipmap.caballo6,
            R.mipmap.caballo7,
            R.mipmap.caballo8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cab=findViewById(R.id.caballo);
        izq=findViewById(R.id.izq);
        der=findViewById(R.id.der);



        izq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nf=(nf==0)?7:nf-1;
                cab.setImageResource(ids[nf]);

            }
        });
        der.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nf=(nf==7)?0:nf+1;
                cab.setImageResource(ids[nf]);
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle os){
        super.onSaveInstanceState(os);
        os.putInt("cont",nf);

    }
    @Override
    protected void onRestoreInstanceState(Bundle os){
        super.onRestoreInstanceState(os);
        nf=(os.getInt("cont"));
        cab.setImageResource(ids[nf]);

    }
}