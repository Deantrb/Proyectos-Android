package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.security.auth.Destroyable;

public class Reporte extends AppCompatActivity {
    TextView nom,exp,ho,email;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);
        b = findViewById(R.id.fin);
        nom = findViewById(R.id.getnom);
        exp = findViewById(R.id.getXP);
        ho = findViewById(R.id.getH);
        email = findViewById(R.id.getEma);

        Bundle bu = getIntent().getExtras();
        nom.setText("" + bu.getString("SOMBRE"));
        exp.setText("" + bu.getString("EXPERIENCE"));
        ho.setText("" + bu.getString("HORA"));
        email.setText("" + bu.getString("EMAIL"));

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}