package Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Basic.ShapeInterface;
import Basic.ShapeInterface.ShapeType;
import Basic.ShapeWithTimeStamp;
import utility.inputValidation;
import Factory.ShapeFactory;
import Point.Point;

/**
 * @author ajay
 * 
 *         this class creates a virtual screen
 */
public class Screen {
	static Scanner scan = new Scanner(System.in);
	List<ShapeWithTimeStamp> listOfAllShapes = new ArrayList<ShapeWithTimeStamp>();
	final int xLimit, yLimit;

	public Screen(int xLimit, int yLimit) {
		this.xLimit = xLimit;
		this.yLimit = yLimit;
	}

	/**
	 * Add shape to the screen
	 */
	public void addShape(Screen currentScreen) {
		int choiceOfShape;

		// Shapes available to add on screen
		System.out.println("\n1. Square");
		System.out.println("2. Rectangle");
		System.out.println("3. Circle");
		System.out.println("4. Triangle");
		System.out.println("5. Regular Polygon");
		System.out.println("6. Exit");
		System.out.println("\nPlease select the index of the shape you want to add to the screen");
		choiceOfShape = inputValidation.isIntInRange(1, 6);
		int xOrigin; // x coordinate of the origin of shape
		int yOrigin; // y coordinate of the origin of shape

		int length, width, radius, numberOfEdgesInPolygon;

		int side1OfTriangle, side2OfTriangle, side3OfTriangle; // Sides of the
																// triangle
		List<Integer> listOfParameters; // List to store parameters of the shape
		Point origin; // Store the origin point of the shape

		// Create shape based on the type of shape
		switch (choiceOfShape) {
		case 1:
			// take the origin of square in input from user
			System.out.println("Enter the x coordinate of origin of square");
			xOrigin = inputValidation.isIntInRange(1, currentScreen.xLimit);
			System.out.println("Enter the x coordinate of origin of square");
			yOrigin = inputValidation.isIntInRange(1, currentScreen.yLimit);
			origin = new Point(xOrigin, yOrigin);

			// take other parameters required for square in input from user
			listOfParameters = new ArrayList<Integer>();
			System.out.println("Enter the width of square");
			width = inputValidation.isPositiveInt();
			listOfParameters.add(new Integer(width));

			// Create square object
			ShapeInterface squareObject = ShapeFactory.shapeCreator(ShapeType.SQUARE, origin, listOfParameters);
			ShapeWithTimeStamp squareFinalObject = new ShapeWithTimeStamp(ShapeType.SQUARE, squareObject);
			listOfAllShapes.add(squareFinalObject);
			break;

		case 2:
			// take the origin of rectangle in input from user
			System.out.println("Enter the x coordinate of origin of rectangle");
			xOrigin = inputValidation.isPositiveInt();
			System.out.println("Enter the x coordinate of origin of rectangle");
			yOrigin = inputValidation.isPositiveInt();
			origin = new Point(xOrigin, yOrigin);

			// take other parameters required for rectangle in input from user
			listOfParameters = new ArrayList<Integer>();
			System.out.println("Enter the length of rectangle");
			length = inputValidation.isPositiveInt();
			System.out.println("Enter the width of rectangle");
			width = inputValidation.isPositiveInt();
			listOfParameters.add(new Integer(length));
			listOfParameters.add(new Integer(width));

			// Create rectangle object
			ShapeInterface rectangleObject = ShapeFactory.shapeCreator(ShapeType.RECTANGLE, origin, listOfParameters);
			ShapeWithTimeStamp rectangleFinalObject = new ShapeWithTimeStamp(ShapeType.RECTANGLE, rectangleObject);
			listOfAllShapes.add(rectangleFinalObject);
			break;

		case 3:
			// take the origin of circle in input from user
			System.out.println("Enter the x coordinate of origin of circle");
			xOrigin = inputValidation.isPositiveInt();
			System.out.println("Enter the x coordinate of origin of circle");
			yOrigin = inputValidation.isPositiveInt();
			origin = new Point(xOrigin, yOrigin);

			// take other parameters required for circle in input from user
			listOfParameters = new ArrayList<Integer>();
			System.out.println("Enter the radius of the circle");
			radius = inputValidation.isPositiveInt();
			listOfParameters.add(new Integer(radius));

			// Create circle object
			ShapeInterface circleObject = ShapeFactory.shapeCreator(ShapeType.CIRCLE, origin, listOfParameters);
			ShapeWithTimeStamp circleFinalObject = new ShapeWithTimeStamp(ShapeType.CIRCLE, circleObject);
			listOfAllShapes.add(circleFinalObject);
			break;

		case 4:
			// take the origin of triangle in input from user
			System.out.println("Enter the x coordinate of origin of triangle");
			xOrigin = inputValidation.isPositiveInt();
			System.out.println("Enter the x coordinate of origin of triangle");
			yOrigin = inputValidation.isPositiveInt();
			origin = new Point(xOrigin, yOrigin);

			// take other parameters required for triangle in input from user
			listOfParameters = new ArrayList<Integer>();
			System.out.println("Enter the size of one side of triangle");
			side1OfTriangle = inputValidation.isPositiveInt();
			System.out.println("Enter the size of second side of triangle");
			side2OfTriangle = inputValidation.isPositiveInt();
			System.out.println("Enter the size of third side of triangle");
			side3OfTriangle = inputValidation.isPositiveInt();
			listOfParameters.add(new Integer(side1OfTriangle));
			listOfParameters.add(new Integer(side2OfTriangle));
			listOfParameters.add(new Integer(side3OfTriangle));

			// Create triangle object
			ShapeInterface triangleObject = ShapeFactory.shapeCreator(ShapeType.TRIANGLE, origin, listOfParameters);
			ShapeWithTimeStamp triangleFinalObject = new ShapeWithTimeStamp(ShapeType.TRIANGLE, triangleObject);
			listOfAllShapes.add(triangleFinalObject);
			break;

		case 5:
			// take the origin of regular polygon in input from user
			System.out.println("Enter the x coordinate of origin of polygon");
			xOrigin = inputValidation.isPositiveInt();
			System.out.println("Enter the x coordinate of origin of polygon");
			yOrigin = inputValidation.isPositiveInt();
			origin = new Point(xOrigin, yOrigin);

			// take other parameters required for regular polygon in input from
			// user
			listOfParameters = new ArrayList<Integer>();
			System.out.println("Enter the size of side");
			width = inputValidation.isPositiveInt();
			System.out.println("Number of edges");
			numberOfEdgesInPolygon = inputValidation.isPositiveInt();
			listOfParameters.add(new Integer(width));
			listOfParameters.add(new Integer(numberOfEdgesInPolygon));

			// Create regular polygon object
			ShapeInterface regularPolygonObject = ShapeFactory.shapeCreator(ShapeType.REGULARPOLYGON, origin,
					listOfParameters);
			ShapeWithTimeStamp regularPolygonFinalObject = new ShapeWithTimeStamp(ShapeType.REGULARPOLYGON,
					regularPolygonObject);
			listOfAllShapes.add(regularPolygonFinalObject);
			break;

		case 6:
			return;
		}
	}

