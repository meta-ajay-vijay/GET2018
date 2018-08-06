import java.util.ArrayList;
import java.util.List;

import cage.Cage;
import animal.Animal;
import animal.animals;
import zone.Zone;

public class Zoo {
	private int capacity;
	private int spareCapacity;
	private List<Zone> listOfZone;

	/**
	 * @param spareCapacity
	 *            the spareCapacity to set
	 */
	private void setSpareCapacity() {
		this.spareCapacity = capacity - listOfZone.size();
	}

	/**
	 * constructor for initializing the zoneCapacity, spareCapacity and
	 * lisOfZones
	 * 
	 * @param zoneCapacity
	 */
	Zoo(int zoneCapacity) {
		this.capacity = zoneCapacity;
		this.spareCapacity = zoneCapacity;
		listOfZone = new ArrayList<Zone>();
	}

	/**
	 * function checks from animals enum that whether this zone is available or
	 * not
	 * 
	 * @param zone
	 * @return true if this zone category exists
	 */
	private boolean checkZoneAvailablity(Zone zone) {
		boolean flag = false;
		for (animals value : animals.values()) {
			if (value.getCategory() == zone.getZoneCategory()) {
				flag = true; // category match
				break;
			}
		}
		return flag;
	}

	/**
	 * same zone is already available in zonelist then return false
	 * 
	 * @param id
	 * @return
	 */
	private boolean isZoneExist(int id) {
		boolean flag = true;

		for (Zone zone : listOfZone) {
			if (zone.getZoneId() == id) {
				flag = false; // if zone id already exists
			}
		}

		return flag;
	}

	/**
	 * add zone to the list of zones in zoo
	 * 
	 * @param zone
	 * @return if zone has already added then return false if zone category does
	 *         not exists then return false if capacity is not available then
	 *         return false
	 */
	public boolean addZone(Zone zone) {
		if ((checkZoneAvailablity(zone)) && (spareCapacity > 0)
				&& (isZoneExist(zone.getZoneId()))) {
			listOfZone.add(zone);
			setSpareCapacity();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param zone
	 *            is the zone to remove
	 * @return true if successfully removed
	 */
	public boolean removeZone(Zone zoneToRemove) {
		boolean flag = true;
		int id = zoneToRemove.getZoneId(); // getting the unique id of zone

		if (!isZoneExist(id)) { // zone should exist
			int index = 0;
			for (Zone zone : listOfZone) {
				if (id == zone.getZoneId()) {
					break;
				}
				index++; // for getting index of the particular zone that we
							// want to remove
			}
			listOfZone.remove(index);
			flag = true; // if removed
		} else {
			flag = false; // if not removed
		}
		return flag;
	}

	/**
	 * check if category is available in the list of zones.
	 * 
	 * @param category
	 * @return true if a particular category is available in the list of zone
	 */
	private boolean isCategoryZoneExist(String category) {
		boolean flag = false;
		for (Zone zone : listOfZone) {
			if (category.equalsIgnoreCase(zone.getZoneCategory())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * getting the animal category using the animal's type by enum
	 * 
	 * @param animal
	 * @return
	 */
	private String getAnimalCategory(Animal animal) {
		String category = "";
		for (animals animalEnum : animals.values()) {
			if (animal.type.equalsIgnoreCase(animalEnum.getType())) {
				category = animalEnum.getCategory();
			}
		}
		return category;
	}

	/**
	 * returning the particular zone which is compatible with animal (as an
	 * example lion is compatible with mammal zone)
	 * 
	 * @param animal
	 * @return the reference of zone from zoo list which is compatible with
	 *         category of an animal
	 */

	private Zone getcompatibleZone(Animal animal) {
		for (Zone zone : listOfZone) {
			if (zone.getZoneCategory().equalsIgnoreCase(
					getAnimalCategory(animal))) {
				return zone;
			}
		}
		return null;
	}

	/**
	 * function checks if any cage type is available in zone for a particular
	 * animal type
	 * 
	 * @param animal
	 * @param zone
	 * @return true if cage type exists
	 */
	private boolean isCageTypeExist(Animal animal, Zone zone) {
		boolean flag = false;
		for (Cage cage : zone.listOfCage) {
			if (cage.getCageType().equalsIgnoreCase(animal.type)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * returning the compatible cage reference for animal type
	 * 
	 * @param animal
	 * @param zone
	 * @return reference of cage
	 */
	private Cage getcompatibleCage(Animal animal, Zone zone) {
		for (Cage cage : zone.listOfCage) {
			if (cage.getCageType().equalsIgnoreCase(animal.type)) {
				return cage;
			}
		}
		return null;
	}

	/**
	 * adding an animal to zoo
	 * 
	 * @param animal
	 * @return
	 */
	public boolean addAnimal(Animal animal) {
		boolean flag = false;
		if (isCategoryZoneExist(getAnimalCategory(animal))) {
			Zone zone = getcompatibleZone(animal);
			if (isCageTypeExist(animal, zone)) {
				Cage cage = getcompatibleCage(animal, zone);
				flag = cage.addAnimal(animal); // return true if successfully
												// added to zoo
			}
		}
		return flag;
	}

	/**
	 * removing an animal from zoo
	 * 
	 * @param animal
	 * @return
	 */
	public boolean removeAnimal(Animal animal) {
		boolean flag = false;
		if (isCategoryZoneExist(getAnimalCategory(animal))) {
			Zone zone = getcompatibleZone(animal);
			if (isCageTypeExist(animal, zone)) {
				Cage cage = getcompatibleCage(animal, zone);
				flag = cage.removeAnimal(animal.getId()); // return true if
															// successfully
															// removed
			}
		}
		return flag;
	}
}
