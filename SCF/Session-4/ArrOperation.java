package Assignment5;

import java.util.*;

class ArrOperation {

	/**
	 * This function calculates the max size of the mirror section that exist in
	 * a passed "non negative integer" array. Array should not be empty.
	 *
	 * @param non
	 *            negative integer array
	 * @return max size of the mirror section.
	 */
	public int mirrorSection(int arr[]) {

		int arrayLength = arr.length;
		try {
			if (arrayLength == 0) {
				throw new Exception("Array size is null.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int maxMirror = 0;

		for (int i = 0; i <= arrayLength - 2; i++) {
			int j = arrayLength - 1;
			int k = i;
			int tempMaxMirror = 0;
			for (; ((j - k) > 1); j--) {
				if (arr[k] == arr[j]) {
					k++;
					tempMaxMirror++;
				}
			}
			if ((k - j) <= 1 && arr[k] == arr[j]) {
				tempMaxMirror++;
				if (k == j) {
					tempMaxMirror = 2 * tempMaxMirror - 1;
				} else {
					tempMaxMirror = 2 * tempMaxMirror;
				}
			}
			if (tempMaxMirror > maxMirror) {
				maxMirror = tempMaxMirror;
			}
		}
		return maxMirror;
	}

	/**
	 * This function calculates the clumps number of the that exist in a passed
	 * "non negative integer" array. Array should not be empty.
	 *
	 * @param non
	 *            negative integer array
	 * @return total no of clumps of the mirror section.
	 */
	public int clumpsOfArray(int arr[]) {
		int arrayLength = arr.length;
		try {
			if (arrayLength == 0) {
				throw new Exception("Array size is null.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int clumpSize = 0;
		int arrLength = arr.length;

		for (int i = 0; i < arrLength - 1; i++) {
			if (i > 0) {
				if (arr[i] == arr[i + 1] && arr[i - 1] != arr[i]) {
					i = i + 1;
					clumpSize++;
				}
			} else {
				if (arr[i] == arr[i + 1]) {
					i = i + 1;
					clumpSize++;
				}
			}
		}
		return clumpSize;
	}

	/**
	 * This function changes the position of elements in the array that exist in
	 * a passed "non negative integer" array. Array should not be empty.
	 *
	 * @param non
	 *            negative integer array
	 * @param integer
	 *            value X to be fixed
	 * @param integer
	 *            value Y to be replaced
	 * @return max size of the mirror section.
	 */
	public int[] fixXY(int inputarr[], int X, int Y) {
		int arr[] = inputarr;
		int arrLength = arr.length;
		boolean flag = true;
		int countX = 0;
		int countY = 0;
		try {
			if (arrLength == 0) {
				flag = false;
				throw new Exception("Array Doesn't Exist");
			}

			for (int i = 0; i < arrLength; i++) {
				if (arr[i] == X) {
					countX++;
					if (i < arrLength - 1) {
						if (arr[i] == arr[i + 1]) {
							flag = false;
							throw new Exception(X
									+ " value is being adjacent in the array");
						}
					}
				} else if (arr[i] == Y) {
					countY++;
				}
			}
			if (countX != countY) {
				flag = false;
				throw new Exception(X + " and " + Y + " count not equal");
			}
			if (arr[arrLength - 1] == X) {
				flag = false;
				throw new Exception(X + " is the last element of the Array");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (flag) {
			for (int i = 0; i < arrLength - 1; i++) {
				if (arr[i] == X) {
					for (int j = 0; j < arrLength; j++) {
						if (((j == 0) && arr[j] == Y)
								|| (j > 0 && arr[j] == Y && arr[j - 1] != X)) {
							int temp = arr[i + 1];
							arr[i + 1] = arr[j];
							arr[j] = temp;
						}

					}
				}
			}
		}
		return arr;
	}

	/**
	 * This function calculates the max size of the mirror section that exist in
	 * a passed "non negative integer" array. Array should not be empty.
	 *
	 * @param non
	 *            negative integer array
	 * @return split array with equal sum.
	 */
	public int splitArray(int arr[]) {
		int arrayLength = arr.length;
		try {
			if (arrayLength == 0) {
				throw new Exception("Array size is null.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		int location = -1;
		for (int i = 0; i < arr.length; i++) {
			int sum1 = 0;
			for (int k = 0; k <= i; k++) {
				sum1 = sum1 + arr[k];
			}
			int sum2 = 0;
			for (int j = i + 1; j < arr.length; j++) {
				sum2 = sum2 + arr[j];
			}
			if (sum1 == sum2) {
				location = i + 1;
				break;
			}
		}
		return location;
	}

	
}