package Virat;

/**
 * @author User1
 *
 */
public class Bowler implements Comparable<Bowler>{
	String nameOfBowler;
	private int ballsLeft;
	
	/**
	 * parameterized constructor
	 * @param ballsLeft
	 */
	public Bowler(String nameOfBowler, int ballsLeft){
		this.nameOfBowler = nameOfBowler;
		this.ballsLeft = ballsLeft;
	}
	
	/**
	 * @return the nameOfBowler
	 */
	public String getNameOfBowler() {
		return nameOfBowler;
	}

	/**
	 * @param nameOfBowler the nameOfBowler to set
	 */
	public void setNameOfBowler(String nameOfBowler) {
		this.nameOfBowler = nameOfBowler;
	}

	/**
	 * @return the ballsLeft
	 */
	public int getBallsLeft() {
		return ballsLeft;
	}
	
	/**
	 * @param ballsLeft the ballsLeft to set
	 */
	public void setBallsLeft(int ballsLeft) {
		this.ballsLeft = ballsLeft;
	}

	@Override
	public int compareTo(Bowler bowler) {
		int resultOfComparision;
		if(this.getBallsLeft() > bowler.getBallsLeft()){
			resultOfComparision = -1;
		} else if(this.getBallsLeft() > bowler.getBallsLeft()){
			resultOfComparision = 1;
		}else {
			resultOfComparision = 0;
		}
		return resultOfComparision;
	}
}
