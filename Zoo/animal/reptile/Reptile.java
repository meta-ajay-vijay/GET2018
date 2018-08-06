package animal.reptile;

import animal.*;

public abstract class Reptile extends Animal {
	final public static String CATEGORY = "REPTILE";

	protected String eggColor;
	protected String shellName;

	public Reptile(String name, String weight, String eggColor, String shellName) {
		super(name, weight);
		this.eggColor = eggColor;
		this.shellName = shellName;
	}

	abstract public String getInfo();

	abstract public String getSound();
}
