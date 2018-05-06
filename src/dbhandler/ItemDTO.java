package dbhandler;

/**
 * Class that stores information about items. 
 */
public class ItemDTO {
	private String name;
	private String description;
	private int itemIdentifier;
	private double price;
	
	/**
	 * Creates new instance of item. 
	 * @param name Name of item.
	 * @param description Item description. 
	 * @param itemIdentifier Item identifier. 
	 * @param price Price of the item. 
	 */
	public ItemDTO (String name, String description, int itemIdentifier, double price) {
		this.name = name;
		this.description = description;
		this.itemIdentifier = itemIdentifier;
		this.price = price;
	}
	
	/**
	 * Getter for item name.
	 * @return Returns name of item. 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getter for item description.
	 * @return Returns item description. 
	 */
	public String getDescription () {
		return this.description;
	}
	
	/**
	 * Getter for item identifier.
	 * @return Returns item identifier. 
	 */
	public int getItemIdentifier() {
		return this.itemIdentifier;
	}	
	
	/**
	 * Getter for item price.
	 * @return Returns item price. 
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * Converts item info to string.
	 */
	@Override
	public String toString(){
		return name + " " + description + " " + price ;
	}
	
}
