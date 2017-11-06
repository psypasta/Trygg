package designPattern.factoryPattern;

import java.util.ArrayList;
import java.util.List;

public class FactoryPattern {
	
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		
		shape2.draw();
		
		Shape shape3 = shapeFactory.getShape("SQUARE");
		
		shape3.draw();
		// Kollar på detta sen!
		//List<Shape> shapeList = new ArrayList<Shape>();
		//Waiting for answers from Patrik
		//for(int i = 0; i < 100; i++) {
			
				
		//}
		
	}

}
