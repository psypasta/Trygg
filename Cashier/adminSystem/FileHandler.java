package adminSystem;

//dåliga namn, dåliga namn överallt... <- help
//handler eller göra en FileWriter :s confoos

public interface FileHandler {
	
	public String read();
	
	public void addLine(String line);
	
	public void removeLine();
	
}
