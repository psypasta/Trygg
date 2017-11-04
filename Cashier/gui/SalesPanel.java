package gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SalesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SalesPanel() {
        add(new JLabel("Sales"));
	}
  
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}
