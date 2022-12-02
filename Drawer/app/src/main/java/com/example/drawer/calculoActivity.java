package com.example.drawer;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class calculoActivity extends AppCompatActivity {
    int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
        Button bt=findViewById(R.id.button);
        EditText ed=findViewById(R.id.edt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=0;
                String[] num=ed.getText().toString().split(",");
                try{
                    if(ed.getText().toString().contains("-")){
                        for (int i = 0; i <= num.length-1; i++) {
                            if (Integer.parseInt(num[i]) != -1) {
                                n = n + Integer.parseInt(num[i]);
                            }else
                                break;
                        }
                        Bundle b=new Bundle();
                        b.putInt("NUMERO", n);
                        Intent int1 = new Intent(getApplicationContext(), calculoResActivity.class);
                        int1.putExtras(b);
                        startActivity(int1);
                    }else
                        Toast.makeText(getApplicationContext(),"Necesitas un numero negativo",Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}