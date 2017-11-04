package gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminPanel() {
        add(new JLabel("Admin"));
	}
  
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

}
