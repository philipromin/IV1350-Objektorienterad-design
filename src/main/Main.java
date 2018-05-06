package main;

import controller.Controller;
import view.View;

public class Main {
	
	public static void main (String[] args) {
		
		Controller contr = new Controller ();
		View view = new View(contr);
			
		view.saleSimulation();	
	}
}
