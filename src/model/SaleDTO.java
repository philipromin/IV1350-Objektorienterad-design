package model;

import java.util.ArrayList;
import dbhandler.ItemDTO;

/**
 * Class that stores information about the sale.
 */
public class SaleDTO {
	private ArrayList <ItemDTO> items = new ArrayList<ItemDTO>();
	private double total;
	
	/**
	 * Initializes new sale, empty at first. 
	 */
	public SaleDTO () {
		
	}
	
	/**
	 * Adds item to current sale.
	 * @param item Item to add. 
	 */
	public void addItem (ItemDTO item) {
		items.add(item);
		total += item.getPrice();
	}
	
	/**
	 * Converts sale items to string.
	 */
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (ItemDTO item : items) {
			string.append(item + "\n");
		}
		return string.toString();
	}
	
	/**
	 * Getter for total amount.
	 * @return Returns sale total. 
	 */
	public double getTotal () {
		return this.total;
	}
	
	/**
	 * Getter for items in sale.
	 * @return Returns list of items in sale.
	 */
	public ArrayList<ItemDTO> getItems () {
		return items;
	}
	
}
