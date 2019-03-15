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
		
		String moneyReturned;
//		User Story #1
//		The user is prompted asking for the price of the item.
		
		Scanner kb = new Scanner(System.in);

		System.out.print("Welcome to the Make Change Program!\nEnter the price of your item >> ");
		double productPrice = kb.nextDouble();
		if (productPrice > 20) {
			System.out.println("We do not sell items costing over $20.00.\nTerminating Program.");		
		}
//		User Story #2
//		The user is then prompted asking how much money was tendered by the customer.

		System.out.print("Enter the amount of money you are tendering >> ");
		double amountTendered = kb.nextDouble();

//		User Story #3
//		Display an appropriate message if the customer provided too little money or the exact amount.
		
		if (amountTendered < productPrice ) {
			System.out.println("Sorry, you've not provided enough to cover the cost of your item.\nTerminating program.");
		}
		else if (amountTendered < 0) {
			System.out.println("You've entered an invalide tender ammount.\nTerminating Program.");
		}
		
//		User Story #4
//		If the amount tendered is more than the cost of the item, display the number of bills and 
//		coins that should be given to the customer.
		
		else {
			double changeReturned = amountTendered - productPrice;
 
			if (changeReturned % 10 == 0) {
				double quantity10s = changeReturned / 10;
				if (quantity10s - (int)quantity10s == 0) {
					moneyReturned = "" + quantity10s;
					System.out.println("changeReturned twenties mod int, no coin" + quantity10s);
				}
				else if (quantity10s > 1) {
					moneyReturned = "" + quantity10s;
				System.out.println("changed returned more than 1 twenty" + quantity10s);
				}
			}
		}
	}

}
