package com.example.ejemplotouchsonido;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;


public class MainActivity extends Activity implements OnTouchListener{
	private Drawable miImagen;	
	private Resources res;
	private float px=175,py=575,incx=1,incy=1;
	private int idImagen=R.drawable.carita01;
	private int idFondo=R.drawable.fondogato;
	private int idGato=R.drawable.gato;
	EjemploView lienzo;
	public SoundPool sp;
	public int flujodemusica=0,flujodemusica2=0,flujodemusica3=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		res = getResources();
		lienzo=new EjemploView(this);
		setContentView(lienzo);
		lienzo.setOnTouchListener(this);
		sp = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		flujodemusica= sp.load(this,R.raw.golpe,1);
		flujodemusica2= sp.load(this,R.raw.bell,1);
		flujodemusica3= sp.load(this,R.raw.miau,1);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
        case MotionEvent.ACTION_MOVE: 
        	idImagen=R.drawable.carita02;
            break;
        case MotionEvent.ACTION_DOWN: 
        	idImagen=R.drawable.carita03;
        	sp.play(flujodemusica, 1, 1, 0, 0, 1);
            break;
	    case MotionEvent.ACTION_UP: 
            idImagen=R.drawable.carita01;
			if (0<=px&&px<=400&&0<=py&&py<=400)
				sp.play(flujodemusica3, 1, 1, 0, 0, 1);
			else
				sp.play(flujodemusica2, 1, 1, 0, 0, 1);
            break;
        }
		px = event.getX();
        py = event.getY();
        lienzo.invalidate();
		return true;
	}

	public class EjemploView extends View {	
		private Drawable miImagen,fondo,gato;
		public EjemploView (Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
			// Se obtienen dimensiones de pantalla
			int resX=canvas.getWidth(); // ancho en pixeles
			int resY=canvas.getHeight(); // alto en pixeles

			fondo = res.getDrawable(idFondo);
			fondo.setBounds(0,0,resX-1,resY-1);
			fondo.draw(canvas);

			gato = res.getDrawable(idGato);
			gato.setBounds(0,0,350,350);
			gato.draw(canvas);

	    	miImagen = res.getDrawable(idImagen);
		    miImagen.setBounds((int)px-175,(int)py-175,(int)px+175,(int)py+175);
		    miImagen.draw(canvas);
        }

    }
	
}
