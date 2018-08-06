package cage;

import animal.*;

import java.util.*;

public class Cage {
	private int cageId;
	private String cageType;
	private String cageCategory;
	private int capacity;
	private int spareCapacity;
	private List<Animal> listOfAnimal;

	/**
	 * function set cage category automatically by getting category from animals
	 * enum
	 * 
	 * @param cageCategory
	 *            the cageCategory to set
	 */
	private void setCageCategory() {
		for (animals animalEnum : animals.values()) {
			if (cageType.equalsIgnoreCase(animalEnum.getType())) {
				cageCategory = animalEnum.getCategory();
			}
		}
	}

	/**
	 * @return the cageCategory
	 */
	public String getCageCategory() {
		return cageCategory;
	}

	/**
	 * for setting a unique id of cage
	 */
	private void setCageId() {
		double random = Math.random();
		this.cageId = (int) (random * 1000);
	}

	public int getCageId() {
		return this.cageId;
	}

	/**
	 * @return the cageType
	 */
	public String getCageType() {
		return cageType;
	}

	/**
	 * constructor for initializing the cageId, cageType
	 * 
	 * @param cageType
	 * @param capacity
	 */
	public Cage(String cageType, int capacity) {
		super();
		this.cageType = cageType.toUpperCase();
		this.capacity = capacity;
		spareCapacity = capacity;
		listOfAnimal = new ArrayList<Animal>();
		setCageCategory();
		setCageId();
	}

	/**
	 * spare Capacity is the available capacity in which animal can be allocated
	 */
	private void setSpareCapacity() {
		spareCapacity = capacity - listOfAnimal.size();
	}

	/**
	 * checking if a particular animal already exists in the cage
	 * 
	 * @param id
	 * @return
	 */
	boolean isAnimalExist(int id) {
		boolean flag = true;
		for (Animal x : listOfAnimal) {
			if (x.getId() == id) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * adding an animal to cage
	 * 
	 * @param animal
	 * @return true if animal is successfully added
	 */
	public boolean addAnimal(Animal animal) {
		if (animal.type.equalsIgnoreCase(cageType) && spareCapacity > 0
				&& isAnimalExist(animal.getId())) {
			listOfAnimal.add(animal);
			setSpareCapacity();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * remove an animal from cage
	 * 
	 * @param id
	 * @return true if animal is successfully removed
	 */
	public boolean removeAnimal(int id) {
		boolean flag = true;

		if (!isAnimalExist(id)) {
			int index = 0;
			for (Animal animal : listOfAnimal) {
				if (id == animal.getId()) {
					break;
				}
				index++;
			}
			listOfAnimal.remove(index);
			flag = true; // successfully removed
		} else {
			flag = false; // not removed
		}
		return flag;
	}

}
