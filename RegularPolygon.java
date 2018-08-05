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
public class RegularPolygon implements ShapeInterface {

	int side, noOfEdges;
	Point origin;

	public RegularPolygon(Point origin, List<Integer> parameter) {
		this.side = parameter.get(0).intValue();
		this.noOfEdges = parameter.get(1).intValue();
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
		return getperimeter() * (this.side / (4 * Math.tan(180 / this.noOfEdges)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getperimeter()
	 */
	@Override
	public float getperimeter() {
		// TODO Auto-generated method stub
		return (this.noOfEdges * this.side);
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
