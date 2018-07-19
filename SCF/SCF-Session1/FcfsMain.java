package Assignment3.Fcfs;

import myUtility.inputValidation;
import java.util.*;

class FcfsMain {

	public int arr[][];
	public final int COL_SIZE = 3;

	public void schedule(int arr[][]) {
		int size = arr.length;
		int completionTime[] = new int[size];
		int turnAroundTime[] = new int[size];
		int waitTime[] = new int[size];

		arr = sort(arr);
		display(arr);

		completionTime = calculateCompletionTime(arr, completionTime);
		System.out.println("Completion Time according to sorted Process");
		display(completionTime);

		turnAroundTime = calculateTurnAroundTime(arr, turnAroundTime,
				completionTime);
		System.out.println("Turn Around Time according to sorted Process");
		display(turnAroundTime);

		waitTime = calculateWaitTime(arr, waitTime, turnAroundTime);
		System.out.println("Wait Time according to sorted Process");
		display(waitTime);

		System.out.println("Max Wait Time of a Process "
				+ calculateMax(waitTime));
		System.out.println("Average Wait Time of all Process  "
				+ calculateAvg(waitTime));

	}

	public int[] calculateCompletionTime(int arr[][], int completionTime[]) {
		completionTime[0] = arr[0][COL_SIZE - 2] + arr[0][COL_SIZE - 1];
		for (int i = 1; i < arr.length; i++) {
			if (completionTime[i - 1] > arr[i][COL_SIZE - 2]) {
				completionTime[i] = completionTime[i - 1]
						+ arr[i][COL_SIZE - 1];
			} else {
				completionTime[i] = arr[i][COL_SIZE - 2] + arr[i][COL_SIZE - 1];
			}
		}
		return completionTime;
	}

	public int[] calculateTurnAroundTime(int arr[][], int turnAroundTime[],
			int completionTime[]) {

		for (int i = 0; i < arr.length; i++) {
			turnAroundTime[i] = completionTime[i] - arr[i][COL_SIZE - 2];
		}
		return turnAroundTime;
	}

	public int[] calculateWaitTime(int arr[][], int waitTime[],
			int turnAroundTime[]) {

		for (int i = 0; i < arr.length; i++) {
			waitTime[i] = turnAroundTime[i] - arr[i][COL_SIZE - 1];
		}
		return waitTime;
	}

	public float calculateAvg(int passedArray[]) {
		float sum = 0;
		for (int i = 0; i < passedArray.length; i++) {
			sum = sum + passedArray[i];
		}
		return (sum / (float) passedArray.length);
	}

	public int calculateMax(int passedArray[]) {
		int max = 0;
		for (int i = 0; i < passedArray.length; i++) {
			if (passedArray[i] > max) {
				max = passedArray[i];
			}
		}
		return max;
	}

	public int[][] sort(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i][1] > arr[j][1]) {
					int temp = arr[i][1];
					int temp2 = arr[i][0];
					int temp3 = arr[i][2];
					arr[i][1] = arr[j][1];
					arr[i][0] = arr[j][0];
					arr[i][2] = arr[j][2];
					arr[j][1] = temp;
					arr[j][0] = temp2;
					arr[j][2] = temp3;
				}
			}
		}
		return arr;
	}

	public void operation() {
		boolean flag = true;
		int size = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the total number of processes.");

		size = inputValidation.isPositiveInt();
		arr = new int[size][COL_SIZE];
		for (int i = 0; i < size; i++) {
			arr[i][0] = i + 1;
		}
		System.out
				.println(" The Scheduling computation will be done starting from second 0 .");
		for (int i = 0; i < size; i++) {
			System.out.println("Enter ARRIVAL time of  " + (i + 1)
					+ "  process.");
			for (int j = 1; j < COL_SIZE; j++) {
				if (j == 2) {
					System.out.println("Enter BURST time of  " + (i + 1)
							+ "   process.");
				}
				try {
					flag = true;
					arr[i][j] = scan.nextInt();
					if (arr[i][j] < 0) {
						System.out
								.println("Input can't be Interpreted. \n Please input values greater than 0.");
						j--;
					}
				} catch (Exception e) {
					System.out.println("Input can't be Interpreted.");
					j--;
				}

			}

		}

		display(arr);
		schedule(arr);
	}

	public void display(int passedArray[]) {
		System.out.println("--------");
		for (int i = 0; i < passedArray.length; i++) {
			System.out.println(" " + passedArray[i]);
		}
		System.out.println("--------");
	}

	public void display(int arr[][]) {
		System.out.println(" Process No.   Arrival Time   Burst Time");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("");
			for (int j = 0; j < COL_SIZE; j++) {
				System.out.print(" \t" + arr[i][j] + " \t");
			}
		}
		System.out.println("");
	}

	public static void main(String args[]) {
		FcfsMain schedular = new FcfsMain();
		Scanner scan = new Scanner(System.in);
		int userAction = 0;
		do {
			System.out.println("\t 1. Compute Job Scheduling FCFS Algorithm");
			System.out.println("\t 2. Exit.");

			System.out.println("");
			System.out.println("Choose the action you want to implement");

			userAction = inputValidation.isInt();

			if (userAction == 1) {
				schedular.operation();
			} else if (userAction != 2) {
				System.out
						.println("Please Enter a Correct Integer Value between 1 - 2");
			}
			else if(userAction==2){
				System.out.println("Bye! See you later.");
			}
		} while (userAction != 2);

	}

}