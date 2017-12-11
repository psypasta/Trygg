package gfx;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFW.*;

public class WindowTest {

	public static void main(String[] args) {

		GLFW.glfwInit();
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
	    //glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
		    
		
	}

}
