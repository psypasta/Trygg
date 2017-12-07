package gfx;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class TestTile {
	
	private double tileCoordX = 0;
	private double tileCoordY = 0;
	
	private double tileWidth = 0;
	private double tileHeight = 0;
	
	private Line2D line;
	private Point2D.Double top;
	private Point2D.Double right;
	private Point2D.Double bottom;
	private Point2D.Double left;
	
	public TestTile(double x, double y, double w, double h) {
		
		this.tileCoordX = x;
		this.tileCoordY = y;
		this.tileWidth = w;
		this.tileHeight = h;
		
		
		top = new Point2D.Double(0, 0);
		right = new Point2D.Double(w / 2, h / 2);
		bottom = new Point2D.Double(0 , h);
		left = new Point2D.Double(-w / 2, h / 2);

	//	line = makeLine(makePoint(250.0, 0.0), makePoint(200.0, 200.0));
	//	System.out.println("Start " + line.getP1());
	//	System.out.println("End " + line.getP2());
	}
	
	public void paint (Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
    
    	Line2D line1 = new Line2D.Double(top, right);
    	Line2D line2 = new Line2D.Double(right, bottom);
    	Line2D line3 = new Line2D.Double(bottom, left);
    	Line2D line4 = new Line2D.Double(left, top);
    	

    	g2.translate(tileCoordX, tileCoordY);
    	
    	g2.draw(line1);
    	g2.draw(line2);
    	g2.draw(line3);
    	g2.draw(line4);
    	
    	g2.translate(-tileCoordX, -tileCoordY);
	    
	}
	
	private Line2D makeLine(Point2D startPoint, Point2D endPoint) {
		Line2D line = new Line2D.Double();
		line.setLine(startPoint, endPoint);
		
		return line;
	}
	
	private Point2D makePoint(double x, double y) {
		Point2D.Double point = new Point2D.Double();
		point.setLocation(x, y);
		
		return point;
	}
	
/*
	public void setCoords(double x, double y) {
		this.tileCoordX = x;
		this.tileCoordY = y;
	}
	
	public void setDimension(double w, double h) {
		this.tileHeight = h;
		this.tileWidth = w;
	}
*/	

}
