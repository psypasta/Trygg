package gfx.timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import jdk.nashorn.internal.runtime.ECMAErrors;

public class Board extends JPanel 
        implements ActionListener, KeyListener {

    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 1;

    private Rectangle2D testRect;
    private int rectX, rectY;
    
    
    private Image star;
    private Timer timer;
    private int x, y;

    public Board() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("resource/star.png");
        star = ii.getImage();
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);

        testRect = new Rectangle2D.Double(100, 100, 100, 100);
        
        loadImage();
        
        x = INITIAL_X;
        y = INITIAL_Y;
        
        rectX = INITIAL_X;
        rectY = INITIAL_Y;
        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawRect(g);
        drawStar(g);
    }

    private void drawStar(Graphics g) {

        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawRect(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
    	g2.translate(rectX, rectY);
    	g2.rotate(0.785398163);
    	
    	g2.draw(testRect);
    	g2.fill(testRect);
    	g2.translate(-rectX, -rectY);
    	g2.rotate(-0.785398163);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        x += 1;
        y += 1;

        if (y > B_HEIGHT) {

            y = INITIAL_Y;
            x = INITIAL_X;
        }

        repaint();
    }

	@Override
	public void keyPressed(KeyEvent e) {
		if('w' == e.getKeyChar()){
			rectY -= 10;
		}
		else if('a' == e.getKeyChar()) {
			rectX -= 10;
		}		
		else if('s' == e.getKeyChar()) {
			rectY += 10;
		}
		else if('d' == e.getKeyChar()) {
			rectX += 10;
		}
        repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}