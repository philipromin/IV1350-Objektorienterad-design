package model;

import static org.junit.Assert.*;
import org.junit.Test;
import dbhandler.ItemDTO;

public class PaymentTest {
	private Payment payment = new Payment();
	
	@Test
	public void testCalculateTotal() {
		double expectedTotal = 120;
		SaleDTO salesInfo = new SaleDTO();
		salesInfo.addItem(new ItemDTO("testItem", "testItem", 1, 50));
		salesInfo.addItem(new ItemDTO("testItem", "testItem", 1, 40));
		salesInfo.addItem(new ItemDTO("testItem", "testItem", 1, 10));
		
		assertEquals(expectedTotal, payment.calculateTotal(salesInfo), 0);
	}	
}
