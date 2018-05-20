package dbhandler;

import java.sql.SQLException;
import java.util.ArrayList;

import model.SaleDTO;

/**
 * Responsible for logic involving fictional database.
 */
public class Dbhandler {
	private ArrayList <ItemDTO> database = new ArrayList<ItemDTO>();
	
	/**
	 * Adds items to fictional database.
	 */
	public Dbhandler () {
		database.add( new ItemDTO ("Shirt", "Blue Shirt", 1, 199) );
		database.add( new ItemDTO ("Pants", "Red Pants", 2, 299) );
		database.add( new ItemDTO ("Hat", "Orange Hat", 3, 99) );
		database.add( new ItemDTO ("Hoodie", "Black Hoodie", 4, 399) );
	}
	
	/**
	 * Retrieves item from fictional database.
	 * @param identifier Item identifier.
	 * @return Item from database if found.
	 * @throws SQLException if database failure occurs.
	 * @throws ItemNotFoundException if item with identifier doesn't exist. 
	 */
	public ItemDTO findItem (int identifier) throws SQLException, ItemNotFoundException {
		//Hardcoded database failure
		if (identifier == 5) {
			throw new SQLException();
		}
		
		for (ItemDTO item : database ) {
			if (item.getItemIdentifier() == identifier) {
				return item;
			}
		}	
		throw new ItemNotFoundException(identifier);
	}
	
	/**
	 * Logs finished sale to some system.
	 * @param salesInfo Information about finished sale.
	 */
	public void logSale (SaleDTO salesInfo) {
		//Logs sale to some system.
	}

}
