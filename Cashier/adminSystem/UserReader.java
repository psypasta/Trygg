package adminSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserReader implements FileReader{

	private String path = "Cashier/resource/users.txt";
	
	public UserReader() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String read() {
		//  throws IOException 
		  {
		    byte[] encoded = null;
			try {
				encoded = Files.readAllBytes(Paths.get(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return new String(encoded, StandardCharsets.UTF_8);
		  }

	}

	@Override
	public void addLine(String line) {
		boolean append = true;
		Writer output;
		
		try {
			output = new BufferedWriter(new FileWriter(path, append));
		
			output.append("\n" + line);
			output.close();
		} catch (IOException e) {
				e.printStackTrace();
		}  
	}

	@Override
	public void removeLine() {
		// TODO Auto-generated method stub
		
	}

}
