package gfx.invader;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Player {
    private boolean init = true;
    
    private int x, y;
    	
	private Image invaderImg;

	public Player() {
    	System.out.println();
    	System.out.println();
    	
        loadImage();
	}

	private void loadImage() {
        ImageIcon ii = new ImageIcon("resource/player.png");
        invaderImg = ii.getImage();
    }
    
    public void render(Graphics g, InvaderBoard board) {

    	if(init) {
    		x = board.getBounds().width / 2;
    		y = board.getBounds().height - 50;
    		init = false;
    	}
    	
    	g.drawImage(invaderImg, x, y, board);
    	
		Toolkit.getDefaultToolkit().sync();
    }
 
}
