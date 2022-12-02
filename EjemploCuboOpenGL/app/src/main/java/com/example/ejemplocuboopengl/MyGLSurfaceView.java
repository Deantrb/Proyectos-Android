package com.example.ejemplocuboopengl;
import android.content.Context;
import android.opengl.GLSurfaceView;

import android.view.MotionEvent;
public class MyGLSurfaceView extends GLSurfaceView {
   MyGLRenderer renderer;    // Custom GL Renderer
   private final float TOUCH_SCALE_FACTOR = 180.0f / 320.0f;
   public MyGLSurfaceView(Context context) {
      super(context);
      renderer = new MyGLRenderer(context);
      this.setRenderer(renderer);
      // Request focus, otherwise key/button won't react
      this.requestFocus();  
      this.setFocusableInTouchMode(true);
   }
   // Handler for touch event
   @Override
   public boolean onTouchEvent(final MotionEvent evt) {
      switch (evt.getPointerCount())
      {
         case (1):
        	renderer.signo = 0; break;
         case (2):
            renderer.signo=-1; break;
         case (3):
        	renderer.signo=1; break;
         case (4):
            renderer.rotacion=(renderer.rotacion+1)%3;
            renderer.angulo=0; break;
      }
      return true;  // Event handled
   }
}
