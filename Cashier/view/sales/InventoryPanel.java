package view.sales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class InventoryPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtAntal;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public InventoryPanel() {
		setLayout(null);
		
		JLabel lblVara = new JLabel("Vara:");
		lblVara.setBounds(10, 30, 46, 14);
		add(lblVara);
		
		JLabel lblDatum = new JLabel("Lagerstatus:");
		lblDatum.setBounds(10, 55, 61, 14);
		add(lblDatum);
		
		JLabel lblDatum_1 = new JLabel("Best\u00E4llningspunkt:");
		lblDatum_1.setBounds(10, 80, 97, 14);
		add(lblDatum_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(97, 27, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(97, 52, 86, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 77, 86, 20);
		add(textField_2);
		
		JButton btnNewButton = new JButton("Best\u00E4ll");
		btnNewButton.setBounds(10, 182, 89, 23);
		add(btnNewButton);
		
		JCheckBox chckbxBestllAutomatiskt = new JCheckBox("Best\u00E4ll Automatiskt");
		chckbxBestllAutomatiskt.setBounds(10, 121, 117, 23);
		add(chckbxBestllAutomatiskt);
		
		txtAntal = new JTextField();
		txtAntal.setText("Antal");
		txtAntal.setToolTipText("");
		txtAntal.setBounds(109, 183, 86, 20);
		add(txtAntal);
		txtAntal.setColumns(10);
		
		JLabel lblMoms = new JLabel("Moms:");
		lblMoms.setBounds(193, 83, 46, 14);
		add(lblMoms);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(280, 80, 86, 20);
		add(textField_3);
		
		JLabel lblInkpsPris = new JLabel("In pris:");
		lblInkpsPris.setBounds(193, 30, 77, 14);
		add(lblInkpsPris);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(280, 30, 86, 20);
		add(textField_4);
		
		JLabel lblSljPris = new JLabel("Ut pris:");
		lblSljPris.setBounds(193, 55, 77, 14);
		add(lblSljPris);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(280, 55, 86, 20);
		add(textField_5);

	}
}
