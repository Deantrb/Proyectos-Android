package com.example.listmenu;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
public class canvas extends View {
    private ShapeDrawable miDibujo;
    public canvas (Context context) {
        super(context);

        miDibujo = new ShapeDrawable();

        Resources res = context.getResources();

    }

    @Override
    protected void onDraw(Canvas lienzo) {

        int resX=lienzo.getWidth(); // ancho en pixeles
        int resY=lienzo.getHeight(); // alto en pixeles

        Paint pincel = new Paint();

        pincel.setStrokeWidth(10);
        pincel.setColor(Color.BLUE); // Ajusta el color azul
        pincel.setStyle(Paint.Style.STROKE); // Ajusta estilo para relleno
        lienzo.drawCircle(resX/2,resY/2, 200, pincel); // Dibuja el circulo

         pincel.setColor(Color.argb(125,3,255,255));
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


        miDibujo.draw(lienzo);
    }
}
