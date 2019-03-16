import java.util.Scanner;

public class MakeChangeProgram {

	public static void main(String[] args) {
//		Overview
//		In the cash register we will calculate the amount of change returned to a customer 
//		based on the purchase price and the amount tendered. We will also notify the attendant 
//		how many of each piece of currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed 
//		to make the change for the customer. Change should be provided using the largest bill and 
//		coin denominations as possible. Denominations that are not used should not be displayed.

//	    Assumptions: 
//		1. The item will never be over $20.00 
//		2. The customer will never tender more than $20.00

		String moneyReturned = "";
//		User Story #1
//		The user is prompted asking for the price of the item.

		Scanner kb = new Scanner(System.in);

		System.out.print("Welcome to the Make Change Program!\nEnter the price of your item >> ");
		float productPrice = kb.nextFloat();
		if (productPrice >= 20) {
			System.out.println("Sorry, this program does not calculate items costing $20.00 or more.\nTerminating Program.");
		}
//		User Story #2
//		The user is then prompted asking how much money was tendered by the customer.

		System.out.print("Enter the amount of money you are tendering >> ");
		float amountTendered = kb.nextFloat();

//		User Story #3
//		Display an appropriate message if the customer provided too little money or the exact amount.
		float change = amountTendered - productPrice;
		//float change = chgToBeRtnd;

		if (amountTendered < productPrice) {
			System.out
					.println("Sorry, you've not provided enough to cover the cost of your item.\nTerminating program.");
		} else if (amountTendered < 0) {
			System.out.println("You've entered an invalide tender ammount.\nTerminating Program.");
		} else if (amountTendered == productPrice) {
			System.out.println("You've entered the exact amount. Thank you for using the Make Change Program.");
		}

//		User Story #4
//		If the amount tendered is more than the cost of the item, display the number of bills and 
//		coins that should be given to the customer.

		// Determine number of 10s to be returned; determine appropriate string output
		if (change >= 10) {
			int num10s = (int)change / 10;
			if (num10s > 1) {
				moneyReturned = moneyReturned + num10s + " ten dollar bills";
			} else {
				moneyReturned = moneyReturned + num10s + " ten dollar bill";
			}
			change = change - num10s * 10;
		}
		
		// Determine number of 5s to be returned; determine appropriate string output
		if (change >= 5) {
			int num5s = (int)change / 5;
			change = change - num5s * 5;
			if (num5s > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + num5s + " five dollar bills";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + num5s + " five dollar bill";
			}
		}
		
		// Determine number of 1s to be returned; determine appropriate string output
		if (change >= 1) {
			int num1s = (int)change / 1;
			change = change - num1s * 1;
			if (num1s > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + num1s + " one dollar bills";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + num1s + " one dollar bill";
			}
		}
		// Determine number of 0.25s to be returned; determine appropriate string output
		if (change > 0 && change >= 0.25f) {
			float numQrts = change / 0.25f;
			change = change - (int)numQrts * 0.25f;
			
			// Round up if near the next denomination increment
			if (change >= 0.245f) {
				numQrts += 0.001f;
			}
			if ((int)numQrts > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numQrts + " quarters";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numQrts + " quarter";
			}
		}
		// Determine number of 0.10s to be returned; determine appropriate string output
		if (change > 0 && change >= 0.10f) {
			float numDimes = change / 0.10f;
			change = change - (int)numDimes * 0.10f;
			
			// Round up if near the next denomination increment
			if (change >= 0.095f) {
				numDimes += 0.001f;
			}
			if ((int)numDimes > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numDimes + " dimes";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numDimes + " dime";
			}
		}
		// Determine number of 0.05s to be returned; determine appropriate string output
		if (change > 0 && change >= 0.05f) {
			float numNickels = change / 0.05f;
			change = change - (int)numNickels * 0.05f;
			
			// Round up if near the next denomination increment
			if (change >= 0.045f) {
				numNickels += 0.001f;
			}
			if ((int)numNickels > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numNickels + " nickels";
			} else {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numNickels + " nickel";
			}
		}
		// Determine number of 0.01s to be returned; determine appropriate string output
		if (change > 0) {
			float numPen = change / 0.01f;
			change = change - (int)numPen * 0.01f;
			
			// Round up if near the next denomination increment
			if (change >= 0.005f) {
				numPen += 0.001f;
			}
			else {
				numPen = 0;
			}
			if ((int)numPen > 1) {
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numPen + " pennies";
			} else if ((int)numPen == 1){
				if ( moneyReturned != "" ) {
					moneyReturned = moneyReturned + ", ";
				}
				moneyReturned = moneyReturned + (int)numPen + " penny";
			}
		}
		System.out.println(moneyReturned + ".");

	}

}
