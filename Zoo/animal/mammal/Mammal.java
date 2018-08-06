package animal.mammal;

import animal.*;

public abstract class Mammal extends Animal {
	final static public String CATEGORY = "MAMMAL";

	protected String bloodType;
	public Mammal(String name, String weight, String bloodType) {
		super(name, weight);
		this.bloodType = bloodType;
	}

	abstract public String getInfo();

	abstract public String getSound();

}
