package gfx.invader;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class TestInvader extends JFrame {

    public TestInvader() {
        
        initUI();
    }
    
    private void initUI() {
    	InvaderBoard b = new InvaderBoard();
        add(b);
        
        setResizable(false);
        pack();
        
     //   b.setFocusable(true);
    //    b.requestFocus();
     //   b.addKeyListener(b);
        
        setTitle("Invaders");
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new TestInvader();
                ex.setVisible(true);                
            }
        });
    }
}