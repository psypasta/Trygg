package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

class PanelTwo extends JPanel {

    public PanelTwo() {
        setBackground(Color.BLUE);
        add(new JLabel("Panel two"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}