/**
 * 
 */
package Shapes;

import Basic.ShapeInterface;
import Point.Point;
import java.util.List;

/**
 * @author User1
 *
 */
public class Circle implements ShapeInterface {

	float radius;
	Point origin;

	public Circle(Point origin, List<Integer> parameter) {
		this.radius = parameter.get(0).intValue();
		this.origin = origin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getArea()
	 */
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (Math.PI * Math.pow(this.radius, 2));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getperimeter()
	 */
	@Override
	public float getperimeter() {
		// TODO Auto-generated method stub
		return (2 * (float) Math.PI * this.radius);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getOrigin()
	 */
	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#isPointEnclosed()
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		// TODO Auto-generated method stub
		boolean reply = false;
		return reply;
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return ShapeType.CIRCLE;
	}

}
