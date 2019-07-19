package marksheet;
import java.util.*;
public class Marksheet {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Student object = new Student();
		int numberOfStudents = 0;
		try {
			System.out.println("Enter the total number of students ");
			numberOfStudents = input.nextInt();
			if (numberOfStudents <= 0) {
				throw new Exception("Invalid input Entered !! ");
			}
			float gradesOfStudent[] = new float[numberOfStudents];
			System.out.println("Enter the grades of " + numberOfStudents + " students between 0 to 100 ");
			for (int i = 0; i < numberOfStudents; i++) {
				gradesOfStudent[i] = input.nextFloat();
				if (gradesOfStudent[i] < 0 || gradesOfStudent[i] > 100) {
					throw new Exception("Invalid input Entered !! ");
				}
			}
			System.out.printf("The average of all the grades is %.2f",object.averageOfAll(gradesOfStudent));
			System.out.println();
			System.out.printf("The maximum grade out of all the grades is %.2f",object.maximumOfAllGrades(gradesOfStudent));
			System.out.println();
			System.out.printf("The minimum grade out of all the grades is %.2f",object.minimumOfAllGrades(gradesOfStudent));
			System.out.println();
			System.out.printf("The percentage of students passed is %.2f",object.percentageStudentsPassed(gradesOfStudent));
			System.out.println(" %");
		} catch (Exception e) {
			System.out.println("Invalid input entered !! Try Again ");
			main(args);
		}
	}
}
