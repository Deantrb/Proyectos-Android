package com.example.drawer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class calculoResActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_res);
        ImageView iv=findViewById(R.id.imageView2);
        TextView tv=findViewById(R.id.textView5);
        Bundle bu= getIntent().getExtras();
        tv.setText(""+bu.getInt("NUMERO"));
        Uri urlparse = Uri.parse("https://media.tenor.com/CpMj1KdWkf4AAAAd/thumbs-up-nice.gif");

        Glide.with(getApplicationContext()).load(urlparse).into(iv);
        }
    }
