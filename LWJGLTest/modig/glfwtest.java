package modig;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWVidMode;

public class glfwtest {

	public static void main(String[] args) {
		if(!glfwInit()) {
			throw new IllegalStateException("Failed to initialize GLFW!");
		}

		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		long window = glfwCreateWindow(640, 480, "MYLWJGLProgram", 0, 0);
		if(window == 0) {
			throw new IllegalStateException("Failed to create window");
		}
		
		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());	
		glfwSetWindowPos(window, (videoMode.width() - 640) / 2, (videoMode.width() - 480) / 2);
		
		glfwShowWindow(window);
		
		while(!glfwWindowShouldClose(window)) {
			glfwPollEvents();
		}
		
	}

}
