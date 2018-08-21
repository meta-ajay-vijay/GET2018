package assignment2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestInsertData {
	
	List <ImageData> listOfObjects  = new ArrayList<ImageData>();
	
	@Before
	public void initaliseListOfObjects(){
		listOfObjects.add(new ImageData("www.xyzx.com", "xyzx"));
		listOfObjects.add(new ImageData("www.abcx.com", "abc"));
		listOfObjects.add(new ImageData("www.pqrx.com", "pqr"));
		listOfObjects.add(new ImageData("www.lmnx.com", "lmn"));
		listOfObjects.add(new ImageData("www.zzzx.com", "zzz"));
	}
	
	@Test
	public void test() {
		assertEquals(true,InsertImageData.inserImageData(listOfObjects, 101));
	}

}