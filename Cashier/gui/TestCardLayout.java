package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestCardLayout {

    LoginPanel login = new LoginPanel();
    RegisterPanel register = new RegisterPanel();
    SalesPanel sales = new SalesPanel();

    CardLayout layout = new CardLayout();
    JPanel cardPanel = new JPanel(layout);

    public TestCardLayout() {
        JButton showOne = new JButton("Show One");
        JButton showTwo = new JButton("Show Two");
        JButton showThree = new JButton("Show Trree");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(showOne);
        buttonsPanel.add(showTwo);
        buttonsPanel.add(showThree);
        showOne.addActionListener(new ButtonListener());
        showTwo.addActionListener(new ButtonListener());
        showThree.addActionListener(new ButtonListener());
        
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

    private class ButtonListener implements ActionListener {
//big time derps going down
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if ("Show One".equals(command)) {
                layout.show(cardPanel, "login");
            } else if ("Show Two".equals(command)) {
                layout.show(cardPanel, "register");
            } else {
                layout.show(cardPanel, "sales");
            }
            System.out.println(login.getLogin());
        /*    if(login.getLogin()) {
            	layout.show(cardPanel, "panel 2");
            } */
        }
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