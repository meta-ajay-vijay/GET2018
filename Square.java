package Shapes;

import Basic.ShapeInterface;
import Point.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * @author User1
 *
 */
public class Square implements ShapeInterface {
	int width;
	Point origin;
	List<Point> corners = new ArrayList<Point>();

	/**
	 * 
	 * @param origin
	 * @param parameter
	 */
	public Square(Point origin, List<Integer> parameter) {
		this.width = parameter.get(0).intValue();
		this.origin = origin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getArea()
	 */
	@Override
	public double getArea() {
		return (this.width * this.width);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getperimeter()
	 */
	@Override
	public float getperimeter() {
		return (4 * this.width);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#getOrigin()
	 */
	@Override
	public Point getOrigin() {
		return this.origin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Basic.ShapeInterface#isPointEnclosed()
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		boolean flag = true;
		float xCoordinate = point.getxCoordinate();
        float yCoordinate = point.getyCoordinate();

        float x1 = this.origin.xCoordinate;
        float y1 = this.origin.yCoordinate;

        float x2 = x1;
        float y2 = y1 + this.width;

        float x3 = x1 + this.width;
        float y3 = y2;

        float x4 = x1 + this.width;
        float y4 = y1;

        if ((xCoordinate < x1 && yCoordinate < y1)
                && (xCoordinate < x2 && yCoordinate < y2)
                && (xCoordinate < x3 && yCoordinate < y3)
                && (xCoordinate < x4 && yCoordinate < y4)) {

            flag = false;
        }
        if ((xCoordinate > x1 && yCoordinate > y1)
                && (xCoordinate > x2 && yCoordinate > y2)
                && (xCoordinate > x3 && yCoordinate > y3)
                && (xCoordinate > x4 && yCoordinate > y4)) {

            flag = false;
        }

        return flag;
	}

	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return ShapeType.SQUARE;
	}
}
