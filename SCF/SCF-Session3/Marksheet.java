package Assignment4;
import java.util.*;

import myUtility.inputValidation;

class studentGradeInput{
	
	
}


public class Marksheet{
	ArrayList <studentGradeInput> marksheet = new <studentGradeInput>ArrayList ();
	
	/**public float averageOfAll()
	{
	}
	
	public float maximumOfAll()
	{
	}
	
	public float minimumOfAll()
	{
	}
	
	public float percetageOfPassedStudents()
	{
	}
	*/
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of students whose combined Marksheet is to be printed");
		int totalStudents =inputValidation.isPositiveInt();
		
		System.out.println("Total number of Students are  " +totalStudents);
		
		for(int i=0; i<totalStudents; i++)
		{
			
			System.out.println("Enter the name of the Student");
			
			String name = inputValidation.isName();
			int grade;
		    //flag = false;	
			System.out.println("Enter the grade of the Student");
			grade = inputValidation.isIntInRange(0,100);
			
		}
	}
}