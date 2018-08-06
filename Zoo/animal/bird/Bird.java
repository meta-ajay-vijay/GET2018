package animal.bird;

import animal.*;

public abstract class Bird extends Animal {

	final static public String CATEGORY = "BIRD";
	protected String maximumFlyHeight;

	public Bird(String name, String animalWeight, String maximumFlyHeight) {
		super(name, animalWeight);
		this.maximumFlyHeight = maximumFlyHeight;
	}

	abstract public String getInfo();

	abstract public String getSound();

}
