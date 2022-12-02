package com.example.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;

public class canvas extends View {
    private ShapeDrawable miDibujo; // Dibujo
    private Drawable miImagen;      // Imagen
    public canvas (Context context) {
        super(context);

        // Definiendo un dibujo
        miDibujo = new ShapeDrawable();

        // Definiendo una imagen
        Resources res = context.getResources();
        miImagen = res.getDrawable(R.drawable.ven);
    }

    @Override
    protected void onDraw(Canvas lienzo) {
//Dibujar aquí
        // Se obtienen dimensiones de pantalla
        int resX=lienzo.getWidth(); // ancho en pixeles
        int resY=lienzo.getHeight(); // alto en pixeles

        // Crea un pincel
        Paint pincel = new Paint();



        //Dibuja dos lineas en color rojo
        /*pincel.setColor(Color.RED); // Ajusta el color rojo
        pincel.setStrokeWidth(16); // Ajusta anchura del trazo a 16
        pincel.setStyle(Paint.Style.STROKE); // Ajusta estilo solo contorno
        lienzo.drawLine(0,0,resX,resY,pincel); // dibuja linea
        lienzo.drawLine(0,resY,resX,0,pincel); // dibuja linea
        */
        //Dibuja circulo con relleno en color azul

        pincel.setStrokeWidth(16);
        pincel.setColor(Color.BLUE); // Ajusta el color azul
        pincel.setStyle(Paint.Style.STROKE); // Ajusta estilo para relleno
        lienzo.drawCircle(resX/2,resY/2, 200, pincel); // Dibuja el circulo

        // Rectangulo y circulo con contorno color magenta
        pincel.setColor(Color.WHITE);
        pincel.setStyle(Paint.Style.STROKE);
        lienzo.drawCircle(resX/2,resY*4/10,100,pincel);

        pincel.setColor(Color.WHITE);
        pincel.setStyle(Paint.Style.STROKE);
        lienzo.drawCircle(resX*3/10,resY/2,100,pincel);

        pincel.setStyle(Paint.Style.STROKE);
        pincel.setColor(Color.WHITE);
        lienzo.drawCircle(resX*7/10,resY/2,100,pincel);

        pincel.setStyle(Paint.Style.STROKE);
        pincel.setColor(Color.WHITE);
        lienzo.drawCircle(resX/2,resY*6/10,100,pincel);

        pincel.setColor(Color.RED);
        pincel.setStyle(Paint.Style.STROKE);
        lienzo.drawCircle(resX*3/8,resY*4/9,100,pincel);

        pincel.setColor(Color.YELLOW);
        pincel.setStyle(Paint.Style.STROKE);
        lienzo.drawCircle(resX*5/8,resY*6/11,100,pincel);

        pincel.setColor(Color.YELLOW);
        pincel.setStyle(Paint.Style.STROKE);
        lienzo.drawCircle(resX*3/8,resY*6/11,100,pincel);

        pincel.setColor(Color.RED);
        pincel.setStyle(Paint.Style.STROKE);
        lienzo.drawCircle(resX*5/8,resY*4/9,100,pincel);




        // Texto color naranja tamaño 75
        /*pincel.setColor(Color.rgb(255,153,34));
        pincel.setTextSize(75);
        //pincel.setTypeface(Typeface.SANS_SERIF);
        lienzo.drawText("Hola mundo !!",200,150,pincel);
        */
        // Circulo relleno amarillo


        // Mostrar el dibujo en el lienzo
        miDibujo.draw(lienzo);

        // Mostrando la imagen en el lienzo
        //miImagen.setBounds(resX/2-120,resY/2-120,resX/2+120,resY/2+120);
        //miImagen.draw(lienzo);
    }
}
