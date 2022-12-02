package com.example.listmenumarvel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class resultActivity extends AppCompatActivity {
TextView nomp,nomr,des;
ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        nomp=findViewById(R.id.textView);
        nomr=findViewById(R.id.textView2);
        des=findViewById(R.id.textView3);
        Bundle bu= getIntent().getExtras();
        nomp.setText(""+bu.getString("NOMP"));
        nomr.setText(""+bu.getString("NOMR"));
        des.setText(""+bu.getString("DES"));
        iv=findViewById(R.id.imageView);
        Picasso.get().load(bu.getString("FOTO")).into(iv);
    }
}