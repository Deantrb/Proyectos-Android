package com.example.listmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnItemClickListener{
    private ArrayList<Prog> prog;
    private ListView list;
    private ProgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        list=(ListView)findViewById(R.id.listv);
        list.setOnItemClickListener(this);
        prog=new ArrayList<Prog>();
        rellenarArrayList();
        adapter = new ProgAdapter(this, prog);

        // Asignamos el Adapter al ListView, en este punto hacemos que el
        // ListView muestre los datos que queremos.
        list.setAdapter(adapter);
    }
    private void rellenarArrayList() {
        prog.add(new Prog("Melodia",R.mipmap.melodia));
        prog.add(new Prog("Video",R.mipmap.video));
        prog.add(new Prog("Dibujo",R.mipmap.dibujo));
        prog.add(new Prog("Animacion",R.mipmap.animacion));
        prog.add(new Prog("Touch y Sonido",R.mipmap.touch));
        prog.add(new Prog("Gestures",R.mipmap.gestures));
        prog.add(new Prog("Acerca de",R.mipmap.acerca));


    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(prog.get(i).getNombre().equals("Melodia")){
            Intent int1=new Intent(getApplicationContext(),MelodiaActivity.class);
            startActivity(int1);
        }
        if(prog.get(i).getNombre().equals("Video")){
            Intent int1=new Intent(getApplicationContext(),VideoActivity.class);
            startActivity(int1);
        }
        if(prog.get(i).getNombre().equals("Dibujo")){
            Intent int1=new Intent(getApplicationContext(),DibujoActivity.class);
            startActivity(int1);
        }
        if(prog.get(i).getNombre().equals("Animacion")){
            Intent int1=new Intent(getApplicationContext(),AnimacionActivity.class);
            startActivity(int1);
        }
        if(prog.get(i).getNombre().equals("Touch y Sonido")){
            Intent int1=new Intent(getApplicationContext(),TouchActivity.class);
            startActivity(int1);
        }if(prog.get(i).getNombre().equals("Gestures")){
            Intent int1=new Intent(getApplicationContext(),GesturesActivity.class);
            startActivity(int1);
        }if(prog.get(i).getNombre().equals("Acerca de")){
            Intent int1=new Intent(getApplicationContext(),AcercaActivity.class);
            startActivity(int1);
        }



    }

    public class Prog {
        private String nombre;
        private int drawableImageID;

        public Prog(String nombre, int drawableImageID) {
            this.nombre = nombre;
            this.drawableImageID = drawableImageID;
        }
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getDrawableImageID() {
            return this.drawableImageID;
        }

        public void setDrawableImageID(int drawableImageID) {
            this.drawableImageID = drawableImageID;
        }

    }
    public class ProgAdapter extends ArrayAdapter<Prog>{
        private Context context;
        private ArrayList<Prog> datos;

        public ProgAdapter(Context context, ArrayList<Prog> datos) {
            super(context, R.layout.itemview, datos);
            // Guardamos los parámetros en variables de clase.
            this.context = context;
            this.datos = datos;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // En primer lugar "inflamos" una nueva vista, que será la que se
            // mostrará en la celda del ListView. Para ello primero creamos el
            // inflater, y después inflamos la vista.
            LayoutInflater inflater = LayoutInflater.from(context);
            View item = inflater.inflate(R.layout.itemview, null);

            // A partir de la vista, recogeremos los controles que contiene para
            // poder manipularlos.
            // Recogemos el ImageView y le asignamos una foto del animal
            ImageView imagen = (ImageView) item.findViewById(R.id.imgAnimal);
            imagen.setImageResource(datos.get(position).getDrawableImageID());

            // Recogemos el TextView para mostrar la descripción del animal

            // Recogemos el TextView para mostrar el nombre del animal
            // como titulo
            TextView numCelda = (TextView) item.findViewById(R.id.tvTitulo);
            numCelda.setText(datos.get(position).getNombre());

            // Devolvemos la vista para que se muestre en el LImageistView.
            return item;
        }
    }

}