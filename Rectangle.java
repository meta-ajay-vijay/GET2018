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
public class Rectangle implements ShapeInterface {

	int width, length;
	Point origin;

	public Rectangle(Point origin, List<Integer> parameter) {
		this.width = parameter.get(0).intValue();
		this.length = parameter.get(1).intValue();
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
		return (this.width * this.length);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getperimeter()
	 */
	@Override
	public float getperimeter() {
		// TODO Auto-generated method stub
		return (2 * this.length + 2 * this.width);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getOrigin()
	 */
	@Override
	public Point getOrigin() {
		// TODO Auto-generated method stub
		return origin;
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
		return ShapeType.RECTANGLE;
	}

}
