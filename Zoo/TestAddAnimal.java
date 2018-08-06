import static org.junit.Assert.*;

import org.junit.Test;

import cage.Cage;
import zone.Zone;
import animal.Animal;
import animal.mammal.Lion;


public class TestAddAnimal {

	@Test
	public void testAddAnimal() {
		Zoo zoo = new Zoo(10); //creating zoo of zone capacity 10
        Animal lion1 = new Lion("lionA","200kg","cold",200,4);
        boolean expectedResult = zoo.addAnimal(lion1);
        /*
         * animal can not be added as no existing zones exists for adding an animal
         */
        assertEquals(false, expectedResult);
     }
	
	@Test
	public void test2AddAnimal() {
		Zoo zoo = new Zoo(10); //creating zoo of zone capacity 10
		Zone mammalZone = new Zone("REPTILE", 10);
		zoo.addZone(mammalZone);
	    Animal lion1 = new Lion("lionA","200kg","cold",200,4);
        boolean expectedResult = zoo.addAnimal(lion1);
        /*
         * animal can not be added as no existing cages are available for adding an animal
         */
        assertEquals(false, expectedResult);
     }
	
	@Test
	public void test3AddAnimal() {
		Zoo zoo = new Zoo(10); //creating zoo of zone capacity 10
		Zone mammalZone = new Zone("MAMMAL", 10);
		
		Cage lionCage1 = new Cage("elephant", 2);
		
		mammalZone.addCage(lionCage1);
		zoo.addZone(mammalZone);
	    Animal lion1 = new Lion("lionA","200kg","cold",200,4);
	    boolean expectedResult = zoo.addAnimal(lion1);
	    
	    /*
         * animal can not be added as existing cages is not compatible for adding an animal
         * a lion can not be added in elephant's cage
         */
        assertEquals(false, expectedResult);
     }
	
	@Test
	public void test4AddAnimal() {
		Zoo zoo = new Zoo(10); //creating zoo of zone capacity 10
		Zone ReptileZone = new Zone("REPTILE", 10);
		
		Cage lionCage1 = new Cage("lion", 2);
		
		ReptileZone.addCage(lionCage1); //not added as lion is not reptile
		zoo.addZone(ReptileZone);
	    Animal lion1 = new Lion("lionA","200kg","cold",200,4);
	    boolean expectedResult = zoo.addAnimal(lion1);
	    
	    /*
         * there is no compatible zone exists in the zoo
         * lion can not be added to the REPTILE zone 
         */
        assertEquals(false, expectedResult);
     }
	
	@Test
	public void test5AddAnimal() {
		Zoo zoo = new Zoo(10); //creating zoo of zone capacity 10
		Zone mammalZone = new Zone("MAMMAL", 10);
		
		Cage lionCage1 = new Cage("lion", 2);
		
		mammalZone.addCage(lionCage1);
		zoo.addZone(mammalZone);
	    Animal lion1 = new Lion("lionA","200kg","cold",200,4);
	    boolean expectedResult = zoo.addAnimal(lion1);
	    
	    /*
         * animal has found the compatible cage in zoo. 
         */
        assertEquals(true, expectedResult);
     }
	
	@Test
	public void test6AddAnimal() {
		Zoo zoo = new Zoo(10); //creating zoo of zone capacity 10
		Zone mammalZone = new Zone("MAMMAL", 10);
		
		Cage lionCage1 = new Cage("lion", 2);
		
		mammalZone.addCage(lionCage1);
		zoo.addZone(mammalZone);
	    Animal lion1 = new Lion("lionA","200kg","cold",200,4);
	    Animal lion2 = new Lion("lionB","200kg","cold",200,4);
	    Animal lion3 = new Lion("lionC","200kg","cold",200,4);
	    
	    zoo.addAnimal(lion1);
	    zoo.addAnimal(lion2);
	    boolean expectedResult = zoo.addAnimal(lion3);
	    
	    /*
         * animal can not be added to zoo as no capacity is available in the zoo 
         */
        assertEquals(false, expectedResult);
     }
}
