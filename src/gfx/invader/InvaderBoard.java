package gfx.invader;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;
public class InvaderBoard extends JPanel implements ActionListener {

    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int DELAY = 10;

    private Timer timer;
    
    private List<Invader> invaderList;
    private Player p;

    public InvaderBoard() {
        initBoard();
    }


    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);
        
        invaderList = invaderList = new ArrayList<Invader>();
        int xPlace = 0;
        for(int i = 0; i < 11; i++) {
        	invaderList.add(new Invader(xPlace, 10));
        	xPlace += 35;
        }
        p = new Player();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < invaderList.size(); i++) {
        	invaderList.get(i).render(g, this);
        }
        
        p.render(g, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

  //  	for(int i = 0; i < invaderList.size(); i++) {
    	 Random random = new Random();
         int i = random.nextInt(9 - 0 + 1) + 0;
    		invaderList.get(i).move();
  // 	}
    	
        repaint();
    }
}