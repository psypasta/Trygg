package designPattern.AbstractFactory;

import designPattern.factoryPattern.Circle;
import designPattern.factoryPattern.Rectangle;
import designPattern.factoryPattern.Shape;
import designPattern.factoryPattern.Square;

public class ColorFactory extends AbstractFactory{

	@Override
	Color getColor(String color) {
		if(color == null) {
			return null;
		}
		if(color.equalsIgnoreCase("RED")) {
			return new Red();
			
		}else if(color.equalsIgnoreCase("GREEN")) {
			return new Green();
			
		}else if(color.equalsIgnoreCase("BLUE")) {
			return new Blue();
			
		}
		return null;
	}

	@Override
	Shape getShape(String Shape) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
