package view;

import model.SaleObserver;

/**
 * Observer class of total sales. Prints total money earned to console.
 */
public class TotalRevenueView implements SaleObserver {
	private double total;
	
	@Override
	public void update(double amount) {
		total += amount;
		System.out.println("DISPLAY: " + total);
	}
	
}
