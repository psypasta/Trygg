package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

class PanelOne extends JPanel {

    public PanelOne() {
        setBackground(Color.GREEN);
        add(new JLabel("Panel one"));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}