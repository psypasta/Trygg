package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProductGroupPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ProductGroupPanel() {
		setLayout(null);
		
		JLabel lblProduktgrupp = new JLabel("Produktgrupp:");
		lblProduktgrupp.setBounds(10, 14, 70, 14);
		add(lblProduktgrupp);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(79, 11, 86, 20);
		add(textField);
		
		JLabel lblMoms = new JLabel("MOMS:");
		lblMoms.setBounds(10, 39, 46, 14);
		add(lblMoms);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(79, 36, 140, 20);
		add(textField_1);
		
		JButton button = new JButton("Spara");
		button.setBounds(120, 179, 70, 23);
		add(button);
		
		JButton button_1 = new JButton("Ta bort");
		button_1.setBounds(200, 179, 70, 23);
		add(button_1);

	}

}
