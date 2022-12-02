package com.example.ejemplocuboopengl;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;




import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
public class MyGLRenderer implements GLSurfaceView.Renderer{
   private Cubo cubo;    // (NEW)
   float angulo = 0; // Rotational angle in degree for pyramid (NEW)
   float velocidad = 1.0f; // Rotational speed for pyramid (NEW)
   int signo=1;
   int rotacion=0;
   // Constructor
   public MyGLRenderer(Context context) {
      // Set up the buffers for these shapes
       cubo = new Cubo();   // (NEW)
   }
   // Call back when the surface is first created or re-created.
   @Override
   public void onSurfaceCreated(GL10 gl, EGLConfig config) {
	   gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);  // Set color's clear-value to black
	   gl.glClearDepthf(1.0f);            // Set depth's clear-value to farthest
	   gl.glEnable(GL10.GL_DEPTH_TEST);   // Enables depth-buffer for hidden surface removal
	   gl.glDepthFunc(GL10.GL_LEQUAL);    // The type of depth testing to do
	   gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  // nice perspective view
	   gl.glShadeModel(GL10.GL_SMOOTH);   // Enable smooth shading of color
	   gl.glDisable(GL10.GL_DITHER);      // Disable dithering for better performance
   }
   
   // Call back after onSurfaceCreated() or whenever the window's size changes.
   @Override
   public void onSurfaceChanged(GL10 gl, int width, int height) {
	   if (height == 0) height = 1;   // To prevent divide by zero
	      float aspect = (float)width / height;
	   
	      // Set the viewport (display area) to cover the entire window
	      gl.glViewport(0, 0, width, height);
	  
	      // Setup perspective projection, with aspect ratio matches viewport
	      gl.glMatrixMode(GL10.GL_PROJECTION); // Select projection matrix
	      gl.glLoadIdentity();                 // Reset projection matrix
	      // Use perspective projection
	      GLU.gluPerspective(gl, 60, aspect, 0.1f, 100.f);
	  
	      gl.glMatrixMode(GL10.GL_MODELVIEW);  // Select model-view matrix
	      gl.glLoadIdentity();                 // Reset
   }
  
   // Call back to draw the current frame.
   @Override
   public void onDrawFrame(GL10 gl) {
      // Clear color and depth buffers
      gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    
      // ----- Render the Pyramid -----
      gl.glLoadIdentity();                 // Reset the model-view matrix

      gl.glTranslatef(0f, 0.0f, -6.5f); // Translate left and into the screen
      gl.glRotatef(20,1f,0f,0f);
      switch(rotacion){
          case 0 : gl.glRotatef(angulo, 1f, 0f, 0f); break;
          case 1 : gl.glRotatef(angulo, 0f, 1f, 0f); break;
          case 2 : gl.glRotatef(angulo, 0f, 0f, 1f); break;
      }
       // Rotate (NEW)
      gl.glScalef(1f, 1f, 1f);
      cubo.draw(gl);                              // Draw the pyramid (NEW)
      angulo += velocidad*signo;
   }

   

}
