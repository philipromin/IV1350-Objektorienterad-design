package model;

/**
 * Responsible for the logic concerning payment. 
 */
public class Payment {	
	private double totalWithTaxes;	
	
	/**
	 * Calculates the total cost of the sale including taxes.
	 * @param salesInfo Contains information about the sale. 
	 * @return Returns total including taxes.
	 */
	public double calculateTotal (SaleDTO salesInfo) {
	
		totalWithTaxes = salesInfo.getTotal() * 1.2;
		
		return totalWithTaxes;
	}
	
	/**
	 * Calculates change to give customer.
	 * @param amount Amount paid by customer.
	 * @return Change to give customer.
	 */
	public double calculateChange (double amount) {
		
		double change = amount - totalWithTaxes;		
		
		return change;
	}

}
