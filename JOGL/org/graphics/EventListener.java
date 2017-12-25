package org.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener{

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		gl.glColor3f(1, 0, 1);
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex2f(-125, -125);
			gl.glVertex2f(125, -125);
			gl.glVertex2f(125, 125);
			gl.glVertex2f(-125, 125);
		gl.glEnd();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glClearColor(0, 0, 0, 1);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		gl.glOrtho(-250, 250, -250, 250, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}

}
