package model;

import dbhandler.Dbhandler;
import dbhandler.ItemDTO;
import dbhandler.Printer;

/**
 * Responsible for the logic of current sale. Takes calls from controller.
 */
public class Sale {
	private SaleDTO salesInfo = new SaleDTO();
	private Dbhandler dbhandler = new Dbhandler();
	private Payment payment = new Payment();;
	
	/**
	 * Updates current sales info by adding registered item.
	 * @param itemIdentifier Identifier of the registered item. 
	 * @return A string containing sales info. 
	 */
	public String updateSale (int itemIdentifier) {
		ItemDTO searchedItem = dbhandler.findItem(itemIdentifier);
		
		if(searchedItem != null) {
			salesInfo.addItem(searchedItem);
			return "Scanned item: " + searchedItem.toString() + "\nRunning Total: " + salesInfo.getTotal() + "\n";
		}
			return "Item not found\n";
	}
	
	/**
	 * Ends the current sale when all items are registered.
	 * @return Total amount including taxes.
	 */
	public double endSale () {
		
		double total = payment.calculateTotal(salesInfo);
		
		return total;
	}
	
	/**
	 * Pays for current sale.
	 * @param amount Amount paid by the customer.
	 * @return A string specifying change amount to give customer. 
	 */
	public String pay (double amount) {
		double change = payment.calculateChange(amount);
		
		if(change >= 0) {
			printReceipt();
			dbhandler.logSale(salesInfo);
			return "Change to give customer: " + change;
		} 
		return "Amount given is too low";
	}
	
	/**
	 * Calls printer to print sales info.
	 */
	public void printReceipt () {
		Printer printer = new Printer();
		printer.printReceipt(salesInfo);
	}
		
}

