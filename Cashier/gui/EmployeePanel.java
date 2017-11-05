package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EmployeePanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public EmployeePanel() {
		setLayout(null);
		
		JLabel lblNamn = new JLabel("ID:");
		lblNamn.setBounds(10, 38, 46, 14);
		add(lblNamn);
		
		JLabel lblNamn_1 = new JLabel("Förnamn:");
		lblNamn_1.setBounds(10, 63, 46, 14);
		add(lblNamn_1);
		
		JLabel lblWorkhours = new JLabel("Jobbtimmar:");
		lblWorkhours.setBounds(10, 168, 59, 14);
		add(lblWorkhours);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 60, 140, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(79, 35, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSpara = new JButton("Ta bort");
		btnSpara.setBounds(309, 246, 70, 23);
		add(btnSpara);
		
		JButton btnTaBort = new JButton("Spara");
		btnTaBort.setBounds(229, 246, 70, 23);
		add(btnTaBort);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(79, 165, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblEfternamn = new JLabel("Efternamn:");
		lblEfternamn.setBounds(10, 88, 59, 14);
		add(lblEfternamn);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setBounds(10, 113, 46, 14);
		add(lblAdress);
		
		textField_3 = new JTextField();
		textField_3.setBounds(79, 85, 140, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(79, 110, 140, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAnstllda = new JLabel("Anställd");
		lblAnstllda.setBounds(10, 11, 48, 14);
		add(lblAnstllda);

	}
}
