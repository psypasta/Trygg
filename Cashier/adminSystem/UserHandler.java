package adminSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserHandler implements FileHandler{

	private String path = "Cashier/resource/users.txt";
	
	public UserHandler() {
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
			
			String data = new String(encoded, StandardCharsets.UTF_8);
			String[] lines = data.split(System.getProperty("line.separator"));
			
			for(int i=0;i<lines.length;i++){
			
			    if(lines[i].startsWith("#")){
			        lines[i] = "";
			       
			    }
			    

			}

			StringBuilder finalStringBuilder = new StringBuilder();
			for(String s:lines){
			   if(!s.equals("")){
			       finalStringBuilder.append(s).append(System.getProperty("line.separator"));
			    }
			}
			data = finalStringBuilder.toString();
				
		    return data;
		  }

	}

	@Override
	public void addLine(String line) {
		boolean append = true;
		Writer output;
		
		try {
			output = new BufferedWriter(new FileWriter(path, append));
		
			output.append(System.getProperty("line.separator") + line);
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
