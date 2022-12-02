package com.example.raiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView res;
EditText edt;
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res=findViewById(R.id.textView3);
        edt=findViewById(R.id.edtx);
        btn=findViewById(R.id.button);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double v=Double.parseDouble(edt.getText().toString());
                    double re=Math.sqrt(v);
                    res.setText(String.format("%.4f",re));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),";;",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}