package org.graphics;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Renderer {

	private GLWindow window = null;
	
	public void init() {
		GLProfile.initSingleton();
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		
		window = GLWindow.create(caps);
		window.setSize(500, 500);
		window.setResizable(false);
		window.addGLEventListener(new EventListener());
		
		FPSAnimator animator = new FPSAnimator(window, 60);
		animator.start();
		
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		Renderer r = new Renderer();
		r.init();
	}
}
