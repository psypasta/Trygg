package view.register;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import model.registerSystem.Product;

public class RegisterPanel extends JPanel implements ActionListener { 
	
	private JTextField textField;
	private static JTextArea textArea;
	
	private JButton[] buttons = new JButton[12];
    private String[] buttonNames = new String[] {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0", "#", "Enter"};
    
/*    private List<Product> productList;
    private int productCount = 0; */
    
    private static volatile String data = "99";
    
	public RegisterPanel() {
		initialize();
	}
	
	//skapar och lägger till komponenter i JPanel
	private void initialize() {
		
	//	productList = new ArrayList<Product>();
	
		
	//	setBounds(100, 100, 580, 420);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 50, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textField, 260, SpringLayout.WEST, this);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 0, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 6, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -50, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, this);
		add(textArea);
		
		buttons[0] = new JButton(buttonNames[0]);
		buttons[1] = new JButton(buttonNames[1]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[1], 0, SpringLayout.NORTH, buttons[0]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[1], 6, SpringLayout.EAST, buttons[0]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[1], 0, SpringLayout.SOUTH, buttons[0]);
		springLayout.putConstraint(SpringLayout.EAST, buttons[1], 66, SpringLayout.EAST, buttons[0]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[0], 6, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, buttons[0], 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[0], 46, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, buttons[0], 60, SpringLayout.WEST, textField);
		add(buttons[0]);
		add(buttons[1]);	
		
		buttons[2] = new JButton(buttonNames[2]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[2], 0, SpringLayout.NORTH, buttons[0]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[2], 6, SpringLayout.EAST, buttons[1]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[2], 0, SpringLayout.SOUTH, buttons[0]);
		springLayout.putConstraint(SpringLayout.EAST, buttons[2], 66, SpringLayout.EAST, buttons[1]);
		add(buttons[2]);
		
		buttons[3] = new JButton(buttonNames[3]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[3], 6, SpringLayout.SOUTH, buttons[0]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[3], 0, SpringLayout.WEST, buttons[0]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[3], 46, SpringLayout.SOUTH, buttons[0]);
		springLayout.putConstraint(SpringLayout.EAST, buttons[3], 0, SpringLayout.EAST, buttons[0]);
		add(buttons[3]);
		
		buttons[4] = new JButton(buttonNames[4]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[4], 6, SpringLayout.SOUTH, buttons[1]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[4], 0, SpringLayout.WEST, buttons[1]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[4], 0, SpringLayout.SOUTH, buttons[3]);
		springLayout.putConstraint(SpringLayout.EAST, buttons[4], 0, SpringLayout.EAST, buttons[1]);
		add(buttons[4]);
		
		buttons[5] = new JButton(buttonNames[5]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[5], 6, SpringLayout.SOUTH, buttons[1]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[5], 0, SpringLayout.WEST, buttons[2]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[5], 0, SpringLayout.SOUTH, buttons[3]);
		springLayout.putConstraint(SpringLayout.EAST, buttons[5], 0, SpringLayout.EAST, buttons[2]);
		add(buttons[5]);
		
		buttons[6] = new JButton(buttonNames[6]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[6], 6, SpringLayout.SOUTH, buttons[3]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[6], 0, SpringLayout.WEST, buttons[0]);
		springLayout.putConstraint(SpringLayout.EAST, buttons[6], 0, SpringLayout.EAST, buttons[0]);
		add(buttons[6]);
		
		buttons[7] = new JButton(buttonNames[7]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[6], 0, SpringLayout.SOUTH, buttons[7]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[7], 6, SpringLayout.SOUTH, buttons[4]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[7], 0, SpringLayout.WEST, buttons[1]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[7], 46, SpringLayout.SOUTH, buttons[4]);
		springLayout.putConstraint(SpringLayout.EAST, buttons[7], 0, SpringLayout.EAST, buttons[1]);
		add(buttons[7]);
		
		buttons[8] = new JButton(buttonNames[8]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[8], 6, SpringLayout.SOUTH, buttons[5]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[8], 0, SpringLayout.WEST, buttons[2]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[8], 0, SpringLayout.SOUTH, buttons[7]);
		springLayout.putConstraint(SpringLayout.EAST, buttons[8], 66, SpringLayout.EAST, buttons[1]);
		add(buttons[8]);
		
		buttons[9] = new JButton(buttonNames[9]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[9], 6, SpringLayout.SOUTH, buttons[7]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[9], 0, SpringLayout.WEST, buttons[1]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[9], -147, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, buttons[9], -66, SpringLayout.EAST, buttons[2]);
		add(buttons[9]);
		
		buttons[10] = new JButton(buttonNames[10]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[10], 6, SpringLayout.SOUTH, buttons[6]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[10], 0, SpringLayout.WEST, buttons[0]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[10], -147, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, buttons[10], 0, SpringLayout.EAST, buttons[0]);
		add(buttons[10]);
		
		buttons[11] = new JButton(buttonNames[11]);
		springLayout.putConstraint(SpringLayout.NORTH, buttons[11], 6, SpringLayout.SOUTH, buttons[6]);
		springLayout.putConstraint(SpringLayout.WEST, buttons[11], 0, SpringLayout.WEST, buttons[2]);
		springLayout.putConstraint(SpringLayout.SOUTH, buttons[11], -147, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, buttons[11], 0, SpringLayout.EAST, buttons[2]);
		add(buttons[11]);
		
		for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
            
        }
	}

	public String getData() {
		return data;
	}
	public void setData() {
		data = "99";
	}
	
	public void addProduct(Product p) {
		
		textArea.append(p.getID() + " " + p.getProductName() + " " + p.getPrice() + "\n");
		System.out.println("append");
		//productList.add(p);
	}
	
	public void clearArea() {
		textArea.setText(null);
	}
	
/*	public void destroy() {

		this.setVisible(false);
		this.dispose();

	    System.exit(0); 
	} */
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Enter")) {
		//	System.out.println(textField.getText());
			data = textField.getText();
		//	System.out.println(data);
			textField.setText("");
		}
		else{
			textField.setText(textField.getText()+arg0.getActionCommand());
		}
	}

}
