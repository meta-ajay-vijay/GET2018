package com.metacube.webService.soap;

/**
 * This class is used to calculate area of triangle using Heron's formula
 */
public class Triangle {
	/**
	 * Calculates area of triangle using heron's formula
	 * @param sideFirst - It is first side of triangle entered by user
	 * @param sideSecond - It is second side of triangle entered by user
	 * @param sideThird - It is third side of triangle entered by user
	 * @return area of triangle
	 */
	public float areaOfTriangle(float sideFirst, float sideSecond, float sideThird) {
		float halfPerimeter = (sideFirst + sideSecond + sideThird) / 2;
		float area = (float)(Math.sqrt(halfPerimeter * (halfPerimeter - sideFirst)
				* (halfPerimeter - sideSecond) * (halfPerimeter - sideThird)));
		return area;
	}
}
