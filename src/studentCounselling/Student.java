package studentCounselling;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	public List<String> choices = new ArrayList<String>();
	private String allottedSeat;

	/**
	 * @return the choices
	 */
	public List<String> getChoices() {
		return choices;
	}
	/**
	 * @param choices the choices to set
	 */
	public void setChoices(List<String> choices) {
		this.choices = choices;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the allottedSeat
	 */
	public String getAllottedSeat() {
		return allottedSeat;
	}
	/**
	 * @param allottedSeat the allottedSeat to set
	 */
	public void setAllottedSeat(String allottedSeat) {
		this.allottedSeat = allottedSeat;
	}
	
}
