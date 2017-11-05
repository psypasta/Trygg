package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ReportPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReportPanel() {
		setLayout(null);
		
		JTextArea txtrTest = new JTextArea();
		txtrTest.setEditable(false);
		txtrTest.setBounds(10, 11, 369, 245);
		add(txtrTest);

	}
}
