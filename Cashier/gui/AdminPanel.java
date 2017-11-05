package gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.CardLayout;
import javax.swing.JSeparator;

public class AdminPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AdminPanel() {
        setLayout(null);
        JLabel label = new JLabel("Admin");
        label.setBounds(210, 5, 41, 14);
        add(label);
        
        JList list = new JList();
        list.setBounds(409, 36, 161, 333);
        add(list);
        
        JButton btnNewButton = new JButton("Anställda");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        btnNewButton.setBounds(10, 346, 89, 23);
        add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Vara");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setBounds(109, 346, 89, 23);
        add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Varugrupp");
        btnNewButton_2.setBounds(210, 346, 89, 23);
        add(btnNewButton_2);
        
        JLabel lblSk = new JLabel("Sök:");
        lblSk.setBounds(453, 11, 29, 14);
        add(lblSk);
        
        textField = new JTextField();
        textField.setBounds(484, 5, 86, 20);
        add(textField);
        textField.setColumns(10);
        
        JButton btnVlj = new JButton("Redigera");
        btnVlj.setBounds(310, 346, 89, 23);
        add(btnVlj);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 39, 389, 280);
        add(panel);
        panel.setLayout(new CardLayout(0, 0));
	}
  
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}
