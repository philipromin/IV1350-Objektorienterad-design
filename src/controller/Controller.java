package controller;

import model.Sale;

/**
 * This is the application's controller. Calls to the model pass through here.
 */
public class Controller {
	private Sale sale;
	
	/**
	 * Starts a new sale when customer arrives at POS.
	 */
	public void startSale () {
		sale = new Sale();
	}
	
	/**
	 * Registers a new item when scanned by cashier.
	 * @param itemIdentifier The identifier of the scanned item.
	 * @return A string containing item info and running total. 
	 */
	public String enterItem (int itemIdentifier) {
		
		return sale.updateSale(itemIdentifier);
		
	}
	
	/**
	 * Ends the current sale when all items are registered by cashier.
	 * @return A string presenting total including taxes.
	 */
	public String endSale () {
		
		return "Total with taxes: " + sale.endSale() + "\n";
		
	}
	
	/**
	 * Pays for current sale and prints receipt.
	 * @param amount The amount paid by customer.
	 * @return A string specifying change amount to give customer.
	 */
	public String pay (double amount) {
		
		return sale.pay(amount);
		
	}

}
