import static org.junit.Assert.*;

import org.junit.Test;

import zone.Zone;
import animal.Animal;
import animal.mammal.Lion;
import cage.Cage;


public class TestRemoveAnimal {

	@Test
	public void testRemoveAnimalAnimal() {
		Zoo zoo = new Zoo(10); //creating zoo of zone capacity 10
		Zone mammalZone = new Zone("MAMMAL", 10);
		
		Cage lionCage1 = new Cage("lion", 2);
		
		mammalZone.addCage(lionCage1);
		zoo.addZone(mammalZone);
	    Animal lion1 = new Lion("lionA","200kg","cold",200,4);
	    zoo.addAnimal(lion1);
	    boolean ActualResult = zoo.removeAnimal(lion1);
	    assertEquals(true, ActualResult );
	 }
	
	@Test
	public void test2RemoveAnimalAnimal() {
		Zoo zoo = new Zoo(10); //creating zoo of zone capacity 10
		Zone mammalZone = new Zone("MAMMAL", 10);
		
		Cage lionCage1 = new Cage("lion", 2);
		
		mammalZone.addCage(lionCage1);
		zoo.addZone(mammalZone);
	    Animal lion1 = new Lion("lionA","200kg","cold",200,4);
	    zoo.addAnimal(lion1);
	    zoo.removeAnimal(lion1);
	    
	    //no such animal exists in zoo
	    boolean ActualResult = zoo.removeAnimal(lion1);
	    assertEquals(false, ActualResult );
	 }


}
