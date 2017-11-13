package view.admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductGroupPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ProductGroupPanel() {
		setLayout(null);
		
		JLabel lblProduktgrupp = new JLabel("Produktgrupp:");
		lblProduktgrupp.setBounds(10, 38, 70, 14);
		add(lblProduktgrupp);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(79, 35, 86, 20);
		add(textField);
		
		JLabel lblMoms = new JLabel("MOMS:");
		lblMoms.setBounds(10, 63, 46, 14);
		add(lblMoms);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(79, 60, 140, 20);
		add(textField_1);
		
		JButton button = new JButton("Spara");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(229, 246, 70, 23);
		add(button);
		
		JButton button_1 = new JButton("Ta bort");
		button_1.setBounds(309, 246, 70, 23);
		add(button_1);
		
		JLabel lblVarugrupp = new JLabel("Varugrupp");
		lblVarugrupp.setBounds(10, 11, 59, 14);
		add(lblVarugrupp);

	}

}
