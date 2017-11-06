package designPattern.AbstractFactory;

import designPattern.factoryPattern.Shape;

public abstract class AbstractFactory {
	abstract Color getColor(String color);
	abstract Shape getShape(String Shape);
	

}
