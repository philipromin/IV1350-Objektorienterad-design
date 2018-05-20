package dbhandler;

public class ItemNotFoundException extends Exception {
	
	public ItemNotFoundException(int itemIdentifier) {
		super("Item with identifier " + itemIdentifier + " does not exist\n");
	}
}
