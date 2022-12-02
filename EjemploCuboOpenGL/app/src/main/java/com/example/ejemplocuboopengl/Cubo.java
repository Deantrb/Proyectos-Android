package com.example.ejemplocuboopengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Cubo {
   private FloatBuffer vertexBuffer;  // Buffer for vertex-array


   private float[] vertices = {

           0.5f,1.0f,0.0f,
           1.0f,0.0f,0.0f,
           0.0f,0.0f,0.0f,

           -0.5f,1.0f,0.0f,
           0.5f,1.0f,0.0f,
           0.0f,0.0f,0.0f,

           -1.0f,0.0f,0.0f,
           -0.5f,1.0f,0.0f,
           0.0f,0.0f,0.0f,

           -0.5f,-1.0f,0.0f,
           -1.0f,0.0f,0.0f,
           0.0f,0.0f,0.0f,

           0.5f,-1.0f,0.0f,
           -0.5f,-1.0f,0.0f,
           0.0f,0.0f,0.0f,

           1.0f,0.0f,0.0f,
           0.5f,-1.0f,0.0f,
           0.0f,0.0f,0.0f,

           //============
           1.0f,0.0f,0.0f,
           0.5f,1.0f,0.0f,
           0.0f,0.0f,2.0f,

           0.5f,1.0f,0.0f,
           -0.5f,1.0f,0.0f,
           0.0f,0.0f,2.0f,

           -0.5f,1.0f,0.0f,
           -1.0f,0.0f,0.0f,
           0.0f,0.0f,2.0f,

           -1.0f,0.0f,0.0f,
           -0.5f,-1.0f,0.0f,
           0.0f,0.0f,2.0f,

           -0.5f,-1.0f,0.0f,
           0.5f,-1.0f,0.0f,
           0.0f,0.0f,2.0f,

           0.5f,-1.0f,0.0f,
           1.0f,0.0f,0.0f,
           0.0f,0.0f,2.0f,

           //==============
           0.5f,1.0f,0.0f,
           1.0f,0.0f,0.0f,
           0.0f,0.0f,-2.0f,

           -0.5f,1.0f,0.0f,
           0.5f,1.0f,0.0f,
           0.0f,0.0f,-2.0f,

           -1.0f,0.0f,0.0f,
           -0.5f,1.0f,0.0f,
           0.0f,0.0f,-2.0f,

           -0.5f,-1.0f,0.0f,
           -1.0f,0.0f,0.0f,
           0.0f,0.0f,-2.0f,

           0.5f,-1.0f,0.0f,
           -0.5f,-1.0f,0.0f,
           0.0f,0.0f,-2.0f,

           1.0f,0.0f,0.0f,
           0.5f,-1.0f,0.0f,
           0.0f,0.0f,-2.0f


   };

   private float[][] colors = {  // Colors of the 5 vertices in RGBA
            {0.2f, 0.2f, 0.2f, 1.0f},  // 1. blak
            {1.0f, 1.0f, 1.0f, 1.0f},  // 0. white
            {0.2f, 0.2f, 0.2f, 1.0f},  // 1. black
            {1.0f, 1.0f, 1.0f, 1.0f},  // 1. whitete
            {0.2f, 0.2f, 0.2f, 1.0f},  // 1. black
            {1.0f, 1.0f, 1.0f, 1.0f},  // 2. white
            {0.3f, 0.0f, 1.0f, 1.0f},  // 2. morado
            {0.3f, 0.0f, 0.4f, 1.0f},  // 4. vino
            {0.6f, 0.0f, 0.2f, 1.0f},  // 1. rojo0.6/0/0.2
            {0.9f, 0.5f, 0.8f, 1.0f},  // 3. pink0.9/0.5/0.8
            {0.6f, 0.2f, 1.0f, 1.0f},  // 3. pink.6/0.2/1
            {1.0f, 0.0f, 0.8f, 1.0f},  // 4. white/0/0.8
           {0.3f, 0.0f, 1.0f, 1.0f},  // 2. morado
           {0.3f, 0.0f, 0.4f, 1.0f},  // 4. vino
           {0.6f, 0.0f, 0.2f, 1.0f},  // 1. rojo0.6/0/0.2
           {0.9f, 0.5f, 0.8f, 1.0f},  // 3. pink0.9/0.5/0.8
           {0.6f, 0.2f, 1.0f, 1.0f},  // 3. pink.6/0.2/1
           {1.0f, 0.0f, 0.8f, 1.0f}


   };  // 5. white


   // Constructor - Set up the buffers
   public Cubo() {
      // Setup vertex-array buffer. Vertices in float. An float has 4 bytes
      ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
      vbb.order(ByteOrder.nativeOrder()); // Use native byte order
      vertexBuffer = vbb.asFloatBuffer(); // Convert from byte to float
      vertexBuffer.put(vertices);         // Copy data into buffer
      vertexBuffer.position(0);           // Rewind
 
   }
  
   // Draw the shape
   public void draw(GL10 gl) {
	      gl.glFrontFace(GL10.GL_CCW);    // Front face in counter-clockwise orientation
	      gl.glEnable(GL10.GL_CULL_FACE); // Enable cull face
	      gl.glCullFace(GL10.GL_BACK);    // Cull the back face (don't display)
	  
	      gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	      gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

	      // Render all the faces
	      for (int face = 0; face < 18; face++) {
	         // Set the color for each of the faces
	         gl.glColor4f(colors[face][0], colors[face][1], colors[face][2], colors[face][3]);
	         // Draw the primitive from the vertex-array directly
	         gl.glDrawArrays(GL10.GL_TRIANGLES, face*3, 3);
	      }
	      gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	      gl.glDisable(GL10.GL_CULL_FACE);
   }
}
