package dbhandler;

import model.SaleDTO;

/**
 * Responsible for printing sales info. 
 */
public class Printer {
	
	/**
	 * Prints information about the sale.
	 * @param salesInfo Information about the sale.
	 */
	public void printReceipt (SaleDTO salesInfo) {	
		
		System.out.println("RECEIPT\n" + salesInfo.toString());		
		
	}
}
