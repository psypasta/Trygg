package model.adminSystem.FileFactory;

import model.adminSystem.User;
import model.registerSystem.Product;

public interface FileFactory {
	
	public User createUser(int index);
	public Product createProduct(int index);
	public String[] fileArray();
	public String[] arrayChop(String[] lines, int index);
	public int getLinesSize();
	
}
