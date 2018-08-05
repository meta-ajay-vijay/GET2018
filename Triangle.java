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
public class Triangle implements ShapeInterface {

	int side1, side2, side3;
	Point origin;

	public Triangle(Point origin, List<Integer> parameter) {
		this.side1 = parameter.get(0).intValue();
		this.side2 = parameter.get(1).intValue();
		this.side3 = parameter.get(2).intValue();
		origin = new Point(origin.xCoordinate, origin.yCoordinate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getArea()
	 */
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		float s = (this.side1 + this.side2 + this.side3) / 3;

		return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getperimeter()
	 */
	@Override
	public float getperimeter() {
		// TODO Auto-generated method stub
		return (this.side1 + this.side2 + this.side3);
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
		return null;
	}

}
