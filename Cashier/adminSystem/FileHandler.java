package adminSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler{

	private String path = "Cashier/resource/";
	
	public FileHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public String read(String file) {
		path += file;
		//  throws IOException 
		  {
		    byte[] encoded = null;
			try {
				encoded = Files.readAllBytes(Paths.get(path));
			} catch (IOException e) {
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
			System.out.println("data: " + data);
		    return data;
		  }

	}

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

	public void removeLine() {
		// TODO Auto-generated method stub
		
	}

}
