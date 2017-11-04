package adminSystem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProductReader  implements FileReader {
	
	private String path = "Cashier/resource/products.txt";

	public ProductReader() {
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
			        lines[i]="";
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

	

}
