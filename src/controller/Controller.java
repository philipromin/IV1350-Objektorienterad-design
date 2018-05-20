package controller;

import dbhandler.ItemNotFoundException;
import model.OperationFailedException;
import model.Sale;
import model.SaleDTO;
import model.SaleObserver;

/**
 * This is the application's controller. Calls to the model pass through here.
 */
public class Controller {
	private Sale sale;
	private SaleObserver saleObserver;
	
	/**
	 * Starts a new sale when customer arrives at POS.
	 */
	public void startSale () {
		sale = new Sale();
		sale.setSaleObserver(this.saleObserver);
	}
	
	/**
	 * Registers a new item when scanned by cashier.
	 * @param itemIdentifier The identifier of the scanned item.
	 * @return A saleDTO containing item info and running total. 
	 * @throws ItemNotFoundException if item with itemIdentifier does not exist. 
	 * @throws OperationFailedException indicates database failure besides itemIdentifier not existing.  
	 * @throws IllegalStateException if enterItem is called before startSale. 
	 */
	public SaleDTO enterItem (int itemIdentifier) throws ItemNotFoundException, OperationFailedException {
		if (sale == null) {
			throw new IllegalStateException("Start a new sale before entering items."); //Unchecked RuntimeException
		}
		return sale.updateSale(itemIdentifier);	
	}
	
	/**
	 * Ends the current sale when all items are registered by cashier.
	 * @return A string presenting total including taxes.
	 */
	public Double endSale () {
		
		return sale.endSale();
		
	}
	
	/**
	 * Pays for current sale and prints receipt.
	 * @param amount The amount paid by customer.
	 * @return A string specifying change amount to give customer.
	 */
	public String pay (double amount) {
		
		return sale.pay(amount);
		
	}

	/**
	 * Adds another observer. In this case we only need one. 
	 * @param observer to add as observer.
	 */
	public void addSaleObserver(SaleObserver observer) {
		this.saleObserver = observer;
	}

}
