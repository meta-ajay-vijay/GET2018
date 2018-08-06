package animal.mammal;

import animal.animals;

public class Lion extends Mammal {
	final private String SOUND = "ROAR";

	private int speed;
	private int totalLegs;

	public Lion(String name, String weight, String bloodType, int speed, int totalLegs) {
		super(name, weight, bloodType);
		this.speed = speed;
		this.totalLegs = totalLegs;
		this.setType();
	}

	@Override
	public String getInfo() {
		return "id:\t" + id + "\nCateGory:" + CATEGORY + "\nType:\t"
				+ type + "\nName:\t" + name + "\nWeight:\t" + weight
				+ "\nblood-Type:" + bloodType + "\nspeed:\t" + speed + "\nlegs:\t" + totalLegs;
	}
	
	public void setType() {
		type = animals.LION.getType();
	}

	public String getType() {
		return this.type;
	}

	@Override
	public String getSound() {
		return this.SOUND;
	}
	public int getLegs(){
		return this.totalLegs;
	}
}
