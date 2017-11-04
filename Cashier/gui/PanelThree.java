package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

class PanelThree extends JPanel {

    public PanelThree() {
        setBackground(Color.YELLOW);
        add(new JLabel("Panel three"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}