package view;

import controller.Controller;
import dbhandler.ItemNotFoundException;
import model.OperationFailedException;

/**
 * This program has no view, instead, this class is a
 * placeholder for the entire view.
 */

public class View {
	private Controller contr;
	private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
		/**		 
		 * @param contr The controller that is used for all operations.
		 */
		public View(Controller contr) {
			
			this.contr = contr;
			contr.addSaleObserver(new TotalRevenueView());
			
		}
		
		/**
		 * Simulates user input that generates calls to all system operations.
		 */
		public void saleSimulation () {	
			
			try {
				contr.startSale();
				try {
					System.out.println(contr.enterItem(1));
				} catch (ItemNotFoundException e) {
					handleException(e.getMessage(), e);
				} catch (OperationFailedException e) {
					handleException("Failed to enter item", e);
				}
				try {
					System.out.println("*Trying to add identifier which should cause DB failure*");
					System.out.println(contr.enterItem(5));
				} catch (ItemNotFoundException e) {
					handleException(e.getMessage(), e);
				} catch (OperationFailedException e) {
					handleException("Failed to enter item", e);
				}
				try {
					System.out.println("*Trying to add identifier which doesn't exist*");
					System.out.println(contr.enterItem(6));
				} catch (ItemNotFoundException e) {
					handleException(e.getMessage(), e);
				} catch (OperationFailedException e) {
					handleException("Failed to enter item", e);
				}
				System.out.println("To pay: " + contr.endSale());
				contr.pay(300);
			} catch (Exception e) {
				handleException("Sale has failed to start, please try again", e);
			}
			
		}
		
		private void handleException(String uiMsg, Exception exc) {
	        errorMsgHandler.showErrorMsg(uiMsg); //Prints for User
	        
	        System.out.println("\nTo Devs:");
	        exc.printStackTrace(); //Prints for Devs
	        System.out.println("-----------------------------------------------------------");
	    }
}
