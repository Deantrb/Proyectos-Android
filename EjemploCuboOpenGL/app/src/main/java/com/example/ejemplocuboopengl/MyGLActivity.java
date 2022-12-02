package com.example.ejemplocuboopengl;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class MyGLActivity extends Activity {

	private MyGLSurfaceView glView5;
	int ban=1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glView5 = new MyGLSurfaceView(this);
        this.setContentView(glView5); 
    }
    // Call back when the activity is going into the background
    @Override
    protected void onPause() {
       super.onPause();
       glView5.onPause();
    }
    
    // Call back after onPause()
    @Override
    protected void onResume() {
       super.onResume();
       glView5.onResume();
    }



	



    
}
