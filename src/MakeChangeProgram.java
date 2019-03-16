import java.util.Scanner;

public class MakeChangeProgram {

	public static void main(String[] args) {
//		Overview
//		In the cash register we will calculate the amount of change returned to a customer 
//		based on the purchase price and the amount tendered. We will also notify the attendant 
//		how many of each piece of currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed 
//		to make the change for the customer. Change should be provided using the largest bill and 
//		coin denominations as possible. Denominations that are not used should not be displayed.

//	    Limits: 
//		1. The item will never be over $20.00 
//		2. The customer will never tender more than $20.00

		String changeString = "";

//		User Story #1
//		The user is prompted asking for the price of the item.

		Scanner kb = new Scanner(System.in);

		System.out.print("Welcome to the Make Change Program!\nEnter the price of your item >> ");
		double productPrice = kb.nextDouble();
		
//		User Story #2
//		The user is then prompted asking how much money was tendered by the customer.	
		double amountTendered = 0;		
		double change = 0; 

//		User Story #3
//		Display an appropriate message if the customer provided too little money or the exact amount.
		if (productPrice >= 20) {
			System.out.println("Sorry, this program does not calculate items costing $20.00 or more.\nTerminating Program.");
		}
		else if (productPrice <= 0) {
			System.out.println("You've entered an invalid tender amount.\nTerminating Program.");
		}   
		else if (productPrice > 0 && productPrice < 20) { 		
			System.out.print("Enter the amount of money you are tendering >> ");
			amountTendered = kb.nextDouble();
		}
		
		change = amountTendered - productPrice;
		
		if (amountTendered != 0 && amountTendered == productPrice) {
				System.out.println("You've entered the exact amount. Thank you for using the Make Change Program.");
		}
		else if (amountTendered != 0 && amountTendered < productPrice) {
			System.out.println("Sorry, you've not provided enough to cover the cost of your item.\nTerminating program.");
		}
		
//		User Story #4
//		If the amount tendered is more than the cost of the item, display the number of bills and 
//		coins that should be given to the customer.

		// Determine number of 10s to be returned; determine appropriate string output
		if (amountTendered > 0) {
			if (change >= 20) {
				int num20s = (int) change / 20;
				if (num20s > 1) {
					changeString = changeString + num20s + " twenty dollar bills";
				} else {
					changeString = changeString + num20s + " twenty dollar bill";
				}
				change = change - num20s * 20;
			}
	
			// Determine number of 10s to be returned; determine appropriate string output
			if (change >= 10) {
				int num10s = (int) change / 10;
				if (num10s > 1) {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + num10s + " ten dollar bills";
				} else {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + num10s + " ten dollar bill";
				}
				change = change - num10s * 10;
			}
	
			// Determine number of 5s to be returned; determine appropriate string output
			if (change >= 5) {
				int num5s = (int) change / 5;
				change = change - num5s * 5;
				if (num5s > 1) {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + num5s + " five dollar bills";
				} else {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + num5s + " five dollar bill";
				}
			}
	
			// Determine number of 1s to be returned; determine appropriate string output
			if (change >= 1) {
				int num1s = (int) change / 1;
				change = change - num1s * 1;
				if (num1s > 1) {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + num1s + " one dollar bills";
				} else {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + num1s + " one dollar bill";
				}
			}
			// Determine number of 0.25s to be returned; determine appropriate string output
			if (change > 0 && change >= 0.25f) {
				double numQrts = change / 0.25f;
				change = change - (int) numQrts * 0.25f;
	
				// Round up if near the next denomination increment
				if (change >= 0.245f || change >= 0.095f) {
					numQrts += 0.001f;
					change += 0.001f;
				}
				if ((int) numQrts > 1) {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + (int) numQrts + " quarters";
				} else {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + (int) numQrts + " quarter";
				}
			}
			// Determine number of 0.10s to be returned; determine appropriate string output
			if (change > 0 && change >= 0.10f) {
				double numDimes = change / 0.10f;
				change = change - (int)numDimes * 0.10f;
	
				// Round up if near the next denomination increment
				if (change >= 0.095f || change >= 0.045f) {
					numDimes += 0.001f;
					change += 0.001f;
				}
				if ((int)numDimes > 1) {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + (int)numDimes + " dimes";
				} else {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + (int)numDimes + " dime";
				}
			}
			// Determine number of 0.05s to be returned; determine appropriate string output
			if (change > 0 && change >= 0.05f) {
				double numNickels = change / 0.05f;
				change = change - (int)numNickels * 0.05f;
	
				// Round up if near the next denomination increment
				if (change >= 0.045f || change >= 0.005f) {
					numNickels += 0.001f;
					change += 0.001f;
				}
				if ((int)numNickels > 1) {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + (int)numNickels + " nickels";
				} else {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + (int)numNickels + " nickel";
				}
			}
			// Determine number of 0.01s to be returned; determine appropriate string output
			if (change > 0.00f) {
				double numPen = change / 0.01f;
				change = change - (int)numPen * 0.01f;
				
				// Round up if near the next denomination increment
				if (change >= 0.005f) {
					numPen += 0.01f;
					change += 0.01f;
				} 
				if ((int)numPen > 1) {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + (int)numPen + " pennies";
				} else if ((int)numPen == 1) {
					if (changeString != "") {
						changeString = changeString + ", ";
					}
					changeString = changeString + (int)numPen + " penny";
				}
			}
			if (changeString != "") {
				System.out.println(changeString + ".");
			}
		}
		kb.close();
	}
// 		Review of requirements
//		User Story #1
//		The user is prompted asking for the price of the item.
//		Complete
//
//		User Story #2
//		The user is then prompted asking how much money was tendered by the customer.
//		Complete
//		
//		User Story #3
//		Display an appropriate message if the customer provided too little money or the exact amount.
//		Complete
//		
//		User Story #4
//		If the amount tendered is more than the cost of the item, display the number of 
// 		bills and coins that should be given to the customer.
//		Complete
//		
//		Test Cases:
//		Amount: .67, Tendered: .50, Result: Error message
//		Passes
//
//		Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
//		Passes
//	
//		Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
//		Passes
//	
//		Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 
//		1 one dollar bill, 4 pennies.
//		Passes
//	
//		Amount: any amount less than 20.00, Tendered: anything greater than amount: correct 
//		denominations for correct change.
//		Passes for test cases:
//			Amount: 12.33, Tendered: 15.00, Result: 2 one dollar bills, 2 quarters, 
//			1 dime, 1 nickel, 2 pennies.
//			Amount: 10.69, Tendered: 10.70, Result: 1 penny.
//			Amount: -21.00, Result: You've entered an invalid tender amount.
//			Terminating Program.
//			Amount: 19.99, Tendered: -20, Result: Sorry, you've not provided enough to 
//			cover the cost of your item.
//			Terminating program.
//			Amount: 0.01, Tendered: 333, Result: 16 twenty dollar bills, 1 ten dollar bill, 
//			2 one dollar bills, 3 quarters, 2 dimes, 4 pennies.
}
