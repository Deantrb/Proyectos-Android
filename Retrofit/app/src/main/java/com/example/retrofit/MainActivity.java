package com.example.retrofit;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import Interface.JsonPlaceHolderApi;
import Model.KBD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {
    private TextView mJsonTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJsonTxtView = findViewById(R.id.jsonText);
        getKBD ();
    }
    private void getKBD(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://huasteco.tiburcio.mx/~a18091116/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<KBD>> call = jsonPlaceHolderApi.getKBD();
        call.enqueue(new Callback<List<KBD>>() {
            @Override
            public void onResponse(Call<List<KBD>> call, Response<List<KBD>> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo"+response.code());
                    return;
                }
                List<KBD> KBDList = response.body();
                for (KBD KBD : KBDList){
                    String content ="";
                    content += "id: "+ KBD.getId() +"\n";
                    content += "nombre: "+ KBD.getNombre() +"\n";
                    content += "marca: "+ KBD.getMarca() +"\n";
                    content += "tipo: "+ KBD.getTipo() +"\n";
                    content += "lang: "+ KBD.getLang() +"\n\n";
                    mJsonTxtView.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<KBD>> call, Throwable t) {
            }
        });
    }
}