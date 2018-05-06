package controller;

import static org.junit.Assert.*;
import org.junit.Test;

public class ControllerTest {
	private Controller contr = new Controller();

	@Test
	public void testEnterItem() {
		contr.startSale();
		
		String itemFail = contr.enterItem(10);
		assertTrue(itemFail.equals("Item not found\n"));
		
		String item = contr.enterItem(1);
		assertTrue(item.contains("Scanned item: Shirt Blue Shirt 199.0"));
	}
	
	@Test
	public void testEndSale () {
		contr.startSale();
		contr.enterItem(1);
		String endSale = contr.endSale();
		
		assertTrue(endSale.equals("Total with taxes: " + 199.0*1.2 + "\n"));
	}
	
	@Test
	public void testPay () {
		contr.startSale();
		contr.enterItem(2);
		contr.endSale();
		
		String pay = contr.pay(400);
		assertTrue(pay.contains("Change to give customer: " + (400-(299.0*1.2))));
	}
	
	
}
