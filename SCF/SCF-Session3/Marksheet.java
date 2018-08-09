package Assignment4;

import java.text.DecimalFormat;
import java.util.*;
import myUtility.inputValidation;

class Grades {
	public float gradeOfStudent;
	public String nameOfStudent;

	/**
	 * Constructor of class Grade
	 * 
	 * @param name
	 * @param grade
	 */
	public Grades(String name, float grade) {
		gradeOfStudent = grade;
		nameOfStudent = name;
	}
}

/*
 * ArrayList<Marksheet> marksheet = new <Marksheet>ArrayList();
 */

public class Marksheet {
	public ArrayList<Grades> marksheet = new ArrayList<Grades>();

	/**
	 * public float averageOfAll() /** Calculates average of student list
	 * 
	 * @return
	 */
	public float averageOfAll() {
		float sum = 0;
		for (int i = 0; i < marksheet.size(); i++) {
			sum = sum + marksheet.get(i).gradeOfStudent;
		}
		return sum;
	}

	/**
	 * Calculates maximum of student list
	 * 
	 * @return
	 */
	public float maximumOfAll() {
		float max = -1;
		for (int i = 0; i < marksheet.size(); i++) {
			if (marksheet.get(i).gradeOfStudent > max)
				max = marksheet.get(i).gradeOfStudent;
		}
		return max;
	}

	/**
	 * Calculates minimum of student list
	 * 
	 * @return
	 */
	public float minimumOfAll() {
		float min = marksheet.get(0).gradeOfStudent;
		for (int i = 1; i < marksheet.size(); i++) {
			if (marksheet.get(i).gradeOfStudent < min)
				min = marksheet.get(i).gradeOfStudent;
		}
		return min;
	}

	/**
	 * Calculates percetage of student list
	 * 
	 * @return
	 */
	public float percetageOfPassedStudents() {
		float sum = 0;
		for (int i = 0; i < marksheet.size(); i++) {
			if (marksheet.get(i).gradeOfStudent > 40) {
				sum++;
			}
		}
		return (float) (sum / marksheet.size()) * 100;

	}

	public void operation(int userAction) {
		float result = 0;

		switch (userAction) {
		case 1:
			result = averageOfAll();
			break;

		case 2:
			result = maximumOfAll();
			break;
		case 3:
			result = minimumOfAll();
			break;

		case 4:
			result = percetageOfPassedStudents();
			break;
		}
		if (userAction < 5) {
			DecimalFormat df = new DecimalFormat();
			df.setMinimumFractionDigits(2);
			df.setMaximumFractionDigits(2);

			System.out.println("Answer : " + df.format(result));
		}
	}

	public static void main(String args[]) {
		Marksheet report = new Marksheet();
		System.out.println("Enter the number of students whose combined Marksheet is to be printed");
		int totalStudents = inputValidation.isPositiveInt();
		System.out.println("Total number of Students are  " + totalStudents);

		for (int i = 0; i < totalStudents; i++) {

			System.out.println("Enter the name of the Student");

			String name = inputValidation.isName();
			int grade;
			// flag = false;
			System.out.println("Enter the grade of the Student");
			grade = inputValidation.isIntInRange(0, 100);

			Grades gradeStudent = new Grades(name, grade);
			report.marksheet.add(gradeStudent);
		}
		int userAction;
		do {
			System.out.println("\t 1. Average of Grades ");
			System.out.println("\t 2. maximum Grades ");
			System.out.println("\t 3. minimum Grades ");
			System.out.println("\t 4. % of passed students ");
			System.out.println("\t 5. Exit ");

			userAction = inputValidation.isIntInRange(1, 5);
			report.operation(userAction);
		} while (userAction != 5);
	}

}
