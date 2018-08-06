package animal;

public enum animals {
	LION("Lion", "MAMMAL"), ELEPHANT("Elephant", "MAMMAL"), SPARROW("Sparrow",
			"BIRD"), EAGLE("Eagle", "BIRD"), CROCODILE("Crocodile", "REPTILE"), TURTLE(
			"Turtle", "REPTILE");

	private String type;
	private String category;

	animals(String type, String category) {
		this.type = type;
		this.category = category;

	}

	public String getType() {
		return type;
	}

	public String getCategory() {
		return category;
	}
};
