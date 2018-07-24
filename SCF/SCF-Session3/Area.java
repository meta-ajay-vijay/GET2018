package Assignment4;
import java.util.*;

import myUtility.inputValidation;

public class Area{
	
	private final double PI = 3.14;
	
	/**
	 * area of Triangle
	 * @param height
	 * @param width
	 * @return double value
	 */
	public double areaTriangle(double height, double width)
	{
		return (double)(0.5 * height *width);
	}
	
	/**
	 * Area of rectangle
	 * @param height
	 * @param width
	 * @return double value
	 */
	public double areaRectangle(double height, double width)
	{
		return (double)( height *width);
	}
	
	/**
	 * Area of Square
	 * @param width
	 * @return double
	 */
	public double areaSquare(double width)
	{
		return (double)(width *width);
	}
	
	/**
	 * Area of Circle
	 * @param radius
	 * @return double
	 */
	public double areaCircle(double radius)
	{
		return (double)(PI*radius*radius );
	}
	
	/**
	 * takes the input value.
	 * @param param
	 * @return validated input value in type double
	 */
	public double inputValue(String param)
	{	
		boolean flag =false;
		double input=-1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter The Value for "+param);
		do{
			try{
			input = scan.nextDouble();
			flag = false;
		}catch(Exception e){
			flag = true;
			System.out.println("\tEnter a valid numeric Index, Shown above");
			scan.next();
			}
		}while(flag);
		
		return input;
	}
	
	public static void main(String args[])
	{
	  Area area = new Area();
	  double firstValue,secondValue = 0;
	  double result=0;
	  int userAction = -1;
		do
		{
			System.out.println("\t1.Calculate area Of Triangle");
			System.out.println("\t2.Calculate area Of Rectangle");
			System.out.println("\t3.Calculate area Of Square");
			System.out.println("\t4.Calculate area Of Circle");
			System.out.println("\t5.Exit");
			
			Scanner scan = new Scanner(System.in);
			
			userAction = inputValidation.isIntInRange(1,5);
			
			
			switch(userAction)
			{
			case 1:
				System.out.println("To Calculate area Of Triangle");
				firstValue = area.inputValue("Height");
				secondValue = area.inputValue("Base");
				result = area.areaTriangle(firstValue,secondValue);
				break;
			
			case 2:
				System.out.println("To Calculate area Of Rectangle");
				firstValue = area.inputValue("Height");
				secondValue = area.inputValue("Base");
				result = area.areaRectangle(firstValue,secondValue);
				break;

			
			case 3:
				System.out.println("To Calculate area Of Square");
				firstValue = area.inputValue("Side");
				result = area.areaSquare(firstValue);
				break;

				
			
			case 4:
				System.out.println("To Calculate area Of Circle");
				firstValue = area.inputValue("Radius");
				result = area.areaTriangle(firstValue,secondValue);
				break;	
				
			case 5:
				System.out.println("Bye! See you later.");
				System.exit(0);
			
			}
		if(userAction!=5)
			System.out.println("Area " +result);
		
		}while(userAction!=5);
	}
}