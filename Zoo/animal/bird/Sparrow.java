package animal.bird;

import animal.animals;

public class Sparrow extends Bird {

	final private String SOUND = "CHRIP";
	private String color;

	public Sparrow(String name, String animalWeight, String maximumFlyHeight,
			String color) {
		super(name, animalWeight, maximumFlyHeight);
		this.color = color;
		this.setType();
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "id:\t" + id + "\nCateGory:" + CATEGORY + "\nType:\t" + type
				+ "\nName:\t" + name + "\nWeight:\t" + weight
				+ "\nMaximum Fly:" + maximumFlyHeight + "\ncolor\t" + color;
	}

	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return this.SOUND;
	}

	public void setType() {
		type = animals.SPARROW.getType();
	}

	public String getType() {
		return this.type;
	}


}
