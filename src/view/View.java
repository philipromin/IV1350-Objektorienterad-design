package view;

import controller.Controller;

/**
 * This program has no view, instead, this class is a
 * placeholder for the entire view.
 */

public class View {
	private Controller contr;
		/**		 
		 * @param contr The controller that is used for all operations.
		 */
		public View(Controller contr) {
			
			this.contr = contr;
			
		}
		
		/**
		 * Simulates user input that generates calls to all system operations.
		 */
		public void saleSimulation () {
			System.out.println("STARTS A NEW SALE:\n");
			contr.startSale();
			
			System.out.println("REGISTER ITEMS:\n");
			System.out.println(contr.enterItem(3));
			System.out.println(contr.enterItem(1));
			System.out.println(contr.enterItem(4));
			
			System.out.println("CASHIER INDICATES THAT ALL ITEMS ARE REGISTERED:\n");
			System.out.println(contr.endSale());
			
			System.out.println("CUSTOMER PAYS 900\n");
			System.out.println(contr.pay(900));
		}
}