	/**
	 * remove shape from the screen given in parameter
	 * 
	 * @param screenFromWhereWeWantToRemoveShape
	 * @return
	 */
	public boolean removeShape(Screen screenFromWhereWeWantToRemoveShape) {
		boolean flag = true;
		System.out.println("All shaes available on the screen:");
		screenFromWhereWeWantToRemoveShape.showAllShapes();
		System.out.println((listOfAllShapes.size() + 1) + "\tI don't want to remove anything");
		System.out.println("Please select the index of shape you want to remove from screen");
		int indexOfShapeUserWantToRemove = inputValidation.isIntInRange(1, listOfAllShapes.size() + 1);
		if (indexOfShapeUserWantToRemove == (listOfAllShapes.size() + 1)) {
			flag = false;
		}
		if (flag) {
			listOfAllShapes.remove(indexOfShapeUserWantToRemove - 1);
		}

		return flag;
	}

	public boolean removeAllShapesOfAType(Screen screenFromWhereWeWantToRemoveShape, ShapeType typeOfShapeUserWantToRemove) {
		boolean flag = true;
		
		return flag;
	}

	
	
	/**
	 * method displays all the shapes added to the screen
	 */
	@SuppressWarnings("deprecation")
	public void showAllShapes() {
		System.out.println("Index\tShape Type\tOrigin Point\tCreated on");
		for (int i = 0; i < listOfAllShapes.size(); i++) {
			System.out.println((i + 1) + "\t" + this.listOfAllShapes.get(i).getShapeType().getShapeName() + "\t("
					+ this.listOfAllShapes.get(i).getShape().getOrigin().getxCoordinate() + ", "
					+ this.listOfAllShapes.get(i).getShape().getOrigin().getyCoordinate() + ")\t"
					+ this.listOfAllShapes.get(i).getDate());
		}
	}

