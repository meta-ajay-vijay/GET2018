package assignment4;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestGetCategoryData {
	private List<Category> listOfResultCategory;

	@Before
	public void initialiseList(){
		listOfResultCategory = GetCategoryData.getCategoryData();
	}
	
	@Test
	public void testForFirstChild() {
		int childOfElectronices = listOfResultCategory.get(0).getTotalChilds();
		assertEquals("total 3 childs of electronics",3, childOfElectronices);
	}
	
	@Test
	public void testForSecondChild() {
		List<Category> list = GetCategoryData.getCategoryData();
		int childOfFashion = list.get(1).getTotalChilds();
		assertEquals(3, childOfFashion);
	}
	
	@Test
	public void testForThirdChild() {
		List<Category> list = GetCategoryData.getCategoryData();
		int childOfSports = list.get(2).getTotalChilds();
		assertEquals(1, childOfSports);
	}

}