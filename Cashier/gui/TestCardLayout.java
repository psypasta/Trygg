package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestCardLayout implements ActionListener{

//	private static ActionListener listener = new Listener();
	
    private LoginPanel login = new LoginPanel(this);
    private RegisterPanel register = new RegisterPanel();
    private SalesPanel sales = new SalesPanel();

    private CardLayout layout = new CardLayout();
    private JPanel cardPanel = new JPanel(layout);
    
    private boolean boolLogin = false;

    public TestCardLayout() {
        JButton showOne = new JButton("Show One");
        JButton showTwo = new JButton("Show Two");
        JButton showThree = new JButton("Show Three");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(showOne);
        buttonsPanel.add(showTwo);
        buttonsPanel.add(showThree);
        showOne.addActionListener(this);
        showTwo.addActionListener(this);
        showThree.addActionListener(this);
        
        cardPanel.add(login, "login");
        cardPanel.add(register, "register");
        cardPanel.add(sales, "sales");

        JFrame frame = new JFrame("Test Card");
        frame.setResizable(false);
		frame.setBounds(100, 100, 580, 450);
		
        frame.add(cardPanel);
        frame.add(buttonsPanel, BorderLayout.SOUTH);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //   frame.pack(); automatically sets the size of windows according to components use setSize/setBounds OR pack
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		   String command = e.getActionCommand();
           if ("Show One".equals(command)) {
               layout.show(cardPanel, "login");
           } else if ("Show Two".equals(command)) {
               layout.show(cardPanel, "register");
           } else {
               layout.show(cardPanel, "sales");
           }
        //   System.out.println(login.getLogin());
           System.out.println(boolLogin);
           if(command.equals("Login")) {	
	           	
	           	boolLogin = true;
	           	System.out.println(boolLogin);
	           	layout.show(cardPanel, "register");
           } /*else(command.equals("Logout")){
        	   boolLogin = false;
        	   layout.show(cardPanel, "login");
           }*/
	}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestCardLayout testCardLayout = new TestCardLayout();
            }
        });
    }

}