package designPattern.AbstractFactory;

import designPattern.AbstractFactory.AbstractFactory;
import designPattern.AbstractFactory.Color;
import designPattern.factoryPattern.Circle;
import designPattern.factoryPattern.Rectangle;
import designPattern.factoryPattern.Shape;
import designPattern.factoryPattern.Square;

public class ShapeFactory extends AbstractFactory{

	@Override
	Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape getShape(String shapeType) {
			if(shapeType == null) {
				return null;
			}
			if(shapeType.equalsIgnoreCase("CIRCLE")) {
				return new Circle();
			}
			else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
				return new Rectangle();
			}
			else if(shapeType.equalsIgnoreCase("SQUARE")) {
				return new Square();
			}
			return null;
		
	
	}
	
	
	
}
