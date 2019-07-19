package marksheet;

public class Student {
	/**
	 * This method calculates the total average grades of all Students
	 * @param gradesOfStudent contains the grades of all the students
	 * @return the total average grade obtained by the students
	 */
	public float averageOfAll(float gradesOfStudent[]) {
		float sum = 0;
		for (int i = 0; i < gradesOfStudent.length; i++) {
			sum += gradesOfStudent[i];
		}
		return (sum / gradesOfStudent.length); // returning average of number
	}

	/**
	 * This method calculates the maximum grade obtained
	 * @param gradesOfStudent contains the grades of all the students
	 * @return float value having the maximum grade out of all grades
	 */
	public float maximumOfAllGrades(float gradesOfStudent[]) {
		float maximumGrade = 0;
		for (int j = 0; j < gradesOfStudent.length; j++) {
			if (gradesOfStudent[j] > maximumGrade) { // comparing to find maximum number for grade
				maximumGrade = gradesOfStudent[j];
			}
		}
		return maximumGrade;
	}

	/**
	 * This method calculates the minimum grade obtained
	 * @param gradesOfStudent contains the grades of all the students
	 * @return float value having the minimum grade value
	 */
	public float minimumOfAllGrades(float gradesOfStudent[]) {
		float minimumGrade = 100;
		for (int k = 0; k < gradesOfStudent.length; k++) {
			if (gradesOfStudent[k] < minimumGrade) { // comparing to find minimum number for grade
				minimumGrade = gradesOfStudent[k];
			}
		}
		return minimumGrade;
	}

	/**
	 * This method calculates the total percentage of students passed
	 * @param gradesOfStudent contains the grades of all the students
	 * @return the float value containing percentage of passes students
	 */
	public float percentageStudentsPassed(float gradesOfStudent[]) {
		int passedStudents = 0;
		for (int i = 0; i < gradesOfStudent.length; i++) {
			if (gradesOfStudent[i] >= 40) { // to get passed number
				passedStudents++;
			}
		}
		return ((float) passedStudents / (float) gradesOfStudent.length) * 100; // returning percentage by type casting into float
	}
}
