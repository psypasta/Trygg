package view.admin;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ProductPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public ProductPanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(79, 35, 86, 20);
		add(textField);
		
		JLabel label = new JLabel("ID:");
		label.setBounds(10, 38, 46, 14);
		add(label);
		
		JLabel lblVara = new JLabel("Vara:");
		lblVara.setBounds(10, 63, 46, 14);
		add(lblVara);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(79, 60, 140, 20);
		add(textField_1);
		
		JLabel lblProduktgrupp = new JLabel("Produktgrupp:");
		lblProduktgrupp.setBounds(10, 88, 70, 14);
		add(lblProduktgrupp);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(79, 85, 140, 20);
		add(textField_2);
		
		JLabel lblPris = new JLabel("Pris:");
		lblPris.setBounds(10, 113, 46, 14);
		add(lblPris);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(79, 110, 86, 20);
		add(textField_3);
		
		JButton btnSpara = new JButton("Spara");
		btnSpara.setBounds(229, 246, 70, 23);
		add(btnSpara);
		
		JButton btnTaBort = new JButton("Ta bort");
		btnTaBort.setBounds(309, 246, 70, 23);
		add(btnTaBort);
		
		JButton btnPrintEtikett = new JButton("Print Etikett");
		btnPrintEtikett.setBounds(10, 246, 89, 23);
		add(btnPrintEtikett);
		
		JLabel lblVara_1 = new JLabel("Vara");
		lblVara_1.setBounds(10, 11, 46, 14);
		add(lblVara_1);

	}

}
