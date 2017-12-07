package renderEngine;

import static org.lwjgl.glfw.GLFW.GLFW_CONTEXT_VERSION_MAJOR;
import static org.lwjgl.glfw.GLFW.GLFW_CONTEXT_VERSION_MINOR;
import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_CORE_PROFILE;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_FORWARD_COMPAT;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_PROFILE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class DisplayManager {

	private static final int WIDTH = 1280, HEIGHT = 720;
	private static long window = 0;
	
	
	public static void main(String[] args) {
		Renderer r = new Renderer();
		r.prepare();
		createDisplay();
		updateDisplay(r);
		closeDisplay();
		
	}
	public static void createDisplay() {
		if(!glfwInit()) {
			throw new IllegalStateException("Failed to initialize GLFW!");
		}

		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
		
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		long window = glfwCreateWindow(640, 480, "MYLWJGL Program", 0, 0);
		if(window == 0) {
			throw new IllegalStateException("Failed to create window");
		}
		
		glfwMakeContextCurrent(window);
		GL.createCapabilities();
		
		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());	
		glfwSetWindowPos(window, (videoMode.width() - 640) / 2, (videoMode.height() - 480) / 2);
		
		glfwShowWindow(window);
		
		while(!glfwWindowShouldClose(window)) {
			glfwPollEvents();
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			
			

				
			
			glfwSwapBuffers(window);
		}
		
		glfwTerminate(); 
	}
	
	public static void updateDisplay(Renderer r) {
		Loader l = new Loader();
		float[] pos = {1.0f,  1.0f,
						0.5f, 0.5f,
						0.0f, 0.0f};
		int[] indices = {1};
		r.render(l.loadToVAO(null, null));
	}
	
	public static void closeDisplay() {

	}

}
