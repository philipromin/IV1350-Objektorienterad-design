package model;

/**
 * A listener interface for receiving notifications about finished sale.
 */

public interface SaleObserver {
	public void update(double amount);
}
