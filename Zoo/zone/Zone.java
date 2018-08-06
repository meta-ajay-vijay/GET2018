package zone;

import java.util.*;

import cage.Cage;

public class Zone {
	private int zoneId;
	private String zoneCategory;
	private int capacity;
	private int spareCapacity;
	public List<Cage> listOfCage;
	public void setZoneId() {
		double random = Math.random();
		this.zoneId = (int) (random * 1000);
	}

	public int getZoneId() {
		return this.zoneId;
	}

	/**
	 * @return the zoneCategory
	 */
	public String getZoneCategory() {
		return zoneCategory;
	}

	/**
	 * @param spareCapacity
	 *            the spareCapacity to set
	 */
	public void setSpareCapacity() {
		this.spareCapacity = capacity - listOfCage.size();
	}

	/**
	 * @return the spareCapacity
	 */
	public int getSpareCapacity() {
		return spareCapacity;
	}

	/**
	 * constructor for for initializing the zoneCategory, capacity,
	 * spareCapacity, zone id, listOfZone
	 * 
	 * @param zoneCategory
	 * @param capacity
	 */
	public Zone(String zoneCategory, int capacity) {
		this.zoneCategory = zoneCategory.toUpperCase();
		this.capacity = capacity;
		this.spareCapacity = capacity;
		listOfCage = new ArrayList<Cage>();
		setZoneId();
	}

	/**
	 * adding cage to the list of cage
	 * 
	 * @param cage
	 * @return true if cage is added else false
	 */
	public boolean addCage(Cage cage) {
		if ((zoneCategory.equalsIgnoreCase(cage.getCageCategory()))
				&& (spareCapacity > 0) && (isCageExist(cage.getCageId()))) {

			listOfCage.add(cage);
			setSpareCapacity();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * removing the cage from cage list
	 * 
	 * @param id
	 * @return true if cage exists
	 */
	public boolean removeAnimal(int id) {
		boolean flag = true;

		if (!isCageExist(id)) {
			int index = 0;
			for (Cage cage : listOfCage) {
				if (id == cage.getCageId()) {
					break;
				}
				index++;
			}
			listOfCage.remove(index);
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * if a particular cage already exist then returns false
	 * 
	 * @param id
	 * @return
	 */
	private boolean isCageExist(int id) {
		boolean flag = true;

		for (Cage x : listOfCage) {
			if (x.getCageId() == id) {
				flag = false;
			}
		}

		return flag;
	}

}
