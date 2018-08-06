package animal.reptile;

import animal.animals;

public class Crocodile extends Reptile {
	final private String sound = "HISSING";

	public Crocodile(String name, String weight, String eggColor,
			String shellName) {
		super(name, weight, eggColor, shellName);
		this.setType();
	}

	@Override
	public String getInfo() {
		return "id:\t" + id + "\nCateGory:" + CATEGORY + "\nType:\t" + type
				+ "\nName:\t" + name + "\nWeight:\t" + weight + "\nEgg Color:"
				+ eggColor + "\nShell:\t" + shellName;
	}

	public void setType() {
		type = animals.CROCODILE.getType();
	}

	public String getType() {
		return this.type;
	}


	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return this.sound;
	}

}
