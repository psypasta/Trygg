
package gfx;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {
	
	List<TestTile> column = new ArrayList<TestTile>();
	List<Rectangle2D> column2 = new ArrayList<Rectangle2D>();
	double columnX = 0;
	double columnY = 0;
	double offset = 25;
	int tileAmount = 420;
	
    private void doDrawing(Graphics g) {
    	
        Graphics2D g2d = (Graphics2D) g;
/*   
		g2d.drawString("Java 2D", 75, 50);
        g2d.draw(new Line2D.Double(0.0, 100.0, 100.0, 0.0));
        g2d.draw(new Line2D.Double(100.0, 0.0, 200.0, 100.0));
        g2d.draw(new Line2D.Double(200.0, 100.0, 100.0, 200.0));
        g2d.draw(new Line2D.Double(100.0, 200.0, 0.0, 100.0));
        
*/
        for(int i = 0; i < column.size(); i++) {
        	if(i == 6) {
        		g2d.setColor(Color.RED);
        	}else if(i == 12){
        		g2d.setColor(Color.GREEN);
        	}else if(i == 18) {
        		g2d.setColor(Color.BLUE);
        	}else if(i == 24) {
        		g2d.setColor(Color.BLACK);
        	}
        	g2d.draw(column2.get(i));
        	column.get(i).paint(g2d);
        }
    }

    public void initTest(double width, double height) {
		for (int i = 0; i < tileAmount; i++) {
			
			if(columnX > width) {
		    	columnY = columnY + offset;
		    	columnX = 0;
		    }
			column2.add(new Rectangle2D.Double(columnX,columnY,offset,offset));
			TestTile tile = new TestTile(columnX, columnY, offset, offset);
		    column.add(tile);
		    columnX = columnX + offset;
		}
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class runTest extends JFrame {

	private int windowWidth = 517, windowHeight = 540;
	
    public runTest() {

        initUI();
    }

    private void initUI() {

    	Surface s = new Surface();
        add(s);

        s.initTest(windowWidth, windowHeight);
        
        setTitle("Java 2D");
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
            	runTest ex = new runTest();
                ex.setVisible(true);
            }
        });
    }
}