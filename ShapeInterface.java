package Basic;
/**
 * 
 */

import Point.Point;

/**
 * @author ajay
 *
 */
public interface ShapeInterface {
	public enum ShapeType {
		SQUARE("Square"), RECTANGLE("Rectangle"), CIRCLE("Circle"), TRIANGLE("Triangle"), REGULARPOLYGON(
				"Regular Polygon");

		String shapeName;

		ShapeType(String name) {
			this.shapeName = name;
		}

		/**
		 * @return the shapeName
		 */
		public String getShapeName() {
			return shapeName;
		}
	}

	/**
	 * Calculate area of shape
	 * 
	 * @return the area
	 */
	public double getArea();

	/**
	 * calculate Perimeter
	 * 
	 * @return the perimeter
	 */
	public float getperimeter();

	/**
	 * @return the origin
	 */
	public Point getOrigin();

	/**
	 * checks if the point is in screen or not.
	 * 
	 * @return true if point is in screen otherwise false
	 */
	public boolean isPointEnclosed(Point point);
	
	public ShapeType getShapeType();
}
