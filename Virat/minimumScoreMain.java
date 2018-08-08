/**
 * 
 */
package Virat;

import Virat.MinimumScore;
import myUtility.Utility;
/**
 * @author User1
 *
 */
public class minimumScoreMain {
	public static void main(String[] args){
		MinimumScore objectOfMinimumScore = new MinimumScore();
		System.out.println("Enter the number of bowlers");
		int numberOfBowlers = Utility.isPositiveInt();
		objectOfMinimumScore.createBowler(numberOfBowlers);
		System.out.println("How many balls virat will play?");
		int numberOfBallsViratWillPlay = Utility.isIntInRange(1, objectOfMinimumScore.getTotalBallsBowlersCanThrow());
		System.out.println("Bowling order");
		System.out.println(objectOfMinimumScore.bowlingOrder(numberOfBallsViratWillPlay));
	}
}
