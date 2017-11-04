package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private JTextField txtUsername;
	private JTextField textField;

	private volatile boolean login = false;
	
	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(100, 100, 86, 20);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(100, 75, 55, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(100, 131, 46, 14);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(100, 156, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(100, 187, 89, 23);
		add(btnLogin);
		
		 btnLogin.addActionListener(new ButtonListener());

	}
	
	public boolean getLogin() {
		return login;
	}
	
	private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            login = true;
            System.out.println(command + " " + login);
        }
    }
}