	public static void main(String[] args) {
		System.out.println("WELCOME TO THE WORLD OF SHAPES");
		System.out.println("Please enter the width of Screen");
		int x = inputValidation.isPositiveInt();
		System.out.println("Please enter the heigth of Screen");
		int y = inputValidation.isPositiveInt();
		Screen newScreen = new Screen(x, y);
		int choice;
		// Display the all operation that can be performed on screen
		do {
			System.out.println("1. Add shape to the screen");
			System.out.println("2. Remove shape from the screen");
			System.out.println("3. Remove all shapes of a particular type from the screen");
			System.out.println("4. Show a sorted list of shapes based on their areas");
			System.out.println("5. Show a sorted list of shapes based on their Perimeter");
			System.out.println("6. List of all shapes on screen");
			System.out.println("7. Exit");
			System.out.println("\n Please enter the index of operation you want to perform...");
			choice = inputValidation.isIntInRange(1, 6);

			switch (choice) {
			case 1:
				newScreen.addShape(newScreen);
				break;

			case 2:
				// checks if the screen has any shape or not, if has shapes on
				// screen then display the shapes user can remove

				if (newScreen.listOfAllShapes.size() > 0) {
					boolean isremoved = newScreen.removeShape(newScreen);
					if (isremoved) {
						System.out.println("Shape removed.");
					}
				} else {
					System.out.println("You do not have any shape on your screen");
				}
				break;

			case 3:

				if (newScreen.listOfAllShapes.size() > 0) {
					System.out.println("\n1. Square");
					System.out.println("2. Rectangle");
					System.out.println("3. Circle");
					System.out.println("4. Triangle");
					System.out.println("5. Regular Polygon");
					System.out.println("6. I don't want to remove anything, take me to previous menu");
					System.out.println("\nPlease select the index of the shape you want to remove from screen");
					int indexOfTypeOfShapeUserWantToRemove = inputValidation.isIntInRange(1, 6);
					if(indexOfTypeOfShapeUserWantToRemove != 6){
						boolean isRemoved;
						switch(indexOfTypeOfShapeUserWantToRemove){
						case 1:
							isRemoved = newScreen.removeAllShapesOfAType(newScreen, ShapeType.SQUARE);
							break;
						case 2:
							isRemoved = newScreen.removeAllShapesOfAType(newScreen, ShapeType.RECTANGLE);
							break;
						case 3: 
							isRemoved = newScreen.removeAllShapesOfAType(newScreen, ShapeType.CIRCLE);
							break;
						case 4: 
							isRemoved = newScreen.removeAllShapesOfAType(newScreen, ShapeType.TRIANGLE);
							break;
						case 5: 
							isRemoved = newScreen.removeAllShapesOfAType(newScreen, ShapeType.REGULARPOLYGON);
							break;
						case 6: 
							
							break;
						}
						
					}
					
				} else {
					System.out.println("You do not have any shape on your screen");
				}
				break;

			case 4:
				break;

			case 5:
				break;

			case 6:
				newScreen.showAllShapes();
				break;

			case 7:
				System.exit(0);
				break;
			}

		} while (choice != 7);
	}
}
