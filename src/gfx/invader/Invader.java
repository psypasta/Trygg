package gfx.invader;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Invader {

    private int x, y;
	private Image invaderImg;

	public Invader(int x, int y) {
		this.x = x;
		this.y = y;
		
		loadImage();
	}
	
	public void move() {
		this.y += 1
				;
	}
	
	private void loadImage() {
        ImageIcon ii = new ImageIcon("resource/invader3.png");
        invaderImg = ii.getImage();
    }
    
    public void render(Graphics g, InvaderBoard board) {
    	g.drawImage(invaderImg, x, y, board);
		Toolkit.getDefaultToolkit().sync();
    }
 
}
