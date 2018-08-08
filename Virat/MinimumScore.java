package Virat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import myUtility.Utility;

/**
 * @author User1
 *
 */
public class MinimumScore {

	List<Bowler> listOfBowlers;
	List<String> orderOfBowlers = new ArrayList<String>();
	private int totalBallsBowlersCanThrow = 0;

	public MinimumScore() {
		listOfBowlers = new ArrayList<Bowler>();
	}

	/**
	 * @return the totalBallsBowlersCanThrow
	 */
	public int getTotalBallsBowlersCanThrow() {
		return totalBallsBowlersCanThrow;
	}

	/**
	 * method creates new bowler
	 */
	public void createBowler(int numberOfBowlers) {
		for (int index = 0; index < numberOfBowlers; index++) {
			System.out.println("Enter the name of bowler " + (index + 1));
			String nameOfBowler = Utility.isName();
			System.out.println("Enter the balls bowler " + (index + 1) + " can throw");
			int balls = Utility.isPositiveInt();
			totalBallsBowlersCanThrow += balls;
			// creates object of bowler
			Bowler bowler = new Bowler(nameOfBowler, balls);
			// add bowler to the list of bowlers
			listOfBowlers.add(bowler);
		}
	}

	public List<String> bowlingOrder(int numberOfBallsKohliWillPlay) {
		for (int ballKohliIsPlaying = 0; ballKohliIsPlaying < numberOfBallsKohliWillPlay; ballKohliIsPlaying++) {
			Collections.sort(listOfBowlers);
			orderOfBowlers.add(listOfBowlers.get(0).getNameOfBowler());
			int temporaryBallsLest = listOfBowlers.get(0).getBallsLeft();
			listOfBowlers.get(0).setBallsLeft(temporaryBallsLest - 1);
		}
		return orderOfBowlers;
	}
}
