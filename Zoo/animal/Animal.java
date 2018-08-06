package animal;

public abstract class Animal {
	public int id;
	public String type;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	protected String name;
	protected String weight;

	public Animal(String name, String weight) {
		super();
		this.name = name;
		this.weight = weight;
		setId();
	}

	public void setId() {
        double random = Math.random();
		this.id = (int) (random * 1000);
	}

	public int getId() {
		return this.id;
	}

	abstract public String getInfo();

	abstract public String getSound();
}
