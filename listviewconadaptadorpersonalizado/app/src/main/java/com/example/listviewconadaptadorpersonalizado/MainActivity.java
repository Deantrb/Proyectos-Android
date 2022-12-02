package com.example.listviewconadaptadorpersonalizado;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{

    private ArrayList<Animal> animales;
    private ListView lvAnimales;
    private AnimalesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvAnimales=(ListView)findViewById(R.id.listView1);
        lvAnimales.setOnItemClickListener(this);

        // Inicializamos el adapter.
        animales=new ArrayList<Animal>();
        rellenarArrayList();
        adapter = new AnimalesAdapter(this, animales);

        // Asignamos el Adapter al ListView, en este punto hacemos que el
        // ListView muestre los datos que queremos.
        lvAnimales.setAdapter(adapter);
    }

    private void rellenarArrayList() {
        animales.add(new Animal("Águila", "Ave de altos vuelos", R.mipmap.aguila));
        animales.add(new Animal("Ballena","El mamífero mas grande", R.mipmap.ballena));
        animales.add(new Animal("Caballo", "El complemento del hombre",R.mipmap.caballo));
        animales.add(new Animal("Camaleón","Ejemplo de mimetización", R.mipmap.camaleon));
        animales.add(new Animal("Canario","Un ave con un lindo trino", R.mipmap.canario));
        animales.add(new Animal("Cerdo", "Una buena fuente de alimentos",R.mipmap.cerdo));
        animales.add(new Animal("Delfín", "El más simpático e inteligente",R.mipmap.delfin));
        animales.add(new Animal("Gato","El que dicen que tiene 7 vidas", R.mipmap.gato));
        animales.add(new Animal("Iguana","Reptil muy comun en climas áridos", R.mipmap.iguana));
        animales.add(new Animal("Lince","Un felino muy veloz", R.mipmap.lince));
        animales.add(new Animal("Lobo","Aullador en luna llena", R.mipmap.lobo_9));
        animales.add(new Animal("Morena","Muy peligrosa para los buzos", R.mipmap.morena));
        animales.add(new Animal("Orca", "Un asesino de los mares fríos",R.mipmap.orca));
        animales.add(new Animal("Perro","El mejor amigo del hombre", R.mipmap.perro));
        animales.add(new Animal("Vaca","Rumiante de los campos y granjas", R.mipmap.vaca));
    }

    public class Animal {
        private String nombre;
        private String descripcion;
        private int drawableImageID;

        public Animal(String nombre, String descripcion, int drawableImageID) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.drawableImageID = drawableImageID;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
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
    } //Animal

    public class AnimalesAdapter extends ArrayAdapter<Animal>{
        private Context context;
        private ArrayList<Animal> datos;

        public AnimalesAdapter(Context context, ArrayList<Animal> datos) {
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
            //
            TextView nombre = (TextView) item.findViewById(R.id.tvDescripcion);
            nombre.setText(datos.get(position).getDescripcion());

            // Recogemos el TextView para mostrar el nombre del animal
            // como titulo
            TextView numCelda = (TextView) item.findViewById(R.id.tvTitulo);
            numCelda.setText(datos.get(position).getNombre());

            // Devolvemos la vista para que se muestre en el LImageistView.
            return item;
        }
    } // AnimalesAdapter

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        //Toast.makeText(this, animales.get(arg2).getNombre(), Toast.LENGTH_SHORT).show();
        mostrarToast("Seleccionaste: "+animales.get(arg2).getNombre());
    }

    private void mostrarToast(String s){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toastLayout));
        TextView tv=layout.findViewById(R.id.textview);
        tv.setText(s);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
