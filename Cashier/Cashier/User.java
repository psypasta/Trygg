package Cashier;

public class User {
	
	private String name;	
	private int code;
	
	public User(String name, int code) {
		this.name = name;
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
