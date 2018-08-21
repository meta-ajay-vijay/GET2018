package assignment1;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestGetOrder {
	private List<OrderInfo> listOfOrdersRetrived;
	
	@Before
	public void initalizeListOfOrdersRetrived(){
		listOfOrdersRetrived = GetOrderData.getOrderData(2);
	}

	@Test
	public void testIsDataRetrived() {
		assertEquals("total five rows are selected", listOfOrdersRetrived.size()==5, true);
	}
	
	@Test
	public void testFirstDataRetrivedObject() {
		int firstId = listOfOrdersRetrived.get(0).getObjectId();
		
		assertEquals(firstId, 8);
	}

}