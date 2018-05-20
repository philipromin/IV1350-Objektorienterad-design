package model;

import java.sql.SQLException;

import dbhandler.Dbhandler;
import dbhandler.ItemDTO;
import dbhandler.ItemNotFoundException;
import dbhandler.Printer;

/**
 * Responsible for the logic of current sale. Takes calls from controller.
 */
public class Sale {
	private SaleDTO salesInfo = new SaleDTO();
	private Dbhandler dbhandler = new Dbhandler();
	private Payment payment = new Payment();
	private double totalWithTaxes;
	private SaleObserver saleObserver;
	
	/**
	 * Updates current sales info by adding registered item.
	 * @param itemIdentifier Identifier of the registered item. 
	 * @return A saleDTO containing sales info.  
	 * @throws ItemNotFoundException if item with itemIdentifier does not exist. 
	 * @throws OperationFailedException indicates database failure besides itemIdentifier not existing. 
	 */
	public SaleDTO updateSale (int itemIdentifier) throws ItemNotFoundException, OperationFailedException {
		try {
			ItemDTO searchedItem = dbhandler.findItem(itemIdentifier);
			salesInfo.addItem(searchedItem);
			return salesInfo;
		} catch (SQLException sqle) {
			throw new OperationFailedException("Database error has occurred", sqle);
		}
	}
	
	/**
	 * Ends the current sale when all items are registered.
	 * @return Total amount including taxes.
	 */
	public double endSale () {
		
		totalWithTaxes = payment.calculateTotal(salesInfo);
		
		return totalWithTaxes;
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
			notifyObserver();
			return "Change to give customer: " + change;
		} 
		return "Amount given is too low";
	}
	
	/**
	 * Notifies observer when state change. 
	 */
	private void notifyObserver() {
		saleObserver.update(this.totalWithTaxes);
	}

	/**
	 * Calls printer to print sales info.
	 */
	public void printReceipt () {
		Printer printer = new Printer();
		printer.printReceipt(salesInfo);
	}
	
	/**
	 * Setter for observer. 
	 * @param observer to set. 
	 */
	public void setSaleObserver (SaleObserver observer) {
		this.saleObserver = observer;
	}
		
}

