package shaders;

public class StaticShader extends ShaderProgram {

	private static final String VERTEX_FILE = "LWJGLTest/shaders/vertexShader.txt", FRAGMENT_FILE = "LWJGLTest/shaders/fragmentShader.txt";
	
	
	//String vertexFile, String fragmentFile
	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);		
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
	}

}
