package Assignment6.QUEEN;

import java.util.Scanner;

import myUtility.inputValidation;

public class NewQueen {
	Scanner scan = new Scanner(System.in);
	static int[][] matrixForQueen;
	static int size;

	public static void printMatrix() {
		for (int i = 0; i < matrixForQueen.length; i++) {
			for (int j = 0; j < matrixForQueen.length; j++) {
				if(matrixForQueen[i][j] == 1){
					System.out.print(" Q");
				}
				else{
					System.out.print(" _");
				}
			}
			System.out.println();
		}
	}

	public static boolean placeQueen(int row) {

		if (row == size) {
			printMatrix();
			return true;
		}
		int column;
		for (column = 0; column < size; column++) {
			if (isSafe(row, column)) {
				matrixForQueen[row][column] = 1;
				boolean checkNextRow = placeQueen(row+1);
				if (checkNextRow) {
					return true;
				}
				matrixForQueen[row][column] = 0;
			}
		}
		if (column == size) {
			return false;
		}

		return false;
	}

	public static boolean isSafe(int row, int column) {
		boolean safe = true;

		for (int i = 0; i<row; i++) {
			if (matrixForQueen[i][column] == 1) {
				safe = false;
				break;
			}
		}

		if (safe) {
			for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
				if (matrixForQueen[i][j] == 1) {
					safe = false;
					break;
				}
			}
		}
		
		if (safe) {
			for(int i=row, j=column; i>=0 && j<size ;i--,j++){
				if (matrixForQueen[i][j] == 1) {
					safe = false;
					break;
				}
			}
		}

		return safe;
	}

	public static void main(String args[]) {
		int choice;
		do {
			System.out.println("1. Queens problem\n");
			System.out.println("2. Exit\n");
			System.out.println("Enter the index of operation you want to perform\n");
			choice = inputValidation.isIntInRange(1, 2);

			switch (choice) {

			case 1:
				System.out.println("Enter the number of queens");
				size = inputValidation.isPositiveInt();

				matrixForQueen = new int[size][size];
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						matrixForQueen[i][j] = 0;
					}
				}

				boolean isPossible = placeQueen(0);
				if (!isPossible) {
					System.out.println("Not possible.");
				}
				break;

			case 2:
				System.exit(0);
				break;

			}

		} while (choice != 2);

	}
}