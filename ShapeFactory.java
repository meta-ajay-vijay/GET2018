/**
 * 
 */
package Factory;

import Shapes.*;
import Basic.ShapeInterface;
import Basic.ShapeInterface.ShapeType;
import Point.Point;
import java.util.List;

/**
 * @author User1
 *
 */
public class ShapeFactory {

	public static ShapeInterface shapeCreator(ShapeType typeOfShape, Point origin, List<Integer> parameters) {
		ShapeInterface toReturn = null;

		switch (typeOfShape) {
		case CIRCLE:
			toReturn = new Circle(origin, parameters);
			break;
		case RECTANGLE:
			toReturn = new Rectangle(origin, parameters);
			break;
		case REGULARPOLYGON:
			toReturn = new RegularPolygon(origin, parameters);
			break;
		case SQUARE:
			toReturn = new Square(origin, parameters);
			break;
		case TRIANGLE:
			toReturn = new Triangle(origin, parameters);
			break;
		default:
			break;
		}

		return toReturn;
	}
}
