package renderEngine;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class DisplayManager {

	private static final int WIDTH = 1280, HEIGHT = 720;
	private static long window = 0;
	
	
	public static void main(String[] args) {
	
		createDisplay();
		updateDisplay();
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
	/*	
		while(!glfwWindowShouldClose(window)) {
			glfwPollEvents();
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			

				
			
			glfwSwapBuffers(window);
		}
		
		glfwTerminate(); */
	}
	
	public static void updateDisplay() {

	}
	
	public static void closeDisplay() {

	}

}
