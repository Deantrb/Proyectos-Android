package com.example.drawer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class elementosResActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementos_res);
        TextView tv=findViewById(R.id.tv1);
        Bundle bu= getIntent().getExtras();
        tv.setText(""+bu.getString("CADENA"));
        if(bu.getString("COLOR").equals("R"))
            tv.setTextColor(Color.RED);
        if(bu.getString("COLOR").equals("A"))
            tv.setTextColor(Color.BLUE);
        if(bu.getString("COLOR").equals("V"))
            tv.setTextColor(Color.GREEN);
    }
}